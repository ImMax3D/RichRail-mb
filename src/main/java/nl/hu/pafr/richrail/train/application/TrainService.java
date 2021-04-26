package nl.hu.pafr.richrail.train.application;

import nl.hu.pafr.richrail.train.domain.RollingComponent;
import nl.hu.pafr.richrail.train.domain.Train;
import nl.hu.pafr.richrail.train.domain.TrainNotFoundException;
import nl.hu.pafr.richrail.train.domain.repository.TrainRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Collection;


// @Service, @Component gebruik je voor dependency injection

@Service
public class TrainService {
    private TrainRepository repository;

    public TrainService(TrainRepository repository) {
        this.repository = repository;
    }

    public Train createNewTrain(String name) {
        Train train = new Train(name);

        this.repository.save(train);

        return train;
    }

    public void deleteTrain(String name) {
        this.repository.delete(name);
    }

    public Train findTrainByName(String name) {
//        Optional<Train> optional = this.repository.findByName(name);
//
//        if (optional.isEmpty()) {
//            throw new TrainNotFoundException();
//        }
//
//        return optional.get();
        return this.repository
                .findByName(name)
                .orElseThrow(TrainNotFoundException::new);
    }

    public Collection<Train> listTrains() {
        return this.repository.findAll();
    }

    public Train addComponentToTrain(String name, RollingComponent component) {
        Train train = this.findTrainByName(name);
        train.add(component);

        return train;
    }

    public void removeComponentFromTrain(String name, int index) {
        Train train = this.findTrainByName(name);
        train.remove(index);
    }
}

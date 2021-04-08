package nl.hu.pafr.richrail.train.application;

import nl.hu.pafr.richrail.train.domain.RollingComponent;
import nl.hu.pafr.richrail.train.domain.Train;
import nl.hu.pafr.richrail.train.domain.TrainNotFoundException;
import nl.hu.pafr.richrail.train.domain.repository.TrainRepository;
import org.springframework.stereotype.Service;

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

    public void deleteTrain(String key) {

        this.repository.delete(key);
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

    public void addComponentToTrain(Long trainId, RollingComponent component) {

    }

    public void removeComponentFromTrain(Long trainId, int index) {

    }
}

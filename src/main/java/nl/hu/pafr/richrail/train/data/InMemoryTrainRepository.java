package nl.hu.pafr.richrail.train.data;

import nl.hu.pafr.richrail.train.domain.Train;
import nl.hu.pafr.richrail.train.domain.TrainNotFoundException;
import nl.hu.pafr.richrail.train.domain.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryTrainRepository implements TrainRepository {
    private Map<String, Train> trains = new HashMap<>();

    @Override
    public void save(Train train) {
        this.trains.put(train.getName(), train);
    }

    @Override
    public void delete(String name) {
        if (!this.trains.containsKey(name)) {
            throw new TrainNotFoundException();
        }

        this.trains.remove(name);
    }

    @Override
    public Optional<Train> findByName(String name) {
        Train train = this.trains.get(name);

        if (train == null) {
            return Optional.empty();
        }

        return Optional.of(train);
    }

    @Override
    public List<Train> findAll() {
        return new ArrayList<>(this.trains.values());
    }
}

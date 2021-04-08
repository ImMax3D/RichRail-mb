package nl.hu.pafr.richrail.train.data;

import nl.hu.pafr.richrail.train.domain.Train;
import nl.hu.pafr.richrail.train.domain.repository.TrainRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class InMemoryTrainRepository implements TrainRepository {
    private Map<String, Train> trains = new HashMap<>();

    @Override
    public void save(Train train) {
        this.trains.put(train.getName(), train);
    }

    @Override
    public void delete(String key) { this.trains.remove(key); }

    @Override
    public Optional<Train> findByName(String name) {
        Train train = this.trains.get(name);

        if (train == null) {
            return Optional.empty();
        }

        return Optional.of(train);
    }

    @Override
    public java.util.Collection<Train> findAll() {
        return this.trains.values();
    }


}

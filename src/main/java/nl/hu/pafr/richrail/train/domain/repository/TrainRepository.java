package nl.hu.pafr.richrail.train.domain.repository;

import nl.hu.pafr.richrail.train.domain.Train;

import java.util.Optional;

public interface TrainRepository {
    void save(Train train);
    void delete(String key);
    Optional<Train> findByName(String name);
    java.util.Collection<Train> findAll();
}

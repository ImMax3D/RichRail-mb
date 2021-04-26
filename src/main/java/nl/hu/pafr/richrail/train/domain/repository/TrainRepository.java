package nl.hu.pafr.richrail.train.domain.repository;

import nl.hu.pafr.richrail.train.domain.Train;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TrainRepository {
    void save(Train train);
    void delete(String name);
    Optional<Train> findByName(String name);
    List<Train> findAll();
}

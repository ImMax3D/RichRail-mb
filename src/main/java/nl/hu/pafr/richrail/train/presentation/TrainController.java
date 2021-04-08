package nl.hu.pafr.richrail.train.presentation;

import nl.hu.pafr.richrail.train.application.TrainService;
import nl.hu.pafr.richrail.train.domain.Train;
import nl.hu.pafr.richrail.train.domain.TrainNotFoundException;
import nl.hu.pafr.richrail.train.presentation.dto.NewTrainRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class TrainController {
    private final TrainService service;

    public TrainController(TrainService service) {
        this.service = service;
    }

    @PostMapping("/trains")
    public Train newTrain(@Valid @RequestBody NewTrainRequest request) {
        return this.service.createNewTrain(request.name);
    }

    @GetMapping("/trains/{name}")
    public Train getTrain(@PathVariable String name) {
        try {
            return this.service.findTrainByName(name);
        } catch (TrainNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/trains/all")
    public Collection<Train> getTrains() {
        try {
            return this.service.listTrains();
        } catch (TrainNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete")
    public void deleteTrain(String key) {
        try {
            this.service.deleteTrain(key);
        } catch (TrainNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

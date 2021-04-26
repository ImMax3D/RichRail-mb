package nl.hu.pafr.richrail.train.presentation;

import nl.hu.pafr.richrail.train.application.TrainService;
import nl.hu.pafr.richrail.train.domain.*;
import nl.hu.pafr.richrail.train.presentation.dto.AddCartRequest;
import nl.hu.pafr.richrail.train.presentation.dto.AddLocomotiveRequest;
import nl.hu.pafr.richrail.train.presentation.dto.AddWagonRequest;
import nl.hu.pafr.richrail.train.presentation.dto.NewTrainRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/trains")
public class TrainController {
    private final TrainService service;

    public TrainController(TrainService service) {
        this.service = service;
    }

    @PostMapping
    public Train newTrain(@Valid @RequestBody NewTrainRequest request) {
        return this.service.createNewTrain(request.name);
    }

    @GetMapping("/all")
    public Collection<Train> getTrains() {
        return this.service.listTrains();
    }

    @PostMapping("/{name}/wagon")
    public Train addComponent(@PathVariable String name, @Valid @RequestBody AddWagonRequest request) {
        RollingComponent wagon = new Wagon(request.name, request.capacity);
        return this.service.addComponentToTrain(name, wagon);
    }

    @PostMapping("/{name}/cart")
    public Train addComponent(@PathVariable String name, @Valid @RequestBody AddCartRequest request) {
        RollingComponent cart = new Cart(request.name ,request.maxLoad);
        return this.service.addComponentToTrain(name, cart);
    }

    @PostMapping("/{name}/locomotive")
    public Train addComponent(@PathVariable String name, @Valid @RequestBody AddLocomotiveRequest request) {
        RollingComponent locomotive = new Locomotive(request.name, request.weight);
        return this.service.addComponentToTrain(name, locomotive);
    }

    @GetMapping("/{name}")
    public Train getTrain(@PathVariable String name) {
        return this.service.findTrainByName(name);
    }

    @DeleteMapping("/{name}")
    public void deleteTrain(@PathVariable String name) {
        this.service.deleteTrain(name);
    }

    @DeleteMapping("/{name}/component")
    public void removeComponentFromTrain(@PathVariable String name, @Valid @RequestBody int index) {
        this.service.removeComponentFromTrain(name, index);
    }

//    private Train addComponentToTrain(@PathVariable String name, RollingComponent cart) {
//        try {
//            return this.service.addComponentToTrain(name, cart);
//        } catch (TrainNotFoundException exception) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }
}

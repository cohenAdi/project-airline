package airline.system.controllers;


import airline.system.dataToTransfer.DistanceDto;
import airline.system.domain.Destination;
import airline.system.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService)
    {
        this.destinationService = destinationService;
    }

    @PostMapping
    public ResponseEntity<DistanceDto> addDestination(@RequestBody final DistanceDto distanceDto)
    {
        Destination destination = destinationService.addDestination(Destination.from(distanceDto));
        return new ResponseEntity<>(DistanceDto.from(destination), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<DistanceDto> removeDestination(@PathVariable final Long id)
    {
        Destination destination = destinationService.deleteDestination(id);
        return new ResponseEntity<>(DistanceDto.from(destination), HttpStatus.OK);
    }











}

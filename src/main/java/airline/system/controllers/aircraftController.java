package airline.system.controllers;
import airline.system.dataToTransfer.AircraftDto;
import airline.system.domain.Aircraft;
import airline.system.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/aircrafts")
public class aircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public aircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }


    @PostMapping
    public ResponseEntity<AircraftDto> addAircraft(@RequestBody final AircraftDto aircraftDto)
    {
        Aircraft aircraft = aircraftService.addAircraft(Aircraft.from(aircraftDto));
        return new ResponseEntity<>(AircraftDto.from(aircraft), HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<AircraftDto>> getAircrafts()
//    {
//        List<Aircraft> aircrafts = aircraftService.getAircraftsList();
//        List<AircraftDto> aircraftDtos = aircrafts.stream().map(AircraftDto::from).collect(Collectors.toList());
//        return new ResponseEntity<>(aircraftDtos, HttpStatus.OK);
//    }


    @GetMapping(value = "{id}")
    public ResponseEntity<AircraftDto> getAircraft(@PathVariable final Long id)
    {
        Aircraft aircraft = aircraftService.getAircraft(id);
        return new ResponseEntity<>(AircraftDto.from(aircraft) , HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<AircraftDto> RemoveAircraft(@PathVariable final Long id)
    {
        Aircraft aircraft = aircraftService.deleteAircraft(id);
        return new ResponseEntity<>(AircraftDto.from(aircraft) , HttpStatus.OK);
    }

    @PutMapping(value = "{id}" )
    public ResponseEntity<AircraftDto> editAircraft(@PathVariable final Long id , @RequestBody final AircraftDto aircraftDto)
    {
        Aircraft editedAircraft = aircraftService.editAircraft(id, Aircraft.from(aircraftDto));
        return new ResponseEntity<>(AircraftDto.from(editedAircraft) , HttpStatus.OK);

    }




}

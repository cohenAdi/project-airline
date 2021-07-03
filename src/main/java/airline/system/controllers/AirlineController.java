package airline.system.controllers;



import airline.system.dataToTransfer.AirlineDto;
import airline.system.domain.Airline;
import airline.system.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    @Autowired

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping
    public ResponseEntity<AirlineDto> addAirline(@RequestBody final AirlineDto airlineDto)
    {
        Airline airline = airlineService.addAirline(Airline.from(airlineDto));
        return new ResponseEntity<>(AirlineDto.from(airline),HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AirlineDto> getAirline(@PathVariable final Long id)
    {
        Airline airline = airlineService.getAirline(id);
        return new ResponseEntity<>(AirlineDto.from(airline) , HttpStatus.OK);
    }


    @PostMapping(value = "{airlineId}/Aircrafts/{aircraftId}/add ")
    public ResponseEntity<AirlineDto> addAircraft(@PathVariable final Long airlineId,
                                                        @PathVariable final  Long aircraftId)
    {
       Airline airline = airlineService.addAirCraft(airlineId,aircraftId);
        return new ResponseEntity<>(AirlineDto.from(airline),HttpStatus.OK);
    }

    @PostMapping(value = "{airlineId}/Aircrafts/{aircraftId}/buy_sell ")
    public ResponseEntity<AirlineDto> buyAnAircraft(@PathVariable final Long airlineIdSell,
                                                  @PathVariable final  Long aircraftIdSell,
                                                    @PathVariable final Long airlineIdBuy
                                                    )
    {
        Airline airline = airlineService.addAirCraft(airlineIdBuy,aircraftIdSell);
        airlineService.removeAirCraft(airlineIdSell,aircraftIdSell);
        return new ResponseEntity<>(AirlineDto.from(airline),HttpStatus.OK);
    }




















}

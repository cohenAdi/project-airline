package airline.system.controllers;


import airline.system.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    @Autowired

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }




}

package airline.system.service;


import airline.system.domain.Aircraft;
import airline.system.domain.Airline;
import airline.system.exception.AirlineNotFound;
import airline.system.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AirlineService {

    private final AirlineRepository airlineRepository;
    private final AircraftService aircraftService;

    @Autowired
    public AirlineService(AirlineRepository airlineRepository, AircraftService aircraftService) {
        this.airlineRepository = airlineRepository;
        this.aircraftService = aircraftService;
    }

    public Airline getAirline(Long id)
    {
        return airlineRepository.findById(id).orElseThrow(()-> new AirlineNotFound(id));
    }

    public List<Airline> getListOfAirlines()
    {
        return StreamSupport.stream(airlineRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    public Airline addAirline(Airline airline)
    {
        return airlineRepository.save(airline);
    }

//    public Airline deleteAirline(Long id)
//    {
//        Airline airline= getAirline(id);
//        airlineRepository.delete(airline);
//        return airline;
//    }

    public Airline addAirCraft(Long airlineId,Long aircraftId)
    {
        Airline airline = getAirline(airlineId);
        Aircraft aircraft =aircraftService.getAircraft(aircraftId);
        airline.addAircraft(aircraft);
        return airline;
    }
    public Airline removeAirCraft(Long airlineId,Long aircraftId)
    {
        Airline airline = getAirline(airlineId);
        Aircraft aircraft =aircraftService.getAircraft(aircraftId);
        airline.removeAircraft(aircraft);
        return airline;
    }














}

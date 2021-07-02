package airline.system.service;


import airline.system.domain.Aircraft;
import airline.system.exception.AircraftNoFound;
import airline.system.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }


    public Aircraft addAircraft(Aircraft aircraft)
    {
        return aircraftRepository.save(aircraft);
    }

    public List<Aircraft> getAircraftsList()
    {
        return StreamSupport.stream( aircraftRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    public Aircraft getAircraft(Long id)
    {
        return aircraftRepository.findById(id).orElseThrow(()->new AircraftNoFound(id)); /** validation if really exist **/

    }

    public Aircraft deleteAircraft(Long id)
    {
        Aircraft aircraft = getAircraft(id);
        aircraftRepository.delete(aircraft);
        return aircraft;
    }

    public Aircraft editAircraft(Long id,Aircraft aircraft)
    {
        Aircraft aircraftToEdit  = getAircraft(id);

        aircraftToEdit.setMonthInUse(aircraft.getMonthInUse());
        return aircraftToEdit;


    }

}

package airline.system.service;


import airline.system.domain.Destination;
import airline.system.exception.DestinationNotFound;
import airline.system.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    @Autowired
    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public Destination addDestination(Destination destination)
    {
        return destinationRepository.save(destination);
    }

    public Destination getDestination(Long id)
    {
        return destinationRepository.findById(id).orElseThrow(()->new DestinationNotFound((id))); /** validation if really exist **/
    }

    public Destination deleteDestination(Long id)
    {
        Destination destination =getDestination(id);
        destinationRepository.delete(destination);
        return destination;
    }

    public Destination editDestination(Long id,Destination destination)
    {
        Destination destination1  = getDestination(id);
        destination1.setLatitude(destination.getLatitude());

        return destination1;

    }









}

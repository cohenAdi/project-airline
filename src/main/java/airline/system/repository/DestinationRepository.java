package airline.system.repository;

import airline.system.domain.Airline;
import airline.system.domain.Destination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, Long> {
}

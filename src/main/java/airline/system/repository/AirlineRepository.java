package airline.system.repository;


import airline.system.domain.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirlineRepository extends CrudRepository<Airline, Long> {
}

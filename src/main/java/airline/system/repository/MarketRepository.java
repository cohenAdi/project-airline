package airline.system.repository;

import airline.system.domain.Market;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarketRepository extends CrudRepository<Market,Long> {
}

package airline.system.service;

import airline.system.repository.AirlineRepository;
import airline.system.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    private MarketRepository marketRepository;
    @Autowired
    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

}

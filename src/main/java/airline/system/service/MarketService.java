package airline.system.service;

import airline.system.domain.Airline;
import airline.system.domain.Market;
import airline.system.exception.MarketNoFound;
import airline.system.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private MarketRepository marketRepository;
    private final AirlineService airlineService;

    @Autowired
    public MarketService(MarketRepository marketRepository, AirlineService airlineService) {


        this.marketRepository = marketRepository;
        this.airlineService = airlineService;
    }

    public Market addMarket(Market market)
    {
        return marketRepository.save(market);
    }

    public Market getMarket(Long id)
    {
        return marketRepository.findById(id).orElseThrow(()-> new MarketNoFound(id));
    }

    public Market addNewAirline(Long marketId, Long airlineId)
    {
        Market market = Market.getInstance();
        Airline airline = airlineService.getAirline(airlineId);
        market.addAirline(airline);
        return market;
    }

//    public Market getListOfAirlines(Long marketId)
//    {
//        Market market = getMarket(marketId);
//        Airline airline
//
//    }


    public Market removeAirline(Long marketId, Long airlineId)
    {
        Market market = getMarket(marketId);
        Airline airline = airlineService.getAirline(airlineId);
        market.removeAirline(airline);
        return market;
    }

    public List<String> getCurrBudgetAirlines()
    {
        Market market = Market.getInstance();

        return market.AirlinesCurrBadget();
    }





}

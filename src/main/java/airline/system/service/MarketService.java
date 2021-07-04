package airline.system.service;

import airline.system.domain.Airline;
import airline.system.domain.Destination;
import airline.system.domain.Market;
import airline.system.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private MarketRepository marketRepository;
    private final AirlineService airlineService;
    private final DestinationService destinationService;

    Market market;

    @Autowired
    public MarketService(MarketRepository marketRepository, AirlineService airlineService, DestinationService destinationService) {


        this.marketRepository = marketRepository;
        this.airlineService = airlineService;
        this.destinationService = destinationService;
        this.market = Market.getInstance();
    }

    public Market addMarket(Market market)
    {
        return marketRepository.save(market);
    }


    public Market addDestination(Long destinationId)
    {
        market = Market.getInstance();
        Destination destination =destinationService.getDestination(destinationId);
        market.addDestinationToList(destination);
        return market;
    }

    public Market addNewAirline( Long airlineId)
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
        Airline airline = airlineService.getAirline(airlineId);
        market.removeAirline(airline);
        return market;
    }

    public List<String> getCurrBudgetAirlines()
    {
        return market.AirlinesCurrBadget();
    }

    public List<Destination> getlistOfdests()
    {
        return market.getDestinationList();
    }


}

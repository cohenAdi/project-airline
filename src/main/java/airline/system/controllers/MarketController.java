package airline.system.controllers;



import airline.system.dataToTransfer.DistanceDto;
import airline.system.dataToTransfer.MarketDto;
import airline.system.domain.Destination;
import airline.system.domain.Market;
import airline.system.service.DestinationService;
import airline.system.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/market")
public class MarketController {


    private final MarketService marketService;



    @Autowired

    public MarketController(MarketService marketService, DestinationService destinationService) {
        this.marketService = marketService;

    }


    @PostMapping
    public ResponseEntity<MarketDto> addMarket(@RequestBody final MarketDto marketDto)
    {
        Market market = marketService.addMarket(Market.from(marketDto));
        return new ResponseEntity<>(MarketDto.from(market), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<String>> getAirlineBudg()
    {
        List<String> airlines = marketService.getCurrBudgetAirlines();
        return new ResponseEntity<>(airlines, HttpStatus.OK);
    }

    @PostMapping(value = "{marketId}/destinations/{destinationId}/add")
    public ResponseEntity<MarketDto> addDestination(@PathVariable final Long destinationId)
    {
        Market market = marketService.addDestination(destinationId);
        return new ResponseEntity<>(MarketDto.from(market),HttpStatus.OK);
    }
    @PostMapping(value = "{marketId}/airline/{airlineId}/add ")
    public ResponseEntity<MarketDto> addAirlineToMarket(@PathVariable final Long airlineId)
    {
        Market market = marketService.addNewAirline(airlineId);
        return new ResponseEntity<>(MarketDto.from(market),HttpStatus.OK);
    }

//    @GetMapping
//    public ResponseEntity<List<MarketDto>> getMarket()
//    {
//        Market market = Market.getInstance();
//        market =marketService.get
//    }

//    @GetMapping
//    public ResponseEntity<List<Destination>> getDestinations()
//    {
//        List<Destination> dest = marketService.getlistOfdests();
//        List<DistanceDto> disDto = dest.stream().map(DistanceDto::from).collect(Collectors.toList());
//        return new ResponseEntity(disDto,HttpStatus.OK);
//    }


//    @GetMapping
//    public ResponseEntity<MarketDto> getDestinationList(@PathVariable final Long airlineId)
//    {
//        HashMap<String,Double> map = marketService.getlistOfdests(airlineId);
//        return new ResponseEntity(map,HttpStatus.OK);
//    }




    @DeleteMapping(value = "{marketId}/Airlines/{airlineId}/remove ")
    public ResponseEntity<MarketDto> removeAirlineToMarket(@PathVariable final Long marketId,
                                                        @PathVariable final  Long airlineId)
    {
        Market market = marketService.removeAirline(airlineId);
        return new ResponseEntity<>(MarketDto.from(market),HttpStatus.OK);
    }

























}

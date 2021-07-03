package airline.system.controllers;


import airline.system.dataToTransfer.AircraftDto;
import airline.system.dataToTransfer.AirlineDto;
import airline.system.dataToTransfer.MarketDto;
import airline.system.domain.Aircraft;
import airline.system.domain.Market;
import airline.system.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/market")
public class MarketController {


    private final MarketService marketService;
    private final MarketService marketService;

    @Autowired

    public MarketController(MarketService marketService) {
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

    @GetMapping(value = "{id}")
    public ResponseEntity<MarketDto> getMarket(@PathVariable final Long id)
    {
        Market market = marketService.getMarket(id);
        return new ResponseEntity<>(MarketDto.from(market) , HttpStatus.OK);
    }

//    @GetMapping(value = "{id}")
//    public ResponseEntity<MarketDto>removeMarket(@PathVariable final Long id)
//    {
//        Market market = marketService.removeAirline(id);
//        return new ResponseEntity<>(MarketDto.from(market) , HttpStatus.OK);
//    }

    @PostMapping(value = "{marketId}/Airlines/{airlineId}/add ")
    public ResponseEntity<MarketDto> addAirlineToMarket(@PathVariable final Long marketId,
                                                        @PathVariable final  Long airlineId)
    {
        Market market = marketService.addNewAirline(marketId,airlineId);
        return new ResponseEntity<>(MarketDto.from(market),HttpStatus.OK);
    }

    @DeleteMapping(value = "{marketId}/Airlines/{airlineId}/remove ")
    public ResponseEntity<MarketDto> removeAirlineToMarket(@PathVariable final Long marketId,
                                                        @PathVariable final  Long airlineId)
    {
        Market market = marketService.removeAirline(marketId,airlineId);
        return new ResponseEntity<>(MarketDto.from(market),HttpStatus.OK);
    }

























}

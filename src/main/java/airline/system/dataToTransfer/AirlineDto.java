package airline.system.dataToTransfer;


import airline.system.domain.Aircraft;
import airline.system.domain.Airline;
import airline.system.domain.Destination;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class AirlineDto {

    private Long id;
    private String airlineName;
    private int initialBudget;
    private int currBudget;

    private Destination homeBase;
    private HashMap<String, Double> destFromHb;
    private List<Aircraft> aircraftList;

    public static AirlineDto from(Airline airline)
    {
        AirlineDto airlineDto = new AirlineDto();
        airlineDto.setAirlineName(airline.getAirlineName());
        airlineDto.setCurrBudget(airline.getCurrBudget());
        airlineDto.setInitialBudget(airline.getInitialBudget());
        airlineDto.setHomeBase(airline.getHomeBase());
        airlineDto.setAircraftList(airline.getAircreaft_list());

        return airlineDto;
    }





}

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
    private Double lon,lan;
    private String baseName;


    public static AirlineDto from(Airline airline)
    {
        AirlineDto airlineDto = new AirlineDto();
        airlineDto.setId(airline.getId());
        airlineDto.setAirlineName(airline.getAirlineName());
        airlineDto.setInitialBudget(airline.getInitialBudget());
        airlineDto.setLon(airline.getLongitude());
        airlineDto.setLan(airline.getAltitude());
        airlineDto.setBaseName(airline.getBaseName());


        return airlineDto;
    }





}

package airline.system.dataToTransfer;


import airline.system.domain.Aircraft;
import lombok.Data;

@Data
public class AircraftDto {

    private Long id;
    private String aircraftName;
    private int maxDis;
    private int price;
    private int monthInUse;
    private String serialNumber;

    public static AircraftDto from (Aircraft aircraft)
    {
        AircraftDto aircraftDto = new AircraftDto();
        aircraftDto.setId(aircraft.getId());
        aircraftDto.setAircraftName(aircraft.getAircraftName());
        aircraftDto.setMaxDis(aircraft.getMaxDis());
        aircraftDto.setPrice(aircraft.getPrice());
        aircraftDto.setMonthInUse(aircraft.getMonthInUse());
        aircraftDto.setSerialNumber(aircraft.getSerialNumber());

        return aircraftDto;
    }




}

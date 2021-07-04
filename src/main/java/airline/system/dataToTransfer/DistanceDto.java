package airline.system.dataToTransfer;

import airline.system.domain.Destination;
import airline.system.domain.TypeDestination;
import lombok.Data;

@Data
public class DistanceDto {

    private Long id;
    private Double latitude,longtitude;
    private String name;
    private TypeDestination type;

    public static DistanceDto from(Destination destination)
    {

        DistanceDto distanceDto = new DistanceDto();
        distanceDto.setId(destination.getId());
        distanceDto.setLatitude(destination.getLatitude());
        distanceDto.setLongtitude(destination.getLongtitude());
        distanceDto.setName(destination.getName());
        distanceDto.setType(destination.getType());
        return distanceDto;

    }






}





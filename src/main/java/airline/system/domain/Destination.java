package airline.system.domain;


import airline.system.dataToTransfer.AircraftDto;
import airline.system.dataToTransfer.DistanceDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "destination")
public class Destination {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double latitude,longtitude;
    private String name;
    private TypeDestination type;

    @ManyToOne
    @JoinColumn(name="market_id")
    private Market market = Market.getInstance();


    @OneToOne
    @JoinColumn(name="airline_id")
    private Airline airline;

    public Destination(Double latitude, Double longtitude, String name ,TypeDestination type) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.name = name;
        this.type = type;
    }

    public Destination() { }

    public static Destination from(DistanceDto distanceDto)
    {
        Destination destination =new Destination(distanceDto.getLatitude(),
                distanceDto.getLongtitude(),
                distanceDto.getName() ,distanceDto.getType());
        return  destination;
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeDestination getType() {
        return type;
    }

    public void setType(TypeDestination type) {
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }




}

package airline.system.domain;

import airline.system.dataToTransfer.AirlineDto;
import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String airlineName;
    private int initialBudget;
    private int currBudget;
    private Double altitude,longitude;
    private String baseName;


    @OneToOne
    private Destination homeBase;


    public Airline(String airlineName, int initialBudget, Double altitude, Double longitude, String baseName) {
        this.baseName =baseName;
        this.airlineName = airlineName;
        this.altitude =altitude;
        this.longitude=longitude;
        this.initialBudget = initialBudget;
        this.currBudget = initialBudget;
    }


    public Airline() { }



    @OneToMany(
            mappedBy = "airline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private final List<Aircraft> aircreaft_list = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "market_id")
    Market market = Market.getInstance();


    public int getCurrBudget() {
        return currBudget;
    }

    public void setCurrBudget(int currBudget) {
        this.currBudget = currBudget;
    }

    public Long getId() {
        return id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public int getInitialBudget() {
        return initialBudget;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void setInitialBudget(int initialBudget) {
        this.initialBudget = initialBudget;
    }


    public List<Aircraft> getAircreaft_list() {
        return aircreaft_list;
    }

    public Double getAltitude() {
        return altitude;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public static Airline from(AirlineDto airlineDto)
    {
        Airline airline = new Airline();
        airline.setId(airlineDto.getId());
        airline.setAirlineName(airlineDto.getAirlineName());
        airline.setInitialBudget(airlineDto.getInitialBudget());
        airline.setAltitude(airlineDto.getLan());
        airline.setLongitude(airlineDto.getLon());
        airline.setBaseName(airlineDto.getBaseName());
        airline.setId(airlineDto.getId());
        return airline;
    }

    public void removeAircraft(Aircraft aircraft)
    {
        if(aircraft!=null)
        {
            this.setCurrBudget((int) (currBudget+(aircraft.getPrice()*(1-aircraft.getMonthInUse()*0.02))));
            aircraft.setPrice((int) (aircraft.getPrice()*(1-aircraft.getMonthInUse()*0.02)));
            aircreaft_list.remove(aircraft);
        }
    }

    public void addAircraft(Aircraft aircraft)
    {
        if(aircraft!=null)
        {
            this.setCurrBudget((int) (currBudget-(aircraft.getPrice()*(1-aircraft.getMonthInUse()*0.02))));
            aircreaft_list.add(aircraft);
        }
    }




}

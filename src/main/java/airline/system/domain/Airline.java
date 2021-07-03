package airline.system.domain;

import airline.system.dataToTransfer.AirlineDto;
import airline.system.dataToTransfer.MarketDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Entity
@Table(name = "airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String airlineName;
    private int initialBudget;
    private int currBudget;


    public Airline(String airlineName, int initialBudget, int altitude, int longitude, String baseName) {
        this.airlineName = airlineName;
        this.homeBase = new Destination(altitude,longitude,baseName,TypeDestination.HOMEBASE);
        this.initialBudget = initialBudget;
        this.currBudget = initialBudget;
    }


    public Airline() { }


    @OneToOne
    private Destination homeBase;

    @OneToMany(
            mappedBy = "airline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private final List<Aircraft> aircreaft_list = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "market_id")
    Market market = Market.getInstance();

//    public HashMap<String,Double> DestinationsFromHomeBase(Airline airline)
//    {
//        Destination homeBase = airline.getHomeBase();
//
//    }




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

    public Destination getHomeBase() {
        return homeBase;
    }

    public void setHomeBase(Destination homeBase) {
        this.homeBase = homeBase;
    }

    public List<Aircraft> getAircreaft_list() {
        return aircreaft_list;
    }

    public Market getMarket() {
        return market;
    }
    public static Airline from(AirlineDto airlineDto)
    {
        Airline airline = new Airline();
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

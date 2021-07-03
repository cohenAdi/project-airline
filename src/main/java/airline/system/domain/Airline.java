package airline.system.domain;


import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.omg.CORBA.INTERNAL;

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


    @OneToOne
    private Destination homeBase;


    @OneToMany(

            mappedBy = "airline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private final List<Destination> destinationList = new ArrayList<>();
    @OneToMany(

            mappedBy = "airline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private final List<Aircraft> aircreaft_list = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;



    public Airline(String airlineName, int initialBudget, int altitude, int longitude, String baseName) {
        this.airlineName = airlineName;
        this.homeBase = new Destination(altitude,longitude,baseName,TypeDestination.HOMEBASE);
        this.initialBudget = initialBudget;


    }


    public Airline() {

    }

    public void addAircraft(Aircraft aircraft)
    {
        if(aircraft!=null)
        {
            aircreaft_list.add(aircraft);
        }
    }
    public void removeAircraft(Aircraft aircraft)
    {
        if(aircraft!=null)
        {
            aircreaft_list.remove(aircraft);
        }
    }

    public void addDestination(Destination destination)
    {
        if(destination!=null)
        {
            destinationList.add(destination);
        }
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

    public List<Destination> getDestinationList() {
        return destinationList;
    }

    public List<Aircraft> getAircreaft_list() {
        return aircreaft_list;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}

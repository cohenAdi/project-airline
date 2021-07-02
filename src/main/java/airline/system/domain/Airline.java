package airline.system.domain;


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
    private int initialBudget,altitude ,longitude;
    @OneToOne
    private Destination baseName;

    @OneToMany(

            mappedBy = "airline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Destination> destinationList = new ArrayList<>();

    @OneToMany(

            mappedBy = "airline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Aircraft> aircreaft_list = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    public Airline(String airlineName, int initialBudget, int altitude, int longitude, String baseName) {
        this.airlineName = airlineName;
        this.initialBudget = initialBudget;
        this.altitude = altitude;
        this.longitude = longitude;
    }


    public Airline() {

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

    public int getAltitude() {
        return altitude;
    }

    public int getLongitude() {
        return longitude;
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

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }


}

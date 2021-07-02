package airline.system.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "market")
public class Market {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(
            mappedBy = "market",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )


    private List<Airline> airlineList = new ArrayList<>();

    public Market() {
    }

    public void addAirline(Airline airline)
    {
        if(airline!=null){
            airlineList.add(airline);
        }

    }
    public void removeAirline(Airline airline)
    {
        airlineList.remove(airline);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Airline> getAirlineList() {
        return airlineList;
    }

    public void setAirlineList(List<Airline> airlineList) {
        this.airlineList = airlineList;
    }



}

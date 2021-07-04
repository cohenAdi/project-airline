package airline.system.domain;

import airline.system.dataToTransfer.MarketDto;
import org.apache.lucene.spatial.util.GeoDistanceUtils;
import sun.security.krb5.internal.crypto.Des;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "market")
public class Market {

    private static  final Market market = new Market(); /** singeltone class**/
    protected Market() {}
    public static Market getInstance()
    {
        return market;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(
            mappedBy = "market",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Airline> airlineList = new ArrayList<>();

    @OneToMany(
            mappedBy = "market",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Destination> destinationList = new ArrayList<>();

    public void addAirline(Airline airline)
    {
        if(airline!=null){
            airlineList.add(airline);
        }
    }
    public static Market from(MarketDto marketDto)
    {
        Market market = getInstance();
        market.setId(marketDto.getId());
        return market;
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
//    public void addDestination(Destination destination)
//    {
//        if(destination!=null)
//        {
//            destinationList.add(destination);
//        }
//    }
//    public List<Destination> getDestinationList() {
//        return destinationList;
//    }


    public void addDestinationToList(Destination destination) {
        if(destination!=null)
        {
            destinationList.add(destination);
        }


    }
    public List<Destination> getDestinationList() {
        return destinationList;
    }

    public List<String> AirlinesCurrBadget()
    {
        List<String> budgetList = new ArrayList<>();
        if(airlineList!=null){
            for(Airline i :airlineList)
            {
                budgetList.add("Name: "+ i.getAirlineName() +" Budget: "+i.getCurrBudget());
            }
        }
        return budgetList;
    }

//        public HashMap<String,Double> DestinationsFromHomeBase(Airline airline)
//    {
//        HashMap<String,Double> dest = new HashMap<>();
//        Destination homeBase = airline.getHomeBase();
//        for(Destination i : destinationList)
//        {
//            dest.put(i.getName() ,  GeoDistanceUtils.haversin(homeBase.getLatitude(),homeBase.getLongtitude() , i.getLatitude(),i.getLongtitude()));
//
//        }
//        return dest;
//    }






}

package airline.system.domain;


import javax.persistence.*;

@Entity
public class Destination {


    @Id
    private Long id;
    private int latitude,longtitude;
    private String name;
    private TypeDestination type;

    @ManyToOne
    private Airline airline;

    public Destination(int latitude, int longtitude, String name ,TypeDestination type) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.name = name;
        this.type = type;
    }

    public Destination()
    {

    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(int longtitude) {
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

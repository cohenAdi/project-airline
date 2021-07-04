package airline.system.domain;

import airline.system.dataToTransfer.AircraftDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String aircraftName;

    private int maxDis;
    private int price;
    private int monthInUse;


    @ManyToOne
    @JoinColumn(name="airline_id")
    private Airline airline;


    public Aircraft(String aircraftName, int maxDis, int price, int monthInUse) {
        this.aircraftName = aircraftName;
        this.maxDis = maxDis;
        this.price = price;
        this.monthInUse = monthInUse;
    }

    public Aircraft() { }


    public static Aircraft from(AircraftDto aircraftDto)
    {
        return new Aircraft(aircraftDto.getAircraftName(),
                aircraftDto.getMaxDis(),
                aircraftDto.getPrice(),
                aircraftDto.getMonthInUse());

    }



    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    public int getMaxDis() {
        return maxDis;
    }

    public void setMaxDis(int maxDis) {
        this.maxDis = maxDis;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMonthInUse() {
        return monthInUse;
    }

    public void setMonthInUse(int monthInUse) {
        this.monthInUse = monthInUse;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}

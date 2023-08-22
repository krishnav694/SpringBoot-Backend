package in.co.srdt.BMS.BMS.entities;

import javax.persistence.*;

/* @Entity
@Table(name = "bus_details")*/
public class AddBusEntity {
    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)*/
    private Long busId;
    private String busName;
    private String from;
    private String destination;
    private String boardingTime;
    private String departureTime;
    private String arrivalTime;
    private Double fare;
    private Integer capacity;
    private String busNumber;
    private Boolean vaccinationStatus;

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public Boolean getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void setVaccinationStatus(Boolean vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
    }

    @Override
    public String toString() {
        return "AddBusEntity{" +
                "busId=" + busId +
                ", busName='" + busName + '\'' +
                ", from='" + from + '\'' +
                ", destination='" + destination + '\'' +
                ", boardingTime='" + boardingTime + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", fare=" + fare +
                ", capacity=" + capacity +
                ", busNumber='" + busNumber + '\'' +
                ", vaccinationStatus=" + vaccinationStatus +
                '}';
    }
}

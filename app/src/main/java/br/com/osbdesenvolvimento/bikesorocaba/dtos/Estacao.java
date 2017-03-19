package br.com.osbdesenvolvimento.bikesorocaba.dtos;

public class Estacao {

    private Integer id;
    private Integer stationNumber;
    private String name;
    private Double googleMapX;
    private Double googleMapY;
    private String status;
    private String updatedAt;
    private Integer availableSlotsSize;
    private Integer unavailableSlotsSize;

    public Estacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(Integer stationNumber) {
        this.stationNumber = stationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGoogleMapX() {
        return googleMapX;
    }

    public void setGoogleMapX(Double googleMapX) {
        this.googleMapX = googleMapX;
    }

    public Double getGoogleMapY() {
        return googleMapY;
    }

    public void setGoogleMapY(Double googleMapY) {
        this.googleMapY = googleMapY;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getAvailableSlotsSize() {
        return availableSlotsSize;
    }

    public void setAvailableSlotsSize(Integer availableSlotsSize) {
        this.availableSlotsSize = availableSlotsSize;
    }

    public Integer getUnavailableSlotsSize() {
        return unavailableSlotsSize;
    }

    public void setUnavailableSlotsSize(Integer unavailableSlotsSize) {
        this.unavailableSlotsSize = unavailableSlotsSize;
    }

    @Override
    public String toString() {
        return "Estacao{" +
                "id=" + id +
                ", stationNumber=" + stationNumber +
                ", name='" + name + '\'' +
                ", googleMapX=" + googleMapX +
                ", googleMapY=" + googleMapY +
                ", status='" + status + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", availableSlotsSize=" + availableSlotsSize +
                ", unavailableSlotsSize=" + unavailableSlotsSize +
                '}';
    }

    public String toJsonString() {
        return "{" +
                "id:'" + id + '\'' +
                ", stationNumber:'" + stationNumber + '\'' +
                ", name:'" + name + '\'' +
                ", googleMapX:'" + googleMapX + '\'' +
                ", googleMapY:'" + googleMapY + '\'' +
                ", status:'" + status + '\'' +
                ", updatedAt:'" + updatedAt + '\'' +
                ", availableSlotsSize:'" + availableSlotsSize + '\'' +
                ", unavailableSlotsSize:'" + unavailableSlotsSize + '\'' +
                '}';
    }

}

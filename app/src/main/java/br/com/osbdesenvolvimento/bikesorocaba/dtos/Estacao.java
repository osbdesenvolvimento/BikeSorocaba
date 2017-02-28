package br.com.osbdesenvolvimento.bikesorocaba.dtos;

import java.util.ArrayList;
import java.util.List;

public class Estacao {

    private String address;
    private String createdAt;
    private String description;
    private Double googleMapX;
    private Double googleMapY;
    private String id;
    private String mapX;
    private String mapY;
    private String name;
    private String numberLeftSlots;
    private String numberRightSlots;
    private String password;
    private String stationNumber;
    private String status;
    private String totalBikes;
    private String typeStation;
    private String updatedAt;
    private String availableSlotsSize;
    private String unavailableSlotsSize;
    private String statusToHuman;
    private List<Bicicleta> bikes;

    public Estacao() {
        this.bikes = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMapX() {
        return mapX;
    }

    public void setMapX(String mapX) {
        this.mapX = mapX;
    }

    public String getMapY() {
        return mapY;
    }

    public void setMapY(String mapY) {
        this.mapY = mapY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberLeftSlots() {
        return numberLeftSlots;
    }

    public void setNumberLeftSlots(String numberLeftSlots) {
        this.numberLeftSlots = numberLeftSlots;
    }

    public String getNumberRightSlots() {
        return numberRightSlots;
    }

    public void setNumberRightSlots(String numberRightSlots) {
        this.numberRightSlots = numberRightSlots;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(String stationNumber) {
        this.stationNumber = stationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalBikes() {
        return totalBikes;
    }

    public void setTotalBikes(String totalBikes) {
        this.totalBikes = totalBikes;
    }

    public String getTypeStation() {
        return typeStation;
    }

    public void setTypeStation(String typeStation) {
        this.typeStation = typeStation;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAvailableSlotsSize() {
        return availableSlotsSize;
    }

    public void setAvailableSlotsSize(String availableSlotsSize) {
        this.availableSlotsSize = availableSlotsSize;
    }

    public String getUnavailableSlotsSize() {
        return unavailableSlotsSize;
    }

    public void setUnavailableSlotsSize(String unavailableSlotsSize) {
        this.unavailableSlotsSize = unavailableSlotsSize;
    }

    public String getStatusToHuman() {
        return statusToHuman;
    }

    public void setStatusToHuman(String statusToHuman) {
        this.statusToHuman = statusToHuman;
    }

    public List<Bicicleta> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bicicleta> bikes) {
        this.bikes = bikes;
    }


    @Override
    public String toString() {
        return "Estacao{" +
                "status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", description='" + description + '\'' +
                ", googleMapX='" + googleMapX + '\'' +
                ", googleMapY='" + googleMapY + '\'' +
                ", id='" + id + '\'' +
                ", mapX='" + mapX + '\'' +
                ", mapY='" + mapY + '\'' +
                ", name='" + name + '\'' +
                ", numberLeftSlots='" + numberLeftSlots + '\'' +
                ", numberRightSlots='" + numberRightSlots + '\'' +
                ", password='" + password + '\'' +
                ", stationNumber='" + stationNumber + '\'' +
                ", totalBikes='" + totalBikes + '\'' +
                ", typeStation='" + typeStation + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", availableSlotsSize='" + availableSlotsSize + '\'' +
                ", unavailableSlotsSize='" + unavailableSlotsSize + '\'' +
                ", statusToHuman='" + statusToHuman + '\'' +
                ", bikes=" + bikes +
                '}';
    }

    public String toJsonString() {
        return "{" +
                "status:'" + status + '\'' +
                ", address:'" + address + '\'' +
                ", createdAt:'" + createdAt + '\'' +
                ", description:'" + description + '\'' +
                ", id:'" + id + '\'' +
                ", name:'" + name + '\'' +
                ", numberLeftSlots:'" + numberLeftSlots + '\'' +
                ", numberRightSlots:'" + numberRightSlots + '\'' +
                ", stationNumber:'" + stationNumber + '\'' +
                ", totalBikes:'" + totalBikes + '\'' +
                ", typeStation:'" + typeStation + '\'' +
                ", updatedAt:'" + updatedAt + '\'' +
                ", availableSlotsSize:'" + availableSlotsSize + '\'' +
                ", unavailableSlotsSize:'" + unavailableSlotsSize + '\'' +
                ", statusToHuman:'" + statusToHuman + '\'' +
                '}';
    }
}

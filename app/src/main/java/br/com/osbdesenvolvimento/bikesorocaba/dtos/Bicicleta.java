package br.com.osbdesenvolvimento.bikesorocaba.dtos;

import java.util.Date;

import static android.R.attr.id;

public class Bicicleta {

    private String acquisitionDate;
    private String bikeHardId;
    private String createdAt;
    private String deletedAt;
    private String id;
    private String lastReceived;
    private String lastStationId;
    private String model;
    private String rfid;
    private String stationId;
    private String status;
    private String updatedAt;

    public Bicicleta() {
    }

    public String getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(String acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public String getBikeHardId() {
        return bikeHardId;
    }

    public void setBikeHardId(String bikeHardId) {
        this.bikeHardId = bikeHardId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastReceived() {
        return lastReceived;
    }

    public void setLastReceived(String lastReceived) {
        this.lastReceived = lastReceived;
    }

    public String getLastStationId() {
        return lastStationId;
    }

    public void setLastStationId(String lastStationId) {
        this.lastStationId = lastStationId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
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

    @Override
    public String toString() {
        return "Bicicleta{" +
                "acquisitionDate='" + acquisitionDate + '\'' +
                ", bikeHardId='" + bikeHardId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", deletedAt='" + deletedAt + '\'' +
                ", id='" + id + '\'' +
                ", lastReceived='" + lastReceived + '\'' +
                ", lastStationId='" + lastStationId + '\'' +
                ", model='" + model + '\'' +
                ", rfid='" + rfid + '\'' +
                ", stationId='" + stationId + '\'' +
                ", status='" + status + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}

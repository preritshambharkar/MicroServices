package com.car.service.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "vehicles")
public class Vehicles {

    @Id
    @Column(name = "vehicleId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long vehicleId;

    @Column(name = "year")
    private String year;

    @Column(name = "make")
    private String make;

    @Column(name = "modal")
    private String modal;

    @Column(name= "series")
    private String series;

    @Column(name = "exterior_color")
    private String exterior_color;

    @Column(name = "interior_color")
    private String interior_color;

    @Column(name = "mileage")
    private String mileage;

    @Column(name = "doors")
    private String doors;

    @Column(name = "engine")
    private String engine;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "active")
    private boolean active;

    @Column(name = "system_id")
    private int system_id;

    @Column(name = "vehicle_status_id")
    private int vehicle_status_id;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update_date")
    private Date last_update_date;

    @Column(name = "last_status_update_date")
    private Date last_status_update_date;

    @Column(name = "car_group_config_id")
    private int car_group_config_id;

    public Vehicles() {
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setCarId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getExterior_color() {
        return exterior_color;
    }

    public void setExterior_color(String exterior_color) {
        this.exterior_color = exterior_color;
    }

    public String getInterior_color() {
        return interior_color;
    }

    public void setInterior_color(String interior_color) {
        this.interior_color = interior_color;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getSystem_id() {
        return system_id;
    }

    public void setSystem_id(int system_id) {
        this.system_id = system_id;
    }

    public int getVehicle_status_id() {
        return vehicle_status_id;
    }

    public void setVehicle_status_id(int vehicle_status_id) {
        this.vehicle_status_id = vehicle_status_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public Date getLast_status_update_date() {
        return last_status_update_date;
    }

    public void setLast_status_update_date(Date last_status_update_date) {
        this.last_status_update_date = last_status_update_date;
    }

    public int getCar_group_config_id() {
        return car_group_config_id;
    }

    public void setCar_group_config_id(int car_group_config_id) {
        this.car_group_config_id = car_group_config_id;
    }


    @Override
    public String toString() {
        return "Car{" +
                "vehicleId='" + vehicleId + '\'' +
                ", year='" + year + '\'' +
                ", make='" + make + '\'' +
                ", modal='" + modal + '\'' +
                ", series='" + series + '\'' +
                ", exterior_color='" + exterior_color + '\'' +
                ", interior_color='" + interior_color + '\'' +
                ", mileage='" + mileage + '\'' +
                ", doors='" + doors + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", active=" + active +
                ", system_id=" + system_id +
                ", vehicle_status_id=" + vehicle_status_id +
                ", create_date=" + create_date +
                ", last_update_date=" + last_update_date +
                ", last_status_update_date=" + last_status_update_date +
                ", car_group_config_id=" + car_group_config_id +
                '}';
    }

    public Vehicles(long vehicleId, String year, String make, String modal, String series, String exterior_color, String interior_color, String mileage, String doors, String engine, String transmission, boolean active, int system_id, int vehicle_status_id, int car_group_config_id) {
        this.vehicleId = vehicleId;
        this.year = year;
        this.make = make;
        this.modal = modal;
        this.series = series;
        this.exterior_color = exterior_color;
        this.interior_color = interior_color;
        this.mileage = mileage;
        this.doors = doors;
        this.engine = engine;
        this.transmission = transmission;
        this.active = active;
        this.system_id = system_id;
        this.vehicle_status_id = vehicle_status_id;
        this.car_group_config_id = car_group_config_id;
    }
}


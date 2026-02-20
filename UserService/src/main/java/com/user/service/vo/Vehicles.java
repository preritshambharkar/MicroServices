package com.user.service.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles {
    private long vehicleId;

    private String year;

    private String make;

    private String modal;

    private String series;

    private String exterior_color;

    private String interior_color;

    private String mileage;

    private String doors;

    private String engine;

    private String transmission;

    private boolean active;

    private int system_id;

    private int vehicle_status_id;

    private Date create_date;

    private Date last_update_date;

    private Date last_status_update_date;

    private int car_group_config_id;

    @Override
    public String toString() {
        return "Vehicle{" +
                "carId='" + vehicleId + '\'' +
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
}

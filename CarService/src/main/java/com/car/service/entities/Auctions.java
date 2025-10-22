package com.car.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "auctions")
public class Auctions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "auctionId")
    private long auctionId;

    @Column(name = "vehicleId")
    private long vehicleId;

    @Column(name = "auction_status_id")
    private String auction_status_id;

    @Column(name = "high_bidder_id")
    private long high_bidder_id;

    @Column(name = "start_price")
    private double start_price;

    @Column(name = "reserve_price")
    private double reserve_price;

    @Column(name = "buy_price")
    private double buy_price;

    @Column(name = "start_time")
    private Date start_time;

    @Column(name = "end_time")
    private Date end_time;

    @Column(name = "resolve_time")
    private Date resolve_time;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update_date")
    private Date last_update_date;

    @Column(name = "modified_by_login_id")
    private long modified_by_login_id;


    public long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(long auctionId) {
        this.auctionId = auctionId;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getAuction_status_id() {
        return auction_status_id;
    }

    public void setAuction_status_id(String auction_status_id) {
        this.auction_status_id = auction_status_id;
    }

    public long getHigh_bidder_id() {
        return high_bidder_id;
    }

    public void setHigh_bidder_id(long high_bidder_id) {
        this.high_bidder_id = high_bidder_id;
    }

    public double getStart_price() {
        return start_price;
    }

    public void setStart_price(double start_price) {
        this.start_price = start_price;
    }

    public double getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(double reserve_price) {
        this.reserve_price = reserve_price;
    }

    public double getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(double buy_price) {
        this.buy_price = buy_price;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getResolve_time() {
        return resolve_time;
    }

    public void setResolve_time(Date resolve_time) {
        this.resolve_time = resolve_time;
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

    public long getModified_by_login_id() {
        return modified_by_login_id;
    }

    public void setModified_by_login_id(long modified_by_login_id) {
        this.modified_by_login_id = modified_by_login_id;
    }

    @Override
    public String toString() {
        return "Auctions{" +
                "auctionId=" + auctionId +
                ", vehicleId=" + vehicleId +
                ", auction_status_id='" + auction_status_id + '\'' +
                ", high_bidder_id=" + high_bidder_id +
                ", start_price=" + start_price +
                ", reserve_price=" + reserve_price +
                ", buy_price=" + buy_price +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", resolve_time=" + resolve_time +
                ", create_date=" + create_date +
                ", last_update_date=" + last_update_date +
                ", modified_by_login_id=" + modified_by_login_id +
                '}';
    }

    public Auctions(long auctionId, long vehicleId, String auction_status_id, long high_bidder_id, double start_price, double reserve_price, double buy_price, Date start_time, Date end_time, Date resolve_time, Date create_date, Date last_update_date, long modified_by_login_id) {
        this.auctionId = auctionId;
        this.vehicleId = vehicleId;
        this.auction_status_id = auction_status_id;
        this.high_bidder_id = high_bidder_id;
        this.start_price = start_price;
        this.reserve_price = reserve_price;
        this.buy_price = buy_price;
        this.start_time = start_time;
        this.end_time = end_time;
        this.resolve_time = resolve_time;
        this.create_date = create_date;
        this.last_update_date = last_update_date;
        this.modified_by_login_id = modified_by_login_id;
    }

    public Auctions() {}

}

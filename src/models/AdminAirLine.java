package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class AdminAirLine {

    public int air_id;
    public String air_name;
    public String loc_from;
    public String loc_to;
    public LocalDate date;
    public LocalTime time;
    public LocalTime arrival_time;



    public int seat_qty;
    public int seat_col;
    public double price;
    public String air_class;

    public AdminAirLine(){

    }

    public AdminAirLine(int air_id,String air_name,String loc_from,String loc_to,LocalDate date,LocalTime time,
                        LocalTime arrival_time,int seat_qty,int seat_col,double price,String air_class){
        this.air_id = air_id;
        this.air_name = air_name;
        this.loc_from = loc_from;
        this.loc_to = loc_to;
        this.date = date;
        this.time = time;
        this.arrival_time = arrival_time;
        this.seat_qty = seat_qty;
        this.seat_col = seat_col;
        this.price = price;
        this.air_class = air_class;
    }

    public int getAir_id() {
        return air_id;
    }

    public void setAir_id(int air_id) {
        this.air_id = air_id;
    }

    public String getAir_name() {
        return air_name;
    }

    public void setAir_name(String air_name) {
        this.air_name = air_name;
    }

    public String getLoc_from() {
        return loc_from;
    }

    public void setLoc_from(String loc_from) {
        this.loc_from = loc_from;
    }

    public String getLoc_to() {
        return loc_to;
    }

    public void setLoc_to(String loc_to) {
        this.loc_to = loc_to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(LocalTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getSeat_qty() {
        return seat_qty;
    }

    public void setSeat_qty(int seat_qty) {
        this.seat_qty = seat_qty;
    }

    public int getSeat_col() {
        return seat_col;
    }

    public void setSeat_col(int seat_col) {
        this.seat_col = seat_col;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAir_class() {
        return air_class;
    }

    public void setAir_class(String air_class) {
        this.air_class = air_class;
    }

    @Override
    public String toString() {
        return "AdminAirLine{" +
                "air_id=" + air_id +
                ", air_name='" + air_name + '\'' +
                ", loc_from='" + loc_from + '\'' +
                ", loc_to='" + loc_to + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", arrival_time=" + arrival_time +
                ", seat_qty=" + seat_qty +
                ", seat_col=" + seat_col +
                ", price=" + price +
                ", air_class='" + air_class + '\'' +
                '}';
    }
}

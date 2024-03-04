package model;


import java.sql.Time;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Booking {
    private int id;
    private int roomId;
    private Date bookingDate;
    private Time startTime;
    private Time endTime;
    private String purpose;

    public Booking(int id, int roomId, Date bookingDate, Time startTime, Time endTime, String purpose) {
        this.id = id;
        this.roomId = roomId;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public int getRoomId() {
        return roomId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public String getPurpose() {
        return purpose;
    }
}


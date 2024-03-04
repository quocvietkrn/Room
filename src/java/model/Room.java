package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Room {
    private int id;
    private String roomNumber;
    private int capacity;
    private int floor;

    public Room(int id, String roomNumber, int capacity, int floor) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFloor() {
        return floor;
    }
}


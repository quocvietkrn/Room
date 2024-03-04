/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import dal.RoomBean;
import model.Room;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng RoomBean để truy vấn cơ sở dữ liệu
        RoomBean roomBean = new RoomBean();

        // Gọi phương thức getAll để lấy danh sách tất cả các phòng
        List<Room> rooms = roomBean.getAll();

        // In thông tin về các phòng
        System.out.println("Danh sách các phòng:");
        for (Room room : rooms) {
            System.out.println("ID: " + room.getId());
            System.out.println("Room Number: " + room.getRoomNumber());
            System.out.println("Capacity: " + room.getCapacity());
            System.out.println("Floor: " + room.getFloor());
            System.out.println("----------------------");
        }
    }
}

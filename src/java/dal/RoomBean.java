package dal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import model.Booking;
import model.Room;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class RoomBean {
    // Chi tiết kết nối cơ sở dữ liệu
    private final String url = "jdbc:mysql://localhost:3306/Rooms_DE170053";
    private final String username = "sa";
    private final String password = "123123 ";

    // Phương thức để lấy tất cả các phòng từ bảng Rooms
 public List<Room> getAll() {
        List<Room> rooms = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM Rooms";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String roomNumber = rs.getString("room_number");
                        int capacity = rs.getInt("capacity");
                        int floor = rs.getInt("floor");
                        rooms.add(new Room(id, roomNumber, capacity, floor));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }


    // Phương thức để lấy lịch đặt phòng trong một tháng cụ thể
    public List<Booking> getBookingByMonth(int month) {
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM Bookings WHERE MONTH(booking_date) = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, month);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        int roomId = rs.getInt("room_id");
                        // Lấy thông tin đặt phòng khác nếu cần
                        bookings.add(new Booking(id, roomId, rs.getDate("booking_date"), rs.getTime("start_time"), rs.getTime("end_time"), rs.getString("purpose")));

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}


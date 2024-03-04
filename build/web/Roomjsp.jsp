<%-- 
    Document   : Roomjsp
    Created on : Mar 4, 2024, 7:49:41 AM
    Author     : ASUS
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dal.RoomBean" %>
<%@ page import="model.Room" %>
<%@ page import="model.Booking" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Room Information</title>
</head>
<body>
    <h1>All Rooms</h1>
    <% 
        RoomBean roomBean = new RoomBean();
        List<Room> rooms = roomBean.getAll();
        for (Room room : rooms) {
    %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Room Number</th>
                <th>Capacity</th>
                <th>Floor</th>
            </tr>
            <tr>
                <td><%= room.getId() %></td>
                <td><%= room.getRoomNumber() %></td>
                <td><%= room.getCapacity() %></td>
                <td><%= room.getFloor() %></td>
            </tr>
        </table>
    <% } %>

    <h1>Bookings by Month</h1>
    <% 
        int month = 3; // Thay đổi giá trị này thành tháng mong muốn
        List<Booking> bookings = roomBean.getBookingByMonth(month);
        for (Booking booking : bookings) {
    %>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Room ID</th>
                <!-- Thêm thông tin đặt phòng khác nếu cần -->
            </tr>
            <tr>
                <td><%= booking.getId() %></td>
                <td><%= booking.getRoomId() %></td>
                <!-- Hiển thị thông tin đặt phòng khác nếu cần -->
            </tr>
        </table>
    <% } %>
</body>
</html>


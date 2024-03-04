/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dal.RoomBean;
import jakarta.servlet.annotation.WebServlet;
import model.Room;
import model.Booking;

@WebServlet(name = "RoomController", urlPatterns = {"/roomController"})
public class RoomController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("allRooms")) {
                showAllRooms(request, response);
            } else if (action.equals("bookingsByMonth")) {
                showBookingsByMonth(request, response);
            }
        }
    }

    private void showAllRooms(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoomBean roomBean = new RoomBean();
        List<Room> rooms = roomBean.getAll();
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("/allRooms.jsp").forward(request, response);
    }

    private void showBookingsByMonth(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int month = Integer.parseInt(request.getParameter("month"));
        RoomBean roomBean = new RoomBean();
        List<Booking> bookings = roomBean.getBookingByMonth(month);
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("/bookingsByMonth.jsp").forward(request, response);
    }
}


package org.example.web_app.dao;

import org.example.web_app.dao.impl.IBookingDAO;
import org.example.web_app.model.Booking;
import org.example.web_app.model.en.EPay;
import org.example.web_app.model.en.EStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO extends ConnectionDB implements IBookingDAO {
    protected String VIEW_ALL_BOOKINGS = "SELECT * FROM db_manager_tour.view_bookings;";
    protected String HANDLE_PROCESSING_TOUR_SQL = "call db_manager_tour.handleProcessingTour(?, ?);\n";
    protected String CREATE_BOOKING_CUSTOMER = "call db_manager_tour.insertIntoBooking(?, ?, ?, ?, ?);";
    @Override
    public List<Booking> getAll() {
        List<Booking> bookingList = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement(VIEW_ALL_BOOKINGS);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
//                long id, int seat, long totalPrice,
//                LocalDate dateBooking, EStatusTour statusTour,
//                EPay pay, String customerName, String customerPhone,
//                String tourName, long idDescriptionTour, LocalDate dateStat,
//                LocalDate dateEnd, String employeeName, String employeePhone
                bookingList.add(new Booking(
                   rs.getLong("id"),
                        rs.getInt("seat"),
                        rs.getLong("totalPrice"),
                        rs.getDate("dateBooking").toLocalDate(),
                        EStatus.valueOf(rs.getString("status")),
                        EPay.valueOf(rs.getString("payment")),
                        rs.getString("customerName"),
                        rs.getString("customerPhone"),
                        rs.getString("tourName"),
                        rs.getLong("description_tours_id"),
                        rs.getDate("dateStart").toLocalDate(),
                        rs.getDate("dateEnd").toLocalDate(),
                        rs.getString("employeeName"),
                        rs.getString("employeePhone")

                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookingList;
    }
    @Override
    public void handleTourBooking(long id, EStatus status) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(HANDLE_PROCESSING_TOUR_SQL);
            statement.setLong(1, id);
            statement.setString(2, status + "");

            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createBooking(Booking booking) {
        try {
            PreparedStatement statement = getConnection().prepareStatement(CREATE_BOOKING_CUSTOMER);
            //IN seatPlace int, IN totalPrice int, IN pay varchar(20), IN idCustomer int, IN idDescription_id int
            statement.setLong(1, booking.getSeat());
            statement.setLong(2, booking.getTotalPrice());
            statement.setString(3,booking.getPay() + "");
            statement.setLong(4, booking.getIdCustomer());
            statement.setLong(5, booking.getIdDescriptionTour());


            System.out.println(statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

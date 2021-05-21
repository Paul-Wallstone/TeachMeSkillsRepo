package utils;

import classes.Stuff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {

    private static final String GET_ALL_DOCTORS = "SELECT * FROM medicalstuff ";
    private static final String UPDATE_DOCTORS =
            "UPDATE medicalstuff SET name = ? ,surname = ? ,age =? ,position=?,specialization = ? WHERE id = ?";
    private static final String DELETE_DOCTORS = "DELETE FROM medicalstuff WHERE id = ?";
    private static final String INSERT_DOCTORS = "INSERT INTO medicalstuff(name,surname,age,position ,specialization) VALUES (?,?,?,?,?)";


    public static List<Stuff> getDoctorsData(Connection connection) throws SQLException {
        List<Stuff> doctors = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_DOCTORS);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int age = rs.getInt("age");
            String position = rs.getString("position");
            String specialization = rs.getString("specialization");
            doctors.add(new Stuff(id, name, surname, age, position, specialization));

        }
        return doctors;
    }


    public static List<Stuff> updateDoctorsData(Stuff stuff, Connection connection) throws SQLException {
        List<Stuff> doctors = new ArrayList<>();

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCTORS);
        preparedStatement.setString(1, stuff.getName());
        preparedStatement.setString(2, stuff.getSurname());
        preparedStatement.setInt(3, stuff.getAge());
        preparedStatement.setString(4, stuff.getPosition());
        preparedStatement.setString(5, stuff.getSpecialization());
        preparedStatement.setInt(6, stuff.getId());
        preparedStatement.executeUpdate();

        return doctors;
    }


    public static void deleteDoctorsData(int stuffID, Connection connection) throws SQLException {
        List<Stuff> doctors = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOCTORS);
        preparedStatement.setInt(1, stuffID);
        preparedStatement.executeUpdate();

    }

    public static void saveDoctorsData(Stuff stuff, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOCTORS);
        preparedStatement.setString(1, stuff.getName());
        preparedStatement.setString(2, stuff.getSurname());
        preparedStatement.setInt(3, stuff.getAge());
        preparedStatement.setString(4, stuff.getPosition());
        preparedStatement.setString(5, stuff.getSpecialization());
        preparedStatement.executeUpdate();
    }
}




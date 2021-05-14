package HW10_2021_05_14.jdbc.utils;

import HW10_2021_05_14.jdbc.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
private static final String GET_ALL_STUDENTS = "SELECT * FROM students";

    public static List<Student> getStudentData() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String course_name = rs.getString("course_name");
                students.add(new Student(id, name, surname, course_name));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}

package HW10_2021_05_14.jdbc.utils;



import HW10_2021_05_14.jdbc.classes.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static final String GET_ALL_STUDENTS = "SELECT * FROM students";
    private static final String UPDATE_STUDENT =
            "UPDATE students SET name = ? ,surname = ? ,course_name =? WHERE id = ?";
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
    private static final String INSERT_STUDENT = "INSERT INTO students(name,surname,course_name) VALUES (?,?,?)";


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

    public static List<Student> updateStudentsData(int studentID, String name, String surname, String course_name) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, course_name);
            preparedStatement.setInt(4, studentID);
            preparedStatement.executeUpdate();


            PreparedStatement AllPreparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);
            ResultSet rs = AllPreparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String surname1 = rs.getString("surname");
                String course_name1 = rs.getString("course_name");
                students.add(new Student(id, name1, surname1, course_name1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return students;
    }

    public static List<Student> deleteStudentData(int studentId) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);) {
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();

            PreparedStatement AllPreparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);
            ResultSet rs = AllPreparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String surname1 = rs.getString("surname");
                String course_name1 = rs.getString("course_name");
                students.add(new Student(id, name1, surname1, course_name1));
            }

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static List<Student> saveStudentData(Student student) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setString(3, student.getCourse_name());
            preparedStatement.executeUpdate();

            PreparedStatement AllPreparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);
            ResultSet rs = AllPreparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String surname1 = rs.getString("surname");
                String course_name1 = rs.getString("course_name");
                students.add(new Student(id, name1, surname1, course_name1));
            }

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}
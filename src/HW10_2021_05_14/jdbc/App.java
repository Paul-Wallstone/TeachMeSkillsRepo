package HW10_2021_05_14.jdbc;

import HW10_2021_05_14.jdbc.utils.CRUDUtils;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Student> students = CRUDUtils.getStudentData();
        System.out.println(students);
    }
}

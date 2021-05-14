package HW10_2021_05_14.jdbc.classes;

import HW10_2021_05_14.jdbc.utils.CRUDUtils;


import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Student> students = CRUDUtils.getStudentData();
        students.stream().forEach(System.out::println);
        students = CRUDUtils.updateStudentsData(1, "Stive", "Jobs",
                "Apple course");
        students.stream().forEach(System.out::println);
        students = CRUDUtils.saveStudentData(
                new Student(2, "Pavel", "Puchinski", "Java Core SE"));
        students.stream().forEach(System.out::println);
        students = CRUDUtils.deleteStudentData(1);
        students.stream().forEach(System.out::println);

    }
}

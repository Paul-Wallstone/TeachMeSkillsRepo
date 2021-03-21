package HW3_2021_03_19;

import java.util.List;

public class Student {
    private String name;
    private String surname;
    private String dateOfBirthday;
    private int course;
    private static List<Student> students;

    public Student(String name, String surname, String dateOfBirthday, int course) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirthday = dateOfBirthday;
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public static void setStudents(List<Student> students1) {
        students = students1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Имя: " + name + " /Фамилия: " + surname + " /Дата рождения: " + dateOfBirthday
                + " /курс: " + course;
    }

    public static void printStudents(int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.toString());
            }
        }
    }

    public static void printStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}

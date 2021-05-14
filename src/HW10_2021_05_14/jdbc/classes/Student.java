package HW10_2021_05_14.jdbc.classes;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String course_name;

    public Student(int id, String surname, String name, String course_name) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.course_name = course_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public String toString() {
        return "classes.Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", course_name='" + course_name + '\'' +
                '}';
    }
}

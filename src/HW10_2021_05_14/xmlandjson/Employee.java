package HW10_2021_05_14.xmlandjson;

public class Employee {
    private String name, position, department;
    private int experience;

    public Employee(String name) {
        this.name = name;
        this.position = "";
        this.department = "";
        this.experience = 0;
    }

    public Employee(String name, String position, String department, int experience) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public int getExperience() {
        return experience;
    }
}

package HW9_2021_05_07.stream;

public class UserCard {
    private String name;
    private String sex;
    private int age;
    private String company;

    public UserCard(String name, String sex, int age, String company) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }
}

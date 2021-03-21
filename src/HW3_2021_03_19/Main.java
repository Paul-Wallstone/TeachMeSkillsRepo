package HW3_2021_03_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестируем класс Student");
        Student student1 = new Student("Pavel", "Puchinski", "31/12/1988", 13);
        Student student2 = new Student("Ivan", "Ivanov", "31/12/1966", 10);
        Student student3 = new Student("Oleg", "Sidorov", "31/12/1994", 13);
        Student student4 = new Student("Anna", "Konopelko", "31/12/1977", 13);

        Student.setStudents(Arrays.asList(student1, student2, student3, student4));
        Student.printStudents(13);
        System.out.println();
        Student.printStudents();

        System.out.println("Тестируем класс Calculator");
        System.out.println(Calculator.division(12, 3));
        System.out.println(Calculator.addition(12, 3));
        System.out.println(Calculator.multiplication(12, 3));
        System.out.println(Calculator.subtraction(12, 3));

        System.out.println("Тестируем класс Computer");
        Computer computer = new Computer("Intel", 16, 1000);
        computer.printPC();
        computer.onPC();
        computer.offPC();
        computer.onPC();

        System.out.println("Тестируем класс CardValidator");
        ProductValidator cardValidator = new ProductValidator();

        cardValidator.validateDebitCard("123456789", "Debit", "Pavel",
                "Puchinski", "21/12/2023", "591");
        System.out.println();
        cardValidator.validateDebitCard("12345678VF", "Credit", "Ivan",
                "Ivanov2", "41/12;2066", "591C");


    }
}

package HW9_2021_05_07.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressionsApplication {
    public static void main(String[] args) {
        String[] str1 = new String[]{"Car", "Plant", "Firewall"};
        String[] str2 = new String[]{"Parrot", "Dog", "Elephant", "Space"};
        String[] str3 = new String[]{"Apple", "Nokia"};
        List<String[]> stringList = new ArrayList<>(Arrays.asList(str1, str2, str3));
        System.out.println("\nОригинальный список");
        print(stringList);
        System.out.println("\nСортировка по возрастанию");
        stringList.sort((o1, o2) -> o1.length - o2.length);
        print(stringList);
        System.out.println("\nСортировка по убыванию");
        stringList.sort(((o1, o2) -> o1.length > o2.length ? -1 : 1));
        print(stringList);
    }

    public static void print(List<String[]> stringList) {
        for (String[] s : stringList) {
            Arrays.stream(s).forEach(x -> System.out.printf("%s ", x));
            System.out.println();
        }
    }
}

package HW9_2021_05_07.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamApiApplication {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(Arrays.asList("clever", "god", "tenet", "prist", "kayak", "level", "dad"));
        AtomicInteger n = new AtomicInteger();
        System.out.println("\nВыполнение основного задания");
        System.out.println("\nОригинальный список строк(отсортированный по количеству символов)(sorted,map,collect)");
        strings.stream().sorted((n1, n2) -> n1.length() - n2.length()).map(p -> (n.getAndIncrement() + 1) + ")" + p).forEach(System.out::println);
        System.out.println("\nПалиндромы:");
        List<String> strings2 = strings.stream().
                filter(s -> s.equals(new StringBuilder(s).reverse().toString())).collect(Collectors.toList());
        strings2.stream().forEach(System.out::println);
        System.out.println();

    }
}

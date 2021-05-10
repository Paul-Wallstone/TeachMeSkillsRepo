package HW9_2021_05_07.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest {
    public static void main(String[] args) {
        //Метод forEach. Метод filter .Метод map. Метод flatMap. Метод sorted
        Stream<Integer> st = Stream.of(-1, 2, 13, -12, 4);
        st.sorted(Integer::compareTo).filter(t -> t > 0).map(o -> "n:" + o).forEach(System.out::println);

        //Метод takeWhile.Метод dropWhile.Метод concat.Метод distinct
        Stream<String> st1 = Stream.of("level", "dad", "table", "god");
        Stream<String> st2 = Stream.of("clever", "god", "tenet", "prist", "kayak");
        Stream<String> st3 = Stream.of("clever", "god", "tenet", "prist", "kayak", "god");
        System.out.println("\ndropWhile:");
        Stream.concat(st1, st2).sorted((t1, t2) -> t1.length() - t2.length()).dropWhile(g -> g.length() == 3).forEach(System.out::println);
        System.out.println("\ntakeWhile:");
        st3.sorted((e1, e2) -> e1.length() - e2.length()).takeWhile(f -> f.length() == 3).distinct().forEach(System.out::println);

        //Методы skip и limit,findFirst и findAny,count,min и max,allMatch, anyMatch, noneMatch
        Stream stream1 = Stream.of("One", "Yellow", "Light", "One", "Green", "Light");
        Stream stream2 = Stream.of("One", "Red", "Light");
        Stream stream3 = Stream.of("One", "Red", "Light");
        Stream stream4 = Stream.of("One", "Red", "Light");
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 12, -10, 123, 11, -43, -9));
        System.out.println("\nFind first/find any");
        Optional first = stream3.findFirst();
        Optional any = stream4.findAny();
        System.out.println("Первый объект: " + first.get());
        System.out.println("Любой объект: " + any.get());
        System.out.println("\nskip,limit:");
        Stream.concat(stream1, stream2).distinct().skip(1).limit(3).forEach(System.out::println);
        System.out.println("anyMatch,noneMatch,allMatch,min,max:\n Initial List:");
        array.stream().map(v -> v + ";").forEach(System.out::print);
        System.out.println("\nКоличество элементов в потоке < 0:" + array.stream().filter(f -> f < 0).count());
        System.out.println("\nЕсть ли хоть одно четное число: " + array.stream().anyMatch(a -> a % 2 == 0) +
                "\nВсе ли числа четные: " +
                array.stream().allMatch(a -> a % 2 == 0) +
                "\nНи одно число не четное: " +
                array.stream().noneMatch(a -> a % 2 == 0) + "\nМаксимальное значение: " +
                array.stream().max(Integer::compareTo).get() + "\nМинимальное значение: " +
                array.stream().min(Integer::compareTo).get());

        // reduce
        Stream<Integer> stream_1 = Stream.of(1, 2, 3);
        Stream<Integer> stream_2 = Stream.of(1, 2, 3);
        Stream<Integer> stream_3 = Stream.of(2, 2, 3);
        Optional<Integer> result = stream_2.reduce((x, y) -> y + x * 10);
        int identity = 10;
        int result2 = stream_1.reduce(identity, (x, y) -> y + x * 10);
        identity = 0;
        int result3 = stream_3.reduce(identity, (x, y) -> y % 2 == 0 ? x + 1 : x + 0, (x, y) -> x + y);
        System.out.println("\nReduce\n" + "Result1:" + result.orElse(-1) + "\nResult2:" + result2 + "\nResult3:" + result3);

        //Метод collect
        System.out.println("\nМетод collect:");
        List<Integer> intArray = Stream.of(1, 22, 334, 5, 6, 77, 8, -49, -4, -3).sorted((c, v) -> c < v ? 1 : -1)
                .filter(d -> d > 0).collect(Collectors.toList());
        intArray.stream().forEach(System.out::println);
        //groupingBY
        List<UserCard> users = new ArrayList<>(Arrays.asList(new UserCard("Stive", "M", 30, "Google"),
                new UserCard("Mike", "M", 29, "Google"),
                new UserCard("Ann", "F", 33, "Facebook"),
                new UserCard("Kate", "F", 25, "Facebook")));
        Stream<UserCard> userCard = users.stream();
        Stream<UserCard> userCard2 = users.stream();
        Stream<UserCard> userCard3 = users.stream();

        Map<String, List<UserCard>> userMap = userCard.collect(Collectors.groupingBy(UserCard::getCompany));
        Map<String, Long> userMap2 = userCard2.collect(Collectors.groupingBy(UserCard::getCompany, Collectors.counting()));
        Map<String, Optional<UserCard>> userMap3 = userCard3.collect(Collectors.groupingBy(UserCard::getCompany, Collectors.minBy(Comparator.comparing(UserCard::getAge))));

        for (Map.Entry<String, List<UserCard>> box : userMap.entrySet()) {
            System.out.println(box.getKey());
            box.getValue().stream().map(n -> n.getName()).forEach(System.out::println);
            System.out.println();
        }
        for (Map.Entry<String, Long> box : userMap2.entrySet()) {
            System.out.println(box.getKey() + ":" + box.getValue());
            System.out.println();
        }
        for (Map.Entry<String, Optional<UserCard>> box : userMap3.entrySet()) {
            System.out.println(box.getKey() + ":" + box.getValue().get().getName());
            System.out.println();
        }
    }
}

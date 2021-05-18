package HW10_2021_05_14.regularexpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {
        System.out.println("First task");
        String[] inputs = {"127.0.0.1", "1300.6.7.8", "255.255.255.0", "abc.def.gha.bcd"};
        Pattern pattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
        for (String input : inputs) {
            Matcher matcher = pattern.matcher(input);
            checkString(matcher);
        }

        System.out.println("Second task");
        System.out.println("Введите дату и время в формате YYYY/MM/DD HH:MM:SS");
        Scanner sc = new Scanner(System.in);
        String dateTime = sc.nextLine();
        String date = "(\\d{4}/(0[1-9]|1[012])/(0[1-9]|1[0-9]|2[0-9]|3[01]))";
        String time = "(0[0-9]|[1-2][0-3]):(0[0-9]|[1-5][0-9]):(0[0-9]|[1-5][0-9])";
        Pattern pattern1 = Pattern.compile(date + "\\s*" + time);
        Matcher matcher = pattern1.matcher(dateTime);
        checkString(matcher);

        System.out.println("Third task");
        String[] inputs1 = {"http://example.com/", "example.com"};
        Pattern pattern2 = Pattern.compile("(http://|https://)[a-z1-9]*\\.[a-z]{2,3}/");
        for (String s : inputs1) {
            Matcher matcher2 = pattern2.matcher(s);
            checkString(matcher2);
        }
    }

    public static void checkString(Matcher matcher) {
        if (matcher.matches()) {
            System.out.println("Validate");
            try {
                System.out.println(matcher.group());
            } catch (IllegalStateException e) {
                e.printStackTrace(System.out);
            }
        } else {
            System.out.println("Error");
        }
    }
}


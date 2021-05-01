package HW8_2021_04_23.thirdtask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CensureClass {
    private static List<String> stringsNeedToCensored = new ArrayList<>();
    static private int stringCount = 0;


    public static void startCensored(String blackList, String censoredText) {
        String regex = "[;.!?]";
        String[] strings = censoredText.split(regex);
        for (String censoredString : strings) {
            countCensoredWordsInString(blackList, censoredString);
        }
        if (stringCount == 0) {
            System.out.println("Censored strings are not exist!");
        } else {
            System.out.printf("%d sentenсes should be censored:\n", stringCount);
            for (String str : stringsNeedToCensored) {
                System.out.println(str + ".");
            }
        }

    }

    private static void countCensoredWordsInString(String blackList, String censoredString) {
        String regex = "[\\s;,:()\"]";
        String regex2 = "\\R";
        String[] blackListWords = blackList.split(regex2);
        String[] censoredWords = censoredString.split(regex);
        List<String> censoredArray = new ArrayList<>(Arrays.asList(censoredWords));
        for (String s : blackListWords) {
            if (censoredArray.contains(s)) {
                stringCount++;
                stringsNeedToCensored.add(censoredString.replace("\r\n", "").trim());
                break;
            }
        }
    }
}

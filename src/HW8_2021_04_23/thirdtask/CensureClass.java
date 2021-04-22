package HW8_2021_04_23.thirdtask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CensureClass {
    private static List<String> stringsNeedToCensored = new ArrayList<String>();
    static private int stringCount = 0;
    private String[] stringArray;

    public static List<String> getStringsNeedToCensored() {
        return stringsNeedToCensored;
    }

    public static int getStringCount() {
        return stringCount;
    }

    public static void startCensored(String blackList, String censoredText) {
        String regex = "[;.!?]";
        String[] strings = censoredText.split(regex);
        for (String censoredString : strings) {
            countCensoredWordsInString(blackList, censoredString);
        }
        if (getStringCount() == 0) {
            System.out.println("Censored strings are not exist!");
        } else {
            System.out.printf("%d sentenсes should be censored:\n", getStringCount());
            for (String str : getStringsNeedToCensored()) {
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

package HW8_2021_04_23.secondtask;

public class TextFormater {
    static int countWordsInString(String str) {
        String[] strings = str.split(" ");
        return strings.length;
    }

    static boolean isStringHasPolindrome(String str) {
        boolean flag = false;
        String regex = "[\\s;.,:!?()\"-]";
        String[] strings = str.split(regex);
        for (String string : strings) {
            String strReverse = new StringBuilder(string.toUpperCase()).reverse().toString();
            if (string.toUpperCase().equals(strReverse) && string.length() > 1) {
                System.out.println(string);
                flag = true;
            }
        }
        return flag;
    }
}
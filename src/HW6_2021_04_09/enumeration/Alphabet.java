package HW6_2021_04_09.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public enum Alphabet {

    A('a'),
    B('b'),
    C('c'),
    D('d'),
    E('e'),
    F('f'),
    G('g'),
    H('h'),
    I('i'),
    J('j'),
    K('k'),
    L('l'),
    M('m'),
    N('n'),
    O('o'),
    P('p'),
    Q('q'),
    R('r'),
    S('s'),
    T('t'),
    U('u'),
    V('v'),
    W('w'),
    X('x'),
    Y('y'),
    Z('z');

    char letter;

    Alphabet(char letter) {
        this.letter = letter;
    }

    public static int getLetterPosition(String a) {
        if (a.length() == 1 && !Character.isDigit(a.charAt(0))) {
            Alphabet letter = Alphabet.valueOf(a.toUpperCase(Locale.ROOT));
            return letter.ordinal() + 1;
        }
        return 0;
    }
}



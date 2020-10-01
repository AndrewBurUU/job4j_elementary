package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    public int getNumberFromString (String str) {
        int rsl = -1;
        String sNum = "";
        for (int index = 0; index < str.length(); index++) {
            Character charLeft = str.charAt(index);
            if (charLeft != '.') {
                sNum = sNum + charLeft;
            }
            else break;
        }
        if (sNum.length() != 0) rsl = Integer.parseInt(sNum);
        return rsl;
    }

    @Override
    public int compare(String left, String right) {
        int numLeft = 0;
        int numRight = 0;
        numLeft = getNumberFromString(left);
        numRight = getNumberFromString(right);
        return Integer.compare(numLeft, numRight);
    }
}

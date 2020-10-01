package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int minLength = left.length() < right.length() ? left.length() : right.length();
        for (int index = 0; index < minLength; index++) {
            if (left.charAt(index) == right.charAt(index)) {
                rsl = 0;
            }
            else if (left.charAt(index) < right.charAt(index)) {
                rsl = -1;
                break;
            }
            else {rsl = 1; break;}
        }
        if (rsl == 0) {
            if (left.length() > right.length()) {
                rsl = 1;
            }
            if (left.length() < right.length()) {
                rsl = -1;
            }
        }
        return rsl;
    }
}

package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Word = o1.split("/");
        String[] o2Word = o2.split("/");
        int rsl = o2Word[0].compareTo(o1Word[0]);
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        else {
            return rsl;
        }
    }
}

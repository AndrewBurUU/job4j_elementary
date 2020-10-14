package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        LinkedHashSet<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.length() == 0) {
                    start = el;
                }
                else {
                    start = start + "/" + el;
                }
                tmp.add(start);
            }
        }
        ArrayList<String> rsl = new ArrayList<>(tmp);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}

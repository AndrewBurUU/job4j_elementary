package ru.job4j.loop;

import java.util.Arrays;

public class Mortgage {
    public static int year(int amount, int salary, double percent) {
        int year = 0;
        double sum = amount;
        while (sum > 0) {
            sum = sum * percent / 100 + sum  - salary;
            year++;
        }
        return year;
    }

    public static void main(String[] args) {
        int res = year(2000000, 300000, 6.1);
        System.out.println("ages = " + String.valueOf(res));
    }
}

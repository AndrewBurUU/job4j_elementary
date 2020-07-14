package ru.job4j.loop;

public class Factorial {
    public static int calc (int n) {
        int res=1;
        for (int number = 1; number <= n; number++) {
            res=res*number;
        }
        return res;
    }
}

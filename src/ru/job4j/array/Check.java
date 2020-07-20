package ru.job4j.array;

public class Check {
    public static boolean mono(boolean[] data) {
        boolean result = true;
        boolean tmp = data[0];
        for (int index = 1; index < data.length - 1; index++) {
            if (data[index] != tmp) {
                result = false;
                break;
            }
        }
        return result;
    }
}

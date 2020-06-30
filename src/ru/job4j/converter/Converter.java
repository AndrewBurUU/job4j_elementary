package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) {
        int rsl = value / 70;
        return rsl;
    }

    public static int rubleToDollar(int value) {
        int rsl = value / 60; /* формула перевода рублей в доллары. */
        return rsl;
    }

    public static void main(String[] args) {
/*
         int euro = Converter.rubleToEuro(140);
        int dollar=Converter.rubleToDollar(140);
        System.out.println("140 rubles are " + euro + " euros.");
        System.out.println("140 rubles are " + dollar + " dollars.");

 */
        int in=140;
        int expected=2;
        int out=rubleToEuro(in);
        boolean passed=expected==out;
        System.out.println("140 rubles are 2 euros. Test result:"+passed);
        in=120;
        out=rubleToDollar(in);
        passed=expected==out;
        System.out.println("120 rubles are 2 dollars. Test result:"+passed);
    }
}

package ru.job4j.loop;

public class Counter {
    /*
        public static void main (String[] args) {
            System.out.println(sum(0,5));
            System.out.println(sum(0,10));
            System.out.println(sum(3,8));
            System.out.println(sum(1,1));
            System.out.println(sum(-8,4));
        }
     */

    public static int sum (int start, int finish) {
        int sum=0;
        for (int number=start;number<=finish;number++) {
            sum=sum+number;
        }
        return sum;
    }

    public static int sumByEven (int start, int finish) {
        int sum=0;
        for (int number=start;number<=finish;number++) {
            if (number % 2==0) {
                sum = sum + number;
            }
        }
        return sum;
    }

}

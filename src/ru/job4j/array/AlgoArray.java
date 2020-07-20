package ru.job4j.array;

public class AlgoArray {
    public static void main(String[] args) {
        int[] array = new int[] {5, 3, 2, 1, 4};
        int min = 0;
        int minIndex = 0;
        int temp = 0;
        for (int index = 0; index < array.length; index++) {
            min = array[index];
            for (int i = index + 1; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                    minIndex = i;
                }
            }
            temp = array[index]; /* переменная для временного хранения значение ячейки с индексом 0. */
            array[index] = min; /* записываем в ячейку с индексом 0 значение ячейки с индексом 3. */
            array[minIndex] = temp; /* записываем в ячейку с индексом 3 значение временной переменной. */
        }

        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
    }
}

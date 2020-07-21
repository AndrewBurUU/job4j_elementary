package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        boolean result = true;
        int dLength = word.length - post.length;
        /* проверить. что массив word имеет последние элементы одинаковые с post */
        for (int index = post.length - 1; index >= 0; index--) {
            if (word[index + dLength] != post[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}

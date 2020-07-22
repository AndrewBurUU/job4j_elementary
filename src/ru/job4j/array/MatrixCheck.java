package ru.job4j.array;

public class MatrixCheck {
    public static boolean monoHorizontal(char[][] board, int row) {
        boolean result = true;
        for (int cell = 0; cell < board[row].length - 1; cell++) {
                if (board[row][cell] != board[row][cell+1]) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}

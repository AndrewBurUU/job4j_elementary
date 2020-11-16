package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void whenMatrix2List() {
        Integer[][] matrix = new Integer[1][2];
        matrix[0][0] = 4;
        matrix[0][1] = 1;
        MatrixToList newMatrix = new MatrixToList();
        List<Integer> rsl = newMatrix.collect(matrix);
        List<Integer> expected = List.of(4,1);
        assertThat(rsl, is(expected));
    }
}
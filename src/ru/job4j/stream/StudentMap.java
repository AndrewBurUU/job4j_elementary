package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
        List<Student> collect(List<Student> students) {
            return students.stream()
            .distinct()
            .collect(Collectors.toMap(
                    student -> student.getSurname(),
                    student -> student))
        };
        /*
        Integer[][] matrix = new Integer[1][2];
        matrix[0][0] = 4;
        matrix[0][1] = 1;
        System.out.println(
        Stream.of(matrix).flatMap(e -> Arrays.stream(e.clone())).collect(Collectors.toList())
        );

         */
}

package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentMap {
        public Map<String,Student> collect(List<Student> students) {
            return students.stream()
            .collect(Collectors.toMap(
                    student -> student.getSurname(),
                    student -> student,
                    (existing, replacement) -> existing));
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

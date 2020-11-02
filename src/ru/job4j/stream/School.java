package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> students10 = new ArrayList<Student>();
        students10 = students.stream().filter(predict).collect(Collectors.toList());
        return students10;
    };
}

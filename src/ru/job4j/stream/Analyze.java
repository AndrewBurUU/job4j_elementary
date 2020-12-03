package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(subject -> subject.getScore())
                .average().orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil ->
                        new Tuple(pupil.getName(),
                        pupil.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .average()
                                .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(
                        Collectors.groupingBy(
                                Subject::getName,
                                Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(subject ->
                        new Tuple(subject.getKey(),subject.getValue()))
                .collect(Collectors.toList());
//        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}

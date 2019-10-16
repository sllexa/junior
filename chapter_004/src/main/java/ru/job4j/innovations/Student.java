package ru.job4j.innovations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class Student.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 15.10.2019
 */
public class Student implements Comparator<Student> {
    /**
     * Student name.
     */
    private String name;
    /**
     * Student score.
     */
    private int score;

    /**
     * Constructor default.
     */
    public Student() {
    }

    /**
     * Constructor.
     * @param name - student name
     * @param score - student score
     */
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }

    /**
     * Getting student name.
     * @return - student name
     */
    public String getName() {
        return name;
    }

    /**
     * Getting student score.
     * @return - student score
     */
    public int getScore() {
        return score;
    }

    /**
     * Grouping of students by grade point.
     * @param students - list students
     * @param bound - certificate score
     * @return - list students
     */
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted((Comparator.nullsLast((o1, o2) -> o2.getScore() - o1.getScore())))
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }
}

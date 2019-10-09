package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.function.Predicate;
/**
 * Class School.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 04.10.2019
 */
public class School {
    /**
     * Student filtering method.
     * @param students - list students
     * @param predict - filtration conditions
     * @return - filtered student list
     */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    /**
     * Convert students list to Map.
     * @param students list students
     * @return - Map students
     */
    Map<String, Student> convert(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                student -> student.getSurname(),
                student -> student,
                (oldK, newK) -> oldK
        ));
    }
}
package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Predicate;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class SchoolTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 04.10.2019
 */
public class SchoolTest {
    /**
     * School object.
     */
    private School school = new School();
    /**
     * Students list.
     */
    private List<Student> students = Arrays.asList(new Student("Petrov", 45), new Student("Vasin", 58),
            new Student("Ivanov", 85), new Student("Borisov", 74), new Student("Golubev", 90),
            new Student("Garin", 65));

    /**
     * Filter to get a class A list.
     */
    @Test
    public void whenFilterClassAThenListClassA() {
        List<Student> expected = new ArrayList<>();
        Predicate<Student> predicate1 = student -> student.getScore() > 70;
        Predicate<Student> predicate2 = student -> student.getScore() < 100;
        List<Student> result = school.collect(students, predicate1.and(predicate2));
        for (Student student : students) {
            if (student.getScore() > 70 && student.getScore() < 100) {
                expected.add(student);
            }
        }
        assertThat(result, is(expected));
    }

    /**
     * Filter to get a class B list.
     */
    @Test
    public void whenFilterClassBThenListClassB() {
        List<Student> expected = new ArrayList<>();
        Predicate<Student> predicate1 = student -> student.getScore() > 50;
        Predicate<Student> predicate2 = student -> student.getScore() < 70;
        List<Student> result = school.collect(students, predicate1.and(predicate2));
        for (Student student : students) {
            if (student.getScore() > 50 && student.getScore() < 70) {
                expected.add(student);
            }
        }
        assertThat(result, is(expected));
    }

    /**
     * Filter to get a class C list.
     */
    @Test
    public void whenFilterClassCThenListClassC() {
        List<Student> expected = new ArrayList<>();
        Predicate<Student> predicate1 = student -> student.getScore() < 50;
        Predicate<Student> predicate2 = student -> student.getScore() > 0;
        List<Student> result = school.collect(students, predicate1.and(predicate2));
        for (Student student : students) {
            if (student.getScore() > 0 && student.getScore() < 50) {
                expected.add(student);
            }
        }
        assertThat(result, is(expected));
    }

    /**
     * Test convert students list to Map.
     */
    @Test
    public void whenConvertListToMapThenMap() {
        Map<String, Student> expected = new HashMap<>();
        Map<String, Student> result = school.convert(students);
        for (Student student : students) {
            expected.put(student.getSurname(), student);
        }
        assertThat(result, is(expected));
    }
}
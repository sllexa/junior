package ru.job4j.innovations;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StudentTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 15.10.2019
 */
public class StudentTest {
    /**
     * Testing method grouping of students by grade point.
     */
    @Test
    public void whenListStudentsAndBoundThenListStudents() {
        List<Student> students = Arrays.asList(
                new Student("Max", 68),
                new Student("Katerina", 90),
                new Student("Bob", 76),
                new Student("Maria", 55),
                null,
                new Student("Nic", 88),
                new Student("Anna", 45)
        );
        List<Student> result = new Student().levelOf(students, 70);
        List<Student> expected = new ArrayList<>();
        for (Student student : students) {
            if (student != null && student.getScore() > 70) {
                expected.add(student);
            }
        }
        expected.sort((o1, o2) -> o2.getScore() - o1.getScore());
        assertThat(result, is(expected));
    }
}
package ru.job4j.stream;

/**
 * Class Student.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 04.10.2019
 */
public class Student {
    /**
     * field for storing points.
     */
    private int score;

    /**
     * Constructor.
     * @param score - points
     */
    public Student(int score) {
        this.score = score;
    }

    /**
     * Getting student points.
     * @return - int points
     */
    public int getScore() {
        return score;
    }
}
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
     * Student surname.
     */
    private String surname;
    /**
     * field for storing points.
     */
    private int score;

    /**
     * Constructor.
     * @param surname - surname
     * @param score - points
     */
    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    /**
     * Getting student surname.
     * @return - surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Getting student points.
     * @return - int points
     */
    public int getScore() {
        return score;
    }
}
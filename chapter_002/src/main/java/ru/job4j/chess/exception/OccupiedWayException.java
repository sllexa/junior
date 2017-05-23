package ru.job4j.chess.exception;

/**
 * Класс OccupiedWayException.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 20.05.2017
 */
public class OccupiedWayException extends Exception {
    /**
     * Constructor for OccupiedWayException.
     * @param msg - information about Exception.
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}

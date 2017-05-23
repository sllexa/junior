package ru.job4j.chess.exception;

/**
 * Класс FigureNotFoundException.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 20.05.2017
 */
public class FigureNotFoundException extends Exception {
    /**
     * Constructor for FigureNotFoundException.
     * @param msg - information about Exception.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}

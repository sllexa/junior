package ru.job4j.chess.exception;

/**
 * Класс ImposibleMoveException.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.05.2017
 */
public class ImposibleMoveException extends Exception {
    /**
     * constructor for ImpossibleMoveException.
     * @param msg information about Exception.
     */
    public ImposibleMoveException(String msg) {
        super(msg);
    }
}

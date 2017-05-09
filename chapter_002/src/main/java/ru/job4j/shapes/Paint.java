package ru.job4j.shapes;

/**
 * Класс Paint.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 08.05.2017
 */
public class Paint {

    /**
     * Метод печатает фигуру.
     * @param shape - фигура.
     */
    public void draw(Shape shape) {
        System.out.println(shape.pic());
    }
}

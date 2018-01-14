package ru.job4j.shapes;

/**
 * Класс Triangle.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 08.05.2017
 */
public class Triangle implements Shape {
    /**
     * Метод построения треугольника.
     * @return - возвращает строку.
     */
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("   *");
        sb.append(System.lineSeparator());
        sb.append(" *   *");
        sb.append(System.lineSeparator());
        sb.append("*  *  *");
        return sb.toString();
    }
}

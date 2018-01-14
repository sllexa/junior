package ru.job4j.shapes;

/**
 * Класс Square.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 08.05.2017
 */
public class Square implements Shape {
    /**
     * Метод построения квадрада.
     * @return - возвращает строку.
     */
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("* * *");
        sb.append(System.lineSeparator());
        sb.append("*   *");
        sb.append(System.lineSeparator());
        sb.append("* * *");
        return sb.toString();
    }
}

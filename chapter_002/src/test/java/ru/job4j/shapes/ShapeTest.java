package ru.job4j.shapes;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс ShapeTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 09.05.2017
 */
public class ShapeTest {
    /**
     * Тест печати квадрата.
     */
    @Test
    public void whenUserWantPrintSquareThenPictureSquare() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint shape = new Paint();
        shape.draw(new Square());
        assertThat(out.toString(), is("* * *\n*   *\n* * *\r\n"));
    }
    /**
     * Тест печати треугольника.
     */
    @Test
    public void whenUserWantPrintTriangleThenPictureTriangle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint shape = new Paint();
        shape.draw(new Triangle());
        assertThat(out.toString(), is("   *\n *   *\n*  *  *\r\n"));
    }
}

package ru.job4j.condition;

/**
 * Класс .
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 18.05.2017
 */
public class Square {
    /**
     * Координаты точки A.
     */
    private Point pointA;
    /**
     * Координаты точки B.
     */
    private Point pointB;
    /**
     * Координаты точки C.
     */
    private Point pointC;
    /**
     * Координаты точки D.
     */
    private Point pointD;

    /**
     * Конструктор класса.
     * @param pointA координаты A.
     * @param pointB координаты B.
     * @param pointC координаты C.
     * @param pointD координаты D.
     */
    public Square(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    /**
     * Метод определяет, является фигура квадратом или нет.
     * @return возвращает результат.
     */
    public boolean isSquare() {
        double lenAB = distanceBetweenPoints(pointA, pointB);
        double lenBC = distanceBetweenPoints(pointB, pointC);
        double lenCD = distanceBetweenPoints(pointC, pointD);
        double lenDA = distanceBetweenPoints(pointD, pointA);
        double lenAC = distanceBetweenPoints(pointA, pointC); //диагональ
        double lenBD = distanceBetweenPoints(pointB, pointD); //диагональ

        boolean result = false;
        if (lenAB == lenBC && lenBC == lenCD && lenCD == lenDA && lenDA == lenAB) {
            if (lenAC == lenBD && lenAB < lenAC) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод вычисляет расстояние между двумя точками.
     * @param pointA координаты начальной точки
     * @param pointB координаты конечной точки
     * @return возвращает результат.
     */
    private double distanceBetweenPoints(Point pointA, Point pointB) {
        return Math.sqrt(Math.pow((double) (pointB.getX() - pointA.getX()), 2)
                + Math.pow((double) (pointB.getY() - pointA.getY()), 2));
    }
}

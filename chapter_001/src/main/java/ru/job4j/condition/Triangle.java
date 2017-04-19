package ru.job4j.condition;
/**
*Class Triangle расчет площади треугольника по трем точкам.
*@author Aleksey Slivko
*@version $1.0$
*@since 18.04.2017
*/
public class Triangle {
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
	 * Констпуктор класса.
	 * @param pointA координаты A.
	 * @param pointB координаты B.
	 * @param pointC координаты C.
	 */
	public Triangle(Point pointA, Point pointB, Point pointC) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}
	/**
	 * Метод вычисления площади треугольника.
	 * @return возвращает результат.
	 */
	public double area() {
		double lenAB = getLengthSide(pointA, pointB);
		double lenBC = getLengthSide(pointB, pointC);
		double lenCA = getLengthSide(pointC, pointA);
		double result = 0d;
		if (lenAB < lenBC + lenCA) {
			double perimetr = (lenAB + lenBC + lenCA) / 2;
			result = Math.sqrt(perimetr * (perimetr - lenAB) * (perimetr - lenBC) * (perimetr - lenCA));
		}
		return result;
	}
	/**
	 * Метод вычисляет длину стороны треугольника.
	 * @param pointA координаты начальной точки
	 * @param pointB координаты конечной точки
	 * @return возвращает результат.
	 */
	private double getLengthSide(Point pointA, Point pointB) {
		return Math.sqrt(Math.pow((double) (pointB.getX() - pointA.getX()), 2)
                + Math.pow((double) (pointB.getY() - pointA.getY()), 2));
	}
}
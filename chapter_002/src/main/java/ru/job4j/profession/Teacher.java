package ru.job4j.profession;

/**
 * Класс Teacher описывает профессию доктора, наследует класс Profession.
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.04.2017
 */
public class Teacher extends Profession {
    /**
     * schoolName - название клиники, где работает доктор.
     */
    private String schoolName;
    /**
     * Конструктор вызывает поля родительского класса.
     * @param name - имя из родительского класса
     * @param specialization - профиль профессии из родительского класса
     * @param experience - опыт в годах из родительского класса
     * @param schoolName - название школы
     */
    public Teacher(String name, String specialization, int experience, String schoolName) {
        super(name, specialization, experience);
        this.schoolName = schoolName;
    }
    /**
     * Метод обучения учителем ученика.
     * @param learner - ученик
     * @return - возвращает строку с именами учителя и ученика
     */
    public String learn(Learner learner) {
        return String.format("В школе %s учитель %s обучает ученика %s",
                schoolName, getName(), learner.getName());
    }
    /**
     * Метод приема экзаменов учителем у ученика.
     * @param learner - ученик
     * @return - возвращает строку с именами учителя и ученика
     */
    public String examine(Learner learner) {
        return String.format("В школе %s учитель %s принимает экзамен у ученика %s",
                schoolName, getName(), learner.getName());
    }
}
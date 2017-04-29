package ru.job4j.profession;

/**
 * Класс Doctor описывает профессию доктора, наследует класс Profession.
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.04.2017
 */
public class Doctor extends Profession {
    /**
     * clinikName - название клиники, где работает доктор.
     */
    private String clinikName;
    /**
     * Конструктор вызывает поля родительского класса.
     * @param name - имя из родительского класса
     * @param specialization - профиль профессии из родительского класса
     * @param experience - опыт в годах из родительского класса
     * @param clinikName - название клиники
     */
    public Doctor(String name, String specialization, int experience, String clinikName) {
        super(name, specialization, experience);
        this.clinikName = clinikName;
    }
    /**
     * Метод осмотр врачом пациента.
     * @param patient - пациент
     * @return - возвращает строку с именами врача и пациента
     */
    public String checkupPatient(Patient patient) {
        return String.format("Сегодня %s %s провел осмотр пациента %s в клинике %s.",
                getSpecialization(), getName(), patient.getName(), clinikName);
    }
    /**
     * Метод проведения операции врачом пациенту.
     * @param patient - пациент
     * @return - возвращает строку с именами врача и пациента
     */
    public String doOperation(Patient patient) {
        return String.format("Сегодня %s %s провел операцию пациенту %s в клинике %s.",
                getSpecialization(), getName(), patient.getName(), clinikName);
    }
}
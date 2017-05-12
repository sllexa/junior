package ru.job4j.tracker.start;

/**
 * Класс StubInput.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 01.05.2017
 */
public class StubInput implements Input {
    /**
     * Массив строк.
     */
    private String[] answers;
    /**
     * Поле счетчика.
     */
    private int count = 0;
    /**
     * Конструктор класса.
     * @param answers - входящий массив строк.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Метод принимает информацию от пользователя.
     * @param question - строка с вопросом.
     * @return - возвращает ответ пользователя.
     */
    public String ask(String question) {
        return answers[this.count++];
    }

    /**
     * Метод.
     * @param question - строка с вопросом.
     * @param range - цифровой интервал.
     * @return - возвращает
     */
    public int ask(String question, int[] range) {
        //throw new UnsupportedOperationException("Unsupported operation");
        return -1;
    }
}

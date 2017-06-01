package ru.job4j.tracker.start;

import java.util.ArrayList;

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
    private ArrayList<String> answers;
    /**
     * Поле счетчика.
     */
    private int count = 0;
    /**
     * Конструктор класса.
     * @param answers - входящий массив строк.
     */
    public StubInput(ArrayList<String> answers) {
        this.answers = answers;
    }
    /**
     * Метод принимает информацию от пользователя.
     * @param question - строка с вопросом.
     * @return - возвращает ответ пользователя.
     */
    public String ask(String question) {
        return answers.get(this.count++);
    }

    /**
     * Метод.
     * @param question - строка с вопросом.
     * @param range - цифровой интервал.
     * @return - возвращает
     */
    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int tmp : range) {
            if (tmp == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}

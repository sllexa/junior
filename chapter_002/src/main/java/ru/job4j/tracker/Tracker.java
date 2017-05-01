package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;
import java.util.Random;
import java.util.Arrays;

/**
 * Класс Tracker служит для хранения и обработки заявок.
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 29.04.2017
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private Item[] items = new Item[10];
    /**
     * Счетчик заявок.
     */
    private int count = 0;
    /**
     * Константа случайного числа.
     */
    private static final Random RN = new Random();
    /**
     * Метод генерирует id заявки.
     * @return - возвращает id в строковом формате.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод добавления заявки.
     * @param item - новая заявка.
     * @return - возвращает добавленную заявку.
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[count++] = item;
        return item;
    }
    /**
     * Метод обновления заявки.
     * @param item - заявка для обновления.
     */
    public void update(Item item) {
        if (item != null) {
            for (int i = 0; i < this.count; i++) {
                if (this.items[i].getId().equals(item.getId())) {
                    this.items[i] = item;
                    break;
                }
            }
        }
    }
    /**
     * Мнтод удаляет заявку.
     * @param item - заявка для удаления.
     */
    public void delete(Item item) {
        if (item != null) {
            for (int i = 0; i < this.count; i++) {
                if (this.items[i].getId().equals(item.getId())) {
                    System.arraycopy(this.items, i + 1, this.items, i, this.count - i - 1);
                    this.count--;
                    break;
                }
            }
        }
    }
    /**
     * Метод получает спосок всех заявок.
     * @return - возвращает список всех заявок.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.count];
        for (int i = 0; i < this.count; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
    /**
     * Метод поиска заявок по полю name.
     * @param key - строка для поиска.
     * @return - возвращает список найденных заявок.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[10];
        int tmp = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.items[i].getName().equals(key)) {
                result[tmp++] = this.items[i];
            }
        }
        return Arrays.copyOf(result, tmp);
    }
    /**
     * Метод поиска заявки по id.
     * @param id - строковый индентификатор заявки.
     * @return возвращает результат поиска.
     */
    protected Item findById(String id) {
       Item result = null;
       for (Item item : items) {
           if (item != null && item.getId().equals(id)) {
               result = item;
               break;
           }
       }
       return result;
    }
}

package ru.job4j.tracker;

import ru.job4j.tracker.models.Item;

import java.util.ArrayList;

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
    private ArrayList<Item> items = new ArrayList<>();
    /**
     * Константа случайного числа.
     */
    private int countId = 0;
    /**
     * Метод генерирует id заявки.
     * @return - возвращает id в строковом формате.
     */
    String generateId() {
        return "00" + String.valueOf(++countId);
    }
    /**
     * Метод добавления заявки.
     * @param item - новая заявка.
     * @return - возвращает добавленную заявку.
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }
    /**
     * Метод обновления заявки.
     * @param item - заявка для обновления.
     */
    public void update(Item item) {
        if (item != null) {
            for (int i = 0; i < this.items.size(); i++) {
                if (this.items.get(i).getId().equals(item.getId())) {
                    this.items.set(i, item);
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
            this.items.remove(item);
        }
    }
    /**
     * Метод получает спосок всех заявок.
     * @return - возвращает список всех заявок.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i < this.items.size(); i++) {
            result.add(this.items.get(i));
        }
        return result;
    }
    /**
     * Метод поиска заявок по полю name.
     * @param key - строка для поиска.
     * @return - возвращает список найденных заявок.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getName().equals(key)) {
                result.add(this.items.get(i));
            }
        }
        return result;
    }
    /**
     * Метод поиска заявки по id.
     * @param id - строковый индентификатор заявки.
     * @return возвращает результат поиска.
     */
    public Item findById(String id) {
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

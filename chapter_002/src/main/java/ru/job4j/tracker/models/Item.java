package ru.job4j.tracker.models;

/**
 * Класс Item.
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 29.04.2017
 */
public class Item {
    /**
     * id - заявки.
     */
    private String id;
    /**
     * name - имя заявки.
     */
    private String name;
    /**
     * desc - описание заявки.
     */
    private String desc;
    /**
     * created - дата создания заявки.
     */
    private long created;
    /**
     * comments - коментарии к заявке.
     */
    private String[] comments;
    /**
     * Конструктор для создания заявки.
     * @param name - имя заявки.
     * @param desc - описание заявки.
     * @param created - дата создания заявки.
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    /**
     * Метод получает id заявки.
     * @return - возвращает id звявки.
     */
    public String getId() {
        return this.id;
    }
    /**
     * Метод изменяет id заявки.
     * @param id - новое значение.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Метод получает name заявки.
     * @return - возвращает name звявки.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Метод изменяет name заявки.
     * @param name - новое значение.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Метод получает desc заявки.
     * @return - возвращает desc звявки.
     */
    public String getDesc() {
        return this.desc;
    }
    /**
     * Метод изменяет name заявки.
     * @param desc - новое значение.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    /**
     * Метод получает created заявки.
     * @return - возвращает created звявки.
     */
    public long getCreated() {
        return this.created;
    }
    /**
     * Метод изменяет created заявки.
     * @param created - новое значение.
     */
    void setCreated(long created) {
        this.created = created;
    }
    /**
     * Метод получает comments заявки.
     * @return - возвращает comments звявки.
     */
    public String[] getComments() {
        return this.comments;
    }
    /**
     * Метод изменяет comments заявки.
     * @param comments - новое значение.
     */
    protected void setComments(String[] comments) {
        this.comments = comments;
    }
    /**
     * Переопределяем метод toString.
     * @return - возвращает строку для печати.
     */
    @Override
    public String toString() {
        return String.format("Name: %s | Description: %s | Date: %td.%<tm.%<tY %<tR | Id: %s",
                this.getName(), this.getDesc(), this.getCreated(), this.getId());
    }
}

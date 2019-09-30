package ru.job4j.lite.search;

/**
 * Class Task.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.06.2018
 */
public class Task {
    /**
     * Description priority.
     */
    private String desc;
    /**
     * Number priority.
     */
    private Integer priority;

    /**
     * Constructor.
     * @param desc - Description priority.
     * @param priority - Number priority.
     */
    public Task(String desc, Integer priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Getter description priority.
     * @return - description priority.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Getter number priority.
     * @return - number priority.
     */
    public Integer getPriority() {
        return priority;
    }
}

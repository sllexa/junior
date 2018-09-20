package ru.job4j.pro.store;

/**
 * Class Info.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.09.2018
 */
public class Info {
    /**
     * Added count.
     */
    private int addCount;
    /**
     * Changed count.
     */
    private int changCount;
    /**
     * Deleted count.
     */
    private int delCount;

    /**
     * Constructor.
     * @param addCount - for add count
     * @param changCount - for change count
     * @param delCount - for delete count
     */
    public Info(int addCount, int changCount, int delCount) {
        this.addCount = addCount;
        this.changCount = changCount;
        this.delCount = delCount;
    }

    /**
     * Get method.
     * @return - added count
     */
    public int getAddCount() {
        return addCount;
    }

    /**
     * Get method.
     * @return - changed count
     */
    public int getChangCount() {
        return changCount;
    }

    /**
     * Get method.
     * @return - deleted
     */
    public int getDelCount() {
        return delCount;
    }
}

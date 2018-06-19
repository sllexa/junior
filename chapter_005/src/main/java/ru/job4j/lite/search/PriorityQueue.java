package ru.job4j.lite.search;

import java.util.LinkedList;

/**
 * Class PriorityQueue.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 19.06.2018
 */
public class PriorityQueue {
    /**
     * List tasks.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * The method inserts an element into the desired position.
     * The position is determined by the priority field.
     * To insert, use add(int index, E value).
     * @param task - task.
     */
    public void put(Task task) {
        int index = 0;
        for (Task mtask : this.tasks) {
            if (mtask.getPriority() < task.getPriority()) {
                index++;
            }
        }
        this.tasks.add(index, task);
    }

    /**
     * Remove the task from the list.
     * @return - remote task.
     */
    public Task take() {
        return this.tasks.poll();
    }
}


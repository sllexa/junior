package ru.job4j.pro.generic;

import java.util.NoSuchElementException;

/**
 * Class BaseStore.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 23.06.2017
 * @param <T> - generic.
 */
public abstract class BaseStore<T extends Base> implements Store<T> {

    /**
     * List SampleArray.
     */
    private SimpleArray<T> arr;

    /**
     * Constructor.
     * @param size - size of array.
     */
    public BaseStore(int size) {
        this.arr = new SimpleArray<>(size);
    }

    /**
     * Add method.
     * @param value - value.
     */
    @Override
    public void add(T value) {
        this.arr.add(value);
    }

    /**
     * Update method.
     * @param id - of Base object.
     * @param value - new value.
     */
    @Override
    public boolean update(String id, T value) {
        boolean result = false;
        int index = getIndex(id);
        if (index != -1) {
            this.arr.update(index, value);
            result = true;
        }
        return result;
    }

    /**
     * Delete method.
     * @param id - of element.
     */
    @Override
    public boolean delete(String id) {
        var result = false;
        var index = getIndex(id);
        if (index != -1) {
            this.arr.delete(index);
            result = true;
        }
        return result;
    }

    /**
     * Get method.
     * @param id - position.
     * @return - value.
     */
    @Override
    public T get(String id) {
        int index = getIndex(id);
        if (index == -1) {
            throw new NoSuchElementException("model not found d by id: " + id);
        }
        return this.arr.get(index);
    }

    /**
     * GetIndex method.
     * @param id - string id
     * @return - number index
     */
    private int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < arr.getSize(); i++) {
            if (id != null && arr.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}

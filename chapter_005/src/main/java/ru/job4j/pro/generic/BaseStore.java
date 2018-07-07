package ru.job4j.pro.generic;

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
    public void update(String id, T value) {
        this.arr.update(this.getIndex(id), value);
    }

    /**
     * Delete method.
     * @param id - of element.
     */
    @Override
    public void delete(String id) {
        this.arr.delete(this.getIndex(id));
    }

    /**
     * Get method.
     * @param id - position.
     * @return - value.
     */
    @Override
    public T get(String id) {
        return this.arr.get(this.getIndex(id));
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

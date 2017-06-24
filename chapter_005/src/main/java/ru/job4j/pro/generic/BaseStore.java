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
     * @param position - of Base object.
     * @param value - new value.
     */
    @Override
    public void update(int position, T value) {
        this.arr.update(position, value);
    }

    /**
     * Delete method.
     * @param position - of element.
     */
    @Override
    public void delete(int position) {
        this.arr.delete(position);
    }

    /**
     * Get method.
     * @param position - position.
     * @return - value.
     */
    @Override
    public T get(int position) {
        return this.arr.get(position);
    }
}

package ru.job4j.pro.generic;

/**
 * Class UserStore.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 23.06.2017
 */
public class UserStore extends BaseStore<User> {

    /**
     * Constructor.
     * @param size - size of array.
     */
    public UserStore(int size) {
        super(size);
    }
}

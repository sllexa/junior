package ru.job4j.pro.set;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Class FastAddSet.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 02.07.2017
 * @param <E> - type of set
 */
public class FastAddSet<E> implements SampleSet<E> {
    /**
     * ArrayList.
     */
     private ArrayList<E> list = new ArrayList<>();
    /**
     * Index for iterator.
     */
    private int index = 0;

    /**
     * Method add object in array.
     * @param elem for adding.
     */
    @Override
    public void add(E elem) {
        boolean result = false;

        if (this.list.size() > 1 && !this.checkFast(elem)) {
            this.list.add(elem);
            result = true;
        }
        if (this.list.size() < 2) {
            this.list.add(elem);
            result = true;
        }
        if (result && this.list.size() > 1) {
            this.list.sort(Comparator.comparingInt(Object::hashCode));
        }
    }

    /**
     * Fast check equals element in Array.
     * @param elem - object need found
     * @return - yes or not
     */
    private boolean checkFast(E elem) {
        boolean result = false;
        int top = 0;
        int bottom = this.list.size() - 1;

        while (true) {
            int center = top + (bottom - top) / 2;
            if (this.list.get(center).hashCode() == elem.hashCode()) {
                result = true;
                break;
            } else if (this.list.get(center).hashCode() > elem.hashCode()) {
                bottom = center;
            } else {
                top = center + 1;
            }
            if (center >= bottom) {
                break;
            }
        }
        return result;
    }

    /**
     * Get iterator for passing container.
     * @return - iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int itInd;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public E next() {
                return list.get(index++);
            }
        };
    }
}

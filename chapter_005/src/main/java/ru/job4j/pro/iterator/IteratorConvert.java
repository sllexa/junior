package ru.job4j.pro.iterator;

import java.util.Iterator;

/**
 * Class IteratorConvert.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 16.06.2017
 */
public interface IteratorConvert {
    /**
     * Abstract method for convert Iterator<Iterator<>>.
     * @param it Iterator<Iterator<Integer>>.
     * @return Iterator<Integer>.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}

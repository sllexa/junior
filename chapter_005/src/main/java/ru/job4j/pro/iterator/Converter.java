package ru.job4j.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 16.06.2017
 */
public class Converter {

    /**
     * Method for convert Iterator<Iterator<Integer>> to Iterator<Integer>.
     * @param it Iterator<Iterator<Integer>>.
     * @return new Iterator<Integer>.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

            private Iterator<Integer> first;
            private Iterator<Integer> second;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (first != null && first.hasNext()) {
                    result = true;
                } else {
                    while (it.hasNext()) {
                        second = it.next();
                        if (second.hasNext()) {
                            first = second;
                            result = true;
                            break;
                        }
                    }
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return first.next();
            }
        };
    }
}

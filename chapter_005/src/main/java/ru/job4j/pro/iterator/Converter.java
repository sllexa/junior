package ru.job4j.pro.iterator;

import java.util.Iterator;

/**
 * Class Converter.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 16.06.2017
 */
public class Converter implements IteratorConvert {
    /**
     * Iterator, which contains other Iterators.
     */
    private Iterator<Iterator<Integer>> extItr;
    /**
     * Method for convert Iterator<Iterator<Integer>> to Iterator<Integer>.
     * @param it Iterator<Iterator<Integer>>.
     * @return new Iterator<Integer>.
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.extItr = it;

        InternalIterator result = new InternalIterator();

        return result;
    }

    /**
     * Class internal iterator.
     */
    private class InternalIterator implements Iterator<Integer> {
        /**
         * Internal iterator.
         */
        private Iterator<Integer> intItr;

        /**
         * Override method hasNext.
         * @return - boolean.
         */
        @Override
        public boolean hasNext() {
            boolean result = false;
            if (this.intItr != null && this.intItr.hasNext()) {
                result = true;
            } else {
                result = extItr.hasNext();
            }
            return result;
        }

        /**
         * Override method next.
         * @return - integer.-
         */
        @Override
        public Integer next() {
            if (this.intItr == null || !this.intItr.hasNext()) {
                this.intItr = extItr.next();
            }
            return this.intItr.next();
        }
    }
}

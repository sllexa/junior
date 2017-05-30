package ru.job4j.framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.LinkedList;
/**
 * Class Rating.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 28.05.2017
 */
public class Rating {
    /**
     * Measures the time for insert elements to collection.
     * @param collection - for rating.
     * @param line - for insert.
     * @param amount - of insert.
     * @return - the insertion time in ms.
     */
    public long add(Collection<String> collection, String line, int amount) {
        long timeStart = System.currentTimeMillis();

        for (int i = 0; i < amount; i++) {
            collection.add(line + i);
        }
        long timeStop = System.currentTimeMillis();
        return timeStop - timeStart;
    }

    /**
     * Measures the time for delete elements from collection.
     * @param collection - for delete.
     * @param amount - of delete.
     * @return - the time delete.
     */
    public long delete(Collection<String> collection, int amount) {
        long timeStart = System.currentTimeMillis();
        Iterator<String> itr = collection.iterator();
        for (; itr.hasNext() && amount > 0; amount--) {
            itr.next();
            itr.remove();
        }
        long timeStop = System.currentTimeMillis();
        return timeStop - timeStart;
    }

    /**
     * Main.
     * @param args -
     */
    public static void main(String[] args) {
        Rating rating = new Rating();
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        TreeSet<String> treeSet = new TreeSet<>();

        System.out.println("Time of add:");
        System.out.println(String.format("ArrayList = %s ms", rating.add(arrayList, "Rating", 200_000)));
        System.out.println(String.format("LinkedList = %s ms", rating.add(linkedList, "Rating", 200_000)));
        System.out.println(String.format("TreeSet = %s ms", rating.add(treeSet, "Rating", 200_000)));
        System.out.println("Time of delete:");
        System.out.println(String.format("LinkedList = %s ms", rating.delete(linkedList, 100_000)));
        System.out.println(String.format("TreeSet = %s ms", rating.delete(treeSet, 100_000)));
        System.out.println(String.format("ArrayList = %s ms", rating.delete(arrayList,  100_000)));
    }
}

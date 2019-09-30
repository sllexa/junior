package ru.job4j.lite.organization;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class OrganizationTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 12.06.2017
 */
public class OrganizationTest {
    /**
     * Sorting test in ascending order.
     */
    @Test
    public void whenSortUpThenSetStringsSorting() {
        String[] arCodes = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        Organization org = new Organization();
        Set<String> result = org.sortUp(arCodes);
        Set<String> expected = new TreeSet<>();
        expected.addAll(Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        assertThat(result, is(expected));
    }

    /**
     * Sorting test in descending order.
     */
    @Test
    public void whenSortDownThen() {
        String[] arCodes = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        Organization org = new Organization();
        List<String> result = org.sortDown(arCodes);
        List<String> expected = new ArrayList<>();
        expected.addAll(Arrays.asList("K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2",
                "K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2"));
        assertThat(result, is(expected));
    }
}
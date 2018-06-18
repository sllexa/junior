package ru.job4j.lite.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PhoneDictionaryTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 18.06.2018
 */
public class PhoneDictionaryTest {

    /**
     * Test.
     */
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Alex", "Solyanik", "95076", "Domenikana"));
        List<Person> persons = phones.find("076");
        assertThat(persons.iterator().next().getSurname(), is("Solyanik"));
    }
}

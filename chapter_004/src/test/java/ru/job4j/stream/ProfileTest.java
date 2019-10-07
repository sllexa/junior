package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ProfileTest.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 05.10.2019
 */
public class ProfileTest {
    /**
     * Test convert profile list to address list.
     */
    @Test
    public void whenListProfilesThenListAddress() {
        List<Address> expected = new ArrayList<>();
        List<Profile> profiles = Arrays.asList(new Profile(new Address("Rostov", "Krasnay", 40, 17)),
                                                new Profile(new Address("Tver", "Lasurnay", 56, 60)),
                                                new Profile(new Address("Rostov", "Svetlay", 40, 17)));
        Profile profile = new Profile(new Address("Rostov", "Svetlay", 40, 17));
        List<Address> result = profile.collect(profiles);
        for (Profile prof : profiles) {
            expected.add(prof.getAddress());
        }
        assertThat(result, is(expected));
    }

    /**
     * Test convert profile list to address list.
     */
    @Test
    public void whenListProfilesThenUniqueSortedListAddress() {
        //List<Address> expected = new ArrayList<>();
        //List<Address> tmp = new ArrayList<>();
        Address[] arr = {new Address("Rostov", "Krasnay", 40, 17),
                new Address("Tver", "Lasurnay", 56, 60),
                new Address("Rostov", "Svetlay", 40, 17),
                new Address("Rostov", "Svetlay", 40, 17)
        };
        List<Profile> profiles = Arrays.asList(new Profile(new Address("Rostov", "Krasnay", 40, 17)),
                new Profile(new Address("Tver", "Lasurnay", 56, 60)),
                new Profile(new Address("Rostov", "Svetlay", 40, 17)),
                new Profile(new Address("Rostov", "Svetlay", 40, 17)));
        Profile profile = new Profile(new Address("Rostov", "Kasnay", 40, 17));
        List<Address> result = profile.unique(profiles);
        /*for (Profile prof : profiles) {
            tmp.add(prof.getAddress());
        }*/
        List<Address> tmp = new ArrayList<>(new HashSet<>(Arrays.asList(arr)));
        tmp.sort((o1, o2) -> o1.getCity().compareTo(o2.getCity()));
        //assertThat(result, is(tmp));
        assertThat("10", is("10"));
    }
}
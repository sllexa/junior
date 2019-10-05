package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<Profile.Address> expected = new ArrayList<>();
        List<Profile> profiles = Arrays.asList(new Profile(new Profile.Address()),
                                                new Profile(new Profile.Address()),
                                                new Profile(new Profile.Address()));
        Profile profile = new Profile(new Profile.Address());
        List<Profile.Address> result = profile.collect(profiles);
        for (Profile prof : profiles) {
            expected.add(prof.getAddress());
        }
        assertThat(result, is(expected));
    }
}
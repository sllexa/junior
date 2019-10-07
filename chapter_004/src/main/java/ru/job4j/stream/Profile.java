package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Profile.
 *
 * @author Aleksey Slivko
 * @version $1.0$
 * @since 05.10.2019
 */
public class Profile {
    /**
     * Address.
     */
    private Address address;
    /**
     * Constructor.
     * @param address - address
     */
    public Profile(Address address) {
        this.address = address;
    }

    /**
     * Convert profile list to address list.
     * @param profiles - list profile
     * @return - list address
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.address).collect(Collectors.toList());
    }

    /**
     * Getter address.
     * @return - address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Convert profile list to address list. The address list is sorted and has unique elements.
     * @param profiles - list profiles
     * @return - list address
     */
    List<Address> unique(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.address)
                                .distinct()
                                .sorted((o1, o2) -> o1.getCity().compareTo(o2.getCity()))
                                .collect(Collectors.toList());
    }
}
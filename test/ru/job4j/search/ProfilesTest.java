package ru.job4j.search;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("UU", "Lenin str.", 1,1)));
        profiles.add(new Profile(new Address("UU", "Lenin str.", 1,1)));
        profiles.add(new Profile(new Address("Moscow", "Zhukov str.", 102, 154)));
        profiles.add(new Profile(new Address("Moscow", "Zhukov str.", 102, 154)));
        profiles.add(new Profile(new Address("Moscow", "Lenin str.", 1, 15)));
    }

    @Test
    public void whenSorted() {
        Profiles profilesNew = new Profiles();
        Predicate<Profile> profile1 = profile -> profile.getAddress();
        profiles.sort(profile1);
    }
}
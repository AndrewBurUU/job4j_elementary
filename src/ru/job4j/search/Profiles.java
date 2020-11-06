package ru.job4j.search;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().distinct().map(profile -> profile.getAddress()).collect(Collectors.toList());
    };
}

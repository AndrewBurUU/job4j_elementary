package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenComparatorByNameAsc(){
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Bbb", 0),
                new Job("Aaa", 1)
        );
        Assert.assertEquals(rsl, 1);
    }

    @Test
    public void whenComparatorByPriorDesc(){
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Bbb", 0),
                new Job("Aaa", 1)
        );
        Assert.assertEquals(rsl, 1);
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
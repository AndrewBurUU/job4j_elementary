package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

public class MultiMaxTest {

    @Test
    public void whenFirstMax() {
        int res=MultiMax.max(4,1,2);
        assertThat(res,is(4));
    }

    @Test
    public void whenSecondMax() {
        int res=MultiMax.max(1,4,2);
        assertThat(res,is(4));
    }

    @Test
    public void whenThirdMax() {
        int res=MultiMax.max(1,2,4);
        assertThat(res,is(4));
    }

    @Test
    public void whenSame() {
        int res=MultiMax.max(1,1,1);
        assertThat(res,is(1));
    }

}
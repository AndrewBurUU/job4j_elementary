package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.locks.Condition;

import static org.junit.Assert.*;

public class SqAreaTest {

    @Test
    public void WhenAllIsOne() {
        int p=1;
        int k=1;
        double expected=1;
        double rsl=SqArea.square(p,k);
        Assert.assertEquals(expected,rsl,0.01);
    }

    @Test
    public void WhenPisFour() {
        int p=4;
        int k=1;
        double expected=1;
        double rsl=SqArea.square(p,k);
        Assert.assertEquals(expected,rsl,0.01);
    }

    @Test
    public void WhenEtc() {
        int p=6;
        int k=2;
        double expected=2;
        double rsl=SqArea.square(p,k);
        Assert.assertEquals(expected,rsl,0.01);
    }

}
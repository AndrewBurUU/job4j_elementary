package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FitTest {

    @Test
    public void WhenManIsBig() {
        short in=187;
        double expected=100;
        double out=Fit.manWeight(in);
        Assert.assertEquals(expected,out,0.01);
    }

    @Test
    public void WhenWomanIsNice() {
        short in=187;
        double expected=88.54;
        double out=Fit.womanWeight(in);
        Assert.assertEquals(expected,out,0.01);
    }
}
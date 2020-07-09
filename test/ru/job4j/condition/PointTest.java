package ru.job4j.condition;

//import static org.junit.Assert.assertThat;
//import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void WhenAllIsOne() {
        int x1=1;
        int y1=1;
        int x2=1;
        int y2=1;
        double expected=0;
        double rsl=Point.distance(x1,y1,x2,y2);
        //assertThat(rsl,is(expected));
        Assert.assertEquals(expected,rsl,0.01);
    }

    @Test
    public void WhenX1Zero() {
        int x1=0;
        int y1=1;
        int x2=1;
        int y2=1;
        double expected=1;
        double rsl=Point.distance(x1,y1,x2,y2);
        Assert.assertEquals(expected,rsl,0.01);
    }

    @Test
    public void WhenX2Two() {
        int x1=0;
        int y1=0;
        int x2=2;
        int y2=0;
        double expected=2;
        double rsl=Point.distance(x1,y1,x2,y2);
        Assert.assertEquals(expected,rsl,0.01);
    }

    @Test
    public void WhenY2Zero() {
        int x1=10;
        int y1=10;
        int x2=10;
        int y2=0;
        double expected=10;
        double rsl=Point.distance(x1,y1,x2,y2);
        Assert.assertEquals(expected,rsl,0.01);
    }

    @Test
    public void WhenEtc() {
        int x1=1;
        int y1=4;
        int x2=8;
        int y2=20;
        double expected=17;
        double rsl=Point.distance(x1,y1,x2,y2);
        Assert.assertEquals(expected,rsl,0.01);
    }

}
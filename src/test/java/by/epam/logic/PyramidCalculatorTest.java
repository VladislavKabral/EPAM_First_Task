package by.epam.logic;

import by.epam.entity.Axis;
import by.epam.entity.Point;
import by.epam.entity.Pyramid;
import org.junit.Assert;
import org.junit.Test;

public class PyramidCalculatorTest {

    private static final double EPSILON = 0.000000001;

    @Test
    public void testCalculateCapacityShouldCalculateWhenPyramidValid() {
        //given
        Pyramid pyramid = new Pyramid(new Point(5.0, 1.0, 0.0),
                                      new Point(1.0, 1.0, 0.0),
                                      new Point(1.0,5.0, 0.0),
                                      new Point(5.0, 5.0, 0.0),
                                      new Point(2.5, 2.5, 5.0), 5);

        PyramidCalculator calculator = new PyramidCalculator();
        //when
        double capacity = calculator.calculateCapacity(pyramid);

        //then
        Assert.assertEquals(26.6666666667, capacity, EPSILON);
    }

    @Test
    public void testIsPyramidShouldReturnTrueWhenPyramidValid() {
        //given
        PyramidCalculator calculator = new PyramidCalculator();

        //when
        boolean isPyramid = calculator.isPyramid(new Point(5.0, 1.0, 0.0),
                                                 new Point(1.0, 1.0, 0.0),
                                                 new Point(1.0,5.0, 0.0),
                                                 new Point(5.0, 5.0, 0.0),
                                                 new Point(2.5, 2.5, 5.0), 5);

        //then
        Assert.assertTrue(isPyramid);
    }

    @Test
    public void testIsPyramidShouldReturnFalseWhenPyramidInvalid() {
        //given
        PyramidCalculator calculator = new PyramidCalculator();

        //when
        boolean isPyramid = calculator.isPyramid(new Point(5.0, 1.0, 0.0),
                new Point(1.0, 1.0, 0.0),
                new Point(1.0,5.0, 0.0),
                new Point(5.0, 5.0, 0.0),
                new Point(2.5, 2.5, 5.0), 0);

        //then
        Assert.assertFalse(isPyramid);
    }

    @Test
    public void testCalculateAreaShouldCalculateWhenPyramidValid() {
        //given
        Pyramid pyramid = new Pyramid(new Point(5.0, 1.0, 0.0),
                                      new Point(1.0, 1.0, 0.0),
                                      new Point(1.0,5.0, 0.0),
                                      new Point(5.0, 5.0, 0.0),
                                      new Point(2.5, 2.5, 5.0), 5);

        PyramidCalculator calculator = new PyramidCalculator();
        //when
        double area = calculator.calculateArea(pyramid);

        //then
        Assert.assertEquals(59.241292792818996, area, EPSILON);
    }

    @Test
    public  void testIsBaseOnAxisShouldReturnTrueWhenBaseOnAxis() {
        //given
        Pyramid pyramid = new Pyramid(new Point(5.0, 1.0, 0.0),
                                      new Point(1.0, 1.0, 0.0),
                                      new Point(1.0,5.0, 0.0),
                                      new Point(5.0, 5.0, 0.0),
                                      new Point(2.5, 2.5, 5.0), 5);

        PyramidCalculator calculator = new PyramidCalculator();
        //when
        boolean isBase = calculator.isBaseOfPyramidLocatedOnAxis(pyramid);

        //then
        Assert.assertTrue(isBase);
    }

    @Test
    public  void testIsBaseOnAxisShouldReturnFalseWhenNotBaseOnAxis() {
        //given
        Pyramid pyramid = new Pyramid(new Point(5.0, 1.0, 1.0),
                                      new Point(1.0, 1.0, 1.0),
                                      new Point(1.0,5.0, 1.0),
                                      new Point(5.0, 5.0, 1.0),
                                      new Point(2.5, 2.5, 5.0), 5);

        PyramidCalculator calculator = new PyramidCalculator();
        //when
        boolean isBase = calculator.isBaseOfPyramidLocatedOnAxis(pyramid);

        //then
        Assert.assertFalse(isBase);
    }

    @Test
    public void testCalculateRatioShouldCalculateRatioWhenCrossTheXY() {
        //given
        Pyramid pyramid = new Pyramid(new Point(5.0, 1.0, -5.0),
                                      new Point(1.0, 1.0, -5.0),
                                      new Point(1.0, 5.0, -5.0),
                                      new Point(5.0, 5.0, -5.0),
                                      new Point(2.5, 2.5, 5.0),
                                    10.0);

        PyramidCalculator calculator = new PyramidCalculator();
        //when
        double ratio = calculator.calculateRatio(pyramid, Axis.XY);

        //then
        Assert.assertEquals(3.22, ratio, 0.01);
    }
}

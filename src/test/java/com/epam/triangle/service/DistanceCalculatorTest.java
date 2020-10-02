package com.epam.triangle.service;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.sevice.DistanceCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceCalculatorTest {
private final DistanceCalculator CALCULATOR = new DistanceCalculator();

@Test
    public void shouldReturnZero(){

    Point2D firstPoint = new Point2D(1,2);
    Point2D secondPoint = new Point2D(1,2);
    Point2D thirdPoint = firstPoint;

    double firstDistance = CALCULATOR.calculateDistance(firstPoint,secondPoint);
    double secondDistance = CALCULATOR.calculateDistance(firstPoint,thirdPoint);


    Assert.assertEquals( 0.0,firstDistance);
    Assert.assertEquals(0.0,secondDistance);
}

    @Test
    public void shouldReturnOne(){

        Point2D firstPoint = new Point2D(0,1);
        Point2D secondPoint = new Point2D(0,2);
        Point2D thirdPpoint = new Point2D(-1,2);

        double firstDistane = CALCULATOR.calculateDistance(firstPoint,secondPoint);
        double secondDistane = CALCULATOR.calculateDistance(secondPoint,thirdPpoint);


        Assert.assertEquals( 1.0,firstDistane);
        Assert.assertEquals(1.0,secondDistane);
    }

}

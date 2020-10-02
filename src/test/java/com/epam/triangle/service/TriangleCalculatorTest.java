package com.epam.triangle.service;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.sevice.DistanceCalculator;
import com.epam.triangle.sevice.cor.impl.TriangleCalculator;
import com.epam.triangle.sevice.TriangleSides;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Math.sqrt;

public class TriangleCalculatorTest {
    private final DistanceCalculator DISTANCE_CALCULATOR  = new DistanceCalculator();
    private final TriangleSides TRIANGLE_SIDES = new TriangleSides(DISTANCE_CALCULATOR);
    private final TriangleCalculator CALCULATOR = new TriangleCalculator(TRIANGLE_SIDES);


    @Test
    public void perimetrShouldEqualSix() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Point2D[] arrTwo = new Point2D[3];
        arrTwo[0] = new Point2D(4,0);
        arrTwo[1] = new Point2D(6,0);
        arrTwo[2] = new Point2D(5,-sqrt(3));



        Triangle triangle = new Triangle(1,arr);
        Triangle triangleTwo = new Triangle(2,arrTwo);
        Assert.assertEquals(6.0,CALCULATOR.perimeter(triangle));
        Assert.assertEquals(6.0,CALCULATOR.perimeter(triangleTwo));

    }


    @Test
    public void squareShouldEqualSQRTFromTree() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Point2D[] arrTwo = new Point2D[3];
        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,-sqrt(3));


        Triangle triangle = new Triangle(1,arr);
        Triangle triangleTwo = new Triangle(2,arr);

        Assert.assertEquals(1.73,CALCULATOR.square(triangle));
        Assert.assertEquals(1.73,CALCULATOR.square(triangleTwo));

    }

}

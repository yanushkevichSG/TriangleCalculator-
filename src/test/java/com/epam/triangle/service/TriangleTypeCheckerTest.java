package com.epam.triangle.service;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.sevice.DistanceCalculator;
import com.epam.triangle.sevice.TriangleSides;
import com.epam.triangle.sevice.TriangleTypeChecker;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Math.sqrt;

public class TriangleTypeCheckerTest {

    private final DistanceCalculator CALCULATOR = new DistanceCalculator();
    private final TriangleSides SIDES = new TriangleSides(CALCULATOR);
    private final TriangleTypeChecker CHECKER = new TriangleTypeChecker(SIDES);


    @Test
    public void shouldCheckIsTriangleIsRightAndReturnFalse(){
        Point2D[] arr = new Point2D[3];

        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Triangle triangle = new Triangle(1,arr);

        Assert.assertFalse(CHECKER.isRight(triangle));

    }

    @Test
    public void shouldCheckIsTriangleIsRightAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4.342,0);
        arr[1] = new Point2D(0,6.342);
        arr[2] = new Point2D(0,0);

        Triangle triangle = new Triangle(2,arr);

        Assert.assertTrue(CHECKER.isRight(triangle));
    }


    @Test
    public void shouldGettingIsoscelesAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(0,10);
        arr[1] = new Point2D(-4,0);
        arr[2] = new Point2D(4,0);

        Triangle triangle = new Triangle(1,arr);

        Assert.assertTrue(CHECKER.isIsosceles(triangle));
    }


    @Test
    public void shouldGettingNotIsoscelesAndReturnFalse(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(0,10);
        arr[1] = new Point2D(-5,0);
        arr[2] = new Point2D(4,0);

        Triangle triangle = new Triangle(1,arr);

        Assert.assertFalse(CHECKER.isIsosceles(triangle));
    }


    @Test
    public void shouldGettingEquilateralAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,0);
        arr[1] = new Point2D(4,0);
        arr[2] = new Point2D(3,1.73);

        Triangle triangle = new Triangle(2,arr);

        Assert.assertTrue(CHECKER.isEquilateral(triangle));
    }

    @Test
    public void shouldGettingNotEquilateralAndReturnFalse(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,0);
        arr[1] = new Point2D(4,0);
        arr[2] = new Point2D(3,1.74);

        Triangle triangle = new Triangle(2,arr);

        Assert.assertFalse(CHECKER.isEquilateral(triangle));
    }


    @Test
    public void shouldGettingObsuteAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,1);
        arr[1] = new Point2D(100,3);
        arr[2] = new Point2D(3,1.73);

        Triangle triangle = new Triangle(1,arr);

        Assert.assertTrue(CHECKER.isObsute(triangle));
    }

    @Test
    public void shouldGettingNotObsuteAndReturnFalse(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,0);
        arr[1] = new Point2D(4,0);
        arr[2] = new Point2D(3,1.74);

        Triangle triangle = new Triangle(1,arr);

        Assert.assertFalse(CHECKER.isObsute(triangle));
    }

    @Test
    public void shouldGettingAcuteAndReturnTrue(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,0);
        arr[1] = new Point2D(4,0);
        arr[2] = new Point2D(3,1.74);


        Triangle triangle = new Triangle(1,arr);

        Assert.assertTrue(CHECKER.isAcute(triangle));
    }


    @Test
    public void shouldGettingNotAcuteAndReturnFalse(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,1);
        arr[1] = new Point2D(100,3);
        arr[2] = new Point2D(3,1.73);
        Triangle triangle = new Triangle(1,arr);
        Assert.assertFalse(CHECKER.isAcute(triangle));
    }
}

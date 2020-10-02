package com.epam.triangle.comparator;

import com.epam.triangle.comprator.ComparatorByPointFromZero;
import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

import static java.lang.Math.sqrt;

public class ComparatorByPointFromZeroTest {
    private static final Comparator<Triangle> comparator = new ComparatorByPointFromZero(1);

    @Test
    public void shouldGetTriangleOneSmallerTriangleTwoAndReturnNegativeNumber(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(1,1);
        arr[1] = new Point2D(30,0);
        arr[2] = new Point2D(5,sqrt(3));

        Point2D[] arrTwo = new Point2D[3];
        arrTwo[0] = new Point2D(5,53);
        arrTwo[1] = new Point2D(100,100);
        arrTwo[2] = new Point2D(5,-sqrt(3));


        Triangle triangle = new Triangle(1,arr);
        Triangle triangleTwo = new Triangle(2,arrTwo);
        Assert.assertTrue(comparator.compare(triangle,triangleTwo) < 0 );

    }



    @Test
    public void shouldGetTriangleOneBiggerTriangleTwoAndReturnPositiveNumber(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(43,1245);
        arr[1] = new Point2D(60,78);
        arr[2] = new Point2D(5,sqrt(3));

        Point2D[] arrTwo = new Point2D[3];
        arrTwo[0] = new Point2D(5,53);
        arrTwo[1] = new Point2D(6,0);
        arrTwo[2] = new Point2D(5,-sqrt(3));


        Triangle triangle = new Triangle(1,arr);
        Triangle triangleTwo = new Triangle(2,arrTwo);
        Assert.assertTrue(comparator.compare(triangle,triangleTwo) > 0 );

    }
}

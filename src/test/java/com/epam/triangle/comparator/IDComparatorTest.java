package com.epam.triangle.comparator;
import com.epam.triangle.comprator.IDComparator;
import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;

import static java.lang.Math.sqrt;

public class IDComparatorTest {
    private static final Comparator<Triangle> comparator = new IDComparator();

    @Test
    public void shouldGetTriangleOneSmallerTriangleTwoAndReturnNegativeNumber(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4,1);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Point2D[] arrTwo = new Point2D[3];
        arrTwo[0] = new Point2D(5,53);
        arrTwo[1] = new Point2D(6,0);
        arrTwo[2] = new Point2D(5,-sqrt(3));


        Triangle triangle = new Triangle(2,arr);
        Triangle triangleTwo = new Triangle(3,arrTwo);
        Assert.assertTrue(comparator.compare(triangle,triangleTwo) < 0 );

    }



    @Test
    public void shouldGetTriangleOneBiggerTriangleTwoAndReturnPositiveNumber(){
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4,1245);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Point2D[] arrTwo = new Point2D[3];
        arrTwo[0] = new Point2D(5,53);
        arrTwo[1] = new Point2D(6,0);
        arrTwo[2] = new Point2D(5,-sqrt(3));


        Triangle triangle = new Triangle(2,arr);
        Triangle triangleTwo = new Triangle(1,arrTwo);
        Assert.assertTrue(comparator.compare(triangle,triangleTwo) > 0 );

    }

}

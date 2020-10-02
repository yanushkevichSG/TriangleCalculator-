package com.epam.triangle.repository.impl.spicification;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.repository.Specification;
import com.epam.triangle.repository.impl.specification.SquareSmallerThanSpecification;
import com.epam.triangle.sevice.DistanceCalculator;
import com.epam.triangle.sevice.TriangleSides;
import com.epam.triangle.sevice.cor.impl.TriangleCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Math.sqrt;

public class SquareSmallerThanSpecificationTest {
    private static  Specification<Triangle> spicification;


    @BeforeClass
    public void  initSpecification(){
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        TriangleSides sides = new TriangleSides(distanceCalculator);
        TriangleCalculator calculator = new TriangleCalculator(sides);
        spicification = new SquareSmallerThanSpecification(20,calculator);
    }



    @Test
    public void ShouldGetTriangleWithSquareSmallerTwentyAndReturnTrue() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(2,0);
        arr[1] = new Point2D(4,0);
        arr[2] = new Point2D(2,sqrt(3));
        Triangle triangle = new Triangle(3L,arr);
        Assert.assertTrue(spicification.specify(triangle));
    }

    @Test
    public void ShouldGetTriangleWithSquareBiggerTwentyAndReturnFalse() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(20,0);
        arr[1] = new Point2D(64,0);
        arr[2] = new Point2D(51,sqrt(3));
        Triangle triangle = new Triangle(2L,arr);
        Assert.assertFalse(spicification.specify(triangle));
    }
}

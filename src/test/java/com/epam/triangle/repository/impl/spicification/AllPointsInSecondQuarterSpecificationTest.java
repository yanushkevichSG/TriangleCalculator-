package com.epam.triangle.repository.impl.spicification;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.repository.Specification;
import com.epam.triangle.repository.impl.specification.AllPointsInSecondQuarterSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Math.sqrt;

public class AllPointsInSecondQuarterSpecificationTest {
    private static final Specification<Triangle> spicification = new AllPointsInSecondQuarterSpecification();

    @Test
    public void ShouldGetTriangleWithPointsWhichDontLocatedInSecondQuarterAndReturnFalse() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(-4,2);
        arr[1] = new Point2D(6,3);
        arr[2] = new Point2D(-3,sqrt(13));
        Triangle triangle = new Triangle(3L,arr);
        Assert.assertFalse(spicification.specify(triangle));
    }

    @Test
    public void ShouldGetTriangleWithsPointsWhichLocatedInSecondQuarterAndReturnTrue() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(-4,3);
        arr[1] = new Point2D(-6,24);
        arr[2] = new Point2D(-25,sqrt(3));
        Triangle triangle = new Triangle(2L,arr);
        Assert.assertTrue(spicification.specify(triangle));
    }
}

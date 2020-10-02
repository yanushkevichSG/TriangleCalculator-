package com.epam.triangle.repository.impl.spicification;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.repository.Specification;
import com.epam.triangle.repository.impl.specification.AllPointsInSecondQuarterSpecification;
import com.epam.triangle.repository.impl.specification.AllPointsLocatedInRange;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Math.sqrt;

public class AllPointsLocatedInRangeTest {

    private static final Specification<Triangle> specification = new AllPointsLocatedInRange(3);

    @Test
    public void ShouldGetTriangleWithPointsWhichDontLocatedInRangeAndReturnFalse() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(-5,2);
        arr[1] = new Point2D(6,3);
        arr[2] = new Point2D(-3,sqrt(13));
        Triangle triangle = new Triangle(3L,arr);
        Assert.assertFalse(specification.specify(triangle));
    }

    @Test
    public void ShouldGetTriangleWithPointsWhichLocatedInRangeAndReturnTrue() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(-2,1);
        arr[1] = new Point2D(1,1);
        arr[2] = new Point2D(-1,2.5);
        Triangle triangle = new Triangle(2L,arr);
        Assert.assertTrue(specification.specify(triangle));
    }

}

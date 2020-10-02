package com.epam.triangle.repository.impl.spicification;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.repository.Specification;
import com.epam.triangle.repository.impl.specification.IDEqualsSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Math.sqrt;


public class IDEqualsSpecificationTest {
    private static final Specification<Triangle> spicification = new IDEqualsSpecification(3);

    @Test
    public void ShouldGetTriangleWithIDThreeAndShouldReturnTrue() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Triangle triangle = new Triangle(3L,arr);

        Assert.assertTrue(spicification.specify(triangle));
    }

    @Test
    public void ShouldGetTriangleWithIDTwoAndShouldReturnFalse() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(4,0);
        arr[1] = new Point2D(6,0);
        arr[2] = new Point2D(5,sqrt(3));

        Triangle triangle = new Triangle(2L,arr);

        Assert.assertFalse(spicification.specify(triangle));
    }

}

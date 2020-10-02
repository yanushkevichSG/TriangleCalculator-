package com.epam.triangle.service;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.exception.CannotCalculateFunctionsCoefficiensException;
import com.epam.triangle.sevice.FunctionMatchesChecker;
import com.epam.triangle.sevice.LinearFunctionChecker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinearFunctionCheackerTest {


   @Test
    public void  shouldCheaskPointAndReturnTrue() throws CannotCalculateFunctionsCoefficiensException {
       Point2D firstPoint = new Point2D(1,1);
       Point2D secondPoint = new Point2D(-1,-1);
       Point2D thirdPoint = new Point2D(2,2);
       Point2D forthPoint = new Point2D(1,1);

       FunctionMatchesChecker cheacker = new LinearFunctionChecker(firstPoint,secondPoint);
       Assert.assertTrue(cheacker.matches(thirdPoint));
       Assert.assertTrue(cheacker.matches(forthPoint));
   }

    @Test
    public void  shouldCheckPointAndReturnFalse() throws CannotCalculateFunctionsCoefficiensException {
        Point2D firstPoint = new Point2D(1,1);
        Point2D secondPoint = new Point2D(-1,-100);
        Point2D thirdPoint = new Point2D(23,2);
        Point2D forthPoint = new Point2D(11,1);

        FunctionMatchesChecker checker = new LinearFunctionChecker(firstPoint,secondPoint);
        Assert.assertFalse(checker.matches(thirdPoint));
        Assert.assertFalse(checker.matches(forthPoint));
    }


    @Test(expectedExceptions = CannotCalculateFunctionsCoefficiensException.class)
    public void  shouldThrowException() throws CannotCalculateFunctionsCoefficiensException {
        Point2D firstPoint = new Point2D(1,1);
        Point2D secondPoint = new Point2D(1,1);
        Point2D thirdPoint = new Point2D(2,2);
        FunctionMatchesChecker checker = new LinearFunctionChecker(firstPoint,secondPoint);
        Assert.assertTrue(checker.matches(thirdPoint));


    }


}

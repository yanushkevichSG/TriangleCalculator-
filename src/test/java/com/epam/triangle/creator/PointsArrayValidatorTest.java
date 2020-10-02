package com.epam.triangle.creator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsArrayValidatorTest {
    private final PointsArrayValidator validator = new PointsArrayValidator();

    @Test
    public void shouldGetingEmptyDoubleArrayAndReturnFalse(){
        double[] testArray = new double[0];
        boolean isValidArray = validator.isValid(testArray);
        Assert.assertFalse(isValidArray);
    }

    @Test
    public void shouldGetingNotOddDoubleArrayAndReturnFalse(){
        double[] testArray = new double[3];
        boolean isValidArray = validator.isValid(testArray);
        Assert.assertFalse(isValidArray);
    }

    @Test
    public void shouldGetingOddDoubleArrayAndReturnTrue(){
        double[] testArray = new double[4];
        boolean isValidArray = validator.isValid(testArray);
        Assert.assertTrue(isValidArray);
    }

}

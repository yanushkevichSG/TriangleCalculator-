package com.epam.triangle.creator;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.exception.CannotCalculateFunctionsCoefficiensException;
import com.epam.triangle.sevice.FunctionMatchesChecker;
import com.epam.triangle.sevice.LinearFunctionChecker;

public class TriangleValidator implements Validator {
    public boolean isValid(Point2D[] points) throws CannotCalculateFunctionsCoefficiensException {
        if(points.length !=3){
            return false;
        }

        Point2D pointOne = points[0];
        Point2D pointTwo = points[1];
        Point2D pointTree = points[2];

        if(pointOne.equals(pointTwo)
                ||pointOne.equals(pointTree)
                || pointTwo.equals(pointTree)){
            return false;
        }
        FunctionMatchesChecker checker = new LinearFunctionChecker(pointOne,pointTwo);
        return !checker.matches(pointTree);
    }
}

package com.epam.triangle.sevice;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.exception.CannotCalculateFunctionsCoefficiensException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinearFunctionChecker implements FunctionMatchesChecker {

    private static final Logger LOGGER = LogManager.getLogger(LinearFunctionChecker.class);


    private Point2D pointOne;
    private  Point2D pointTwo;

    public LinearFunctionChecker(Point2D pointOne, Point2D pointTwo){
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
    }



    private double calculateK()  {
        return (pointTwo.getY() - pointOne.getY())
                /(pointTwo.getX() - pointOne.getX());
    }

    private double calculateB()  {
        double k = calculateK();
        return  pointTwo.getY() -k*pointTwo.getX();
    }

    @Override
    public boolean matches(Point2D point) throws CannotCalculateFunctionsCoefficiensException {
        if(pointOne.equals(pointTwo)){
            CannotCalculateFunctionsCoefficiensException exception =  new CannotCalculateFunctionsCoefficiensException(
                    "Needed two different points for defining linear function");
            LOGGER.error(pointOne + " equals " + pointTwo + " " + exception);
            throw exception;
        }
        double k = calculateK();
        double b = calculateB();
        return point.getY() == point.getX()*k + b;
    }
}

package com.epam.triangle.creator;

public class PointsArrayValidator {

    public boolean isValid(double[] cordinates){
        return cordinates.length%2 == 0
                && cordinates.length != 0;
    }
}

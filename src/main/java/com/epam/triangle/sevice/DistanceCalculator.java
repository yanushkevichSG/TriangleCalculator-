package com.epam.triangle.sevice;

import com.epam.triangle.entity.Point2D;

import static java.lang.Math.*;

public class DistanceCalculator {
    private final double ROUND_BY_100 = 100D;

    public  double calculateDistance(Point2D point1, Point2D point2){
        double oX = point1.getX() - point2.getX();
        double oXSquare =  pow(oX,2);
        double oY = point1.getY() - point2.getY();
        double oYSquare = pow(oY,2);
        return (double)Math.round(sqrt(oXSquare + oYSquare) * ROUND_BY_100) / ROUND_BY_100;
    }



}


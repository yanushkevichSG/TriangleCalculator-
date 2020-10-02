package com.epam.triangle.repository.impl.specification;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.repository.Specification;
import com.epam.triangle.sevice.DistanceCalculator;

public class AllPointsLocatedInRange implements Specification<Triangle> {

    double distance;

    public AllPointsLocatedInRange(double distance){
        this.distance = distance;
    }
    @Override
    public boolean specify(Triangle object) {
        DistanceCalculator calculator = new DistanceCalculator();

        Point2D[] points = object.getAllPoints();
        Point2D zero = new Point2D(0,0);

        for (Point2D point: points){
            double distance = calculator.calculateDistance(zero,point);
            if(distance > this.distance){
                return false;
            }
        }
        return true;
    }
}

package com.epam.triangle.comprator;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;

import java.util.Comparator;

public class ComparatorByXCordinate implements Comparator<Triangle> {
    private int numberPoint;
    public  ComparatorByXCordinate(int numberPoint){
        this.numberPoint = numberPoint;
    }

    @Override
    public int compare(Triangle o1, Triangle o2) {
        Point2D one = o1.getPoint(numberPoint);
        Point2D two = o2.getPoint(numberPoint);
        return Double.compare(one.getX(),two.getX());
    }
}

package com.epam.triangle.comprator;
import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import java.util.Comparator;

public class ComparatorByPointFromZero implements Comparator<Triangle> {

    private int pointNumber;
    public ComparatorByPointFromZero(int pointNumber){
        this.pointNumber = pointNumber;
    }

    @Override
    public int compare(Triangle o1, Triangle o2) {
        Point2D firstPointOne = o1.getPoint(pointNumber);
        Point2D secondPointOne = o2.getPoint(pointNumber);
        double XOneSquare = Math.pow(firstPointOne.getX(),2);
        double YOneSquare = Math.pow(firstPointOne.getY(),2);
        double YTwoSquare = Math.pow(secondPointOne.getY(),2);
        double XTwoSquare = Math.pow(secondPointOne.getX(),2);
        return Double.compare(XOneSquare + YOneSquare , YTwoSquare + XTwoSquare);
    }
}

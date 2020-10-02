package com.epam.triangle.observer;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Shape2DParametrs;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.observer.impl.TriangleObservable;
import com.epam.triangle.observer.impl.WareHouse;
import com.epam.triangle.sevice.DistanceCalculator;
import com.epam.triangle.sevice.cor.impl.TriangleCalculator;
import com.epam.triangle.sevice.TriangleSides;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ObserverIT {
    private static TriangleObservable observable;
    private static Observer observer;

    @BeforeClass
    public void initObservable(){
        Point2D[] points = new Point2D[3];
        points[0] = new Point2D(0,0);
        points[1] = new Point2D(3,0);
        points[2] = new Point2D(0,4);
        observable = new TriangleObservable(1L, points);

        Map<Long, Shape2DParametrs> parametrsMap = new HashMap<>();
        parametrsMap.put(1L,new Shape2DParametrs(0,0));
        observer = new WareHouse(parametrsMap,new TriangleCalculator(new TriangleSides(new DistanceCalculator())));

        observable.addObserver(observer);

    }
    @BeforeMethod
    public void resetObservable() throws CannotFindCalculatorForShapeException {
        observable.setPoint(new Point2D(0,0),0);
        observable.setPoint(new Point2D(3,0),1);
        observable.setPoint(new Point2D(0,4),2);
    }

    @Test
    public void shouldChangeThePointAndCalculateNewSquare() throws CannotFindCalculatorForShapeException {

        observable.setPoint(new Point2D(4,0),1);

        WareHouse wareHouse = (WareHouse) observer;
        double square = wareHouse.getSquareByID(1L);
        Assert.assertEquals(8.0, square);
    }



    @Test
    public void shouldChangeThePointAndCalculateNewPerimetr() throws CannotFindCalculatorForShapeException {

        observable.setPoint(new Point2D(4,0),1);

        WareHouse wareHouse = (WareHouse) observer;
        double perimetr = wareHouse.getPerimetrByID(1L);
        Assert.assertEquals(13.66, perimetr);
    }

    @Test( expectedExceptions = NullPointerException.class)
    public void shouldThrowNullPointerException(){
        WareHouse wareHouse = (WareHouse) observer;
        double perimetr = wareHouse.getPerimetrByID(2L);

    }
}

package com.epam.triangle.observer.impl;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.observer.Observable;
import com.epam.triangle.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public  class TriangleObservable extends Triangle implements Observable {
    public TriangleObservable(long id, Point2D[] points) {
        super(id,points);
    }

    private List<Observer> observers = new ArrayList<>();


    public void setPoint(Point2D point, int pointNumber) throws CannotFindCalculatorForShapeException {
        super.setPoint(point, pointNumber);
        notifyObservers();
    }

    @Override
    public void notifyObservers() throws CannotFindCalculatorForShapeException {
        long id = getId();
        for (Observer observer: this.observers){
            observer.handleEvent(id,this);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
}

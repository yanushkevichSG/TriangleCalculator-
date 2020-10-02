package com.epam.triangle.observer;

import com.epam.triangle.exception.CannotFindCalculatorForShapeException;

public interface Observable {
    void notifyObservers() throws CannotFindCalculatorForShapeException;
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}

package com.epam.triangle.observer;

import com.epam.triangle.entity.Shape2D;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;

public interface Observer {
    void handleEvent(long id, Shape2D shape) throws CannotFindCalculatorForShapeException;
}

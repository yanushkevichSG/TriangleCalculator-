package com.epam.triangle.sevice.cor;

import com.epam.triangle.entity.Shape2D;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;

public interface Shape2DCalculatorChain {
    double perimeter(Shape2D shape) throws CannotFindCalculatorForShapeException;
    double square(Shape2D shape) throws CannotFindCalculatorForShapeException;

    Shape2DCalculatorChain linkWith(Shape2DCalculatorChain chain);
}

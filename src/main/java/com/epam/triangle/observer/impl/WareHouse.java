package com.epam.triangle.observer.impl;

import com.epam.triangle.entity.Shape2D;
import com.epam.triangle.entity.Shape2DParametrs;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.observer.Observer;
import com.epam.triangle.sevice.cor.BaseShape2DCalculator;
import com.epam.triangle.sevice.cor.Shape2DCalculatorChain;

import java.util.Map;

public class WareHouse implements Observer {

    private Map<Long, Shape2DParametrs> parametrs;
    private Shape2DCalculatorChain calculator;



    public WareHouse(Map<Long,Shape2DParametrs> parametrs, BaseShape2DCalculator calculator){
        this.parametrs = parametrs;
        this.calculator = calculator;
    }

    public double getPerimetrByID(long id){
        return parametrs.get(id).getPerimeter();
    }

    public double getSquareByID(long id){
        return parametrs.get(id).getSquare();
    }

    @Override
    public void handleEvent(long id, Shape2D shape) throws CannotFindCalculatorForShapeException {
        double perimetr = calculator.perimeter(shape);
        double square = calculator.square(shape);

        Shape2DParametrs changedParametrs = parametrs.get(id);
        changedParametrs.setPerimeter(perimetr);
        changedParametrs.setSquare(square);
    }


}

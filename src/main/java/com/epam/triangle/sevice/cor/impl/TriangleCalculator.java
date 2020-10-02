package com.epam.triangle.sevice.cor.impl;

import com.epam.triangle.entity.Shape2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.sevice.TriangleSides;
import com.epam.triangle.sevice.cor.BaseShape2DCalculator;


import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class TriangleCalculator extends BaseShape2DCalculator {

    private final double ROUND_BY_100 = 100D;
    private TriangleSides sides;
    public TriangleCalculator(TriangleSides sides){
        this.sides = sides;
    }


    @Override
    public double perimeter(Shape2D triangle) throws CannotFindCalculatorForShapeException {
        if(triangle instanceof Triangle) {
            double[] sides = this.sides.getAll(triangle);

            double perimiter = 0;
            for (double side : sides) {
                perimiter += side;
            }
            return perimiter;
        } else {
            return checkNextPerimetr(triangle);
        }
    }

    @Override
    public double square(Shape2D triangle) throws CannotFindCalculatorForShapeException {
        if(triangle instanceof Triangle) {
            double[] sides = this.sides.getAll(triangle);
            double sideOne = sides[0];
            double sideTwo = sides[1];
            double sideTree = sides[2];
            double semiPerimeter = perimeter(triangle) / 2;
            double square = sqrt(semiPerimeter
                    * (semiPerimeter - sideOne)
                    * (semiPerimeter - sideTwo)
                    * (semiPerimeter - sideTree));
            return round(square * ROUND_BY_100) / ROUND_BY_100;
        } else {
            return checkNextSquare(triangle);

        }
    }
}

package com.epam.triangle.entity;

import java.util.Objects;

public class Shape2DParametrs {

    private double square;
    private  double perimeter;

    public Shape2DParametrs(double square, double perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape2DParametrs that = (Shape2DParametrs) o;
        return Double.compare(that.square, square) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(square, perimeter);
    }

    @Override
    public String toString() {
        return "Shape2DParametrs{" +
                "square=" + square +
                ", perimeter=" + perimeter +
                '}';
    }
}

package com.epam.triangle.entity;

import java.io.Serializable;

public class Point2D implements Serializable {

    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.x, x) == 0 &&
                Double.compare(point2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return (int) (x*31 + y*43);
    }

    @Override
    public String toString() {
        return "Point2D{" +
                " x=" + x +
                ", y=" + y +
                '}';
    }
}

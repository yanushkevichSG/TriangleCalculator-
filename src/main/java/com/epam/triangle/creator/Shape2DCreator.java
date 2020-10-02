package com.epam.triangle.creator;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Shape2D;
import com.epam.triangle.exception.CannotCalculateFunctionsCoefficiensException;

import java.util.List;

public interface Shape2DCreator {

     List<? extends Shape2D> createList(List<Point2D[]> listOfPoints)
             throws CannotCalculateFunctionsCoefficiensException;
}

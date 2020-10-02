package com.epam.triangle.creator;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.exception.CannotCalculateFunctionsCoefficiensException;

public interface Validator {
    boolean isValid(Point2D[] points) throws CannotCalculateFunctionsCoefficiensException;
}

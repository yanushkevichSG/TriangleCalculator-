package com.epam.triangle.sevice;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.exception.CannotCalculateFunctionsCoefficiensException;

public interface FunctionMatchesChecker {
     boolean matches(Point2D point) throws CannotCalculateFunctionsCoefficiensException;
}

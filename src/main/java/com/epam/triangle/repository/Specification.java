package com.epam.triangle.repository;

import com.epam.triangle.exception.CannotFindCalculatorForShapeException;

public interface Specification<T> {
    boolean specify(T object) throws CannotFindCalculatorForShapeException;
}
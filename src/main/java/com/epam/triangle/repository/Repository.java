package com.epam.triangle.repository;


import com.epam.triangle.exception.CannotFindCalculatorForShapeException;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T object);
    void update(T object);
    void remove(T object);
    List<T> query(Specification<T> specification) throws CannotFindCalculatorForShapeException;
    List<T> sort(Comparator<T> comparator);
}

package com.epam.triangle.repository.impl;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.repository.Repository;
import com.epam.triangle.repository.Specification;

import java.util.*;

public class TriangleRepository implements Repository<Triangle> {

    private Map<Long, Triangle> triangleMap = new HashMap<>();



    @Override
    public void add(Triangle object) {
        Long id = object.getId();
        triangleMap.put(id,object);
    }

    @Override
    public void update(Triangle object) {
        Long id = object.getId();
        triangleMap.replace(id,object);
    }

    @Override
    public void remove(Triangle object) {
        Long id = object.getId();
        triangleMap.remove(id);
    }

    @Override
    public List<Triangle> query(Specification<Triangle> specification) throws CannotFindCalculatorForShapeException {
        Collection<Triangle> allTriangles =  triangleMap.values();
        List<Triangle> triangles = new ArrayList<>();

        for (Triangle triangle: allTriangles){
            if(specification.specify(triangle)){
                triangles.add(triangle);
            }
        }
        return triangles;
    }

    @Override
    public List<Triangle> sort(Comparator<Triangle> comparator) {
        List<Triangle> allTriangles =  new ArrayList<>(triangleMap.values());
        allTriangles.sort(comparator);
        return allTriangles;
    }
}

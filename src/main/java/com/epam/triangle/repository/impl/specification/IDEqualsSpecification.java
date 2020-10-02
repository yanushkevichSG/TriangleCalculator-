package com.epam.triangle.repository.impl.specification;

import com.epam.triangle.entity.Triangle;
import com.epam.triangle.repository.Specification;

public class IDEqualsSpecification implements Specification<Triangle> {

    long id;
    public IDEqualsSpecification(long id){
        this.id = id;
    }
    @Override
    public boolean specify(Triangle object) {
        return object.getId() == id;
    }
}

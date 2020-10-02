package com.epam.triangle.entity;

import java.util.Arrays;
import java.util.Objects;

public abstract class Shape2D {

    private final long id;
   public  Shape2D(long id){
       this.id = id;
   }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape2D shape2D = (Shape2D) o;
        return id == shape2D.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Shape2D{" +
                "id=" + id +
                '}';
    }
}

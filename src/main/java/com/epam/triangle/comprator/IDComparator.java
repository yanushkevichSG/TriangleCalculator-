package com.epam.triangle.comprator;

import com.epam.triangle.entity.Triangle;

import java.util.Comparator;

public class IDComparator implements Comparator<Triangle> {

    @Override
    public int compare(Triangle o1, Triangle o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}

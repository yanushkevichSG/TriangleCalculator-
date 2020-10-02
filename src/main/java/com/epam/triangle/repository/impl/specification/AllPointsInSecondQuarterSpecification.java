package com.epam.triangle.repository.impl.specification;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.repository.Specification;

public class AllPointsInSecondQuarterSpecification implements Specification<Triangle> {
    @Override
    public boolean specify(Triangle object) {
        Point2D[] points = object.getAllPoints();

        for (Point2D point: points){
          if(
                  point.getX() > 0
                  ||point.getY() < 0){
              return false;
          }
        }
        return true;
    }
}

package com.epam.triangle.creator;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotCalculateFunctionsCoefficiensException;
import com.epam.triangle.sevice.IDGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TriangleCreator implements Shape2DCreator {
    private static final Logger LOGGER = LogManager.getLogger(Triangle.class);

    private final IDGenerator generator = new IDGenerator();

    private TriangleCreator(){}
    private static class TriangleCreatorHolder{
        private static final TriangleCreator INSTANCE = new TriangleCreator();
    }

    public static TriangleCreator getInstance(){
        return TriangleCreatorHolder.INSTANCE;
    }


    private Triangle create(Point2D[] points) throws CannotCalculateFunctionsCoefficiensException {
        TriangleValidator validator = new TriangleValidator();
        if(!validator.isValid(points)){
            LOGGER.warn("not valid data  for creating triangle: " + Arrays.toString(points));
            return null;
        }

        long id = generator.next();
        return new Triangle(id,points);
    }


@Override
    public List<Triangle> createList(List<Point2D[]> listOfPoints) throws CannotCalculateFunctionsCoefficiensException {
        List<Triangle> triangleList = new LinkedList<>();

        for (Point2D[] points: listOfPoints){
            Triangle triangle = create(points);
            if(triangle != null){
                triangleList.add(triangle);
            }
        }
        return triangleList;
    }
}

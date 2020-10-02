package com.epam.triangle.creator;



import com.epam.triangle.entity.Point2D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PointsArrayCreator {

    private static final Logger LOGGER = LogManager.getLogger(PointsArrayCreator.class);
    private PointsArrayCreator(){}

    private static class PointsArrayCreatorHolder{
        private static final PointsArrayCreator INSTANCE = new PointsArrayCreator();
    }

    public static PointsArrayCreator getInstance(){
        return PointsArrayCreatorHolder.INSTANCE;
    }



    public Point2D[] createPoints(double[] cordinates){

        PointsArrayValidator validator = new PointsArrayValidator();
        if(!validator.isValid(cordinates)) {
            LOGGER.warn("Not valid data for creating Points2D[]: " + Arrays.toString(cordinates));
            return null;
        }

        Point2D[] points = new Point2D[cordinates.length/2];

        for (int i = 0, j =0 ; i < cordinates.length ; i = i+2, ++j){
            double x = cordinates[i];
            double y = cordinates[i+1];
            points[j] = new Point2D(x,y);
        }
        return points;
    }

    public List<Point2D[]> createPointsList(List<double[]> doubles){
        List<Point2D[]> pointsList = new LinkedList<>();
        for (double[] doubleArray: doubles){
            Point2D[] pointArray = createPoints(doubleArray);
            if(pointArray != null){
                pointsList.add(pointArray);
            }
        }
        return pointsList;
    }
}

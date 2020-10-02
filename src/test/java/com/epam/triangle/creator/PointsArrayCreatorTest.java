package com.epam.triangle.creator;

import com.epam.triangle.entity.Point2D;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsArrayCreatorTest {
    private final  PointsArrayCreator creator = PointsArrayCreator.getInstance();

    @Test
    public void shouldReturnNullBecauseNotValidDAtaArray(){
        double[] firsTestData = {1,2,3,4,4};
        double[] secondTestData ={};

        Point2D[] firstPointsArray = creator.createPoints(firsTestData);
        Point2D[] secondPointsArray =  creator.createPoints(secondTestData);

        Assert.assertNull(firstPointsArray);
        Assert.assertNull(secondPointsArray);
    }

    @Test
    public void shouldCreateAndReturnPointsArrayEqualsTestArray() {
        double[] firsTestData = {1, 2, 3, 4, 4,5};
        Point2D[] testArray = {new Point2D(1,2), new Point2D(3,4), new Point2D(4,5)};

        Point2D[] resultArray = creator.createPoints(firsTestData);

        Assert.assertEquals(testArray, resultArray);
    }



    @Test
    public void shouldCreateAndReturnListOfTreePointsArray() {
        List<double[]> pointsCordinates = new ArrayList<>();
        pointsCordinates.add(new double[]{1, 2, 3, 4, 4,5});
        pointsCordinates.add(new double[]{1, 2, 3, 4, 4});
        pointsCordinates.add(new double[]{1, 2, 3, 4,46,-4});
        pointsCordinates.add(new double[]{-2,41, 2, 3, -4, 4});
        pointsCordinates.add(new double[]{});
        pointsCordinates.add(new double[]{-2});
        List<Point2D[]> testData = new ArrayList<>();
        testData.add(new Point2D[]{new Point2D(1, 2),new Point2D(3,4), new Point2D(4, 5)});
        testData.add(new Point2D[]{new Point2D(1, 2),new Point2D(3, 4), new Point2D(46, -4)});
        testData.add(new Point2D[]{new Point2D(-2, 41),new Point2D(2,3), new Point2D(-4, 4)});

        List<Point2D[]> pointsList = creator.createPointsList(pointsCordinates);

        Assert.assertEquals(3, pointsList.size());
        Assert.assertEquals(testData.get(0), pointsList.get(0));
        Assert.assertEquals(testData.get(1), pointsList.get(1));
        Assert.assertEquals(testData.get(2), pointsList.get(2));
    }




    }

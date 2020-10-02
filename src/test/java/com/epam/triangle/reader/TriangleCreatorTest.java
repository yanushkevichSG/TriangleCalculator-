package com.epam.triangle.reader;

import com.epam.triangle.creator.TriangleCreator;
import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotCalculateFunctionsCoefficiensException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleCreatorTest {
    private final TriangleCreator CREATOR = TriangleCreator.getInstance();

    @Test
    public void shouldReturnListWithZeroSize() throws CannotCalculateFunctionsCoefficiensException {
        List<Point2D[]> pointsList = new ArrayList<>();
        pointsList.add(new Point2D[]{new Point2D(0,0),new Point2D(0,0),new Point2D(0,0)});
        pointsList.add(new Point2D[]{});
        pointsList.add(new Point2D[]{new Point2D(0,0),new Point2D(1,1),new Point2D(2,2)});
        List<Triangle> triangles = CREATOR.createList(pointsList);

        Assert.assertEquals(0,triangles.size());
    }


    @Test
    public void shouldReturnListWithTwoSizeAndCreatedTriangelsShouldContainDataFromArray() throws CannotCalculateFunctionsCoefficiensException {
        List<Point2D[]> pointsList = new ArrayList<>();

        Point2D[] firstTestArray = {new Point2D(0,0),new Point2D(1,0),new Point2D(0,1)};
        Point2D[] secondTestArray = {};
        Point2D[] thirdTestArray = {new Point2D(0,0),new Point2D(-1,-1),new Point2D(23,2)};

        pointsList.add(firstTestArray);
        pointsList.add(secondTestArray);
        pointsList.add(thirdTestArray);
        List<Triangle> triangles = CREATOR.createList(pointsList);

        Triangle firstTriangle = triangles.get(0);
        Triangle secondTriangle = triangles.get(1);

        Assert.assertEquals(2,triangles.size());
        Assert.assertEquals(firstTestArray,firstTriangle.getAllPoints());
        Assert.assertEquals(thirdTestArray,secondTriangle.getAllPoints());
    }

}

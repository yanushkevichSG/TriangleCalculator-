package com.epam.triangle.repository.impl.spicification;

import com.epam.triangle.entity.Point2D;
import com.epam.triangle.entity.Triangle;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.repository.Repository;
import com.epam.triangle.repository.impl.TriangleRepository;
import com.epam.triangle.repository.impl.specification.AllPointsInSecondQuarterSpecification;
import com.epam.triangle.repository.impl.specification.IDEqualsSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Math.sqrt;

public class TriangleRepositoryTest {
    private Repository<Triangle> repository = new TriangleRepository();


    @BeforeMethod
    public void initRepo(){
        Point2D[] arrOne = new Point2D[3];
        arrOne[0] = new Point2D(4,4);
        arrOne[1] = new Point2D(6,0);
        arrOne[2] = new Point2D(5,sqrt(3));

        Point2D[] arrTwo = new Point2D[3];
        arrTwo[0] = new Point2D(5,5);
        arrTwo[1] = new Point2D(6,0);
        arrTwo[2] = new Point2D(5,-3);


        Point2D[] arrTree = new Point2D[3];
        arrTree[0] = new Point2D(2,4);
        arrTree[1] = new Point2D(10,4);
        arrTree[2] = new Point2D(34,-3);

        Point2D[] arrFour = new Point2D[3];
        arrFour[0] = new Point2D(2,4);
        arrFour[1] = new Point2D(10,4);
        arrFour[2] = new Point2D(34,-3);


        Triangle triangleOne = new Triangle(1,arrOne);
        Triangle triangleTwo = new Triangle(2,arrTwo);
        Triangle triangleTree = new Triangle(3,arrOne);
        Triangle triangleFour = new Triangle(3,arrOne);

        repository.add(triangleOne);
        repository.add(triangleTwo);
        repository.add(triangleTree);
        repository.add(triangleFour);
    }

    @AfterMethod
    public void cleanRepo(){
        repository = new TriangleRepository();
    }

    @Test
    public void ShouldGetNewTriangleWithIdOneAndCannotAddThisTriangle() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(0,0);
        arr[1] = new Point2D(5,0);
        arr[2] = new Point2D(0,-3);


        Triangle triangleOne = new Triangle(1,arr);

        repository.add(triangleOne);
        List<Triangle> triangle = repository.query(new IDEqualsSpecification(1));
        Assert.assertEquals(triangle.size(),1);
        System.out.println(triangleOne + "  "  + triangle.get(0));
        Assert.assertEquals(triangle.get(0),triangleOne);

    }




    @Test
    public void shouldUpdateDataInRepository() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(0,0);
        arr[1] = new Point2D(5,0);
        arr[2] = new Point2D(0,-3);


        Triangle triangleOne = new Triangle(1,arr);

        repository.update(triangleOne);
        List<Triangle> triangle = repository.query(new IDEqualsSpecification(1));
        Assert.assertEquals(triangle.size(),1);
        Assert.assertEquals(triangle.get(0),triangleOne);
    }



    @Test
    public void ShouldGetNewTrianglesWithAlPointsInSecondQuarterAndReturnListWithThisSpicification() throws CannotFindCalculatorForShapeException {
        Point2D[] arr = new Point2D[3];
        arr[0] = new Point2D(-2,24);
        arr[1] = new Point2D(-5,20);
        arr[2] = new Point2D(-40,4);

        Point2D[] arr2 = new Point2D[3];
        arr2[0] = new Point2D(-1,1);
        arr2[1] = new Point2D(-5,2);
        arr2[2] = new Point2D(-3,4);


        Triangle triangleOne = new Triangle(5,arr);
        Triangle triangleTwo = new Triangle(6,arr);

        repository.add(triangleOne);
        repository.add(triangleTwo);
        List<Triangle> triangle = repository.query(new AllPointsInSecondQuarterSpecification());
        Assert.assertEquals(triangle.size(),2);


    }


}

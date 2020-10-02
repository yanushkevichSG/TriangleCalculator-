package com.epam.triangle.reader;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ToDoubleArrayParserTest {

private  final ToDoubleArrayParser parser = new ToDoubleArrayParser();

@Test
public void shouldParseAndReturnListOfThreeDoubleArrays(){

    List<String> nums = new ArrayList<>();
    nums.add("1 2 3.4 4 5 6  ");
    nums.add("1 4 3 4 5.5 3 ");
    nums.add("1 2.3 3 4 6 6   ");

    List<double[]> doubles = parser.parse(nums);

    Assert.assertEquals(3, doubles.size());
    double[] firstArr = doubles.get(0);

    Assert.assertEquals(6, firstArr.length);
    Assert.assertEquals(1.0, firstArr[0]);

}

@Test
public void shouldParseTwoLineAndReturnOneEqualsTestDataArray(){
    List<String> nums = new ArrayList<>();
    nums.add("1 2 3.4 4 5 6  ");
    nums.add("1 2 3.4 4 5 X6  ");
    double[] testData = {1 ,2,3.4 , 4 ,5, 6};
    List<double[]> parsedData = parser.parse(nums);

    double[] testResult = parsedData.get(0);
    Assert.assertEquals(testData, testResult);
    Assert.assertEquals(1, parsedData.size());




}


}

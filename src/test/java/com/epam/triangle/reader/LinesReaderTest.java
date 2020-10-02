package com.epam.triangle.reader;

import com.epam.triangle.exception.NotSupportedPuthException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.List;

public class LinesReaderTest {
    private final LinesReader reader = new LinesReader();

    @Test(expectedExceptions = NotSupportedPuthException.class)
    public void shouldThrowNotSupportedPuthException() throws IOException {
        String motValidPath = "resoursess" + File.separator  + "data" + File.separator + "data.txt";
        reader.readAllLines(Paths.get(motValidPath), Charset.defaultCharset());
    }

    @Test
    public  void shouldReadEightLinesFromFile() throws IOException {
        List<String> strings;
        String validPath = "resourses" + File.separator  + "data" + File.separator + "data.txt";
        strings =  reader.readAllLines(Paths.get(validPath), Charset.defaultCharset());
        Assert.assertEquals(strings.size(),8);


    }

    @Test
    public void shouldReadZeroLinesFromEmptyFile() throws IOException {
        List<String> strings;
        String validPath = "resourses" + File.separator  + "data" + File.separator + "empty.txt";
        strings =  reader.readAllLines(Paths.get(validPath), Charset.defaultCharset());
        Assert.assertEquals(strings.size(),0);

    }

}

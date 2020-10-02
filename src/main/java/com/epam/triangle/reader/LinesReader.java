package com.epam.triangle.reader;

import com.epam.triangle.exception.NotSupportedPuthException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class LinesReader {
    private static final Logger LOGGER = LogManager.getLogger(LinesReader.class);


    public List<String> readAllLines(Path path, Charset charset) throws IOException {
        try {
            LOGGER.info("Start reading lines from: " + path);
            List<String> lines = Files.readAllLines(path, charset);
            LOGGER.info("All lines was reading from: " + path);
            return lines;
        } catch (NoSuchFileException e) {
            LOGGER.error("Exception generated! Path " + path + " not valid. " + e);
            throw new NotSupportedPuthException("Invalid path: " + path, e);
        } catch (IOException e){
            LOGGER.error(e);
            throw e;
        }
    }
}

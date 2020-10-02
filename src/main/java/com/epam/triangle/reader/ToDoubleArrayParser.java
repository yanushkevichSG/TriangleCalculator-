package com.epam.triangle.reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToDoubleArrayParser {

    private final static String ARRAY_DOUBLE_PATTERN = "\\s*([\\+-]?\\d+([.,]\\d+)?\\s+)*([\\+-]?\\d+([.,]\\d+)?)\\s*";
    private final static String SEPARATOR_PATTERN = "\\s+";


    private double[] parseOneString(String stringOfDoubles) {

        if (!stringOfDoubles.matches(ARRAY_DOUBLE_PATTERN)) {
            return null;
        }

        stringOfDoubles = stringOfDoubles.trim();
        stringOfDoubles = stringOfDoubles.replaceAll(",", ".");
        String[] doublesInStringForm = stringOfDoubles.split(SEPARATOR_PATTERN);

        double[] doubles = new double[doublesInStringForm.length];

        for (int i = 0; i < doubles.length; ++i) {

            String stringForParsing = doublesInStringForm[i];
            doubles[i] = Double.parseDouble(stringForParsing);
        }
        return doubles;
    }

    public  List<double[]> parse(List<String> strings){
        List<double[]> doublesList = new ArrayList<>();
       for(String arrayInStringForm:strings){
           double[] arrayDoubles = parseOneString(arrayInStringForm);
          if(arrayDoubles != null) {
              doublesList.add(arrayDoubles);
          }
       }
       return doublesList;
    }
}

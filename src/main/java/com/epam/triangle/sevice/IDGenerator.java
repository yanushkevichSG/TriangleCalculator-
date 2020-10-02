package com.epam.triangle.sevice;

public class IDGenerator {
    private static long currentID = 1_000_000_000_000L;
    public long next(){
        return currentID++;
    }
}

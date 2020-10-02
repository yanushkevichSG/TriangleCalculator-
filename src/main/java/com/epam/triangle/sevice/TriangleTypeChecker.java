package com.epam.triangle.sevice;

import com.epam.triangle.entity.Triangle;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class TriangleTypeChecker {
    private TriangleSides sides;
    private final double ROUND_BY_10 = 10D;

    public TriangleTypeChecker(TriangleSides sides){
        this.sides = sides;
    }



    public boolean isRight(Triangle triangle){


        double[] sides = this.sides.getAll(triangle);
        Arrays.sort(sides);

        double hypotenuse = sides[2];
        double roundHypotenuse = round(hypotenuse * ROUND_BY_10)/ROUND_BY_10;

        double legOneSquare = pow(sides[1],2);
        double legTwoSquare =  pow(sides[0],2);
        double sumLegsSquare = sqrt(legOneSquare + legTwoSquare);
        double roundSumLegsSquare = round(sumLegsSquare * ROUND_BY_10) / ROUND_BY_10;
        return Double.compare(roundHypotenuse , roundSumLegsSquare) == 0;
    }


    public boolean isIsosceles(Triangle triangle){
        double[] sides = this.sides.getAll(triangle);

        double sideOne = sides[0];
        double sideTwo = sides[1];
        double sideThree = sides[2];

        return Double.compare(sideOne,sideTwo) == 0
                || Double.compare(sideTwo,sideThree) ==0
                || Double.compare(sideThree,sideOne) ==0;


    }

    public boolean isEquilateral(Triangle triangle){
        double[] sides = this.sides.getAll(triangle);

        double sideOne = sides[0];
        double sideTwo = sides[1];
        double sideThree = sides[2];

        return (sideOne == sideTwo)
                &&(sideTwo == sideThree);

    }




    public  boolean isObsute(Triangle triangle){
        double[] sides = this.sides.getAll(triangle);
        Arrays.sort(sides);

        double theBiggestSideSquare = pow(sides[2],2);
        double smallerSideOneSquare = pow(sides[1],2);
        double smallerSideTwoSquare = pow(sides[0],2);

        return theBiggestSideSquare > smallerSideOneSquare + smallerSideTwoSquare;
    }

    public boolean isAcute(Triangle triangle){
        return !isObsute(triangle) && !isRight(triangle);

    }
}

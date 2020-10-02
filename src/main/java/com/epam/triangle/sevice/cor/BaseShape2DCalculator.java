package com.epam.triangle.sevice.cor;


import com.epam.triangle.entity.Shape2D;
import com.epam.triangle.exception.CannotFindCalculatorForShapeException;
import com.epam.triangle.reader.LinesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseShape2DCalculator implements Shape2DCalculatorChain {
     private static final Logger LOGGER = LogManager.getLogger(BaseShape2DCalculator.class);

     private Shape2DCalculatorChain next;


     protected double checkNextPerimetr(Shape2D shape) throws CannotFindCalculatorForShapeException {
          if(next == null){
               throw  new CannotFindCalculatorForShapeException("Cannot find calculator for shape: " + shape.getClass().getName());
          } else {
               return next.perimeter(shape);
          }
     }

     protected double checkNextSquare(Shape2D shape) throws CannotFindCalculatorForShapeException {
          if(next == null){
               throw  new CannotFindCalculatorForShapeException("Cannot find calculator for shape: " + shape.getClass().getName());

          } else {
               return next.square(shape);
          }
     }


     @Override
     public Shape2DCalculatorChain linkWith(Shape2DCalculatorChain chain){
          next = chain;
          return next;
     }
}

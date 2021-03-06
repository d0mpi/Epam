package com.epam.jwd.app;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static final Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        FigureFactory figureFactory = FigureFactory.getInstance();

        Point[] pointArray = new Point[]{
                figureFactory.buildPoint(1, -17),
                figureFactory.buildPoint(-5.4, 2),
                figureFactory.buildPoint(8.3, -3.5),
                figureFactory.buildPoint(4.98, 0)
        };
        Line[] lineArray = new Line[]{
                figureFactory.buildLine(1, 2, 3, 4),
                figureFactory.buildLine(1, -0.7, 1, -0.7)
        };
        Triangle[] triangleArray = new Triangle[]{
                figureFactory.buildTriangle(1, 2, 1, 2, -0.3, 2.4),
                figureFactory.buildTriangle(1, 2, 3, 4, 5, 6)
        };
        Square[] squareArray = new Square[]{
                figureFactory.buildSquare(3, 1, 6, 4, 0,4, 3, 0)
        };


        int i = 3;
        do {
            logger.info(pointArray[i].toString());
        } while (i --> 0);

        for(Line line : lineArray) {
            if (line.containSamePoints()) {
                logger.error("Объект " + line.toString() + " не является фигурой линия" );
            } else {
                logger.info(line.toString());
            }
        }

        for(Triangle triangle: triangleArray){
            if(triangle.containSamePoints()) {
                logger.error("Объект " + triangle.toString() + " не является фигурой треугольник");
            } else if(!triangle.isValid()) {
                logger.error("Треугольник " + triangle.toString() + " не может существовать");
            } else {
                logger.info(triangle.toString());
            }
        }

        for(Square square: squareArray){
            if(square.containSamePoints()) {
                logger.error("Объект " + square.toString() + " не является фигурой квадрат");
            } else if(!square.isValid()) {
                logger.error("Объект " + square.toString() + " не является квадратом");
            } else {
                logger.info(square.toString());
            }
        }
    }
}

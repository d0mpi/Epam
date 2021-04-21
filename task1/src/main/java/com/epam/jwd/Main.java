package com.epam.jwd;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static final Logger logger = LogManager.getLogger();

    private static LinkedList<Point> initializePointArray() {
        return new LinkedList<>(Arrays.asList(
                new Point(1, -17),
                new Point(-5.4, 2),
                new Point(8.3, -3.5),
                new Point(4.98, 0)
        ));
    }

    private static LinkedList<Line> initializeLineArray(FigureFactory multiAngleFigureFactory) throws FigureException {
        return new LinkedList<>(Arrays.asList(
                (Line) multiAngleFigureFactory.createFigure(FigureType.LINE, new Point[]{
                        new Point(1, 2),
                        new Point(3, 4)}),
                (Line) multiAngleFigureFactory.createFigure(FigureType.LINE, new Point[]{
                        new Point(1.54, 2.89),
                        new Point(3, -0.31)})
        ));
    }

    private static LinkedList<Triangle> initializeTriangleArray(FigureFactory multiAngleFigureFactory) throws FigureException {
        return new LinkedList<>(Arrays.asList(
                (Triangle) multiAngleFigureFactory.createFigure(FigureType.TRIANGLE, new Point[]{
                        new Point(1, 2),
                        new Point(1, -4),
                        new Point(3, 4)}),
                (Triangle) multiAngleFigureFactory.createFigure(FigureType.TRIANGLE, new Point[]{
                        new Point(1.54, 2.89),
                        new Point(1.54, 0),
                        new Point(3, -0.31)})));
    }

    private static LinkedList<Square> initializeSquareArray(FigureFactory multiAngleFigureFactory) throws FigureException {
        return new LinkedList<>(Collections.singletonList(
                (Square) multiAngleFigureFactory.createFigure(FigureType.SQUARE, new Point[]{
                        new Point(0, 0),
                        new Point(1, 0),
                        new Point(0, 1),
                        new Point(1, 1)})));
    }

    private static void logPointArray(LinkedList<Point> points) {
        int i = points.size() - 1;
        do {
            logger.info(points.get(i).toString());
        } while (i-- > 0);
    }

    private static void logFigureArray(LinkedList<? extends Figure> figures) {
        for (Figure figure : figures) {
            if (figure.containSamePoints()) {
                logger.error("Object " + figure.toString() + " is not " + figure.getFigureType());
            } else if (!figure.isValid()) {
                logger.error(figure.getFigureType() + " " + figure.toString() + "can not exist");
            } else {
                logger.info(figure.toString());
            }
        }
    }

    private static LinkedList<MultiAngleFigure> initializeMultiAngleFigure(FigureFactory multiAngleFigureFactory) throws FigureException {
        return new LinkedList<>(Arrays.asList(
                (MultiAngleFigure) multiAngleFigureFactory.createFigure(FigureType.MULTIANGLE, new Point[]{
                        new Point(1, 1),
                        new Point(1, 2),
                        new Point(2, 2),
                        new Point(2, 1),
                        new Point(2, 1)
                }),
                (MultiAngleFigure) multiAngleFigureFactory.createFigure(FigureType.MULTIANGLE, new Point[]{
                        new Point(1, 1),
                        new Point(1, 2),
                        new Point(2, 2),
                        new Point(2, 1),
                        new Point(2, 1)
                })));
    }

    public static void main(String[] args) throws FigureException {
        FigureFactory multiAngleFigureFactory = MultiAngleFigureFactory.getInstance();

        LinkedList<Point> pointArray = initializePointArray();
        LinkedList<Line> lineArray = initializeLineArray(multiAngleFigureFactory);
        LinkedList<Triangle> triangleArray = initializeTriangleArray(multiAngleFigureFactory);
        LinkedList<Square> squareArray = initializeSquareArray(multiAngleFigureFactory);

        logPointArray(pointArray);
        logFigureArray(lineArray);
        logFigureArray(triangleArray);
        logFigureArray(squareArray);

        LinkedList<MultiAngleFigure> multiAngleFigureArray = initializeMultiAngleFigure(multiAngleFigureFactory);

    }
}

package com.epam.jwd.app;

import com.epam.jwd.criteria.FigureCriteria;
import com.epam.jwd.criteria.FigureCriteriaBuilder;
import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Main {

    public static final Logger logger = LogManager.getLogger();

    private static ArrayList<Point> initializePointArray() {
        return new ArrayList<>(Arrays.asList(
                new Point(1, -17),
                new Point(-5.4, 2),
                new Point(8.3, -3.5),
                new Point(4.98, 0)
        ));
    }

    private static ArrayList<Line> initializeLineArray(FigureFactory multiAngleFigureFactory) throws FigureException {
        return new ArrayList<>(Arrays.asList(
                (Line) multiAngleFigureFactory.createFigure(FigureType.LINE, new Point[]{
                        new Point(1, 2),
                        new Point(3, 4)}),
                (Line) multiAngleFigureFactory.createFigure(FigureType.LINE, new Point[]{
                        new Point(1.54, 2.89),
                        new Point(3, -0.31)})
        ));
    }

    private static ArrayList<Triangle> initializeTriangleArray(FigureFactory multiAngleFigureFactory) throws FigureException {
        return new ArrayList<>(Arrays.asList(
                (Triangle) multiAngleFigureFactory.createFigure(FigureType.TRIANGLE, new Point[]{
                        new Point(1, 2),
                        new Point(1, -4),
                        new Point(3, 4)}),
                (Triangle) multiAngleFigureFactory.createFigure(FigureType.TRIANGLE, new Point[]{
                        new Point(1.54, 2.89),
                        new Point(1.54, 0),
                        new Point(3, -0.31)})));
    }

    private static ArrayList<Square> initializeSquareArray(FigureFactory multiAngleFigureFactory) throws FigureException {
        return new ArrayList<>(Collections.singletonList(
                (Square) multiAngleFigureFactory.createFigure(FigureType.SQUARE, new Point[]{
                        new Point(0, 0),
                        new Point(1, 0),
                        new Point(0, 1),
                        new Point(1, 1)})));
    }

    private static void logPointArray(ArrayList<Point> points) {
        int i = points.size() - 1;
        do {
            logger.info(points.get(i).toString());
        } while (i-- > 0);
    }

    private static void logFigureArray(ArrayList<? extends Figure> figures) {
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

    private static ArrayList<MultiAngleFigure> initializeMultiAngleFigure(FigureFactory multiAngleFigureFactory) throws FigureException {
        return new ArrayList<>(Arrays.asList(
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
        FigureFactory multiAngleFigureFactory = SimpleFigureFactory.getInstance();

        ArrayList<Point> pointArray = initializePointArray();
        ArrayList<Line> lineArray = initializeLineArray(multiAngleFigureFactory);
        ArrayList<Triangle> triangleArray = initializeTriangleArray(multiAngleFigureFactory);
        ArrayList<Square> squareArray = initializeSquareArray(multiAngleFigureFactory);

        logPointArray(pointArray);
        logFigureArray(lineArray);
        logFigureArray(triangleArray);
        logFigureArray(squareArray);

        ArrayList<MultiAngleFigure> multiAngleFigureArray = initializeMultiAngleFigure(multiAngleFigureFactory);

        FigureCriteriaBuilder figureCriteriaBuilder = new FigureCriteriaBuilder();
        figureCriteriaBuilder.setFigureType(FigureType.LINE);
        figureCriteriaBuilder.setId(1);

        FigureCriteria figureCriteria = figureCriteriaBuilder.getResultCriteria();
    }
}

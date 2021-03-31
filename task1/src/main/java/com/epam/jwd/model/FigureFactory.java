package com.epam.jwd.model;

public class FigureFactory {

    private FigureFactory() {
    }

    public static Point buildPoint(double firstX, double firstY) {
        return new Point(firstX, firstY);
    }


    public static Line buildLine(double firstX, double firstY,
                                 double secondX, double secondY) {
        return new Line(firstX, firstY, secondX, secondY);
    }


    public static Triangle buildTriangle(double firstX, double firstY,
                                         double secondX, double secondY,
                                         double thirdX, double thirdY) {
        return new Triangle(firstX, firstY, secondX, secondY, thirdX, thirdY);
    }

    public static Square buildSquare(double firstX, double firstY,
                                     double secondX, double secondY,
                                     double thirdX, double thirdY,
                                     double fourthX, double fourthY) {
        return new Square(firstX, firstY, secondX, secondY, thirdX, thirdY, fourthX, fourthY);
    }
}
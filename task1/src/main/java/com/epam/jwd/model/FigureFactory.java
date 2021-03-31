package com.epam.jwd.model;

public class FigureFactory {

    private FigureFactory() {
    }

    public static Point buildPoint(double coordinateX, double coordinateY) {
        return new Point(coordinateX, coordinateY);
    }


    public static Line buildLine(double firstX, double firstY, double secondX, double secondY) {
        return new Line(firstX,  firstY, secondX,  secondY);
    }


    public static Triangle buildTriangle(Point pointOne, Point pointTwo, Point pointThree) {
        return new Triangle(pointOne.getX(), pointOne.getY(), pointTwo.getX(), pointTwo.getY(), pointThree.getX(), pointThree.getY());
    }

    public static Square buildSquare(Point pointOne, Point pointTwo, Point pointThree, Point pointFour) {
        return new Square(pointOne.getX(), pointOne.getY(),
                pointTwo.getX(), pointTwo.getY(),
                pointThree.getX(), pointThree.getY(),
                pointFour.getX(), pointFour.getY());
    }
}
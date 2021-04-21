package com.epam.jwd.model;

import java.util.Arrays;
import java.util.Objects;

public class Line extends Figure implements ValidFigure {
    private final Point[] pointArray;

    public Line( Point[] pointArray) {
            this.pointArray = pointArray;
    }

    public Point[] getPointArray() {
        return pointArray;
    }

    public static double length(Point firstPoint, Point secondPoint) {
        return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(), 2) +
                         Math.pow(secondPoint.getY() - firstPoint.getY(), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Arrays.equals(pointArray, line.pointArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pointArray);
    }

    @Override
    public String toString() {
        return "Line{" +
                "pointArray=" + Arrays.toString(pointArray) +
                '}';
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean containSamePoints() {
        return Arrays.stream(pointArray).distinct().count() != pointArray.length;
    }

    @Override
    public FigureType getFigureType() {
        return FigureType.LINE;
    }
}

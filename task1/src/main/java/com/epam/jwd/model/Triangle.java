package com.epam.jwd.model;

import java.util.Arrays;
import java.util.Objects;

public class Triangle extends Figure implements ValidFigure {
    private final Point[] pointArray;

    public Triangle(Point[] pointArray) {
        this.pointArray = pointArray;
    }

    public Point[] getPointArray() {
        return pointArray;
    }

    @Override
    public FigureType getFigureType() {
        return FigureType.TRIANGLE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(pointArray, triangle.pointArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pointArray);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "pointArray=" + Arrays.toString(pointArray) +
                '}';
    }

    @Override
    public boolean isValid() {
        return (Line.length(pointArray[0], pointArray[1]) + Line.length(pointArray[1], pointArray[2]) <= Line.length(pointArray[2], pointArray[0])) ||
                (Line.length(pointArray[1], pointArray[2]) + Line.length(pointArray[0], pointArray[2]) <= Line.length(pointArray[0], pointArray[1])) ||
                (Line.length(pointArray[0], pointArray[2]) + Line.length(pointArray[1], pointArray[0]) <= Line.length(pointArray[2], pointArray[1]));
    }

    @Override
    public boolean containSamePoints() {
        return Arrays.stream(pointArray).distinct().count() != pointArray.length;
    }
}

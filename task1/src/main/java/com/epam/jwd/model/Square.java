package com.epam.jwd.model;

import java.util.Arrays;
import java.util.Objects;

public class Square extends Figure implements ValidFigure {
    private final Point[] pointArray;

    public Square(Point[] pointArray) {
        this.pointArray = pointArray;
    }

    public Point[] getPointArray() {
        return pointArray;
    }

    @Override
    public FigureType getFigureType() {
        return FigureType.SQUARE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Arrays.equals(pointArray, square.pointArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pointArray);
    }

    @Override
    public String toString() {
        return "Square{" +
                "pointArray=" + Arrays.toString(pointArray) +
                '}';
    }

    @Override
    public boolean isValid() {
        double[] array = new double[]{
                Line.length(pointArray[0],pointArray[1]),
                Line.length(pointArray[2], pointArray[1]),
                Line.length(pointArray[2], pointArray[3]),
                Line.length(pointArray[0], pointArray[3]),
                Line.length(pointArray[0], pointArray[2]),
                Line.length(pointArray[3], pointArray[1])
        };
        Arrays.sort(array);
        return array[0] == array[1] && array[2] == array[3] && array[4] == array[5];
    }

    @Override
    public boolean containSamePoints() {
        return Arrays.stream(pointArray).distinct().count() != pointArray.length;
    }
}

package com.epam.jwd.model;

import java.util.Arrays;

public class MultiAngleFigure extends Figure implements ValidFigure{
    private Point[] pointArray;

    public MultiAngleFigure(Point[] pointArray) {
        this.pointArray = pointArray;
    }

    public Point[] getPointArray() {
        return pointArray;
    }

    public void setPointArray(Point[] pointArray) {
        this.pointArray = pointArray;
    }

    @Override
    public FigureType getFigureType() {
        return FigureType.MULTIANGLE;
    }

    @Override
    public boolean isValid() {
        return pointArray.length <= 6 && pointArray.length >= 4;
    }

    @Override
    public boolean containSamePoints() {
        return Arrays.stream(pointArray).distinct().count() == pointArray.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure that = (MultiAngleFigure) o;
        return Arrays.equals(pointArray, that.pointArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pointArray);
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "pointArray=" + Arrays.toString(pointArray) +
                '}';
    }
}

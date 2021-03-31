package com.epam.jwd.model;

import java.util.Objects;

public class Triangle implements ValidFigure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;

    public Triangle(double firstX, double firstY, double secondX, double secondY, double thirdX, double thirdY) {
        this.firstPoint = new Point(firstX, firstY);
        this.secondPoint = new Point(secondX, secondY);
        this.thirdPoint = new Point(thirdX, thirdY);
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(firstPoint, triangle.firstPoint) &&
                Objects.equals(secondPoint, triangle.secondPoint) &&
                Objects.equals(thirdPoint, triangle.thirdPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, secondPoint, thirdPoint);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                '}';
    }

    @Override
    public boolean isValid() {
        return (Line.length(firstPoint, secondPoint) + Line.length(secondPoint, thirdPoint) <= Line.length(thirdPoint, firstPoint)) ||
                (Line.length(secondPoint, thirdPoint) + Line.length(firstPoint, thirdPoint) <= Line.length(firstPoint, secondPoint)) ||
                (Line.length(firstPoint, thirdPoint) + Line.length(secondPoint, firstPoint) <= Line.length(thirdPoint, secondPoint));
    }

    @Override
    public boolean containSamePoints() {
        return this.firstPoint.equals(this.secondPoint) || this.secondPoint.equals(this.thirdPoint);
    }
}

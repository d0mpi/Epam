package com.epam.jwd.model;

import java.util.Objects;

public class Line implements ValidFigure {
    private final Point firstPoint;
    private final Point secondPoint;

    public Line(double firstX, double firstY, double secondX, double secondY) {
        this.firstPoint = new Point(firstX, firstY);
        this.secondPoint = new Point(secondX, secondY);
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
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
        return Objects.equals(firstPoint, line.firstPoint) && Objects.equals(secondPoint, line.secondPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, secondPoint);
    }

    @Override
    public String toString() {
        return "Line{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                '}';
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean containSamePoints() {
        return this.firstPoint.equals(this.secondPoint);
    }
}

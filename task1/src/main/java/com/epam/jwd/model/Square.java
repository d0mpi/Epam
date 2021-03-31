package com.epam.jwd.model;

import java.util.Arrays;
import java.util.Objects;

public class Square implements ValidFigure {
    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final Point fourthPoint;

    public Square(double firstX, double firstY, double secondX, double secondY, double thirdX, double thirdY, double fourthX, double fourthY) {
        this.firstPoint = new Point(firstX, firstY);
        this.secondPoint = new Point(secondX, secondY);
        this.thirdPoint = new Point(thirdX, thirdY);
        this.fourthPoint = new Point(fourthX, fourthY);
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public Point getFourthPoint() {
        return fourthPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(firstPoint, square.firstPoint) && Objects.equals(secondPoint, square.secondPoint) && Objects.equals(thirdPoint, square.thirdPoint) && Objects.equals(fourthPoint, square.fourthPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, secondPoint, thirdPoint, fourthPoint);
    }

    @Override
    public String toString() {
        return "Square{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                ", fourthPoint=" + fourthPoint +
                '}';
    }

    @Override
    public boolean isValid() {
        double[] array = new double[]{
                Line.length(this.firstPoint, this.secondPoint),
                Line.length(this.thirdPoint, this.secondPoint),
                Line.length(this.thirdPoint, this.fourthPoint),
                Line.length(this.firstPoint, this.fourthPoint),
                Line.length(this.firstPoint, this.thirdPoint),
                Line.length(this.fourthPoint, this.secondPoint)
        };
        Arrays.sort(array);
        return array[0] == array[1] && array[2] == array[3] && array[4] == array[5];
    }

    @Override
    public boolean containSamePoints() {
        return this.firstPoint.equals(this.secondPoint) ||
                this.secondPoint.equals(this.thirdPoint) ||
                this.thirdPoint.equals(this.firstPoint);
    }
}

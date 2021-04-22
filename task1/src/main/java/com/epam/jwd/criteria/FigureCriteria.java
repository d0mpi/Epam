package com.epam.jwd.criteria;

import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.FigureStrategy;

import java.util.ArrayList;

public class FigureCriteria {
    private final Integer id;
    private final FigureType figureType;
    private final FigureStrategy figureStrategy;
    private final ArrayList<Point> pointArrayList;
    private final Integer numberOfAngles;

    public FigureCriteria(Integer id, FigureType figureType, FigureStrategy figureStrategy, ArrayList<Point> pointArrayList, Integer numberOfAngles) {
        this.id = id;
        this.figureType = figureType;
        this.figureStrategy = figureStrategy;
        this.pointArrayList = pointArrayList;
        this.numberOfAngles = numberOfAngles;
    }

    public Integer getId() {
        return id;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public FigureStrategy getFigureStrategy() {
        return figureStrategy;
    }

    public ArrayList<Point> getPointArrayList() {
        return pointArrayList;
    }

    public Integer getNumberOfAngles() {
        return numberOfAngles;
    }
}

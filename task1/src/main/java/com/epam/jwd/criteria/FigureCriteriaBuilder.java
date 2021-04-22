package com.epam.jwd.criteria;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.FigureStrategy;

import java.util.ArrayList;

public class FigureCriteriaBuilder implements Criteria {
    private Integer id;
    private FigureType figureType;
    private FigureStrategy figureStrategy;
    private ArrayList<Point> pointArrayList;
    private Integer numberOfAngles;


    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    @Override
    public void setFigureStrategy(FigureStrategy figureStrategy) {
        this.figureStrategy = figureStrategy;
    }

    @Override
    public void setPointArray(ArrayList<Point> pointArrayList) {
        this.pointArrayList = pointArrayList;
    }

    @Override
    public void setNumberOfAngles(Integer numberOfAngles) {
        this.numberOfAngles = numberOfAngles;
    }

    public FigureCriteria getResultCriteria(){
        return new FigureCriteria(id,figureType,figureStrategy,pointArrayList,numberOfAngles);
    }
}

package com.epam.jwd.model;

import com.epam.jwd.strategy.FigureStrategy;

public abstract class Figure implements ValidFigure {
    private FigureStrategy figurePropertiesStrategy;
    private FigureType figureType;
    private Integer id;

    public void setFigureStrategy(FigureStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public FigureStrategy getFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    public void executeFigurePropertiesStrategy() {
         figurePropertiesStrategy.calculate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void calculateProperties(){
        figurePropertiesStrategy.calculate();
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean containSamePoints() {
        return false;
    }

    public abstract FigureType getFigureType();
}

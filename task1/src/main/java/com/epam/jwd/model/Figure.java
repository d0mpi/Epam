package com.epam.jwd.model;

import com.epam.jwd.strategy.FigureStrategy;

public class Figure implements ValidFigure {
    private FigureStrategy figurePropertiesStrategy;
    private FigureType figureFactoryType;

    public void setFigureStrategy(FigureStrategy figurePropertiesStrategy) {
        this.figurePropertiesStrategy = figurePropertiesStrategy;
    }

    public FigureStrategy executeFigurePropertiesStrategy() {
        return figurePropertiesStrategy;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean containSamePoints() {
        return false;
    }

    @Override
    public FigureType getFigureType() {
        return null;
    }
}

package com.epam.jwd.decorator;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public abstract class FigureDecorator implements FigureFactory {

    @Override
    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        return null;
    }
}

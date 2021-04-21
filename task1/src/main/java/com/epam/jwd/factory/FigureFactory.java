package com.epam.jwd.factory;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public interface FigureFactory {
    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException;
}

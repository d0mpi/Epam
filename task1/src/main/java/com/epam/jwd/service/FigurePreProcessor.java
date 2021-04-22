package com.epam.jwd.service;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.model.Figure;

public interface FigurePreProcessor {
    public Figure process(Figure figure) throws FigureException;
}

package com.epam.jwd.service.impl;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.exeption.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePreProcessor;

public class FigureFirstPreProcessor implements FigurePreProcessor {
    private static FigureFirstPreProcessor figureFirstPreProcessor;

    private static class SingletonHelper{
        private static final FigureFirstPreProcessor INSTANCE = new FigureFirstPreProcessor();
    }

    public static FigureFirstPreProcessor getInstance(){
        return FigureFirstPreProcessor.SingletonHelper.INSTANCE;
    }

    @Override
    public Figure process(Figure figure) throws FigureException {
        return figure;
    }
}

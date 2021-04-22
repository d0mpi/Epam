package com.epam.jwd.service.impl;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.exeption.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.strategy.impl.MultiAnglePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    private static FigureExistencePostProcessor figureExistencePostProcessor;

    private static class SingletonHelper{
        private static final FigureExistencePostProcessor INSTANCE = new FigureExistencePostProcessor();
    }

    public static FigureExistencePostProcessor getInstance(){
        return FigureExistencePostProcessor.SingletonHelper.INSTANCE;
    }

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure.containSamePoints()) {
            throw new FigureNotExistException("Figure is not exist");
        }
        return null;
    }
}

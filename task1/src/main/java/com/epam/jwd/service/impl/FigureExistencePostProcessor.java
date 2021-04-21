package com.epam.jwd.service.impl;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.exeption.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    public static final Logger logger = LogManager.getLogger();

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure.containSamePoints()) {
            throw new FigureNotExistException("Figure is not exist");
        }
        return null;
    }
}

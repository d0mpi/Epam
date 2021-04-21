package com.epam.jwd.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum SquarePerimeterStrategy implements FigureStrategy{

    //Enum singleton
    INSTANCE;
    public static final Logger logger = LogManager.getLogger();


    @Override
    public void calculate() {
        logger.info("Calculating square perimeter...");
    }
}

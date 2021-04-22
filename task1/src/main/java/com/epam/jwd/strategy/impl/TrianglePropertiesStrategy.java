package com.epam.jwd.strategy.impl;

import com.epam.jwd.strategy.FigureStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum TrianglePropertiesStrategy implements FigureStrategy {

    //Enum singleton
    INSTANCE;
    public static final Logger logger = LogManager.getLogger();


    @Override
    public void calculate() {
        logger.info("Calculating triangle properties...");
    }
}

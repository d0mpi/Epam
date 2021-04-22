package com.epam.jwd.strategy.impl;

import com.epam.jwd.strategy.FigureStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquarePropertiesStrategy implements FigureStrategy {

    private static SquarePropertiesStrategy instance;
    public static final Logger logger = LogManager.getLogger();

    private SquarePropertiesStrategy(){}

    //lazy initialization singleton
    public static SquarePropertiesStrategy getInstance(){
        if(instance == null){
            instance = new SquarePropertiesStrategy();
        }
        return instance;
    }

    @Override
    public void calculate() {
        logger.info("Calculating square properties...");
    }
}

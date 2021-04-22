package com.epam.jwd.strategy.impl;

import com.epam.jwd.strategy.FigureStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinePropertiesStrategy implements FigureStrategy {

    private static LinePropertiesStrategy instance;
    public static final Logger logger = LogManager.getLogger();

    private LinePropertiesStrategy(){}

    //thread safe singleton
    public static synchronized LinePropertiesStrategy getInstance(){
        if(instance == null){
            instance = new LinePropertiesStrategy();
        }
        return instance;
    }

    @Override
    public void calculate() {
        logger.info("Calculating line properties...");
    }
}

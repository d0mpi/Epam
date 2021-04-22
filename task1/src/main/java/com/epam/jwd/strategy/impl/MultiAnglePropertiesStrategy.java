package com.epam.jwd.strategy.impl;

import com.epam.jwd.strategy.FigureStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiAnglePropertiesStrategy implements FigureStrategy {

    public static final Logger logger = LogManager.getLogger();

    private MultiAnglePropertiesStrategy(){}

    //Bill Pugh Singleton
    private static class SingletonHelper{
        private static final MultiAnglePropertiesStrategy INSTANCE = new MultiAnglePropertiesStrategy();
    }

    public static MultiAnglePropertiesStrategy getInstance(){
        return SingletonHelper.INSTANCE;
    }

    @Override
    public void calculate() {
        logger.info("Calculating triangle properties...");
    }

}

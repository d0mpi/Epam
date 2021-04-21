package com.epam.jwd.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleAreaStrategy implements FigureStrategy {

    public static final Logger logger = LogManager.getLogger();


    private TriangleAreaStrategy(){}

    //Bill Pugh Singleton
    private static class SingletonHelper{
        private static final TriangleAreaStrategy INSTANCE = new TriangleAreaStrategy();
    }

    public static TriangleAreaStrategy getInstance(){
        return SingletonHelper.INSTANCE;
    }

    @Override
    public void calculate() {
        logger.info("Calculating triangle area...");
    }

}

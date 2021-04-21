package com.epam.jwd.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquareAreaStrategy implements FigureStrategy {

    private static SquareAreaStrategy instance;
    public static final Logger logger = LogManager.getLogger();


    private SquareAreaStrategy(){}

    //lazy initialization singleton
    public static SquareAreaStrategy getInstance(){
        if(instance == null){
            instance = new SquareAreaStrategy();
        }
        return instance;
    }

    @Override
    public void calculate() {
        logger.info("Calculating square area...");
    }
}

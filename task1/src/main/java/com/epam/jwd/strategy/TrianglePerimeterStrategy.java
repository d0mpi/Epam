package com.epam.jwd.strategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrianglePerimeterStrategy implements FigureStrategy{

    public static final Logger logger = LogManager.getLogger();
    public static TrianglePerimeterStrategy instance;

    private TrianglePerimeterStrategy(){}

    //Thread safe singleton
    public static synchronized TrianglePerimeterStrategy getInstance(){
        if(instance == null){
            instance = new TrianglePerimeterStrategy();
        }
        return instance;
    }

    @Override
    public void calculate() {
        logger.info("Calculating triangle perimeter...");
    }
}

package com.epam.jwd.model;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleFigureFactory implements FigureFactory {

    private static SimpleFigureFactory instance;
    public static final Logger logger = LogManager.getLogger();

    private SimpleFigureFactory(){}

    public static SimpleFigureFactory getInstance(){
        if(instance == null){
            instance = new SimpleFigureFactory();
        }
        return instance;
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        Figure multiAngleFigure = switch (figureType) {
            case LINE -> new Line(figureConstituents);
            case TRIANGLE -> new Triangle(figureConstituents);
            case SQUARE -> new Square(figureConstituents);
            case MULTIANGLE -> new MultiAngleFigure(figureConstituents);
        };


        FigureExistencePostProcessor figureExistencePostProcessor = new FigureExistencePostProcessor();
        figureExistencePostProcessor.process(multiAngleFigure);

        return  multiAngleFigure;
    }
}

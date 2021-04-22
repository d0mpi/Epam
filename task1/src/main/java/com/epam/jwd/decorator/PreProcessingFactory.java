package com.epam.jwd.decorator;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.service.impl.FigureFirstPreProcessor;

import java.util.ArrayList;
import java.util.List;

public class PreProcessingFactory extends FigureDecorator {
    private final List<FigurePreProcessor> preProcessors = new ArrayList<>();

    public PreProcessingFactory(FigureFactory factory) {
        super(factory);
        addFigurePreProcessor(FigureFirstPreProcessor.getInstance());
    }

    public boolean addFigurePreProcessor(FigurePreProcessor preProcessor) {
        return preProcessors.add(preProcessor);
    }

    public boolean removePreProcessor(FigurePreProcessor preProcessor) {
        return preProcessors.remove(preProcessor);
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        Figure figure = super.createFigure(figureType, figureConstituents);
        for (FigurePreProcessor preProcessor : preProcessors) {
            preProcessor.process(figure);
        }
        return figure;
    }
}

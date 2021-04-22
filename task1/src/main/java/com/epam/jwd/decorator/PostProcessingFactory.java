package com.epam.jwd.decorator;

import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

import java.util.ArrayList;
import java.util.List;

public class PostProcessingFactory extends FigureDecorator{
    private final List<FigurePostProcessor> postProcessors = new ArrayList<>();

    public void addPostProcessor(FigurePostProcessor postProcessor) {
        this.postProcessors.add(postProcessor);
    }

    public void removePostProcessor(FigurePostProcessor postProcessor) {
        this.postProcessors.remove(postProcessor);
    }
    public PostProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
        addPostProcessor(FigureExistencePostProcessor.getInstance());
    }

    @Override
    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        Figure figure = super.createFigure(figureType, figureConstituents);
        for (FigurePostProcessor postProcessor : postProcessors) {
            postProcessor.process(figure);
        }
        return figure;
    }
}

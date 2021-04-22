package com.epam.jwd.service.impl;

import com.epam.jwd.criteria.Criteria;
import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.exeption.FigureNotExistException;
import com.epam.jwd.factory.ApplicationContext;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FigureCrudImpl implements FigureCrud {

    private final List<Figure> figureStorage = new ArrayList<>();
    private final FigureFactory figureFactory = ApplicationContext.INSTANCE.getFigureFactory();

    private static class SingletonHelper{
        private static final FigureCrudImpl INSTANCE = new FigureCrudImpl();
    }

    public static FigureCrudImpl getInstance(){
        return FigureCrudImpl.SingletonHelper.INSTANCE;
    }


    @Override
    public Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException {
        Figure figure = figureFactory.createFigure(figureType, figureConstituents);
        figureStorage.add(figure);
        return figure;
    }

    @Override
    public List<Figure> multiCreateFigure(FigureType figureType, List<Point[]> figureConstituentsArray) throws FigureException {
        List<Figure> figureArray = new ArrayList<>();
        for(Point[] points : figureConstituentsArray){
            Figure figure = figureFactory.createFigure(figureType, points);
            figureStorage.add(figure);
        }
        return figureArray;
    }

    @Override
    public Figure findFigureByID(Integer id) throws FigureNotExistException {
        if(figureStorage.stream().anyMatch(figure -> figure.getId().equals(id))){
            return figureStorage.stream().filter(figure -> figure.getId().equals(id)).findFirst().orElse(null);
        } else {
            throw new FigureNotExistException("Figure with id:" + id + " does not exist!!!");
        }
    }

    @Override
    public void deleteFigure(Figure figure) {
        figureStorage.remove(figure);
    }

    @Override
    public Figure updateFigureDetails(Criteria criteria) {
        return null;
    }

    @Override
    public List<Figure> findAllMissions() {
        return figureStorage;
    }

    @Override
    public List<Figure> findAllMissionsByCriteria(Criteria criteria) {
        return null;
    }

    @Override
    public Optional<Figure> findMissionByCriteria(Criteria criteria) {
        return Optional.empty();
    }
}

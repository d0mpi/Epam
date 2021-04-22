package com.epam.jwd.service;

import com.epam.jwd.criteria.Criteria;
import com.epam.jwd.exeption.FigureException;
import com.epam.jwd.exeption.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface FigureCrud {

    Figure createFigure(FigureType figureType, Point[] figureConstituents) throws FigureException;

    List<Figure> multiCreateFigure(FigureType figureType, List<Point[]> figureConstituentsArray) throws FigureException;

    Figure findFigureByID(Integer id) throws FigureNotExistException;

    void deleteFigure(Figure figure);

    Figure updateFigureDetails(Criteria criteria);

    List<Figure> findAllMissions();

    List<Figure> findAllMissionsByCriteria(Criteria criteria);

    Optional<Figure> findMissionByCriteria(Criteria criteria);
}


package com.epam.jwd.criteria;

import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.FigureStrategy;

import java.util.ArrayList;

public interface Criteria {
    void setId(Integer id);
    void setFigureType(FigureType figureType);
    void setFigureStrategy(FigureStrategy figureStrategy);
    void setPointArray(ArrayList<Point> pointArrayList);
    void setNumberOfAngles(Integer angleNumber);
}

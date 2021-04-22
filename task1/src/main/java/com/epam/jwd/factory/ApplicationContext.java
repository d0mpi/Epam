package com.epam.jwd.factory;

import com.epam.jwd.decorator.PostProcessingFactory;
import com.epam.jwd.decorator.PreProcessingFactory;
import com.epam.jwd.model.SimpleFigureFactory;

public enum ApplicationContext {
    INSTANCE;

    public FigureFactory getFigureFactory() {
        return new PostProcessingFactory(new PreProcessingFactory(SimpleFigureFactory.getInstance()));
    }
}

package by.epam.repository;

import by.epam.PyramidIdentifiable;
import by.epam.logic.PyramidCalculator;

public class AreaSpecification implements Specification{

    private final Integer minArea;
    private final Integer maxArea;

    public AreaSpecification(Integer minArea, Integer maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(PyramidIdentifiable pyramid) {
        PyramidCalculator calculator = new PyramidCalculator();

        Integer area = (int)calculator.calculateArea(pyramid);

        return area > minArea && area < maxArea;
    }
}

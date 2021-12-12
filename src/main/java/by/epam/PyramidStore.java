package by.epam;

import by.epam.logic.PyramidCalculator;

import java.util.HashMap;
import java.util.Map;

public class PyramidStore implements Observer{

    private static PyramidStore instance;

    private final Map<Integer, Parameters> parameters = new HashMap<>();
    private final PyramidCalculator calculator = new PyramidCalculator();

    public Map<Integer, Parameters> getParameters() {
        return parameters;
    }

    public void update(PyramidIdentifiable pyramid) {
        double capacity = calculator.calculateCapacity(pyramid);
        double area = calculator.calculateArea(pyramid);

        Integer pyramidId = pyramid.getId();
        parameters.put(pyramidId, new Parameters(capacity, area));
    }

    public static PyramidStore getInstance() {
        if (instance == null) {
            instance = new PyramidStore();
        }
        return instance;
    }
}

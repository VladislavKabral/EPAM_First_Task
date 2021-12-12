package by.epam.logic;

import by.epam.data.DataReader;
import by.epam.entity.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private final DataReader dataReader;
    private final PyramidValidator pyramidValidator;
    private final PyramidCreator pyramidCreator;

    public static final Logger LOGGER = LogManager.getLogger();

    public Director(DataReader dataReader, PyramidValidator pyramidValidator, PyramidCreator pyramidCreator) {
        this.dataReader = dataReader;
        this.pyramidValidator = pyramidValidator;
        this.pyramidCreator = pyramidCreator;
        LOGGER.info("Director has created");
    }

    public List<Pyramid> read(String path) throws DataException {
        List<Pyramid> pyramids = new ArrayList<>();
        List<String> lines = dataReader.read(path);

        for (String line: lines) {
            if (pyramidValidator.isValidLine(line)) {
                Pyramid pyramid = pyramidCreator.create(line);
                pyramids.add(pyramid);
            }
        }
        return pyramids;
    }
}

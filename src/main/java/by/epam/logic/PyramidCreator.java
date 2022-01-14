package by.epam.logic;

import by.epam.entity.Point;
import by.epam.entity.Pyramid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PyramidCreator {

    public static final Logger LOGGER = LogManager.getLogger();

    public Pyramid create (String inputData) {
        String[] dividedData = inputData.split(" ");

        double xCoordinateOfFirstPoint = Double.parseDouble(dividedData[0]);
        double yCoordinateOfFirstPoint = Double.parseDouble(dividedData[1]);
        double zCoordinateOfFirstPoint = Double.parseDouble(dividedData[2]);
        double xCoordinateOfSecondPoint = Double.parseDouble(dividedData[3]);
        double yCoordinateOfSecondPoint = Double.parseDouble(dividedData[4]);
        double zCoordinateOfSecondPoint = Double.parseDouble(dividedData[5]);
        double xCoordinateOfThirdPoint = Double.parseDouble(dividedData[6]);
        double yCoordinateOfThirdPoint = Double.parseDouble(dividedData[7]);
        double zCoordinateOfThirdPoint = Double.parseDouble(dividedData[8]);
        double xCoordinateOfFourthPoint = Double.parseDouble(dividedData[9]);
        double yCoordinateOfFourthPoint = Double.parseDouble(dividedData[10]);
        double zCoordinateOfFourthPoint = Double.parseDouble(dividedData[11]);
        double xCoordinateOfFifthPoint = Double.parseDouble(dividedData[12]);
        double yCoordinateOfFifthPoint = Double.parseDouble(dividedData[13]);
        double zCoordinateOfFifthPoint = Double.parseDouble(dividedData[14]);
        double height = Double.parseDouble(dividedData[15]);

        LOGGER.info("Pyramid has created");

        return new Pyramid(new Point(xCoordinateOfFirstPoint, yCoordinateOfFirstPoint, zCoordinateOfFirstPoint),
                           new Point(xCoordinateOfSecondPoint, yCoordinateOfSecondPoint, zCoordinateOfSecondPoint),
                           new Point(xCoordinateOfThirdPoint, yCoordinateOfThirdPoint, zCoordinateOfThirdPoint),
                           new Point(xCoordinateOfFourthPoint, yCoordinateOfFourthPoint, zCoordinateOfFourthPoint),
                           new Point(xCoordinateOfFifthPoint, yCoordinateOfFifthPoint, zCoordinateOfFifthPoint),
                           height);
    }
}

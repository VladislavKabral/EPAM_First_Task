package by.epam.repository;

import by.epam.PyramidIdentifiable;
import by.epam.entity.Point;

public class PointSpecification implements Specification{

    @Override
    public boolean specified(PyramidIdentifiable pyramid) {
        Point firstPoint = pyramid.getFirstPoint();
        Point secondPoint = pyramid.getSecondPoint();
        Point thirdPoint = pyramid.getThirdPoint();
        Point fourthPoint = pyramid.getFourthPoint();
        Point fifthPoint = pyramid.getFifthPoint();

        return firstPoint.getxCoordinate() > 0 && firstPoint.getyCoordinate() > 0 && firstPoint.getzCoordinate() > 0
                && secondPoint.getxCoordinate() > 0 && secondPoint.getyCoordinate() > 0 && secondPoint.getzCoordinate() > 0
                && thirdPoint.getxCoordinate() > 0 && thirdPoint.getyCoordinate() > 0 && thirdPoint.getzCoordinate() > 0
                && fourthPoint.getxCoordinate() > 0 && fourthPoint.getyCoordinate() > 0 && fourthPoint.getzCoordinate() > 0
                && fifthPoint.getxCoordinate() > 0 && fifthPoint.getyCoordinate() > 0 && fifthPoint.getzCoordinate() > 0;
    }
}

package by.epam.logic;

import by.epam.entity.Axis;
import by.epam.entity.Point;
import by.epam.entity.Pyramid;

public class PyramidCalculator {
    public boolean isPyramid(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, Point fifthPoint, double height) {
        boolean isXCoordinateEqual = (firstPoint.getxCoordinate() == secondPoint.getxCoordinate())
                                  && (secondPoint.getxCoordinate() == thirdPoint.getxCoordinate())
                                  && (thirdPoint.getxCoordinate() == fourthPoint.getxCoordinate())
                                  && (firstPoint.getxCoordinate() == fourthPoint.getxCoordinate());

        boolean isYCoordinateEqual = (firstPoint.getyCoordinate() == secondPoint.getyCoordinate())
                                  && (secondPoint.getyCoordinate() == thirdPoint.getyCoordinate())
                                  && (thirdPoint.getyCoordinate() == fourthPoint.getyCoordinate())
                                  && (firstPoint.getyCoordinate() == fourthPoint.getyCoordinate());

        boolean isZCoordinateEqual = (firstPoint.getzCoordinate() == secondPoint.getzCoordinate())
                                  && (secondPoint.getzCoordinate() == thirdPoint.getzCoordinate())
                                  && (thirdPoint.getzCoordinate() == fourthPoint.getzCoordinate())
                                  && (firstPoint.getzCoordinate() == fourthPoint.getzCoordinate());;

        boolean isBaseExist = isXCoordinateEqual || isYCoordinateEqual || isZCoordinateEqual;

        return (height > 0) && isBaseExist;
    }

    private double calculateDistanceBetweenTwoPoints(Point firstPoint, Point secondPoint) {
        double xDifference = Math.pow(firstPoint.getxCoordinate() - secondPoint.getxCoordinate(), 2);
        double yDifference = Math.pow(firstPoint.getyCoordinate() - secondPoint.getyCoordinate(), 2);
        double zDifference = Math.pow(firstPoint.getzCoordinate() - secondPoint.getzCoordinate(), 2);
        return Math.sqrt(xDifference + yDifference + zDifference);
    }

    private double calculateSemiPerimeter(double firstSide, double secondSide, double thirdSide) {
        return (firstSide + secondSide + thirdSide) / 2;
    }

    private double calculateAreaOfTriangle(double firstSide, double secondSide, double thirdSide) {
        double semiPerimeter = calculateSemiPerimeter(firstSide, secondSide, thirdSide);
        return (Math.sqrt(semiPerimeter * (semiPerimeter - firstSide)
                                        * (semiPerimeter - secondSide)
                                        * (semiPerimeter - thirdSide)));
    }

    private double calculateAreaOfBase(double side) {
        return side * side;
    }

    public double calculateArea(Pyramid pyramid) {
        double areaOfBase = calculateAreaOfBase(calculateDistanceBetweenTwoPoints(pyramid.getFirstPoint(), pyramid.getSecondPoint()));

        double firstSide = calculateDistanceBetweenTwoPoints(pyramid.getFirstPoint(), pyramid.getSecondPoint());
        double secondSide = calculateDistanceBetweenTwoPoints(pyramid.getFirstPoint(), pyramid.getFifthPoint());
        double thirdSide = calculateDistanceBetweenTwoPoints(pyramid.getSecondPoint(), pyramid.getFifthPoint());
        double areaOfFirstTriangle = calculateAreaOfTriangle(firstSide, secondSide, thirdSide);

        firstSide = calculateDistanceBetweenTwoPoints(pyramid.getSecondPoint(), pyramid.getThirdPoint());
        secondSide = calculateDistanceBetweenTwoPoints(pyramid.getSecondPoint(), pyramid.getFifthPoint());
        thirdSide = calculateDistanceBetweenTwoPoints(pyramid.getThirdPoint(), pyramid.getFifthPoint());
        double areaOfSecondTriangle = calculateAreaOfTriangle(firstSide, secondSide, thirdSide);

        firstSide = calculateDistanceBetweenTwoPoints(pyramid.getThirdPoint(), pyramid.getFourthPoint());
        secondSide = calculateDistanceBetweenTwoPoints(pyramid.getThirdPoint(), pyramid.getFifthPoint());
        thirdSide = calculateDistanceBetweenTwoPoints(pyramid.getFourthPoint(), pyramid.getFifthPoint());
        double areaOfThirdTriangle = calculateAreaOfTriangle(firstSide, secondSide, thirdSide);

        firstSide = calculateDistanceBetweenTwoPoints(pyramid.getFirstPoint(), pyramid.getFourthPoint());
        secondSide = calculateDistanceBetweenTwoPoints(pyramid.getFirstPoint(), pyramid.getFifthPoint());
        thirdSide = calculateDistanceBetweenTwoPoints(pyramid.getFourthPoint(), pyramid.getFifthPoint());
        double areaOfFourthTriangle = calculateAreaOfTriangle(firstSide, secondSide, thirdSide);

        return areaOfBase + areaOfFirstTriangle + areaOfSecondTriangle + areaOfThirdTriangle + areaOfFourthTriangle;
    }

    public double calculateCapacity(Pyramid pyramid) {
        double areaOfBase = calculateAreaOfBase(calculateDistanceBetweenTwoPoints(pyramid.getFirstPoint(), pyramid.getSecondPoint()));

        return areaOfBase * pyramid.getHeight() / 3;
    }

    public boolean isBaseOfPyramidLocatedOnAxis(Pyramid pyramid) {
        boolean result = false;

        Point firstPoint = pyramid.getFirstPoint();
        Point secondPoint = pyramid.getSecondPoint();
        Point thirdPoint = pyramid.getThirdPoint();
        Point fourthPoint = pyramid.getFourthPoint();

        double xCoordinateOfFirstPoint = firstPoint.getxCoordinate();
        double yCoordinateOfFirstPoint = firstPoint.getyCoordinate();
        double zCoordinateOfFirstPoint = firstPoint.getzCoordinate();

        double xCoordinateOfSecondPoint = secondPoint.getxCoordinate();
        double yCoordinateOfSecondPoint = secondPoint.getyCoordinate();
        double zCoordinateOfSecondPoint = thirdPoint.getzCoordinate();

        double xCoordinateOfThirdPoint = thirdPoint.getxCoordinate();
        double yCoordinateOfThirdPoint = thirdPoint.getyCoordinate();
        double zCoordinateOfThirdPoint = thirdPoint.getzCoordinate();

        double xCoordinateOfFourthPoint = fourthPoint.getxCoordinate();
        double yCoordinateOfFourthPoint = fourthPoint.getyCoordinate();
        double zCoordinateOfFourthPoint = fourthPoint.getzCoordinate();

        if (xCoordinateOfFirstPoint == 0 && xCoordinateOfSecondPoint == 0 && xCoordinateOfThirdPoint == 0 && xCoordinateOfFourthPoint == 0) {
            result = true;
        } else if (yCoordinateOfFirstPoint == 0 && yCoordinateOfSecondPoint == 0 && yCoordinateOfThirdPoint == 0 && yCoordinateOfFourthPoint == 0) {
            result = true;
        } else if (zCoordinateOfFirstPoint == 0 && zCoordinateOfSecondPoint == 0 && zCoordinateOfThirdPoint == 0 && zCoordinateOfFourthPoint == 0) {
            result = true;
        }

        return result;
    }

    private double calculateAreaOfTruncatedPart(double firstHeight, double secondHeight, double area) {
        return area * Math.pow(firstHeight, 2) / Math.pow(secondHeight, 2);
    }

    public double calculateRatio(Pyramid pyramid, Axis axis) {
        double truncatedHeight;
        double height = pyramid.getHeight();
        double area = calculateArea(pyramid);
        double truncatedArea;
        double truncatedCapacity = 0;
        Point firstPointOfTheHeight = pyramid.getFifthPoint();

        switch (axis) {
            case XY:
                double zCoordinateOfTheFirstPointOfTheHeight = firstPointOfTheHeight.getzCoordinate();
                truncatedHeight = Math.abs(zCoordinateOfTheFirstPointOfTheHeight);
                truncatedArea = calculateAreaOfTruncatedPart(truncatedHeight, height, area);
                truncatedCapacity = truncatedArea * truncatedHeight / 3;
                break;
            case XZ:
                double yCoordinateOfTheFirstPointOfTheHeight = firstPointOfTheHeight.getyCoordinate();
                truncatedHeight = Math.abs(yCoordinateOfTheFirstPointOfTheHeight);
                truncatedArea = calculateAreaOfTruncatedPart(truncatedHeight, height, area);
                truncatedCapacity = truncatedArea * truncatedHeight / 3;
                break;
            case YZ:
                double xCoordinateOfTheFirstPointOfTheHeight = firstPointOfTheHeight.getxCoordinate();
                truncatedHeight = Math.abs(xCoordinateOfTheFirstPointOfTheHeight);
                truncatedArea = calculateAreaOfTruncatedPart(truncatedHeight, height, area);
                truncatedCapacity = truncatedArea * truncatedHeight / 3;
                break;
        }

        double capacity = calculateCapacity(pyramid);

        return (capacity - truncatedCapacity) / truncatedCapacity;
    }
}
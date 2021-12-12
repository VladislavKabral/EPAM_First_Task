package by.epam.entity;

import java.util.Objects;

public class Pyramid {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private Point fourthPoint;
    private Point fifthPoint;
    private double height;

    public Pyramid(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, Point fifthPoint, double height) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;
        this.fifthPoint = fifthPoint;
        this.height = height;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }
    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }
    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }
    public void setFourthPoint(Point fourthPoint) {
        this.fourthPoint = fourthPoint;
    }
    public void setFifthPoint(Point fifthPoint) {
        this.fifthPoint = fifthPoint;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }
    public Point getSecondPoint() {
        return secondPoint;
    }
    public Point getThirdPoint() {
        return thirdPoint;
    }
    public Point getFourthPoint() {
        return fourthPoint;
    }
    public Point getFifthPoint() {
        return fifthPoint;
    }
    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Pyramid pyramid = (Pyramid) object;
        return Double.compare(pyramid.height, height) == 0
                && Objects.equals(firstPoint, pyramid.firstPoint)
                && Objects.equals(secondPoint, pyramid.secondPoint)
                && Objects.equals(thirdPoint, pyramid.thirdPoint)
                && Objects.equals(fourthPoint, pyramid.fourthPoint)
                && Objects.equals(fifthPoint, pyramid.fifthPoint);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstPoint == null) ? 0 : firstPoint.hashCode())
                                + ((secondPoint == null) ? 0 : secondPoint.hashCode())
                                + ((thirdPoint == null) ? 0 : thirdPoint.hashCode())
                                + ((fourthPoint == null) ? 0 : fourthPoint.hashCode())
                                + ((fifthPoint == null) ? 0 : fifthPoint.hashCode())
                                + (int)height;
        return result;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                ", fourthPoint=" + fourthPoint +
                ", fifthPoint=" + fifthPoint +
                ", height=" + height +
                '}';
    }
}

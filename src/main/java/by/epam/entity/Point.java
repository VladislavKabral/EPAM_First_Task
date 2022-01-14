package by.epam.entity;

import java.util.Objects;

public class Point {
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public Point(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }
    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }
    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getzCoordinate() { return zCoordinate;}
    public void setzCoordinate(double zCoordinate) { this.zCoordinate = zCoordinate; }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Point point = (Point) object;
        return Double.compare(point.xCoordinate, xCoordinate) == 0
                && Double.compare(point.yCoordinate, yCoordinate) == 0
                && Double.compare(point.zCoordinate, zCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)(xCoordinate + yCoordinate + zCoordinate);
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", zCoordinate=" + zCoordinate +
                '}';
    }
}

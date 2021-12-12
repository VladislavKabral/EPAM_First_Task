package by.epam;

import by.epam.entity.Point;
import by.epam.entity.Pyramid;

import java.util.ArrayList;
import java.util.List;

public class PyramidIdentifiable extends Pyramid implements Observable {

    private final Integer id;
    private final List<Observer> observers = new ArrayList<>();

    public PyramidIdentifiable(Integer id, Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint, Point fifthPoint, double height) {
        super(firstPoint, secondPoint, thirdPoint, fourthPoint, fifthPoint, height);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void setFirstPoint(Point firstPoint) {
        super.setFirstPoint(firstPoint);
        notifyObservers();
    }

    @Override
    public void setSecondPoint(Point secondPoint) {
        super.setSecondPoint(secondPoint);
        notifyObservers();
    }

    @Override
    public void setThirdPoint(Point thirdPoint) {
        super.setThirdPoint(thirdPoint);
        notifyObservers();
    }

    @Override
    public void setFourthPoint(Point fourthPoint) {
        super.setFourthPoint(fourthPoint);
        notifyObservers();
    }

    @Override
    public void setFifthPoint(Point fifthPoint) {
        super.setFifthPoint(fifthPoint);
        notifyObservers();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }
}

package by.epam.repository;

import by.epam.PyramidIdentifiable;

public class IdSpecification implements Specification{

    private final Integer id;

    public IdSpecification(final Integer id) {
        this.id = id;
    }

    @Override
    public boolean specified(PyramidIdentifiable pyramid) {
        Integer pyramidId = pyramid.getId();
        return pyramidId.equals(id);
    }
}

package by.epam.repository;

import by.epam.PyramidIdentifiable;

import java.util.Comparator;
import java.util.List;

public interface PyramidRepository {

    void add(PyramidIdentifiable pyramid);
    void delete(PyramidIdentifiable pyramid);
    void update(PyramidIdentifiable pyramid);

    List<PyramidIdentifiable> query(final Specification specification);
    List<PyramidIdentifiable> sort(Comparator<PyramidIdentifiable> comparator);
}

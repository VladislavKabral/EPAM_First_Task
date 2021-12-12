package by.epam.repository;

import by.epam.PyramidIdentifiable;

import java.util.*;

public class PyramidRepositoryImpl implements PyramidRepository{

    private Map<Integer, PyramidIdentifiable> store = new HashMap<>();

    @Override
    public void add(PyramidIdentifiable pyramid) {
        Integer id = pyramid.getId();
        store.put(id, pyramid);
    }

    @Override
    public void delete(PyramidIdentifiable pyramid) {
        Integer id = pyramid.getId();
        store.remove(id, pyramid);
    }

    @Override
    public void update(PyramidIdentifiable pyramid) {
        Integer id = pyramid.getId();
        store.put(id, pyramid);
    }

    @Override
    public List<PyramidIdentifiable> query(Specification specification) {
        List<PyramidIdentifiable> pyramids = new ArrayList<>();
        for (PyramidIdentifiable pyramid: store.values()) {
            if (specification.specified(pyramid)) {
                pyramids.add(pyramid);
            }
        }
        return pyramids;
    }

    @Override
    public List<PyramidIdentifiable> sort(Comparator<PyramidIdentifiable> comparator) {
        List<PyramidIdentifiable> result = new ArrayList<>(store.values());
        result.sort(comparator);
        return result;
    }
}

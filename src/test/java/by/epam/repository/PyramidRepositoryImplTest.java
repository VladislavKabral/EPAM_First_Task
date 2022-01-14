package by.epam.repository;

import by.epam.PyramidIdentifiable;
import by.epam.entity.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PyramidRepositoryImplTest {

    private final PyramidIdentifiable firstPyramid = new PyramidIdentifiable(1, new Point(5.0, 1.0, 0.0),
            new Point(1.0, 1.0, 0.0),
            new Point(1.0, 5.0, 0.0),
            new Point(5.0, 5.0, 0.0),
            new Point(2.5, 2.5, 5.0),
            5.0);
    private final PyramidIdentifiable secondPyramid = new PyramidIdentifiable(2, new Point(5.0, 1.0, -5.0),
            new Point(1.0, 1.0, -5.0),
            new Point(1.0, 5.0, -5.0),
            new Point(5.0, 5.0, -5.0),
            new Point(2.5, 2.5, -5.0),
            10.0);

    @Test
    public void testQueryShouldReturnPyramidsWhenAreaInGivenRange() {
        //given
        PyramidRepository repository = new PyramidRepositoryImpl();
        repository.add(firstPyramid);
        repository.add(secondPyramid);
        List<PyramidIdentifiable> expectedQuery = Arrays.asList(firstPyramid, secondPyramid);

        //when
        List<PyramidIdentifiable> realQuery = repository.query(new AreaSpecification(10, 100));

        //then
        Assert.assertEquals(expectedQuery, realQuery);
    }

    @Test
    public void testQueryShouldReturnPyramidsWhenIdMatches() {
        //given
        PyramidRepository repository = new PyramidRepositoryImpl();
        repository.add(firstPyramid);
        repository.add(secondPyramid);
        List<PyramidIdentifiable> expectedQuery = Arrays.asList(firstPyramid);

        //when
        List<PyramidIdentifiable> realQuery = repository.query(new IdSpecification(1));

        //then
        Assert.assertEquals(expectedQuery, realQuery);
    }

    @Test
    public void testQueryShouldReturnPyramidsWhenInPoint() {
        //given
        PyramidRepository repository = new PyramidRepositoryImpl();
        repository.add(firstPyramid);
        repository.add(secondPyramid);
        List<PyramidIdentifiable> expectedQuery = Arrays.asList(firstPyramid, secondPyramid);

        //when
        List<PyramidIdentifiable> realQuery = repository.query(new PointSpecification());

        //then
        Assert.assertEquals(expectedQuery, realQuery);
    }

    @Test
    public void testQueryShouldNotReturnPyramidsWhenDoesNotFitSpecification() {
        //given
        PyramidRepository repository = new PyramidRepositoryImpl();
        repository.add(firstPyramid);
        repository.add(secondPyramid);
        Specification specification = Mockito.mock(Specification.class);
        Mockito.when(specification.specified(firstPyramid)).thenReturn(false);
        Mockito.when(specification.specified(secondPyramid)).thenReturn(false);
        List<PyramidIdentifiable> expectedQuery = new ArrayList<>();

        //when
        List<PyramidIdentifiable> realQuery = repository.query(specification);

        //then
        Assert.assertEquals(expectedQuery, realQuery);
    }

    @Test
    public void testSortShouldSortDataByHeightWhenDataIsValid() {
        //given
        PyramidRepository repository = new PyramidRepositoryImpl();
        repository.add(firstPyramid);
        repository.add(secondPyramid);
        List<PyramidIdentifiable> expectedQuery = Arrays.asList(firstPyramid, secondPyramid);
        Comparator<PyramidIdentifiable> comparator = Comparator.comparing(PyramidIdentifiable::getHeight);

        //when
        List<PyramidIdentifiable> realQuery = repository.sort(comparator);

        //then
        Assert.assertEquals(expectedQuery, realQuery);
    }

    @Test
    public void testSortShouldSortDataByIdWhenDataIsValid() {
        //given
        PyramidRepository repository = new PyramidRepositoryImpl();
        repository.add(secondPyramid);
        repository.add(firstPyramid);
        List<PyramidIdentifiable> expectedQuery = Arrays.asList(firstPyramid, secondPyramid);
        Comparator<PyramidIdentifiable> comparator = Comparator.comparing(PyramidIdentifiable::getId);

        //when
        List<PyramidIdentifiable> realQuery = repository.sort(comparator);

        //then
        Assert.assertEquals(expectedQuery, realQuery);
    }
}

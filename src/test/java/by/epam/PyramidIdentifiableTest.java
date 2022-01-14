package by.epam;

import by.epam.entity.Point;
import org.junit.Assert;
import org.junit.Test;

public class PyramidIdentifiableTest {

    private static final double EPSILON = 0.000000001;

    @Test
    public void testNotifyObserverShouldChangeParametersWhenDataChanged() {
        //given
        PyramidIdentifiable pyramid = new PyramidIdentifiable(1, new Point(5.0, 1.0, 0.0),
                new Point(1.0, 1.0, 0.0),
                new Point(1.0,5.0, 0.0),
                new Point(5.0, 5.0, 0.0),
                new Point(2.5, 2.5, 5.0), 5);

        PyramidStore store = PyramidStore.getInstance();
        pyramid.attach(store);

        //when
        pyramid.setHeight(10);

        //then
        Assert.assertEquals(53.333333333333332, store.getParameters().get(1).getCapacity(), EPSILON);
    }
}

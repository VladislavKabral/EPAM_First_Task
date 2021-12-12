package by.epam.logic;

import by.epam.entity.Point;
import by.epam.entity.Pyramid;
import org.junit.Assert;
import org.junit.Test;

public class PyramidCreatorTest {

    @Test
    public void testCreateShouldCreatePyramidWhenDataValid() {
        //given
        PyramidCreator creator = new PyramidCreator();
        Pyramid pyramid = new Pyramid(new Point(5.0, 1.0, 0.0),
                                      new Point(1.0, 1.0, 0.0),
                                      new Point(1.0,5.0, 0.0),
                                      new Point(5.0, 5.0, 0.0),
                                      new Point(2.5, 2.5, 5.0), 5);

        String inputData = "5.0 1.0 0.0 1.0 1.0 0.0 1.0 5.0 0.0 5.0 5.0 0.0 2.5 2.5 5.0 5.0";
        //when
        Pyramid createdPyramid = creator.create(inputData);

        //then
        Assert.assertEquals(pyramid, createdPyramid);
    }

    @Test
    public void testCreateShouldCreatePyramidWhenDataInvalid() {
        //given
        PyramidCreator creator = new PyramidCreator();
        Pyramid pyramid = new Pyramid(new Point(5.0, 1.0, 0.0),
                                      new Point(1.0, 1.0, 0.0),
                                      new Point(1.0,5.0, 0.0),
                                      new Point(5.0, 5.0, 0.0),
                                      new Point(2.5, 2.5, 5.0), 5);

        String inputData = "5.0 1.0 0.0 1.0 1.0 0.0 1.0 5.0 0.0 5.0 5.0 0.0 2.5 2.5 5.0 -5";
        //when
        Pyramid createdPyramid = creator.create(inputData);

        //then
        Assert.assertEquals(pyramid, createdPyramid);
    }
}

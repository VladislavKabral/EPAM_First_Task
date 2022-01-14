package by.epam.logic;

import by.epam.data.DataReader;
import by.epam.entity.Point;
import by.epam.entity.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DirectorTest {

    public static final String FIRST_VALID_STRING = "5.0 1.0 0.0 1.0 1.0 0.0 1.0 5.0 0.0 5.0 5.0 0.0 2.5 2.5 5.0 5.0";
    public static final String SECOND_VALID_STRING = "5.0 1.0 -5.0 1.0 1.0 -5.0 1.0 5.0 -5.0 5.0 5.0 -5.0 2.5 2.5 5.0 10.0";
    public static final String FIRST_INVALID_STRING = "5.0 1.0 l0.0 1.0 1.0 0.0 1.0 5.0 0.0 5.0 5.0 0.0 2.5 2.5 5.0 5.0";
    public static final String SECOND_INVALID_STRING = "5.0 1.0 /0.0 1.0 1.0 0.0 1.0 5.0 0.0 5.0 5.0 0.0 2.5 2.5 5.0 5.0";

    public static final Pyramid FIRST_VALID_PYRAMID = new Pyramid(new Point(5.0, 1.0, 0.0),
                                                                  new Point(1.0, 1.0, 0.0),
                                                                  new Point(1.0, 5.0, 0.0),
                                                                  new Point(5.0, 5.0, 0.0),
                                                                  new Point(2.5, 2.5, 5.0),
                                                            5.0);
    public static final Pyramid SECOND_VALID_PYRAMID = new Pyramid(new Point(5.0, 1.0, -5.0),
                                                                   new Point(1.0, 1.0, -5.0),
                                                                   new Point(1.0, 5.0, -5.0),
                                                                   new Point(5.0, 5.0, -5.0),
                                                                   new Point(2.5, 2.5, -5.0),
                                                             10.0);

    public static final String FILE_PATH = "filepath";

    @Test
    public void testReadShouldReturnListWhenDataAreValid() throws DataException {
        //given
        List<String> readLines = Arrays.asList(FIRST_VALID_STRING, SECOND_VALID_STRING);

        PyramidValidator validator = Mockito.mock(PyramidValidator.class);
        Mockito.when(validator.isValidLine(FIRST_VALID_STRING)).thenReturn(true);
        Mockito.when(validator.isValidLine(SECOND_VALID_STRING)).thenReturn(true);

        PyramidCreator creator = Mockito.mock(PyramidCreator.class);
        Mockito.when(creator.create(FIRST_VALID_STRING)).thenReturn(FIRST_VALID_PYRAMID);
        Mockito.when(creator.create(SECOND_VALID_STRING)).thenReturn(SECOND_VALID_PYRAMID);

        DataReader reader = Mockito.mock(DataReader.class);
        Mockito.when(reader.read(FILE_PATH)).thenReturn(readLines);

        Director director = new Director(reader, validator, creator);
        List<Pyramid> expectedPyramids = Arrays.asList(FIRST_VALID_PYRAMID, SECOND_VALID_PYRAMID);

        //when
        List<Pyramid> madePyramids = director.read(FILE_PATH);

        //then
        Assert.assertEquals(expectedPyramids, madePyramids);
        Assert.assertEquals(2, madePyramids.size());

        Mockito.verify(reader, Mockito.times(1)).read(FILE_PATH);
    }

    @Test
    public void testReadShouldNotReturnListWhenDataAreInvalid() throws DataException {
        //given
        List<String> readLines = Arrays.asList(FIRST_INVALID_STRING, SECOND_INVALID_STRING, FIRST_VALID_STRING);

        PyramidValidator validator = Mockito.mock(PyramidValidator.class);
        Mockito.when(validator.isValidLine(FIRST_INVALID_STRING)).thenReturn(false);
        Mockito.when(validator.isValidLine(SECOND_INVALID_STRING)).thenReturn(false);
        Mockito.when(validator.isValidLine(FIRST_VALID_STRING)).thenReturn(true);

        PyramidCreator creator = Mockito.mock(PyramidCreator.class);
        Mockito.when(creator.create(FIRST_VALID_STRING)).thenReturn(FIRST_VALID_PYRAMID);

        DataReader reader = Mockito.mock(DataReader.class);
        Mockito.when(reader.read(FILE_PATH)).thenReturn(readLines);

        Director director = new Director(reader, validator, creator);
        List<Pyramid> expectedPyramids = Arrays.asList(FIRST_VALID_PYRAMID);

        //when
        List<Pyramid> madePyramids = director.read(FILE_PATH);

        //then
        Assert.assertEquals(expectedPyramids, madePyramids);
        Assert.assertEquals(1, madePyramids.size());
    }
}

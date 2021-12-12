package by.epam.data;

import by.epam.logic.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private final DataReader dataReader = new DataReader();

    @Test
    public void testReadShouldReturnArrayWhenPathValid() throws DataException {
        //given
        String path = "src\\main\\resources\\Data.txt";
        List<String> expectedLines = Arrays.asList("5.0 1.0 0.0 1.0 1.0 0.0 1.0 5.0 0.0 5.0 5.0 0.0 2.5 2.5 5.0 5.0",
                                                   "5.0 1.0 -5.0 1.0 1.0 -5.0 1.0 5.0 -5.0 5.0 5.0 -5.0 2.5 2.5 5.0 10.0",
                                                   "z5.0 1.0 0.0 1.0 h1.0 0.0 1.0 5.0 0.0 5.0 h5.0 0.0 2.5 2.5 5.0 5.0");

        //when
        List<String> readLines = dataReader.read(path);

        //then
        Assert.assertEquals(expectedLines, readLines);
    }

    @Test(expected = DataException.class)
    public void testReadShouldNotReadWhenPathInvalid() throws Exception {
        //given
        String path = "InvalidPath";

        //when
        List<String> readLines = dataReader.read(path);
    }
}

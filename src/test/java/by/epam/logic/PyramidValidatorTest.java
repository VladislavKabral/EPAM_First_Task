package by.epam.logic;

import org.junit.Assert;
import org.junit.Test;

public class PyramidValidatorTest {

    @Test
    public void testIsValidLineShouldReturnTrueWhenLineValid() {
        //given
        PyramidValidator validator = new PyramidValidator();
        String validLine = "5.0 1.0 0.0 1.0 1.0 0.0 1.0 5.0 0.0 5.0 5.0 0.0 2.5 2.5 5.0 5.0";

        //when
        boolean isValid = validator.isValidLine(validLine);

        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testIsValidLineShouldReturnFalseWhenLineInvalid() {
        //given
        PyramidValidator validator = new PyramidValidator();
        String invalidLine = "z5.0 1.0 0.0 1.0 h1.0 0.0 1.0 5.0 0.0 5.0 h5.0 0.0 2.5 2.5 5.0 5.0";

        //when
        boolean isValid = validator.isValidLine(invalidLine);

        //then
        Assert.assertFalse(isValid);
    }
}

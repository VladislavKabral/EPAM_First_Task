package by.epam.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class PyramidValidator {
    private static final String PYRAMID_REG_EXPR = "((-)?\\d+\\.\\d+ ){15}\\d+\\.\\d+";
    public static final Logger LOGGER = LogManager.getLogger();

    public boolean isValidLine(String line) {
        LOGGER.info("Line have been validated");
        return Pattern.matches(PYRAMID_REG_EXPR, line);
    }
}

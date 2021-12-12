package by.epam.data;


import by.epam.logic.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static final Logger LOGGER = LogManager.getLogger();

    public List<String> read(String path) throws DataException {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            LOGGER.info("Data from file has read");

        } catch (FileNotFoundException e) {
            LOGGER.warn("Caught " + e.getMessage());
            throw new DataException("Could not find the file", e);
        } catch (IOException e) {
            LOGGER.warn("Caught " + e.getMessage());
            throw  new DataException("Could not read data from file", e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    LOGGER.warn("Caught " + e.getMessage());
                }
            }
        }
        return result;
    }
}
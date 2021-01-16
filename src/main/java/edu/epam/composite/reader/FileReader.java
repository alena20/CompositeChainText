package edu.epam.composite.reader;

import edu.epam.composite.exception.FileReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

    public String read(String fileName) throws FileReaderException {
        try {
            String data = new String(Files.readAllBytes(Paths.get(fileName)));
            LOGGER.info("File '{}' was successfully read", fileName);
            return data;
        } catch (IOException e) {
            throw new FileReaderException("Error during reading file!",
                    e);
        } catch (NullPointerException e) {
            throw new FileReaderException("File is empty!", e);
        }
    }
}

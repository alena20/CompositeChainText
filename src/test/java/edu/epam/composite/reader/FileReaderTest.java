package edu.epam.composite.reader;

import edu.epam.composite.data.DataProvider;
import edu.epam.composite.exception.FileReaderException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileReaderTest {
    private final FileReader reader = new FileReader();

    @Test
    public void testRead() throws FileReaderException {
        String actual = reader.read("input\\text.txt");
        String expected = DataProvider.TEXT_SOURCE;
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = FileReaderException.class,
            expectedExceptionsMessageRegExp = "Error during reading file!")
    public void testReadCaughtIOException() throws FileReaderException {
        reader.read("blabla");
    }

    @Test(expectedExceptions = FileReaderException.class,
            expectedExceptionsMessageRegExp = "Null pointer detected!")
    public void testReadCaughtNullException() throws FileReaderException {
        reader.read(null);
    }
}
package edu.epam.composite.parser.impl;

import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.data.DataProvider;
import edu.epam.composite.parser.ITextParser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceParserTest {
    private final ITextParser parser = SentenceParser.getInstance();

    @Test
    public void testParse() {
        String sourceText = DataProvider.SENTENCE_SOURCE;
        String interpretedText = DataProvider.SENTENCE_INTERPRETED;
        CompositeText compositeText = parser.parse(sourceText);
        String actualText = compositeText.toString();
        assertEquals(actualText, interpretedText);
    }
}
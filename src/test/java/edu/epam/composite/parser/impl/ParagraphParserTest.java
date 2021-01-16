package edu.epam.composite.parser.impl;

import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.data.DataProvider;
import edu.epam.composite.parser.ITextParser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParagraphParserTest {
    private final ITextParser parser = ParagraphParser.getInstance();

    @Test
    public void testParse() {
        String sourceText = DataProvider.PARAGRAPH_SOURCE;
        String interpretedText = DataProvider.PARAGRAPH_INTERPRETED;
        CompositeText compositeText = parser.parse(sourceText);
        String actualText = compositeText.toString();
        assertEquals(actualText, interpretedText);
    }
}
package edu.epam.composite.parser.impl;

import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.data.DataProvider;
import edu.epam.composite.parser.ITextParser;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LexemeParserTest {
    private final ITextParser parser = LexemeParser.getInstance();

    @Test
    public void testParse() {
        String sourceText = DataProvider.LEXEME_SOURCE;
        String interpretedText = DataProvider.LEXEME_INTERPRETED;
        CompositeText compositeText = parser.parse(sourceText);
        String actualText = compositeText.toString();
        assertEquals(actualText, interpretedText);
    }

}
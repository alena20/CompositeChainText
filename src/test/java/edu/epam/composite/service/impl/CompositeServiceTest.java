package edu.epam.composite.service.impl;

import edu.epam.composite.component.ITextComponent;
import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.data.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CompositeServiceTest {
    private final CompositeService service = new CompositeService();

    @Test
    public void testSortParagraphsBySentenceNumber() {
        CompositeText compositeText = DataProvider.COMPOSITE_TEXT;
        List<CompositeText> expectedList = DataProvider.SORTED_PARAGRAPHS;
        List<ITextComponent> actualList = service.sortParagraphsBySentenceNumber(compositeText);
        assertEquals(actualList, expectedList);
    }

    @Test
    public void testSortSentencesByWordLengths() {
        CompositeText compositeText = DataProvider.COMPOSITE_TEXT;
        List<CompositeText> expectedList = DataProvider.SORTED_SENTENCES_WORD_LENGTH;
        List<ITextComponent> actualList = service.sortSentencesByWordLengths(compositeText);
        assertEquals(actualList, expectedList);
    }

    @Test
    public void testSortSentencesByLexemeLengths() {
        CompositeText compositeText = DataProvider.COMPOSITE_TEXT;
        List<CompositeText> expectedList = DataProvider.SORTED_SENTENCES_LEXEME_LENGTH;
        List<ITextComponent> actualList = service.sortSentencesByLexemeLengths(compositeText);
        assertEquals(actualList, expectedList);
    }

    @Test
    public void testSortLexemesByCharacterEntries() {
        CompositeText compositeText = DataProvider.COMPOSITE_TEXT;
        List<CompositeText> expectedList = DataProvider.SORTED_LEXEMES;
        List<ITextComponent> actualList = service.sortLexemesByCharacterEntries(compositeText, 'a');
        assertEquals(actualList, expectedList);
    }

}
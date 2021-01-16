package edu.epam.composite.service;

import edu.epam.composite.component.ITextComponent;
import edu.epam.composite.component.impl.CompositeText;

import java.util.List;

public interface ICompositeService {

    List<ITextComponent> sortParagraphsBySentenceNumber(CompositeText compositeText);

    List<ITextComponent> sortSentencesByWordLengths(CompositeText compositeText);

    List<ITextComponent> sortSentencesByLexemeLengths(CompositeText compositeText);

    List<ITextComponent> sortLexemesByCharacterEntries(CompositeText compositeText, char character);

    List<ITextComponent> getAllLexemes(CompositeText compositeText);

    List<ITextComponent> getAllSentences(CompositeText compositeText);
}

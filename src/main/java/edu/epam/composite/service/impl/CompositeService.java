package edu.epam.composite.service.impl;

import edu.epam.composite.comparator.CharacterEntriesLexemeComparator;
import edu.epam.composite.comparator.ChildrenNumberComparator;
import edu.epam.composite.comparator.LexemeLengthSentenceComparator;
import edu.epam.composite.comparator.WordLengthSentenceComparator;
import edu.epam.composite.component.ITextComponent;
import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.service.ICompositeService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompositeService implements ICompositeService {
    public List<ITextComponent> sortParagraphsBySentenceNumber(CompositeText compositeText) {
        List<ITextComponent> paragraphs =
                new ArrayList<>(compositeText.getChildren());
        Comparator<ITextComponent> comparator = new ChildrenNumberComparator();
        paragraphs.sort(comparator);
        return paragraphs;
    }

    public List<ITextComponent> sortSentencesByWordLengths(CompositeText compositeText) {
        List<ITextComponent> sentences = getAllSentences(compositeText);
        Comparator<ITextComponent> comparator =
                new WordLengthSentenceComparator();
        sentences.sort(comparator);
        return sentences;
    }

    public List<ITextComponent> sortSentencesByLexemeLengths(CompositeText compositeText) {
        List<ITextComponent> sentences = getAllSentences(compositeText);
        Comparator<ITextComponent> comparator =
                new LexemeLengthSentenceComparator();
        sentences.sort(comparator);
        return sentences;
    }

    public List<ITextComponent> sortLexemesByCharacterEntries(CompositeText compositeText,
                                                             char character) {
        List<ITextComponent> lexemes = getAllLexemes(compositeText);
        Comparator<ITextComponent> comparator =
                new CharacterEntriesLexemeComparator(character);
        lexemes.sort(comparator);
        return lexemes;
    }

    public List<ITextComponent> getAllLexemes(CompositeText compositeText) {
        List<ITextComponent> lexemes = new ArrayList<>();
        for (ITextComponent paragraph : compositeText.getChildren()) {
            for (ITextComponent sentence : ((CompositeText) paragraph).getChildren()) {
                lexemes.addAll(((CompositeText) sentence).getChildren());
            }
        }
        return lexemes;
    }

    public List<ITextComponent> getAllSentences(CompositeText compositeText) {
        List<ITextComponent> sentences = new ArrayList<>();
        for (ITextComponent paragraph : compositeText.getChildren()) {
            sentences.addAll(((CompositeText) paragraph).getChildren());
        }
        return sentences;
    }
}

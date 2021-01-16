package edu.epam.composite.comparator;

import edu.epam.composite.component.ITextComponent;
import edu.epam.composite.component.impl.CompositeText;

import java.util.Comparator;

public class LexemeLengthSentenceComparator implements Comparator<ITextComponent> {
    @Override
    public int compare(ITextComponent o1, ITextComponent o2) {
        return totalLexemeLength(o1) - totalLexemeLength(o2);
    }

    private int totalLexemeLength(ITextComponent textComponent) {
        CompositeText sentence = (CompositeText) textComponent;
        int sum = 0;
        for (ITextComponent lexeme : sentence.getChildren()) {
            sum += ((CompositeText) lexeme).childrenNumber();
        }
        return sum;
    }
}
package edu.epam.composite.comparator;

import edu.epam.composite.component.ITextComponent;

import java.util.Comparator;

public class AlphabeticLexemeComparator implements Comparator<ITextComponent> {
    @Override
    public int compare(ITextComponent o1, ITextComponent o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
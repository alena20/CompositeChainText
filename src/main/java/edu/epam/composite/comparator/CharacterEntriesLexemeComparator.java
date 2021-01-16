package edu.epam.composite.comparator;

import edu.epam.composite.component.ITextComponent;
import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.component.impl.ElementaryText;

import java.util.Comparator;

public class CharacterEntriesLexemeComparator implements Comparator<ITextComponent> {
    private final char character;

    public CharacterEntriesLexemeComparator(char character) {
        this.character = character;
    }

    @Override
    public int compare(ITextComponent o1, ITextComponent o2) {
        int difference = countEntries(o1, character) - countEntries(o2, character);
        return difference == 0
                ? new AlphabeticLexemeComparator().compare(o1, o2)
                : difference;
    }

    private int countEntries(ITextComponent textComponent, char character) {
        int count = 0;
        for (ITextComponent child : ((CompositeText) textComponent).getChildren()) {
            ElementaryText elementaryText = (ElementaryText) child;
            if (elementaryText.getCharacter() == character) {
                count++;
            }
        }
        return count;
    }
}

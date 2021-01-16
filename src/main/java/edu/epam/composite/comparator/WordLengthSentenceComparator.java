package edu.epam.composite.comparator;

import edu.epam.composite.component.ITextComponent;
import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.component.impl.ElementaryText;
import edu.epam.composite.type.ElementaryType;

import java.util.Comparator;
import java.util.List;

public class WordLengthSentenceComparator  implements Comparator<ITextComponent> {
    @Override
    public int compare(ITextComponent o1, ITextComponent o2) {
        return totalWordLength(o1) - totalWordLength(o2);
    }

    private int totalWordLength(ITextComponent textComponent) {
        CompositeText sentence = (CompositeText) textComponent;
        int sum = 0;
        for (ITextComponent lexeme : sentence.getChildren()) {
            List<ITextComponent> chars = ((CompositeText) lexeme).getChildren();
            for (ITextComponent ch : chars) {
                ElementaryText elementaryText = ((ElementaryText) ch);
                if (elementaryText.getType() == ElementaryType.WORD_CHARACTER) {
                    sum += 1;
                }
            }
        }
        return sum;
    }
}

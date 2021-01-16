package edu.epam.composite.comparator;

import edu.epam.composite.component.ITextComponent;
import edu.epam.composite.component.impl.CompositeText;

import java.util.Comparator;

public class ChildrenNumberComparator implements Comparator<ITextComponent> {
    @Override
    public int compare(ITextComponent o1, ITextComponent o2) {
        return ((CompositeText) o1).childrenNumber() -
                ((CompositeText) o2).childrenNumber();
    }
}
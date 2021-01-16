package edu.epam.composite.component.impl;

import edu.epam.composite.component.ITextComponent;
import edu.epam.composite.type.CompositeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CompositeText implements ITextComponent {
    private final CompositeType type;
    private final List<ITextComponent> textComponents = new ArrayList<>();

    public CompositeText(CompositeType type) {
        this.type = type;
    }

    public CompositeType getType() {
        return type;
    }

    public int childrenNumber() {
        return textComponents.size();
    }

    public List<ITextComponent> getChildren() {
        return Collections.unmodifiableList(textComponents);
    }

    @Override
    public void add(ITextComponent c) {
        textComponents.add(c);
    }

    @Override
    public void remove(ITextComponent c) {
        textComponents.remove(c);
    }

    @Override
    public Optional<ITextComponent> getChild(int index) {
        return index >= 0 && index < textComponents.size()
                ? Optional.of(textComponents.get(index))
                : Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompositeText that = (CompositeText) o;
        if (type != that.type) {
            return false;
        }
        return textComponents.equals(that.textComponents);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + textComponents.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String delimiter = type.getChildDelimiter();
        int cutLength = type.getCutLength();
        for (ITextComponent textComponent : textComponents) {
            String childText = String.join(delimiter, textComponent.toString());
            builder.append(childText).append(delimiter);
        }
        builder.delete(builder.length() - cutLength, builder.length());
        return builder.toString();
    }
}

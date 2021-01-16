package edu.epam.composite.component;

import java.util.Optional;

public interface ITextComponent {
    void add(ITextComponent c);

    void remove(ITextComponent c);

    Optional<ITextComponent> getChild(int index);
}
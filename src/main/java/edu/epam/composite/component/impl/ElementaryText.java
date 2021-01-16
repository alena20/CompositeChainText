package edu.epam.composite.component.impl;

import edu.epam.composite.component.ITextComponent;
import edu.epam.composite.type.ElementaryType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ElementaryText implements ITextComponent {
    private static final Logger LOGGER = LogManager.getLogger(ElementaryText.class);
    private final char character;
    private final ElementaryType type;

    public ElementaryText(char character, ElementaryType type) {
        this.character = character;
        this.type = type;
    }

    public char getCharacter() {
        return character;
    }

    public ElementaryType getType() {
        return type;
    }

    public void add(ITextComponent c) {
        LOGGER.error("Impossible to add components to elementary text object!");
    }

    public void remove(ITextComponent c) {
        LOGGER.error("Impossible to remove components from " +
                "elementary text object!");
    }

    public Optional<ITextComponent> getChild(int index) {
        LOGGER.error("Impossible to get child components from " +
                "elementary text object!");
        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ElementaryText that = (ElementaryText) o;
        if (character != that.character) {
            return false;
        }
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = character;
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}

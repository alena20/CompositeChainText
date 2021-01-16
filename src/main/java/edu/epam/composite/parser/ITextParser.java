package edu.epam.composite.parser;

import edu.epam.composite.component.impl.CompositeText;

public interface ITextParser {
    CompositeText parse(String text);
}

package edu.epam.composite.parser.impl;

import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.parser.ITextParser;
import edu.epam.composite.type.CompositeType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser implements ITextParser {
    private static final ParagraphParser PARAGRAPH_PARSER = ParagraphParser.getInstance();
    private static final String REGEX_PARAGRAPH = ".+";

    @Override
    public CompositeText parse(String text) {
        Pattern pattern = Pattern.compile(REGEX_PARAGRAPH);
        Matcher matcher = pattern.matcher(text);
        CompositeText compositeText = new CompositeText(CompositeType.TEXT);
        while (matcher.find()) {
            String paragraphText = matcher.group();
            CompositeText paragraph = PARAGRAPH_PARSER.parse(paragraphText);
            compositeText.add(paragraph);
        }
        return compositeText;
    }
}


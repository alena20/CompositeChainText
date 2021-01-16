package edu.epam.composite.parser.impl;

import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.parser.ITextParser;
import edu.epam.composite.type.CompositeType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements ITextParser {
    private static final SentenceParser INSTANCE = new SentenceParser();
    private static final LexemeParser LEXEME_PARSER =
            LexemeParser.getInstance();
    private static final String REGEX_LEXEME = "[^\\s]+";

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        return INSTANCE;
    }

    @Override
    public CompositeText parse(String sentenceText) {
        Pattern pattern = Pattern.compile(REGEX_LEXEME);
        Matcher matcher = pattern.matcher(sentenceText);
        CompositeText sentence = new CompositeText(CompositeType.SENTENCE);
        while (matcher.find()) {
            String lexemeText = matcher.group();
            CompositeText lexeme = LEXEME_PARSER.parse(lexemeText);
            sentence.add(lexeme);
        }
        return sentence;
    }
}

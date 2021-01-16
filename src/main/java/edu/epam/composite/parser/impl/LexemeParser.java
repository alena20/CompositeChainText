package edu.epam.composite.parser.impl;

import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.component.impl.ElementaryText;
import edu.epam.composite.interpreter.IInterpreter;
import edu.epam.composite.interpreter.impl.InterpreterImpl;
import edu.epam.composite.parser.ITextParser;
import edu.epam.composite.type.CompositeType;
import edu.epam.composite.type.ElementaryType;

public class LexemeParser implements ITextParser {
    private static final LexemeParser INSTANCE = new LexemeParser();
    private static final String PUNCTUATION = ".,?!:;-()";
    private static final String REGEX_WORD_CHARACTER = "[\\d\\p{L}']";
    private static final String REGEX_EXPRESSION =
            "[(\\d)][\\d\\Q()+-*/\\E]+[\\d\\Q()+-*/\\E]";

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        return INSTANCE;
    }

    @Override
    public CompositeText parse(String lexemeText) {
        if (lexemeText.matches(REGEX_EXPRESSION)) {
            IInterpreter interpreter = new InterpreterImpl();
            lexemeText = interpreter.interpret(lexemeText);
        }
        CompositeText lexeme = new CompositeText(CompositeType.LEXEME);
        char[] lexemeChars = lexemeText.toCharArray();
        for (char lexemeChar : lexemeChars) {
            ElementaryText atomicText = null;
            if (isPunctuation(lexemeChar)) {
                atomicText = new ElementaryText(lexemeChar, ElementaryType.PUNCTUATION);
            }
            if (isWordCharacter(lexemeChar)) {
                atomicText = new ElementaryText(lexemeChar,
                        ElementaryType.WORD_CHARACTER);
            }
            if (atomicText != null) {
                lexeme.add(atomicText);
            }
        }
        return lexeme;
    }

    private boolean isWordCharacter(char character) {
        String characterString = String.valueOf(character);
        return characterString.matches(REGEX_WORD_CHARACTER);
    }

    private boolean isPunctuation(char character) {
        String characterString = String.valueOf(character);
        return PUNCTUATION.contains(characterString);
    }
}
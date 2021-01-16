package edu.epam.composite.data;

import edu.epam.composite.component.impl.CompositeText;
import edu.epam.composite.parser.ITextParser;
import edu.epam.composite.parser.impl.LexemeParser;
import edu.epam.composite.parser.impl.ParagraphParser;
import edu.epam.composite.parser.impl.SentenceParser;
import edu.epam.composite.parser.impl.TextParser;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public static final String TEXT_SOURCE;
    public static final String TEXT_INTERPRETED;
    public static final String PARAGRAPH_SOURCE;
    public static final String PARAGRAPH_INTERPRETED;
    public static final String SENTENCE_SOURCE;
    public static final String SENTENCE_INTERPRETED;
    public static final String LEXEME_SOURCE;
    public static final String LEXEME_INTERPRETED;
    public static final CompositeText COMPOSITE_TEXT;
    public static final CompositeText LEXEME_COMPARE_1;
    public static final CompositeText LEXEME_COMPARE_2;
    public static final CompositeText SENTENCE_COMPARE_1;
    public static final CompositeText SENTENCE_COMPARE_2;
    public static final List<CompositeText> SORTED_PARAGRAPHS;
    public static final List<CompositeText> SORTED_SENTENCES_WORD_LENGTH;
    public static final List<CompositeText> SORTED_SENTENCES_LEXEME_LENGTH;
    public static final List<CompositeText> SORTED_LEXEMES;

    static {
        String ls = System.getProperty("line.separator");
        TextParser textParser = new TextParser();
        ParagraphParser paragraphParser = ParagraphParser.getInstance();
        LexemeParser lexemeParser = LexemeParser.getInstance();
        SentenceParser sentenceParser = SentenceParser.getInstance();
        CompositeText element;
        TEXT_SOURCE = "It has survived - not only (five) centuries, " +
                "but also the leap into 13+9 electronic typesetting," +
                " remaining 3+5 essentially 6+9*(3-4) unchanged... It" +
                " was popularised in the 5*(1*2*(3*(4*(5-9+4)-3)-2)-1)" +
                " with the release of Letraset sheets containing Lorem" +
                " Ipsum passages, and more recently with desktop publishing" +
                " software like Aldus PageMaker including versions of " +
                "Lorem Ipsum." + ls +
                "It is a long established fact that a reader will be" +
                " distracted by the readable content of a page when looking" +
                " at its layout. The point of using" +
                " (71-(2*9*(3*(2-1/2*2)-2)-10/2))*9 Ipsum is that it has" +
                " a more-or-less normal distribution of letters, as opposed" +
                " to using (Content here), content here', making it look " +
                "like readable English." + ls +
                "It is a (-5+1/2*(2+5*2-9))*1200 established fact that a" +
                " reader will be of a page when looking at its layout." + ls +
                "Bye.";
        TEXT_INTERPRETED = "It has survived - not only (five) centuries, but " +
                "also the leap into 22 electronic typesetting, remaining" +
                " 8 essentially -3 unchanged... It was popularised" +
                " in the -115 with the release of Letraset sheets" +
                " containing Lorem Ipsum passages, and more recently" +
                " with desktop publishing software like Aldus" +
                " PageMaker including versions of Lorem Ipsum." + ls +
                "It is a long established fact that a reader will" +
                " be distracted by the readable content of a page" +
                " when looking at its layout. The point of using" +
                " 522 Ipsum is that it has a more-or-less normal" +
                " distribution of letters, as opposed to using" +
                " (Content here), content here', making it look" +
                " like readable English." + ls +
                "It is a -4200 established fact that a reader will" +
                " be of a page when looking at its layout." + ls +
                "Bye.";
        PARAGRAPH_SOURCE = "It has survived - not only (five) centuries, " +
                "but also the leap into 13+9 electronic typesetting, " +
                "remaining 3+5 essentially 6+9*(3-4) unchanged. It was " +
                "popularised in the 5*(1*2*(3*(4*(5-9+4)-3)-2)-1) with " +
                "the release of Letraset sheets containing Lorem Ipsum " +
                "passages, and more recently with desktop publishing " +
                "software like Aldus PageMaker including versions of " +
                "Lorem Ipsum.";
        PARAGRAPH_INTERPRETED = "It has survived - not only (five) centuries," +
                " but also the leap into 22 electronic typesetting, " +
                "remaining 8 essentially -3 unchanged. It was " +
                "popularised in the -115 with " +
                "the release of Letraset sheets containing Lorem Ipsum " +
                "passages, and more recently with desktop publishing " +
                "software like Aldus PageMaker including versions of " +
                "Lorem Ipsum.";
        SENTENCE_SOURCE = "It has survived - not only (five)" +
                " centuries, but also the leap into 13+9 electronic" +
                " typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged.";
        SENTENCE_INTERPRETED = "It has survived - not only (five)" +
                " centuries, but also the leap into 22 electronic" +
                " typesetting, remaining 8 essentially -3 unchanged.";
        LEXEME_SOURCE = "5*(1*2*(3*(4*(5-9+4)-3)-2)-1)";
        LEXEME_INTERPRETED = "-115";
        COMPOSITE_TEXT = textParser.parse(TEXT_SOURCE);
        LEXEME_COMPARE_1 = lexemeParser.parse("vehicle");
        LEXEME_COMPARE_2 = lexemeParser.parse("survived");
        SENTENCE_COMPARE_1 = sentenceParser.parse("It is a " +
                "(-5+1/2*(2+5*2-9))*1200 established fact that a reader will" +
                " be of a page when looking at its layout.");
        SENTENCE_COMPARE_2 = sentenceParser.parse("Bye.");
        SORTED_PARAGRAPHS = new ArrayList<>();
        element = paragraphParser.parse("It is a -4200" +
                " established fact that a reader will be of a page when" +
                " looking at its layout.");
        SORTED_PARAGRAPHS.add(element);
        element = paragraphParser.parse("Bye.");
        SORTED_PARAGRAPHS.add(element);
        element = paragraphParser.parse("It has survived - not" +
                " only (five) centuries, but also the leap into 22" +
                " electronic typesetting, remaining 8 essentially -3" +
                " unchanged... It was popularised in the -115 with the " +
                "release of Letraset sheets containing Lorem Ipsum passages," +
                " and more recently with desktop publishing software like" +
                " Aldus PageMaker including versions of Lorem Ipsum.");
        SORTED_PARAGRAPHS.add(element);
        element = paragraphParser.parse("It is a long " +
                "established fact that a reader will be distracted by" +
                " the readable content of a page when looking at its " +
                "layout. The point of using 522 Ipsum is that it has a" +
                " more-or-less normal distribution of letters, as opposed" +
                " to using (Content here), content here', making it look" +
                " like readable English.");
        SORTED_PARAGRAPHS.add(element);
        SORTED_SENTENCES_WORD_LENGTH = new ArrayList<>();
        element = sentenceParser.parse("Bye.");
        SORTED_SENTENCES_WORD_LENGTH.add(element);
        element = sentenceParser.parse("It is a -4200 established fact that" +
                " a reader will be of a page when looking at its layout.");
        SORTED_SENTENCES_WORD_LENGTH.add(element);
        element = sentenceParser.parse("It is a long established fact that" +
                " a reader will be distracted by the readable content of" +
                " a page when looking at its layout.");
        SORTED_SENTENCES_WORD_LENGTH.add(element);
        element = sentenceParser.parse("It has survived - not only (five)" +
                " centuries, but also the leap into 22 electronic" +
                " typesetting, remaining 8 essentially -3 unchanged...");
        SORTED_SENTENCES_WORD_LENGTH.add(element);
        element = sentenceParser.parse("The point of using 522 Ipsum is" +
                " that it has a more-or-less normal distribution of " +
                "letters, as opposed to using (Content here), content " +
                "here', making it look like readable English.");
        SORTED_SENTENCES_WORD_LENGTH.add(element);
        element = sentenceParser.parse("It was popularised in the -115 " +
                "with the release of Letraset sheets containing Lorem Ipsum" +
                " passages, and more recently with desktop publishing " +
                "software like Aldus PageMaker including versions" +
                " of Lorem Ipsum.");
        SORTED_SENTENCES_WORD_LENGTH.add(element);
        SORTED_SENTENCES_LEXEME_LENGTH = SORTED_SENTENCES_WORD_LENGTH;
        SORTED_LEXEMES = new ArrayList<>();
        SORTED_LEXEMES.add(lexemeParser.parse("(Content"));
        SORTED_LEXEMES.add(lexemeParser.parse("(five)"));
        SORTED_LEXEMES.add(lexemeParser.parse("-"));
        SORTED_LEXEMES.add(lexemeParser.parse("-115"));
        SORTED_LEXEMES.add(lexemeParser.parse("-3"));
        SORTED_LEXEMES.add(lexemeParser.parse("-4200"));
        SORTED_LEXEMES.add(lexemeParser.parse("22"));
        SORTED_LEXEMES.add(lexemeParser.parse("522"));
        SORTED_LEXEMES.add(lexemeParser.parse("8"));
        SORTED_LEXEMES.add(lexemeParser.parse("Aldus"));
        SORTED_LEXEMES.add(lexemeParser.parse("Bye."));
        SORTED_LEXEMES.add(lexemeParser.parse("English."));
        SORTED_LEXEMES.add(lexemeParser.parse("Ipsum"));
        SORTED_LEXEMES.add(lexemeParser.parse("Ipsum"));
        SORTED_LEXEMES.add(lexemeParser.parse("Ipsum."));
        SORTED_LEXEMES.add(lexemeParser.parse("It"));
        SORTED_LEXEMES.add(lexemeParser.parse("It"));
        SORTED_LEXEMES.add(lexemeParser.parse("It"));
        SORTED_LEXEMES.add(lexemeParser.parse("It"));
        SORTED_LEXEMES.add(lexemeParser.parse("Lorem"));
        SORTED_LEXEMES.add(lexemeParser.parse("Lorem"));
        SORTED_LEXEMES.add(lexemeParser.parse("The"));
        SORTED_LEXEMES.add(lexemeParser.parse("be"));
        SORTED_LEXEMES.add(lexemeParser.parse("be"));
        SORTED_LEXEMES.add(lexemeParser.parse("but"));
        SORTED_LEXEMES.add(lexemeParser.parse("by"));
        SORTED_LEXEMES.add(lexemeParser.parse("centuries,"));
        SORTED_LEXEMES.add(lexemeParser.parse("content"));
        SORTED_LEXEMES.add(lexemeParser.parse("content"));
        SORTED_LEXEMES.add(lexemeParser.parse("desktop"));
        SORTED_LEXEMES.add(lexemeParser.parse("distribution"));
        SORTED_LEXEMES.add(lexemeParser.parse("electronic"));
        SORTED_LEXEMES.add(lexemeParser.parse("here',"));
        SORTED_LEXEMES.add(lexemeParser.parse("here),"));
        SORTED_LEXEMES.add(lexemeParser.parse("in"));
        SORTED_LEXEMES.add(lexemeParser.parse("including"));
        SORTED_LEXEMES.add(lexemeParser.parse("into"));
        SORTED_LEXEMES.add(lexemeParser.parse("is"));
        SORTED_LEXEMES.add(lexemeParser.parse("is"));
        SORTED_LEXEMES.add(lexemeParser.parse("is"));
        SORTED_LEXEMES.add(lexemeParser.parse("it"));
        SORTED_LEXEMES.add(lexemeParser.parse("it"));
        SORTED_LEXEMES.add(lexemeParser.parse("its"));
        SORTED_LEXEMES.add(lexemeParser.parse("its"));
        SORTED_LEXEMES.add(lexemeParser.parse("letters,"));
        SORTED_LEXEMES.add(lexemeParser.parse("like"));
        SORTED_LEXEMES.add(lexemeParser.parse("like"));
        SORTED_LEXEMES.add(lexemeParser.parse("long"));
        SORTED_LEXEMES.add(lexemeParser.parse("look"));
        SORTED_LEXEMES.add(lexemeParser.parse("looking"));
        SORTED_LEXEMES.add(lexemeParser.parse("looking"));
        SORTED_LEXEMES.add(lexemeParser.parse("more"));
        SORTED_LEXEMES.add(lexemeParser.parse("more-or-less"));
        SORTED_LEXEMES.add(lexemeParser.parse("not"));
        SORTED_LEXEMES.add(lexemeParser.parse("of"));
        SORTED_LEXEMES.add(lexemeParser.parse("of"));
        SORTED_LEXEMES.add(lexemeParser.parse("of"));
        SORTED_LEXEMES.add(lexemeParser.parse("of"));
        SORTED_LEXEMES.add(lexemeParser.parse("of"));
        SORTED_LEXEMES.add(lexemeParser.parse("of"));
        SORTED_LEXEMES.add(lexemeParser.parse("only"));
        SORTED_LEXEMES.add(lexemeParser.parse("opposed"));
        SORTED_LEXEMES.add(lexemeParser.parse("point"));
        SORTED_LEXEMES.add(lexemeParser.parse("publishing"));
        SORTED_LEXEMES.add(lexemeParser.parse("recently"));
        SORTED_LEXEMES.add(lexemeParser.parse("sheets"));
        SORTED_LEXEMES.add(lexemeParser.parse("survived"));
        SORTED_LEXEMES.add(lexemeParser.parse("the"));
        SORTED_LEXEMES.add(lexemeParser.parse("the"));
        SORTED_LEXEMES.add(lexemeParser.parse("the"));
        SORTED_LEXEMES.add(lexemeParser.parse("the"));
        SORTED_LEXEMES.add(lexemeParser.parse("to"));
        SORTED_LEXEMES.add(lexemeParser.parse("typesetting,"));
        SORTED_LEXEMES.add(lexemeParser.parse("using"));
        SORTED_LEXEMES.add(lexemeParser.parse("using"));
        SORTED_LEXEMES.add(lexemeParser.parse("versions"));
        SORTED_LEXEMES.add(lexemeParser.parse("when"));
        SORTED_LEXEMES.add(lexemeParser.parse("when"));
        SORTED_LEXEMES.add(lexemeParser.parse("will"));
        SORTED_LEXEMES.add(lexemeParser.parse("will"));
        SORTED_LEXEMES.add(lexemeParser.parse("with"));
        SORTED_LEXEMES.add(lexemeParser.parse("with"));
        SORTED_LEXEMES.add(lexemeParser.parse("Letraset"));
        SORTED_LEXEMES.add(lexemeParser.parse("a"));
        SORTED_LEXEMES.add(lexemeParser.parse("a"));
        SORTED_LEXEMES.add(lexemeParser.parse("a"));
        SORTED_LEXEMES.add(lexemeParser.parse("a"));
        SORTED_LEXEMES.add(lexemeParser.parse("a"));
        SORTED_LEXEMES.add(lexemeParser.parse("a"));
        SORTED_LEXEMES.add(lexemeParser.parse("a"));
        SORTED_LEXEMES.add(lexemeParser.parse("also"));
        SORTED_LEXEMES.add(lexemeParser.parse("and"));
        SORTED_LEXEMES.add(lexemeParser.parse("as"));
        SORTED_LEXEMES.add(lexemeParser.parse("at"));
        SORTED_LEXEMES.add(lexemeParser.parse("at"));
        SORTED_LEXEMES.add(lexemeParser.parse("containing"));
        SORTED_LEXEMES.add(lexemeParser.parse("distracted"));
        SORTED_LEXEMES.add(lexemeParser.parse("essentially"));
        SORTED_LEXEMES.add(lexemeParser.parse("established"));
        SORTED_LEXEMES.add(lexemeParser.parse("established"));
        SORTED_LEXEMES.add(lexemeParser.parse("fact"));
        SORTED_LEXEMES.add(lexemeParser.parse("fact"));
        SORTED_LEXEMES.add(lexemeParser.parse("has"));
        SORTED_LEXEMES.add(lexemeParser.parse("has"));
        SORTED_LEXEMES.add(lexemeParser.parse("layout."));
        SORTED_LEXEMES.add(lexemeParser.parse("layout."));
        SORTED_LEXEMES.add(lexemeParser.parse("leap"));
        SORTED_LEXEMES.add(lexemeParser.parse("making"));
        SORTED_LEXEMES.add(lexemeParser.parse("normal"));
        SORTED_LEXEMES.add(lexemeParser.parse("page"));
        SORTED_LEXEMES.add(lexemeParser.parse("page"));
        SORTED_LEXEMES.add(lexemeParser.parse("popularised"));
        SORTED_LEXEMES.add(lexemeParser.parse("reader"));
        SORTED_LEXEMES.add(lexemeParser.parse("reader"));
        SORTED_LEXEMES.add(lexemeParser.parse("release"));
        SORTED_LEXEMES.add(lexemeParser.parse("remaining"));
        SORTED_LEXEMES.add(lexemeParser.parse("software"));
        SORTED_LEXEMES.add(lexemeParser.parse("that"));
        SORTED_LEXEMES.add(lexemeParser.parse("that"));
        SORTED_LEXEMES.add(lexemeParser.parse("that"));
        SORTED_LEXEMES.add(lexemeParser.parse("unchanged..."));
        SORTED_LEXEMES.add(lexemeParser.parse("was"));
        SORTED_LEXEMES.add(lexemeParser.parse("PageMaker"));
        SORTED_LEXEMES.add(lexemeParser.parse("passages,"));
        SORTED_LEXEMES.add(lexemeParser.parse("readable"));
        SORTED_LEXEMES.add(lexemeParser.parse("readable"));
    }

    private DataProvider() {
    }
}

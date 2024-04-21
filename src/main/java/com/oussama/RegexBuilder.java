package com.oussama;

import java.util.regex.Pattern;

import static com.oussama.Utils.insertBeforeEverySpecialCharacter;

public class RegexBuilder implements PatternBuilder {
    private String regex;

    public RegexBuilder() {
        regex = "";
    }

    @Override
    public PatternBuilder startsWith(String prefix) {
        regex = "^" + "(" + insertBeforeEverySpecialCharacter(prefix,"\\") + ")" + regex;
        return this;
    }

    @Override
    public void endsWith(String suffix) {
        regex += "(" +insertBeforeEverySpecialCharacter(suffix, "\\") + ")" + "$";
    }

    @Override
    public PatternBuilder boundary() {
        regex += "\\b";
        return this;
    }

    @Override
    public PatternBuilder noBoundary() {
        regex += "\\B";
        return this;
    }

    @Override
    public PatternBuilder any() {
        regex += "(.)";
        return this;
    }

    @Override
    public PatternBuilder digit() {
        regex += "(\\d)";
        return this;
    }

    @Override
    public PatternBuilder nonDigit() {
        regex += "(\\D)";
        return this;    }

    @Override
    public PatternBuilder alphanumeric() {
        regex += "[a-zA-Z\\d]";
        return this;
    }

    @Override
    public PatternBuilder nonAlphanumeric() {
        regex += "[^a-zA-Z\\d]";
        return this;    }

    @Override
    public PatternBuilder alphabetic() {
        regex += "[a-zA-Z]";
        return this;
    }

    @Override
    public PatternBuilder nonAlphabetic() {
        regex += "[^a-zA-Z]";
        return this;
    }

    @Override
    public PatternBuilder string(String str) {
        String alteredString = insertBeforeEverySpecialCharacter(str, "\\");
        regex += "(" + alteredString + ")";
        return this;
    }

    @Override
    public PatternBuilder set(char... chars) {
        StringBuilder chSet = new StringBuilder("[");
        for (char ch : chars) {
            chSet.append(String.valueOf(ch));
        }
        chSet.append("]");
        regex += chSet;
        return this;
    }

    @Override
    public PatternBuilder range(char start, char end) {
        regex += "[" + start + "-" + end + "]";
        return this;
    }

    @Override
    public PatternBuilder range(int start, int end) {
        regex += "\\w";
        return this;
    }

    @Override
    public PatternBuilder containsWord() {
        regex += "\\w";
        return this;
    }

    @Override
    public PatternBuilder containsSpace() {
        regex += "\\s";
        return this;
    }

    @Override
    public PatternBuilder repeat() {
        regex += "*";
        return this;
    }

    @Override
    public PatternBuilder repeatAtLeast() {
        regex += "+";
        return this;
    }

    @Override
    public PatternBuilder repeatOne() {
        regex += "?";
        return this;
    }

    @Override
    public PatternBuilder repeatExactly(int occurrence) {
        regex += "{" + occurrence + "}";
        return this;
    }

    @Override
    public PatternBuilder repeatMoreThan(int occurrence) {
        regex += "{"+occurrence+",}";
        return this;
    }

    @Override
    public PatternBuilder repeatBetween(int minOccurrence, int maxOccurrence) {
        regex += "{" + minOccurrence + "," + maxOccurrence + "}";
        return this;
    }

    @Override
    public Pattern build() {
        return Pattern.compile(regex);
    }

    public String getRegex() {
        return regex;
    }
}

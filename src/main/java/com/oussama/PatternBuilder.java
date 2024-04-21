package com.oussama;

import java.util.regex.Pattern;

public interface PatternBuilder {
    PatternBuilder startsWith(String prefix);
    void endsWith(String suffix);
    PatternBuilder boundary();
    PatternBuilder noBoundary();
    PatternBuilder any();
    PatternBuilder digit();
    PatternBuilder nonDigit();
    PatternBuilder alphanumeric();
    PatternBuilder nonAlphanumeric();
    PatternBuilder alphabetic();
    PatternBuilder nonAlphabetic();
    PatternBuilder string(String str);
    PatternBuilder set(char... chars);
    PatternBuilder range(char start, char end);
    PatternBuilder range(int start, int end);
    PatternBuilder containsWord();
    PatternBuilder containsSpace();
    PatternBuilder repeat();
    PatternBuilder repeatAtLeast();
    PatternBuilder repeatOne();
    PatternBuilder repeatExactly(int occurrence);
    PatternBuilder repeatMoreThan(int occurrence);
    PatternBuilder repeatBetween(int minOccurrence, int maxOccurrence);
    Pattern build();
}

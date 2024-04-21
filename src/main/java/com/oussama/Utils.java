package com.oussama;

import java.util.Set;
import java.util.stream.Collectors;

public class Utils {
    public static String insertBeforeEverySpecialCharacter(String input, String insertString) {
        Set<Character> specialCharacters = Set.of('\\', '^', '$', '.', '|', '?', '*', '+', '(', ')', '[', ']', '{', '}');

        return input.chars()
                .mapToObj(c -> {
                    char character = (char) c;
                    return !specialCharacters.contains(character) ? String.valueOf(character) : insertString + character ;
                })
                .collect(Collectors.joining());
    }

}

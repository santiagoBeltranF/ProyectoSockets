package org.example.util;

import java.util.Calendar;
import java.util.Random;

public class NameGenerator {
    private String[] predefinedNames;
    private int currentIndex;

    public NameGenerator(String[] predefinedNames) {
        this.predefinedNames = predefinedNames;
        this.currentIndex = 0;
    }

    public String getName() {
        if (currentIndex < predefinedNames.length) {
            return predefinedNames[currentIndex++];
        } else {
            currentIndex = 0;
            return predefinedNames[currentIndex++];
        }
    }
}

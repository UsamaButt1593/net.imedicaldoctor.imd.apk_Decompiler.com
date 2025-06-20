package com.itextpdf.text.pdf.fonts.otf;

import java.util.Arrays;
import java.util.List;

public enum Language {
    BENGALI("beng", "bng2");
    
    private final List<String> s;

    private Language(String... strArr) {
        this.s = Arrays.asList(strArr);
    }

    public boolean a(String str) {
        return this.s.contains(str);
    }
}

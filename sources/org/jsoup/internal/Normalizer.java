package org.jsoup.internal;

import java.util.Locale;

public class Normalizer {
    public static String a(String str) {
        return str.toLowerCase(Locale.ENGLISH);
    }

    public static String b(String str) {
        return a(str).trim();
    }
}

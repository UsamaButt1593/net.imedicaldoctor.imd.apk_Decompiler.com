package org.threeten.bp.format;

public enum TextStyle {
    FULL,
    FULL_STANDALONE,
    SHORT,
    SHORT_STANDALONE,
    NARROW,
    NARROW_STANDALONE;

    public TextStyle a() {
        return values()[ordinal() & -2];
    }

    public TextStyle b() {
        return values()[ordinal() | 1];
    }

    public boolean c() {
        return (ordinal() & 1) == 1;
    }
}

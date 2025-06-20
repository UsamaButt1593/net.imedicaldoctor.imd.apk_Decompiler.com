package org.jsoup.parser;

import java.util.ArrayList;

public class ParseErrorList extends ArrayList<ParseError> {
    private static final int X = 16;
    private final int s;

    ParseErrorList(int i2, int i3) {
        super(i2);
        this.s = i3;
    }

    public static ParseErrorList d() {
        return new ParseErrorList(0, 0);
    }

    public static ParseErrorList g(int i2) {
        return new ParseErrorList(16, i2);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return size() < this.s;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.s;
    }
}

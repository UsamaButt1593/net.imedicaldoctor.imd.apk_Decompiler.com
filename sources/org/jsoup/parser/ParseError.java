package org.jsoup.parser;

public class ParseError {

    /* renamed from: a  reason: collision with root package name */
    private int f31648a;

    /* renamed from: b  reason: collision with root package name */
    private String f31649b;

    ParseError(int i2, String str) {
        this.f31648a = i2;
        this.f31649b = str;
    }

    public String a() {
        return this.f31649b;
    }

    public int b() {
        return this.f31648a;
    }

    public String toString() {
        return this.f31648a + ": " + this.f31649b;
    }

    ParseError(int i2, String str, Object... objArr) {
        this.f31649b = String.format(str, objArr);
        this.f31648a = i2;
    }
}

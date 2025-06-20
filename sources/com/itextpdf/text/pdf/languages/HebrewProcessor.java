package com.itextpdf.text.pdf.languages;

import com.itextpdf.text.pdf.BidiLine;

public class HebrewProcessor implements LanguageProcessor {

    /* renamed from: a  reason: collision with root package name */
    protected int f26905a;

    public HebrewProcessor() {
        this.f26905a = 3;
    }

    public boolean a() {
        return true;
    }

    public String b(String str) {
        return BidiLine.q(str, this.f26905a, 0);
    }

    public HebrewProcessor(int i2) {
        this.f26905a = i2;
    }
}

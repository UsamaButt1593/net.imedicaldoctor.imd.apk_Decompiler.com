package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.hyphenation.Hyphenation;
import com.itextpdf.text.pdf.hyphenation.Hyphenator;

public class HyphenationAuto implements HyphenationEvent {

    /* renamed from: a  reason: collision with root package name */
    protected Hyphenator f26069a;

    /* renamed from: b  reason: collision with root package name */
    protected String f26070b;

    public HyphenationAuto(String str, String str2, int i2, int i3) {
        this.f26069a = new Hyphenator(str, str2, i2, i3);
    }

    public String a() {
        return "-";
    }

    public String b() {
        return this.f26070b;
    }

    public String c(String str, BaseFont baseFont, float f2, float f3) {
        Hyphenation e2;
        this.f26070b = str;
        String a2 = a();
        float Z = baseFont.Z(a2, f2);
        if (Z > f3 || (e2 = this.f26069a.e(str)) == null) {
            return "";
        }
        int d2 = e2.d();
        int i2 = 0;
        while (i2 < d2 && baseFont.Z(e2.c(i2), f2) + Z <= f3) {
            i2++;
        }
        int i3 = i2 - 1;
        if (i3 < 0) {
            return "";
        }
        this.f26070b = e2.b(i3);
        return e2.c(i3) + a2;
    }
}

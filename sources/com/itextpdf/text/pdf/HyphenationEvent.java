package com.itextpdf.text.pdf;

public interface HyphenationEvent {
    String a();

    String b();

    String c(String str, BaseFont baseFont, float f2, float f3);
}

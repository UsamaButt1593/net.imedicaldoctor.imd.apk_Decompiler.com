package com.itextpdf.text.pdf.hyphenation;

import java.util.ArrayList;

public interface PatternConsumer {
    void b(String str, String str2);

    void c(String str, ArrayList<Object> arrayList);

    void f(String str);
}

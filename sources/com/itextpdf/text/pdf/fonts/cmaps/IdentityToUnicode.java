package com.itextpdf.text.pdf.fonts.cmaps;

import java.io.IOException;

public class IdentityToUnicode {

    /* renamed from: a  reason: collision with root package name */
    private static CMapToUnicode f26826a;

    /* renamed from: b  reason: collision with root package name */
    private static CMapToUnicode f26827b;

    /* renamed from: c  reason: collision with root package name */
    private static CMapToUnicode f26828c;

    /* renamed from: d  reason: collision with root package name */
    private static CMapToUnicode f26829d;

    /* renamed from: e  reason: collision with root package name */
    private static CMapToUnicode f26830e;

    public static CMapToUnicode a(String str) throws IOException {
        if (str.equals("CNS1")) {
            if (f26826a == null) {
                CMapUniCid d2 = CMapCache.d("UniCNS-UTF16-H");
                if (d2 == null) {
                    return null;
                }
                f26826a = d2.o();
            }
            return f26826a;
        } else if (str.equals("Japan1")) {
            if (f26827b == null) {
                CMapUniCid d3 = CMapCache.d("UniJIS-UTF16-H");
                if (d3 == null) {
                    return null;
                }
                f26827b = d3.o();
            }
            return f26827b;
        } else if (str.equals("Korea1")) {
            if (f26828c == null) {
                CMapUniCid d4 = CMapCache.d("UniKS-UTF16-H");
                if (d4 == null) {
                    return null;
                }
                f26828c = d4.o();
            }
            return f26828c;
        } else if (str.equals("GB1")) {
            if (f26829d == null) {
                CMapUniCid d5 = CMapCache.d("UniGB-UTF16-H");
                if (d5 == null) {
                    return null;
                }
                f26829d = d5.o();
            }
            return f26829d;
        } else if (!str.equals("Identity")) {
            return null;
        } else {
            if (f26830e == null) {
                f26830e = CMapToUnicode.t();
            }
            return f26830e;
        }
    }
}

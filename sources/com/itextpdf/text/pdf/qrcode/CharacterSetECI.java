package com.itextpdf.text.pdf.qrcode;

import java.util.HashMap;
import net.lingala.zip4j.util.InternalZipConstants;

public final class CharacterSetECI {

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, CharacterSetECI> f27174c;

    /* renamed from: a  reason: collision with root package name */
    private final String f27175a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27176b;

    private CharacterSetECI(int i2, String str) {
        this.f27175a = str;
        this.f27176b = i2;
    }

    private static void a(int i2, String str, HashMap<String, CharacterSetECI> hashMap) {
        hashMap.put(str, new CharacterSetECI(i2, str));
    }

    private static void b(int i2, String[] strArr, HashMap<String, CharacterSetECI> hashMap) {
        CharacterSetECI characterSetECI = new CharacterSetECI(i2, strArr[0]);
        for (String put : strArr) {
            hashMap.put(put, characterSetECI);
        }
    }

    public static CharacterSetECI c(String str) {
        if (f27174c == null) {
            f();
        }
        return f27174c.get(str);
    }

    private static void f() {
        HashMap<String, CharacterSetECI> hashMap = new HashMap<>(29);
        a(0, InternalZipConstants.q, hashMap);
        b(1, new String[]{"ISO8859_1", "ISO-8859-1"}, hashMap);
        a(2, InternalZipConstants.q, hashMap);
        b(3, new String[]{"ISO8859_1", "ISO-8859-1"}, hashMap);
        b(4, new String[]{"ISO8859_2", "ISO-8859-2"}, hashMap);
        b(5, new String[]{"ISO8859_3", "ISO-8859-3"}, hashMap);
        b(6, new String[]{"ISO8859_4", "ISO-8859-4"}, hashMap);
        b(7, new String[]{"ISO8859_5", "ISO-8859-5"}, hashMap);
        b(8, new String[]{"ISO8859_6", "ISO-8859-6"}, hashMap);
        b(9, new String[]{"ISO8859_7", "ISO-8859-7"}, hashMap);
        b(10, new String[]{"ISO8859_8", "ISO-8859-8"}, hashMap);
        b(11, new String[]{"ISO8859_9", "ISO-8859-9"}, hashMap);
        b(12, new String[]{"ISO8859_10", "ISO-8859-10"}, hashMap);
        b(13, new String[]{"ISO8859_11", "ISO-8859-11"}, hashMap);
        b(15, new String[]{"ISO8859_13", "ISO-8859-13"}, hashMap);
        b(16, new String[]{"ISO8859_14", "ISO-8859-14"}, hashMap);
        b(17, new String[]{"ISO8859_15", "ISO-8859-15"}, hashMap);
        b(18, new String[]{"ISO8859_16", "ISO-8859-16"}, hashMap);
        b(20, new String[]{"SJIS", "Shift_JIS"}, hashMap);
        f27174c = hashMap;
    }

    public String d() {
        return this.f27175a;
    }

    public int e() {
        return this.f27176b;
    }
}

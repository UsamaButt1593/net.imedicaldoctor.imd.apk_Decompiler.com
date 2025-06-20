package com.itextpdf.text.pdf.languages;

public class DevanagariLigaturizer extends IndicLigaturizer {

    /* renamed from: m  reason: collision with root package name */
    public static final char f26901m = 'ा';

    /* renamed from: n  reason: collision with root package name */
    public static final char f26902n = 'ि';
    public static final char o = 'े';
    public static final char p = 'ै';
    public static final char q = 'ॢ';
    public static final char r = 'ॣ';
    public static final char s = 'अ';
    public static final char t = 'औ';
    public static final char u = 'क';
    public static final char v = 'ह';
    public static final char w = '्';

    public DevanagariLigaturizer() {
        char[] cArr = new char[11];
        this.f26917a = cArr;
        cArr[0] = f26901m;
        cArr[1] = f26902n;
        cArr[2] = o;
        cArr[3] = p;
        cArr[4] = q;
        cArr[5] = r;
        cArr[6] = s;
        cArr[7] = t;
        cArr[8] = u;
        cArr[9] = v;
        cArr[10] = w;
    }
}

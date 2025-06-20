package com.itextpdf.text.pdf.languages;

public abstract class IndicLigaturizer implements LanguageProcessor {

    /* renamed from: b  reason: collision with root package name */
    public static final int f26906b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f26907c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f26908d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f26909e = 3;

    /* renamed from: f  reason: collision with root package name */
    public static final int f26910f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f26911g = 5;

    /* renamed from: h  reason: collision with root package name */
    public static final int f26912h = 6;

    /* renamed from: i  reason: collision with root package name */
    public static final int f26913i = 7;

    /* renamed from: j  reason: collision with root package name */
    public static final int f26914j = 8;

    /* renamed from: k  reason: collision with root package name */
    public static final int f26915k = 9;

    /* renamed from: l  reason: collision with root package name */
    public static final int f26916l = 10;

    /* renamed from: a  reason: collision with root package name */
    protected char[] f26917a;

    private static void f(StringBuilder sb, int i2, int i3) {
        char charAt = sb.charAt(i2);
        sb.setCharAt(i2, sb.charAt(i3));
        sb.setCharAt(i3, charAt);
    }

    public boolean a() {
        return false;
    }

    public String b(String str) {
        int length;
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (e(charAt) || c(charAt) || !d(charAt) || (length = sb.length() - 1) < 0) {
                sb.append(charAt);
            } else {
                if (sb.charAt(length) == this.f26917a[10]) {
                    sb.deleteCharAt(length);
                }
                sb.append(charAt);
                int length2 = sb.length() - 2;
                if (charAt == this.f26917a[1] && length2 >= 0) {
                    f(sb, length2, sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean c(char c2) {
        char[] cArr = this.f26917a;
        return c2 >= cArr[6] && c2 <= cArr[7];
    }

    /* access modifiers changed from: protected */
    public boolean d(char c2) {
        char[] cArr = this.f26917a;
        return (c2 >= cArr[0] && c2 <= cArr[3]) || c2 == cArr[4] || c2 == cArr[5];
    }

    /* access modifiers changed from: protected */
    public boolean e(char c2) {
        char[] cArr = this.f26917a;
        return c2 >= cArr[8] && c2 <= cArr[9];
    }
}

package com.itextpdf.text.pdf.qrcode;

public final class Mode {

    /* renamed from: d  reason: collision with root package name */
    public static final Mode f27211d = new Mode(new int[]{0, 0, 0}, 0, "TERMINATOR");

    /* renamed from: e  reason: collision with root package name */
    public static final Mode f27212e = new Mode(new int[]{10, 12, 14}, 1, "NUMERIC");

    /* renamed from: f  reason: collision with root package name */
    public static final Mode f27213f = new Mode(new int[]{9, 11, 13}, 2, "ALPHANUMERIC");

    /* renamed from: g  reason: collision with root package name */
    public static final Mode f27214g = new Mode(new int[]{0, 0, 0}, 3, "STRUCTURED_APPEND");

    /* renamed from: h  reason: collision with root package name */
    public static final Mode f27215h = new Mode(new int[]{8, 16, 16}, 4, "BYTE");

    /* renamed from: i  reason: collision with root package name */
    public static final Mode f27216i = new Mode((int[]) null, 7, "ECI");

    /* renamed from: j  reason: collision with root package name */
    public static final Mode f27217j = new Mode(new int[]{8, 10, 12}, 8, "KANJI");

    /* renamed from: k  reason: collision with root package name */
    public static final Mode f27218k = new Mode((int[]) null, 5, "FNC1_FIRST_POSITION");

    /* renamed from: l  reason: collision with root package name */
    public static final Mode f27219l = new Mode((int[]) null, 9, "FNC1_SECOND_POSITION");

    /* renamed from: a  reason: collision with root package name */
    private final int[] f27220a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27221b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27222c;

    private Mode(int[] iArr, int i2, String str) {
        this.f27220a = iArr;
        this.f27221b = i2;
        this.f27222c = str;
    }

    public static Mode a(int i2) {
        switch (i2) {
            case 0:
                return f27211d;
            case 1:
                return f27212e;
            case 2:
                return f27213f;
            case 3:
                return f27214g;
            case 4:
                return f27215h;
            case 5:
                return f27218k;
            case 7:
                return f27216i;
            case 8:
                return f27217j;
            case 9:
                return f27219l;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int b() {
        return this.f27221b;
    }

    public int c(Version version) {
        if (this.f27220a != null) {
            int j2 = version.j();
            return this.f27220a[j2 <= 9 ? 0 : j2 <= 26 ? (char) 1 : 2];
        }
        throw new IllegalArgumentException("Character count doesn't apply to this mode");
    }

    public String d() {
        return this.f27222c;
    }

    public String toString() {
        return this.f27222c;
    }
}

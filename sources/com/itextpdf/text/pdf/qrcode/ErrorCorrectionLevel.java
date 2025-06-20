package com.itextpdf.text.pdf.qrcode;

public final class ErrorCorrectionLevel {

    /* renamed from: d  reason: collision with root package name */
    public static final ErrorCorrectionLevel f27181d;

    /* renamed from: e  reason: collision with root package name */
    public static final ErrorCorrectionLevel f27182e;

    /* renamed from: f  reason: collision with root package name */
    public static final ErrorCorrectionLevel f27183f;

    /* renamed from: g  reason: collision with root package name */
    public static final ErrorCorrectionLevel f27184g;

    /* renamed from: h  reason: collision with root package name */
    private static final ErrorCorrectionLevel[] f27185h;

    /* renamed from: a  reason: collision with root package name */
    private final int f27186a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27187b;

    /* renamed from: c  reason: collision with root package name */
    private final String f27188c;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = new ErrorCorrectionLevel(0, 1, "L");
        f27181d = errorCorrectionLevel;
        ErrorCorrectionLevel errorCorrectionLevel2 = new ErrorCorrectionLevel(1, 0, "M");
        f27182e = errorCorrectionLevel2;
        ErrorCorrectionLevel errorCorrectionLevel3 = new ErrorCorrectionLevel(2, 3, "Q");
        f27183f = errorCorrectionLevel3;
        ErrorCorrectionLevel errorCorrectionLevel4 = new ErrorCorrectionLevel(3, 2, "H");
        f27184g = errorCorrectionLevel4;
        f27185h = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, errorCorrectionLevel4, errorCorrectionLevel3};
    }

    private ErrorCorrectionLevel(int i2, int i3, String str) {
        this.f27186a = i2;
        this.f27187b = i3;
        this.f27188c = str;
    }

    public static ErrorCorrectionLevel a(int i2) {
        if (i2 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = f27185h;
            if (i2 < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    public int b() {
        return this.f27187b;
    }

    public String c() {
        return this.f27188c;
    }

    public int d() {
        return this.f27186a;
    }

    public String toString() {
        return this.f27188c;
    }
}

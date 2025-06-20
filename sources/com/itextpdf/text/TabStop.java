package com.itextpdf.text;

import com.itextpdf.text.pdf.draw.DrawInterface;
import org.apache.commons.lang3.ClassUtils;

public class TabStop {

    /* renamed from: a  reason: collision with root package name */
    protected float f25726a;

    /* renamed from: b  reason: collision with root package name */
    protected Alignment f25727b;

    /* renamed from: c  reason: collision with root package name */
    protected DrawInterface f25728c;

    /* renamed from: d  reason: collision with root package name */
    protected char f25729d;

    /* renamed from: com.itextpdf.text.TabStop$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25730a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.itextpdf.text.TabStop$Alignment[] r0 = com.itextpdf.text.TabStop.Alignment.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25730a = r0
                com.itextpdf.text.TabStop$Alignment r1 = com.itextpdf.text.TabStop.Alignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25730a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.TabStop$Alignment r1 = com.itextpdf.text.TabStop.Alignment.CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f25730a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.TabStop$Alignment r1 = com.itextpdf.text.TabStop.Alignment.ANCHOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.TabStop.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Alignment {
        LEFT,
        RIGHT,
        CENTER,
        ANCHOR
    }

    public TabStop(float f2) {
        this(f2, Alignment.LEFT);
    }

    public static TabStop f(float f2, float f3) {
        float round = ((float) Math.round(f2 * 1000.0f)) / 1000.0f;
        float round2 = ((float) Math.round(f3 * 1000.0f)) / 1000.0f;
        return new TabStop((round + round2) - (round % round2));
    }

    public Alignment a() {
        return this.f25727b;
    }

    public char b() {
        return this.f25729d;
    }

    public DrawInterface c() {
        return this.f25728c;
    }

    public float d() {
        return this.f25726a;
    }

    public float e(float f2, float f3, float f4) {
        float f5;
        float f6 = this.f25726a;
        float f7 = f3 - f2;
        int i2 = AnonymousClass1.f25730a[this.f25727b.ordinal()];
        if (i2 == 1) {
            f5 = this.f25726a;
            if (f2 + f7 >= f5) {
                return f2;
            }
        } else if (i2 == 2) {
            f7 /= 2.0f;
            f5 = this.f25726a;
            if (f2 + f7 >= f5) {
                return f2;
            }
        } else if (i2 != 3) {
            return f6;
        } else {
            if (!Float.isNaN(f4)) {
                float f8 = this.f25726a;
                return f4 < f8 ? f8 - (f4 - f2) : f2;
            }
            f5 = this.f25726a;
            if (f2 + f7 >= f5) {
                return f2;
            }
        }
        return f5 - f7;
    }

    public void g(Alignment alignment) {
        this.f25727b = alignment;
    }

    public void h(char c2) {
        this.f25729d = c2;
    }

    public void i(DrawInterface drawInterface) {
        this.f25728c = drawInterface;
    }

    public void j(float f2) {
        this.f25726a = f2;
    }

    public TabStop(float f2, Alignment alignment) {
        this(f2, (DrawInterface) null, alignment);
    }

    public TabStop(float f2, Alignment alignment, char c2) {
        this(f2, (DrawInterface) null, alignment, c2);
    }

    public TabStop(float f2, DrawInterface drawInterface) {
        this(f2, drawInterface, Alignment.LEFT);
    }

    public TabStop(float f2, DrawInterface drawInterface, Alignment alignment) {
        this(f2, drawInterface, alignment, ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public TabStop(float f2, DrawInterface drawInterface, Alignment alignment, char c2) {
        Alignment alignment2 = Alignment.LEFT;
        this.f25726a = f2;
        this.f25728c = drawInterface;
        this.f25727b = alignment;
        this.f25729d = c2;
    }

    public TabStop(TabStop tabStop) {
        this(tabStop.d(), tabStop.c(), tabStop.a(), tabStop.b());
    }
}

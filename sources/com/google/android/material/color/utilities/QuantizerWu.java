package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWu implements Quantizer {

    /* renamed from: g  reason: collision with root package name */
    private static final int f21226g = 5;

    /* renamed from: h  reason: collision with root package name */
    private static final int f21227h = 33;

    /* renamed from: i  reason: collision with root package name */
    private static final int f21228i = 35937;

    /* renamed from: a  reason: collision with root package name */
    int[] f21229a;

    /* renamed from: b  reason: collision with root package name */
    int[] f21230b;

    /* renamed from: c  reason: collision with root package name */
    int[] f21231c;

    /* renamed from: d  reason: collision with root package name */
    int[] f21232d;

    /* renamed from: e  reason: collision with root package name */
    double[] f21233e;

    /* renamed from: f  reason: collision with root package name */
    Box[] f21234f;

    /* renamed from: com.google.android.material.color.utilities.QuantizerWu$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21235a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.android.material.color.utilities.QuantizerWu$Direction[] r0 = com.google.android.material.color.utilities.QuantizerWu.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21235a = r0
                com.google.android.material.color.utilities.QuantizerWu$Direction r1 = com.google.android.material.color.utilities.QuantizerWu.Direction.RED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21235a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.android.material.color.utilities.QuantizerWu$Direction r1 = com.google.android.material.color.utilities.QuantizerWu.Direction.GREEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21235a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.android.material.color.utilities.QuantizerWu$Direction r1 = com.google.android.material.color.utilities.QuantizerWu.Direction.BLUE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.QuantizerWu.AnonymousClass1.<clinit>():void");
        }
    }

    private static final class Box {

        /* renamed from: a  reason: collision with root package name */
        int f21236a;

        /* renamed from: b  reason: collision with root package name */
        int f21237b;

        /* renamed from: c  reason: collision with root package name */
        int f21238c;

        /* renamed from: d  reason: collision with root package name */
        int f21239d;

        /* renamed from: e  reason: collision with root package name */
        int f21240e;

        /* renamed from: f  reason: collision with root package name */
        int f21241f;

        /* renamed from: g  reason: collision with root package name */
        int f21242g;

        private Box() {
            this.f21236a = 0;
            this.f21237b = 0;
            this.f21238c = 0;
            this.f21239d = 0;
            this.f21240e = 0;
            this.f21241f = 0;
            this.f21242g = 0;
        }

        /* synthetic */ Box(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class CreateBoxesResult {

        /* renamed from: a  reason: collision with root package name */
        int f21243a;

        CreateBoxesResult(int i2, int i3) {
            this.f21243a = i3;
        }
    }

    private enum Direction {
        RED,
        GREEN,
        BLUE
    }

    private static final class MaximizeResult {

        /* renamed from: a  reason: collision with root package name */
        int f21244a;

        /* renamed from: b  reason: collision with root package name */
        double f21245b;

        MaximizeResult(int i2, double d2) {
            this.f21244a = i2;
            this.f21245b = d2;
        }
    }

    static int b(Box box, Direction direction, int[] iArr) {
        int i2;
        int i3;
        int i4 = AnonymousClass1.f21235a[direction.ordinal()];
        if (i4 == 1) {
            i2 = (-iArr[h(box.f21236a, box.f21239d, box.f21241f)]) + iArr[h(box.f21236a, box.f21239d, box.f21240e)] + iArr[h(box.f21236a, box.f21238c, box.f21241f)];
            i3 = iArr[h(box.f21236a, box.f21238c, box.f21240e)];
        } else if (i4 == 2) {
            i2 = (-iArr[h(box.f21237b, box.f21238c, box.f21241f)]) + iArr[h(box.f21237b, box.f21238c, box.f21240e)] + iArr[h(box.f21236a, box.f21238c, box.f21241f)];
            i3 = iArr[h(box.f21236a, box.f21238c, box.f21240e)];
        } else if (i4 == 3) {
            i2 = (-iArr[h(box.f21237b, box.f21239d, box.f21240e)]) + iArr[h(box.f21237b, box.f21238c, box.f21240e)] + iArr[h(box.f21236a, box.f21239d, box.f21240e)];
            i3 = iArr[h(box.f21236a, box.f21238c, box.f21240e)];
        } else {
            throw new IllegalArgumentException("unexpected direction " + direction);
        }
        return i2 - i3;
    }

    static int h(int i2, int i3, int i4) {
        return (i2 << 10) + (i2 << 6) + i2 + (i3 << 5) + i3 + i4;
    }

    static int j(Box box, Direction direction, int i2, int[] iArr) {
        int i3;
        int i4;
        int i5 = AnonymousClass1.f21235a[direction.ordinal()];
        if (i5 == 1) {
            i3 = (iArr[h(i2, box.f21239d, box.f21241f)] - iArr[h(i2, box.f21239d, box.f21240e)]) - iArr[h(i2, box.f21238c, box.f21241f)];
            i4 = iArr[h(i2, box.f21238c, box.f21240e)];
        } else if (i5 == 2) {
            i3 = (iArr[h(box.f21237b, i2, box.f21241f)] - iArr[h(box.f21237b, i2, box.f21240e)]) - iArr[h(box.f21236a, i2, box.f21241f)];
            i4 = iArr[h(box.f21236a, i2, box.f21240e)];
        } else if (i5 == 3) {
            i3 = (iArr[h(box.f21237b, box.f21239d, i2)] - iArr[h(box.f21237b, box.f21238c, i2)]) - iArr[h(box.f21236a, box.f21239d, i2)];
            i4 = iArr[h(box.f21236a, box.f21238c, i2)];
        } else {
            throw new IllegalArgumentException("unexpected direction " + direction);
        }
        return i3 + i4;
    }

    static int l(Box box, int[] iArr) {
        return ((((((iArr[h(box.f21237b, box.f21239d, box.f21241f)] - iArr[h(box.f21237b, box.f21239d, box.f21240e)]) - iArr[h(box.f21237b, box.f21238c, box.f21241f)]) + iArr[h(box.f21237b, box.f21238c, box.f21240e)]) - iArr[h(box.f21236a, box.f21239d, box.f21241f)]) + iArr[h(box.f21236a, box.f21239d, box.f21240e)]) + iArr[h(box.f21236a, box.f21238c, box.f21241f)]) - iArr[h(box.f21236a, box.f21238c, box.f21240e)];
    }

    public QuantizerResult a(int[] iArr, int i2) {
        c(new QuantizerMap().a(iArr, i2).f21223a);
        e();
        List<Integer> f2 = f(d(i2).f21243a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer next : f2) {
            next.intValue();
            linkedHashMap.put(next, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    /* access modifiers changed from: package-private */
    public void c(Map<Integer, Integer> map) {
        this.f21229a = new int[f21228i];
        this.f21230b = new int[f21228i];
        this.f21231c = new int[f21228i];
        this.f21232d = new int[f21228i];
        this.f21233e = new double[f21228i];
        for (Map.Entry next : map.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            int q = ColorUtils.q(intValue);
            int i2 = ColorUtils.i(intValue);
            int g2 = ColorUtils.g(intValue);
            int h2 = h((q >> 3) + 1, (i2 >> 3) + 1, (g2 >> 3) + 1);
            int[] iArr = this.f21229a;
            iArr[h2] = iArr[h2] + intValue2;
            int[] iArr2 = this.f21230b;
            iArr2[h2] = iArr2[h2] + (q * intValue2);
            int[] iArr3 = this.f21231c;
            iArr3[h2] = iArr3[h2] + (i2 * intValue2);
            int[] iArr4 = this.f21232d;
            iArr4[h2] = iArr4[h2] + (g2 * intValue2);
            double[] dArr = this.f21233e;
            dArr[h2] = dArr[h2] + ((double) (intValue2 * ((q * q) + (i2 * i2) + (g2 * g2))));
        }
    }

    /* access modifiers changed from: package-private */
    public CreateBoxesResult d(int i2) {
        int i3;
        this.f21234f = new Box[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            this.f21234f[i4] = new Box((AnonymousClass1) null);
        }
        double[] dArr = new double[i2];
        Box box = this.f21234f[0];
        box.f21237b = 32;
        box.f21239d = 32;
        box.f21241f = 32;
        int i5 = 1;
        int i6 = 0;
        while (true) {
            if (i5 >= i2) {
                i3 = i2;
                break;
            }
            Box[] boxArr = this.f21234f;
            if (g(boxArr[i6], boxArr[i5]).booleanValue()) {
                Box box2 = this.f21234f[i6];
                dArr[i6] = box2.f21242g > 1 ? k(box2) : 0.0d;
                Box box3 = this.f21234f[i5];
                dArr[i5] = box3.f21242g > 1 ? k(box3) : 0.0d;
            } else {
                dArr[i6] = 0.0d;
                i5--;
            }
            double d2 = dArr[0];
            int i7 = 0;
            for (int i8 = 1; i8 <= i5; i8++) {
                double d3 = dArr[i8];
                if (d3 > d2) {
                    i7 = i8;
                    d2 = d3;
                }
            }
            if (d2 <= 0.0d) {
                i3 = i5 + 1;
                break;
            }
            i5++;
            i6 = i7;
        }
        return new CreateBoxesResult(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        int i2 = 1;
        while (true) {
            int i3 = 33;
            if (i2 < 33) {
                int[] iArr = new int[33];
                int[] iArr2 = new int[33];
                int[] iArr3 = new int[33];
                int[] iArr4 = new int[33];
                double[] dArr = new double[33];
                int i4 = 1;
                while (i4 < i3) {
                    int i5 = 0;
                    double d2 = 0.0d;
                    int i6 = 1;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    while (i6 < i3) {
                        int h2 = h(i2, i4, i6);
                        int i10 = i5 + this.f21229a[h2];
                        i7 += this.f21230b[h2];
                        i8 += this.f21231c[h2];
                        i9 += this.f21232d[h2];
                        d2 += this.f21233e[h2];
                        iArr[i6] = iArr[i6] + i10;
                        iArr2[i6] = iArr2[i6] + i7;
                        iArr3[i6] = iArr3[i6] + i8;
                        iArr4[i6] = iArr4[i6] + i9;
                        dArr[i6] = dArr[i6] + d2;
                        int h3 = h(i2 - 1, i4, i6);
                        int i11 = i10;
                        int[] iArr5 = this.f21229a;
                        iArr5[h2] = iArr5[h3] + iArr[i6];
                        int[] iArr6 = this.f21230b;
                        iArr6[h2] = iArr6[h3] + iArr2[i6];
                        int[] iArr7 = this.f21231c;
                        iArr7[h2] = iArr7[h3] + iArr3[i6];
                        int[] iArr8 = this.f21232d;
                        iArr8[h2] = iArr8[h3] + iArr4[i6];
                        double[] dArr2 = this.f21233e;
                        dArr2[h2] = dArr2[h3] + dArr[i6];
                        i6++;
                        i5 = i11;
                        i3 = 33;
                    }
                    i4++;
                    i3 = 33;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<Integer> f(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            Box box = this.f21234f[i3];
            int l2 = l(box, this.f21229a);
            if (l2 > 0) {
                int l3 = l(box, this.f21231c) / l2;
                arrayList.add(Integer.valueOf(((l(box, this.f21232d) / l2) & 255) | (((l(box, this.f21230b) / l2) & 255) << 16) | ViewCompat.y | ((l3 & 255) << 8)));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Boolean g(Box box, Box box2) {
        int i2;
        int i3;
        Box box3 = box;
        Box box4 = box2;
        int l2 = l(box3, this.f21230b);
        int l3 = l(box3, this.f21231c);
        int l4 = l(box3, this.f21232d);
        int l5 = l(box3, this.f21229a);
        Direction direction = Direction.RED;
        Box box5 = box;
        int i4 = l2;
        int i5 = l3;
        int i6 = l4;
        MaximizeResult i7 = i(box5, direction, box3.f21236a + 1, box3.f21237b, i4, i5, i6, l5);
        Direction direction2 = Direction.GREEN;
        MaximizeResult maximizeResult = i7;
        MaximizeResult i8 = i(box5, direction2, box3.f21238c + 1, box3.f21239d, i4, i5, i6, l5);
        Direction direction3 = Direction.BLUE;
        MaximizeResult maximizeResult2 = i8;
        MaximizeResult i9 = i(box5, direction3, box3.f21240e + 1, box3.f21241f, i4, i5, i6, l5);
        MaximizeResult maximizeResult3 = maximizeResult;
        double d2 = maximizeResult3.f21245b;
        double d3 = maximizeResult2.f21245b;
        double d4 = i9.f21245b;
        if (d2 < d3 || d2 < d4) {
            direction = (d3 < d2 || d3 < d4) ? direction3 : direction2;
        } else if (maximizeResult3.f21244a < 0) {
            return Boolean.FALSE;
        }
        box4.f21237b = box3.f21237b;
        box4.f21239d = box3.f21239d;
        box4.f21241f = box3.f21241f;
        int i10 = AnonymousClass1.f21235a[direction.ordinal()];
        if (i10 == 1) {
            int i11 = maximizeResult3.f21244a;
            box3.f21237b = i11;
            box4.f21236a = i11;
            i2 = box3.f21238c;
            box4.f21238c = i2;
            i3 = box3.f21240e;
        } else if (i10 != 2) {
            if (i10 == 3) {
                i3 = i9.f21244a;
                box3.f21241f = i3;
                box4.f21236a = box3.f21236a;
                box4.f21238c = box3.f21238c;
            }
            box3.f21242g = (box3.f21237b - box3.f21236a) * (box3.f21239d - box3.f21238c) * (box3.f21241f - box3.f21240e);
            box4.f21242g = (box4.f21237b - box4.f21236a) * (box4.f21239d - box4.f21238c) * (box4.f21241f - box4.f21240e);
            return Boolean.TRUE;
        } else {
            i2 = maximizeResult2.f21244a;
            box3.f21239d = i2;
            box4.f21236a = box3.f21236a;
            box4.f21238c = i2;
            i3 = box3.f21240e;
        }
        box4.f21240e = i3;
        box3.f21242g = (box3.f21237b - box3.f21236a) * (box3.f21239d - box3.f21238c) * (box3.f21241f - box3.f21240e);
        box4.f21242g = (box4.f21237b - box4.f21236a) * (box4.f21239d - box4.f21238c) * (box4.f21241f - box4.f21240e);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: package-private */
    public MaximizeResult i(Box box, Direction direction, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        Direction direction2 = direction;
        int b2 = b(box2, direction2, quantizerWu.f21230b);
        int b3 = b(box2, direction2, quantizerWu.f21231c);
        int b4 = b(box2, direction2, quantizerWu.f21232d);
        int b5 = b(box2, direction2, quantizerWu.f21229a);
        int i9 = i3;
        double d2 = 0.0d;
        int i10 = -1;
        int i11 = i2;
        while (i11 < i9) {
            int j2 = j(box2, direction2, i11, quantizerWu.f21230b) + b2;
            int j3 = j(box2, direction2, i11, quantizerWu.f21231c) + b3;
            int j4 = j(box2, direction2, i11, quantizerWu.f21232d) + b4;
            int j5 = j(box2, direction2, i11, quantizerWu.f21229a) + b5;
            if (j5 == 0) {
                i8 = b2;
            } else {
                i8 = b2;
                double d3 = ((double) (((j2 * j2) + (j3 * j3)) + (j4 * j4))) / ((double) j5);
                int i12 = i4 - j2;
                int i13 = i5 - j3;
                int i14 = i6 - j4;
                int i15 = i7 - j5;
                if (i15 != 0) {
                    double d4 = d3 + (((double) (((i12 * i12) + (i13 * i13)) + (i14 * i14))) / ((double) i15));
                    if (d4 > d2) {
                        d2 = d4;
                        i10 = i11;
                    }
                }
            }
            i11++;
            quantizerWu = this;
            box2 = box;
            direction2 = direction;
            b2 = i8;
        }
        return new MaximizeResult(i10, d2);
    }

    /* access modifiers changed from: package-private */
    public double k(Box box) {
        int l2 = l(box, this.f21230b);
        int l3 = l(box, this.f21231c);
        int l4 = l(box, this.f21232d);
        return (((((((this.f21233e[h(box.f21237b, box.f21239d, box.f21241f)] - this.f21233e[h(box.f21237b, box.f21239d, box.f21240e)]) - this.f21233e[h(box.f21237b, box.f21238c, box.f21241f)]) + this.f21233e[h(box.f21237b, box.f21238c, box.f21240e)]) - this.f21233e[h(box.f21236a, box.f21239d, box.f21241f)]) + this.f21233e[h(box.f21236a, box.f21239d, box.f21240e)]) + this.f21233e[h(box.f21236a, box.f21238c, box.f21241f)]) - this.f21233e[h(box.f21236a, box.f21238c, box.f21240e)]) - (((double) (((l2 * l2) + (l3 * l3)) + (l4 * l4))) / ((double) l(box, this.f21229a)));
    }
}

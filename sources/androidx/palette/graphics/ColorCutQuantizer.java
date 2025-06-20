package androidx.palette.graphics;

import android.graphics.Color;
import android.util.TimingLogger;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

final class ColorCutQuantizer {

    /* renamed from: g  reason: collision with root package name */
    private static final String f14948g = "ColorCutQuantizer";

    /* renamed from: h  reason: collision with root package name */
    private static final boolean f14949h = false;

    /* renamed from: i  reason: collision with root package name */
    static final int f14950i = -3;

    /* renamed from: j  reason: collision with root package name */
    static final int f14951j = -2;

    /* renamed from: k  reason: collision with root package name */
    static final int f14952k = -1;

    /* renamed from: l  reason: collision with root package name */
    private static final int f14953l = 5;

    /* renamed from: m  reason: collision with root package name */
    private static final int f14954m = 31;

    /* renamed from: n  reason: collision with root package name */
    private static final Comparator<Vbox> f14955n = new Comparator<Vbox>() {
        /* renamed from: a */
        public int compare(Vbox vbox, Vbox vbox2) {
            return vbox2.g() - vbox.g();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int[] f14956a;

    /* renamed from: b  reason: collision with root package name */
    final int[] f14957b;

    /* renamed from: c  reason: collision with root package name */
    final List<Palette.Swatch> f14958c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    final TimingLogger f14959d = null;

    /* renamed from: e  reason: collision with root package name */
    final Palette.Filter[] f14960e;

    /* renamed from: f  reason: collision with root package name */
    private final float[] f14961f = new float[3];

    private class Vbox {

        /* renamed from: a  reason: collision with root package name */
        private int f14962a;

        /* renamed from: b  reason: collision with root package name */
        private int f14963b;

        /* renamed from: c  reason: collision with root package name */
        private int f14964c;

        /* renamed from: d  reason: collision with root package name */
        private int f14965d;

        /* renamed from: e  reason: collision with root package name */
        private int f14966e;

        /* renamed from: f  reason: collision with root package name */
        private int f14967f;

        /* renamed from: g  reason: collision with root package name */
        private int f14968g;

        /* renamed from: h  reason: collision with root package name */
        private int f14969h;

        /* renamed from: i  reason: collision with root package name */
        private int f14970i;

        Vbox(int i2, int i3) {
            this.f14962a = i2;
            this.f14963b = i3;
            c();
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return e() > 1;
        }

        /* access modifiers changed from: package-private */
        public final int b() {
            int f2 = f();
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f14956a;
            int[] iArr2 = colorCutQuantizer.f14957b;
            ColorCutQuantizer.e(iArr, f2, this.f14962a, this.f14963b);
            Arrays.sort(iArr, this.f14962a, this.f14963b + 1);
            ColorCutQuantizer.e(iArr, f2, this.f14962a, this.f14963b);
            int i2 = this.f14964c / 2;
            int i3 = this.f14962a;
            int i4 = 0;
            while (true) {
                int i5 = this.f14963b;
                if (i3 > i5) {
                    return this.f14962a;
                }
                i4 += iArr2[iArr[i3]];
                if (i4 >= i2) {
                    return Math.min(i5 - 1, i3);
                }
                i3++;
            }
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f14956a;
            int[] iArr2 = colorCutQuantizer.f14957b;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = 0;
            for (int i9 = this.f14962a; i9 <= this.f14963b; i9++) {
                int i10 = iArr[i9];
                i8 += iArr2[i10];
                int k2 = ColorCutQuantizer.k(i10);
                int j2 = ColorCutQuantizer.j(i10);
                int i11 = ColorCutQuantizer.i(i10);
                if (k2 > i5) {
                    i5 = k2;
                }
                if (k2 < i2) {
                    i2 = k2;
                }
                if (j2 > i6) {
                    i6 = j2;
                }
                if (j2 < i3) {
                    i3 = j2;
                }
                if (i11 > i7) {
                    i7 = i11;
                }
                if (i11 < i4) {
                    i4 = i11;
                }
            }
            this.f14965d = i2;
            this.f14966e = i5;
            this.f14967f = i3;
            this.f14968g = i6;
            this.f14969h = i4;
            this.f14970i = i7;
            this.f14964c = i8;
        }

        /* access modifiers changed from: package-private */
        public final Palette.Swatch d() {
            ColorCutQuantizer colorCutQuantizer = ColorCutQuantizer.this;
            int[] iArr = colorCutQuantizer.f14956a;
            int[] iArr2 = colorCutQuantizer.f14957b;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = this.f14962a; i6 <= this.f14963b; i6++) {
                int i7 = iArr[i6];
                int i8 = iArr2[i7];
                i3 += i8;
                i2 += ColorCutQuantizer.k(i7) * i8;
                i4 += ColorCutQuantizer.j(i7) * i8;
                i5 += i8 * ColorCutQuantizer.i(i7);
            }
            float f2 = (float) i3;
            return new Palette.Swatch(ColorCutQuantizer.b(Math.round(((float) i2) / f2), Math.round(((float) i4) / f2), Math.round(((float) i5) / f2)), i3);
        }

        /* access modifiers changed from: package-private */
        public final int e() {
            return (this.f14963b + 1) - this.f14962a;
        }

        /* access modifiers changed from: package-private */
        public final int f() {
            int i2 = this.f14966e - this.f14965d;
            int i3 = this.f14968g - this.f14967f;
            int i4 = this.f14970i - this.f14969h;
            if (i2 < i3 || i2 < i4) {
                return (i3 < i2 || i3 < i4) ? -1 : -2;
            }
            return -3;
        }

        /* access modifiers changed from: package-private */
        public final int g() {
            return ((this.f14966e - this.f14965d) + 1) * ((this.f14968g - this.f14967f) + 1) * ((this.f14970i - this.f14969h) + 1);
        }

        /* access modifiers changed from: package-private */
        public final Vbox h() {
            if (a()) {
                int b2 = b();
                Vbox vbox = new Vbox(b2 + 1, this.f14963b);
                this.f14963b = b2;
                c();
                return vbox;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }
    }

    ColorCutQuantizer(int[] iArr, int i2, Palette.Filter[] filterArr) {
        this.f14960e = filterArr;
        int[] iArr2 = new int[32768];
        this.f14957b = iArr2;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int g2 = g(iArr[i3]);
            iArr[i3] = g2;
            iArr2[g2] = iArr2[g2] + 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 32768; i5++) {
            if (iArr2[i5] > 0 && l(i5)) {
                iArr2[i5] = 0;
            }
            if (iArr2[i5] > 0) {
                i4++;
            }
        }
        int[] iArr3 = new int[i4];
        this.f14956a = iArr3;
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0) {
                iArr3[i6] = i7;
                i6++;
            }
        }
        if (i4 <= i2) {
            this.f14958c = new ArrayList();
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = iArr3[i8];
                this.f14958c.add(new Palette.Swatch(a(i9), iArr2[i9]));
            }
            return;
        }
        this.f14958c = h(i2);
    }

    private static int a(int i2) {
        return b(k(i2), j(i2), i(i2));
    }

    static int b(int i2, int i3, int i4) {
        return Color.rgb(f(i2, 5, 8), f(i3, 5, 8), f(i4, 5, 8));
    }

    private List<Palette.Swatch> c(Collection<Vbox> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Vbox d2 : collection) {
            Palette.Swatch d3 = d2.d();
            if (!n(d3)) {
                arrayList.add(d3);
            }
        }
        return arrayList;
    }

    static void e(int[] iArr, int i2, int i3, int i4) {
        if (i2 == -2) {
            while (i3 <= i4) {
                int i5 = iArr[i3];
                iArr[i3] = i(i5) | (j(i5) << 10) | (k(i5) << 5);
                i3++;
            }
        } else if (i2 == -1) {
            while (i3 <= i4) {
                int i6 = iArr[i3];
                iArr[i3] = k(i6) | (i(i6) << 10) | (j(i6) << 5);
                i3++;
            }
        }
    }

    private static int f(int i2, int i3, int i4) {
        return (i4 > i3 ? i2 << (i4 - i3) : i2 >> (i3 - i4)) & ((1 << i4) - 1);
    }

    private static int g(int i2) {
        return f(Color.blue(i2), 8, 5) | (f(Color.red(i2), 8, 5) << 10) | (f(Color.green(i2), 8, 5) << 5);
    }

    private List<Palette.Swatch> h(int i2) {
        PriorityQueue priorityQueue = new PriorityQueue(i2, f14955n);
        priorityQueue.offer(new Vbox(0, this.f14956a.length - 1));
        o(priorityQueue, i2);
        return c(priorityQueue);
    }

    static int i(int i2) {
        return i2 & 31;
    }

    static int j(int i2) {
        return (i2 >> 5) & 31;
    }

    static int k(int i2) {
        return (i2 >> 10) & 31;
    }

    private boolean l(int i2) {
        int a2 = a(i2);
        ColorUtils.q(a2, this.f14961f);
        return m(a2, this.f14961f);
    }

    private boolean m(int i2, float[] fArr) {
        Palette.Filter[] filterArr = this.f14960e;
        if (filterArr != null && filterArr.length > 0) {
            int length = filterArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (!this.f14960e[i3].a(i2, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean n(Palette.Swatch swatch) {
        return m(swatch.e(), swatch.c());
    }

    private void o(PriorityQueue<Vbox> priorityQueue, int i2) {
        Vbox poll;
        while (priorityQueue.size() < i2 && (poll = priorityQueue.poll()) != null && poll.a()) {
            priorityQueue.offer(poll.h());
            priorityQueue.offer(poll);
        }
    }

    /* access modifiers changed from: package-private */
    public List<Palette.Swatch> d() {
        return this.f14958c;
    }
}

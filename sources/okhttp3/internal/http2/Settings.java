package okhttp3.internal.http2;

import java.util.Arrays;

public final class Settings {

    /* renamed from: c  reason: collision with root package name */
    static final int f31214c = 65535;

    /* renamed from: d  reason: collision with root package name */
    static final int f31215d = 1;

    /* renamed from: e  reason: collision with root package name */
    static final int f31216e = 2;

    /* renamed from: f  reason: collision with root package name */
    static final int f31217f = 4;

    /* renamed from: g  reason: collision with root package name */
    static final int f31218g = 5;

    /* renamed from: h  reason: collision with root package name */
    static final int f31219h = 6;

    /* renamed from: i  reason: collision with root package name */
    static final int f31220i = 7;

    /* renamed from: j  reason: collision with root package name */
    static final int f31221j = 10;

    /* renamed from: a  reason: collision with root package name */
    private int f31222a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f31223b = new int[10];

    /* access modifiers changed from: package-private */
    public void a() {
        this.f31222a = 0;
        Arrays.fill(this.f31223b, 0);
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        return this.f31223b[i2];
    }

    /* access modifiers changed from: package-private */
    public boolean c(boolean z) {
        return ((this.f31222a & 4) != 0 ? this.f31223b[2] : z ? 1 : 0) == 1;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        if ((this.f31222a & 2) != 0) {
            return this.f31223b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        if ((this.f31222a & 128) != 0) {
            return this.f31223b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    public int f(int i2) {
        return (this.f31222a & 16) != 0 ? this.f31223b[4] : i2;
    }

    /* access modifiers changed from: package-private */
    public int g(int i2) {
        return (this.f31222a & 32) != 0 ? this.f31223b[5] : i2;
    }

    /* access modifiers changed from: package-private */
    public int h(int i2) {
        return (this.f31222a & 64) != 0 ? this.f31223b[6] : i2;
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i2) {
        return ((1 << i2) & this.f31222a) != 0;
    }

    /* access modifiers changed from: package-private */
    public void j(Settings settings) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (settings.i(i2)) {
                k(i2, settings.b(i2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Settings k(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f31223b;
            if (i2 < iArr.length) {
                this.f31222a = (1 << i2) | this.f31222a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public int l() {
        return Integer.bitCount(this.f31222a);
    }
}

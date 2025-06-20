package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

class ViewBoundsCheck {

    /* renamed from: c  reason: collision with root package name */
    static final int f15662c = 1;

    /* renamed from: d  reason: collision with root package name */
    static final int f15663d = 2;

    /* renamed from: e  reason: collision with root package name */
    static final int f15664e = 4;

    /* renamed from: f  reason: collision with root package name */
    static final int f15665f = 0;

    /* renamed from: g  reason: collision with root package name */
    static final int f15666g = 1;

    /* renamed from: h  reason: collision with root package name */
    static final int f15667h = 2;

    /* renamed from: i  reason: collision with root package name */
    static final int f15668i = 4;

    /* renamed from: j  reason: collision with root package name */
    static final int f15669j = 4;

    /* renamed from: k  reason: collision with root package name */
    static final int f15670k = 16;

    /* renamed from: l  reason: collision with root package name */
    static final int f15671l = 32;

    /* renamed from: m  reason: collision with root package name */
    static final int f15672m = 64;

    /* renamed from: n  reason: collision with root package name */
    static final int f15673n = 8;
    static final int o = 256;
    static final int p = 512;
    static final int q = 1024;
    static final int r = 12;
    static final int s = 4096;
    static final int t = 8192;
    static final int u = 16384;
    static final int v = 7;

    /* renamed from: a  reason: collision with root package name */
    final Callback f15674a;

    /* renamed from: b  reason: collision with root package name */
    BoundFlags f15675b = new BoundFlags();

    static class BoundFlags {

        /* renamed from: a  reason: collision with root package name */
        int f15676a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f15677b;

        /* renamed from: c  reason: collision with root package name */
        int f15678c;

        /* renamed from: d  reason: collision with root package name */
        int f15679d;

        /* renamed from: e  reason: collision with root package name */
        int f15680e;

        BoundFlags() {
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f15676a = i2 | this.f15676a;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i2 = this.f15676a;
            if ((i2 & 7) != 0 && (i2 & c(this.f15679d, this.f15677b)) == 0) {
                return false;
            }
            int i3 = this.f15676a;
            if ((i3 & 112) != 0 && (i3 & (c(this.f15679d, this.f15678c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f15676a;
            if ((i4 & 1792) != 0 && (i4 & (c(this.f15680e, this.f15677b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f15676a;
            return (i5 & 28672) == 0 || (i5 & (c(this.f15680e, this.f15678c) << 12)) != 0;
        }

        /* access modifiers changed from: package-private */
        public int c(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f15676a = 0;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, int i3, int i4, int i5) {
            this.f15677b = i2;
            this.f15678c = i3;
            this.f15679d = i4;
            this.f15680e = i5;
        }
    }

    interface Callback {
        View a(int i2);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    ViewBoundsCheck(Callback callback) {
        this.f15674a = callback;
    }

    /* access modifiers changed from: package-private */
    public View a(int i2, int i3, int i4, int i5) {
        int c2 = this.f15674a.c();
        int d2 = this.f15674a.d();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View a2 = this.f15674a.a(i2);
            this.f15675b.e(c2, d2, this.f15674a.b(a2), this.f15674a.e(a2));
            if (i4 != 0) {
                this.f15675b.d();
                this.f15675b.a(i4);
                if (this.f15675b.b()) {
                    return a2;
                }
            }
            if (i5 != 0) {
                this.f15675b.d();
                this.f15675b.a(i5);
                if (this.f15675b.b()) {
                    view = a2;
                }
            }
            i2 += i6;
        }
        return view;
    }

    /* access modifiers changed from: package-private */
    public boolean b(View view, int i2) {
        this.f15675b.e(this.f15674a.c(), this.f15674a.d(), this.f15674a.b(view), this.f15674a.e(view));
        if (i2 == 0) {
            return false;
        }
        this.f15675b.d();
        this.f15675b.a(i2);
        return this.f15675b.b();
    }
}

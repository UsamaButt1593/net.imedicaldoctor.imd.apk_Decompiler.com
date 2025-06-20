package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f15250f = false;

    /* renamed from: g  reason: collision with root package name */
    private static final String f15251g = "ChildrenHelper";

    /* renamed from: h  reason: collision with root package name */
    private static final int f15252h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static final int f15253i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final int f15254j = 2;

    /* renamed from: a  reason: collision with root package name */
    final Callback f15255a;

    /* renamed from: b  reason: collision with root package name */
    final Bucket f15256b;

    /* renamed from: c  reason: collision with root package name */
    final List<View> f15257c;

    /* renamed from: d  reason: collision with root package name */
    private int f15258d = 0;

    /* renamed from: e  reason: collision with root package name */
    private View f15259e;

    static class Bucket {

        /* renamed from: c  reason: collision with root package name */
        static final int f15260c = 64;

        /* renamed from: d  reason: collision with root package name */
        static final long f15261d = Long.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        long f15262a = 0;

        /* renamed from: b  reason: collision with root package name */
        Bucket f15263b;

        Bucket() {
        }

        private void c() {
            if (this.f15263b == null) {
                this.f15263b = new Bucket();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if (i2 >= 64) {
                Bucket bucket = this.f15263b;
                if (bucket != null) {
                    bucket.a(i2 - 64);
                    return;
                }
                return;
            }
            this.f15262a &= ~(1 << i2);
        }

        /* access modifiers changed from: package-private */
        public int b(int i2) {
            Bucket bucket = this.f15263b;
            return bucket == null ? i2 >= 64 ? Long.bitCount(this.f15262a) : Long.bitCount(this.f15262a & ((1 << i2) - 1)) : i2 < 64 ? Long.bitCount(this.f15262a & ((1 << i2) - 1)) : bucket.b(i2 - 64) + Long.bitCount(this.f15262a);
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i2) {
            if (i2 < 64) {
                return (this.f15262a & (1 << i2)) != 0;
            }
            c();
            return this.f15263b.d(i2 - 64);
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, boolean z) {
            if (i2 >= 64) {
                c();
                this.f15263b.e(i2 - 64, z);
                return;
            }
            long j2 = this.f15262a;
            boolean z2 = (Long.MIN_VALUE & j2) != 0;
            long j3 = (1 << i2) - 1;
            this.f15262a = ((j2 & (~j3)) << 1) | (j2 & j3);
            if (z) {
                h(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f15263b != null) {
                c();
                this.f15263b.e(0, z2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean f(int i2) {
            if (i2 >= 64) {
                c();
                return this.f15263b.f(i2 - 64);
            }
            long j2 = 1 << i2;
            long j3 = this.f15262a;
            boolean z = (j3 & j2) != 0;
            long j4 = j3 & (~j2);
            this.f15262a = j4;
            long j5 = j2 - 1;
            this.f15262a = (j4 & j5) | Long.rotateRight((~j5) & j4, 1);
            Bucket bucket = this.f15263b;
            if (bucket != null) {
                if (bucket.d(0)) {
                    h(63);
                }
                this.f15263b.f(0);
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            this.f15262a = 0;
            Bucket bucket = this.f15263b;
            if (bucket != null) {
                bucket.g();
            }
        }

        /* access modifiers changed from: package-private */
        public void h(int i2) {
            if (i2 >= 64) {
                c();
                this.f15263b.h(i2 - 64);
                return;
            }
            this.f15262a |= 1 << i2;
        }

        public String toString() {
            if (this.f15263b == null) {
                return Long.toBinaryString(this.f15262a);
            }
            return this.f15263b.toString() + "xx" + Long.toBinaryString(this.f15262a);
        }
    }

    interface Callback {
        View a(int i2);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.ViewHolder f(View view);

        void g(int i2);

        void h(View view);

        void i(View view, int i2);

        void j(int i2);

        void k(View view, int i2, ViewGroup.LayoutParams layoutParams);
    }

    ChildHelper(Callback callback) {
        this.f15255a = callback;
        this.f15256b = new Bucket();
        this.f15257c = new ArrayList();
    }

    private int h(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int c2 = this.f15255a.c();
        int i3 = i2;
        while (i3 < c2) {
            int b2 = i2 - (i3 - this.f15256b.b(i3));
            if (b2 == 0) {
                while (this.f15256b.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b2;
        }
        return -1;
    }

    private void l(View view) {
        this.f15257c.add(view);
        this.f15255a.b(view);
    }

    private boolean t(View view) {
        if (!this.f15257c.remove(view)) {
            return false;
        }
        this.f15255a.h(view);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, boolean z) {
        int c2 = i2 < 0 ? this.f15255a.c() : h(i2);
        this.f15256b.e(c2, z);
        if (z) {
            l(view);
        }
        this.f15255a.i(view, c2);
    }

    /* access modifiers changed from: package-private */
    public void b(View view, boolean z) {
        a(view, -1, z);
    }

    /* access modifiers changed from: package-private */
    public void c(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int c2 = i2 < 0 ? this.f15255a.c() : h(i2);
        this.f15256b.e(c2, z);
        if (z) {
            l(view);
        }
        this.f15255a.k(view, c2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        int h2 = h(i2);
        this.f15256b.f(h2);
        this.f15255a.g(h2);
    }

    /* access modifiers changed from: package-private */
    public View e(int i2) {
        int size = this.f15257c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f15257c.get(i3);
            RecyclerView.ViewHolder f2 = this.f15255a.f(view);
            if (f2.G() == i2 && !f2.O() && !f2.Q()) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View f(int i2) {
        return this.f15255a.a(h(i2));
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f15255a.c() - this.f15257c.size();
    }

    /* access modifiers changed from: package-private */
    public View i(int i2) {
        return this.f15255a.a(i2);
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.f15255a.c();
    }

    /* access modifiers changed from: package-private */
    public void k(View view) {
        int e2 = this.f15255a.e(view);
        if (e2 >= 0) {
            this.f15256b.h(e2);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* access modifiers changed from: package-private */
    public int m(View view) {
        int e2 = this.f15255a.e(view);
        if (e2 != -1 && !this.f15256b.d(e2)) {
            return e2 - this.f15256b.b(e2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f15257c.contains(view);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f15256b.g();
        for (int size = this.f15257c.size() - 1; size >= 0; size--) {
            this.f15255a.h(this.f15257c.get(size));
            this.f15257c.remove(size);
        }
        this.f15255a.d();
    }

    /* access modifiers changed from: package-private */
    public void p(View view) {
        int i2 = this.f15258d;
        if (i2 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        } else if (i2 != 2) {
            try {
                this.f15258d = 1;
                this.f15259e = view;
                int e2 = this.f15255a.e(view);
                if (e2 < 0) {
                    this.f15258d = 0;
                    this.f15259e = null;
                    return;
                }
                if (this.f15256b.f(e2)) {
                    t(view);
                }
                this.f15255a.j(e2);
                this.f15258d = 0;
                this.f15259e = null;
            } catch (Throwable th) {
                this.f15258d = 0;
                this.f15259e = null;
                throw th;
            }
        } else {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i2) {
        int i3 = this.f15258d;
        if (i3 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        } else if (i3 != 2) {
            try {
                int h2 = h(i2);
                View a2 = this.f15255a.a(h2);
                if (a2 == null) {
                    this.f15258d = 0;
                    this.f15259e = null;
                    return;
                }
                this.f15258d = 1;
                this.f15259e = a2;
                if (this.f15256b.f(h2)) {
                    t(a2);
                }
                this.f15255a.j(h2);
                this.f15258d = 0;
                this.f15259e = null;
            } catch (Throwable th) {
                this.f15258d = 0;
                this.f15259e = null;
                throw th;
            }
        } else {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean r(View view) {
        int i2 = this.f15258d;
        if (i2 == 1) {
            if (this.f15259e == view) {
                return false;
            }
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
        } else if (i2 != 2) {
            try {
                this.f15258d = 2;
                int e2 = this.f15255a.e(view);
                if (e2 == -1) {
                    t(view);
                    this.f15258d = 0;
                    return true;
                } else if (this.f15256b.d(e2)) {
                    this.f15256b.f(e2);
                    t(view);
                    this.f15255a.j(e2);
                    this.f15258d = 0;
                    return true;
                } else {
                    this.f15258d = 0;
                    return false;
                }
            } catch (Throwable th) {
                this.f15258d = 0;
                throw th;
            }
        } else {
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
        }
    }

    /* access modifiers changed from: package-private */
    public void s(View view) {
        int e2 = this.f15255a.e(view);
        if (e2 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f15256b.d(e2)) {
            this.f15256b.a(e2);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f15256b.toString() + ", hidden list:" + this.f15257c.size();
    }
}

package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

final class ScrollEventAdapter extends RecyclerView.OnScrollListener {

    /* renamed from: n  reason: collision with root package name */
    private static final int f16572n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    private static final int r = 4;
    private static final int s = -1;

    /* renamed from: a  reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f16573a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f16574b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f16575c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayoutManager f16576d;

    /* renamed from: e  reason: collision with root package name */
    private int f16577e;

    /* renamed from: f  reason: collision with root package name */
    private int f16578f;

    /* renamed from: g  reason: collision with root package name */
    private ScrollEventValues f16579g = new ScrollEventValues();

    /* renamed from: h  reason: collision with root package name */
    private int f16580h;

    /* renamed from: i  reason: collision with root package name */
    private int f16581i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16582j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16583k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16584l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16585m;

    private static final class ScrollEventValues {

        /* renamed from: a  reason: collision with root package name */
        int f16586a;

        /* renamed from: b  reason: collision with root package name */
        float f16587b;

        /* renamed from: c  reason: collision with root package name */
        int f16588c;

        ScrollEventValues() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f16586a = -1;
            this.f16587b = 0.0f;
            this.f16588c = 0;
        }
    }

    ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f16574b = viewPager2;
        RecyclerView recyclerView = viewPager2.f3;
        this.f16575c = recyclerView;
        this.f16576d = (LinearLayoutManager) recyclerView.getLayoutManager();
        q();
    }

    private void c(int i2, float f2, int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f16573a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.b(i2, f2, i3);
        }
    }

    private void d(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f16573a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.c(i2);
        }
    }

    private void e(int i2) {
        if ((this.f16577e != 3 || this.f16578f != 0) && this.f16578f != i2) {
            this.f16578f = i2;
            ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f16573a;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.a(i2);
            }
        }
    }

    private int f() {
        return this.f16576d.B2();
    }

    private boolean l() {
        int i2 = this.f16577e;
        return i2 == 1 || i2 == 4;
    }

    private void q() {
        this.f16577e = 0;
        this.f16578f = 0;
        this.f16579g.a();
        this.f16580h = -1;
        this.f16581i = -1;
        this.f16582j = false;
        this.f16583k = false;
        this.f16585m = false;
        this.f16584l = false;
    }

    private void s(boolean z) {
        this.f16585m = z;
        this.f16577e = z ? 4 : 1;
        int i2 = this.f16581i;
        if (i2 != -1) {
            this.f16580h = i2;
            this.f16581i = -1;
        } else if (this.f16580h == -1) {
            this.f16580h = f();
        }
        e(1);
    }

    private void t() {
        int i2;
        ScrollEventValues scrollEventValues = this.f16579g;
        int B2 = this.f16576d.B2();
        scrollEventValues.f16586a = B2;
        if (B2 == -1) {
            scrollEventValues.a();
            return;
        }
        View O = this.f16576d.O(B2);
        if (O == null) {
            scrollEventValues.a();
            return;
        }
        int n0 = this.f16576d.n0(O);
        int y0 = this.f16576d.y0(O);
        int B0 = this.f16576d.B0(O);
        int T = this.f16576d.T(O);
        ViewGroup.LayoutParams layoutParams = O.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            n0 += marginLayoutParams.leftMargin;
            y0 += marginLayoutParams.rightMargin;
            B0 += marginLayoutParams.topMargin;
            T += marginLayoutParams.bottomMargin;
        }
        int height = O.getHeight() + B0 + T;
        int width = O.getWidth() + n0 + y0;
        if (this.f16576d.Q2() == 0) {
            i2 = (O.getLeft() - n0) - this.f16575c.getPaddingLeft();
            if (this.f16574b.k()) {
                i2 = -i2;
            }
            height = width;
        } else {
            i2 = (O.getTop() - B0) - this.f16575c.getPaddingTop();
        }
        int i3 = -i2;
        scrollEventValues.f16588c = i3;
        if (i3 >= 0) {
            scrollEventValues.f16587b = height == 0 ? 0.0f : ((float) i3) / ((float) height);
        } else if (new AnimateLayoutChangeDetector(this.f16576d).d()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(scrollEventValues.f16588c)}));
        }
    }

    public void a(@NonNull RecyclerView recyclerView, int i2) {
        if (!(this.f16577e == 1 && this.f16578f == 1) && i2 == 1) {
            s(false);
        } else if (!l() || i2 != 2) {
            if (l() && i2 == 0) {
                t();
                if (!this.f16583k) {
                    int i3 = this.f16579g.f16586a;
                    if (i3 != -1) {
                        c(i3, 0.0f, 0);
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.f16579g;
                    if (scrollEventValues.f16588c == 0) {
                        int i4 = this.f16580h;
                        int i5 = scrollEventValues.f16586a;
                        if (i4 != i5) {
                            d(i5);
                        }
                    }
                }
                e(0);
                q();
            }
            if (this.f16577e == 2 && i2 == 0 && this.f16584l) {
                t();
                ScrollEventValues scrollEventValues2 = this.f16579g;
                if (scrollEventValues2.f16588c == 0) {
                    int i6 = this.f16581i;
                    int i7 = scrollEventValues2.f16586a;
                    if (i6 != i7) {
                        if (i7 == -1) {
                            i7 = 0;
                        }
                        d(i7);
                    }
                    e(0);
                    q();
                }
            }
        } else if (this.f16583k) {
            e(2);
            this.f16582j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r3.f16580h != r5) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r5 < 0) == r3.f16574b.k()) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f16583k = r4
            r3.t()
            boolean r0 = r3.f16582j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x0034
            r3.f16582j = r2
            if (r6 > 0) goto L_0x001f
            if (r6 != 0) goto L_0x0029
            if (r5 >= 0) goto L_0x0016
            r5 = 1
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f16574b
            boolean r6 = r6.k()
            if (r5 != r6) goto L_0x0029
        L_0x001f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f16579g
            int r6 = r5.f16588c
            if (r6 == 0) goto L_0x0029
            int r5 = r5.f16586a
            int r5 = r5 + r4
            goto L_0x002d
        L_0x0029:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f16579g
            int r5 = r5.f16586a
        L_0x002d:
            r3.f16581i = r5
            int r6 = r3.f16580h
            if (r6 == r5) goto L_0x0042
            goto L_0x003f
        L_0x0034:
            int r5 = r3.f16577e
            if (r5 != 0) goto L_0x0042
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f16579g
            int r5 = r5.f16586a
            if (r5 != r1) goto L_0x003f
            r5 = 0
        L_0x003f:
            r3.d(r5)
        L_0x0042:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f16579g
            int r6 = r5.f16586a
            if (r6 != r1) goto L_0x0049
            r6 = 0
        L_0x0049:
            float r0 = r5.f16587b
            int r5 = r5.f16588c
            r3.c(r6, r0, r5)
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f16579g
            int r6 = r5.f16586a
            int r0 = r3.f16581i
            if (r6 == r0) goto L_0x005a
            if (r0 != r1) goto L_0x0068
        L_0x005a:
            int r5 = r5.f16588c
            if (r5 != 0) goto L_0x0068
            int r5 = r3.f16578f
            if (r5 == r4) goto L_0x0068
            r3.e(r2)
            r3.q()
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public double g() {
        t();
        ScrollEventValues scrollEventValues = this.f16579g;
        return ((double) scrollEventValues.f16586a) + ((double) scrollEventValues.f16587b);
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f16578f;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f16578f == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.f16585m;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.f16578f == 0;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        this.f16577e = 4;
        s(true);
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f16584l = true;
    }

    /* access modifiers changed from: package-private */
    public void o() {
        if (!i() || this.f16585m) {
            this.f16585m = false;
            t();
            ScrollEventValues scrollEventValues = this.f16579g;
            if (scrollEventValues.f16588c == 0) {
                int i2 = scrollEventValues.f16586a;
                if (i2 != this.f16580h) {
                    d(i2);
                }
                e(0);
                q();
                return;
            }
            e(2);
        }
    }

    /* access modifiers changed from: package-private */
    public void p(int i2, boolean z) {
        this.f16577e = z ? 2 : 3;
        boolean z2 = false;
        this.f16585m = false;
        if (this.f16581i != i2) {
            z2 = true;
        }
        this.f16581i = i2;
        e(2);
        if (z2) {
            d(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f16573a = onPageChangeCallback;
    }
}

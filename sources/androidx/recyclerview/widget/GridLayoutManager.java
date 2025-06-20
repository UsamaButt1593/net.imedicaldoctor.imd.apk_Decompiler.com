package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean X = false;
    private static final String Y = "GridLayoutManager";
    public static final int Z = -1;
    boolean O = false;
    int P = -1;
    int[] Q;
    View[] R;
    final SparseIntArray S = new SparseIntArray();
    final SparseIntArray T = new SparseIntArray();
    SpanSizeLookup U = new DefaultSpanSizeLookup();
    final Rect V = new Rect();
    private boolean W;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int e(int i2, int i3) {
            return i2 % i3;
        }

        public int f(int i2) {
            return 1;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: g  reason: collision with root package name */
        public static final int f15356g = -1;

        /* renamed from: e  reason: collision with root package name */
        int f15357e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f15358f = 0;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public int j() {
            return this.f15357e;
        }

        public int k() {
            return this.f15358f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public static abstract class SpanSizeLookup {

        /* renamed from: a  reason: collision with root package name */
        final SparseIntArray f15359a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        final SparseIntArray f15360b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        private boolean f15361c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f15362d = false;

        static int a(SparseIntArray sparseIntArray, int i2) {
            int size = sparseIntArray.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (sparseIntArray.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i5);
        }

        /* access modifiers changed from: package-private */
        public int b(int i2, int i3) {
            if (!this.f15362d) {
                return d(i2, i3);
            }
            int i4 = this.f15360b.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int d2 = d(i2, i3);
            this.f15360b.put(i2, d2);
            return d2;
        }

        /* access modifiers changed from: package-private */
        public int c(int i2, int i3) {
            if (!this.f15361c) {
                return e(i2, i3);
            }
            int i4 = this.f15359a.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int e2 = e(i2, i3);
            this.f15359a.put(i2, e2);
            return e2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int d(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.f15362d
                r1 = 0
                if (r0 == 0) goto L_0x0025
                android.util.SparseIntArray r0 = r6.f15360b
                int r0 = a(r0, r7)
                r2 = -1
                if (r0 == r2) goto L_0x0025
                android.util.SparseIntArray r2 = r6.f15360b
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.c(r0, r8)
                int r0 = r6.f(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L_0x0028
                int r2 = r2 + 1
            L_0x0023:
                r4 = 0
                goto L_0x0028
            L_0x0025:
                r2 = 0
                r3 = 0
                goto L_0x0023
            L_0x0028:
                int r0 = r6.f(r7)
            L_0x002c:
                if (r3 >= r7) goto L_0x0041
                int r5 = r6.f(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L_0x0039
                int r2 = r2 + 1
                r4 = 0
                goto L_0x003e
            L_0x0039:
                if (r4 <= r8) goto L_0x003e
                int r2 = r2 + 1
                r4 = r5
            L_0x003e:
                int r3 = r3 + 1
                goto L_0x002c
            L_0x0041:
                int r4 = r4 + r0
                if (r4 <= r8) goto L_0x0046
                int r2 = r2 + 1
            L_0x0046:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.d(int, int):int");
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.f(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.f15361c
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.f15359a
                int r2 = a(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.f15359a
                int r3 = r3.get(r2)
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = 0
                r3 = 0
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.f(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = 0
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.e(int, int):int");
        }

        public abstract int f(int i2);

        public void g() {
            this.f15360b.clear();
        }

        public void h() {
            this.f15359a.clear();
        }

        public boolean i() {
            return this.f15362d;
        }

        public boolean j() {
            return this.f15361c;
        }

        public void k(boolean z) {
            if (!z) {
                this.f15360b.clear();
            }
            this.f15362d = z;
        }

        public void l(boolean z) {
            if (!z) {
                this.f15360b.clear();
            }
            this.f15361c = z;
        }
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        Q3(i2);
    }

    static int[] A3(int[] iArr, int i2, int i3) {
        int i4;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i3)) {
            iArr = new int[(i2 + 1)];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    private void B3() {
        this.S.clear();
        this.T.clear();
    }

    private int C3(RecyclerView.State state) {
        if (!(V() == 0 || state.d() == 0)) {
            v2();
            boolean V2 = V2();
            View A2 = A2(!V2, true);
            View z2 = z2(!V2, true);
            if (!(A2 == null || z2 == null)) {
                int b2 = this.U.b(w0(A2), this.P);
                int b3 = this.U.b(w0(z2), this.P);
                int min = Math.min(b2, b3);
                int max = this.x ? Math.max(0, ((this.U.b(state.d() - 1, this.P) + 1) - Math.max(b2, b3)) - 1) : Math.max(0, min);
                if (!V2) {
                    return max;
                }
                return Math.round((((float) max) * (((float) Math.abs(this.u.d(z2) - this.u.g(A2))) / ((float) ((this.U.b(w0(z2), this.P) - this.U.b(w0(A2), this.P)) + 1)))) + ((float) (this.u.n() - this.u.g(A2))));
            }
        }
        return 0;
    }

    private int D3(RecyclerView.State state) {
        if (!(V() == 0 || state.d() == 0)) {
            v2();
            View A2 = A2(!V2(), true);
            View z2 = z2(!V2(), true);
            if (!(A2 == null || z2 == null)) {
                if (!V2()) {
                    return this.U.b(state.d() - 1, this.P) + 1;
                }
                int d2 = this.u.d(z2) - this.u.g(A2);
                int b2 = this.U.b(w0(A2), this.P);
                return (int) ((((float) d2) / ((float) ((this.U.b(w0(z2), this.P) - b2) + 1))) * ((float) (this.U.b(state.d() - 1, this.P) + 1)));
            }
        }
        return 0;
    }

    private void E3(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i2) {
        boolean z = i2 == 1;
        int J3 = J3(recycler, state, anchorInfo.f15405b);
        if (z) {
            while (J3 > 0) {
                int i3 = anchorInfo.f15405b;
                if (i3 > 0) {
                    int i4 = i3 - 1;
                    anchorInfo.f15405b = i4;
                    J3 = J3(recycler, state, i4);
                } else {
                    return;
                }
            }
            return;
        }
        int d2 = state.d() - 1;
        int i5 = anchorInfo.f15405b;
        while (i5 < d2) {
            int i6 = i5 + 1;
            int J32 = J3(recycler, state, i6);
            if (J32 <= J3) {
                break;
            }
            i5 = i6;
            J3 = J32;
        }
        anchorInfo.f15405b = i5;
    }

    private void F3() {
        View[] viewArr = this.R;
        if (viewArr == null || viewArr.length != this.P) {
            this.R = new View[this.P];
        }
    }

    private int I3(RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.j()) {
            return this.U.b(i2, this.P);
        }
        int g2 = recycler.g(i2);
        if (g2 != -1) {
            return this.U.b(g2, this.P);
        }
        Log.w(Y, "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    private int J3(RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.j()) {
            return this.U.c(i2, this.P);
        }
        int i3 = this.T.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int g2 = recycler.g(i2);
        if (g2 != -1) {
            return this.U.c(g2, this.P);
        }
        Log.w(Y, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    private int K3(RecyclerView.Recycler recycler, RecyclerView.State state, int i2) {
        if (!state.j()) {
            return this.U.f(i2);
        }
        int i3 = this.S.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int g2 = recycler.g(i2);
        if (g2 != -1) {
            return this.U.f(g2);
        }
        Log.w(Y, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    private void M3(float f2, int i2) {
        z3(Math.max(Math.round(f2 * ((float) this.P)), i2));
    }

    private void O3(View view, int i2, boolean z) {
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f15535b;
        int i5 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i6 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int G3 = G3(layoutParams.f15357e, layoutParams.f15358f);
        if (this.s == 1) {
            i3 = RecyclerView.LayoutManager.W(G3, i2, i6, layoutParams.width, false);
            i4 = RecyclerView.LayoutManager.W(this.u.o(), k0(), i5, layoutParams.height, true);
        } else {
            int W2 = RecyclerView.LayoutManager.W(G3, i2, i5, layoutParams.height, false);
            int W3 = RecyclerView.LayoutManager.W(this.u.o(), E0(), i6, layoutParams.width, true);
            i4 = W2;
            i3 = W3;
        }
        P3(view, i3, i4, z);
    }

    private void P3(View view, int i2, int i3, boolean z) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z ? i2(view, i2, i3, layoutParams) : g2(view, i2, i3, layoutParams)) {
            view.measure(i2, i3);
        }
    }

    private void T3() {
        int j0;
        int v0;
        if (Q2() == 1) {
            j0 = D0() - t0();
            v0 = s0();
        } else {
            j0 = j0() - q0();
            v0 = v0();
        }
        z3(j0 - v0);
    }

    private void x3(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (z) {
            i3 = i2;
            i4 = 0;
            i5 = 1;
        } else {
            i4 = i2 - 1;
            i3 = -1;
            i5 = -1;
        }
        while (i4 != i3) {
            View view = this.R[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int K3 = K3(recycler, state, w0(view));
            layoutParams.f15358f = K3;
            layoutParams.f15357e = i6;
            i6 += K3;
            i4 += i5;
        }
    }

    private void y3() {
        int V2 = V();
        for (int i2 = 0; i2 < V2; i2++) {
            LayoutParams layoutParams = (LayoutParams) U(i2).getLayoutParams();
            int d2 = layoutParams.d();
            this.S.put(d2, layoutParams.k());
            this.T.put(d2, layoutParams.j());
        }
    }

    private void z3(int i2) {
        this.Q = A3(this.Q, this.P, i2);
    }

    public int A(RecyclerView.State state) {
        return this.W ? D3(state) : super.A(state);
    }

    public int C(RecyclerView.State state) {
        return this.W ? C3(state) : super.C(state);
    }

    public int D(RecyclerView.State state) {
        return this.W ? D3(state) : super.D(state);
    }

    /* access modifiers changed from: package-private */
    public int G3(int i2, int i3) {
        if (this.s != 1 || !U2()) {
            int[] iArr = this.Q;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.Q;
        int i4 = this.P;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    public int H3() {
        return this.P;
    }

    /* access modifiers changed from: package-private */
    public View J2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i2;
        int i3;
        int V2 = V();
        int i4 = 1;
        if (z2) {
            i3 = V() - 1;
            i2 = -1;
            i4 = -1;
        } else {
            i2 = V2;
            i3 = 0;
        }
        int d2 = state.d();
        v2();
        int n2 = this.u.n();
        int i5 = this.u.i();
        View view = null;
        View view2 = null;
        while (i3 != i2) {
            View U2 = U(i3);
            int w0 = w0(U2);
            if (w0 >= 0 && w0 < d2 && J3(recycler, state, w0) == 0) {
                if (((RecyclerView.LayoutParams) U2.getLayoutParams()).g()) {
                    if (view2 == null) {
                        view2 = U2;
                    }
                } else if (this.u.g(U2) < i5 && this.u.d(U2) >= n2) {
                    return U2;
                } else {
                    if (view == null) {
                        view = U2;
                    }
                }
            }
            i3 += i4;
        }
        return view != null ? view : view2;
    }

    public SpanSizeLookup L3() {
        return this.U;
    }

    public boolean N3() {
        return this.W;
    }

    public RecyclerView.LayoutParams P() {
        return this.s == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams Q(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public void Q3(int i2) {
        if (i2 != this.P) {
            this.O = true;
            if (i2 >= 1) {
                this.P = i2;
                this.U.h();
                R1();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    public RecyclerView.LayoutParams R(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void R3(SpanSizeLookup spanSizeLookup) {
        this.U = spanSizeLookup;
    }

    public void S3(boolean z) {
        this.W = z;
    }

    public int U1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        T3();
        F3();
        return super.U1(i2, recycler, state);
    }

    public int W1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        T3();
        F3();
        return super.W1(i2, recycler, state);
    }

    /* access modifiers changed from: package-private */
    public void W2(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        View e2;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        LinearLayoutManager.LayoutState layoutState2 = layoutState;
        LinearLayoutManager.LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int m2 = this.u.m();
        boolean z = m2 != 1073741824;
        int i15 = V() > 0 ? this.Q[this.P] : 0;
        if (z) {
            T3();
        }
        boolean z2 = layoutState2.f15418e == 1;
        int i16 = this.P;
        if (!z2) {
            i16 = J3(recycler2, state2, layoutState2.f15417d) + K3(recycler2, state2, layoutState2.f15417d);
        }
        int i17 = 0;
        while (i17 < this.P && layoutState2.c(state2) && i16 > 0) {
            int i18 = layoutState2.f15417d;
            int K3 = K3(recycler2, state2, i18);
            if (K3 <= this.P) {
                i16 -= K3;
                if (i16 < 0 || (e2 = layoutState2.e(recycler2)) == null) {
                    break;
                }
                this.R[i17] = e2;
                i17++;
            } else {
                throw new IllegalArgumentException("Item at position " + i18 + " requires " + K3 + " spans but GridLayoutManager has only " + this.P + " spans.");
            }
        }
        if (i17 == 0) {
            layoutChunkResult2.f15410b = true;
            return;
        }
        x3(recycler2, state2, i17, z2);
        float f2 = 0.0f;
        int i19 = 0;
        for (int i20 = 0; i20 < i17; i20++) {
            View view = this.R[i20];
            if (layoutState2.f15425l == null) {
                if (z2) {
                    j(view);
                } else {
                    k(view, 0);
                }
            } else if (z2) {
                h(view);
            } else {
                i(view, 0);
            }
            r(view, this.V);
            O3(view, m2, false);
            int e3 = this.u.e(view);
            if (e3 > i19) {
                i19 = e3;
            }
            float f3 = (((float) this.u.f(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).f15358f);
            if (f3 > f2) {
                f2 = f3;
            }
        }
        if (z) {
            M3(f2, i15);
            i19 = 0;
            for (int i21 = 0; i21 < i17; i21++) {
                View view2 = this.R[i21];
                O3(view2, 1073741824, true);
                int e4 = this.u.e(view2);
                if (e4 > i19) {
                    i19 = e4;
                }
            }
        }
        for (int i22 = 0; i22 < i17; i22++) {
            View view3 = this.R[i22];
            if (this.u.e(view3) != i19) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f15535b;
                int i23 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i24 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int G3 = G3(layoutParams.f15357e, layoutParams.f15358f);
                if (this.s == 1) {
                    i14 = RecyclerView.LayoutManager.W(G3, 1073741824, i24, layoutParams.width, false);
                    i13 = View.MeasureSpec.makeMeasureSpec(i19 - i23, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19 - i24, 1073741824);
                    i13 = RecyclerView.LayoutManager.W(G3, 1073741824, i23, layoutParams.height, false);
                    i14 = makeMeasureSpec;
                }
                P3(view3, i14, i13, true);
            }
        }
        layoutChunkResult2.f15409a = i19;
        if (this.s == 1) {
            if (layoutState2.f15419f == -1) {
                i5 = layoutState2.f15415b;
                i12 = i5 - i19;
            } else {
                i12 = layoutState2.f15415b;
                i5 = i12 + i19;
            }
            i2 = i12;
            i4 = 0;
            i3 = 0;
        } else {
            if (layoutState2.f15419f == -1) {
                i11 = layoutState2.f15415b;
                i10 = i11 - i19;
            } else {
                i10 = layoutState2.f15415b;
                i11 = i10 + i19;
            }
            i3 = i10;
            i2 = 0;
            i4 = i11;
            i5 = 0;
        }
        int i25 = 0;
        while (i25 < i17) {
            View view4 = this.R[i25];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.s == 1) {
                if (U2()) {
                    int s0 = s0() + this.Q[this.P - layoutParams2.f15357e];
                    i9 = i5;
                    i8 = s0;
                    i7 = s0 - this.u.f(view4);
                } else {
                    int s02 = s0() + this.Q[layoutParams2.f15357e];
                    i9 = i5;
                    i7 = s02;
                    i8 = this.u.f(view4) + s02;
                }
                i6 = i2;
            } else {
                int v0 = v0() + this.Q[layoutParams2.f15357e];
                i6 = v0;
                i8 = i4;
                i7 = i3;
                i9 = this.u.f(view4) + v0;
            }
            T0(view4, i7, i6, i8, i9);
            if (layoutParams2.g() || layoutParams2.f()) {
                layoutChunkResult2.f15411c = true;
            }
            layoutChunkResult2.f15412d |= view4.hasFocusable();
            i25++;
            i5 = i9;
            i4 = i8;
            i3 = i7;
            i2 = i6;
        }
        Arrays.fill(this.R, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public void Z2(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i2) {
        super.Z2(recycler, state, anchorInfo, i2);
        T3();
        if (state.d() > 0 && !state.j()) {
            E3(recycler, state, anchorInfo, i2);
        }
        F3();
    }

    public int a0(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 1) {
            return this.P;
        }
        if (state.d() < 1) {
            return 0;
        }
        return I3(recycler, state, state.d() - 1) + 1;
    }

    public void c2(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        if (this.Q == null) {
            super.c2(rect, i2, i3);
        }
        int s0 = s0() + t0();
        int v0 = v0() + q0();
        if (this.s == 1) {
            i5 = RecyclerView.LayoutManager.v(i3, rect.height() + v0, o0());
            int[] iArr = this.Q;
            i4 = RecyclerView.LayoutManager.v(i2, iArr[iArr.length - 1] + s0, p0());
        } else {
            i4 = RecyclerView.LayoutManager.v(i2, rect.width() + s0, p0());
            int[] iArr2 = this.Q;
            i5 = RecyclerView.LayoutManager.v(i3, iArr2[iArr2.length - 1] + v0, o0());
        }
        b2(i4, i5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d1, code lost:
        if (r13 == (r2 > r15)) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f1, code lost:
        if (r13 == r10) goto L_0x00f3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View e1(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.N(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.f15357e
            int r5 = r5.f15358f
            int r5 = r5 + r6
            android.view.View r7 = super.e1(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.t2(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = 1
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.x
            r11 = -1
            if (r7 == r10) goto L_0x0039
            int r7 = r23.V()
            int r7 = r7 - r9
            r10 = -1
            r12 = -1
            goto L_0x0040
        L_0x0039:
            int r7 = r23.V()
            r10 = r7
            r7 = 0
            r12 = 1
        L_0x0040:
            int r13 = r0.s
            if (r13 != r9) goto L_0x004c
            boolean r13 = r23.U2()
            if (r13 == 0) goto L_0x004c
            r13 = 1
            goto L_0x004d
        L_0x004c:
            r13 = 0
        L_0x004d:
            int r14 = r0.I3(r1, r2, r7)
            r11 = r7
            r8 = 0
            r15 = -1
            r16 = -1
            r17 = 0
            r7 = r4
        L_0x0059:
            if (r11 == r10) goto L_0x0065
            int r9 = r0.I3(r1, r2, r11)
            android.view.View r1 = r0.U(r11)
            if (r1 != r3) goto L_0x0069
        L_0x0065:
            r21 = r7
            goto L_0x0137
        L_0x0069:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0082
            if (r9 == r14) goto L_0x0082
            if (r4 == 0) goto L_0x0074
            goto L_0x0065
        L_0x0074:
            r18 = r3
            r21 = r7
        L_0x0078:
            r19 = r8
            r20 = r10
        L_0x007c:
            r7 = r16
            r8 = r17
            goto L_0x0123
        L_0x0082:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.f15357e
            r18 = r3
            int r3 = r9.f15358f
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009a
            if (r2 != r6) goto L_0x009a
            if (r3 != r5) goto L_0x009a
            return r1
        L_0x009a:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a2
            if (r4 == 0) goto L_0x00aa
        L_0x00a2:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00b5
            if (r7 != 0) goto L_0x00b5
        L_0x00aa:
            r21 = r7
        L_0x00ac:
            r19 = r8
            r20 = r10
            r7 = r16
            r8 = r17
            goto L_0x00f3
        L_0x00b5:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d4
            if (r7 <= r8) goto L_0x00ca
        L_0x00c9:
            goto L_0x00ac
        L_0x00ca:
            if (r7 != r8) goto L_0x0078
            if (r2 <= r15) goto L_0x00d0
            r7 = 1
            goto L_0x00d1
        L_0x00d0:
            r7 = 0
        L_0x00d1:
            if (r13 != r7) goto L_0x0078
            goto L_0x00c9
        L_0x00d4:
            if (r4 != 0) goto L_0x0078
            r19 = r8
            r20 = r10
            r8 = 0
            r10 = 1
            boolean r22 = r0.R0(r1, r8, r10)
            if (r22 == 0) goto L_0x007c
            r8 = r17
            if (r7 <= r8) goto L_0x00e9
            r7 = r16
            goto L_0x00f3
        L_0x00e9:
            if (r7 != r8) goto L_0x0121
            r7 = r16
            if (r2 <= r7) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r10 = 0
        L_0x00f1:
            if (r13 != r10) goto L_0x0123
        L_0x00f3:
            boolean r10 = r1.hasFocusable()
            if (r10 == 0) goto L_0x010f
            int r4 = r9.f15357e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x012b
        L_0x010f:
            int r7 = r9.f15357e
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x012b
        L_0x0121:
            r7 = r16
        L_0x0123:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x012b:
            int r11 = r11 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r10 = r20
            r9 = 1
            goto L_0x0059
        L_0x0137:
            if (r4 == 0) goto L_0x013a
            goto L_0x013c
        L_0x013a:
            r4 = r21
        L_0x013c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.e1(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public void i1(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.i1(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.j1(GridView.class.getName());
    }

    public void k1(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int j2;
        int k2;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.j1(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int I3 = I3(recycler, state, layoutParams2.d());
        if (this.s == 0) {
            i3 = layoutParams2.j();
            i2 = layoutParams2.k();
            z = false;
            z2 = false;
            k2 = 1;
            j2 = I3;
        } else {
            j2 = layoutParams2.j();
            k2 = layoutParams2.k();
            z = false;
            z2 = false;
            i2 = 1;
            i3 = I3;
        }
        accessibilityNodeInfoCompat.m1(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.j(i3, i2, j2, k2, z, z2));
    }

    public void m1(RecyclerView recyclerView, int i2, int i3) {
        this.U.h();
        this.U.g();
    }

    public void n1(RecyclerView recyclerView) {
        this.U.h();
        this.U.g();
    }

    public boolean n2() {
        return this.D == null && !this.O;
    }

    public void n3(boolean z) {
        if (!z) {
            super.n3(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void o1(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.U.h();
        this.U.g();
    }

    public void p1(RecyclerView recyclerView, int i2, int i3) {
        this.U.h();
        this.U.g();
    }

    /* access modifiers changed from: package-private */
    public void p2(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2 = this.P;
        for (int i3 = 0; i3 < this.P && layoutState.c(state) && i2 > 0; i3++) {
            int i4 = layoutState.f15417d;
            layoutPrefetchRegistry.a(i4, Math.max(0, layoutState.f15420g));
            i2 -= this.U.f(i4);
            layoutState.f15417d += layoutState.f15418e;
        }
    }

    public void r1(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.U.h();
        this.U.g();
    }

    public void s1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.j()) {
            y3();
        }
        super.s1(recycler, state);
        B3();
    }

    public void t1(RecyclerView.State state) {
        super.t1(state);
        this.O = false;
    }

    public boolean u(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int z(RecyclerView.State state) {
        return this.W ? C3(state) : super.z(state);
    }

    public int z0(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 0) {
            return this.P;
        }
        if (state.d() < 1) {
            return 0;
        }
        return I3(recycler, state, state.d() - 1) + 1;
    }

    public GridLayoutManager(Context context, int i2, int i3, boolean z) {
        super(context, i3, z);
        Q3(i2);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Q3(RecyclerView.LayoutManager.x0(context, attributeSet, i2, i3).f15531b);
    }
}

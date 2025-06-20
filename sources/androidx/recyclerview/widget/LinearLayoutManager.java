package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    private static final String I = "LinearLayoutManager";
    static final boolean J = false;
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = Integer.MIN_VALUE;
    private static final float N = 0.33333334f;
    int A;
    int B;
    private boolean C;
    SavedState D;
    final AnchorInfo E;
    private final LayoutChunkResult F;
    private int G;
    private int[] H;
    int s;
    private LayoutState t;
    OrientationHelper u;
    private boolean v;
    private boolean w;
    boolean x;
    private boolean y;
    private boolean z;

    static class AnchorInfo {

        /* renamed from: a  reason: collision with root package name */
        OrientationHelper f15404a;

        /* renamed from: b  reason: collision with root package name */
        int f15405b;

        /* renamed from: c  reason: collision with root package name */
        int f15406c;

        /* renamed from: d  reason: collision with root package name */
        boolean f15407d;

        /* renamed from: e  reason: collision with root package name */
        boolean f15408e;

        AnchorInfo() {
            e();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f15406c = this.f15407d ? this.f15404a.i() : this.f15404a.n();
        }

        public void b(View view, int i2) {
            this.f15406c = this.f15407d ? this.f15404a.d(view) + this.f15404a.p() : this.f15404a.g(view);
            this.f15405b = i2;
        }

        public void c(View view, int i2) {
            int p = this.f15404a.p();
            if (p >= 0) {
                b(view, i2);
                return;
            }
            this.f15405b = i2;
            if (this.f15407d) {
                int i3 = (this.f15404a.i() - p) - this.f15404a.d(view);
                this.f15406c = this.f15404a.i() - i3;
                if (i3 > 0) {
                    int e2 = this.f15406c - this.f15404a.e(view);
                    int n2 = this.f15404a.n();
                    int min = e2 - (n2 + Math.min(this.f15404a.g(view) - n2, 0));
                    if (min < 0) {
                        this.f15406c += Math.min(i3, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g2 = this.f15404a.g(view);
            int n3 = g2 - this.f15404a.n();
            this.f15406c = g2;
            if (n3 > 0) {
                int i4 = (this.f15404a.i() - Math.min(0, (this.f15404a.i() - p) - this.f15404a.d(view))) - (g2 + this.f15404a.e(view));
                if (i4 < 0) {
                    this.f15406c -= Math.min(n3, -i4);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.g() && layoutParams.d() >= 0 && layoutParams.d() < state.d();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f15405b = -1;
            this.f15406c = Integer.MIN_VALUE;
            this.f15407d = false;
            this.f15408e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f15405b + ", mCoordinate=" + this.f15406c + ", mLayoutFromEnd=" + this.f15407d + ", mValid=" + this.f15408e + ASCIIPropertyListParser.f18653k;
        }
    }

    protected static class LayoutChunkResult {

        /* renamed from: a  reason: collision with root package name */
        public int f15409a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15410b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f15411c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15412d;

        protected LayoutChunkResult() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f15409a = 0;
            this.f15410b = false;
            this.f15411c = false;
            this.f15412d = false;
        }
    }

    static class LayoutState {

        /* renamed from: n  reason: collision with root package name */
        static final String f15413n = "LLM#LayoutState";
        static final int o = -1;
        static final int p = 1;
        static final int q = Integer.MIN_VALUE;
        static final int r = -1;
        static final int s = 1;
        static final int t = Integer.MIN_VALUE;

        /* renamed from: a  reason: collision with root package name */
        boolean f15414a = true;

        /* renamed from: b  reason: collision with root package name */
        int f15415b;

        /* renamed from: c  reason: collision with root package name */
        int f15416c;

        /* renamed from: d  reason: collision with root package name */
        int f15417d;

        /* renamed from: e  reason: collision with root package name */
        int f15418e;

        /* renamed from: f  reason: collision with root package name */
        int f15419f;

        /* renamed from: g  reason: collision with root package name */
        int f15420g;

        /* renamed from: h  reason: collision with root package name */
        int f15421h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f15422i = 0;

        /* renamed from: j  reason: collision with root package name */
        boolean f15423j = false;

        /* renamed from: k  reason: collision with root package name */
        int f15424k;

        /* renamed from: l  reason: collision with root package name */
        List<RecyclerView.ViewHolder> f15425l = null;

        /* renamed from: m  reason: collision with root package name */
        boolean f15426m;

        LayoutState() {
        }

        private View f() {
            int size = this.f15425l.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.f15425l.get(i2).f15587a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.g() && this.f15417d == layoutParams.d()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b((View) null);
        }

        public void b(View view) {
            View g2 = g(view);
            this.f15417d = g2 == null ? -1 : ((RecyclerView.LayoutParams) g2.getLayoutParams()).d();
        }

        /* access modifiers changed from: package-private */
        public boolean c(RecyclerView.State state) {
            int i2 = this.f15417d;
            return i2 >= 0 && i2 < state.d();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            Log.d(f15413n, "avail:" + this.f15416c + ", ind:" + this.f15417d + ", dir:" + this.f15418e + ", offset:" + this.f15415b + ", layoutDir:" + this.f15419f);
        }

        /* access modifiers changed from: package-private */
        public View e(RecyclerView.Recycler recycler) {
            if (this.f15425l != null) {
                return f();
            }
            View p2 = recycler.p(this.f15417d);
            this.f15417d += this.f15418e;
            return p2;
        }

        public View g(View view) {
            int d2;
            int size = this.f15425l.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.f15425l.get(i3).f15587a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.g() && (d2 = (layoutParams.d() - this.f15417d) * this.f15418e) >= 0 && d2 < i2) {
                    view2 = view3;
                    if (d2 == 0) {
                        break;
                    }
                    i2 = d2;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        int X;
        boolean Y;
        int s;

        public SavedState() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.s >= 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.s = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.s);
            parcel.writeInt(this.X);
            parcel.writeInt(this.Y ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.s = parcel.readInt();
            this.X = parcel.readInt();
            this.Y = parcel.readInt() != 1 ? false : true;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.s = savedState.s;
            this.X = savedState.X;
            this.Y = savedState.Y;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context) {
        this(context, 1, false);
    }

    private View D2() {
        return F2(V() - 1, -1);
    }

    private View H2() {
        return this.x ? y2() : D2();
    }

    private View I2() {
        return this.x ? D2() : y2();
    }

    private int K2(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int i3;
        int i4 = this.u.i() - i2;
        if (i4 <= 0) {
            return 0;
        }
        int i5 = -g3(-i4, recycler, state);
        int i6 = i2 + i5;
        if (!z2 || (i3 = this.u.i() - i6) <= 0) {
            return i5;
        }
        this.u.t(i3);
        return i3 + i5;
    }

    private int L2(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int n2;
        int n3 = i2 - this.u.n();
        if (n3 <= 0) {
            return 0;
        }
        int i3 = -g3(n3, recycler, state);
        int i4 = i2 + i3;
        if (!z2 || (n2 = i4 - this.u.n()) <= 0) {
            return i3;
        }
        this.u.t(-n2);
        return i3 - n2;
    }

    private View M2() {
        return U(this.x ? 0 : V() - 1);
    }

    private View N2() {
        return U(this.x ? V() - 1 : 0);
    }

    private void X2(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3) {
        if (state.n() && V() != 0 && !state.j() && n2()) {
            List<RecyclerView.ViewHolder> l2 = recycler.l();
            int size = l2.size();
            int w0 = w0(U(0));
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView.ViewHolder viewHolder = l2.get(i6);
                if (!viewHolder.Q()) {
                    if ((viewHolder.G() < w0) != this.x) {
                        i4 += this.u.e(viewHolder.f15587a);
                    } else {
                        i5 += this.u.e(viewHolder.f15587a);
                    }
                }
            }
            this.t.f15425l = l2;
            if (i4 > 0) {
                u3(w0(N2()), i2);
                LayoutState layoutState = this.t;
                layoutState.f15421h = i4;
                layoutState.f15416c = 0;
                layoutState.a();
                w2(recycler, this.t, state, false);
            }
            if (i5 > 0) {
                s3(w0(M2()), i3);
                LayoutState layoutState2 = this.t;
                layoutState2.f15421h = i5;
                layoutState2.f15416c = 0;
                layoutState2.a();
                w2(recycler, this.t, state, false);
            }
            this.t.f15425l = null;
        }
    }

    private void Y2() {
        Log.d(I, "internal representation of views on the screen");
        for (int i2 = 0; i2 < V(); i2++) {
            View U = U(i2);
            Log.d(I, "item " + w0(U) + ", coord:" + this.u.g(U));
        }
        Log.d(I, "==============");
    }

    private void a3(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.f15414a && !layoutState.f15426m) {
            int i2 = layoutState.f15420g;
            int i3 = layoutState.f15422i;
            if (layoutState.f15419f == -1) {
                c3(recycler, i2, i3);
            } else {
                d3(recycler, i2, i3);
            }
        }
    }

    private void b3(RecyclerView.Recycler recycler, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    K1(i4, recycler);
                }
                return;
            }
            while (i2 > i3) {
                K1(i2, recycler);
                i2--;
            }
        }
    }

    private void c3(RecyclerView.Recycler recycler, int i2, int i3) {
        int V = V();
        if (i2 >= 0) {
            int h2 = (this.u.h() - i2) + i3;
            if (this.x) {
                for (int i4 = 0; i4 < V; i4++) {
                    View U = U(i4);
                    if (this.u.g(U) < h2 || this.u.r(U) < h2) {
                        b3(recycler, 0, i4);
                        return;
                    }
                }
                return;
            }
            int i5 = V - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                View U2 = U(i6);
                if (this.u.g(U2) < h2 || this.u.r(U2) < h2) {
                    b3(recycler, i5, i6);
                    return;
                }
            }
        }
    }

    private void d3(RecyclerView.Recycler recycler, int i2, int i3) {
        if (i2 >= 0) {
            int i4 = i2 - i3;
            int V = V();
            if (this.x) {
                int i5 = V - 1;
                for (int i6 = i5; i6 >= 0; i6--) {
                    View U = U(i6);
                    if (this.u.d(U) > i4 || this.u.q(U) > i4) {
                        b3(recycler, i5, i6);
                        return;
                    }
                }
                return;
            }
            for (int i7 = 0; i7 < V; i7++) {
                View U2 = U(i7);
                if (this.u.d(U2) > i4 || this.u.q(U2) > i4) {
                    b3(recycler, 0, i7);
                    return;
                }
            }
        }
    }

    private void f3() {
        this.x = (this.s == 1 || !U2()) ? this.w : !this.w;
    }

    private boolean o3(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View J2;
        boolean z2 = false;
        if (V() == 0) {
            return false;
        }
        View i0 = i0();
        if (i0 == null || !anchorInfo.d(i0, state)) {
            boolean z3 = this.v;
            boolean z4 = this.y;
            if (z3 != z4 || (J2 = J2(recycler, state, anchorInfo.f15407d, z4)) == null) {
                return false;
            }
            anchorInfo.b(J2, w0(J2));
            if (!state.j() && n2()) {
                int g2 = this.u.g(J2);
                int d2 = this.u.d(J2);
                int n2 = this.u.n();
                int i2 = this.u.i();
                boolean z5 = d2 <= n2 && g2 < n2;
                if (g2 >= i2 && d2 > i2) {
                    z2 = true;
                }
                if (z5 || z2) {
                    if (anchorInfo.f15407d) {
                        n2 = i2;
                    }
                    anchorInfo.f15406c = n2;
                }
            }
            return true;
        }
        anchorInfo.c(i0, w0(i0));
        return true;
    }

    private boolean p3(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i2;
        boolean z2 = false;
        if (!state.j() && (i2 = this.A) != -1) {
            if (i2 < 0 || i2 >= state.d()) {
                this.A = -1;
                this.B = Integer.MIN_VALUE;
            } else {
                anchorInfo.f15405b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z3 = this.D.Y;
                    anchorInfo.f15407d = z3;
                    anchorInfo.f15406c = z3 ? this.u.i() - this.D.X : this.u.n() + this.D.X;
                    return true;
                } else if (this.B == Integer.MIN_VALUE) {
                    View O = O(this.A);
                    if (O == null) {
                        if (V() > 0) {
                            if ((this.A < w0(U(0))) == this.x) {
                                z2 = true;
                            }
                            anchorInfo.f15407d = z2;
                        }
                        anchorInfo.a();
                    } else if (this.u.e(O) > this.u.o()) {
                        anchorInfo.a();
                        return true;
                    } else if (this.u.g(O) - this.u.n() < 0) {
                        anchorInfo.f15406c = this.u.n();
                        anchorInfo.f15407d = false;
                        return true;
                    } else if (this.u.i() - this.u.d(O) < 0) {
                        anchorInfo.f15406c = this.u.i();
                        anchorInfo.f15407d = true;
                        return true;
                    } else {
                        anchorInfo.f15406c = anchorInfo.f15407d ? this.u.d(O) + this.u.p() : this.u.g(O);
                    }
                    return true;
                } else {
                    boolean z4 = this.x;
                    anchorInfo.f15407d = z4;
                    anchorInfo.f15406c = z4 ? this.u.i() - this.B : this.u.n() + this.B;
                    return true;
                }
            }
        }
        return false;
    }

    private int q2(RecyclerView.State state) {
        if (V() == 0) {
            return 0;
        }
        v2();
        OrientationHelper orientationHelper = this.u;
        View A2 = A2(!this.z, true);
        return ScrollbarHelper.a(state, orientationHelper, A2, z2(!this.z, true), this, this.z);
    }

    private void q3(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!p3(state, anchorInfo) && !o3(recycler, state, anchorInfo)) {
            anchorInfo.a();
            anchorInfo.f15405b = this.y ? state.d() - 1 : 0;
        }
    }

    private int r2(RecyclerView.State state) {
        if (V() == 0) {
            return 0;
        }
        v2();
        OrientationHelper orientationHelper = this.u;
        View A2 = A2(!this.z, true);
        return ScrollbarHelper.b(state, orientationHelper, A2, z2(!this.z, true), this, this.z, this.x);
    }

    private void r3(int i2, int i3, boolean z2, RecyclerView.State state) {
        int i4;
        this.t.f15426m = e3();
        this.t.f15419f = i2;
        int[] iArr = this.H;
        boolean z3 = false;
        iArr[0] = 0;
        int i5 = 1;
        iArr[1] = 0;
        o2(state, iArr);
        int max = Math.max(0, this.H[0]);
        int max2 = Math.max(0, this.H[1]);
        if (i2 == 1) {
            z3 = true;
        }
        LayoutState layoutState = this.t;
        int i6 = z3 ? max2 : max;
        layoutState.f15421h = i6;
        if (!z3) {
            max = max2;
        }
        layoutState.f15422i = max;
        if (z3) {
            layoutState.f15421h = i6 + this.u.j();
            View M2 = M2();
            LayoutState layoutState2 = this.t;
            if (this.x) {
                i5 = -1;
            }
            layoutState2.f15418e = i5;
            int w0 = w0(M2);
            LayoutState layoutState3 = this.t;
            layoutState2.f15417d = w0 + layoutState3.f15418e;
            layoutState3.f15415b = this.u.d(M2);
            i4 = this.u.d(M2) - this.u.i();
        } else {
            View N2 = N2();
            this.t.f15421h += this.u.n();
            LayoutState layoutState4 = this.t;
            if (!this.x) {
                i5 = -1;
            }
            layoutState4.f15418e = i5;
            int w02 = w0(N2);
            LayoutState layoutState5 = this.t;
            layoutState4.f15417d = w02 + layoutState5.f15418e;
            layoutState5.f15415b = this.u.g(N2);
            i4 = (-this.u.g(N2)) + this.u.n();
        }
        LayoutState layoutState6 = this.t;
        layoutState6.f15416c = i3;
        if (z2) {
            layoutState6.f15416c = i3 - i4;
        }
        layoutState6.f15420g = i4;
    }

    private int s2(RecyclerView.State state) {
        if (V() == 0) {
            return 0;
        }
        v2();
        OrientationHelper orientationHelper = this.u;
        View A2 = A2(!this.z, true);
        return ScrollbarHelper.c(state, orientationHelper, A2, z2(!this.z, true), this, this.z);
    }

    private void s3(int i2, int i3) {
        this.t.f15416c = this.u.i() - i3;
        LayoutState layoutState = this.t;
        layoutState.f15418e = this.x ? -1 : 1;
        layoutState.f15417d = i2;
        layoutState.f15419f = 1;
        layoutState.f15415b = i3;
        layoutState.f15420g = Integer.MIN_VALUE;
    }

    private void t3(AnchorInfo anchorInfo) {
        s3(anchorInfo.f15405b, anchorInfo.f15406c);
    }

    private void u3(int i2, int i3) {
        this.t.f15416c = i3 - this.u.n();
        LayoutState layoutState = this.t;
        layoutState.f15417d = i2;
        layoutState.f15418e = this.x ? 1 : -1;
        layoutState.f15419f = -1;
        layoutState.f15415b = i3;
        layoutState.f15420g = Integer.MIN_VALUE;
    }

    private void v3(AnchorInfo anchorInfo) {
        u3(anchorInfo.f15405b, anchorInfo.f15406c);
    }

    private View y2() {
        return F2(0, V());
    }

    @SuppressLint({"UnknownNullness"})
    public int A(RecyclerView.State state) {
        return s2(state);
    }

    /* access modifiers changed from: package-private */
    public View A2(boolean z2, boolean z3) {
        int i2;
        int V;
        if (this.x) {
            i2 = V() - 1;
            V = -1;
        } else {
            i2 = 0;
            V = V();
        }
        return G2(i2, V, z2, z3);
    }

    @SuppressLint({"UnknownNullness"})
    public int B(RecyclerView.State state) {
        return q2(state);
    }

    public int B2() {
        View G2 = G2(0, V(), false, true);
        if (G2 == null) {
            return -1;
        }
        return w0(G2);
    }

    @SuppressLint({"UnknownNullness"})
    public int C(RecyclerView.State state) {
        return r2(state);
    }

    public int C2() {
        View G2 = G2(V() - 1, -1, true, false);
        if (G2 == null) {
            return -1;
        }
        return w0(G2);
    }

    @SuppressLint({"UnknownNullness"})
    public int D(RecyclerView.State state) {
        return s2(state);
    }

    public int E2() {
        View G2 = G2(V() - 1, -1, false, true);
        if (G2 == null) {
            return -1;
        }
        return w0(G2);
    }

    /* access modifiers changed from: package-private */
    public View F2(int i2, int i3) {
        int i4;
        int i5;
        v2();
        if (i3 <= i2 && i3 >= i2) {
            return U(i2);
        }
        if (this.u.g(U(i2)) < this.u.n()) {
            i5 = 16644;
            i4 = 16388;
        } else {
            i5 = 4161;
            i4 = FragmentTransaction.I;
        }
        return (this.s == 0 ? this.f15518e : this.f15519f).a(i2, i3, i5, i4);
    }

    /* access modifiers changed from: package-private */
    public View G2(int i2, int i3, boolean z2, boolean z3) {
        v2();
        int i4 = TIFFConstants.o1;
        int i5 = z2 ? 24579 : TIFFConstants.o1;
        if (!z3) {
            i4 = 0;
        }
        return (this.s == 0 ? this.f15518e : this.f15519f).a(i2, i3, i5, i4);
    }

    public boolean J0() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public View J2(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        v2();
        int V = V();
        if (z3) {
            i4 = V() - 1;
            i3 = -1;
            i2 = -1;
        } else {
            i3 = V;
            i4 = 0;
            i2 = 1;
        }
        int d2 = state.d();
        int n2 = this.u.n();
        int i5 = this.u.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i4 != i3) {
            View U = U(i4);
            int w0 = w0(U);
            int g2 = this.u.g(U);
            int d3 = this.u.d(U);
            if (w0 >= 0 && w0 < d2) {
                if (!((RecyclerView.LayoutParams) U.getLayoutParams()).g()) {
                    boolean z4 = d3 <= n2 && g2 < n2;
                    boolean z5 = g2 >= i5 && d3 > i5;
                    if (!z4 && !z5) {
                        return U;
                    }
                    if (z2) {
                        if (!z5) {
                            if (view != null) {
                            }
                            view = U;
                        }
                    } else if (!z4) {
                        if (view != null) {
                        }
                        view = U;
                    }
                    view2 = U;
                } else if (view3 == null) {
                    view3 = U;
                }
            }
            i4 += i2;
        }
        if (view != null) {
            return view;
        }
        return view2 != null ? view2 : view3;
    }

    @SuppressLint({"UnknownNullness"})
    public View O(int i2) {
        int V = V();
        if (V == 0) {
            return null;
        }
        int w0 = i2 - w0(U(0));
        if (w0 >= 0 && w0 < V) {
            View U = U(w0);
            if (w0(U) == i2) {
                return U;
            }
        }
        return super.O(i2);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int O2(RecyclerView.State state) {
        if (state.h()) {
            return this.u.o();
        }
        return 0;
    }

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams P() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int P2() {
        return this.G;
    }

    public int Q2() {
        return this.s;
    }

    public boolean R2() {
        return this.C;
    }

    public boolean S2() {
        return this.w;
    }

    public boolean T2() {
        return this.y;
    }

    @SuppressLint({"UnknownNullness"})
    public int U1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 1) {
            return 0;
        }
        return g3(i2, recycler, state);
    }

    /* access modifiers changed from: protected */
    public boolean U2() {
        return m0() == 1;
    }

    public void V1(int i2) {
        this.A = i2;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        R1();
    }

    public boolean V2() {
        return this.z;
    }

    @SuppressLint({"UnknownNullness"})
    public int W1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.s == 0) {
            return 0;
        }
        return g3(i2, recycler, state);
    }

    /* access modifiers changed from: package-private */
    public void W2(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View e2 = layoutState.e(recycler);
        if (e2 == null) {
            layoutChunkResult.f15410b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) e2.getLayoutParams();
        if (layoutState.f15425l == null) {
            if (this.x == (layoutState.f15419f == -1)) {
                j(e2);
            } else {
                k(e2, 0);
            }
        } else {
            if (this.x == (layoutState.f15419f == -1)) {
                h(e2);
            } else {
                i(e2, 0);
            }
        }
        V0(e2, 0, 0);
        layoutChunkResult.f15409a = this.u.e(e2);
        if (this.s == 1) {
            if (U2()) {
                i6 = D0() - t0();
                i5 = i6 - this.u.f(e2);
            } else {
                i5 = s0();
                i6 = this.u.f(e2) + i5;
            }
            int i7 = layoutState.f15419f;
            int i8 = layoutState.f15415b;
            if (i7 == -1) {
                i2 = i8;
                i3 = i6;
                i4 = i8 - layoutChunkResult.f15409a;
            } else {
                i4 = i8;
                i3 = i6;
                i2 = layoutChunkResult.f15409a + i8;
            }
        } else {
            int v0 = v0();
            int f2 = this.u.f(e2) + v0;
            int i9 = layoutState.f15419f;
            int i10 = layoutState.f15415b;
            if (i9 == -1) {
                i3 = i10;
                i4 = v0;
                i2 = f2;
                i5 = i10 - layoutChunkResult.f15409a;
            } else {
                i4 = v0;
                i3 = layoutChunkResult.f15409a + i10;
                i2 = f2;
                i5 = i10;
            }
        }
        T0(e2, i5, i4, i3, i2);
        if (layoutParams.g() || layoutParams.f()) {
            layoutChunkResult.f15411c = true;
        }
        layoutChunkResult.f15412d = e2.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    public void Z2(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i2) {
    }

    @SuppressLint({"UnknownNullness"})
    public PointF a(int i2) {
        if (V() == 0) {
            return null;
        }
        boolean z2 = false;
        int i3 = 1;
        if (i2 < w0(U(0))) {
            z2 = true;
        }
        if (z2 != this.x) {
            i3 = -1;
        }
        return this.s == 0 ? new PointF((float) i3, 0.0f) : new PointF(0.0f, (float) i3);
    }

    @SuppressLint({"UnknownNullness"})
    public void d1(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.d1(recyclerView, recycler);
        if (this.C) {
            H1(recycler);
            recycler.d();
        }
    }

    public void e(@NonNull View view, @NonNull View view2, int i2, int i3) {
        int g2;
        n("Cannot drop a view during a scroll or layout calculation");
        v2();
        f3();
        int w0 = w0(view);
        int w02 = w0(view2);
        char c2 = w0 < w02 ? (char) 1 : 65535;
        if (this.x) {
            if (c2 == 1) {
                h3(w02, this.u.i() - (this.u.g(view2) + this.u.e(view)));
                return;
            }
            g2 = this.u.i() - this.u.d(view2);
        } else if (c2 == 65535) {
            g2 = this.u.g(view2);
        } else {
            h3(w02, this.u.d(view2) - this.u.e(view));
            return;
        }
        h3(w02, g2);
    }

    @SuppressLint({"UnknownNullness"})
    public View e1(View view, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int t2;
        f3();
        if (V() == 0 || (t2 = t2(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        v2();
        r3(t2, (int) (((float) this.u.o()) * N), false, state);
        LayoutState layoutState = this.t;
        layoutState.f15420g = Integer.MIN_VALUE;
        layoutState.f15414a = false;
        w2(recycler, layoutState, state, true);
        View I2 = t2 == -1 ? I2() : H2();
        View N2 = t2 == -1 ? N2() : M2();
        if (!N2.hasFocusable()) {
            return I2;
        }
        if (I2 == null) {
            return null;
        }
        return N2;
    }

    /* access modifiers changed from: package-private */
    public boolean e3() {
        return this.u.l() == 0 && this.u.h() == 0;
    }

    @SuppressLint({"UnknownNullness"})
    public void f1(AccessibilityEvent accessibilityEvent) {
        super.f1(accessibilityEvent);
        if (V() > 0) {
            accessibilityEvent.setFromIndex(B2());
            accessibilityEvent.setToIndex(E2());
        }
    }

    /* access modifiers changed from: package-private */
    public int g3(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (V() == 0 || i2 == 0) {
            return 0;
        }
        v2();
        this.t.f15414a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        r3(i3, abs, true, state);
        LayoutState layoutState = this.t;
        int w2 = layoutState.f15420g + w2(recycler, layoutState, state, false);
        if (w2 < 0) {
            return 0;
        }
        if (abs > w2) {
            i2 = i3 * w2;
        }
        this.u.t(-i2);
        this.t.f15424k = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public boolean h2() {
        return (k0() == 1073741824 || E0() == 1073741824 || !F0()) ? false : true;
    }

    public void h3(int i2, int i3) {
        this.A = i2;
        this.B = i3;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        R1();
    }

    public void i3(int i2) {
        this.G = i2;
    }

    @SuppressLint({"UnknownNullness"})
    public void j2(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.q(i2);
        k2(linearSmoothScroller);
    }

    public void j3(int i2) {
        if (i2 == 0 || i2 == 1) {
            n((String) null);
            if (i2 != this.s || this.u == null) {
                OrientationHelper b2 = OrientationHelper.b(this, i2);
                this.u = b2;
                this.E.f15404a = b2;
                this.s = i2;
                R1();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i2);
    }

    public void k3(boolean z2) {
        this.C = z2;
    }

    public void l3(boolean z2) {
        n((String) null);
        if (z2 != this.w) {
            this.w = z2;
            R1();
        }
    }

    public void m3(boolean z2) {
        this.z = z2;
    }

    @SuppressLint({"UnknownNullness"})
    public void n(String str) {
        if (this.D == null) {
            super.n(str);
        }
    }

    public boolean n2() {
        return this.D == null && this.v == this.y;
    }

    public void n3(boolean z2) {
        n((String) null);
        if (this.y != z2) {
            this.y = z2;
            R1();
        }
    }

    /* access modifiers changed from: protected */
    public void o2(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i2;
        int O2 = O2(state);
        if (this.t.f15419f == -1) {
            i2 = 0;
        } else {
            i2 = O2;
            O2 = 0;
        }
        iArr[0] = O2;
        iArr[1] = i2;
    }

    /* access modifiers changed from: package-private */
    public void p2(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2 = layoutState.f15417d;
        if (i2 >= 0 && i2 < state.d()) {
            layoutPrefetchRegistry.a(i2, Math.max(0, layoutState.f15420g));
        }
    }

    public boolean s() {
        return this.s == 0;
    }

    @SuppressLint({"UnknownNullness"})
    public void s1(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int i3;
        int i4;
        int i5;
        int K2;
        int i6;
        View O;
        int g2;
        int i7;
        int i8 = -1;
        if (!(this.D == null && this.A == -1) && state.d() == 0) {
            H1(recycler);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.s;
        }
        v2();
        this.t.f15414a = false;
        f3();
        View i0 = i0();
        AnchorInfo anchorInfo = this.E;
        if (!anchorInfo.f15408e || this.A != -1 || this.D != null) {
            anchorInfo.e();
            AnchorInfo anchorInfo2 = this.E;
            anchorInfo2.f15407d = this.x ^ this.y;
            q3(recycler, state, anchorInfo2);
            this.E.f15408e = true;
        } else if (i0 != null && (this.u.g(i0) >= this.u.i() || this.u.d(i0) <= this.u.n())) {
            this.E.c(i0, w0(i0));
        }
        LayoutState layoutState = this.t;
        layoutState.f15419f = layoutState.f15424k >= 0 ? 1 : -1;
        int[] iArr = this.H;
        iArr[0] = 0;
        iArr[1] = 0;
        o2(state, iArr);
        int max = Math.max(0, this.H[0]) + this.u.n();
        int max2 = Math.max(0, this.H[1]) + this.u.j();
        if (!(!state.j() || (i6 = this.A) == -1 || this.B == Integer.MIN_VALUE || (O = O(i6)) == null)) {
            if (this.x) {
                i7 = this.u.i() - this.u.d(O);
                g2 = this.B;
            } else {
                g2 = this.u.g(O) - this.u.n();
                i7 = this.B;
            }
            int i9 = i7 - g2;
            if (i9 > 0) {
                max += i9;
            } else {
                max2 -= i9;
            }
        }
        AnchorInfo anchorInfo3 = this.E;
        if (!anchorInfo3.f15407d ? !this.x : this.x) {
            i8 = 1;
        }
        Z2(recycler, state, anchorInfo3, i8);
        E(recycler);
        this.t.f15426m = e3();
        this.t.f15423j = state.j();
        this.t.f15422i = 0;
        AnchorInfo anchorInfo4 = this.E;
        if (anchorInfo4.f15407d) {
            v3(anchorInfo4);
            LayoutState layoutState2 = this.t;
            layoutState2.f15421h = max;
            w2(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.t;
            i3 = layoutState3.f15415b;
            int i10 = layoutState3.f15417d;
            int i11 = layoutState3.f15416c;
            if (i11 > 0) {
                max2 += i11;
            }
            t3(this.E);
            LayoutState layoutState4 = this.t;
            layoutState4.f15421h = max2;
            layoutState4.f15417d += layoutState4.f15418e;
            w2(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.t;
            i2 = layoutState5.f15415b;
            int i12 = layoutState5.f15416c;
            if (i12 > 0) {
                u3(i10, i3);
                LayoutState layoutState6 = this.t;
                layoutState6.f15421h = i12;
                w2(recycler, layoutState6, state, false);
                i3 = this.t.f15415b;
            }
        } else {
            t3(anchorInfo4);
            LayoutState layoutState7 = this.t;
            layoutState7.f15421h = max2;
            w2(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.t;
            i2 = layoutState8.f15415b;
            int i13 = layoutState8.f15417d;
            int i14 = layoutState8.f15416c;
            if (i14 > 0) {
                max += i14;
            }
            v3(this.E);
            LayoutState layoutState9 = this.t;
            layoutState9.f15421h = max;
            layoutState9.f15417d += layoutState9.f15418e;
            w2(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.t;
            i3 = layoutState10.f15415b;
            int i15 = layoutState10.f15416c;
            if (i15 > 0) {
                s3(i13, i2);
                LayoutState layoutState11 = this.t;
                layoutState11.f15421h = i15;
                w2(recycler, layoutState11, state, false);
                i2 = this.t.f15415b;
            }
        }
        if (V() > 0) {
            if (this.x ^ this.y) {
                int K22 = K2(i2, recycler, state, true);
                i4 = i3 + K22;
                i5 = i2 + K22;
                K2 = L2(i4, recycler, state, false);
            } else {
                int L2 = L2(i3, recycler, state, true);
                i4 = i3 + L2;
                i5 = i2 + L2;
                K2 = K2(i5, recycler, state, false);
            }
            i3 = i4 + K2;
            i2 = i5 + K2;
        }
        X2(recycler, state, i3, i2);
        if (!state.j()) {
            this.u.u();
        } else {
            this.E.e();
        }
        this.v = this.y;
    }

    public boolean t() {
        return this.s == 1;
    }

    @SuppressLint({"UnknownNullness"})
    public void t1(RecyclerView.State state) {
        super.t1(state);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.E.e();
    }

    /* access modifiers changed from: package-private */
    public int t2(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.s == 1) ? 1 : Integer.MIN_VALUE : this.s == 0 ? 1 : Integer.MIN_VALUE : this.s == 1 ? -1 : Integer.MIN_VALUE : this.s == 0 ? -1 : Integer.MIN_VALUE : (this.s != 1 && U2()) ? -1 : 1 : (this.s != 1 && U2()) ? 1 : -1;
    }

    /* access modifiers changed from: package-private */
    public LayoutState u2() {
        return new LayoutState();
    }

    /* access modifiers changed from: package-private */
    public void v2() {
        if (this.t == null) {
            this.t = u2();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void w(int i2, int i3, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.s != 0) {
            i2 = i3;
        }
        if (V() != 0 && i2 != 0) {
            v2();
            r3(i2 > 0 ? 1 : -1, Math.abs(i2), true, state);
            p2(state, this.t, layoutPrefetchRegistry);
        }
    }

    /* access modifiers changed from: package-private */
    public int w2(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z2) {
        int i2 = layoutState.f15416c;
        int i3 = layoutState.f15420g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                layoutState.f15420g = i3 + i2;
            }
            a3(recycler, layoutState);
        }
        int i4 = layoutState.f15416c + layoutState.f15421h;
        LayoutChunkResult layoutChunkResult = this.F;
        while (true) {
            if ((!layoutState.f15426m && i4 <= 0) || !layoutState.c(state)) {
                break;
            }
            layoutChunkResult.a();
            W2(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f15410b) {
                layoutState.f15415b += layoutChunkResult.f15409a * layoutState.f15419f;
                if (!layoutChunkResult.f15411c || layoutState.f15425l != null || !state.j()) {
                    int i5 = layoutState.f15416c;
                    int i6 = layoutChunkResult.f15409a;
                    layoutState.f15416c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = layoutState.f15420g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + layoutChunkResult.f15409a;
                    layoutState.f15420g = i8;
                    int i9 = layoutState.f15416c;
                    if (i9 < 0) {
                        layoutState.f15420g = i8 + i9;
                    }
                    a3(recycler, layoutState);
                }
                if (z2 && layoutChunkResult.f15412d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - layoutState.f15416c;
    }

    /* access modifiers changed from: package-private */
    public void w3() {
        Log.d(I, "validating child count " + V());
        boolean z2 = true;
        if (V() >= 1) {
            int w0 = w0(U(0));
            int g2 = this.u.g(U(0));
            if (this.x) {
                int i2 = 1;
                while (i2 < V()) {
                    View U = U(i2);
                    int w02 = w0(U);
                    int g3 = this.u.g(U);
                    if (w02 < w0) {
                        Y2();
                        StringBuilder sb = new StringBuilder();
                        sb.append("detected invalid position. loc invalid? ");
                        if (g3 >= g2) {
                            z2 = false;
                        }
                        sb.append(z2);
                        throw new RuntimeException(sb.toString());
                    } else if (g3 <= g2) {
                        i2++;
                    } else {
                        Y2();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i3 = 1;
            while (i3 < V()) {
                View U2 = U(i3);
                int w03 = w0(U2);
                int g4 = this.u.g(U2);
                if (w03 < w0) {
                    Y2();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("detected invalid position. loc invalid? ");
                    if (g4 >= g2) {
                        z2 = false;
                    }
                    sb2.append(z2);
                    throw new RuntimeException(sb2.toString());
                } else if (g4 >= g2) {
                    i3++;
                } else {
                    Y2();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void x(int i2, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z2;
        int i3;
        SavedState savedState = this.D;
        int i4 = -1;
        if (savedState == null || !savedState.a()) {
            f3();
            z2 = this.x;
            i3 = this.A;
            if (i3 == -1) {
                i3 = z2 ? i2 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z2 = savedState2.Y;
            i3 = savedState2.s;
        }
        if (!z2) {
            i4 = 1;
        }
        for (int i5 = 0; i5 < this.G && i3 >= 0 && i3 < i2; i5++) {
            layoutPrefetchRegistry.a(i3, 0);
            i3 += i4;
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void x1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.D = savedState;
            if (this.A != -1) {
                savedState.b();
            }
            R1();
        }
    }

    public int x2() {
        View G2 = G2(0, V(), true, false);
        if (G2 == null) {
            return -1;
        }
        return w0(G2);
    }

    @SuppressLint({"UnknownNullness"})
    public int y(RecyclerView.State state) {
        return q2(state);
    }

    @SuppressLint({"UnknownNullness"})
    public Parcelable y1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (V() > 0) {
            v2();
            boolean z2 = this.v ^ this.x;
            savedState.Y = z2;
            if (z2) {
                View M2 = M2();
                savedState.X = this.u.i() - this.u.d(M2);
                savedState.s = w0(M2);
            } else {
                View N2 = N2();
                savedState.s = w0(N2);
                savedState.X = this.u.g(N2) - this.u.n();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    @SuppressLint({"UnknownNullness"})
    public int z(RecyclerView.State state) {
        return r2(state);
    }

    /* access modifiers changed from: package-private */
    public View z2(boolean z2, boolean z3) {
        int V;
        int i2;
        if (this.x) {
            V = 0;
            i2 = V();
        } else {
            V = V() - 1;
            i2 = -1;
        }
        return G2(V, i2, z2, z3);
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context, int i2, boolean z2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new AnchorInfo();
        this.F = new LayoutChunkResult();
        this.G = 2;
        this.H = new int[2];
        j3(i2);
        l3(z2);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.E = new AnchorInfo();
        this.F = new LayoutChunkResult();
        this.G = 2;
        this.H = new int[2];
        RecyclerView.LayoutManager.Properties x0 = RecyclerView.LayoutManager.x0(context, attributeSet, i2, i3);
        j3(x0.f15530a);
        l3(x0.f15532c);
        n3(x0.f15533d);
    }
}

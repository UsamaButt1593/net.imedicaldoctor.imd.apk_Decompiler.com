package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;

public class RecyclerViewExpandableItemManager {

    /* renamed from: k  reason: collision with root package name */
    private static final String f25464k = "ARVExpandableItemMgr";

    /* renamed from: l  reason: collision with root package name */
    public static final long f25465l = -1;

    /* renamed from: m  reason: collision with root package name */
    public static final int f25466m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static final int f25467n = 2;
    public static final int o = 4;
    public static final int p = Integer.MIN_VALUE;

    /* renamed from: a  reason: collision with root package name */
    private SavedState f25468a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f25469b;

    /* renamed from: c  reason: collision with root package name */
    private ExpandableRecyclerViewWrapperAdapter f25470c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.OnItemTouchListener f25471d = new RecyclerView.OnItemTouchListener() {
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            return RecyclerViewExpandableItemManager.this.H(recyclerView, motionEvent);
        }

        public void e(boolean z) {
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private OnGroupExpandListener f25472e;

    /* renamed from: f  reason: collision with root package name */
    private OnGroupCollapseListener f25473f;

    /* renamed from: g  reason: collision with root package name */
    private long f25474g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f25475h;

    /* renamed from: i  reason: collision with root package name */
    private int f25476i;

    /* renamed from: j  reason: collision with root package name */
    private int f25477j;

    public interface OnGroupCollapseListener {
        void a(int i2, boolean z);
    }

    public interface OnGroupExpandListener {
        void a(int i2, boolean z);
    }

    public RecyclerViewExpandableItemManager(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f25468a = (SavedState) parcelable;
        }
    }

    public static int e(int i2) {
        return ExpandableAdapterHelper.a(i2);
    }

    public static long f(long j2, long j3) {
        return ExpandableAdapterHelper.b(j2, j3);
    }

    public static long g(long j2) {
        return ExpandableAdapterHelper.c(j2);
    }

    public static int j(int i2) {
        return ExpandableAdapterHelper.d(i2);
    }

    public static int k(long j2) {
        return ExpandableAdapterHelper.e(j2);
    }

    public static long l(int i2, int i3) {
        return ExpandableAdapterHelper.f(i2, i3);
    }

    public static long m(int i2) {
        return ExpandableAdapterHelper.g(i2);
    }

    public static int n(long j2) {
        return ExpandableAdapterHelper.h(j2);
    }

    private void p(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView.ViewHolder a2 = CustomRecyclerViewUtils.a(recyclerView, motionEvent.getX(), motionEvent.getY());
        this.f25476i = (int) (motionEvent.getX() + 0.5f);
        this.f25477j = (int) (motionEvent.getY() + 0.5f);
        this.f25474g = a2 instanceof ExpandableItemViewHolder ? a2.E() : -1;
    }

    private boolean q(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView.ViewHolder a2;
        int j2;
        long j3 = this.f25474g;
        int i2 = this.f25476i;
        int i3 = this.f25477j;
        this.f25474g = -1;
        this.f25476i = 0;
        this.f25477j = 0;
        if (j3 != -1 && MotionEventCompat.c(motionEvent) == 1) {
            int x = (int) (motionEvent.getX() + 0.5f);
            int y = (int) (motionEvent.getY() + 0.5f);
            int i4 = y - i3;
            if (Math.abs(x - i2) >= this.f25475h || Math.abs(i4) >= this.f25475h || (a2 = CustomRecyclerViewUtils.a(recyclerView, motionEvent.getX(), motionEvent.getY())) == null || a2.E() != j3 || (j2 = CustomRecyclerViewUtils.j(a2)) == -1) {
                return false;
            }
            View view = a2.f15587a;
            int left = view.getLeft();
            int top = y - (view.getTop() + ((int) (ViewCompat.C0(view) + 0.5f)));
            return this.f25470c.N0(a2, j2, x - (left + ((int) (ViewCompat.B0(view) + 0.5f))), top);
        }
        return false;
    }

    public static boolean s(int i2) {
        return ExpandableAdapterHelper.i(i2);
    }

    public void A(int i2) {
        this.f25470c.G0(i2);
    }

    public void B(int i2) {
        this.f25470c.H0(i2);
    }

    public void C(int i2) {
        this.f25470c.I0(i2);
    }

    public void D(int i2) {
        this.f25470c.J0(i2);
    }

    public void E(int i2, int i3) {
        this.f25470c.K0(i2, i3);
    }

    public void F(int i2, int i3) {
        this.f25470c.L0(i2, i3);
    }

    public void G(int i2) {
        this.f25470c.M0(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean H(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f25470c == null) {
            return false;
        }
        int c2 = MotionEventCompat.c(motionEvent);
        if (c2 == 0) {
            p(recyclerView, motionEvent);
        } else if (c2 == 1 || c2 == 3) {
            q(recyclerView, motionEvent);
            return false;
        }
        return false;
    }

    public void I() {
        RecyclerView.OnItemTouchListener onItemTouchListener;
        RecyclerView recyclerView = this.f25469b;
        if (!(recyclerView == null || (onItemTouchListener = this.f25471d) == null)) {
            recyclerView.D1(onItemTouchListener);
        }
        this.f25471d = null;
        this.f25472e = null;
        this.f25473f = null;
        this.f25469b = null;
        this.f25468a = null;
    }

    public void J(Parcelable parcelable) {
        K(parcelable, false, false);
    }

    public void K(Parcelable parcelable, boolean z, boolean z2) {
        if (parcelable != null) {
            if (parcelable instanceof SavedState) {
                ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.f25470c;
                if (expandableRecyclerViewWrapperAdapter == null || this.f25469b == null) {
                    throw new IllegalStateException("RecyclerView has not been attached");
                }
                expandableRecyclerViewWrapperAdapter.P0(((SavedState) parcelable).s, z, z2);
                return;
            }
            throw new IllegalArgumentException("Illegal saved state object passed");
        }
    }

    public void L(OnGroupCollapseListener onGroupCollapseListener) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.f25470c;
        if (expandableRecyclerViewWrapperAdapter != null) {
            expandableRecyclerViewWrapperAdapter.R0(onGroupCollapseListener);
        } else {
            this.f25473f = onGroupCollapseListener;
        }
    }

    public void M(OnGroupExpandListener onGroupExpandListener) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.f25470c;
        if (expandableRecyclerViewWrapperAdapter != null) {
            expandableRecyclerViewWrapperAdapter.S0(onGroupExpandListener);
        } else {
            this.f25472e = onGroupExpandListener;
        }
    }

    public void a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            throw new IllegalArgumentException("RecyclerView cannot be null");
        } else if (t()) {
            throw new IllegalStateException("Accessing released object");
        } else if (this.f25469b == null) {
            this.f25469b = recyclerView;
            recyclerView.s(this.f25471d);
            this.f25475h = ViewConfiguration.get(this.f25469b.getContext()).getScaledTouchSlop();
        } else {
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
    }

    public boolean b(int i2) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.f25470c;
        return expandableRecyclerViewWrapperAdapter != null && expandableRecyclerViewWrapperAdapter.q0(i2, false);
    }

    public RecyclerView.Adapter c(RecyclerView.Adapter adapter) {
        if (this.f25470c == null) {
            SavedState savedState = this.f25468a;
            int[] iArr = savedState != null ? savedState.s : null;
            this.f25468a = null;
            ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = new ExpandableRecyclerViewWrapperAdapter(this, adapter, iArr);
            this.f25470c = expandableRecyclerViewWrapperAdapter;
            expandableRecyclerViewWrapperAdapter.S0(this.f25472e);
            this.f25472e = null;
            this.f25470c.R0(this.f25473f);
            this.f25473f = null;
            return this.f25470c;
        }
        throw new IllegalStateException("already have a wrapped adapter");
    }

    public boolean d(int i2) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.f25470c;
        return expandableRecyclerViewWrapperAdapter != null && expandableRecyclerViewWrapperAdapter.s0(i2, false);
    }

    public long h(int i2) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.f25470c;
        if (expandableRecyclerViewWrapperAdapter == null) {
            return -1;
        }
        return expandableRecyclerViewWrapperAdapter.u0(i2);
    }

    public int i(long j2) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.f25470c;
        if (expandableRecyclerViewWrapperAdapter == null) {
            return -1;
        }
        return expandableRecyclerViewWrapperAdapter.w0(j2);
    }

    public Parcelable o() {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.f25470c;
        return new SavedState(expandableRecyclerViewWrapperAdapter != null ? expandableRecyclerViewWrapperAdapter.v0() : null);
    }

    public boolean r(int i2) {
        ExpandableRecyclerViewWrapperAdapter expandableRecyclerViewWrapperAdapter = this.f25470c;
        return expandableRecyclerViewWrapperAdapter != null && expandableRecyclerViewWrapperAdapter.y0(i2);
    }

    public boolean t() {
        return this.f25471d == null;
    }

    public void u(int i2, int i3) {
        this.f25470c.A0(i2, i3);
    }

    public void v(int i2, int i3) {
        this.f25470c.B0(i2, i3);
    }

    public void w(int i2, int i3, int i4) {
        this.f25470c.C0(i2, i3, i4);
    }

    public void x(int i2, int i3, int i4) {
        this.f25470c.D0(i2, i3, i4);
    }

    public void y(int i2, int i3, int i4) {
        this.f25470c.E0(i2, i3, i4);
    }

    public void z(int i2, int i3) {
        this.f25470c.F0(i2, i3);
    }

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
        final int[] s;

        private SavedState(Parcel parcel) {
            this.s = parcel.createIntArray();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeIntArray(this.s);
        }

        public SavedState(int[] iArr) {
            this.s = iArr;
        }
    }
}

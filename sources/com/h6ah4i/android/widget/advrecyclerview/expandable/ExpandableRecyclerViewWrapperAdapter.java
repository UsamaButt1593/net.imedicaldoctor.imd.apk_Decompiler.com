package com.h6ah4i.android.widget.advrecyclerview.expandable;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.BaseWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;

class ExpandableRecyclerViewWrapperAdapter extends BaseWrapperAdapter<RecyclerView.ViewHolder> implements DraggableItemAdapter<RecyclerView.ViewHolder>, SwipeableItemAdapter<RecyclerView.ViewHolder> {
    private static final String q = "ARVExpandableWrapper";
    private static final int r = Integer.MIN_VALUE;
    private static final int s = -1;

    /* renamed from: h  reason: collision with root package name */
    private ExpandableItemAdapter f25457h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerViewExpandableItemManager f25458i;

    /* renamed from: j  reason: collision with root package name */
    private ExpandablePositionTranslator f25459j;

    /* renamed from: k  reason: collision with root package name */
    private int f25460k = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f25461l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f25462m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f25463n = -1;
    private RecyclerViewExpandableItemManager.OnGroupExpandListener o;
    private RecyclerViewExpandableItemManager.OnGroupCollapseListener p;

    public ExpandableRecyclerViewWrapperAdapter(RecyclerViewExpandableItemManager recyclerViewExpandableItemManager, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int[] iArr) {
        super(adapter);
        ExpandableItemAdapter t0 = t0(adapter);
        this.f25457h = t0;
        if (t0 == null) {
            throw new IllegalArgumentException("adapter does not implement RecyclerViewExpandableListManager");
        } else if (recyclerViewExpandableItemManager != null) {
            this.f25458i = recyclerViewExpandableItemManager;
            ExpandablePositionTranslator expandablePositionTranslator = new ExpandablePositionTranslator();
            this.f25459j = expandablePositionTranslator;
            expandablePositionTranslator.b(this.f25457h);
            if (iArr != null) {
                this.f25459j.w(iArr, (ExpandableItemAdapter) null, (RecyclerViewExpandableItemManager.OnGroupExpandListener) null, (RecyclerViewExpandableItemManager.OnGroupCollapseListener) null);
            }
        } else {
            throw new IllegalArgumentException("manager cannot be null");
        }
    }

    private void O0() {
        ExpandablePositionTranslator expandablePositionTranslator = this.f25459j;
        if (expandablePositionTranslator != null) {
            int[] j2 = expandablePositionTranslator.j();
            this.f25459j.b(this.f25457h);
            this.f25459j.w(j2, (ExpandableItemAdapter) null, (RecyclerViewExpandableItemManager.OnGroupExpandListener) null, (RecyclerViewExpandableItemManager.OnGroupCollapseListener) null);
        }
    }

    private static void Q0(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof ExpandableItemViewHolder) {
            ExpandableItemViewHolder expandableItemViewHolder = (ExpandableItemViewHolder) viewHolder;
            int q2 = expandableItemViewHolder.q();
            if (q2 == -1 || ((q2 ^ i2) & Integer.MAX_VALUE) != 0) {
                i2 |= Integer.MIN_VALUE;
            }
            expandableItemViewHolder.m(i2);
        }
    }

    private void r0(RecyclerView.ViewHolder viewHolder, int i2, int i3) {
        if (viewHolder instanceof DraggableItemViewHolder) {
            DraggableItemViewHolder draggableItemViewHolder = (DraggableItemViewHolder) viewHolder;
            int i4 = this.f25460k;
            boolean z = false;
            boolean z2 = (i4 == -1 || this.f25461l == -1) ? false : true;
            int i5 = this.f25462m;
            boolean z3 = (i5 == -1 || this.f25463n == -1) ? false : true;
            boolean z4 = i2 >= i4 && i2 <= this.f25461l;
            if (i2 != -1 && i3 >= i5 && i3 <= this.f25463n) {
                z = true;
            }
            int d2 = draggableItemViewHolder.d();
            if ((d2 & 1) != 0 && (d2 & 4) == 0) {
                if (z2 && !z4) {
                    return;
                }
                if (!z3 || (z3 && z)) {
                    draggableItemViewHolder.i(d2 | -2147483644);
                }
            }
        }
    }

    private static ExpandableItemAdapter t0(RecyclerView.Adapter adapter) {
        return (ExpandableItemAdapter) WrapperAdapterUtils.a(adapter, ExpandableItemAdapter.class);
    }

    private static boolean x0(ItemDraggableRange itemDraggableRange) {
        return itemDraggableRange.getClass().equals(ChildPositionItemDraggableRange.class);
    }

    private static boolean z0(ItemDraggableRange itemDraggableRange) {
        return itemDraggableRange.getClass().equals(GroupPositionItemDraggableRange.class) || itemDraggableRange.getClass().equals(ItemDraggableRange.class);
    }

    /* access modifiers changed from: package-private */
    public void A0(int i2, int i3) {
        C0(i2, i3, 1);
    }

    public long B(int i2) {
        if (this.f25457h == null) {
            return -1;
        }
        long g2 = this.f25459j.g(i2);
        int h2 = ExpandableAdapterHelper.h(g2);
        int e2 = ExpandableAdapterHelper.e(g2);
        return e2 == -1 ? ExpandableAdapterHelper.c(this.f25457h.getGroupId(h2)) : ExpandableAdapterHelper.b(this.f25457h.getGroupId(h2), this.f25457h.getChildId(h2, e2));
    }

    /* access modifiers changed from: package-private */
    public void B0(int i2, int i3) {
        this.f25459j.l(i2, i3);
        int h2 = this.f25459j.h(ExpandableAdapterHelper.f(i2, i3));
        if (h2 != -1) {
            J(h2);
        }
    }

    public int C(int i2) {
        if (this.f25457h == null) {
            return 0;
        }
        long g2 = this.f25459j.g(i2);
        int h2 = ExpandableAdapterHelper.h(g2);
        int e2 = ExpandableAdapterHelper.e(g2);
        ExpandableItemAdapter expandableItemAdapter = this.f25457h;
        int g3 = e2 == -1 ? expandableItemAdapter.g(h2) : expandableItemAdapter.i(h2, e2);
        if ((g3 & Integer.MIN_VALUE) == 0) {
            return e2 == -1 ? g3 | Integer.MIN_VALUE : g3;
        }
        throw new IllegalStateException("Illegal view type (type = " + Integer.toHexString(g3) + ")");
    }

    /* access modifiers changed from: package-private */
    public void C0(int i2, int i3, int i4) {
        int h2;
        int k2 = this.f25459j.k(i2);
        if (k2 > 0 && i3 < k2 && (h2 = this.f25459j.h(ExpandableAdapterHelper.f(i2, 0))) != -1) {
            L(h2 + i3, Math.min(i4, k2 - i3));
        }
    }

    /* access modifiers changed from: package-private */
    public void D0(int i2, int i3, int i4) {
        this.f25459j.m(i2, i3, i4);
        int h2 = this.f25459j.h(ExpandableAdapterHelper.f(i2, i3));
        if (h2 != -1) {
            N(h2, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void E0(int i2, int i3, int i4) {
        int h2 = this.f25459j.h(ExpandableAdapterHelper.f(i2, i3));
        this.f25459j.t(i2, i3, i4);
        if (h2 != -1) {
            O(h2, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void F0(int i2, int i3) {
        int h2 = this.f25459j.h(ExpandableAdapterHelper.f(i2, i3));
        this.f25459j.s(i2, i3);
        if (h2 != -1) {
            P(h2);
        }
    }

    /* access modifiers changed from: package-private */
    public void G0(int i2) {
        int h2;
        int k2 = this.f25459j.k(i2);
        if (k2 > 0 && (h2 = this.f25459j.h(ExpandableAdapterHelper.f(i2, 0))) != -1) {
            L(h2, k2);
        }
    }

    /* access modifiers changed from: package-private */
    public void H0(int i2) {
        int h2 = this.f25459j.h(ExpandableAdapterHelper.g(i2));
        int k2 = this.f25459j.k(i2);
        if (h2 != -1) {
            L(h2, k2 + 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void I0(int i2) {
        int h2 = this.f25459j.h(ExpandableAdapterHelper.g(i2));
        if (h2 != -1) {
            H(h2);
        }
    }

    /* access modifiers changed from: package-private */
    public void J0(int i2) {
        if (this.f25459j.n(i2) > 0) {
            J(this.f25459j.h(ExpandableAdapterHelper.g(i2)));
        }
    }

    /* access modifiers changed from: package-private */
    public void K0(int i2, int i3) {
        int o2 = this.f25459j.o(i2, i3);
        if (o2 > 0) {
            N(this.f25459j.h(ExpandableAdapterHelper.g(i2)), o2);
        }
    }

    /* access modifiers changed from: package-private */
    public void L0(int i2, int i3) {
        int h2 = this.f25459j.h(ExpandableAdapterHelper.g(i2));
        int v = this.f25459j.v(i2, i3);
        if (v > 0) {
            O(h2, v);
        }
    }

    /* access modifiers changed from: package-private */
    public void M0(int i2) {
        int h2 = this.f25459j.h(ExpandableAdapterHelper.g(i2));
        if (this.f25459j.u(i2) > 0) {
            P(h2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean N0(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4) {
        if (this.f25457h == null) {
            return false;
        }
        long g2 = this.f25459j.g(i2);
        int h2 = ExpandableAdapterHelper.h(g2);
        if (ExpandableAdapterHelper.e(g2) != -1) {
            return false;
        }
        boolean z = !this.f25459j.p(h2);
        if (!this.f25457h.v(viewHolder, h2, i3, i4, z)) {
            return false;
        }
        if (z) {
            s0(h2, true);
        } else {
            q0(h2, true);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void P0(int[] iArr, boolean z, boolean z2) {
        ExpandablePositionTranslator expandablePositionTranslator = this.f25459j;
        RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener = null;
        ExpandableItemAdapter expandableItemAdapter = z ? this.f25457h : null;
        RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener = z2 ? this.o : null;
        if (z2) {
            onGroupCollapseListener = this.p;
        }
        expandablePositionTranslator.w(iArr, expandableItemAdapter, onGroupExpandListener, onGroupCollapseListener);
    }

    public void R(RecyclerView.ViewHolder viewHolder, int i2) {
        if (this.f25457h != null) {
            long g2 = this.f25459j.g(i2);
            int h2 = ExpandableAdapterHelper.h(g2);
            int e2 = ExpandableAdapterHelper.e(g2);
            int F = viewHolder.F() & Integer.MAX_VALUE;
            int i3 = e2 == -1 ? 1 : 2;
            if (this.f25459j.p(h2)) {
                i3 |= 4;
            }
            Q0(viewHolder, i3);
            r0(viewHolder, h2, e2);
            if (e2 == -1) {
                this.f25457h.e(viewHolder, h2, F);
            } else {
                this.f25457h.j(viewHolder, h2, e2, F);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void R0(RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener) {
        this.p = onGroupCollapseListener;
    }

    /* access modifiers changed from: package-private */
    public void S0(RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener) {
        this.o = onGroupExpandListener;
    }

    public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
        ExpandableItemAdapter expandableItemAdapter = this.f25457h;
        if (expandableItemAdapter == null) {
            return null;
        }
        int i3 = Integer.MAX_VALUE & i2;
        RecyclerView.ViewHolder q2 = (i2 & Integer.MIN_VALUE) != 0 ? expandableItemAdapter.q(viewGroup, i3) : expandableItemAdapter.f(viewGroup, i3);
        if (q2 instanceof ExpandableItemViewHolder) {
            ((ExpandableItemViewHolder) q2).m(-1);
        }
        return q2;
    }

    public int b() {
        return this.f25459j.i();
    }

    public int c(RecyclerView.ViewHolder viewHolder, int i2, int i3) {
        ExpandableItemAdapter expandableItemAdapter = this.f25457h;
        if (!(expandableItemAdapter instanceof ExpandableSwipeableItemAdapter)) {
            return 0;
        }
        ExpandableSwipeableItemAdapter expandableSwipeableItemAdapter = (ExpandableSwipeableItemAdapter) expandableItemAdapter;
        long g2 = this.f25459j.g(i2);
        int h2 = ExpandableAdapterHelper.h(g2);
        int e2 = ExpandableAdapterHelper.e(g2);
        return e2 == -1 ? expandableSwipeableItemAdapter.g(viewHolder, h2, i3) : expandableSwipeableItemAdapter.c(viewHolder, h2, e2, i3);
    }

    /* access modifiers changed from: protected */
    public void e0() {
        O0();
        super.e0();
    }

    /* access modifiers changed from: protected */
    public void f0(int i2, int i3) {
        super.f0(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void g0(int i2, int i3) {
        O0();
        super.g0(i2, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h(int r11, int r12) {
        /*
            r10 = this;
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemAdapter r0 = r10.f25457h
            boolean r1 = r0 instanceof com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableDraggableItemAdapter
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            r1 = -1
            r10.f25460k = r1
            r10.f25461l = r1
            r10.f25462m = r1
            r10.f25463n = r1
            if (r11 != r12) goto L_0x0013
            return
        L_0x0013:
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableDraggableItemAdapter r0 = (com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableDraggableItemAdapter) r0
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r2 = r10.f25459j
            long r2 = r2.g(r11)
            int r4 = com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableAdapterHelper.h(r2)
            int r2 = com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableAdapterHelper.e(r2)
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r3 = r10.f25459j
            long r5 = r3.g(r12)
            int r3 = com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableAdapterHelper.h(r5)
            int r5 = com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableAdapterHelper.e(r5)
            r6 = 0
            r7 = 1
            if (r2 != r1) goto L_0x0037
            r8 = 1
            goto L_0x0038
        L_0x0037:
            r8 = 0
        L_0x0038:
            if (r5 != r1) goto L_0x003c
            r9 = 1
            goto L_0x003d
        L_0x003c:
            r9 = 0
        L_0x003d:
            if (r8 == 0) goto L_0x004b
            if (r9 == 0) goto L_0x004b
        L_0x0041:
            r0.d(r4, r3)
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r0 = r10.f25459j
            r0.r(r4, r3)
            goto L_0x00c1
        L_0x004b:
            if (r8 != 0) goto L_0x0069
            if (r9 != 0) goto L_0x0069
            if (r4 != r3) goto L_0x0052
            goto L_0x0056
        L_0x0052:
            if (r11 >= r12) goto L_0x0056
            int r5 = r5 + 1
        L_0x0056:
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r12 = r10.f25459j
            long r6 = com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableAdapterHelper.f(r4, r5)
            int r12 = r12.h(r6)
            r0.c(r4, r2, r3, r5)
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r0 = r10.f25459j
            r0.q(r4, r2, r3, r5)
            goto L_0x00c1
        L_0x0069:
            if (r8 != 0) goto L_0x00b3
            if (r12 >= r11) goto L_0x007b
            if (r3 != 0) goto L_0x0072
        L_0x006f:
            r5 = r3
            r8 = 0
            goto L_0x008b
        L_0x0072:
            int r5 = r3 + -1
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r8 = r10.f25459j
            int r8 = r8.f(r5)
            goto L_0x008b
        L_0x007b:
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r5 = r10.f25459j
            boolean r5 = r5.p(r3)
            if (r5 == 0) goto L_0x0084
            goto L_0x006f
        L_0x0084:
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r5 = r10.f25459j
            int r8 = r5.f(r3)
            r5 = r3
        L_0x008b:
            if (r4 != r5) goto L_0x009c
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r9 = r10.f25459j
            int r9 = r9.f(r5)
            int r9 = r9 - r7
            int r6 = java.lang.Math.max(r6, r9)
            int r8 = java.lang.Math.min(r8, r6)
        L_0x009c:
            if (r4 != r5) goto L_0x00a0
            if (r2 == r8) goto L_0x00c0
        L_0x00a0:
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r6 = r10.f25459j
            boolean r3 = r6.p(r3)
            if (r3 == 0) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            r12 = -1
        L_0x00aa:
            r0.c(r4, r2, r5, r8)
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r0 = r10.f25459j
            r0.q(r4, r2, r5, r8)
            goto L_0x00c1
        L_0x00b3:
            if (r4 == r3) goto L_0x00c0
            com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandablePositionTranslator r12 = r10.f25459j
            long r5 = com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableAdapterHelper.g(r3)
            int r12 = r12.h(r5)
            goto L_0x0041
        L_0x00c0:
            r12 = r11
        L_0x00c1:
            if (r12 == r11) goto L_0x00cc
            if (r12 == r1) goto L_0x00c9
            r10.K(r11, r12)
            goto L_0x00cc
        L_0x00c9:
            r10.P(r11)
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableRecyclerViewWrapperAdapter.h(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void h0(int i2, int i3) {
        if (i3 == 1) {
            long g2 = this.f25459j.g(i2);
            int h2 = ExpandableAdapterHelper.h(g2);
            int e2 = ExpandableAdapterHelper.e(g2);
            if (e2 == -1) {
                this.f25459j.u(h2);
            } else {
                this.f25459j.s(h2, e2);
            }
        } else {
            O0();
        }
        super.h0(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void i0(int i2, int i3, int i4) {
        O0();
        super.i0(i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void j0() {
        super.j0();
        this.f25457h = null;
        this.f25458i = null;
        this.o = null;
        this.p = null;
    }

    public boolean k(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4) {
        ExpandableItemAdapter expandableItemAdapter = this.f25457h;
        if (!(expandableItemAdapter instanceof ExpandableDraggableItemAdapter)) {
            return false;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) expandableItemAdapter;
        long g2 = this.f25459j.g(i2);
        int h2 = ExpandableAdapterHelper.h(g2);
        int e2 = ExpandableAdapterHelper.e(g2);
        boolean a2 = e2 == -1 ? expandableDraggableItemAdapter.a(viewHolder, h2, i3, i4) : expandableDraggableItemAdapter.e(viewHolder, h2, e2, i3, i4);
        this.f25460k = -1;
        this.f25461l = -1;
        this.f25462m = -1;
        this.f25463n = -1;
        return a2;
    }

    public void l(RecyclerView.ViewHolder viewHolder, int i2, int i3) {
        ExpandableItemAdapter expandableItemAdapter = this.f25457h;
        if (expandableItemAdapter instanceof ExpandableSwipeableItemAdapter) {
            ExpandableSwipeableItemAdapter expandableSwipeableItemAdapter = (ExpandableSwipeableItemAdapter) expandableItemAdapter;
            long g2 = this.f25459j.g(i2);
            int h2 = ExpandableAdapterHelper.h(g2);
            int e2 = ExpandableAdapterHelper.e(g2);
            if (e2 == -1) {
                expandableSwipeableItemAdapter.d(viewHolder, h2, i3);
            } else {
                expandableSwipeableItemAdapter.f(viewHolder, h2, e2, i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean q0(int i2, boolean z) {
        if (!this.f25459j.p(i2) || !this.f25457h.n(i2, z)) {
            return false;
        }
        if (this.f25459j.c(i2)) {
            O(this.f25459j.h(ExpandableAdapterHelper.g(i2)) + 1, this.f25459j.f(i2));
        }
        H(this.f25459j.h(ExpandableAdapterHelper.g(i2)));
        RecyclerViewExpandableItemManager.OnGroupCollapseListener onGroupCollapseListener = this.p;
        if (onGroupCollapseListener != null) {
            onGroupCollapseListener.a(i2, z);
        }
        return true;
    }

    public int s(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4) {
        ExpandableItemAdapter expandableItemAdapter = this.f25457h;
        if (!(expandableItemAdapter instanceof ExpandableSwipeableItemAdapter)) {
            return 0;
        }
        ExpandableSwipeableItemAdapter expandableSwipeableItemAdapter = (ExpandableSwipeableItemAdapter) expandableItemAdapter;
        long g2 = this.f25459j.g(i2);
        int h2 = ExpandableAdapterHelper.h(g2);
        int e2 = ExpandableAdapterHelper.e(g2);
        return e2 == -1 ? expandableSwipeableItemAdapter.h(viewHolder, h2, i3, i4) : expandableSwipeableItemAdapter.a(viewHolder, h2, e2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public boolean s0(int i2, boolean z) {
        if (this.f25459j.p(i2) || !this.f25457h.u(i2, z)) {
            return false;
        }
        if (this.f25459j.e(i2)) {
            N(this.f25459j.h(ExpandableAdapterHelper.g(i2)) + 1, this.f25459j.f(i2));
        }
        H(this.f25459j.h(ExpandableAdapterHelper.g(i2)));
        RecyclerViewExpandableItemManager.OnGroupExpandListener onGroupExpandListener = this.o;
        if (onGroupExpandListener != null) {
            onGroupExpandListener.a(i2, z);
        }
        return true;
    }

    public void t(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4) {
        ExpandableItemAdapter expandableItemAdapter = this.f25457h;
        if (expandableItemAdapter instanceof ExpandableSwipeableItemAdapter) {
            ExpandableSwipeableItemAdapter expandableSwipeableItemAdapter = (ExpandableSwipeableItemAdapter) expandableItemAdapter;
            long g2 = this.f25459j.g(i2);
            int h2 = ExpandableAdapterHelper.h(g2);
            int e2 = ExpandableAdapterHelper.e(g2);
            if (e2 == -1) {
                expandableSwipeableItemAdapter.e(viewHolder, h2, i3, i4);
            } else {
                expandableSwipeableItemAdapter.b(viewHolder, h2, e2, i3, i4);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public long u0(int i2) {
        return this.f25459j.g(i2);
    }

    /* access modifiers changed from: package-private */
    public int[] v0() {
        ExpandablePositionTranslator expandablePositionTranslator = this.f25459j;
        if (expandablePositionTranslator != null) {
            return expandablePositionTranslator.j();
        }
        return null;
    }

    public ItemDraggableRange w(RecyclerView.ViewHolder viewHolder, int i2) {
        ExpandableItemAdapter expandableItemAdapter = this.f25457h;
        if (!(expandableItemAdapter instanceof ExpandableDraggableItemAdapter) || expandableItemAdapter.getGroupCount() < 1) {
            return null;
        }
        ExpandableDraggableItemAdapter expandableDraggableItemAdapter = (ExpandableDraggableItemAdapter) this.f25457h;
        long g2 = this.f25459j.g(i2);
        int h2 = ExpandableAdapterHelper.h(g2);
        int e2 = ExpandableAdapterHelper.e(g2);
        if (e2 == -1) {
            ItemDraggableRange b2 = expandableDraggableItemAdapter.b(viewHolder, h2);
            if (b2 == null) {
                return new ItemDraggableRange(0, Math.max(0, (this.f25459j.i() - this.f25459j.k(Math.max(0, this.f25457h.getGroupCount() - 1))) - 1));
            } else if (z0(b2)) {
                long g3 = ExpandableAdapterHelper.g(b2.d());
                long g4 = ExpandableAdapterHelper.g(b2.c());
                int h3 = this.f25459j.h(g3);
                int h4 = this.f25459j.h(g4);
                if (b2.c() > h2) {
                    h4 += this.f25459j.k(b2.c());
                }
                this.f25460k = b2.d();
                this.f25461l = b2.c();
                return new ItemDraggableRange(h3, h4);
            } else {
                throw new IllegalStateException("Invalid range specified: " + b2);
            }
        } else {
            ItemDraggableRange f2 = expandableDraggableItemAdapter.f(viewHolder, h2, e2);
            if (f2 == null) {
                return new ItemDraggableRange(1, Math.max(1, this.f25459j.i() - 1));
            }
            if (z0(f2)) {
                long g5 = ExpandableAdapterHelper.g(f2.d());
                int h5 = this.f25459j.h(ExpandableAdapterHelper.g(f2.c())) + this.f25459j.k(f2.c());
                int min = Math.min(this.f25459j.h(g5) + 1, h5);
                this.f25460k = f2.d();
                this.f25461l = f2.c();
                return new ItemDraggableRange(min, h5);
            } else if (x0(f2)) {
                int max = Math.max(this.f25459j.k(h2) - 1, 0);
                int min2 = Math.min(f2.d(), max);
                int min3 = Math.min(f2.c(), max);
                long f3 = ExpandableAdapterHelper.f(h2, min2);
                long f4 = ExpandableAdapterHelper.f(h2, min3);
                int h6 = this.f25459j.h(f3);
                int h7 = this.f25459j.h(f4);
                this.f25462m = min2;
                this.f25463n = min3;
                return new ItemDraggableRange(h6, h7);
            } else {
                throw new IllegalStateException("Invalid range specified: " + f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int w0(long j2) {
        return this.f25459j.h(j2);
    }

    /* access modifiers changed from: package-private */
    public boolean y0(int i2) {
        return this.f25459j.p(i2);
    }
}

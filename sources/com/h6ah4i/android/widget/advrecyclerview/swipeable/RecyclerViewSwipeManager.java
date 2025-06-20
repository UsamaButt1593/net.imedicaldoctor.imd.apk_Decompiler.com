package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.SwipeDismissItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;

public class RecyclerViewSwipeManager {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 0;
    public static final int E = 65536;
    public static final int F = 131072;
    public static final int G = 0;
    public static final int H = 65537;
    public static final int I = 131074;
    public static final int J = 0;
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 0;
    public static final int N = 1;
    public static final int O = 2;
    public static final float P = -3.4028235E38f;
    public static final float Q = Float.MAX_VALUE;
    public static final int R = 1;
    public static final int S = 2;
    public static final int T = Integer.MIN_VALUE;
    private static final int U = 10;
    private static final int V = 8;
    private static final boolean W = false;
    private static final boolean X = false;
    private static final String v = "ARVSwipeManager";
    public static final int w = 0;
    public static final int x = 1;
    public static final int y = 2;
    public static final int z = 3;

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView.OnItemTouchListener f25491a = new RecyclerView.OnItemTouchListener() {
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            RecyclerViewSwipeManager.this.v(recyclerView, motionEvent);
        }

        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            return RecyclerViewSwipeManager.this.u(recyclerView, motionEvent);
        }

        public void e(boolean z) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f25492b;

    /* renamed from: c  reason: collision with root package name */
    private long f25493c = 300;

    /* renamed from: d  reason: collision with root package name */
    private long f25494d = 200;

    /* renamed from: e  reason: collision with root package name */
    private int f25495e;

    /* renamed from: f  reason: collision with root package name */
    private int f25496f;

    /* renamed from: g  reason: collision with root package name */
    private int f25497g;

    /* renamed from: h  reason: collision with root package name */
    private int f25498h;

    /* renamed from: i  reason: collision with root package name */
    private int f25499i;

    /* renamed from: j  reason: collision with root package name */
    private long f25500j = -1;

    /* renamed from: k  reason: collision with root package name */
    private ItemSlidingAnimator f25501k = new ItemSlidingAnimator();

    /* renamed from: l  reason: collision with root package name */
    private SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> f25502l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView.ViewHolder f25503m;

    /* renamed from: n  reason: collision with root package name */
    private int f25504n = -1;
    private Rect o = new Rect();
    private int p;
    private int q;
    private int r;
    private VelocityTracker s = VelocityTracker.obtain();
    private SwipingItemOperator t;
    private OnItemSwipeEventListener u;

    public interface OnItemSwipeEventListener {
        void a(int i2, int i3, int i4);

        void b(int i2);
    }

    private void A(RecyclerView.ViewHolder viewHolder, float f2, boolean z2) {
        ItemSlidingAnimator itemSlidingAnimator;
        boolean z3;
        if (f2 == -3.4028235E38f) {
            itemSlidingAnimator = this.f25501k;
            z3 = true;
        } else if (f2 == Float.MAX_VALUE) {
            itemSlidingAnimator = this.f25501k;
            z3 = false;
        } else if (f2 == 0.0f) {
            this.f25501k.p(viewHolder, z2, this.f25493c);
            return;
        } else {
            this.f25501k.s(viewHolder, f2);
            return;
        }
        itemSlidingAnimator.q(viewHolder, z3, z2, this.f25494d);
    }

    private void B(RecyclerView recyclerView, MotionEvent motionEvent, RecyclerView.ViewHolder viewHolder, int i2) {
        this.f25503m = viewHolder;
        this.f25504n = i2;
        int x2 = (int) (motionEvent.getX() + 0.5f);
        this.q = x2;
        this.p = x2;
        CustomRecyclerViewUtils.i(viewHolder.f15587a, this.o);
        SwipingItemOperator swipingItemOperator = new SwipingItemOperator(this, this.f25503m, this.f25504n, this.r);
        this.t = swipingItemOperator;
        swipingItemOperator.b();
        this.s.clear();
        this.s.addMovement(motionEvent);
        this.f25492b.getParent().requestDisallowInterceptTouchEvent(true);
        OnItemSwipeEventListener onItemSwipeEventListener = this.u;
        if (onItemSwipeEventListener != null) {
            onItemSwipeEventListener.b(i2);
        }
        this.f25502l.x0(this, viewHolder, i2);
    }

    private static boolean C() {
        return true;
    }

    private static int e(int i2, int i3) {
        if ((i3 != 2 && i3 != 1) || i2 == 2 || i2 == 3) {
            return i3;
        }
        return 0;
    }

    private void g(int i2) {
        ItemSlidingAnimator itemSlidingAnimator;
        boolean z2;
        RecyclerView.ViewHolder viewHolder;
        boolean z3;
        long j2;
        RecyclerView.ViewHolder viewHolder2 = this.f25503m;
        if (viewHolder2 != null) {
            RecyclerView recyclerView = this.f25492b;
            int i3 = 0;
            if (!(recyclerView == null || recyclerView.getParent() == null)) {
                this.f25492b.getParent().requestDisallowInterceptTouchEvent(false);
            }
            int i4 = this.f25504n;
            this.s.clear();
            this.f25503m = null;
            this.f25504n = -1;
            this.q = 0;
            this.f25498h = 0;
            this.p = 0;
            this.f25500j = -1;
            this.r = 0;
            SwipingItemOperator swipingItemOperator = this.t;
            if (swipingItemOperator != null) {
                swipingItemOperator.a();
                this.t = null;
            }
            boolean z4 = i2 == 2;
            SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> swipeableItemWrapperAdapter = this.f25502l;
            if (swipeableItemWrapperAdapter != null) {
                i3 = swipeableItemWrapperAdapter.v0(viewHolder2, i4, i2);
            }
            int e2 = e(i2, i3);
            if (e2 != 0) {
                if (e2 == 1) {
                    RecyclerView.ItemAnimator itemAnimator = this.f25492b.getItemAnimator();
                    long p2 = itemAnimator != null ? itemAnimator.p() : 0;
                    if (C()) {
                        RemovingItemDecorator removingItemDecorator = new RemovingItemDecorator(this.f25492b, viewHolder2, p2, itemAnimator != null ? itemAnimator.o() : 0);
                        removingItemDecorator.t(SwipeDismissItemAnimator.s);
                        removingItemDecorator.u();
                    }
                    itemSlidingAnimator = this.f25501k;
                    z2 = true;
                    viewHolder = viewHolder2;
                    z3 = z4;
                    j2 = p2;
                } else if (e2 == 2) {
                    itemSlidingAnimator = this.f25501k;
                    z2 = true;
                    j2 = this.f25494d;
                    viewHolder = viewHolder2;
                    z3 = z4;
                } else {
                    throw new IllegalStateException("Unknwon after reaction type: " + e2);
                }
                itemSlidingAnimator.q(viewHolder, z3, z2, j2);
            } else {
                this.f25501k.p(viewHolder2, true, this.f25493c);
            }
            SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> swipeableItemWrapperAdapter2 = this.f25502l;
            if (swipeableItemWrapperAdapter2 != null) {
                swipeableItemWrapperAdapter2.w0(viewHolder2, i4, i2, e2);
            }
            OnItemSwipeEventListener onItemSwipeEventListener = this.u;
            if (onItemSwipeEventListener != null) {
                onItemSwipeEventListener.a(i4, i2, e2);
            }
        }
    }

    private static SwipeableItemWrapperAdapter l(RecyclerView recyclerView) {
        return (SwipeableItemWrapperAdapter) WrapperAdapterUtils.a(recyclerView.getAdapter(), SwipeableItemWrapperAdapter.class);
    }

    private boolean m(RecyclerView recyclerView, MotionEvent motionEvent) {
        int j2;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        RecyclerView.ViewHolder a2 = CustomRecyclerViewUtils.a(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (!(a2 instanceof SwipeableItemViewHolder) || (j2 = CustomRecyclerViewUtils.j(a2)) < 0 || j2 >= adapter.b() || a2.E() != adapter.B(j2)) {
            return false;
        }
        int x2 = (int) (motionEvent.getX() + 0.5f);
        int y2 = (int) (motionEvent.getY() + 0.5f);
        View view = a2.f15587a;
        int C0 = (int) (ViewCompat.C0(view) + 0.5f);
        int left = view.getLeft();
        int top = y2 - (view.getTop() + C0);
        int s0 = this.f25502l.s0(a2, j2, x2 - (left + ((int) (ViewCompat.B0(view) + 0.5f))), top);
        if (s0 == 0) {
            return false;
        }
        this.f25498h = x2;
        this.f25499i = y2;
        this.f25500j = a2.E();
        this.r = s0;
        return true;
    }

    private boolean n(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f25500j == -1) {
            return false;
        }
        if (Math.abs(motionEvent.getY() - ((float) this.f25499i)) > ((float) this.f25495e)) {
            this.f25500j = -1;
            return false;
        } else if (Math.abs(motionEvent.getX() - ((float) this.f25498h)) <= ((float) this.f25495e)) {
            return false;
        } else {
            RecyclerView.ViewHolder a2 = CustomRecyclerViewUtils.a(recyclerView, motionEvent.getX(), motionEvent.getY());
            if (a2 == null || a2.E() != this.f25500j) {
                this.f25500j = -1;
                return false;
            }
            int j2 = CustomRecyclerViewUtils.j(a2);
            if (j2 == -1) {
                return false;
            }
            B(recyclerView, motionEvent, a2, j2);
            return true;
        }
    }

    private void o(MotionEvent motionEvent) {
        this.q = (int) (motionEvent.getX() + 0.5f);
        this.s.addMovement(motionEvent);
        this.t.c(this.q - this.p);
    }

    private void p() {
        this.f25500j = -1;
        this.r = 0;
    }

    private boolean q(MotionEvent motionEvent) {
        int i2;
        this.q = (int) (motionEvent.getX() + 0.5f);
        if (MotionEventCompat.c(motionEvent) == 1) {
            int width = this.f25503m.f15587a.getWidth();
            float f2 = (float) (this.q - this.f25498h);
            float abs = Math.abs(f2);
            this.s.computeCurrentVelocity(1000, (float) this.f25497g);
            float xVelocity = this.s.getXVelocity();
            float abs2 = Math.abs(xVelocity);
            if (abs > ((float) (this.f25495e * 10)) && xVelocity * f2 > 0.0f && abs2 <= ((float) this.f25497g)) {
                i2 = 2;
                if (abs > ((float) (width / 2)) || abs2 >= ((float) this.f25496f)) {
                    if (f2 >= 0.0f || !SwipeReactionUtils.a(this.r)) {
                        if (f2 > 0.0f && SwipeReactionUtils.b(this.r)) {
                            i2 = 3;
                        }
                    }
                    g(i2);
                    return true;
                }
            }
        }
        i2 = 1;
        g(i2);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r10 < 0.0f) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r9 < 0.0f) goto L_0x001b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.recyclerview.widget.RecyclerView.ViewHolder r7, int r8, float r9, float r10, boolean r11) {
        /*
            r6 = this;
            r0 = r7
            com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder r0 = (com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemViewHolder) r0
            android.view.View r1 = r0.e()
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            r1 = 2
            r2 = 1
            r3 = 0
            int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x001e
            int r5 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0017
            r9 = 0
            goto L_0x0023
        L_0x0017:
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x001c
        L_0x001b:
            r1 = 1
        L_0x001c:
            r9 = r1
            goto L_0x0023
        L_0x001e:
            int r9 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r9 >= 0) goto L_0x001c
            goto L_0x001b
        L_0x0023:
            if (r4 != 0) goto L_0x002e
            r6.A(r7, r10, r11)
            com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemWrapperAdapter<androidx.recyclerview.widget.RecyclerView$ViewHolder> r10 = r6.f25502l
            r10.z0(r7, r8, r9)
            goto L_0x0046
        L_0x002e:
            float r1 = r0.n()
            float r10 = java.lang.Math.max(r10, r1)
            float r0 = r0.b()
            float r10 = java.lang.Math.min(r10, r0)
            com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemWrapperAdapter<androidx.recyclerview.widget.RecyclerView$ViewHolder> r0 = r6.f25502l
            r0.z0(r7, r8, r9)
            r6.A(r7, r10, r11)
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager.a(androidx.recyclerview.widget.RecyclerView$ViewHolder, int, float, float, boolean):void");
    }

    public void b(RecyclerView recyclerView) {
        if (recyclerView == null) {
            throw new IllegalArgumentException("RecyclerView cannot be null");
        } else if (s()) {
            throw new IllegalStateException("Accessing released object");
        } else if (this.f25492b != null) {
            throw new IllegalStateException("RecyclerView instance has already been set");
        } else if (this.f25502l == null || l(recyclerView) != this.f25502l) {
            throw new IllegalStateException("adapter is not set properly");
        } else {
            this.f25492b = recyclerView;
            recyclerView.s(this.f25491a);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(recyclerView.getContext());
            this.f25495e = viewConfiguration.getScaledTouchSlop();
            this.f25496f = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f25497g = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f25501k.l((int) ((recyclerView.getResources().getDisplayMetrics().density * 8.0f) + 0.5f));
        }
    }

    /* access modifiers changed from: package-private */
    public void c(RecyclerView.ViewHolder viewHolder) {
        ItemSlidingAnimator itemSlidingAnimator = this.f25501k;
        if (itemSlidingAnimator != null) {
            itemSlidingAnimator.e(viewHolder);
        }
    }

    public void d() {
        g(1);
    }

    public RecyclerView.Adapter f(RecyclerView.Adapter adapter) {
        if (this.f25502l == null) {
            SwipeableItemWrapperAdapter<RecyclerView.ViewHolder> swipeableItemWrapperAdapter = new SwipeableItemWrapperAdapter<>(this, adapter);
            this.f25502l = swipeableItemWrapperAdapter;
            return swipeableItemWrapperAdapter;
        }
        throw new IllegalStateException("already have a wrapped adapter");
    }

    public long h() {
        return this.f25494d;
    }

    public OnItemSwipeEventListener i() {
        return this.u;
    }

    public long j() {
        return this.f25493c;
    }

    /* access modifiers changed from: package-private */
    public int k(RecyclerView.ViewHolder viewHolder) {
        return this.f25501k.h(viewHolder);
    }

    /* access modifiers changed from: package-private */
    public boolean r(RecyclerView.ViewHolder viewHolder) {
        ItemSlidingAnimator itemSlidingAnimator = this.f25501k;
        return itemSlidingAnimator != null && itemSlidingAnimator.k(viewHolder);
    }

    public boolean s() {
        return this.f25491a == null;
    }

    public boolean t() {
        return this.f25503m != null;
    }

    /* access modifiers changed from: package-private */
    public boolean u(RecyclerView recyclerView, MotionEvent motionEvent) {
        int c2 = MotionEventCompat.c(motionEvent);
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        return false;
                    }
                } else if (!t()) {
                    return n(recyclerView, motionEvent);
                } else {
                    o(motionEvent);
                    return true;
                }
            }
            if (t()) {
                q(motionEvent);
                return true;
            }
            p();
            return false;
        } else if (t()) {
            return false;
        } else {
            m(recyclerView, motionEvent);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void v(RecyclerView recyclerView, MotionEvent motionEvent) {
        int c2 = MotionEventCompat.c(motionEvent);
        if (t()) {
            if (c2 != 1) {
                if (c2 == 2) {
                    o(motionEvent);
                    return;
                } else if (c2 != 3) {
                    return;
                }
            }
            q(motionEvent);
        }
    }

    public void w() {
        RecyclerView.OnItemTouchListener onItemTouchListener;
        RecyclerView recyclerView = this.f25492b;
        if (!(recyclerView == null || (onItemTouchListener = this.f25491a) == null)) {
            recyclerView.D1(onItemTouchListener);
        }
        this.f25491a = null;
        VelocityTracker velocityTracker = this.s;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.s = null;
        }
        ItemSlidingAnimator itemSlidingAnimator = this.f25501k;
        if (itemSlidingAnimator != null) {
            itemSlidingAnimator.f();
            this.f25501k = null;
        }
        this.f25502l = null;
        this.f25492b = null;
    }

    public void x(long j2) {
        this.f25494d = j2;
    }

    public void y(OnItemSwipeEventListener onItemSwipeEventListener) {
        this.u = onItemSwipeEventListener;
    }

    public void z(long j2) {
        this.f25493c = j2;
    }
}

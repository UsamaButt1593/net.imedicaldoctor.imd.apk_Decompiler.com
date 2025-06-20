package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.event.RecyclerViewOnScrollEventDistributor;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;
import java.lang.ref.WeakReference;

public class RecyclerViewDragDropManager {
    private static final String N = "ARVDragDropManager";
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 4;
    public static final int R = Integer.MIN_VALUE;
    public static final Interpolator S = new BasicSwapTargetTranslationInterpolator();
    public static final Interpolator T = new DecelerateInterpolator();
    private static final int U = 0;
    private static final int V = 1;
    private static final int W = 2;
    private static final boolean X = false;
    private static final boolean Y = false;
    private static final float Z = 0.3f;
    private static final float a0 = 25.0f;
    private static final float b0 = 1.5f;
    private SwapTargetItemOperator A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F = 0;
    private int G;
    private int H;
    private int I;
    private ItemDraggableRange J;
    private InternalHandler K;
    private OnItemDragEventListener L;
    private Runnable M = new Runnable() {
        public void run() {
            if (RecyclerViewDragDropManager.this.x != null) {
                RecyclerViewDragDropManager recyclerViewDragDropManager = RecyclerViewDragDropManager.this;
                recyclerViewDragDropManager.m(recyclerViewDragDropManager.f25406a);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f25406a;

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f25407b = S;

    /* renamed from: c  reason: collision with root package name */
    private ScrollOnDraggingProcessRunnable f25408c = new ScrollOnDraggingProcessRunnable(this);

    /* renamed from: d  reason: collision with root package name */
    private boolean f25409d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView.OnItemTouchListener f25410e = new RecyclerView.OnItemTouchListener() {
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            RecyclerViewDragDropManager.this.M(recyclerView, motionEvent);
        }

        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            return RecyclerViewDragDropManager.this.H(recyclerView, motionEvent);
        }

        public void e(boolean z) {
            RecyclerViewDragDropManager.this.J(z);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.OnScrollListener f25411f = new RecyclerView.OnScrollListener() {
        public void a(RecyclerView recyclerView, int i2) {
            RecyclerViewDragDropManager.this.K(recyclerView, i2);
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
            RecyclerViewDragDropManager.this.L(recyclerView, i2, i3);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private EdgeEffectDecorator f25412g;

    /* renamed from: h  reason: collision with root package name */
    private NinePatchDrawable f25413h;

    /* renamed from: i  reason: collision with root package name */
    private float f25414i;

    /* renamed from: j  reason: collision with root package name */
    private int f25415j;

    /* renamed from: k  reason: collision with root package name */
    private int f25416k;

    /* renamed from: l  reason: collision with root package name */
    private int f25417l;

    /* renamed from: m  reason: collision with root package name */
    private long f25418m = -1;

    /* renamed from: n  reason: collision with root package name */
    private boolean f25419n;
    private boolean o = true;
    private boolean p;
    private int q;
    private Rect r = new Rect();
    /* access modifiers changed from: private */
    public Runnable s;
    private int t = 200;
    private Interpolator u = T;
    private DraggableItemWrapperAdapter v;
    private long w = -1;
    /* access modifiers changed from: private */
    public RecyclerView.ViewHolder x;
    private Rect y = new Rect();
    private DraggingItemDecorator z;

    private static class InternalHandler extends Handler {

        /* renamed from: c  reason: collision with root package name */
        private static final int f25422c = ViewConfiguration.getLongPressTimeout();

        /* renamed from: d  reason: collision with root package name */
        private static final int f25423d = 1;

        /* renamed from: a  reason: collision with root package name */
        private RecyclerViewDragDropManager f25424a;

        /* renamed from: b  reason: collision with root package name */
        private MotionEvent f25425b;

        public InternalHandler(RecyclerViewDragDropManager recyclerViewDragDropManager) {
            this.f25424a = recyclerViewDragDropManager;
        }

        public void a() {
            removeMessages(1);
            MotionEvent motionEvent = this.f25425b;
            if (motionEvent != null) {
                motionEvent.recycle();
                this.f25425b = null;
            }
        }

        public void b() {
            removeCallbacks((Runnable) null);
            this.f25424a = null;
        }

        public void c(MotionEvent motionEvent) {
            a();
            this.f25425b = MotionEvent.obtain(motionEvent);
            sendEmptyMessageAtTime(1, motionEvent.getDownTime() + ((long) f25422c));
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                this.f25424a.A(this.f25425b);
            }
        }
    }

    public interface OnItemDragEventListener {
        void a(int i2);

        void b(int i2, int i3, boolean z);
    }

    private static class ScrollOnDraggingProcessRunnable implements Runnable {
        private boolean X;
        private final WeakReference<RecyclerViewDragDropManager> s;

        public ScrollOnDraggingProcessRunnable(RecyclerViewDragDropManager recyclerViewDragDropManager) {
            this.s = new WeakReference<>(recyclerViewDragDropManager);
        }

        public void a() {
            this.s.clear();
            this.X = false;
        }

        public void b() {
            RecyclerViewDragDropManager recyclerViewDragDropManager;
            RecyclerView v;
            if (!this.X && (recyclerViewDragDropManager = this.s.get()) != null && (v = recyclerViewDragDropManager.v()) != null) {
                ViewCompat.v1(v, this);
                this.X = true;
            }
        }

        public void c() {
            if (this.X) {
                this.X = false;
            }
        }

        public void run() {
            RecyclerViewDragDropManager recyclerViewDragDropManager = this.s.get();
            if (recyclerViewDragDropManager != null && this.X) {
                recyclerViewDragDropManager.B();
                RecyclerView v = recyclerViewDragDropManager.v();
                if (v == null || !this.X) {
                    this.X = false;
                } else {
                    ViewCompat.v1(v, this);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void A(MotionEvent motionEvent) {
        if (this.f25419n) {
            l(this.f25406a, motionEvent, false);
        }
    }

    private static void O(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView != null ? recyclerView.getItemAnimator() : null;
        if (itemAnimator != null) {
            itemAnimator.k(viewHolder);
        }
    }

    private static void P(RecyclerView recyclerView) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView != null ? recyclerView.getItemAnimator() : null;
        if (itemAnimator != null) {
            itemAnimator.l();
        }
    }

    private int Q(int i2) {
        this.q = 0;
        this.p = true;
        this.f25406a.scrollBy(0, i2);
        this.p = false;
        return this.q;
    }

    private void Z(RecyclerView recyclerView, MotionEvent motionEvent, RecyclerView.ViewHolder viewHolder, ItemDraggableRange itemDraggableRange) {
        O(recyclerView, viewHolder);
        this.K.a();
        this.x = viewHolder;
        this.w = viewHolder.E();
        this.J = itemDraggableRange;
        View view = this.x.f15587a;
        this.I = ViewCompat.l0(recyclerView);
        ViewCompat.m2(recyclerView, 2);
        int y2 = (int) (motionEvent.getY() + 0.5f);
        this.B = y2;
        this.E = y2;
        this.D = y2;
        this.C = y2;
        this.F = 0;
        this.G = y2 - view.getTop();
        this.H = view.getHeight();
        CustomRecyclerViewUtils.i(view, this.y);
        this.f25406a.getParent().requestDisallowInterceptTouchEvent(true);
        a0();
        this.v.B0(this.x, this.J);
        DraggableItemWrapperAdapter draggableItemWrapperAdapter = this.v;
        RecyclerView.ViewHolder viewHolder2 = this.x;
        draggableItemWrapperAdapter.R(viewHolder2, viewHolder2.G());
        DraggingItemDecorator draggingItemDecorator = new DraggingItemDecorator(this.f25406a, this.x, this.J);
        this.z = draggingItemDecorator;
        draggingItemDecorator.D(this.f25413h);
        this.z.E(motionEvent, (float) this.G);
        if (d0()) {
            SwapTargetItemOperator swapTargetItemOperator = new SwapTargetItemOperator(this.f25406a, this.x, this.J);
            this.A = swapTargetItemOperator;
            swapTargetItemOperator.t(this.f25407b);
            this.A.u();
            this.A.v(this.z.u());
        }
        EdgeEffectDecorator edgeEffectDecorator = this.f25412g;
        if (edgeEffectDecorator != null) {
            edgeEffectDecorator.s();
        }
        OnItemDragEventListener onItemDragEventListener = this.L;
        if (onItemDragEventListener != null) {
            onItemDragEventListener.a(this.v.v0());
        }
    }

    private void a0() {
        this.f25408c.b();
    }

    private void b0() {
        ScrollOnDraggingProcessRunnable scrollOnDraggingProcessRunnable = this.f25408c;
        if (scrollOnDraggingProcessRunnable != null) {
            scrollOnDraggingProcessRunnable.c();
        }
    }

    private static boolean c0() {
        return true;
    }

    private static boolean d0() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0082, code lost:
        r12 = r11.getChildAt(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e0(androidx.recyclerview.widget.RecyclerView r11, androidx.recyclerview.widget.RecyclerView.ViewHolder r12, androidx.recyclerview.widget.RecyclerView.ViewHolder r13) {
        /*
            r10 = this;
            android.view.View r0 = r13.f15587a
            android.graphics.Rect r1 = r10.r
            android.graphics.Rect r0 = com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils.i(r0, r1)
            int r1 = r12.B()
            int r2 = r13.B()
            int r3 = r1 - r2
            int r3 = java.lang.Math.abs(r3)
            r4 = -1
            if (r1 == r4) goto L_0x00c1
            if (r2 != r4) goto L_0x001d
            goto L_0x00c1
        L_0x001d:
            androidx.recyclerview.widget.RecyclerView$Adapter r5 = r11.getAdapter()
            long r5 = r5.B(r1)
            long r7 = r10.w
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x002c
            return
        L_0x002c:
            if (r3 != 0) goto L_0x0030
            goto L_0x00c1
        L_0x0030:
            r5 = 1
            if (r3 != r5) goto L_0x007c
            android.view.View r12 = r12.f15587a
            android.view.View r3 = r13.f15587a
            android.graphics.Rect r5 = r10.y
            int r6 = r12.getTop()
            int r7 = r5.top
            int r6 = r6 - r7
            int r7 = r3.getTop()
            int r8 = r0.top
            int r7 = r7 - r8
            int r6 = java.lang.Math.min(r6, r7)
            int r12 = r12.getBottom()
            int r5 = r5.bottom
            int r12 = r12 + r5
            int r3 = r3.getBottom()
            int r5 = r0.bottom
            int r3 = r3 + r5
            int r12 = java.lang.Math.max(r12, r3)
            float r3 = (float) r6
            int r12 = r12 - r6
            float r12 = (float) r12
            r5 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 * r5
            float r3 = r3 + r12
            int r12 = r10.B
            int r6 = r10.G
            int r12 = r12 - r6
            float r12 = (float) r12
            int r6 = r10.H
            float r6 = (float) r6
            float r6 = r6 * r5
            float r12 = r12 + r6
            if (r2 >= r1) goto L_0x0078
            int r12 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x00c1
            goto L_0x007c
        L_0x0078:
            int r12 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r12 <= 0) goto L_0x00c1
        L_0x007c:
            int r12 = r11.getChildCount()
            if (r12 <= 0) goto L_0x008e
            r12 = 0
            android.view.View r12 = r11.getChildAt(r12)
            if (r12 == 0) goto L_0x008e
            androidx.recyclerview.widget.RecyclerView$ViewHolder r12 = r11.y0(r12)
            goto L_0x008f
        L_0x008e:
            r12 = 0
        L_0x008f:
            if (r12 == 0) goto L_0x0095
            int r4 = r12.B()
        L_0x0095:
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemWrapperAdapter r12 = r10.v
            r12.z0(r1, r2)
            P(r11)
            if (r1 != r4) goto L_0x00b0
            android.view.View r12 = r13.f15587a
            int r12 = r12.getHeight()
            int r13 = r0.top
            int r12 = r12 + r13
            int r13 = r0.bottom
            int r12 = r12 + r13
            int r12 = -r12
        L_0x00ac:
            r10.Q(r12)
            goto L_0x00be
        L_0x00b0:
            if (r2 != r4) goto L_0x00be
            android.graphics.Rect r12 = r10.y
            int r13 = r10.H
            int r0 = r12.top
            int r13 = r13 + r0
            int r12 = r12.bottom
            int r13 = r13 + r12
            int r12 = -r13
            goto L_0x00ac
        L_0x00be:
            P(r11)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.e0(androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.RecyclerView$ViewHolder):void");
    }

    private void f0() {
        int i2 = this.C;
        int i3 = this.D;
        int i4 = i2 - i3;
        int i5 = this.f25416k;
        if (i4 > i5 || this.E - this.B > i5) {
            this.F |= 1;
        }
        if (this.E - i2 > i5 || this.B - i3 > i5) {
            this.F |= 2;
        }
    }

    private void g0(float f2) {
        if (f2 == 0.0f) {
            this.f25412g.r();
        } else if (f2 < 0.0f) {
            this.f25412g.q(f2);
        } else {
            this.f25412g.p(f2);
        }
    }

    private void h0(ItemDraggableRange itemDraggableRange, RecyclerView.ViewHolder viewHolder) {
        int max = Math.max(0, this.v.b() - 1);
        if (itemDraggableRange.d() > itemDraggableRange.c()) {
            throw new IllegalStateException("Invalid range specified --- start > range (range = " + itemDraggableRange + ")");
        } else if (itemDraggableRange.d() < 0) {
            throw new IllegalStateException("Invalid range specified --- start < 0 (range = " + itemDraggableRange + ")");
        } else if (itemDraggableRange.c() > max) {
            throw new IllegalStateException("Invalid range specified --- end >= count (range = " + itemDraggableRange + ")");
        } else if (!itemDraggableRange.a(viewHolder.B())) {
            throw new IllegalStateException("Invalid range specified --- does not contain drag target item (range = " + itemDraggableRange + ", position = " + viewHolder.B() + ")");
        }
    }

    private void k(boolean z2) {
        if (z2) {
            q(false);
        } else if (C() && this.s == null) {
            AnonymousClass3 r2 = new Runnable() {
                public void run() {
                    if (RecyclerViewDragDropManager.this.s == this) {
                        Runnable unused = RecyclerViewDragDropManager.this.s = null;
                        RecyclerViewDragDropManager.this.q(false);
                    }
                }
            };
            this.s = r2;
            this.f25406a.post(r2);
        }
    }

    private boolean l(RecyclerView recyclerView, MotionEvent motionEvent, boolean z2) {
        if (this.x != null) {
            return false;
        }
        int x2 = (int) (motionEvent.getX() + 0.5f);
        int y2 = (int) (motionEvent.getY() + 0.5f);
        this.B = y2;
        if (this.f25418m == -1) {
            return false;
        }
        if (z2 && Math.abs(y2 - this.f25417l) <= this.f25415j) {
            return false;
        }
        RecyclerView.ViewHolder b2 = CustomRecyclerViewUtils.b(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (!n(recyclerView, b2) || b2.E() != this.f25418m) {
            this.f25418m = -1;
            this.K.a();
            return false;
        }
        int j2 = CustomRecyclerViewUtils.j(b2);
        if (j2 == -1) {
            return false;
        }
        View view = b2.f15587a;
        int C0 = (int) (ViewCompat.C0(view) + 0.5f);
        int left = view.getLeft();
        if (!this.v.q0(b2, j2, x2 - (left + ((int) (ViewCompat.B0(view) + 0.5f))), y2 - (view.getTop() + C0))) {
            return false;
        }
        ItemDraggableRange w0 = this.v.w0(b2, j2);
        if (w0 == null) {
            w0 = new ItemDraggableRange(0, Math.max(0, this.v.b() - 1));
        }
        h0(w0, b2);
        Z(recyclerView, motionEvent, b2, w0);
        return true;
    }

    /* access modifiers changed from: private */
    public void m(RecyclerView recyclerView) {
        RecyclerView.ViewHolder viewHolder = this.x;
        RecyclerView recyclerView2 = recyclerView;
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        RecyclerView.ViewHolder p2 = p(recyclerView2, viewHolder2, this.w, this.B - this.G, this.J);
        if (p2 != null && p2 != this.x) {
            e0(recyclerView, viewHolder, p2);
        }
    }

    private boolean n(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (!(viewHolder instanceof DraggableItemViewHolder)) {
            return false;
        }
        int B2 = viewHolder.B();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        return B2 >= 0 && B2 < adapter.b() && viewHolder.E() == adapter.B(B2);
    }

    static RecyclerView.ViewHolder p(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, long j2, int i2, ItemDraggableRange itemDraggableRange) {
        RecyclerView.ViewHolder viewHolder2;
        int i3;
        int B2 = viewHolder.B();
        int top = viewHolder.f15587a.getTop();
        if (B2 != -1 && viewHolder.E() == j2) {
            if (i2 < top) {
                if (B2 > 0) {
                    i3 = B2 - 1;
                }
            } else if (i2 > top && B2 < recyclerView.getAdapter().b() - 1) {
                i3 = B2 + 1;
            }
            viewHolder2 = recyclerView.m0(i3);
            if (viewHolder2 != null || itemDraggableRange == null || itemDraggableRange.a(viewHolder2.B())) {
                return viewHolder2;
            }
            return null;
        }
        viewHolder2 = null;
        if (viewHolder2 != null) {
        }
        return viewHolder2;
    }

    /* access modifiers changed from: private */
    public void q(boolean z2) {
        int i2;
        int i3;
        RecyclerView.ViewHolder viewHolder = this.x;
        if (viewHolder == null) {
            z2 = false;
        }
        Runnable runnable = this.s;
        if (runnable != null) {
            this.f25406a.removeCallbacks(runnable);
            this.s = null;
        }
        RecyclerView recyclerView = this.f25406a;
        if (!(recyclerView == null || this.x == null)) {
            ViewCompat.m2(recyclerView, this.I);
        }
        DraggingItemDecorator draggingItemDecorator = this.z;
        if (draggingItemDecorator != null) {
            draggingItemDecorator.n(this.t);
            this.z.o(this.u);
            this.z.t(true);
        }
        SwapTargetItemOperator swapTargetItemOperator = this.A;
        if (swapTargetItemOperator != null) {
            swapTargetItemOperator.n(this.t);
            this.z.o(this.u);
            this.A.s(true);
        }
        EdgeEffectDecorator edgeEffectDecorator = this.f25412g;
        if (edgeEffectDecorator != null) {
            edgeEffectDecorator.r();
        }
        b0();
        RecyclerView recyclerView2 = this.f25406a;
        if (!(recyclerView2 == null || recyclerView2.getParent() == null)) {
            this.f25406a.getParent().requestDisallowInterceptTouchEvent(false);
        }
        RecyclerView recyclerView3 = this.f25406a;
        if (recyclerView3 != null) {
            recyclerView3.invalidate();
        }
        this.J = null;
        this.z = null;
        this.A = null;
        this.x = null;
        this.w = -1;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.G = 0;
        this.H = 0;
        DraggableItemWrapperAdapter draggableItemWrapperAdapter = this.v;
        if (draggableItemWrapperAdapter != null) {
            i3 = draggableItemWrapperAdapter.v0();
            i2 = this.v.u0();
            this.v.A0(viewHolder, z2);
        } else {
            i3 = -1;
            i2 = -1;
        }
        OnItemDragEventListener onItemDragEventListener = this.L;
        if (onItemDragEventListener != null) {
            onItemDragEventListener.b(i3, i2, z2);
        }
    }

    private static DraggableItemWrapperAdapter r(RecyclerView recyclerView) {
        return (DraggableItemWrapperAdapter) WrapperAdapterUtils.a(recyclerView.getAdapter(), DraggableItemWrapperAdapter.class);
    }

    private boolean w(RecyclerView recyclerView, MotionEvent motionEvent) {
        RecyclerView.ViewHolder b2 = CustomRecyclerViewUtils.b(recyclerView, motionEvent.getX(), motionEvent.getY());
        if (!n(recyclerView, b2)) {
            return false;
        }
        int y2 = (int) (motionEvent.getY() + 0.5f);
        this.B = y2;
        this.f25417l = y2;
        this.f25418m = b2.E();
        if (!this.f25419n) {
            return true;
        }
        this.K.c(motionEvent);
        return true;
    }

    private void x(RecyclerView recyclerView, MotionEvent motionEvent) {
        int y2 = (int) (motionEvent.getY() + 0.5f);
        this.B = y2;
        this.D = Math.min(this.D, y2);
        this.E = Math.max(this.E, this.B);
        f0();
        this.z.F(motionEvent);
        SwapTargetItemOperator swapTargetItemOperator = this.A;
        if (swapTargetItemOperator != null) {
            swapTargetItemOperator.v(this.z.u());
        }
        m(recyclerView);
    }

    private boolean y(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.o) {
            return l(recyclerView, motionEvent, true);
        }
        return false;
    }

    private boolean z(RecyclerView recyclerView, MotionEvent motionEvent) {
        boolean z2 = MotionEventCompat.c(motionEvent) == 1;
        this.K.a();
        this.f25417l = 0;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.f25418m = -1;
        if (C()) {
            q(z2);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B() {
        /*
            r15 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r15.f25406a
            int r1 = r0.getHeight()
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = (float) r1
            float r2 = r2 / r3
            int r3 = r15.B
            float r3 = (float) r3
            float r3 = r3 * r2
            r4 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 - r4
            float r5 = java.lang.Math.abs(r3)
            r6 = 1050253722(0x3e99999a, float:0.3)
            float r5 = r4 - r5
            float r6 = r6 - r5
            r5 = 0
            float r6 = java.lang.Math.max(r5, r6)
            r7 = 1079334229(0x40555555, float:3.3333333)
            float r6 = r6 * r7
            int r7 = r15.F
            float r3 = java.lang.Math.signum(r3)
            int r3 = (int) r3
            r8 = 1103626240(0x41c80000, float:25.0)
            float r9 = r15.f25414i
            float r9 = r9 * r8
            float r9 = r9 * r6
            float r9 = r9 + r4
            int r6 = (int) r9
            int r3 = r3 * r6
            com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange r6 = r15.J
            androidx.recyclerview.widget.RecyclerView r8 = r15.f25406a
            int r8 = com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils.d(r8)
            androidx.recyclerview.widget.RecyclerView r9 = r15.f25406a
            int r9 = com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils.f(r9)
            r10 = -1
            r11 = 0
            r12 = 1
            if (r8 == r10) goto L_0x0063
            int r13 = r6.d()
            if (r8 > r13) goto L_0x0057
            r13 = 1
            goto L_0x0058
        L_0x0057:
            r13 = 0
        L_0x0058:
            int r14 = r6.d()
            int r14 = r14 - r12
            if (r8 > r14) goto L_0x0061
            r14 = 1
            goto L_0x0065
        L_0x0061:
            r14 = 0
            goto L_0x0065
        L_0x0063:
            r13 = 0
            goto L_0x0061
        L_0x0065:
            if (r9 == r10) goto L_0x007b
            int r10 = r6.c()
            if (r9 < r10) goto L_0x006f
            r10 = 1
            goto L_0x0070
        L_0x006f:
            r10 = 0
        L_0x0070:
            int r6 = r6.c()
            int r6 = r6 + r12
            if (r9 < r6) goto L_0x0079
            r6 = 1
            goto L_0x007d
        L_0x0079:
            r6 = 0
            goto L_0x007d
        L_0x007b:
            r6 = 0
            r10 = 0
        L_0x007d:
            if (r3 <= 0) goto L_0x0085
            r7 = r7 & 2
            if (r7 != 0) goto L_0x008b
        L_0x0083:
            r3 = 0
            goto L_0x008b
        L_0x0085:
            if (r3 >= 0) goto L_0x008b
            r7 = r7 & r12
            if (r7 != 0) goto L_0x008b
            goto L_0x0083
        L_0x008b:
            if (r14 != 0) goto L_0x008f
            if (r3 < 0) goto L_0x0093
        L_0x008f:
            if (r6 != 0) goto L_0x00ba
            if (r3 <= 0) goto L_0x00ba
        L_0x0093:
            P(r0)
            int r0 = r15.Q(r3)
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggingItemDecorator r6 = r15.z
            if (r3 >= 0) goto L_0x00a4
            r7 = r13 ^ 1
        L_0x00a0:
            r6.C(r7)
            goto L_0x00a7
        L_0x00a4:
            r7 = r10 ^ 1
            goto L_0x00a0
        L_0x00a7:
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggingItemDecorator r6 = r15.z
            r6.A()
            com.h6ah4i.android.widget.advrecyclerview.draggable.SwapTargetItemOperator r6 = r15.A
            if (r6 == 0) goto L_0x00c0
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggingItemDecorator r7 = r15.z
            int r7 = r7.u()
            r6.v(r7)
            goto L_0x00c0
        L_0x00ba:
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggingItemDecorator r0 = r15.z
            r0.C(r11)
            r0 = 0
        L_0x00c0:
            if (r0 == 0) goto L_0x00c3
            r11 = 1
        L_0x00c3:
            com.h6ah4i.android.widget.advrecyclerview.draggable.EdgeEffectDecorator r0 = r15.f25412g
            if (r0 == 0) goto L_0x011a
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggingItemDecorator r0 = r15.z
            int r0 = r0.w()
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggingItemDecorator r6 = r15.z
            int r6 = r6.v()
            int r7 = r0 + r6
            int r7 = r7 / 2
            if (r8 != 0) goto L_0x00e0
            if (r9 != 0) goto L_0x00e0
            if (r3 >= 0) goto L_0x00de
            goto L_0x00e4
        L_0x00de:
            r0 = r6
            goto L_0x00e4
        L_0x00e0:
            int r1 = r1 / 2
            if (r7 >= r1) goto L_0x00de
        L_0x00e4:
            float r0 = (float) r0
            float r0 = r0 * r2
            float r0 = r0 - r4
            float r1 = java.lang.Math.abs(r0)
            r2 = 1053609165(0x3ecccccd, float:0.4)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0117
            if (r3 == 0) goto L_0x0117
            if (r11 != 0) goto L_0x0117
            r1 = 1000593162(0x3ba3d70a, float:0.005)
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x010c
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggingItemDecorator r0 = r15.z
            boolean r0 = r0.z()
            if (r0 == 0) goto L_0x0117
            float r0 = r15.f25414i
            float r0 = -r0
        L_0x0109:
            float r5 = r0 * r1
            goto L_0x0117
        L_0x010c:
            com.h6ah4i.android.widget.advrecyclerview.draggable.DraggingItemDecorator r0 = r15.z
            boolean r0 = r0.y()
            if (r0 == 0) goto L_0x0117
            float r0 = r15.f25414i
            goto L_0x0109
        L_0x0117:
            r15.g0(r5)
        L_0x011a:
            androidx.recyclerview.widget.RecyclerView r0 = r15.f25406a
            java.lang.Runnable r1 = r15.M
            androidx.core.view.ViewCompat.v1(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager.B():void");
    }

    public boolean C() {
        return this.w != -1 && this.s == null;
    }

    public boolean D() {
        return this.f25419n;
    }

    public boolean E() {
        return this.o;
    }

    public boolean F() {
        return this.f25410e == null;
    }

    /* access modifiers changed from: package-private */
    public void G() {
        this.z.x();
    }

    /* access modifiers changed from: package-private */
    public boolean H(RecyclerView recyclerView, MotionEvent motionEvent) {
        int c2 = MotionEventCompat.c(motionEvent);
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 != 3) {
                        return false;
                    }
                } else if (!C()) {
                    return y(recyclerView, motionEvent);
                } else {
                    x(recyclerView, motionEvent);
                    return true;
                }
            }
            z(recyclerView, motionEvent);
            return false;
        } else if (C()) {
            return false;
        } else {
            w(recyclerView, motionEvent);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void I(RecyclerView.ViewHolder viewHolder) {
        this.x = viewHolder;
        this.z.B(viewHolder);
    }

    /* access modifiers changed from: package-private */
    public void J(boolean z2) {
        if (z2) {
            k(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void K(RecyclerView recyclerView, int i2) {
    }

    /* access modifiers changed from: package-private */
    public void L(RecyclerView recyclerView, int i2, int i3) {
        if (this.p) {
            this.q = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public void M(RecyclerView recyclerView, MotionEvent motionEvent) {
        int c2 = MotionEventCompat.c(motionEvent);
        if (C()) {
            if (c2 != 1) {
                if (c2 == 2) {
                    x(recyclerView, motionEvent);
                    return;
                } else if (c2 != 3) {
                    return;
                }
            }
            z(recyclerView, motionEvent);
        }
    }

    public void N() {
        RecyclerView.OnScrollListener onScrollListener;
        RecyclerView.OnItemTouchListener onItemTouchListener;
        j();
        InternalHandler internalHandler = this.K;
        if (internalHandler != null) {
            internalHandler.b();
            this.K = null;
        }
        EdgeEffectDecorator edgeEffectDecorator = this.f25412g;
        if (edgeEffectDecorator != null) {
            edgeEffectDecorator.n();
            this.f25412g = null;
        }
        RecyclerView recyclerView = this.f25406a;
        if (!(recyclerView == null || (onItemTouchListener = this.f25410e) == null)) {
            recyclerView.D1(onItemTouchListener);
        }
        this.f25410e = null;
        RecyclerView recyclerView2 = this.f25406a;
        if (!(recyclerView2 == null || (onScrollListener = this.f25411f) == null || !this.f25409d)) {
            recyclerView2.E1(onScrollListener);
        }
        this.f25411f = null;
        ScrollOnDraggingProcessRunnable scrollOnDraggingProcessRunnable = this.f25408c;
        if (scrollOnDraggingProcessRunnable != null) {
            scrollOnDraggingProcessRunnable.a();
            this.f25408c = null;
        }
        this.v = null;
        this.f25406a = null;
        this.f25407b = null;
        this.f25409d = false;
    }

    public void R(NinePatchDrawable ninePatchDrawable) {
        this.f25413h = ninePatchDrawable;
    }

    public void S(boolean z2) {
        this.f25419n = z2;
    }

    public void T(boolean z2) {
        this.o = z2;
    }

    public void U(int i2) {
        this.t = i2;
    }

    public void V(Interpolator interpolator) {
        this.u = interpolator;
    }

    public void W(OnItemDragEventListener onItemDragEventListener) {
        this.L = onItemDragEventListener;
    }

    public Interpolator X() {
        return this.f25407b;
    }

    public void Y(Interpolator interpolator) {
        this.f25407b = interpolator;
    }

    public void h(RecyclerView recyclerView) {
        i(recyclerView, (RecyclerViewOnScrollEventDistributor) null);
    }

    @Deprecated
    public void i(RecyclerView recyclerView, RecyclerViewOnScrollEventDistributor recyclerViewOnScrollEventDistributor) {
        boolean z2;
        RecyclerView g2;
        if (recyclerView == null) {
            throw new IllegalArgumentException("RecyclerView cannot be null");
        } else if (F()) {
            throw new IllegalStateException("Accessing released object");
        } else if (this.f25406a != null) {
            throw new IllegalStateException("RecyclerView instance has already been set");
        } else if (this.v == null || r(recyclerView) != this.v) {
            throw new IllegalStateException("adapter is not set properly");
        } else if (recyclerViewOnScrollEventDistributor == null || (g2 = recyclerViewOnScrollEventDistributor.g()) == null || g2 == recyclerView) {
            this.f25406a = recyclerView;
            if (recyclerViewOnScrollEventDistributor != null) {
                recyclerViewOnScrollEventDistributor.a(this.f25411f);
                z2 = true;
            } else {
                recyclerView.t(this.f25411f);
                z2 = false;
            }
            this.f25409d = z2;
            this.f25406a.s(this.f25410e);
            this.f25414i = this.f25406a.getResources().getDisplayMetrics().density;
            int scaledTouchSlop = ViewConfiguration.get(this.f25406a.getContext()).getScaledTouchSlop();
            this.f25415j = scaledTouchSlop;
            this.f25416k = (int) ((((float) scaledTouchSlop) * b0) + 0.5f);
            this.K = new InternalHandler(this);
            if (c0()) {
                EdgeEffectDecorator edgeEffectDecorator = new EdgeEffectDecorator(this.f25406a);
                this.f25412g = edgeEffectDecorator;
                edgeEffectDecorator.t();
            }
        } else {
            throw new IllegalArgumentException("The scroll event distributor attached to different RecyclerView instance");
        }
    }

    public void j() {
        k(false);
    }

    public RecyclerView.Adapter o(RecyclerView.Adapter adapter) {
        if (this.v == null) {
            DraggableItemWrapperAdapter draggableItemWrapperAdapter = new DraggableItemWrapperAdapter(this, adapter);
            this.v = draggableItemWrapperAdapter;
            return draggableItemWrapperAdapter;
        }
        throw new IllegalStateException("already have a wrapped adapter");
    }

    public int s() {
        return this.t;
    }

    public Interpolator t() {
        return this.u;
    }

    public OnItemDragEventListener u() {
        return this.L;
    }

    /* access modifiers changed from: package-private */
    public RecyclerView v() {
        return this.f25406a;
    }
}

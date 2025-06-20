package com.h6ah4i.android.widget.advrecyclerview.touchguard;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewTouchActionGuardManager {

    /* renamed from: i  reason: collision with root package name */
    private static final String f25545i = "ARVTouchActionGuardMgr";

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f25546j = false;

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f25547k = false;

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView.OnItemTouchListener f25548a = new RecyclerView.OnItemTouchListener() {
        public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
            RecyclerViewTouchActionGuardManager.this.j(recyclerView, motionEvent);
        }

        public boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
            return RecyclerViewTouchActionGuardManager.this.i(recyclerView, motionEvent);
        }

        public void e(boolean z) {
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f25549b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25550c;

    /* renamed from: d  reason: collision with root package name */
    private int f25551d;

    /* renamed from: e  reason: collision with root package name */
    private int f25552e;

    /* renamed from: f  reason: collision with root package name */
    private int f25553f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25554g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f25555h;

    private void b(MotionEvent motionEvent) {
        int y = (int) (motionEvent.getY() + 0.5f);
        this.f25552e = y;
        this.f25551d = y;
        this.f25550c = false;
    }

    private boolean c(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.f25550c) {
            int y = (int) (motionEvent.getY() + 0.5f);
            this.f25552e = y;
            int i2 = y - this.f25551d;
            if (this.f25555h && Math.abs(i2) > this.f25553f && e(recyclerView)) {
                this.f25550c = true;
            }
        }
        return this.f25550c;
    }

    private void d() {
        this.f25550c = false;
        this.f25551d = 0;
        this.f25552e = 0;
    }

    private static boolean e(RecyclerView recyclerView) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        return itemAnimator != null && itemAnimator.q();
    }

    public void a(RecyclerView recyclerView) {
        if (recyclerView == null) {
            throw new IllegalArgumentException("RecyclerView cannot be null");
        } else if (h()) {
            throw new IllegalStateException("Accessing released object");
        } else if (this.f25549b == null) {
            this.f25549b = recyclerView;
            recyclerView.s(this.f25548a);
            this.f25553f = ViewConfiguration.get(recyclerView.getContext()).getScaledTouchSlop();
        } else {
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
    }

    public boolean f() {
        return this.f25554g;
    }

    public boolean g() {
        return this.f25555h;
    }

    public boolean h() {
        return this.f25548a == null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (r0 != 3) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(androidx.recyclerview.widget.RecyclerView r5, android.view.MotionEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.f25554g
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = androidx.core.view.MotionEventCompat.c(r6)
            if (r0 == 0) goto L_0x0021
            r2 = 1
            if (r0 == r2) goto L_0x001d
            r3 = 2
            if (r0 == r3) goto L_0x0016
            r5 = 3
            if (r0 == r5) goto L_0x001d
            goto L_0x0024
        L_0x0016:
            boolean r5 = r4.c(r5, r6)
            if (r5 == 0) goto L_0x0024
            return r2
        L_0x001d:
            r4.d()
            goto L_0x0024
        L_0x0021:
            r4.b(r6)
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.h6ah4i.android.widget.advrecyclerview.touchguard.RecyclerViewTouchActionGuardManager.i(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void j(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f25554g) {
            int c2 = MotionEventCompat.c(motionEvent);
            if (c2 == 1 || c2 == 3) {
                d();
            }
        }
    }

    public void k() {
        RecyclerView.OnItemTouchListener onItemTouchListener;
        RecyclerView recyclerView = this.f25549b;
        if (!(recyclerView == null || (onItemTouchListener = this.f25548a) == null)) {
            recyclerView.D1(onItemTouchListener);
        }
        this.f25548a = null;
        this.f25549b = null;
    }

    public void l(boolean z) {
        if (this.f25554g != z) {
            this.f25554g = z;
            if (!z) {
                d();
            }
        }
    }

    public void m(boolean z) {
        this.f25555h = z;
    }
}

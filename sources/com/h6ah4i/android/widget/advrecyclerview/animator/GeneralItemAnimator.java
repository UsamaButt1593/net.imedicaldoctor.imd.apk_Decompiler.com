package com.h6ah4i.android.widget.advrecyclerview.animator;

import android.util.Log;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemAddAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemChangeAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemMoveAnimationManager;
import com.h6ah4i.android.widget.advrecyclerview.animator.impl.ItemRemoveAnimationManager;

public abstract class GeneralItemAnimator extends BaseItemAnimator {
    private static final String r = "ARVGeneralItemAnimator";

    /* renamed from: m  reason: collision with root package name */
    private boolean f25341m;

    /* renamed from: n  reason: collision with root package name */
    private ItemRemoveAnimationManager f25342n;
    private ItemAddAnimationManager o;
    private ItemChangeAnimationManager p;
    private ItemMoveAnimationManager q;

    protected GeneralItemAnimator() {
        p0();
    }

    private void p0() {
        i0();
        if (this.f25342n == null || this.o == null || this.p == null || this.q == null) {
            throw new IllegalStateException("setup incomplete");
        }
    }

    public boolean D() {
        return this.f25341m;
    }

    public boolean E() {
        if (this.f25341m && !q()) {
            Log.d(r, "dispatchFinishedWhenDone()");
        }
        return super.E();
    }

    public boolean W(RecyclerView.ViewHolder viewHolder) {
        if (this.f25341m) {
            Log.d(r, "animateAdd(id = " + viewHolder.E() + ", position = " + viewHolder.G() + ")");
        }
        return this.o.z(viewHolder);
    }

    public boolean X(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        if (this.f25341m) {
            String str = "-";
            String l2 = viewHolder != null ? Long.toString(viewHolder.E()) : str;
            String l3 = viewHolder != null ? Long.toString((long) viewHolder.G()) : str;
            String l4 = viewHolder2 != null ? Long.toString(viewHolder2.E()) : str;
            if (viewHolder2 != null) {
                str = Long.toString((long) viewHolder2.G());
            }
            Log.d(r, "animateChange(old.id = " + l2 + ", old.position = " + l3 + ", new.id = " + l4 + ", new.position = " + str + ", fromX = " + i2 + ", fromY = " + i3 + ", toX = " + i4 + ", toY = " + i5 + ")");
        }
        return this.p.z(viewHolder, viewHolder2, i2, i3, i4, i5);
    }

    public boolean Y(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        if (this.f25341m) {
            Log.d(r, "animateMove(id = " + viewHolder.E() + ", position = " + viewHolder.G() + ", fromX = " + i2 + ", fromY = " + i3 + ", toX = " + i4 + ", toY = " + i5 + ")");
        }
        return this.q.z(viewHolder, i2, i3, i4, i5);
    }

    public boolean Z(RecyclerView.ViewHolder viewHolder) {
        if (this.f25341m) {
            Log.d(r, "animateRemove(id = " + viewHolder.E() + ", position = " + viewHolder.G() + ")");
        }
        return this.f25342n.z(viewHolder);
    }

    /* access modifiers changed from: protected */
    public void a0(RecyclerView.ViewHolder viewHolder) {
        ViewCompat.g(viewHolder.f15587a).d();
    }

    /* access modifiers changed from: protected */
    public ItemAddAnimationManager b0() {
        return this.o;
    }

    /* access modifiers changed from: protected */
    public ItemChangeAnimationManager c0() {
        return this.p;
    }

    /* access modifiers changed from: protected */
    public ItemMoveAnimationManager d0() {
        return this.q;
    }

    /* access modifiers changed from: protected */
    public ItemRemoveAnimationManager e0() {
        return this.f25342n;
    }

    /* access modifiers changed from: protected */
    public boolean f0() {
        return this.f25342n.p() || this.q.p() || this.p.p() || this.o.p();
    }

    public boolean g0() {
        return this.f25341m;
    }

    /* access modifiers changed from: protected */
    public void h0() {
        j0();
    }

    /* access modifiers changed from: protected */
    public abstract void i0();

    /* access modifiers changed from: protected */
    public void j0() {
        boolean p2 = this.f25342n.p();
        boolean p3 = this.q.p();
        boolean p4 = this.p.p();
        boolean p5 = this.o.p();
        long j2 = 0;
        long p6 = p2 ? p() : 0;
        long o2 = p3 ? o() : 0;
        long n2 = p4 ? n() : 0;
        boolean z = false;
        if (p2) {
            this.f25342n.w(false, 0);
        }
        if (p3) {
            this.q.w(p2, p6);
        }
        if (p4) {
            this.p.w(p2, p6);
        }
        if (p5) {
            if (p2 || p3 || p4) {
                z = true;
            }
            long max = p6 + Math.max(o2, n2);
            if (z) {
                j2 = max;
            }
            this.o.w(z, j2);
        }
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        a0(viewHolder);
        this.q.m(viewHolder);
        this.p.m(viewHolder);
        this.f25342n.m(viewHolder);
        this.o.m(viewHolder);
        this.q.k(viewHolder);
        this.p.k(viewHolder);
        this.f25342n.k(viewHolder);
        this.o.k(viewHolder);
        if (this.f25342n.v(viewHolder) && this.f25341m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [remove]");
        } else if (this.o.v(viewHolder) && this.f25341m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [add]");
        } else if (this.p.v(viewHolder) && this.f25341m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [change]");
        } else if (!this.q.v(viewHolder) || !this.f25341m) {
            E();
        } else {
            throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [move]");
        }
    }

    public void k0(boolean z) {
        this.f25341m = z;
    }

    public void l() {
        this.q.i();
        this.f25342n.i();
        this.o.i();
        this.p.i();
        if (q()) {
            this.q.h();
            this.o.h();
            this.p.h();
            this.f25342n.b();
            this.q.b();
            this.o.b();
            this.p.b();
            j();
        }
    }

    /* access modifiers changed from: protected */
    public void l0(ItemAddAnimationManager itemAddAnimationManager) {
        this.o = itemAddAnimationManager;
    }

    /* access modifiers changed from: protected */
    public void m0(ItemChangeAnimationManager itemChangeAnimationManager) {
        this.p = itemChangeAnimationManager;
    }

    /* access modifiers changed from: protected */
    public void n0(ItemMoveAnimationManager itemMoveAnimationManager) {
        this.q = itemMoveAnimationManager;
    }

    /* access modifiers changed from: protected */
    public void o0(ItemRemoveAnimationManager itemRemoveAnimationManager) {
        this.f25342n = itemRemoveAnimationManager;
    }

    public boolean q() {
        return this.f25342n.q() || this.o.q() || this.p.q() || this.q.q();
    }

    public void x() {
        if (f0()) {
            h0();
        }
    }
}

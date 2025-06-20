package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.lang.ref.WeakReference;

public class BaseWrapperAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f25557f = "ARVBaseWrapperAdapter";

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f25558g = false;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView.Adapter<VH> f25559d;

    /* renamed from: e  reason: collision with root package name */
    private BridgeObserver f25560e;

    private static final class BridgeObserver<VH extends RecyclerView.ViewHolder> extends RecyclerView.AdapterDataObserver {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<BaseWrapperAdapter<VH>> f25561a;

        public BridgeObserver(BaseWrapperAdapter<VH> baseWrapperAdapter) {
            this.f25561a = new WeakReference<>(baseWrapperAdapter);
        }

        public void a() {
            BaseWrapperAdapter baseWrapperAdapter = this.f25561a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.k0();
            }
        }

        public void b(int i2, int i3) {
            BaseWrapperAdapter baseWrapperAdapter = this.f25561a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.l0(i2, i3);
            }
        }

        public void d(int i2, int i3) {
            BaseWrapperAdapter baseWrapperAdapter = this.f25561a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.m0(i2, i3);
            }
        }

        public void e(int i2, int i3, int i4) {
            BaseWrapperAdapter baseWrapperAdapter = this.f25561a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.o0(i2, i3, i4);
            }
        }

        public void f(int i2, int i3) {
            BaseWrapperAdapter baseWrapperAdapter = this.f25561a.get();
            if (baseWrapperAdapter != null) {
                baseWrapperAdapter.n0(i2, i3);
            }
        }
    }

    public BaseWrapperAdapter(RecyclerView.Adapter<VH> adapter) {
        this.f25559d = adapter;
        BridgeObserver bridgeObserver = new BridgeObserver(this);
        this.f25560e = bridgeObserver;
        this.f25559d.Z(bridgeObserver);
        super.a0(this.f25559d.F());
    }

    public long B(int i2) {
        return this.f25559d.B(i2);
    }

    public int C(int i2) {
        return this.f25559d.C(i2);
    }

    public void Q(RecyclerView recyclerView) {
        this.f25559d.Q(recyclerView);
    }

    public void R(VH vh, int i2) {
        this.f25559d.R(vh, i2);
    }

    public VH T(ViewGroup viewGroup, int i2) {
        return this.f25559d.T(viewGroup, i2);
    }

    public void U(RecyclerView recyclerView) {
        this.f25559d.U(recyclerView);
    }

    public void W(VH vh) {
        this.f25559d.W(vh);
    }

    public void X(VH vh) {
        this.f25559d.X(vh);
    }

    public void Y(VH vh) {
        this.f25559d.Y(vh);
    }

    public void a0(boolean z) {
        super.a0(z);
        this.f25559d.a0(z);
    }

    public int b() {
        return this.f25559d.b();
    }

    public RecyclerView.Adapter<VH> d0() {
        return this.f25559d;
    }

    /* access modifiers changed from: protected */
    public void e0() {
        G();
    }

    /* access modifiers changed from: protected */
    public void f0(int i2, int i3) {
        L(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void g0(int i2, int i3) {
        N(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void h0(int i2, int i3) {
        O(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void i0(int i2, int i3, int i4) {
        if (i4 == 1) {
            K(i2, i3);
            return;
        }
        throw new IllegalStateException("itemCount should be always 1  (actual: " + i4 + ")");
    }

    /* access modifiers changed from: protected */
    public void j0() {
    }

    /* access modifiers changed from: package-private */
    public final void k0() {
        e0();
    }

    /* access modifiers changed from: package-private */
    public final void l0(int i2, int i3) {
        f0(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final void m0(int i2, int i3) {
        g0(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final void n0(int i2, int i3) {
        h0(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public final void o0(int i2, int i3, int i4) {
        i0(i2, i3, i4);
    }

    public void p0() {
        BridgeObserver bridgeObserver;
        j0();
        RecyclerView.Adapter<VH> adapter = this.f25559d;
        if (!(adapter == null || (bridgeObserver = this.f25560e) == null)) {
            adapter.c0(bridgeObserver);
        }
        this.f25559d = null;
        this.f25560e = null;
    }
}

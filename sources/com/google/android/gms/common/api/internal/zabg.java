package com.google.android.gms.common.api.internal;

abstract class zabg {

    /* renamed from: a  reason: collision with root package name */
    private final zabf f20098a;

    protected zabg(zabf zabf) {
        this.f20098a = zabf;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    public final void b(zabi zabi) {
        zabi.f20100l.lock();
        try {
            if (zabi.v == this.f20098a) {
                a();
            }
        } finally {
            zabi.f20100l.unlock();
        }
    }
}

package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class zabd extends zabw {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<zabe> f20087a;

    zabd(zabe zabe) {
        this.f20087a = new WeakReference<>(zabe);
    }

    public final void a() {
        zabe zabe = this.f20087a.get();
        if (zabe != null) {
            zabe.P(zabe);
        }
    }
}

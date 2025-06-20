package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzv extends zzx {

    /* renamed from: f  reason: collision with root package name */
    private final Callable f20433f;

    /* synthetic */ zzv(Callable callable, zzu zzu) {
        super(false, 1, 5, (String) null, (Throwable) null, (zzw) null);
        this.f20433f = callable;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        try {
            return (String) this.f20433f.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}

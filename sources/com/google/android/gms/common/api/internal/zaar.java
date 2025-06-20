package com.google.android.gms.common.api.internal;

import androidx.annotation.BinderThread;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

final class zaar extends zac {

    /* renamed from: l  reason: collision with root package name */
    private final WeakReference<zaaw> f20060l;

    zaar(zaaw zaaw) {
        this.f20060l = new WeakReference<>(zaaw);
    }

    @BinderThread
    public final void Y(zak zak) {
        zaaw zaaw = this.f20060l.get();
        if (zaaw != null) {
            zaaw.f20062a.t(new zaaq(this, zaaw, zaaw, zak));
        }
    }
}

package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class zan extends zabw {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Dialog f20176a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zao f20177b;

    zan(zao zao, Dialog dialog) {
        this.f20177b = zao;
        this.f20176a = dialog;
    }

    public final void a() {
        this.f20177b.X.p();
        if (this.f20176a.isShowing()) {
            this.f20176a.dismiss();
        }
    }
}

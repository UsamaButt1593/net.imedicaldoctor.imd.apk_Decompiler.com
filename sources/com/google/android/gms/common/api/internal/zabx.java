package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;

public final class zabx extends BroadcastReceiver {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    Context f20118a;

    /* renamed from: b  reason: collision with root package name */
    private final zabw f20119b;

    public zabx(zabw zabw) {
        this.f20119b = zabw;
    }

    public final void a(Context context) {
        this.f20118a = context;
    }

    public final synchronized void b() {
        try {
            Context context = this.f20118a;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f20118a = null;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f20119b.a();
            b();
        }
    }
}

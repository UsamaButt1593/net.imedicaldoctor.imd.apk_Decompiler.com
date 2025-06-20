package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

@SuppressLint({"HandlerLeak"})
final class zac extends zaq {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20414a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ GoogleApiAvailability f20415b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zac(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f20415b = googleApiAvailability;
        this.f20414a = context.getApplicationContext();
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 != 1) {
            StringBuilder sb = new StringBuilder(50);
            sb.append("Don't know how to handle this message: ");
            sb.append(i2);
            Log.w("GoogleApiAvailability", sb.toString());
            return;
        }
        int j2 = this.f20415b.j(this.f20414a);
        if (this.f20415b.o(j2)) {
            this.f20415b.C(this.f20414a, j2);
        }
    }
}

package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzs {

    /* renamed from: a  reason: collision with root package name */
    final int f19829a;

    /* renamed from: b  reason: collision with root package name */
    final TaskCompletionSource f19830b = new TaskCompletionSource();

    /* renamed from: c  reason: collision with root package name */
    final int f19831c;

    /* renamed from: d  reason: collision with root package name */
    final Bundle f19832d;

    zzs(int i2, int i3, Bundle bundle) {
        this.f19829a = i2;
        this.f19831c = i3;
        this.f19832d = bundle;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public final void c(zzt zzt) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String obj = toString();
            String obj2 = zzt.toString();
            Log.d("MessengerIpcClient", "Failing " + obj + " with " + obj2);
        }
        this.f19830b.b(zzt);
    }

    /* access modifiers changed from: package-private */
    public final void d(Object obj) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String obj2 = toString();
            String valueOf = String.valueOf(obj);
            Log.d("MessengerIpcClient", "Finishing " + obj2 + " with " + valueOf);
        }
        this.f19830b.c(obj);
    }

    public final String toString() {
        return "Request { what=" + this.f19831c + " id=" + this.f19829a + " oneWay=" + b() + "}";
    }
}

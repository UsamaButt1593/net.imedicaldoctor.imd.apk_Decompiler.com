package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.Nullable;

public abstract class zzc {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Object f20304a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20305b = false;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f20306c;

    public zzc(BaseGmsClient baseGmsClient, Object obj) {
        this.f20306c = baseGmsClient;
        this.f20304a = obj;
    }

    /* access modifiers changed from: protected */
    public abstract void a(Object obj);

    /* access modifiers changed from: protected */
    public abstract void b();

    public final void c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f20304a;
                if (this.f20305b) {
                    String obj2 = toString();
                    Log.w("GmsClient", "Callback proxy " + obj2 + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (obj != null) {
            a(obj);
        }
        synchronized (this) {
            this.f20305b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f20304a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f20306c.k3) {
            this.f20306c.k3.remove(this);
        }
    }
}

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.Executor;

@KeepForSdk
public abstract class GmsClientSupervisor {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f20241a = new Object();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static zzs f20242b = null;
    @VisibleForTesting
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    static HandlerThread f20243c = null;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static Executor f20244d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f20245e = false;

    @KeepForSdk
    public static int d() {
        return 4225;
    }

    @NonNull
    @KeepForSdk
    public static GmsClientSupervisor e(@NonNull Context context) {
        synchronized (f20241a) {
            try {
                if (f20242b == null) {
                    f20242b = new zzs(context.getApplicationContext(), f20245e ? f().getLooper() : context.getMainLooper(), f20244d);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f20242b;
    }

    @NonNull
    @KeepForSdk
    public static HandlerThread f() {
        synchronized (f20241a) {
            try {
                HandlerThread handlerThread = f20243c;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f20243c = handlerThread2;
                handlerThread2.start();
                HandlerThread handlerThread3 = f20243c;
                return handlerThread3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static HandlerThread g(int i2) {
        synchronized (f20241a) {
            try {
                HandlerThread handlerThread = f20243c;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", i2);
                f20243c = handlerThread2;
                handlerThread2.start();
                HandlerThread handlerThread3 = f20243c;
                return handlerThread3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static void h(@Nullable Executor executor) {
        synchronized (f20241a) {
            try {
                zzs zzs = f20242b;
                if (zzs != null) {
                    zzs.t(executor);
                }
                f20244d = executor;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public static void i() {
        synchronized (f20241a) {
            try {
                zzs zzs = f20242b;
                if (zzs != null && !f20245e) {
                    zzs.u(f().getLooper());
                }
                f20245e = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public boolean a(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        return n(new zzo(componentName, 4225), serviceConnection, str, (Executor) null);
    }

    @KeepForSdk
    public boolean b(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str, @Nullable Executor executor) {
        return n(new zzo(componentName, 4225), serviceConnection, str, executor);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public boolean c(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        return n(new zzo(str, 4225, false), serviceConnection, str2, (Executor) null);
    }

    @KeepForSdk
    public void j(@NonNull ComponentName componentName, @NonNull ServiceConnection serviceConnection, @NonNull String str) {
        l(new zzo(componentName, 4225), serviceConnection, str);
    }

    @KeepForSdk
    public void k(@NonNull String str, @NonNull ServiceConnection serviceConnection, @NonNull String str2) {
        l(new zzo(str, 4225, false), serviceConnection, str2);
    }

    /* access modifiers changed from: protected */
    public abstract void l(zzo zzo, ServiceConnection serviceConnection, String str);

    public final void m(@NonNull String str, @NonNull String str2, int i2, @NonNull ServiceConnection serviceConnection, @NonNull String str3, boolean z) {
        l(new zzo(str, str2, 4225, z), serviceConnection, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean n(zzo zzo, ServiceConnection serviceConnection, String str, @Nullable Executor executor);
}

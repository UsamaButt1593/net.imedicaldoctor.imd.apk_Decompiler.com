package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zacd<T> implements OnCompleteListener<T> {

    /* renamed from: a  reason: collision with root package name */
    private final GoogleApiManager f20120a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20121b;

    /* renamed from: c  reason: collision with root package name */
    private final ApiKey<?> f20122c;

    /* renamed from: d  reason: collision with root package name */
    private final long f20123d;

    /* renamed from: e  reason: collision with root package name */
    private final long f20124e;

    @VisibleForTesting
    zacd(GoogleApiManager googleApiManager, int i2, ApiKey<?> apiKey, long j2, long j3, @Nullable String str, @Nullable String str2) {
        this.f20120a = googleApiManager;
        this.f20121b = i2;
        this.f20122c = apiKey;
        this.f20123d = j2;
        this.f20124e = j3;
    }

    @Nullable
    static <T> zacd<T> b(GoogleApiManager googleApiManager, int i2, ApiKey<?> apiKey) {
        boolean z;
        if (!googleApiManager.g()) {
            return null;
        }
        RootTelemetryConfiguration a2 = RootTelemetryConfigManager.b().a();
        if (a2 == null) {
            z = true;
        } else if (!a2.I()) {
            return null;
        } else {
            z = a2.N();
            zabq x = googleApiManager.x(apiKey);
            if (x != null) {
                if (!(x.u() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) x.u();
                if (baseGmsClient.S() && !baseGmsClient.h()) {
                    ConnectionTelemetryConfiguration c2 = c(x, baseGmsClient, i2);
                    if (c2 == null) {
                        return null;
                    }
                    x.G();
                    z = c2.O();
                }
            }
        }
        return new zacd(googleApiManager, i2, apiKey, z ? System.currentTimeMillis() : 0, z ? SystemClock.elapsedRealtime() : 0, (String) null, (String) null);
    }

    @Nullable
    private static ConnectionTelemetryConfiguration c(zabq<?> zabq, BaseGmsClient<?> baseGmsClient, int i2) {
        int[] H;
        int[] I;
        ConnectionTelemetryConfiguration Q = baseGmsClient.Q();
        if (Q == null || !Q.N() || ((H = Q.H()) != null ? !ArrayUtils.c(H, i2) : !((I = Q.I()) == null || !ArrayUtils.c(I, i2))) || zabq.r() >= Q.C()) {
            return null;
        }
        return Q;
    }

    @WorkerThread
    public final void a(@NonNull Task<T> task) {
        zabq x;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2;
        long j3;
        if (this.f20120a.g()) {
            RootTelemetryConfiguration a2 = RootTelemetryConfigManager.b().a();
            if ((a2 == null || a2.I()) && (x = this.f20120a.x(this.f20122c)) != null && (x.u() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) x.u();
                boolean z = true;
                boolean z2 = this.f20123d > 0;
                int H = baseGmsClient.H();
                if (a2 != null) {
                    boolean N = z2 & a2.N();
                    int C = a2.C();
                    int H2 = a2.H();
                    i4 = a2.getVersion();
                    if (baseGmsClient.S() && !baseGmsClient.h()) {
                        ConnectionTelemetryConfiguration c2 = c(x, baseGmsClient, this.f20121b);
                        if (c2 != null) {
                            if (!c2.O() || this.f20123d <= 0) {
                                z = false;
                            }
                            H2 = c2.C();
                            N = z;
                        } else {
                            return;
                        }
                    }
                    i3 = C;
                    i2 = H2;
                } else {
                    i4 = 0;
                    i3 = 5000;
                    i2 = 100;
                }
                GoogleApiManager googleApiManager = this.f20120a;
                if (task.v()) {
                    i6 = 0;
                    i5 = 0;
                } else {
                    if (task.t()) {
                        i6 = 100;
                    } else {
                        Exception q = task.q();
                        if (q instanceof ApiException) {
                            Status a3 = ((ApiException) q).a();
                            int I = a3.I();
                            ConnectionResult C2 = a3.C();
                            i5 = C2 == null ? -1 : C2.C();
                            i6 = I;
                        } else {
                            i6 = 101;
                        }
                    }
                    i5 = -1;
                }
                if (z2) {
                    long j4 = this.f20123d;
                    j2 = System.currentTimeMillis();
                    j3 = j4;
                    i7 = (int) (SystemClock.elapsedRealtime() - this.f20124e);
                } else {
                    j3 = 0;
                    j2 = 0;
                    i7 = -1;
                }
                googleApiManager.L(new MethodInvocation(this.f20121b, i6, i5, j3, j2, (String) null, (String) null, H, i7), i4, (long) i3, i2);
            }
        }
    }
}

package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

@KeepForSdk
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client, zaj {
    @Nullable
    private static volatile Executor G3;
    private final ClientSettings D3;
    private final Set<Scope> E3;
    @Nullable
    private final Account F3;

    @KeepForSdk
    @VisibleForTesting
    protected GmsClient(@NonNull Context context, @NonNull Handler handler, int i2, @NonNull ClientSettings clientSettings) {
        super(context, handler, GmsClientSupervisor.e(context), GoogleApiAvailability.x(), i2, (BaseGmsClient.BaseConnectionCallbacks) null, (BaseGmsClient.BaseOnConnectionFailedListener) null);
        this.D3 = (ClientSettings) Preconditions.r(clientSettings);
        this.F3 = clientSettings.b();
        this.E3 = t0(clientSettings.e());
    }

    private final Set<Scope> t0(@NonNull Set<Scope> set) {
        Set<Scope> s0 = s0(set);
        for (Scope contains : s0) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return s0;
    }

    @Nullable
    public final Account C() {
        return this.F3;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Executor E() {
        return null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public final Set<Scope> L() {
        return this.E3;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> e() {
        return w() ? this.E3 : Collections.emptySet();
    }

    @NonNull
    @KeepForSdk
    public Feature[] n() {
        return new Feature[0];
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public final ClientSettings r0() {
        return this.D3;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public Set<Scope> s0(@NonNull Set<Scope> set) {
        return set;
    }

    @KeepForSdk
    protected GmsClient(@NonNull Context context, @NonNull Looper looper, int i2, @NonNull ClientSettings clientSettings) {
        this(context, looper, GmsClientSupervisor.e(context), GoogleApiAvailability.x(), i2, clientSettings, (ConnectionCallbacks) null, (OnConnectionFailedListener) null);
    }

    @KeepForSdk
    @Deprecated
    protected GmsClient(@NonNull Context context, @NonNull Looper looper, int i2, @NonNull ClientSettings clientSettings, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, i2, clientSettings, (ConnectionCallbacks) connectionCallbacks, (OnConnectionFailedListener) onConnectionFailedListener);
    }

    @KeepForSdk
    protected GmsClient(@NonNull Context context, @NonNull Looper looper, int i2, @NonNull ClientSettings clientSettings, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, GmsClientSupervisor.e(context), GoogleApiAvailability.x(), i2, clientSettings, (ConnectionCallbacks) Preconditions.r(connectionCallbacks), (OnConnectionFailedListener) Preconditions.r(onConnectionFailedListener));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected GmsClient(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.NonNull android.os.Looper r12, @androidx.annotation.NonNull com.google.android.gms.common.internal.GmsClientSupervisor r13, @androidx.annotation.NonNull com.google.android.gms.common.GoogleApiAvailability r14, int r15, @androidx.annotation.NonNull com.google.android.gms.common.internal.ClientSettings r16, @androidx.annotation.Nullable com.google.android.gms.common.api.internal.ConnectionCallbacks r17, @androidx.annotation.Nullable com.google.android.gms.common.api.internal.OnConnectionFailedListener r18) {
        /*
            r10 = this;
            r9 = r10
            r0 = r17
            r1 = r18
            r2 = 0
            if (r0 != 0) goto L_0x000a
            r6 = r2
            goto L_0x0010
        L_0x000a:
            com.google.android.gms.common.internal.zah r3 = new com.google.android.gms.common.internal.zah
            r3.<init>(r0)
            r6 = r3
        L_0x0010:
            if (r1 != 0) goto L_0x0014
            r7 = r2
            goto L_0x001a
        L_0x0014:
            com.google.android.gms.common.internal.zai r0 = new com.google.android.gms.common.internal.zai
            r0.<init>(r1)
            r7 = r0
        L_0x001a:
            java.lang.String r8 = r16.m()
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            r9.D3 = r0
            android.accounts.Account r1 = r16.b()
            r9.F3 = r1
            java.util.Set r0 = r16.e()
            java.util.Set r0 = r10.t0(r0)
            r9.E3 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClient.<init>(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.GmsClientSupervisor, com.google.android.gms.common.GoogleApiAvailability, int, com.google.android.gms.common.internal.ClientSettings, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener):void");
    }
}

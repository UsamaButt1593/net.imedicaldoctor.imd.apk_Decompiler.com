package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class TaskApiCall<A extends Api.AnyClient, ResultT> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Feature[] f20028a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f20029b;

    /* renamed from: c  reason: collision with root package name */
    private final int f20030c;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, ResultT> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public RemoteCall<A, TaskCompletionSource<ResultT>> f20031a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f20032b = true;

        /* renamed from: c  reason: collision with root package name */
        private Feature[] f20033c;

        /* renamed from: d  reason: collision with root package name */
        private int f20034d = 0;

        private Builder() {
        }

        @NonNull
        @KeepForSdk
        public TaskApiCall<A, ResultT> a() {
            Preconditions.b(this.f20031a != null, "execute parameter required");
            return new zacv(this, this.f20033c, this.f20032b, this.f20034d);
        }

        @NonNull
        @KeepForSdk
        @Deprecated
        public Builder<A, ResultT> b(@NonNull BiConsumer<A, TaskCompletionSource<ResultT>> biConsumer) {
            this.f20031a = new zacu(biConsumer);
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> c(@NonNull RemoteCall<A, TaskCompletionSource<ResultT>> remoteCall) {
            this.f20031a = remoteCall;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> d(boolean z) {
            this.f20032b = z;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> e(@NonNull Feature... featureArr) {
            this.f20033c = featureArr;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, ResultT> f(int i2) {
            this.f20034d = i2;
            return this;
        }

        /* synthetic */ Builder(zacw zacw) {
        }
    }

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.f20028a = null;
        this.f20029b = false;
        this.f20030c = 0;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, ResultT> Builder<A, ResultT> a() {
        return new Builder<>((zacw) null);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract void b(@NonNull A a2, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    @KeepForSdk
    public boolean c() {
        return this.f20029b;
    }

    public final int d() {
        return this.f20030c;
    }

    @Nullable
    public final Feature[] e() {
        return this.f20028a;
    }

    @KeepForSdk
    protected TaskApiCall(@Nullable Feature[] featureArr, boolean z, int i2) {
        this.f20028a = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.f20029b = z2;
        this.f20030c = i2;
    }
}

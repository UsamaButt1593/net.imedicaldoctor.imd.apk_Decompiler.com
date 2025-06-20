package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public class RegistrationMethods<A extends Api.AnyClient, L> {
    @NonNull
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    public final RegisterListenerMethod<A, L> f20017a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final UnregisterListenerMethod<A, L> f20018b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f20019c;

    @KeepForSdk
    public static class Builder<A extends Api.AnyClient, L> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public RemoteCall<A, TaskCompletionSource<Void>> f20020a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public RemoteCall<A, TaskCompletionSource<Boolean>> f20021b;

        /* renamed from: c  reason: collision with root package name */
        private Runnable f20022c = zacj.s;

        /* renamed from: d  reason: collision with root package name */
        private ListenerHolder<L> f20023d;

        /* renamed from: e  reason: collision with root package name */
        private Feature[] f20024e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f20025f = true;

        /* renamed from: g  reason: collision with root package name */
        private int f20026g;

        private Builder() {
        }

        @NonNull
        @KeepForSdk
        public RegistrationMethods<A, L> a() {
            boolean z = false;
            Preconditions.b(this.f20020a != null, "Must set register function");
            Preconditions.b(this.f20021b != null, "Must set unregister function");
            if (this.f20023d != null) {
                z = true;
            }
            Preconditions.b(z, "Must set holder");
            return new RegistrationMethods<>(new zack(this, this.f20023d, this.f20024e, this.f20025f, this.f20026g), new zacl(this, (ListenerHolder.ListenerKey) Preconditions.s(this.f20023d.b(), "Key must not be null")), this.f20022c, (zacn) null);
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> b(@NonNull Runnable runnable) {
            this.f20022c = runnable;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> c(@NonNull RemoteCall<A, TaskCompletionSource<Void>> remoteCall) {
            this.f20020a = remoteCall;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> d(boolean z) {
            this.f20025f = z;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> e(@NonNull Feature... featureArr) {
            this.f20024e = featureArr;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> f(int i2) {
            this.f20026g = i2;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> g(@NonNull RemoteCall<A, TaskCompletionSource<Boolean>> remoteCall) {
            this.f20021b = remoteCall;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder<A, L> h(@NonNull ListenerHolder<L> listenerHolder) {
            this.f20023d = listenerHolder;
            return this;
        }

        /* synthetic */ Builder(zacm zacm) {
        }
    }

    /* synthetic */ RegistrationMethods(RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable, zacn zacn) {
        this.f20017a = registerListenerMethod;
        this.f20018b = unregisterListenerMethod;
        this.f20019c = runnable;
    }

    @NonNull
    @KeepForSdk
    public static <A extends Api.AnyClient, L> Builder<A, L> a() {
        return new Builder<>((zacm) null);
    }
}

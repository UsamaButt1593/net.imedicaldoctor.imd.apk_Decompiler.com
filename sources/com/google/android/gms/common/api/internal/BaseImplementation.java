package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class BaseImplementation {

    @KeepForSdk
    public static abstract class ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
        @KeepForSdk
        private final Api.AnyClientKey<A> r;
        @KeepForSdk
        @Nullable
        private final Api<?> s;

        @KeepForSdk
        @Deprecated
        protected ApiMethodImpl(@NonNull Api.AnyClientKey<A> anyClientKey, @NonNull GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.s(googleApiClient, "GoogleApiClient must not be null"));
            this.r = (Api.AnyClientKey) Preconditions.r(anyClientKey);
            this.s = null;
        }

        @KeepForSdk
        private void B(@NonNull RemoteException remoteException) {
            a(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        @KeepForSdk
        public final void A(@NonNull A a2) throws DeadObjectException {
            try {
                w(a2);
            } catch (DeadObjectException e2) {
                B(e2);
                throw e2;
            } catch (RemoteException e3) {
                B(e3);
            }
        }

        @KeepForSdk
        public final void a(@NonNull Status status) {
            Preconditions.b(!status.R(), "Failed result must not be success");
            Result k2 = k(status);
            o(k2);
            z(k2);
        }

        @KeepForSdk
        public /* bridge */ /* synthetic */ void b(@NonNull Object obj) {
            super.o((Result) obj);
        }

        /* access modifiers changed from: protected */
        @KeepForSdk
        public abstract void w(@NonNull A a2) throws RemoteException;

        @KeepForSdk
        @Nullable
        public final Api<?> x() {
            return this.s;
        }

        @NonNull
        @KeepForSdk
        public final Api.AnyClientKey<A> y() {
            return this.r;
        }

        /* access modifiers changed from: protected */
        @KeepForSdk
        public void z(@NonNull R r2) {
        }

        @KeepForSdk
        protected ApiMethodImpl(@NonNull Api<?> api, @NonNull GoogleApiClient googleApiClient) {
            super((GoogleApiClient) Preconditions.s(googleApiClient, "GoogleApiClient must not be null"));
            Preconditions.s(api, "Api must not be null");
            this.r = api.b();
            this.s = api;
        }

        @VisibleForTesting
        @KeepForSdk
        protected ApiMethodImpl(@NonNull BasePendingResult.CallbackHandler<R> callbackHandler) {
            super(callbackHandler);
            this.r = new Api.AnyClientKey<>();
            this.s = null;
        }
    }

    @KeepForSdk
    public interface ResultHolder<R> {
        @KeepForSdk
        void a(@NonNull Status status);

        @KeepForSdk
        void b(@NonNull R r);
    }
}

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions> {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractClientBuilder<?, O> f19920a;

    /* renamed from: b  reason: collision with root package name */
    private final ClientKey<?> f19921b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19922c;

    @KeepForSdk
    @VisibleForTesting
    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        @NonNull
        @KeepForSdk
        @Deprecated
        public T c(@NonNull Context context, @NonNull Looper looper, @NonNull ClientSettings clientSettings, @NonNull O o, @NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return d(context, looper, clientSettings, o, connectionCallbacks, onConnectionFailedListener);
        }

        @NonNull
        @KeepForSdk
        public T d(@NonNull Context context, @NonNull Looper looper, @NonNull ClientSettings clientSettings, @NonNull O o, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    @KeepForSdk
    public interface AnyClient {
    }

    @KeepForSdk
    public static class AnyClientKey<C extends AnyClient> {
    }

    public interface ApiOptions {
        @NonNull
        public static final NoOptions d0 = new NoOptions((zaa) null);

        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            @NonNull
            Account v();
        }

        public interface HasGoogleSignInAccountOptions extends HasOptions {
            @Nullable
            GoogleSignInAccount t();
        }

        public interface HasOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }

            /* synthetic */ NoOptions(zaa zaa) {
            }
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    @KeepForSdk
    @VisibleForTesting
    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        @KeepForSdk

        /* renamed from: a  reason: collision with root package name */
        public static final int f19923a = 1;
        @KeepForSdk

        /* renamed from: b  reason: collision with root package name */
        public static final int f19924b = 2;
        @KeepForSdk

        /* renamed from: c  reason: collision with root package name */
        public static final int f19925c = Integer.MAX_VALUE;

        @NonNull
        @KeepForSdk
        public List<Scope> a(@Nullable O o) {
            return Collections.emptyList();
        }

        @KeepForSdk
        public int b() {
            return Integer.MAX_VALUE;
        }
    }

    @KeepForSdk
    public interface Client extends AnyClient {
        @KeepForSdk
        boolean a();

        @KeepForSdk
        boolean d();

        @NonNull
        @KeepForSdk
        Set<Scope> e();

        @KeepForSdk
        void f(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set);

        @KeepForSdk
        void g(@NonNull String str);

        @KeepForSdk
        boolean h();

        @NonNull
        @KeepForSdk
        String i();

        @KeepForSdk
        boolean j();

        @KeepForSdk
        void k(@NonNull BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks);

        @KeepForSdk
        void l();

        @KeepForSdk
        void m(@NonNull BaseGmsClient.SignOutCallbacks signOutCallbacks);

        @NonNull
        @KeepForSdk
        Feature[] n();

        @KeepForSdk
        void o(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr);

        @KeepForSdk
        boolean p();

        @KeepForSdk
        int r();

        @NonNull
        @KeepForSdk
        Feature[] s();

        @KeepForSdk
        @Nullable
        String u();

        @NonNull
        @KeepForSdk
        Intent v();

        @KeepForSdk
        boolean w();

        @KeepForSdk
        @Nullable
        IBinder x();
    }

    @KeepForSdk
    @VisibleForTesting
    public static final class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    @KeepForSdk
    public <C extends Client> Api(@NonNull String str, @NonNull AbstractClientBuilder<C, O> abstractClientBuilder, @NonNull ClientKey<C> clientKey) {
        Preconditions.s(abstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.s(clientKey, "Cannot construct an Api with a null ClientKey");
        this.f19922c = str;
        this.f19920a = abstractClientBuilder;
        this.f19921b = clientKey;
    }

    @NonNull
    public final AbstractClientBuilder<?, O> a() {
        return this.f19920a;
    }

    @NonNull
    public final AnyClientKey<?> b() {
        return this.f19921b;
    }

    @NonNull
    public final BaseClientBuilder<?, O> c() {
        return this.f19920a;
    }

    @NonNull
    public final String d() {
        return this.f19922c;
    }
}

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

@KeepForSdk
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19943a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f19944b;

    /* renamed from: c  reason: collision with root package name */
    private final Api<O> f19945c;

    /* renamed from: d  reason: collision with root package name */
    private final O f19946d;

    /* renamed from: e  reason: collision with root package name */
    private final ApiKey<O> f19947e;

    /* renamed from: f  reason: collision with root package name */
    private final Looper f19948f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19949g;
    @NotOnlyInitialized

    /* renamed from: h  reason: collision with root package name */
    private final GoogleApiClient f19950h;

    /* renamed from: i  reason: collision with root package name */
    private final StatusExceptionMapper f19951i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    protected final GoogleApiManager f19952j;

    @KeepForSdk
    public static class Settings {
        @NonNull
        @KeepForSdk

        /* renamed from: c  reason: collision with root package name */
        public static final Settings f19953c = new Builder().a();
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final StatusExceptionMapper f19954a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Looper f19955b;

        @KeepForSdk
        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            private StatusExceptionMapper f19956a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f19957b;

            @NonNull
            @KeepForSdk
            public Settings a() {
                if (this.f19956a == null) {
                    this.f19956a = new ApiExceptionMapper();
                }
                if (this.f19957b == null) {
                    this.f19957b = Looper.getMainLooper();
                }
                return new Settings(this.f19956a, this.f19957b);
            }

            @NonNull
            @KeepForSdk
            public Builder b(@NonNull Looper looper) {
                Preconditions.s(looper, "Looper must not be null.");
                this.f19957b = looper;
                return this;
            }

            @NonNull
            @KeepForSdk
            public Builder c(@NonNull StatusExceptionMapper statusExceptionMapper) {
                Preconditions.s(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.f19956a = statusExceptionMapper;
                return this;
            }
        }

        @KeepForSdk
        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.f19954a = statusExceptionMapper;
            this.f19955b = looper;
        }
    }

    @MainThread
    @KeepForSdk
    public GoogleApi(@NonNull Activity activity, @NonNull Api<O> api, @NonNull O o, @NonNull Settings settings) {
        this((Context) activity, activity, api, o, settings);
    }

    private final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T y(int i2, @NonNull T t) {
        t.s();
        this.f19952j.J(this, i2, t);
        return t;
    }

    private final <TResult, A extends Api.AnyClient> Task<TResult> z(int i2, @NonNull TaskApiCall<A, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f19952j.K(this, i2, taskApiCall, taskCompletionSource, this.f19951i);
        return taskCompletionSource.a();
    }

    @NonNull
    public final ApiKey<O> b() {
        return this.f19947e;
    }

    @NonNull
    @KeepForSdk
    public GoogleApiClient c() {
        return this.f19950h;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public ClientSettings.Builder d() {
        Account account;
        GoogleSignInAccount t;
        GoogleSignInAccount t2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        O o = this.f19946d;
        if (!(o instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (t2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o).t()) == null) {
            O o2 = this.f19946d;
            account = o2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) o2).v() : null;
        } else {
            account = t2.v();
        }
        builder.d(account);
        O o3 = this.f19946d;
        builder.c((!(o3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (t = ((Api.ApiOptions.HasGoogleSignInAccountOptions) o3).t()) == null) ? Collections.emptySet() : t.W());
        builder.e(this.f19943a.getClass().getName());
        builder.b(this.f19943a.getPackageName());
        return builder;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public Task<Boolean> e() {
        return this.f19952j.C(this);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T f(@NonNull T t) {
        y(2, t);
        return t;
    }

    @NonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> g(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        return z(2, taskApiCall);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T h(@NonNull T t) {
        y(0, t);
        return t;
    }

    @NonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> i(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        return z(0, taskApiCall);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> j(@NonNull T t, @NonNull U u) {
        Preconditions.r(t);
        Preconditions.r(u);
        Preconditions.s(t.b(), "Listener has already been released.");
        Preconditions.s(u.a(), "Listener has already been released.");
        Preconditions.b(Objects.b(t.b(), u.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.f19952j.D(this, t, u, zad.s);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient> Task<Void> k(@NonNull RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.r(registrationMethods);
        Preconditions.s(registrationMethods.f20017a.b(), "Listener has already been released.");
        Preconditions.s(registrationMethods.f20018b.a(), "Listener has already been released.");
        return this.f19952j.D(this, registrationMethods.f20017a, registrationMethods.f20018b, registrationMethods.f20019c);
    }

    @NonNull
    @KeepForSdk
    public Task<Boolean> l(@NonNull ListenerHolder.ListenerKey<?> listenerKey) {
        return m(listenerKey, 0);
    }

    @NonNull
    @KeepForSdk
    public Task<Boolean> m(@NonNull ListenerHolder.ListenerKey<?> listenerKey, int i2) {
        Preconditions.s(listenerKey, "Listener key cannot be null.");
        return this.f19952j.E(this, listenerKey, i2);
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T n(@NonNull T t) {
        y(1, t);
        return t;
    }

    @NonNull
    @KeepForSdk
    public <TResult, A extends Api.AnyClient> Task<TResult> o(@NonNull TaskApiCall<A, TResult> taskApiCall) {
        return z(1, taskApiCall);
    }

    @NonNull
    @KeepForSdk
    public O p() {
        return this.f19946d;
    }

    @NonNull
    @KeepForSdk
    public Context q() {
        return this.f19943a;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public String r() {
        return this.f19944b;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Deprecated
    @Nullable
    public String s() {
        return this.f19944b;
    }

    @NonNull
    @KeepForSdk
    public Looper t() {
        return this.f19948f;
    }

    @NonNull
    @KeepForSdk
    public <L> ListenerHolder<L> u(@NonNull L l2, @NonNull String str) {
        return ListenerHolders.a(l2, this.f19948f, str);
    }

    public final int v() {
        return this.f19949g;
    }

    @WorkerThread
    public final Api.Client w(Looper looper, zabq<O> zabq) {
        Looper looper2 = looper;
        Api.Client c2 = ((Api.AbstractClientBuilder) Preconditions.r(this.f19945c.a())).c(this.f19943a, looper2, d().a(), this.f19946d, zabq, zabq);
        String r = r();
        if (r != null && (c2 instanceof BaseGmsClient)) {
            ((BaseGmsClient) c2).X(r);
        }
        if (r != null && (c2 instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) c2).A(r);
        }
        return c2;
    }

    public final zact x(Context context, Handler handler) {
        return new zact(context, handler, d().a());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(@androidx.annotation.NonNull android.app.Activity r2, @androidx.annotation.NonNull com.google.android.gms.common.api.Api<O> r3, @androidx.annotation.NonNull O r4, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.c(r5)
            android.os.Looper r5 = r2.getMainLooper()
            r0.b(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.a()
            r1.<init>((android.app.Activity) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.app.Activity, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    private GoogleApi(@NonNull Context context, @Nullable Activity activity, Api<O> api, O o, Settings settings) {
        Preconditions.s(context, "Null context is not permitted.");
        Preconditions.s(api, "Api must not be null.");
        Preconditions.s(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f19943a = context.getApplicationContext();
        String str = null;
        if (PlatformVersion.q()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", (Class[]) null).invoke(context, (Object[]) null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.f19944b = str;
        this.f19945c = api;
        this.f19946d = o;
        this.f19948f = settings.f19955b;
        ApiKey<O> a2 = ApiKey.a(api, o, str);
        this.f19947e = a2;
        this.f19950h = new zabv(this);
        GoogleApiManager z = GoogleApiManager.z(this.f19943a);
        this.f19952j = z;
        this.f19949g = z.n();
        this.f19951i = settings.f19954a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zaae.v(activity, z, a2);
        }
        z.c(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(@androidx.annotation.NonNull android.content.Context r2, @androidx.annotation.NonNull com.google.android.gms.common.api.Api<O> r3, @androidx.annotation.NonNull O r4, @androidx.annotation.NonNull android.os.Looper r5, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.StatusExceptionMapper r6) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.b(r5)
            r0.c(r6)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.a()
            r1.<init>((android.content.Context) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, android.os.Looper, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }

    @KeepForSdk
    public GoogleApi(@NonNull Context context, @NonNull Api<O> api, @NonNull O o, @NonNull Settings settings) {
        this(context, (Activity) null, api, o, settings);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleApi(@androidx.annotation.NonNull android.content.Context r2, @androidx.annotation.NonNull com.google.android.gms.common.api.Api<O> r3, @androidx.annotation.NonNull O r4, @androidx.annotation.NonNull com.google.android.gms.common.api.internal.StatusExceptionMapper r5) {
        /*
            r1 = this;
            com.google.android.gms.common.api.GoogleApi$Settings$Builder r0 = new com.google.android.gms.common.api.GoogleApi$Settings$Builder
            r0.<init>()
            r0.c(r5)
            com.google.android.gms.common.api.GoogleApi$Settings r5 = r0.a()
            r1.<init>((android.content.Context) r2, r3, r4, (com.google.android.gms.common.api.GoogleApi.Settings) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApi.<init>(android.content.Context, com.google.android.gms.common.api.Api, com.google.android.gms.common.api.Api$ApiOptions, com.google.android.gms.common.api.internal.StatusExceptionMapper):void");
    }
}

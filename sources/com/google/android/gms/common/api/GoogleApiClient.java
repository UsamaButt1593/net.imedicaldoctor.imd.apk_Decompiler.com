package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zada;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zab;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@Deprecated
public abstract class GoogleApiClient {
    @NonNull
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    public static final String f19958a = "<<default account>>";

    /* renamed from: b  reason: collision with root package name */
    public static final int f19959b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f19960c = 2;
    /* access modifiers changed from: private */
    @GuardedBy("sAllClients")

    /* renamed from: d  reason: collision with root package name */
    public static final Set<GoogleApiClient> f19961d = Collections.newSetFromMap(new WeakHashMap());

    @KeepForSdk
    @Deprecated
    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Account f19962a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<Scope> f19963b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<Scope> f19964c;

        /* renamed from: d  reason: collision with root package name */
        private int f19965d;

        /* renamed from: e  reason: collision with root package name */
        private View f19966e;

        /* renamed from: f  reason: collision with root package name */
        private String f19967f;

        /* renamed from: g  reason: collision with root package name */
        private String f19968g;

        /* renamed from: h  reason: collision with root package name */
        private final Map<Api<?>, zab> f19969h;

        /* renamed from: i  reason: collision with root package name */
        private final Context f19970i;

        /* renamed from: j  reason: collision with root package name */
        private final Map<Api<?>, Api.ApiOptions> f19971j;

        /* renamed from: k  reason: collision with root package name */
        private LifecycleActivity f19972k;

        /* renamed from: l  reason: collision with root package name */
        private int f19973l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        private OnConnectionFailedListener f19974m;

        /* renamed from: n  reason: collision with root package name */
        private Looper f19975n;
        private GoogleApiAvailability o;
        private Api.AbstractClientBuilder<? extends zae, SignInOptions> p;
        private final ArrayList<ConnectionCallbacks> q;
        private final ArrayList<OnConnectionFailedListener> r;

        @KeepForSdk
        public Builder(@NonNull Context context) {
            this.f19963b = new HashSet();
            this.f19964c = new HashSet();
            this.f19969h = new ArrayMap();
            this.f19971j = new ArrayMap();
            this.f19973l = -1;
            this.o = GoogleApiAvailability.x();
            this.p = zad.f20496c;
            this.q = new ArrayList<>();
            this.r = new ArrayList<>();
            this.f19970i = context;
            this.f19975n = context.getMainLooper();
            this.f19967f = context.getPackageName();
            this.f19968g = context.getClass().getName();
        }

        private final <O extends Api.ApiOptions> void q(Api<O> api, @Nullable O o2, Scope... scopeArr) {
            HashSet hashSet = new HashSet(((Api.BaseClientBuilder) Preconditions.s(api.c(), "Base client builder must not be null")).a(o2));
            for (Scope add : scopeArr) {
                hashSet.add(add);
            }
            this.f19969h.put(api, new zab(hashSet));
        }

        @NonNull
        public Builder a(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            Preconditions.s(api, "Api must not be null");
            this.f19971j.put(api, (Object) null);
            List<Scope> a2 = ((Api.BaseClientBuilder) Preconditions.s(api.c(), "Base client builder must not be null")).a(null);
            this.f19964c.addAll(a2);
            this.f19963b.addAll(a2);
            return this;
        }

        @NonNull
        public <O extends Api.ApiOptions.HasOptions> Builder b(@NonNull Api<O> api, @NonNull O o2) {
            Preconditions.s(api, "Api must not be null");
            Preconditions.s(o2, "Null options are not permitted for this Api");
            this.f19971j.put(api, o2);
            List<Scope> a2 = ((Api.BaseClientBuilder) Preconditions.s(api.c(), "Base client builder must not be null")).a(o2);
            this.f19964c.addAll(a2);
            this.f19963b.addAll(a2);
            return this;
        }

        @NonNull
        public <O extends Api.ApiOptions.HasOptions> Builder c(@NonNull Api<O> api, @NonNull O o2, @NonNull Scope... scopeArr) {
            Preconditions.s(api, "Api must not be null");
            Preconditions.s(o2, "Null options are not permitted for this Api");
            this.f19971j.put(api, o2);
            q(api, o2, scopeArr);
            return this;
        }

        @NonNull
        public <T extends Api.ApiOptions.NotRequiredOptions> Builder d(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, @NonNull Scope... scopeArr) {
            Preconditions.s(api, "Api must not be null");
            this.f19971j.put(api, (Object) null);
            q(api, (Api.ApiOptions) null, scopeArr);
            return this;
        }

        @NonNull
        public Builder e(@NonNull ConnectionCallbacks connectionCallbacks) {
            Preconditions.s(connectionCallbacks, "Listener must not be null");
            this.q.add(connectionCallbacks);
            return this;
        }

        @NonNull
        public Builder f(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            Preconditions.s(onConnectionFailedListener, "Listener must not be null");
            this.r.add(onConnectionFailedListener);
            return this;
        }

        @NonNull
        public Builder g(@NonNull Scope scope) {
            Preconditions.s(scope, "Scope must not be null");
            this.f19963b.add(scope);
            return this;
        }

        @NonNull
        public GoogleApiClient h() {
            Preconditions.b(!this.f19971j.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings p2 = p();
            Map<Api<?>, zab> n2 = p2.n();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api = null;
            boolean z = false;
            for (Api next : this.f19971j.keySet()) {
                Api.ApiOptions apiOptions = this.f19971j.get(next);
                boolean z2 = n2.get(next) != null;
                arrayMap.put(next, Boolean.valueOf(z2));
                zat zat = new zat(next, z2);
                arrayList.add(zat);
                Api.AbstractClientBuilder abstractClientBuilder = (Api.AbstractClientBuilder) Preconditions.r(next.a());
                Api api2 = next;
                Api.Client c2 = abstractClientBuilder.c(this.f19970i, this.f19975n, p2, apiOptions, zat, zat);
                arrayMap2.put(api2.b(), c2);
                if (abstractClientBuilder.b() == 1) {
                    z = apiOptions != null;
                }
                if (c2.d()) {
                    if (api == null) {
                        api = api2;
                    } else {
                        String d2 = api2.d();
                        String d3 = api.d();
                        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 21 + String.valueOf(d3).length());
                        sb.append(d2);
                        sb.append(" cannot be used with ");
                        sb.append(d3);
                        throw new IllegalStateException(sb.toString());
                    }
                }
            }
            if (api != null) {
                if (!z) {
                    Preconditions.z(this.f19962a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.d());
                    Preconditions.z(this.f19963b.equals(this.f19964c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.d());
                } else {
                    String d4 = api.d();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(d4).length() + 82);
                    sb2.append("With using ");
                    sb2.append(d4);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
            }
            zabe zabe = new zabe(this.f19970i, new ReentrantLock(), this.f19975n, p2, this.o, this.p, arrayMap, this.q, this.r, arrayMap2, this.f19973l, zabe.K(arrayMap2.values(), true), arrayList);
            synchronized (GoogleApiClient.f19961d) {
                GoogleApiClient.f19961d.add(zabe);
            }
            if (this.f19973l >= 0) {
                zak.u(this.f19972k).v(this.f19973l, zabe, this.f19974m);
            }
            return zabe;
        }

        @NonNull
        public Builder i(@NonNull FragmentActivity fragmentActivity, int i2, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
            Preconditions.b(i2 >= 0, "clientId must be non-negative");
            this.f19973l = i2;
            this.f19974m = onConnectionFailedListener;
            this.f19972k = lifecycleActivity;
            return this;
        }

        @NonNull
        public Builder j(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            i(fragmentActivity, 0, onConnectionFailedListener);
            return this;
        }

        @NonNull
        public Builder k(@NonNull String str) {
            this.f19962a = str == null ? null : new Account(str, AccountType.f20215a);
            return this;
        }

        @NonNull
        public Builder l(int i2) {
            this.f19965d = i2;
            return this;
        }

        @NonNull
        public Builder m(@NonNull Handler handler) {
            Preconditions.s(handler, "Handler must not be null");
            this.f19975n = handler.getLooper();
            return this;
        }

        @NonNull
        public Builder n(@NonNull View view) {
            Preconditions.s(view, "View must not be null");
            this.f19966e = view;
            return this;
        }

        @NonNull
        public Builder o() {
            k("<<default account>>");
            return this;
        }

        @NonNull
        @VisibleForTesting
        public final ClientSettings p() {
            SignInOptions signInOptions = SignInOptions.c3;
            Map<Api<?>, Api.ApiOptions> map = this.f19971j;
            Api<SignInOptions> api = zad.f20500g;
            if (map.containsKey(api)) {
                signInOptions = (SignInOptions) this.f19971j.get(api);
            }
            return new ClientSettings(this.f19962a, this.f19963b, this.f19969h, this.f19965d, this.f19966e, this.f19967f, this.f19968g, signInOptions, false);
        }

        @KeepForSdk
        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            Preconditions.s(connectionCallbacks, "Must provide a connected listener");
            this.q.add(connectionCallbacks);
            Preconditions.s(onConnectionFailedListener, "Must provide a connection failed listener");
            this.r.add(onConnectionFailedListener);
        }
    }

    @Deprecated
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {

        /* renamed from: j  reason: collision with root package name */
        public static final int f19976j = 1;

        /* renamed from: k  reason: collision with root package name */
        public static final int f19977k = 2;
    }

    @Deprecated
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    public static void k(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        Set<GoogleApiClient> set = f19961d;
        synchronized (set) {
            try {
                String concat = String.valueOf(str).concat("  ");
                int i2 = 0;
                for (GoogleApiClient j2 : set) {
                    printWriter.append(str).append("GoogleApiClient#").println(i2);
                    j2.j(concat, fileDescriptor, printWriter, strArr);
                    i2++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static Set<GoogleApiClient> n() {
        Set<GoogleApiClient> set = f19961d;
        synchronized (set) {
        }
        return set;
    }

    public abstract void A();

    public abstract void B(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void C(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    @KeepForSdk
    public <L> ListenerHolder<L> D(@NonNull L l2) {
        throw new UnsupportedOperationException();
    }

    public abstract void E(@NonNull FragmentActivity fragmentActivity);

    public abstract void F(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void G(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public void H(zada zada) {
        throw new UnsupportedOperationException();
    }

    public void I(zada zada) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract ConnectionResult d();

    @NonNull
    public abstract ConnectionResult e(long j2, @NonNull TimeUnit timeUnit);

    @NonNull
    public abstract PendingResult<Status> f();

    public abstract void g();

    public void h(int i2) {
        throw new UnsupportedOperationException();
    }

    public abstract void i();

    public abstract void j(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr);

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T l(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T m(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public <C extends Api.Client> C o(@NonNull Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract ConnectionResult p(@NonNull Api<?> api);

    @NonNull
    @KeepForSdk
    public Context q() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public Looper r() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean s(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean t(@NonNull Api<?> api);

    public abstract boolean u();

    public abstract boolean v();

    public abstract boolean w(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean x(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public boolean y(@NonNull SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void z() {
        throw new UnsupportedOperationException();
    }
}

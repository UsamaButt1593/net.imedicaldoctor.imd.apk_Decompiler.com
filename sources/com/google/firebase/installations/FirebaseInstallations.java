package com.google.firebase.installations;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Lazy;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class FirebaseInstallations implements FirebaseInstallationsApi {

    /* renamed from: m  reason: collision with root package name */
    private static final Object f24411m = new Object();

    /* renamed from: n  reason: collision with root package name */
    private static final String f24412n = "generatefid.lock";
    private static final String o = "CHIME_ANDROID_SDK";
    private static final int p = 0;
    private static final int q = 1;
    private static final long r = 30;
    private static final ThreadFactory s = new ThreadFactory() {
        private final AtomicInteger s = new AtomicInteger(1);

        @SuppressLint({"ThreadPoolCreation"})
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.s.getAndIncrement())}));
        }
    };
    private static final String t = "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final String u = "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final String v = "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.";
    private static final String w = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.";

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f24413a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseInstallationServiceClient f24414b;

    /* renamed from: c  reason: collision with root package name */
    private final PersistedInstallation f24415c;

    /* renamed from: d  reason: collision with root package name */
    private final Utils f24416d;

    /* renamed from: e  reason: collision with root package name */
    private final Lazy<IidStore> f24417e;

    /* renamed from: f  reason: collision with root package name */
    private final RandomFidGenerator f24418f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f24419g;

    /* renamed from: h  reason: collision with root package name */
    private final ExecutorService f24420h;

    /* renamed from: i  reason: collision with root package name */
    private final Executor f24421i;
    @GuardedBy("this")

    /* renamed from: j  reason: collision with root package name */
    private String f24422j;
    /* access modifiers changed from: private */
    @GuardedBy("FirebaseInstallations.this")

    /* renamed from: k  reason: collision with root package name */
    public Set<FidListener> f24423k;
    @GuardedBy("lock")

    /* renamed from: l  reason: collision with root package name */
    private final List<StateListener> f24424l;

    /* renamed from: com.google.firebase.installations.FirebaseInstallations$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24427a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f24428b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        static {
            /*
                com.google.firebase.installations.remote.TokenResult$ResponseCode[] r0 = com.google.firebase.installations.remote.TokenResult.ResponseCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24428b = r0
                r1 = 1
                com.google.firebase.installations.remote.TokenResult$ResponseCode r2 = com.google.firebase.installations.remote.TokenResult.ResponseCode.OK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f24428b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.installations.remote.TokenResult$ResponseCode r3 = com.google.firebase.installations.remote.TokenResult.ResponseCode.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = f24428b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.installations.remote.TokenResult$ResponseCode r3 = com.google.firebase.installations.remote.TokenResult.ResponseCode.AUTH_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode[] r2 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f24427a = r2
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode r3 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.OK     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = f24427a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.firebase.installations.remote.InstallationResponse$ResponseCode r2 = com.google.firebase.installations.remote.InstallationResponse.ResponseCode.BAD_CONFIG     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.AnonymousClass3.<clinit>():void");
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    FirebaseInstallations(FirebaseApp firebaseApp, @NonNull Provider<HeartBeatController> provider, @NonNull ExecutorService executorService, @NonNull Executor executor) {
        this(executorService, executor, firebaseApp, new FirebaseInstallationServiceClient(firebaseApp.n(), provider), new PersistedInstallation(firebaseApp), Utils.c(), new Lazy(new a(firebaseApp)), new RandomFidGenerator());
    }

    private void A(PersistedInstallationEntry persistedInstallationEntry) {
        CrossProcessLock a2;
        synchronized (f24411m) {
            try {
                a2 = CrossProcessLock.a(this.f24413a.n(), f24412n);
                this.f24415c.c(persistedInstallationEntry);
                if (a2 != null) {
                    a2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C() {
        D(false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ IidStore E(FirebaseApp firebaseApp) {
        return new IidStore(firebaseApp);
    }

    private void F() {
        Preconditions.m(r(), u);
        Preconditions.m(z(), v);
        Preconditions.m(q(), t);
        Preconditions.b(Utils.h(r()), u);
        Preconditions.b(Utils.g(q()), t);
    }

    private String G(PersistedInstallationEntry persistedInstallationEntry) {
        if ((!this.f24413a.r().equals(o) && !this.f24413a.B()) || !persistedInstallationEntry.m()) {
            return this.f24418f.a();
        }
        String f2 = t().f();
        return TextUtils.isEmpty(f2) ? this.f24418f.a() : f2;
    }

    private PersistedInstallationEntry H(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        InstallationResponse d2 = this.f24414b.d(q(), persistedInstallationEntry.d(), z(), r(), (persistedInstallationEntry.d() == null || persistedInstallationEntry.d().length() != 11) ? null : t().i());
        int i2 = AnonymousClass3.f24427a[d2.e().ordinal()];
        if (i2 == 1) {
            return persistedInstallationEntry.s(d2.c(), d2.d(), this.f24416d.b(), d2.b().c(), d2.b().d());
        } else if (i2 == 2) {
            return persistedInstallationEntry.q("BAD CONFIG");
        } else {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    private void I(Exception exc) {
        synchronized (this.f24419g) {
            try {
                Iterator<StateListener> it2 = this.f24424l.iterator();
                while (it2.hasNext()) {
                    if (it2.next().a(exc)) {
                        it2.remove();
                    }
                }
            } finally {
            }
        }
    }

    private void J(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.f24419g) {
            try {
                Iterator<StateListener> it2 = this.f24424l.iterator();
                while (it2.hasNext()) {
                    if (it2.next().b(persistedInstallationEntry)) {
                        it2.remove();
                    }
                }
            } finally {
            }
        }
    }

    private synchronized void K(String str) {
        this.f24422j = str;
    }

    private synchronized void L(PersistedInstallationEntry persistedInstallationEntry, PersistedInstallationEntry persistedInstallationEntry2) {
        if (this.f24423k.size() != 0 && !TextUtils.equals(persistedInstallationEntry.d(), persistedInstallationEntry2.d())) {
            for (FidListener a2 : this.f24423k) {
                a2.a(persistedInstallationEntry2.d());
            }
        }
    }

    private Task<InstallationTokenResult> j() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        l(new GetAuthTokenListener(this.f24416d, taskCompletionSource));
        return taskCompletionSource.a();
    }

    private Task<String> k() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        l(new GetIdListener(taskCompletionSource));
        return taskCompletionSource.a();
    }

    private void l(StateListener stateListener) {
        synchronized (this.f24419g) {
            this.f24424l.add(stateListener);
        }
    }

    /* access modifiers changed from: private */
    public Void m() throws FirebaseInstallationsException {
        K((String) null);
        PersistedInstallationEntry w2 = w();
        if (w2.k()) {
            this.f24414b.e(q(), w2.d(), z(), w2.f());
        }
        A(w2.r());
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c  */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.local.PersistedInstallationEntry r0 = r2.w()
            boolean r1 = r0.i()     // Catch:{ FirebaseInstallationsException -> 0x001d }
            if (r1 != 0) goto L_0x0024
            boolean r1 = r0.l()     // Catch:{ FirebaseInstallationsException -> 0x001d }
            if (r1 == 0) goto L_0x0011
            goto L_0x0024
        L_0x0011:
            if (r3 != 0) goto L_0x001f
            com.google.firebase.installations.Utils r3 = r2.f24416d     // Catch:{ FirebaseInstallationsException -> 0x001d }
            boolean r3 = r3.f(r0)     // Catch:{ FirebaseInstallationsException -> 0x001d }
            if (r3 == 0) goto L_0x001c
            goto L_0x001f
        L_0x001c:
            return
        L_0x001d:
            r3 = move-exception
            goto L_0x005e
        L_0x001f:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.p(r0)     // Catch:{ FirebaseInstallationsException -> 0x001d }
            goto L_0x0028
        L_0x0024:
            com.google.firebase.installations.local.PersistedInstallationEntry r3 = r2.H(r0)     // Catch:{ FirebaseInstallationsException -> 0x001d }
        L_0x0028:
            r2.A(r3)
            r2.L(r0, r3)
            boolean r0 = r3.k()
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r3.d()
            r2.K(r0)
        L_0x003b:
            boolean r0 = r3.i()
            if (r0 == 0) goto L_0x004c
            com.google.firebase.installations.FirebaseInstallationsException r3 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r0 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
            r3.<init>(r0)
        L_0x0048:
            r2.I(r3)
            goto L_0x005d
        L_0x004c:
            boolean r0 = r3.j()
            if (r0 == 0) goto L_0x005a
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r3.<init>(r0)
            goto L_0x0048
        L_0x005a:
            r2.J(r3)
        L_0x005d:
            return
        L_0x005e:
            r2.I(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.FirebaseInstallations.B(boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public final void D(boolean z) {
        PersistedInstallationEntry y = y();
        if (z) {
            y = y.p();
        }
        J(y);
        this.f24421i.execute(new b(this, z));
    }

    private PersistedInstallationEntry p(@NonNull PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        TokenResult f2 = this.f24414b.f(q(), persistedInstallationEntry.d(), z(), persistedInstallationEntry.f());
        int i2 = AnonymousClass3.f24428b[f2.b().ordinal()];
        if (i2 == 1) {
            return persistedInstallationEntry.o(f2.c(), f2.d(), this.f24416d.b());
        } else if (i2 == 2) {
            return persistedInstallationEntry.q("BAD CONFIG");
        } else {
            if (i2 == 3) {
                K((String) null);
                return persistedInstallationEntry.r();
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    private synchronized String s() {
        return this.f24422j;
    }

    private IidStore t() {
        return this.f24417e.get();
    }

    @NonNull
    public static FirebaseInstallations u() {
        return v(FirebaseApp.p());
    }

    @NonNull
    public static FirebaseInstallations v(@NonNull FirebaseApp firebaseApp) {
        Preconditions.b(firebaseApp != null, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations) firebaseApp.l(FirebaseInstallationsApi.class);
    }

    private PersistedInstallationEntry w() {
        CrossProcessLock a2;
        PersistedInstallationEntry e2;
        synchronized (f24411m) {
            try {
                a2 = CrossProcessLock.a(this.f24413a.n(), f24412n);
                e2 = this.f24415c.e();
                if (a2 != null) {
                    a2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return e2;
    }

    private PersistedInstallationEntry y() {
        CrossProcessLock a2;
        PersistedInstallationEntry e2;
        synchronized (f24411m) {
            try {
                a2 = CrossProcessLock.a(this.f24413a.n(), f24412n);
                e2 = this.f24415c.e();
                if (e2.j()) {
                    e2 = this.f24415c.c(e2.t(G(e2)));
                }
                if (a2 != null) {
                    a2.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return e2;
    }

    @NonNull
    public Task<Void> a() {
        return Tasks.d(this.f24420h, new d(this));
    }

    @NonNull
    public synchronized FidListenerHandle b(@NonNull final FidListener fidListener) {
        this.f24423k.add(fidListener);
        return new FidListenerHandle() {
            public void a() {
                synchronized (FirebaseInstallations.this) {
                    FirebaseInstallations.this.f24423k.remove(fidListener);
                }
            }
        };
    }

    @NonNull
    public Task<InstallationTokenResult> c(boolean z) {
        F();
        Task<InstallationTokenResult> j2 = j();
        this.f24420h.execute(new e(this, z));
        return j2;
    }

    @NonNull
    public Task<String> getId() {
        F();
        String s2 = s();
        if (s2 != null) {
            return Tasks.g(s2);
        }
        Task<String> k2 = k();
        this.f24420h.execute(new c(this));
        return k2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String q() {
        return this.f24413a.s().i();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public String r() {
        return this.f24413a.s().j();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public String x() {
        return this.f24413a.r();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String z() {
        return this.f24413a.s().n();
    }

    @SuppressLint({"ThreadPoolCreation"})
    FirebaseInstallations(ExecutorService executorService, Executor executor, FirebaseApp firebaseApp, FirebaseInstallationServiceClient firebaseInstallationServiceClient, PersistedInstallation persistedInstallation, Utils utils, Lazy<IidStore> lazy, RandomFidGenerator randomFidGenerator) {
        this.f24419g = new Object();
        this.f24423k = new HashSet();
        this.f24424l = new ArrayList();
        this.f24413a = firebaseApp;
        this.f24414b = firebaseInstallationServiceClient;
        this.f24415c = persistedInstallation;
        this.f24416d = utils;
        this.f24417e = lazy;
        this.f24418f = randomFidGenerator;
        this.f24420h = executorService;
        this.f24421i = executor;
    }
}

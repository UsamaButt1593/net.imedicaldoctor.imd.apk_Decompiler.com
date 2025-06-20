package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.dash.offline.a;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FirebaseMessaging {

    /* renamed from: m  reason: collision with root package name */
    static final String f24752m = "FirebaseMessaging";

    /* renamed from: n  reason: collision with root package name */
    static final String f24753n = "com.google.android.gms";
    private static final String o = "com.google.android.gcm.intent.SEND";
    private static final String p = "app";
    @Deprecated
    public static final String q = "FCM";
    private static final long r = 30;
    private static final long s = TimeUnit.HOURS.toSeconds(8);
    private static final String t = "";
    @GuardedBy("FirebaseMessaging.class")
    private static Store u;
    @VisibleForTesting
    static Provider<TransportFactory> v = new p();
    @VisibleForTesting
    @GuardedBy("FirebaseMessaging.class")
    static ScheduledExecutorService w;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final FirebaseApp f24754a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseInstanceIdInternal f24755b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f24756c;

    /* renamed from: d  reason: collision with root package name */
    private final GmsRpc f24757d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestDeduplicator f24758e;

    /* renamed from: f  reason: collision with root package name */
    private final AutoInit f24759f;

    /* renamed from: g  reason: collision with root package name */
    private final Executor f24760g;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f24761h;

    /* renamed from: i  reason: collision with root package name */
    private final Task<TopicsSubscriber> f24762i;

    /* renamed from: j  reason: collision with root package name */
    private final Metadata f24763j;
    @GuardedBy("this")

    /* renamed from: k  reason: collision with root package name */
    private boolean f24764k;

    /* renamed from: l  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f24765l;

    private class AutoInit {

        /* renamed from: f  reason: collision with root package name */
        private static final String f24766f = "firebase_messaging_auto_init_enabled";

        /* renamed from: g  reason: collision with root package name */
        private static final String f24767g = "com.google.firebase.messaging";

        /* renamed from: h  reason: collision with root package name */
        private static final String f24768h = "auto_init";

        /* renamed from: a  reason: collision with root package name */
        private final Subscriber f24769a;
        @GuardedBy("this")

        /* renamed from: b  reason: collision with root package name */
        private boolean f24770b;
        @GuardedBy("this")
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private EventHandler<DataCollectionDefaultChange> f24771c;
        @GuardedBy("this")
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Boolean f24772d;

        AutoInit(Subscriber subscriber) {
            this.f24769a = subscriber;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Event event) {
            if (c()) {
                FirebaseMessaging.this.h0();
            }
        }

        @Nullable
        private Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context n2 = FirebaseMessaging.this.f24754a.n();
            SharedPreferences sharedPreferences = n2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains(f24768h)) {
                return Boolean.valueOf(sharedPreferences.getBoolean(f24768h, false));
            }
            try {
                PackageManager packageManager = n2.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(n2.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(f24766f)) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(f24766f));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized void b() {
            try {
                if (!this.f24770b) {
                    Boolean e2 = e();
                    this.f24772d = e2;
                    if (e2 == null) {
                        x xVar = new x(this);
                        this.f24771c = xVar;
                        this.f24769a.a(DataCollectionDefaultChange.class, xVar);
                    }
                    this.f24770b = true;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c() {
            Boolean bool;
            try {
                b();
                bool = this.f24772d;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.f24754a.A();
        }

        /* access modifiers changed from: package-private */
        public synchronized void f(boolean z) {
            try {
                b();
                EventHandler<DataCollectionDefaultChange> eventHandler = this.f24771c;
                if (eventHandler != null) {
                    this.f24769a.d(DataCollectionDefaultChange.class, eventHandler);
                    this.f24771c = null;
                }
                SharedPreferences.Editor edit = FirebaseMessaging.this.f24754a.n().getSharedPreferences("com.google.firebase.messaging", 0).edit();
                edit.putBoolean(f24768h, z);
                edit.apply();
                if (z) {
                    FirebaseMessaging.this.h0();
                }
                this.f24772d = Boolean.valueOf(z);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    FirebaseMessaging(FirebaseApp firebaseApp, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<TransportFactory> provider, Subscriber subscriber, Metadata metadata, GmsRpc gmsRpc, Executor executor, Executor executor2, Executor executor3) {
        this.f24764k = false;
        v = provider;
        this.f24754a = firebaseApp;
        this.f24755b = firebaseInstanceIdInternal;
        this.f24759f = new AutoInit(subscriber);
        Context n2 = firebaseApp.n();
        this.f24756c = n2;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.f24765l = fcmLifecycleCallbacks;
        this.f24763j = metadata;
        this.f24757d = gmsRpc;
        this.f24758e = new RequestDeduplicator(executor);
        this.f24760g = executor2;
        this.f24761h = executor3;
        Context n3 = firebaseApp.n();
        if (n3 instanceof Application) {
            ((Application) n3).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            Log.w("FirebaseMessaging", "Context " + n3 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.c(new C0495k(this));
        }
        executor2.execute(new C0496l(this));
        Task<TopicsSubscriber> f2 = TopicsSubscriber.f(this, metadata, gmsRpc, n2, FcmExecutors.i());
        this.f24762i = f2;
        f2.l(executor2, new C0497m(this));
        executor2.execute(new n(this));
    }

    private String A() {
        return FirebaseApp.f23276l.equals(this.f24754a.r()) ? "" : this.f24754a.t();
    }

    @Nullable
    public static TransportFactory E() {
        return v.get();
    }

    private void F() {
        this.f24757d.f().l(this.f24760g, new t(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void V() {
        ProxyNotificationInitializer.c(this.f24756c);
        ProxyNotificationPreferences.g(this.f24756c, this.f24757d, f0());
        if (f0()) {
            F();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: H */
    public void S(String str) {
        if (FirebaseApp.f23276l.equals(this.f24754a.r())) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Invoking onNewToken for app: " + this.f24754a.r());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new FcmBroadcastProcessor(this.f24756c).k(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task L(String str, Store.Token token, String str2) throws Exception {
        z(this.f24756c).g(A(), str, str2, this.f24763j.a());
        if (token == null || !str2.equals(token.f24869a)) {
            S(str2);
        }
        return Tasks.g(str2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task M(String str, Store.Token token) {
        return this.f24757d.g().x(this.f24761h, new q(this, str, token));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TransportFactory N() {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(TaskCompletionSource taskCompletionSource) {
        try {
            this.f24755b.a(Metadata.c(this.f24754a), q);
            taskCompletionSource.c(null);
        } catch (Exception e2) {
            taskCompletionSource.b(e2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.a(this.f24757d.c());
            z(this.f24756c).d(A(), Metadata.c(this.f24754a));
            taskCompletionSource.c(null);
        } catch (Exception e2) {
            taskCompletionSource.b(e2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.c(r());
        } catch (Exception e2) {
            taskCompletionSource.b(e2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R(CloudMessage cloudMessage) {
        if (cloudMessage != null) {
            MessagingAnalytics.y(cloudMessage.N());
            F();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T() {
        if (I()) {
            h0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(TopicsSubscriber topicsSubscriber) {
        if (I()) {
            topicsSubscriber.r();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(Void voidR) {
        ProxyNotificationPreferences.g(this.f24756c, this.f24757d, f0());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TransportFactory X() {
        return null;
    }

    private boolean f0() {
        ProxyNotificationInitializer.c(this.f24756c);
        if (!ProxyNotificationInitializer.d(this.f24756c)) {
            return false;
        }
        if (this.f24754a.l(AnalyticsConnector.class) != null) {
            return true;
        }
        return MessagingAnalytics.a() && v != null;
    }

    private synchronized void g0() {
        if (!this.f24764k) {
            j0(0);
        }
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.l(FirebaseMessaging.class);
            Preconditions.s(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    /* access modifiers changed from: private */
    public void h0() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f24755b;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.d();
        } else if (k0(C())) {
            g0();
        }
    }

    @VisibleForTesting
    static synchronized void s() {
        synchronized (FirebaseMessaging.class) {
            u = null;
        }
    }

    static void t() {
        v = new o();
    }

    @NonNull
    public static synchronized FirebaseMessaging y() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(FirebaseApp.p());
        }
        return instance;
    }

    @NonNull
    private static synchronized Store z(Context context) {
        Store store;
        synchronized (FirebaseMessaging.class) {
            try {
                if (u == null) {
                    u = new Store(context);
                }
                store = u;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return store;
    }

    @NonNull
    public Task<String> B() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f24755b;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.b();
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f24760g.execute(new s(this, taskCompletionSource));
        return taskCompletionSource.a();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public Store.Token C() {
        return z(this.f24756c).e(A(), Metadata.c(this.f24754a));
    }

    /* access modifiers changed from: package-private */
    public Task<TopicsSubscriber> D() {
        return this.f24762i;
    }

    public boolean I() {
        return this.f24759f.c();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean J() {
        return this.f24763j.g();
    }

    public boolean K() {
        return ProxyNotificationInitializer.d(this.f24756c);
    }

    @Deprecated
    public void a0(@NonNull RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.a0())) {
            Intent intent = new Intent(o);
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra(p, PendingIntent.getBroadcast(this.f24756c, 0, intent2, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
            intent.setPackage("com.google.android.gms");
            remoteMessage.d0(intent);
            this.f24756c.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void b0(boolean z) {
        this.f24759f.f(z);
    }

    public void c0(boolean z) {
        MessagingAnalytics.B(z);
        ProxyNotificationPreferences.g(this.f24756c, this.f24757d, f0());
    }

    @NonNull
    public Task<Void> d0(boolean z) {
        return ProxyNotificationInitializer.f(this.f24760g, this.f24756c, z).l(new a(), new C0498r(this));
    }

    /* access modifiers changed from: package-private */
    public synchronized void e0(boolean z) {
        this.f24764k = z;
    }

    @SuppressLint({"TaskMainThread"})
    @NonNull
    public Task<Void> i0(@NonNull String str) {
        return this.f24762i.w(new C0493i(str));
    }

    /* access modifiers changed from: package-private */
    public synchronized void j0(long j2) {
        w(new SyncTask(this, Math.min(Math.max(r, 2 * j2), s)), j2);
        this.f24764k = true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean k0(@Nullable Store.Token token) {
        return token == null || token.b(this.f24763j.a());
    }

    @SuppressLint({"TaskMainThread"})
    @NonNull
    public Task<Void> l0(@NonNull String str) {
        return this.f24762i.w(new u(str));
    }

    /* access modifiers changed from: package-private */
    public String r() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f24755b;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.a(firebaseInstanceIdInternal.b());
            } catch (InterruptedException | ExecutionException e2) {
                throw new IOException(e2);
            }
        } else {
            Store.Token C = C();
            if (!k0(C)) {
                return C.f24869a;
            }
            String c2 = Metadata.c(this.f24754a);
            try {
                return (String) Tasks.a(this.f24758e.b(c2, new v(this, c2, C)));
            } catch (InterruptedException | ExecutionException e3) {
                throw new IOException(e3);
            }
        }
    }

    @NonNull
    public Task<Void> u() {
        if (this.f24755b != null) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f24760g.execute(new w(this, taskCompletionSource));
            return taskCompletionSource.a();
        } else if (C() == null) {
            return Tasks.g(null);
        } else {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            FcmExecutors.f().execute(new C0494j(this, taskCompletionSource2));
            return taskCompletionSource2.a();
        }
    }

    @NonNull
    public boolean v() {
        return MessagingAnalytics.a();
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public void w(Runnable runnable, long j2) {
        synchronized (FirebaseMessaging.class) {
            try {
                if (w == null) {
                    w = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
                }
                w.schedule(runnable, j2, TimeUnit.SECONDS);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Context x() {
        return this.f24756c;
    }

    FirebaseMessaging(FirebaseApp firebaseApp, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider3, Subscriber subscriber) {
        this(firebaseApp, firebaseInstanceIdInternal, provider, provider2, firebaseInstallationsApi, provider3, subscriber, new Metadata(firebaseApp.n()));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    FirebaseMessaging(com.google.firebase.FirebaseApp r11, @androidx.annotation.Nullable com.google.firebase.iid.internal.FirebaseInstanceIdInternal r12, com.google.firebase.inject.Provider<com.google.firebase.platforminfo.UserAgentPublisher> r13, com.google.firebase.inject.Provider<com.google.firebase.heartbeatinfo.HeartBeatInfo> r14, com.google.firebase.installations.FirebaseInstallationsApi r15, com.google.firebase.inject.Provider<com.google.android.datatransport.TransportFactory> r16, com.google.firebase.events.Subscriber r17, com.google.firebase.messaging.Metadata r18) {
        /*
            r10 = this;
            com.google.firebase.messaging.GmsRpc r6 = new com.google.firebase.messaging.GmsRpc
            r0 = r6
            r1 = r11
            r2 = r18
            r3 = r13
            r4 = r14
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            java.util.concurrent.ExecutorService r7 = com.google.firebase.messaging.FcmExecutors.h()
            java.util.concurrent.ScheduledExecutorService r8 = com.google.firebase.messaging.FcmExecutors.d()
            java.util.concurrent.Executor r9 = com.google.firebase.messaging.FcmExecutors.c()
            r0 = r10
            r2 = r12
            r3 = r16
            r4 = r17
            r5 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FirebaseMessaging.<init>(com.google.firebase.FirebaseApp, com.google.firebase.iid.internal.FirebaseInstanceIdInternal, com.google.firebase.inject.Provider, com.google.firebase.inject.Provider, com.google.firebase.installations.FirebaseInstallationsApi, com.google.firebase.inject.Provider, com.google.firebase.events.Subscriber, com.google.firebase.messaging.Metadata):void");
    }
}

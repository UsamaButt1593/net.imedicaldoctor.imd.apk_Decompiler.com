package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import androidx.lifecycle.g;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.events.Publisher;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.provider.FirebaseInitProvider;
import com.google.firebase.tracing.ComponentMonitor;
import com.google.firebase.tracing.FirebaseTrace;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp {

    /* renamed from: k  reason: collision with root package name */
    private static final String f23275k = "FirebaseApp";
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public static final String f23276l = "[DEFAULT]";
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Object f23277m = new Object();
    @GuardedBy("LOCK")

    /* renamed from: n  reason: collision with root package name */
    static final Map<String, FirebaseApp> f23278n = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    private final Context f23279a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23280b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseOptions f23281c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentRuntime f23282d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f23283e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f23284f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private final Lazy<DataCollectionConfigStorage> f23285g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<DefaultHeartBeatController> f23286h;

    /* renamed from: i  reason: collision with root package name */
    private final List<BackgroundStateChangeListener> f23287i = new CopyOnWriteArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final List<FirebaseAppLifecycleListener> f23288j = new CopyOnWriteArrayList();

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void a(boolean z);
    }

    @TargetApi(14)
    private static class GlobalBackgroundStateListener implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<GlobalBackgroundStateListener> f23289a = new AtomicReference<>();

        private GlobalBackgroundStateListener() {
        }

        /* access modifiers changed from: private */
        public static void c(Context context) {
            if (PlatformVersion.c() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f23289a.get() == null) {
                    GlobalBackgroundStateListener globalBackgroundStateListener = new GlobalBackgroundStateListener();
                    if (g.a(f23289a, (Object) null, globalBackgroundStateListener)) {
                        BackgroundDetector.c(application);
                        BackgroundDetector.b().a(globalBackgroundStateListener);
                    }
                }
            }
        }

        public void a(boolean z) {
            synchronized (FirebaseApp.f23277m) {
                try {
                    Iterator it2 = new ArrayList(FirebaseApp.f23278n.values()).iterator();
                    while (it2.hasNext()) {
                        FirebaseApp firebaseApp = (FirebaseApp) it2.next();
                        if (firebaseApp.f23283e.get()) {
                            firebaseApp.F(z);
                        }
                    }
                } finally {
                }
            }
        }
    }

    @TargetApi(24)
    private static class UserUnlockReceiver extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private static AtomicReference<UserUnlockReceiver> f23290b = new AtomicReference<>();

        /* renamed from: a  reason: collision with root package name */
        private final Context f23291a;

        public UserUnlockReceiver(Context context) {
            this.f23291a = context;
        }

        /* access modifiers changed from: private */
        public static void b(Context context) {
            if (f23290b.get() == null) {
                UserUnlockReceiver userUnlockReceiver = new UserUnlockReceiver(context);
                if (g.a(f23290b, (Object) null, userUnlockReceiver)) {
                    context.registerReceiver(userUnlockReceiver, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f23291a.unregisterReceiver(this);
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.f23277m) {
                try {
                    for (FirebaseApp d2 : FirebaseApp.f23278n.values()) {
                        d2.v();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            c();
        }
    }

    protected FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.f23279a = (Context) Preconditions.r(context);
        this.f23280b = Preconditions.l(str);
        this.f23281c = (FirebaseOptions) Preconditions.r(firebaseOptions);
        StartupTime b2 = FirebaseInitProvider.b();
        FirebaseTrace.b("Firebase");
        FirebaseTrace.b("ComponentDiscovery");
        List<Provider<ComponentRegistrar>> c2 = ComponentDiscovery.d(context, ComponentDiscoveryService.class).c();
        FirebaseTrace.a();
        FirebaseTrace.b("Runtime");
        ComponentRuntime.Builder g2 = ComponentRuntime.p(UiExecutor.INSTANCE).d(c2).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(Component.D(context, Context.class, new Class[0])).b(Component.D(this, FirebaseApp.class, new Class[0])).b(Component.D(firebaseOptions, FirebaseOptions.class, new Class[0])).g(new ComponentMonitor());
        if (UserManagerCompat.a(context) && FirebaseInitProvider.c()) {
            g2.b(Component.D(b2, StartupTime.class, new Class[0]));
        }
        ComponentRuntime e2 = g2.e();
        this.f23282d = e2;
        FirebaseTrace.a();
        this.f23285g = new Lazy<>(new a(this, context));
        this.f23286h = e2.c(DefaultHeartBeatController.class);
        g(new b(this));
        FirebaseTrace.a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DataCollectionConfigStorage C(Context context) {
        return new DataCollectionConfigStorage(context, t(), (Publisher) this.f23282d.a(Publisher.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D(boolean z) {
        if (!z) {
            this.f23286h.get().l();
        }
    }

    private static String E(@NonNull String str) {
        return str.trim();
    }

    /* access modifiers changed from: private */
    public void F(boolean z) {
        Log.d(f23275k, "Notifying background state change listeners.");
        for (BackgroundStateChangeListener a2 : this.f23287i) {
            a2.a(z);
        }
    }

    private void G() {
        for (FirebaseAppLifecycleListener a2 : this.f23288j) {
            a2.a(this.f23280b, this.f23281c);
        }
    }

    private void i() {
        Preconditions.y(!this.f23284f.get(), "FirebaseApp was deleted");
    }

    @VisibleForTesting
    public static void j() {
        synchronized (f23277m) {
            f23278n.clear();
        }
    }

    private static List<String> m() {
        ArrayList arrayList = new ArrayList();
        synchronized (f23277m) {
            try {
                for (FirebaseApp r : f23278n.values()) {
                    arrayList.add(r.r());
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @NonNull
    public static List<FirebaseApp> o(@NonNull Context context) {
        ArrayList arrayList;
        synchronized (f23277m) {
            arrayList = new ArrayList(f23278n.values());
        }
        return arrayList;
    }

    @NonNull
    public static FirebaseApp p() {
        FirebaseApp firebaseApp;
        synchronized (f23277m) {
            try {
                firebaseApp = f23278n.get(f23276l);
                if (firebaseApp != null) {
                    firebaseApp.f23286h.get().l();
                } else {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseApp;
    }

    @NonNull
    public static FirebaseApp q(@NonNull String str) {
        FirebaseApp firebaseApp;
        String str2;
        synchronized (f23277m) {
            try {
                firebaseApp = f23278n.get(E(str));
                if (firebaseApp != null) {
                    firebaseApp.f23286h.get().l();
                } else {
                    List<String> m2 = m();
                    if (m2.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = "Available app names: " + TextUtils.join(", ", m2);
                    }
                    throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, str2}));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return firebaseApp;
    }

    @KeepForSdk
    public static String u(String str, FirebaseOptions firebaseOptions) {
        return Base64Utils.f(str.getBytes(Charset.defaultCharset())) + "+" + Base64Utils.f(firebaseOptions.j().getBytes(Charset.defaultCharset()));
    }

    /* access modifiers changed from: private */
    public void v() {
        if (!UserManagerCompat.a(this.f23279a)) {
            Log.i(f23275k, "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + r());
            UserUnlockReceiver.b(this.f23279a);
            return;
        }
        Log.i(f23275k, "Device unlocked: initializing all Firebase APIs for app " + r());
        this.f23282d.u(B());
        this.f23286h.get().l();
    }

    @Nullable
    public static FirebaseApp x(@NonNull Context context) {
        synchronized (f23277m) {
            try {
                if (f23278n.containsKey(f23276l)) {
                    FirebaseApp p = p();
                    return p;
                }
                FirebaseOptions h2 = FirebaseOptions.h(context);
                if (h2 == null) {
                    Log.w(f23275k, "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                FirebaseApp y = y(context, h2);
                return y;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @NonNull
    public static FirebaseApp y(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions) {
        return z(context, firebaseOptions, f23276l);
    }

    @NonNull
    public static FirebaseApp z(@NonNull Context context, @NonNull FirebaseOptions firebaseOptions, @NonNull String str) {
        FirebaseApp firebaseApp;
        GlobalBackgroundStateListener.c(context);
        String E = E(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f23277m) {
            Map<String, FirebaseApp> map = f23278n;
            Preconditions.y(!map.containsKey(E), "FirebaseApp name " + E + " already exists!");
            Preconditions.s(context, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, E, firebaseOptions);
            map.put(E, firebaseApp);
        }
        firebaseApp.v();
        return firebaseApp;
    }

    @KeepForSdk
    public boolean A() {
        i();
        return this.f23285g.get().b();
    }

    @VisibleForTesting
    @KeepForSdk
    public boolean B() {
        return f23276l.equals(r());
    }

    @KeepForSdk
    public void H(BackgroundStateChangeListener backgroundStateChangeListener) {
        i();
        this.f23287i.remove(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void I(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        i();
        Preconditions.r(firebaseAppLifecycleListener);
        this.f23288j.remove(firebaseAppLifecycleListener);
    }

    public void J(boolean z) {
        boolean z2;
        i();
        if (this.f23283e.compareAndSet(!z, z)) {
            boolean d2 = BackgroundDetector.b().d();
            if (z && d2) {
                z2 = true;
            } else if (!z && d2) {
                z2 = false;
            } else {
                return;
            }
            F(z2);
        }
    }

    @KeepForSdk
    public void K(Boolean bool) {
        i();
        this.f23285g.get().e(bool);
    }

    @KeepForSdk
    @Deprecated
    public void L(boolean z) {
        K(Boolean.valueOf(z));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.f23280b.equals(((FirebaseApp) obj).r());
    }

    @KeepForSdk
    public void g(BackgroundStateChangeListener backgroundStateChangeListener) {
        i();
        if (this.f23283e.get() && BackgroundDetector.b().d()) {
            backgroundStateChangeListener.a(true);
        }
        this.f23287i.add(backgroundStateChangeListener);
    }

    @KeepForSdk
    public void h(@NonNull FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        i();
        Preconditions.r(firebaseAppLifecycleListener);
        this.f23288j.add(firebaseAppLifecycleListener);
    }

    public int hashCode() {
        return this.f23280b.hashCode();
    }

    public void k() {
        if (this.f23284f.compareAndSet(false, true)) {
            synchronized (f23277m) {
                f23278n.remove(this.f23280b);
            }
            G();
        }
    }

    @KeepForSdk
    public <T> T l(Class<T> cls) {
        i();
        return this.f23282d.a(cls);
    }

    @NonNull
    public Context n() {
        i();
        return this.f23279a;
    }

    @NonNull
    public String r() {
        i();
        return this.f23280b;
    }

    @NonNull
    public FirebaseOptions s() {
        i();
        return this.f23281c;
    }

    @KeepForSdk
    public String t() {
        return Base64Utils.f(r().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.f(s().j().getBytes(Charset.defaultCharset()));
    }

    public String toString() {
        return Objects.d(this).a("name", this.f23280b).a("options", this.f23281c).toString();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.TESTS})
    public void w() {
        this.f23282d.t();
    }
}

package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppInitializer {

    /* renamed from: d  reason: collision with root package name */
    private static final String f15844d = "Startup";

    /* renamed from: e  reason: collision with root package name */
    private static volatile AppInitializer f15845e;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f15846f = new Object();
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final Map<Class<?>, Object> f15847a = new HashMap();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final Set<Class<? extends Initializer<?>>> f15848b = new HashSet();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final Context f15849c;

    AppInitializer(@NonNull Context context) {
        this.f15849c = context.getApplicationContext();
    }

    @NonNull
    private <T> T d(@NonNull Class<? extends Initializer<?>> cls, @NonNull Set<Class<?>> set) {
        T t;
        if (Trace.h()) {
            try {
                Trace.c(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.f();
                throw th;
            }
        }
        if (!set.contains(cls)) {
            if (!this.f15847a.containsKey(cls)) {
                set.add(cls);
                Initializer initializer = (Initializer) cls.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                List<Class<? extends Initializer<?>>> dependencies = initializer.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class next : dependencies) {
                        if (!this.f15847a.containsKey(next)) {
                            d(next, set);
                        }
                    }
                }
                t = initializer.a(this.f15849c);
                set.remove(cls);
                this.f15847a.put(cls, t);
            } else {
                t = this.f15847a.get(cls);
            }
            Trace.f();
            return t;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }

    @NonNull
    public static AppInitializer e(@NonNull Context context) {
        if (f15845e == null) {
            synchronized (f15846f) {
                try {
                    if (f15845e == null) {
                        f15845e = new AppInitializer(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15845e;
    }

    static void h(@NonNull AppInitializer appInitializer) {
        synchronized (f15846f) {
            f15845e = appInitializer;
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        try {
            Trace.c(f15844d);
            b(this.f15849c.getPackageManager().getProviderInfo(new ComponentName(this.f15849c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            Trace.f();
        } catch (PackageManager.NameNotFoundException e2) {
            throw new StartupException((Throwable) e2);
        } catch (Throwable th) {
            Trace.f();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(@Nullable Bundle bundle) {
        String string = this.f15849c.getString(R.string.f15850a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String next : bundle.keySet()) {
                    if (string.equals(bundle.getString(next, (String) null))) {
                        Class<?> cls = Class.forName(next);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            this.f15848b.add(cls);
                        }
                    }
                }
                for (Class<? extends Initializer<?>> d2 : this.f15848b) {
                    d(d2, hashSet);
                }
            } catch (ClassNotFoundException e2) {
                throw new StartupException((Throwable) e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public <T> T c(@NonNull Class<? extends Initializer<?>> cls) {
        T t;
        synchronized (f15846f) {
            try {
                t = this.f15847a.get(cls);
                if (t == null) {
                    t = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }

    @NonNull
    public <T> T f(@NonNull Class<? extends Initializer<T>> cls) {
        return c(cls);
    }

    public boolean g(@NonNull Class<? extends Initializer<?>> cls) {
        return this.f15848b.contains(cls);
    }
}

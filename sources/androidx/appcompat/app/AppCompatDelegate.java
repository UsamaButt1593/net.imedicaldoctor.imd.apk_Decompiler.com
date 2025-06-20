package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.app.AppLocalesStorageHelper;
import androidx.core.os.LocaleListCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Executor;

public abstract class AppCompatDelegate {
    static final String X = "AppCompatDelegate";
    public static final int X2 = -1;
    static SerialExecutor Y = new SerialExecutor(new ThreadPerTaskExecutor());
    @Deprecated
    public static final int Y2 = 0;
    static final String Z = "androidx.appcompat.app.AppLocalesMetadataHolderService";
    @Deprecated
    public static final int Z2 = 0;
    public static final int a3 = 1;
    public static final int b3 = 2;
    public static final int c3 = 3;
    public static final int d3 = -100;
    private static int e3 = -100;
    private static LocaleListCompat f3 = null;
    private static LocaleListCompat g3 = null;
    private static Boolean h3 = null;
    private static boolean i3 = false;
    private static final ArraySet<WeakReference<AppCompatDelegate>> j3 = new ArraySet<>();
    private static final Object k3 = new Object();
    private static final Object l3 = new Object();
    public static final int m3 = 108;
    public static final int n3 = 109;
    public static final int o3 = 10;
    static final boolean s = false;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        @DoNotInline
        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NightMode {
    }

    static class SerialExecutor implements Executor {
        final Queue<Runnable> X = new ArrayDeque();
        final Executor Y;
        Runnable Z;
        private final Object s = new Object();

        SerialExecutor(Executor executor) {
            this.Y = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Runnable runnable) {
            try {
                runnable.run();
            } finally {
                c();
            }
        }

        /* access modifiers changed from: protected */
        public void c() {
            synchronized (this.s) {
                try {
                    Runnable poll = this.X.poll();
                    this.Z = poll;
                    if (poll != null) {
                        this.Y.execute(poll);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void execute(Runnable runnable) {
            synchronized (this.s) {
                try {
                    this.X.add(new c(this, runnable));
                    if (this.Z == null) {
                        c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static class ThreadPerTaskExecutor implements Executor {
        ThreadPerTaskExecutor() {
        }

        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    AppCompatDelegate() {
    }

    @Nullable
    static LocaleListCompat A() {
        return f3;
    }

    @Nullable
    static LocaleListCompat B() {
        return g3;
    }

    static boolean G(Context context) {
        if (h3 == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    h3 = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d(X, "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                h3 = Boolean.FALSE;
            }
        }
        return h3.booleanValue();
    }

    public static boolean H() {
        return VectorEnabledTintResources.b();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void K(Context context) {
        l0(context);
        i3 = true;
    }

    static void T(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (k3) {
            U(appCompatDelegate);
        }
    }

    private static void U(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (k3) {
            try {
                Iterator<WeakReference<AppCompatDelegate>> it2 = j3.iterator();
                while (it2.hasNext()) {
                    AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate) it2.next().get();
                    if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                        it2.remove();
                    }
                }
            } finally {
            }
        }
    }

    @VisibleForTesting
    static void W() {
        f3 = null;
        g3 = null;
    }

    public static void X(@NonNull LocaleListCompat localeListCompat) {
        Objects.requireNonNull(localeListCompat);
        if (Build.VERSION.SDK_INT >= 33) {
            Object y = y();
            if (y != null) {
                Api33Impl.b(y, Api24Impl.a(localeListCompat.m()));
            }
        } else if (!localeListCompat.equals(f3)) {
            synchronized (k3) {
                f3 = localeListCompat;
                j();
            }
        }
    }

    public static void Y(boolean z) {
        VectorEnabledTintResources.c(z);
    }

    public static void c0(int i2) {
        if (i2 != -1 && i2 != 0 && i2 != 1 && i2 != 2 && i2 != 3) {
            Log.d(X, "setDefaultNightMode() called with an unknown mode");
        } else if (e3 != i2) {
            e3 = i2;
            i();
        }
    }

    static void e(@NonNull AppCompatDelegate appCompatDelegate) {
        synchronized (k3) {
            U(appCompatDelegate);
            j3.add(new WeakReference(appCompatDelegate));
        }
    }

    @VisibleForTesting
    static void e0(boolean z) {
        h3 = Boolean.valueOf(z);
    }

    private static void i() {
        synchronized (k3) {
            try {
                Iterator<WeakReference<AppCompatDelegate>> it2 = j3.iterator();
                while (it2.hasNext()) {
                    AppCompatDelegate appCompatDelegate = (AppCompatDelegate) it2.next().get();
                    if (appCompatDelegate != null) {
                        appCompatDelegate.h();
                    }
                }
            } finally {
            }
        }
    }

    private static void j() {
        Iterator<WeakReference<AppCompatDelegate>> it2 = j3.iterator();
        while (it2.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) it2.next().get();
            if (appCompatDelegate != null) {
                appCompatDelegate.g();
            }
        }
    }

    static void l0(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            ComponentName componentName = new ComponentName(context, Z);
            if (context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                if (t().j()) {
                    String b2 = AppLocalesStorageHelper.b(context);
                    Object systemService = context.getSystemService("locale");
                    if (systemService != null) {
                        Api33Impl.b(systemService, Api24Impl.a(b2));
                    }
                }
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m0(android.content.Context r3) {
        /*
            boolean r0 = G(r3)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r0 < r1) goto L_0x001c
            boolean r0 = i3
            if (r0 != 0) goto L_0x0057
            androidx.appcompat.app.AppCompatDelegate$SerialExecutor r0 = Y
            androidx.appcompat.app.a r1 = new androidx.appcompat.app.a
            r1.<init>(r3)
            r0.execute(r1)
            goto L_0x0057
        L_0x001c:
            java.lang.Object r0 = l3
            monitor-enter(r0)
            androidx.core.os.LocaleListCompat r1 = f3     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0043
            androidx.core.os.LocaleListCompat r1 = g3     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0034
            java.lang.String r3 = androidx.core.app.AppLocalesStorageHelper.b(r3)     // Catch:{ all -> 0x0032 }
            androidx.core.os.LocaleListCompat r3 = androidx.core.os.LocaleListCompat.c(r3)     // Catch:{ all -> 0x0032 }
            g3 = r3     // Catch:{ all -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            r3 = move-exception
            goto L_0x0058
        L_0x0034:
            androidx.core.os.LocaleListCompat r3 = g3     // Catch:{ all -> 0x0032 }
            boolean r3 = r3.j()     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x003e
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x003e:
            androidx.core.os.LocaleListCompat r3 = g3     // Catch:{ all -> 0x0032 }
            f3 = r3     // Catch:{ all -> 0x0032 }
            goto L_0x0056
        L_0x0043:
            androidx.core.os.LocaleListCompat r2 = g3     // Catch:{ all -> 0x0032 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0056
            androidx.core.os.LocaleListCompat r1 = f3     // Catch:{ all -> 0x0032 }
            g3 = r1     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r1.m()     // Catch:{ all -> 0x0032 }
            androidx.core.app.AppLocalesStorageHelper.a(r3, r1)     // Catch:{ all -> 0x0032 }
        L_0x0056:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
        L_0x0057:
            return
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegate.m0(android.content.Context):void");
    }

    @NonNull
    public static AppCompatDelegate n(@NonNull Activity activity, @Nullable AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(activity, appCompatCallback);
    }

    @NonNull
    public static AppCompatDelegate o(@NonNull Dialog dialog, @Nullable AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(dialog, appCompatCallback);
    }

    @NonNull
    public static AppCompatDelegate p(@NonNull Context context, @NonNull Activity activity, @Nullable AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(context, activity, appCompatCallback);
    }

    @NonNull
    public static AppCompatDelegate q(@NonNull Context context, @NonNull Window window, @Nullable AppCompatCallback appCompatCallback) {
        return new AppCompatDelegateImpl(context, window, appCompatCallback);
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat t() {
        if (Build.VERSION.SDK_INT >= 33) {
            Object y = y();
            if (y != null) {
                return LocaleListCompat.o(Api33Impl.a(y));
            }
        } else {
            LocaleListCompat localeListCompat = f3;
            if (localeListCompat != null) {
                return localeListCompat;
            }
        }
        return LocaleListCompat.g();
    }

    public static int v() {
        return e3;
    }

    @RequiresApi(33)
    static Object y() {
        Context u;
        Iterator<WeakReference<AppCompatDelegate>> it2 = j3.iterator();
        while (it2.hasNext()) {
            AppCompatDelegate appCompatDelegate = (AppCompatDelegate) it2.next().get();
            if (appCompatDelegate != null && (u = appCompatDelegate.u()) != null) {
                return u.getSystemService("locale");
            }
        }
        return null;
    }

    @Nullable
    public abstract ActionBar C();

    public abstract boolean D(int i2);

    public abstract void E();

    public abstract void F();

    public abstract boolean I();

    public abstract void L(Configuration configuration);

    public abstract void M(Bundle bundle);

    public abstract void N();

    public abstract void O(Bundle bundle);

    public abstract void P();

    public abstract void Q(Bundle bundle);

    public abstract void R();

    public abstract void S();

    public abstract boolean V(int i2);

    public abstract void Z(@LayoutRes int i2);

    public abstract void a0(View view);

    public abstract void b0(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void d0(boolean z);

    public abstract void f(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void f0(int i2);

    /* access modifiers changed from: package-private */
    public boolean g() {
        return false;
    }

    @RequiresApi(33)
    @CallSuper
    public void g0(@Nullable OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract boolean h();

    public abstract void h0(@Nullable Toolbar toolbar);

    public void i0(@StyleRes int i2) {
    }

    public abstract void j0(@Nullable CharSequence charSequence);

    /* access modifiers changed from: package-private */
    public void k(Context context) {
        Y.execute(new b(context));
    }

    @Nullable
    public abstract ActionMode k0(@NonNull ActionMode.Callback callback);

    @Deprecated
    public void l(Context context) {
    }

    @CallSuper
    @NonNull
    public Context m(@NonNull Context context) {
        l(context);
        return context;
    }

    public abstract View r(@Nullable View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet);

    @Nullable
    public abstract <T extends View> T s(@IdRes int i2);

    @Nullable
    public Context u() {
        return null;
    }

    @Nullable
    public abstract ActionBarDrawerToggle.Delegate w();

    public int x() {
        return -100;
    }

    public abstract MenuInflater z();
}

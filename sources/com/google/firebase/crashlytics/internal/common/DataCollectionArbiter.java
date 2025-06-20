package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.Executor;

public class DataCollectionArbiter {

    /* renamed from: i  reason: collision with root package name */
    private static final String f23640i = "firebase_crashlytics_collection_enabled";

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f23641a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f23642b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f23643c;

    /* renamed from: d  reason: collision with root package name */
    TaskCompletionSource<Void> f23644d = new TaskCompletionSource<>();

    /* renamed from: e  reason: collision with root package name */
    boolean f23645e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23646f = false;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Boolean f23647g;

    /* renamed from: h  reason: collision with root package name */
    private final TaskCompletionSource<Void> f23648h = new TaskCompletionSource<>();

    public DataCollectionArbiter(FirebaseApp firebaseApp) {
        Object obj = new Object();
        this.f23643c = obj;
        Context n2 = firebaseApp.n();
        this.f23642b = firebaseApp;
        this.f23641a = CommonUtils.r(n2);
        Boolean b2 = b();
        this.f23647g = b2 == null ? a(n2) : b2;
        synchronized (obj) {
            try {
                if (d()) {
                    this.f23644d.e(null);
                    this.f23645e = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private Boolean a(Context context) {
        Boolean g2 = g(context);
        if (g2 == null) {
            this.f23646f = false;
            return null;
        }
        this.f23646f = true;
        return Boolean.valueOf(Boolean.TRUE.equals(g2));
    }

    @Nullable
    private Boolean b() {
        if (!this.f23641a.contains(f23640i)) {
            return null;
        }
        this.f23646f = false;
        return Boolean.valueOf(this.f23641a.getBoolean(f23640i, true));
    }

    private boolean e() {
        try {
            return this.f23642b.A();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    private void f(boolean z) {
        Logger.f().b(String.format("Crashlytics automatic data collection %s by %s.", new Object[]{z ? "ENABLED" : "DISABLED", this.f23647g == null ? "global Firebase setting" : this.f23646f ? "firebase_crashlytics_collection_enabled manifest flag" : "API"}));
    }

    @Nullable
    private static Boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(f23640i)) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean(f23640i));
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.f().e("Could not read data collection permission from manifest", e2);
            return null;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private static void i(SharedPreferences sharedPreferences, Boolean bool) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (bool != null) {
            edit.putBoolean(f23640i, bool.booleanValue());
        } else {
            edit.remove(f23640i);
        }
        edit.apply();
    }

    public void c(boolean z) {
        if (z) {
            this.f23648h.e(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public synchronized boolean d() {
        boolean booleanValue;
        try {
            Boolean bool = this.f23647g;
            booleanValue = bool != null ? bool.booleanValue() : e();
            f(booleanValue);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return booleanValue;
    }

    public synchronized void h(@Nullable Boolean bool) {
        if (bool != null) {
            try {
                this.f23646f = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f23647g = bool != null ? bool : a(this.f23642b.n());
        i(this.f23641a, bool);
        synchronized (this.f23643c) {
            if (d()) {
                if (!this.f23645e) {
                    this.f23644d.e(null);
                    this.f23645e = true;
                }
            } else if (this.f23645e) {
                this.f23644d = new TaskCompletionSource<>();
                this.f23645e = false;
            }
        }
    }

    public Task<Void> j() {
        Task<Void> a2;
        synchronized (this.f23643c) {
            a2 = this.f23644d.a();
        }
        return a2;
    }

    public Task<Void> k(Executor executor) {
        return Utils.o(executor, this.f23648h.a(), j());
    }
}

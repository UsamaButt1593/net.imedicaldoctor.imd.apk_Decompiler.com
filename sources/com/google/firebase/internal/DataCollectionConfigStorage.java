package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;

public class DataCollectionConfigStorage {

    /* renamed from: e  reason: collision with root package name */
    private static final String f24607e = "com.google.firebase.common.prefs:";
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    public static final String f24608f = "firebase_data_collection_default_enabled";

    /* renamed from: a  reason: collision with root package name */
    private final Context f24609a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f24610b;

    /* renamed from: c  reason: collision with root package name */
    private final Publisher f24611c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24612d = c();

    public DataCollectionConfigStorage(Context context, String str, Publisher publisher) {
        Context a2 = a(context);
        this.f24609a = a2;
        this.f24610b = a2.getSharedPreferences(f24607e + str, 0);
        this.f24611c = publisher;
    }

    private static Context a(Context context) {
        return Build.VERSION.SDK_INT < 24 ? context : ContextCompat.c(context);
    }

    private boolean c() {
        return this.f24610b.contains(f24608f) ? this.f24610b.getBoolean(f24608f, true) : d();
    }

    private boolean d() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.f24609a.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(this.f24609a.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(f24608f)) {
                return true;
            }
            return applicationInfo.metaData.getBoolean(f24608f);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }

    private synchronized void f(boolean z) {
        if (this.f24612d != z) {
            this.f24612d = z;
            this.f24611c.c(new Event(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z)));
        }
    }

    public synchronized boolean b() {
        return this.f24612d;
    }

    public synchronized void e(Boolean bool) {
        boolean equals;
        if (bool == null) {
            try {
                this.f24610b.edit().remove(f24608f).apply();
                equals = d();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        } else {
            equals = Boolean.TRUE.equals(bool);
            this.f24610b.edit().putBoolean(f24608f, equals).apply();
        }
        f(equals);
    }
}

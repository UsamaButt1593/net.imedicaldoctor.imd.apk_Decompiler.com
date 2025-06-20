package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;

class Metadata {

    /* renamed from: f  reason: collision with root package name */
    private static final String f24799f = "com.google.android.c2dm.permission.SEND";

    /* renamed from: g  reason: collision with root package name */
    static final String f24800g = "com.google.android.gms";

    /* renamed from: h  reason: collision with root package name */
    private static final String f24801h = "com.google.iid.TOKEN_REQUEST";

    /* renamed from: i  reason: collision with root package name */
    private static final String f24802i = "com.google.android.c2dm.intent.REGISTER";

    /* renamed from: j  reason: collision with root package name */
    static final int f24803j = 0;

    /* renamed from: k  reason: collision with root package name */
    static final int f24804k = 1;

    /* renamed from: l  reason: collision with root package name */
    static final int f24805l = 2;

    /* renamed from: a  reason: collision with root package name */
    private final Context f24806a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private String f24807b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private String f24808c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f24809d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private int f24810e = 0;

    Metadata(Context context) {
        this.f24806a = context;
    }

    static String c(FirebaseApp firebaseApp) {
        String m2 = firebaseApp.s().m();
        if (m2 != null) {
            return m2;
        }
        String j2 = firebaseApp.s().j();
        if (!j2.startsWith("1:")) {
            return j2;
        }
        String[] split = j2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.f24806a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w(Constants.f24670a, "Failed to find package " + e2);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo f2 = f(this.f24806a.getPackageName());
        if (f2 != null) {
            this.f24807b = Integer.toString(f2.versionCode);
            this.f24808c = f2.versionName;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized String a() {
        try {
            if (this.f24807b == null) {
                h();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f24807b;
    }

    /* access modifiers changed from: package-private */
    public synchronized String b() {
        try {
            if (this.f24808c == null) {
                h();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f24808c;
    }

    /* access modifiers changed from: package-private */
    public synchronized int d() {
        PackageInfo f2;
        try {
            if (this.f24809d == 0 && (f2 = f("com.google.android.gms")) != null) {
                this.f24809d = f2.versionCode;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f24809d;
    }

    /* access modifiers changed from: package-private */
    public synchronized int e() {
        int i2 = this.f24810e;
        if (i2 != 0) {
            return i2;
        }
        PackageManager packageManager = this.f24806a.getPackageManager();
        if (packageManager.checkPermission(f24799f, "com.google.android.gms") == -1) {
            Log.e(Constants.f24670a, "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.n()) {
            Intent intent = new Intent(f24802i);
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f24810e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent(f24801h);
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w(Constants.f24670a, "Failed to resolve IID implementation package, falling back");
            if (PlatformVersion.n()) {
                this.f24810e = 2;
            } else {
                this.f24810e = 1;
            }
            return this.f24810e;
        }
        this.f24810e = 2;
        return 2;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return e() != 0;
    }
}

package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;

public final class zzw {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19838a;

    /* renamed from: b  reason: collision with root package name */
    private int f19839b;

    /* renamed from: c  reason: collision with root package name */
    private int f19840c = 0;

    public zzw(Context context) {
        this.f19838a = context;
    }

    public final synchronized int a() {
        PackageInfo packageInfo;
        if (this.f19839b == 0) {
            try {
                packageInfo = Wrappers.a(this.f19838a).f("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w("Metadata", "Failed to find package ".concat(e2.toString()));
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.f19839b = packageInfo.versionCode;
            }
        }
        return this.f19839b;
    }

    public final synchronized int b() {
        int i2 = this.f19840c;
        if (i2 != 0) {
            return i2;
        }
        Context context = this.f19838a;
        PackageManager packageManager = context.getPackageManager();
        if (Wrappers.a(context).b("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("Metadata", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i3 = 1;
        if (!PlatformVersion.n()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                this.f19840c = i3;
                return i3;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.isEmpty()) {
            Log.w("Metadata", "Failed to resolve IID implementation package, falling back");
            if (true == PlatformVersion.n()) {
                i3 = 2;
            }
            this.f19840c = i3;
            return i3;
        }
        i3 = 2;
        this.f19840c = i3;
        return i3;
    }
}

package com.google.firebase.crashlytics.internal.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.Logger;

class BatteryState {

    /* renamed from: c  reason: collision with root package name */
    static final int f23542c = 1;

    /* renamed from: d  reason: collision with root package name */
    static final int f23543d = 2;

    /* renamed from: e  reason: collision with root package name */
    static final int f23544e = 3;

    /* renamed from: a  reason: collision with root package name */
    private final Float f23545a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f23546b;

    private BatteryState(Float f2, boolean z) {
        this.f23546b = z;
        this.f23545a = f2;
    }

    public static BatteryState a(Context context) {
        boolean z = false;
        Float f2 = null;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z = f(registerReceiver);
                f2 = d(registerReceiver);
            }
        } catch (IllegalStateException e2) {
            Logger.f().e("An error occurred getting battery state.", e2);
        }
        return new BatteryState(f2, z);
    }

    private static Float d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(((float) intExtra) / ((float) intExtra2));
    }

    private static boolean f(Intent intent) {
        int intExtra = intent.getIntExtra(NotificationCompat.T0, -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    public Float b() {
        return this.f23545a;
    }

    public int c() {
        Float f2;
        if (!this.f23546b || (f2 = this.f23545a) == null) {
            return 1;
        }
        return ((double) f2.floatValue()) < 0.99d ? 2 : 3;
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f23546b;
    }
}

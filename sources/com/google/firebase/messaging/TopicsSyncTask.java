package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;

class TopicsSyncTask implements Runnable {
    private static final Object Y2 = new Object();
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean Z2;
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean a3;
    private final Metadata X;
    private final long X2;
    private final PowerManager.WakeLock Y;
    /* access modifiers changed from: private */
    public final TopicsSubscriber Z;
    /* access modifiers changed from: private */
    public final Context s;

    @VisibleForTesting
    class ConnectivityChangeReceiver extends BroadcastReceiver {
        @GuardedBy("this")
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private TopicsSyncTask f24900a;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.f24900a = topicsSyncTask;
        }

        public void a() {
            if (TopicsSyncTask.j()) {
                Log.d(Constants.f24670a, "Connectivity change received registered");
            }
            TopicsSyncTask.this.s.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        public synchronized void onReceive(Context context, Intent intent) {
            try {
                TopicsSyncTask topicsSyncTask = this.f24900a;
                if (topicsSyncTask != null) {
                    if (topicsSyncTask.i()) {
                        if (TopicsSyncTask.j()) {
                            Log.d(Constants.f24670a, "Connectivity changed. Starting background sync.");
                        }
                        this.f24900a.Z.n(this.f24900a, 0);
                        context.unregisterReceiver(this);
                        this.f24900a = null;
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    TopicsSyncTask(TopicsSubscriber topicsSubscriber, Context context, Metadata metadata, long j2) {
        this.Z = topicsSubscriber;
        this.s = context;
        this.X2 = j2;
        this.X = metadata;
        this.Y = ((PowerManager) context.getSystemService("power")).newWakeLock(1, Constants.f24671b);
    }

    private static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean f(Context context) {
        boolean booleanValue;
        synchronized (Y2) {
            try {
                Boolean bool = a3;
                Boolean valueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                a3 = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable(Constants.f24670a, 3)) {
            Log.d(Constants.f24670a, e(str));
        }
        return z;
    }

    private static boolean h(Context context) {
        boolean booleanValue;
        synchronized (Y2) {
            try {
                Boolean bool = Z2;
                Boolean valueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                Z2 = valueOf;
                booleanValue = valueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    public synchronized boolean i() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.s.getSystemService("connectivity");
            activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    public static boolean j() {
        return Log.isLoggable(Constants.f24670a, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.f24670a, 3));
    }

    @SuppressLint({"Wakelock"})
    public void run() {
        PowerManager.WakeLock wakeLock;
        if (h(this.s)) {
            this.Y.acquire(Constants.f24672c);
        }
        try {
            this.Z.p(true);
            if (!this.X.g()) {
                this.Z.p(false);
                if (h(this.s)) {
                    try {
                        this.Y.release();
                    } catch (RuntimeException unused) {
                        Log.i(Constants.f24670a, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else if (!f(this.s) || i()) {
                if (this.Z.t()) {
                    this.Z.p(false);
                } else {
                    this.Z.u(this.X2);
                }
                if (h(this.s)) {
                    try {
                        wakeLock = this.Y;
                        wakeLock.release();
                    } catch (RuntimeException unused2) {
                        Log.i(Constants.f24670a, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else {
                new ConnectivityChangeReceiver(this).a();
                if (h(this.s)) {
                    try {
                        this.Y.release();
                    } catch (RuntimeException unused3) {
                        Log.i(Constants.f24670a, "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (IOException e2) {
            Log.e(Constants.f24670a, "Failed to sync topics. Won't retry sync. " + e2.getMessage());
            this.Z.p(false);
            if (h(this.s)) {
                wakeLock = this.Y;
            }
        } catch (Throwable th) {
            if (h(this.s)) {
                try {
                    this.Y.release();
                } catch (RuntimeException unused4) {
                    Log.i(Constants.f24670a, "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}

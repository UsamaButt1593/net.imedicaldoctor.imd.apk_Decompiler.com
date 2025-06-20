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
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class SyncTask implements Runnable {
    private final PowerManager.WakeLock X;
    /* access modifiers changed from: private */
    public final FirebaseMessaging Y;
    @VisibleForTesting
    @SuppressLint({"ThreadPoolCreation"})
    ExecutorService Z = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
    private final long s;

    @VisibleForTesting
    static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private SyncTask f24872a;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.f24872a = syncTask;
        }

        public void a() {
            if (SyncTask.c()) {
                Log.d(Constants.f24670a, "Connectivity change received registered");
            }
            this.f24872a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.f24872a;
            if (syncTask != null && syncTask.d()) {
                if (SyncTask.c()) {
                    Log.d(Constants.f24670a, "Connectivity changed. Starting background sync.");
                }
                this.f24872a.Y.w(this.f24872a, 0);
                this.f24872a.b().unregisterReceiver(this);
                this.f24872a = null;
            }
        }
    }

    @VisibleForTesting
    @SuppressLint({"InvalidWakeLockTag"})
    public SyncTask(FirebaseMessaging firebaseMessaging, long j2) {
        this.Y = firebaseMessaging;
        this.s = j2;
        PowerManager.WakeLock newWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.X = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        return Log.isLoggable(Constants.f24670a, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.f24670a, 3));
    }

    /* access modifiers changed from: package-private */
    public Context b() {
        return this.Y.x();
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean e() throws IOException {
        String str;
        try {
            if (this.Y.r() == null) {
                Log.e(Constants.f24670a, "Token retrieval failed: null");
                return false;
            } else if (!Log.isLoggable(Constants.f24670a, 3)) {
                return true;
            } else {
                Log.d(Constants.f24670a, "Token successfully retrieved");
                return true;
            }
        } catch (IOException e2) {
            if (GmsRpc.i(e2.getMessage())) {
                str = "Token retrieval failed: " + e2.getMessage() + ". Will retry token retrieval";
            } else if (e2.getMessage() == null) {
                str = "Token retrieval failed without exception message. Will retry token retrieval";
            } else {
                throw e2;
            }
            Log.w(Constants.f24670a, str);
            return false;
        } catch (SecurityException unused) {
            str = "Token retrieval failed with SecurityException. Will retry token retrieval";
            Log.w(Constants.f24670a, str);
            return false;
        }
    }

    @SuppressLint({"WakelockTimeout"})
    public void run() {
        if (ServiceStarter.b().e(b())) {
            this.X.acquire();
        }
        try {
            this.Y.e0(true);
            if (!this.Y.J()) {
                this.Y.e0(false);
                if (ServiceStarter.b().e(b())) {
                    this.X.release();
                }
            } else if (!ServiceStarter.b().d(b()) || d()) {
                if (e()) {
                    this.Y.e0(false);
                } else {
                    this.Y.j0(this.s);
                }
                if (!ServiceStarter.b().e(b())) {
                    return;
                }
                this.X.release();
            } else {
                new ConnectivityChangeReceiver(this).a();
                if (ServiceStarter.b().e(b())) {
                    this.X.release();
                }
            }
        } catch (IOException e2) {
            Log.e(Constants.f24670a, "Topic sync or token retrieval failed on hard failure exceptions: " + e2.getMessage() + ". Won't retry the operation.");
            this.Y.e0(false);
            if (!ServiceStarter.b().e(b())) {
            }
        } catch (Throwable th) {
            if (ServiceStarter.b().e(b())) {
                this.X.release();
            }
            throw th;
        }
    }
}

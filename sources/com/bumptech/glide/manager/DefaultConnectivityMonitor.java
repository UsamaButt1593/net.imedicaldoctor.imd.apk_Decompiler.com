package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    private static final String Y2 = "ConnectivityMonitor";
    final ConnectivityMonitor.ConnectivityListener X;
    private final BroadcastReceiver X2 = new BroadcastReceiver() {
        public void onReceive(@NonNull Context context, Intent intent) {
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            boolean z = defaultConnectivityMonitor.Y;
            defaultConnectivityMonitor.Y = defaultConnectivityMonitor.f(context);
            if (z != DefaultConnectivityMonitor.this.Y) {
                if (Log.isLoggable(DefaultConnectivityMonitor.Y2, 3)) {
                    Log.d(DefaultConnectivityMonitor.Y2, "connectivity changed, isConnected: " + DefaultConnectivityMonitor.this.Y);
                }
                DefaultConnectivityMonitor defaultConnectivityMonitor2 = DefaultConnectivityMonitor.this;
                defaultConnectivityMonitor2.X.a(defaultConnectivityMonitor2.Y);
            }
        }
    };
    boolean Y;
    private boolean Z;
    private final Context s;

    DefaultConnectivityMonitor(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.s = context.getApplicationContext();
        this.X = connectivityListener;
    }

    private void g() {
        if (!this.Z) {
            this.Y = f(this.s);
            try {
                this.s.registerReceiver(this.X2, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.Z = true;
            } catch (SecurityException e2) {
                if (Log.isLoggable(Y2, 5)) {
                    Log.w(Y2, "Failed to register", e2);
                }
            }
        }
    }

    private void h() {
        if (this.Z) {
            this.s.unregisterReceiver(this.X2);
            this.Z = false;
        }
    }

    public void a() {
        g();
    }

    public void b() {
    }

    public void d() {
        h();
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public boolean f(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable(Y2, 5)) {
                Log.w(Y2, "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }
}

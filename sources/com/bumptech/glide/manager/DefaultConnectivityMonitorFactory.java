package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.ConnectivityMonitor;

public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18417a = "ConnectivityMonitor";

    /* renamed from: b  reason: collision with root package name */
    private static final String f18418b = "android.permission.ACCESS_NETWORK_STATE";

    @NonNull
    public ConnectivityMonitor a(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener) {
        boolean z = ContextCompat.a(context, f18418b) == 0;
        if (Log.isLoggable(f18417a, 3)) {
            Log.d(f18417a, z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new DefaultConnectivityMonitor(context, connectivityListener) : new NullConnectivityMonitor();
    }
}

package com.bumptech.glide.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.manager.ConnectivityMonitor;

public interface ConnectivityMonitorFactory {
    @NonNull
    ConnectivityMonitor a(@NonNull Context context, @NonNull ConnectivityMonitor.ConnectivityListener connectivityListener);
}

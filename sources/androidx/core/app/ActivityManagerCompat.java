package androidx.core.app;

import android.app.ActivityManager;
import androidx.annotation.NonNull;

public final class ActivityManagerCompat {
    private ActivityManagerCompat() {
    }

    public static boolean a(@NonNull ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}

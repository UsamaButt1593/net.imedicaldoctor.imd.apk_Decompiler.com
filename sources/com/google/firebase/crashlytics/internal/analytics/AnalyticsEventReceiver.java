package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;

public interface AnalyticsEventReceiver {
    void y(@NonNull String str, @NonNull Bundle bundle);
}

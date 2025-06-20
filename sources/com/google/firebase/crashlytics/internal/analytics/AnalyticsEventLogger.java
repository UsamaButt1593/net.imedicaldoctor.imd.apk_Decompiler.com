package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface AnalyticsEventLogger {
    void a(@NonNull String str, @Nullable Bundle bundle);
}

package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

@AutoValue
public abstract class CrashlyticsReportWithSessionId {
    @NonNull
    public static CrashlyticsReportWithSessionId a(CrashlyticsReport crashlyticsReport, String str, File file) {
        return new AutoValue_CrashlyticsReportWithSessionId(crashlyticsReport, str, file);
    }

    public abstract CrashlyticsReport b();

    public abstract File c();

    public abstract String d();
}

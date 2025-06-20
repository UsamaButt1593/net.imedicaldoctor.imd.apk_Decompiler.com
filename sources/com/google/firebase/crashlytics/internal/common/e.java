package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class e implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return str.startsWith(CrashlyticsController.w);
    }
}

package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class b implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return str.startsWith("event");
    }
}

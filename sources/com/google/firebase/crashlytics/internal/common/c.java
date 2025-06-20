package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
    }
}

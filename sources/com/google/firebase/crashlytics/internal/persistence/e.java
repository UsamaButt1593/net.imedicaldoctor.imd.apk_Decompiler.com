package com.google.firebase.crashlytics.internal.persistence;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class e implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24221a;

    public /* synthetic */ e(String str) {
        this.f24221a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.f24221a);
    }
}

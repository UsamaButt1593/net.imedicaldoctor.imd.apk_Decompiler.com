package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

class CrashlyticsFileMarker {

    /* renamed from: a  reason: collision with root package name */
    private final String f23621a;

    /* renamed from: b  reason: collision with root package name */
    private final FileStore f23622b;

    public CrashlyticsFileMarker(String str, FileStore fileStore) {
        this.f23621a = str;
        this.f23622b = fileStore;
    }

    private File b() {
        return this.f23622b.h(this.f23621a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e2) {
            Logger f2 = Logger.f();
            f2.e("Error creating marker: " + this.f23621a, e2);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}

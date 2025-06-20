package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class CrashlyticsAppQualitySessionsStore {

    /* renamed from: d  reason: collision with root package name */
    private static final String f23569d = "aqs.";

    /* renamed from: e  reason: collision with root package name */
    private static final FilenameFilter f23570e = new b();

    /* renamed from: f  reason: collision with root package name */
    private static final Comparator<File> f23571f = new c();

    /* renamed from: a  reason: collision with root package name */
    private final FileStore f23572a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f23573b = null;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f23574c = null;

    CrashlyticsAppQualitySessionsStore(FileStore fileStore) {
        this.f23572a = fileStore;
    }

    private static void f(FileStore fileStore, @Nullable String str, @Nullable String str2) {
        if (str != null && str2 != null) {
            try {
                fileStore.r(str, f23569d + str2).createNewFile();
            } catch (IOException e2) {
                Logger.f().n("Failed to persist App Quality Sessions session id.", e2);
            }
        }
    }

    @VisibleForTesting
    @Nullable
    static String g(FileStore fileStore, @NonNull String str) {
        List<File> s = fileStore.s(str, f23570e);
        if (!s.isEmpty()) {
            return ((File) Collections.min(s, f23571f)).getName().substring(4);
        }
        Logger.f().m("Unable to read App Quality Sessions session id.");
        return null;
    }

    @Nullable
    public synchronized String c(@NonNull String str) {
        if (Objects.equals(this.f23573b, str)) {
            return this.f23574c;
        }
        return g(this.f23572a, str);
    }

    public synchronized void h(@NonNull String str) {
        if (!Objects.equals(this.f23574c, str)) {
            f(this.f23572a, this.f23573b, str);
            this.f23574c = str;
        }
    }

    public synchronized void i(@Nullable String str) {
        if (!Objects.equals(this.f23573b, str)) {
            f(this.f23572a, str, this.f23574c);
            this.f23573b = str;
        }
    }
}

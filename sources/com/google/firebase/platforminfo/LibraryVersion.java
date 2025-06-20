package com.google.firebase.platforminfo;

import com.google.auto.value.AutoValue;
import javax.annotation.Nonnull;

@AutoValue
abstract class LibraryVersion {
    LibraryVersion() {
    }

    /* access modifiers changed from: package-private */
    public static LibraryVersion a(String str, String str2) {
        return new AutoValue_LibraryVersion(str, str2);
    }

    @Nonnull
    public abstract String b();

    @Nonnull
    public abstract String c();
}

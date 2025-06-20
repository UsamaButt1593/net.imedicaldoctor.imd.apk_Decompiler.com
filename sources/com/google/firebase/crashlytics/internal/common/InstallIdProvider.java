package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

public interface InstallIdProvider {

    @AutoValue
    public static abstract class InstallIds {
        static InstallIds a(String str, FirebaseInstallationId firebaseInstallationId) {
            return new AutoValue_InstallIdProvider_InstallIds(str, firebaseInstallationId.f(), firebaseInstallationId.e());
        }

        public static InstallIds b(String str) {
            return new AutoValue_InstallIdProvider_InstallIds(str, (String) null, (String) null);
        }

        @NonNull
        public abstract String c();

        @Nullable
        public abstract String d();

        @Nullable
        public abstract String e();
    }

    InstallIds a();
}

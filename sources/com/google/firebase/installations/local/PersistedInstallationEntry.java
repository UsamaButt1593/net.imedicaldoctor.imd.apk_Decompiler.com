package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.local.AutoValue_PersistedInstallationEntry;
import com.google.firebase.installations.local.PersistedInstallation;

@AutoValue
public abstract class PersistedInstallationEntry {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static PersistedInstallationEntry f24570a = a().a();

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract PersistedInstallationEntry a();

        @NonNull
        public abstract Builder b(@Nullable String str);

        @NonNull
        public abstract Builder c(long j2);

        @NonNull
        public abstract Builder d(@NonNull String str);

        @NonNull
        public abstract Builder e(@Nullable String str);

        @NonNull
        public abstract Builder f(@Nullable String str);

        @NonNull
        public abstract Builder g(@NonNull PersistedInstallation.RegistrationStatus registrationStatus);

        @NonNull
        public abstract Builder h(long j2);
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_PersistedInstallationEntry.Builder().h(0).g(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).c(0);
    }

    @Nullable
    public abstract String b();

    public abstract long c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract String e();

    @Nullable
    public abstract String f();

    @NonNull
    public abstract PersistedInstallation.RegistrationStatus g();

    public abstract long h();

    public boolean i() {
        return g() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
    }

    public boolean j() {
        return g() == PersistedInstallation.RegistrationStatus.NOT_GENERATED || g() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public boolean k() {
        return g() == PersistedInstallation.RegistrationStatus.REGISTERED;
    }

    public boolean l() {
        return g() == PersistedInstallation.RegistrationStatus.UNREGISTERED;
    }

    public boolean m() {
        return g() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    @NonNull
    public abstract Builder n();

    @NonNull
    public PersistedInstallationEntry o(@NonNull String str, long j2, long j3) {
        return n().b(str).c(j2).h(j3).a();
    }

    @NonNull
    public PersistedInstallationEntry p() {
        return n().b((String) null).a();
    }

    @NonNull
    public PersistedInstallationEntry q(@NonNull String str) {
        return n().e(str).g(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).a();
    }

    @NonNull
    public PersistedInstallationEntry r() {
        return n().g(PersistedInstallation.RegistrationStatus.NOT_GENERATED).a();
    }

    @NonNull
    public PersistedInstallationEntry s(@NonNull String str, @NonNull String str2, long j2, @Nullable String str3, long j3) {
        return n().d(str).g(PersistedInstallation.RegistrationStatus.REGISTERED).b(str3).f(str2).c(j3).h(j2).a();
    }

    @NonNull
    public PersistedInstallationEntry t(@NonNull String str) {
        return n().d(str).g(PersistedInstallation.RegistrationStatus.UNREGISTERED).a();
    }
}

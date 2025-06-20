package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {

    /* renamed from: b  reason: collision with root package name */
    private final String f24536b;

    /* renamed from: c  reason: collision with root package name */
    private final PersistedInstallation.RegistrationStatus f24537c;

    /* renamed from: d  reason: collision with root package name */
    private final String f24538d;

    /* renamed from: e  reason: collision with root package name */
    private final String f24539e;

    /* renamed from: f  reason: collision with root package name */
    private final long f24540f;

    /* renamed from: g  reason: collision with root package name */
    private final long f24541g;

    /* renamed from: h  reason: collision with root package name */
    private final String f24542h;

    static final class Builder extends PersistedInstallationEntry.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24543a;

        /* renamed from: b  reason: collision with root package name */
        private PersistedInstallation.RegistrationStatus f24544b;

        /* renamed from: c  reason: collision with root package name */
        private String f24545c;

        /* renamed from: d  reason: collision with root package name */
        private String f24546d;

        /* renamed from: e  reason: collision with root package name */
        private Long f24547e;

        /* renamed from: f  reason: collision with root package name */
        private Long f24548f;

        /* renamed from: g  reason: collision with root package name */
        private String f24549g;

        Builder() {
        }

        public PersistedInstallationEntry a() {
            String str = "";
            if (this.f24544b == null) {
                str = str + " registrationStatus";
            }
            if (this.f24547e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f24548f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new AutoValue_PersistedInstallationEntry(this.f24543a, this.f24544b, this.f24545c, this.f24546d, this.f24547e.longValue(), this.f24548f.longValue(), this.f24549g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public PersistedInstallationEntry.Builder b(@Nullable String str) {
            this.f24545c = str;
            return this;
        }

        public PersistedInstallationEntry.Builder c(long j2) {
            this.f24547e = Long.valueOf(j2);
            return this;
        }

        public PersistedInstallationEntry.Builder d(String str) {
            this.f24543a = str;
            return this;
        }

        public PersistedInstallationEntry.Builder e(@Nullable String str) {
            this.f24549g = str;
            return this;
        }

        public PersistedInstallationEntry.Builder f(@Nullable String str) {
            this.f24546d = str;
            return this;
        }

        public PersistedInstallationEntry.Builder g(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus != null) {
                this.f24544b = registrationStatus;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        public PersistedInstallationEntry.Builder h(long j2) {
            this.f24548f = Long.valueOf(j2);
            return this;
        }

        private Builder(PersistedInstallationEntry persistedInstallationEntry) {
            this.f24543a = persistedInstallationEntry.d();
            this.f24544b = persistedInstallationEntry.g();
            this.f24545c = persistedInstallationEntry.b();
            this.f24546d = persistedInstallationEntry.f();
            this.f24547e = Long.valueOf(persistedInstallationEntry.c());
            this.f24548f = Long.valueOf(persistedInstallationEntry.h());
            this.f24549g = persistedInstallationEntry.e();
        }
    }

    private AutoValue_PersistedInstallationEntry(@Nullable String str, PersistedInstallation.RegistrationStatus registrationStatus, @Nullable String str2, @Nullable String str3, long j2, long j3, @Nullable String str4) {
        this.f24536b = str;
        this.f24537c = registrationStatus;
        this.f24538d = str2;
        this.f24539e = str3;
        this.f24540f = j2;
        this.f24541g = j3;
        this.f24542h = str4;
    }

    @Nullable
    public String b() {
        return this.f24538d;
    }

    public long c() {
        return this.f24540f;
    }

    @Nullable
    public String d() {
        return this.f24536b;
    }

    @Nullable
    public String e() {
        return this.f24542h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.f24536b;
        if (str3 != null ? str3.equals(persistedInstallationEntry.d()) : persistedInstallationEntry.d() == null) {
            if (this.f24537c.equals(persistedInstallationEntry.g()) && ((str = this.f24538d) != null ? str.equals(persistedInstallationEntry.b()) : persistedInstallationEntry.b() == null) && ((str2 = this.f24539e) != null ? str2.equals(persistedInstallationEntry.f()) : persistedInstallationEntry.f() == null) && this.f24540f == persistedInstallationEntry.c() && this.f24541g == persistedInstallationEntry.h()) {
                String str4 = this.f24542h;
                String e2 = persistedInstallationEntry.e();
                if (str4 == null) {
                    if (e2 == null) {
                        return true;
                    }
                } else if (str4.equals(e2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public String f() {
        return this.f24539e;
    }

    @NonNull
    public PersistedInstallation.RegistrationStatus g() {
        return this.f24537c;
    }

    public long h() {
        return this.f24541g;
    }

    public int hashCode() {
        String str = this.f24536b;
        int i2 = 0;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f24537c.hashCode()) * 1000003;
        String str2 = this.f24538d;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f24539e;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        long j2 = this.f24540f;
        long j3 = this.f24541g;
        int i3 = (((((hashCode2 ^ hashCode3) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str4 = this.f24542h;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return i3 ^ i2;
    }

    public PersistedInstallationEntry.Builder n() {
        return new Builder(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f24536b + ", registrationStatus=" + this.f24537c + ", authToken=" + this.f24538d + ", refreshToken=" + this.f24539e + ", expiresInSecs=" + this.f24540f + ", tokenCreationEpochInSecs=" + this.f24541g + ", fisError=" + this.f24542h + "}";
    }
}

package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.firebase.installations.InstallationTokenResult;

final class AutoValue_InstallationTokenResult extends InstallationTokenResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f24397a;

    /* renamed from: b  reason: collision with root package name */
    private final long f24398b;

    /* renamed from: c  reason: collision with root package name */
    private final long f24399c;

    static final class Builder extends InstallationTokenResult.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24400a;

        /* renamed from: b  reason: collision with root package name */
        private Long f24401b;

        /* renamed from: c  reason: collision with root package name */
        private Long f24402c;

        Builder() {
        }

        public InstallationTokenResult a() {
            String str = "";
            if (this.f24400a == null) {
                str = str + " token";
            }
            if (this.f24401b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f24402c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_InstallationTokenResult(this.f24400a, this.f24401b.longValue(), this.f24402c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public InstallationTokenResult.Builder b(String str) {
            if (str != null) {
                this.f24400a = str;
                return this;
            }
            throw new NullPointerException("Null token");
        }

        public InstallationTokenResult.Builder c(long j2) {
            this.f24402c = Long.valueOf(j2);
            return this;
        }

        public InstallationTokenResult.Builder d(long j2) {
            this.f24401b = Long.valueOf(j2);
            return this;
        }

        private Builder(InstallationTokenResult installationTokenResult) {
            this.f24400a = installationTokenResult.b();
            this.f24401b = Long.valueOf(installationTokenResult.d());
            this.f24402c = Long.valueOf(installationTokenResult.c());
        }
    }

    private AutoValue_InstallationTokenResult(String str, long j2, long j3) {
        this.f24397a = str;
        this.f24398b = j2;
        this.f24399c = j3;
    }

    @NonNull
    public String b() {
        return this.f24397a;
    }

    @NonNull
    public long c() {
        return this.f24399c;
    }

    @NonNull
    public long d() {
        return this.f24398b;
    }

    public InstallationTokenResult.Builder e() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        return this.f24397a.equals(installationTokenResult.b()) && this.f24398b == installationTokenResult.d() && this.f24399c == installationTokenResult.c();
    }

    public int hashCode() {
        long j2 = this.f24398b;
        long j3 = this.f24399c;
        return ((((this.f24397a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f24397a + ", tokenExpirationTimestamp=" + this.f24398b + ", tokenCreationTimestamp=" + this.f24399c + "}";
    }
}

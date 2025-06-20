package com.google.firebase.installations.remote;

import androidx.annotation.Nullable;
import com.google.firebase.installations.remote.InstallationResponse;

final class AutoValue_InstallationResponse extends InstallationResponse {

    /* renamed from: a  reason: collision with root package name */
    private final String f24571a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24572b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24573c;

    /* renamed from: d  reason: collision with root package name */
    private final TokenResult f24574d;

    /* renamed from: e  reason: collision with root package name */
    private final InstallationResponse.ResponseCode f24575e;

    static final class Builder extends InstallationResponse.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24576a;

        /* renamed from: b  reason: collision with root package name */
        private String f24577b;

        /* renamed from: c  reason: collision with root package name */
        private String f24578c;

        /* renamed from: d  reason: collision with root package name */
        private TokenResult f24579d;

        /* renamed from: e  reason: collision with root package name */
        private InstallationResponse.ResponseCode f24580e;

        Builder() {
        }

        public InstallationResponse a() {
            return new AutoValue_InstallationResponse(this.f24576a, this.f24577b, this.f24578c, this.f24579d, this.f24580e);
        }

        public InstallationResponse.Builder b(TokenResult tokenResult) {
            this.f24579d = tokenResult;
            return this;
        }

        public InstallationResponse.Builder c(String str) {
            this.f24577b = str;
            return this;
        }

        public InstallationResponse.Builder d(String str) {
            this.f24578c = str;
            return this;
        }

        public InstallationResponse.Builder e(InstallationResponse.ResponseCode responseCode) {
            this.f24580e = responseCode;
            return this;
        }

        public InstallationResponse.Builder f(String str) {
            this.f24576a = str;
            return this;
        }

        private Builder(InstallationResponse installationResponse) {
            this.f24576a = installationResponse.f();
            this.f24577b = installationResponse.c();
            this.f24578c = installationResponse.d();
            this.f24579d = installationResponse.b();
            this.f24580e = installationResponse.e();
        }
    }

    private AutoValue_InstallationResponse(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable TokenResult tokenResult, @Nullable InstallationResponse.ResponseCode responseCode) {
        this.f24571a = str;
        this.f24572b = str2;
        this.f24573c = str3;
        this.f24574d = tokenResult;
        this.f24575e = responseCode;
    }

    @Nullable
    public TokenResult b() {
        return this.f24574d;
    }

    @Nullable
    public String c() {
        return this.f24572b;
    }

    @Nullable
    public String d() {
        return this.f24573c;
    }

    @Nullable
    public InstallationResponse.ResponseCode e() {
        return this.f24575e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f24571a;
        if (str != null ? str.equals(installationResponse.f()) : installationResponse.f() == null) {
            String str2 = this.f24572b;
            if (str2 != null ? str2.equals(installationResponse.c()) : installationResponse.c() == null) {
                String str3 = this.f24573c;
                if (str3 != null ? str3.equals(installationResponse.d()) : installationResponse.d() == null) {
                    TokenResult tokenResult = this.f24574d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.b()) : installationResponse.b() == null) {
                        InstallationResponse.ResponseCode responseCode = this.f24575e;
                        InstallationResponse.ResponseCode e2 = installationResponse.e();
                        if (responseCode == null) {
                            if (e2 == null) {
                                return true;
                            }
                        } else if (responseCode.equals(e2)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public String f() {
        return this.f24571a;
    }

    public InstallationResponse.Builder g() {
        return new Builder(this);
    }

    public int hashCode() {
        String str = this.f24571a;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f24572b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f24573c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.f24574d;
        int hashCode4 = (hashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f24575e;
        if (responseCode != null) {
            i2 = responseCode.hashCode();
        }
        return hashCode4 ^ i2;
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f24571a + ", fid=" + this.f24572b + ", refreshToken=" + this.f24573c + ", authToken=" + this.f24574d + ", responseCode=" + this.f24575e + "}";
    }
}

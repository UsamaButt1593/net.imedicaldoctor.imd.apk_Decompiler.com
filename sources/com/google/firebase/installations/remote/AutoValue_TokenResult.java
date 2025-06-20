package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.installations.remote.TokenResult;

final class AutoValue_TokenResult extends TokenResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f24581a;

    /* renamed from: b  reason: collision with root package name */
    private final long f24582b;

    /* renamed from: c  reason: collision with root package name */
    private final TokenResult.ResponseCode f24583c;

    static final class Builder extends TokenResult.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24584a;

        /* renamed from: b  reason: collision with root package name */
        private Long f24585b;

        /* renamed from: c  reason: collision with root package name */
        private TokenResult.ResponseCode f24586c;

        Builder() {
        }

        public TokenResult a() {
            String str = "";
            if (this.f24585b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.f24584a, this.f24585b.longValue(), this.f24586c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public TokenResult.Builder b(TokenResult.ResponseCode responseCode) {
            this.f24586c = responseCode;
            return this;
        }

        public TokenResult.Builder c(String str) {
            this.f24584a = str;
            return this;
        }

        public TokenResult.Builder d(long j2) {
            this.f24585b = Long.valueOf(j2);
            return this;
        }

        private Builder(TokenResult tokenResult) {
            this.f24584a = tokenResult.c();
            this.f24585b = Long.valueOf(tokenResult.d());
            this.f24586c = tokenResult.b();
        }
    }

    private AutoValue_TokenResult(@Nullable String str, long j2, @Nullable TokenResult.ResponseCode responseCode) {
        this.f24581a = str;
        this.f24582b = j2;
        this.f24583c = responseCode;
    }

    @Nullable
    public TokenResult.ResponseCode b() {
        return this.f24583c;
    }

    @Nullable
    public String c() {
        return this.f24581a;
    }

    @NonNull
    public long d() {
        return this.f24582b;
    }

    public TokenResult.Builder e() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f24581a;
        if (str != null ? str.equals(tokenResult.c()) : tokenResult.c() == null) {
            if (this.f24582b == tokenResult.d()) {
                TokenResult.ResponseCode responseCode = this.f24583c;
                TokenResult.ResponseCode b2 = tokenResult.b();
                if (responseCode == null) {
                    if (b2 == null) {
                        return true;
                    }
                } else if (responseCode.equals(b2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f24581a;
        int i2 = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        long j2 = this.f24582b;
        int i3 = (((hashCode ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f24583c;
        if (responseCode != null) {
            i2 = responseCode.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        return "TokenResult{token=" + this.f24581a + ", tokenExpirationTimestamp=" + this.f24582b + ", responseCode=" + this.f24583c + "}";
    }
}

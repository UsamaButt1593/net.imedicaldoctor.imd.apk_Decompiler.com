package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ClientInfo;

final class AutoValue_ClientInfo extends ClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ClientInfo.ClientType f19320a;

    /* renamed from: b  reason: collision with root package name */
    private final AndroidClientInfo f19321b;

    static final class Builder extends ClientInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ClientInfo.ClientType f19322a;

        /* renamed from: b  reason: collision with root package name */
        private AndroidClientInfo f19323b;

        Builder() {
        }

        public ClientInfo a() {
            return new AutoValue_ClientInfo(this.f19322a, this.f19323b);
        }

        public ClientInfo.Builder b(@Nullable AndroidClientInfo androidClientInfo) {
            this.f19323b = androidClientInfo;
            return this;
        }

        public ClientInfo.Builder c(@Nullable ClientInfo.ClientType clientType) {
            this.f19322a = clientType;
            return this;
        }
    }

    private AutoValue_ClientInfo(@Nullable ClientInfo.ClientType clientType, @Nullable AndroidClientInfo androidClientInfo) {
        this.f19320a = clientType;
        this.f19321b = androidClientInfo;
    }

    @Nullable
    public AndroidClientInfo b() {
        return this.f19321b;
    }

    @Nullable
    public ClientInfo.ClientType c() {
        return this.f19320a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f19320a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            AndroidClientInfo androidClientInfo = this.f19321b;
            AndroidClientInfo b2 = clientInfo.b();
            if (androidClientInfo == null) {
                if (b2 == null) {
                    return true;
                }
            } else if (androidClientInfo.equals(b2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f19320a;
        int i2 = 0;
        int hashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f19321b;
        if (androidClientInfo != null) {
            i2 = androidClientInfo.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f19320a + ", androidClientInfo=" + this.f19321b + "}";
    }
}

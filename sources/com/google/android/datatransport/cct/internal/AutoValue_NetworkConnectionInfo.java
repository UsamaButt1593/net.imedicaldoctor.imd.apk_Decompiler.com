package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkConnectionInfo.NetworkType f19369a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkConnectionInfo.MobileSubtype f19370b;

    static final class Builder extends NetworkConnectionInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private NetworkConnectionInfo.NetworkType f19371a;

        /* renamed from: b  reason: collision with root package name */
        private NetworkConnectionInfo.MobileSubtype f19372b;

        Builder() {
        }

        public NetworkConnectionInfo a() {
            return new AutoValue_NetworkConnectionInfo(this.f19371a, this.f19372b);
        }

        public NetworkConnectionInfo.Builder b(@Nullable NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.f19372b = mobileSubtype;
            return this;
        }

        public NetworkConnectionInfo.Builder c(@Nullable NetworkConnectionInfo.NetworkType networkType) {
            this.f19371a = networkType;
            return this;
        }
    }

    private AutoValue_NetworkConnectionInfo(@Nullable NetworkConnectionInfo.NetworkType networkType, @Nullable NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.f19369a = networkType;
        this.f19370b = mobileSubtype;
    }

    @Nullable
    public NetworkConnectionInfo.MobileSubtype b() {
        return this.f19370b;
    }

    @Nullable
    public NetworkConnectionInfo.NetworkType c() {
        return this.f19369a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType = this.f19369a;
        if (networkType != null ? networkType.equals(networkConnectionInfo.c()) : networkConnectionInfo.c() == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f19370b;
            NetworkConnectionInfo.MobileSubtype b2 = networkConnectionInfo.b();
            if (mobileSubtype == null) {
                if (b2 == null) {
                    return true;
                }
            } else if (mobileSubtype.equals(b2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        NetworkConnectionInfo.NetworkType networkType = this.f19369a;
        int i2 = 0;
        int hashCode = ((networkType == null ? 0 : networkType.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f19370b;
        if (mobileSubtype != null) {
            i2 = mobileSubtype.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f19369a + ", mobileSubtype=" + this.f19370b + "}";
    }
}

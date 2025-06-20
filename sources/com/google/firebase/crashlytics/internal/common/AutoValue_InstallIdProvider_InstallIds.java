package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

final class AutoValue_InstallIdProvider_InstallIds extends InstallIdProvider.InstallIds {

    /* renamed from: a  reason: collision with root package name */
    private final String f23539a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23540b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23541c;

    AutoValue_InstallIdProvider_InstallIds(String str, @Nullable String str2, @Nullable String str3) {
        if (str != null) {
            this.f23539a = str;
            this.f23540b = str2;
            this.f23541c = str3;
            return;
        }
        throw new NullPointerException("Null crashlyticsInstallId");
    }

    @NonNull
    public String c() {
        return this.f23539a;
    }

    @Nullable
    public String d() {
        return this.f23541c;
    }

    @Nullable
    public String e() {
        return this.f23540b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallIdProvider.InstallIds)) {
            return false;
        }
        InstallIdProvider.InstallIds installIds = (InstallIdProvider.InstallIds) obj;
        if (this.f23539a.equals(installIds.c()) && ((str = this.f23540b) != null ? str.equals(installIds.e()) : installIds.e() == null)) {
            String str2 = this.f23541c;
            String d2 = installIds.d();
            if (str2 == null) {
                if (d2 == null) {
                    return true;
                }
            } else if (str2.equals(d2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f23539a.hashCode() ^ 1000003) * 1000003;
        String str = this.f23540b;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f23541c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 ^ i2;
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.f23539a + ", firebaseInstallationId=" + this.f23540b + ", firebaseAuthenticationToken=" + this.f23541c + "}";
    }
}

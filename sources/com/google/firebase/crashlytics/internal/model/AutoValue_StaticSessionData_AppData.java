package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;

final class AutoValue_StaticSessionData_AppData extends StaticSessionData.AppData {

    /* renamed from: a  reason: collision with root package name */
    private final String f24165a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24166b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24167c;

    /* renamed from: d  reason: collision with root package name */
    private final String f24168d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24169e;

    /* renamed from: f  reason: collision with root package name */
    private final DevelopmentPlatformProvider f24170f;

    AutoValue_StaticSessionData_AppData(String str, String str2, String str3, String str4, int i2, DevelopmentPlatformProvider developmentPlatformProvider) {
        if (str != null) {
            this.f24165a = str;
            if (str2 != null) {
                this.f24166b = str2;
                if (str3 != null) {
                    this.f24167c = str3;
                    if (str4 != null) {
                        this.f24168d = str4;
                        this.f24169e = i2;
                        if (developmentPlatformProvider != null) {
                            this.f24170f = developmentPlatformProvider;
                            return;
                        }
                        throw new NullPointerException("Null developmentPlatformProvider");
                    }
                    throw new NullPointerException("Null installUuid");
                }
                throw new NullPointerException("Null versionName");
            }
            throw new NullPointerException("Null versionCode");
        }
        throw new NullPointerException("Null appIdentifier");
    }

    public String a() {
        return this.f24165a;
    }

    public int c() {
        return this.f24169e;
    }

    public DevelopmentPlatformProvider d() {
        return this.f24170f;
    }

    public String e() {
        return this.f24168d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.AppData)) {
            return false;
        }
        StaticSessionData.AppData appData = (StaticSessionData.AppData) obj;
        return this.f24165a.equals(appData.a()) && this.f24166b.equals(appData.f()) && this.f24167c.equals(appData.g()) && this.f24168d.equals(appData.e()) && this.f24169e == appData.c() && this.f24170f.equals(appData.d());
    }

    public String f() {
        return this.f24166b;
    }

    public String g() {
        return this.f24167c;
    }

    public int hashCode() {
        return ((((((((((this.f24165a.hashCode() ^ 1000003) * 1000003) ^ this.f24166b.hashCode()) * 1000003) ^ this.f24167c.hashCode()) * 1000003) ^ this.f24168d.hashCode()) * 1000003) ^ this.f24169e) * 1000003) ^ this.f24170f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f24165a + ", versionCode=" + this.f24166b + ", versionName=" + this.f24167c + ", installUuid=" + this.f24168d + ", deliveryMechanism=" + this.f24169e + ", developmentPlatformProvider=" + this.f24170f + "}";
    }
}

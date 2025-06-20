package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

final class AutoValue_StaticSessionData extends StaticSessionData {

    /* renamed from: a  reason: collision with root package name */
    private final StaticSessionData.AppData f24162a;

    /* renamed from: b  reason: collision with root package name */
    private final StaticSessionData.OsData f24163b;

    /* renamed from: c  reason: collision with root package name */
    private final StaticSessionData.DeviceData f24164c;

    AutoValue_StaticSessionData(StaticSessionData.AppData appData, StaticSessionData.OsData osData, StaticSessionData.DeviceData deviceData) {
        if (appData != null) {
            this.f24162a = appData;
            if (osData != null) {
                this.f24163b = osData;
                if (deviceData != null) {
                    this.f24164c = deviceData;
                    return;
                }
                throw new NullPointerException("Null deviceData");
            }
            throw new NullPointerException("Null osData");
        }
        throw new NullPointerException("Null appData");
    }

    public StaticSessionData.AppData a() {
        return this.f24162a;
    }

    public StaticSessionData.DeviceData c() {
        return this.f24164c;
    }

    public StaticSessionData.OsData d() {
        return this.f24163b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData)) {
            return false;
        }
        StaticSessionData staticSessionData = (StaticSessionData) obj;
        return this.f24162a.equals(staticSessionData.a()) && this.f24163b.equals(staticSessionData.d()) && this.f24164c.equals(staticSessionData.c());
    }

    public int hashCode() {
        return ((((this.f24162a.hashCode() ^ 1000003) * 1000003) ^ this.f24163b.hashCode()) * 1000003) ^ this.f24164c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f24162a + ", osData=" + this.f24163b + ", deviceData=" + this.f24164c + "}";
    }
}

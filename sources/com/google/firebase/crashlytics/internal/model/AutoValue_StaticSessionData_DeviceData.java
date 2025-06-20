package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

final class AutoValue_StaticSessionData_DeviceData extends StaticSessionData.DeviceData {

    /* renamed from: a  reason: collision with root package name */
    private final int f24171a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24172b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24173c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24174d;

    /* renamed from: e  reason: collision with root package name */
    private final long f24175e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f24176f;

    /* renamed from: g  reason: collision with root package name */
    private final int f24177g;

    /* renamed from: h  reason: collision with root package name */
    private final String f24178h;

    /* renamed from: i  reason: collision with root package name */
    private final String f24179i;

    AutoValue_StaticSessionData_DeviceData(int i2, String str, int i3, long j2, long j3, boolean z, int i4, String str2, String str3) {
        this.f24171a = i2;
        if (str != null) {
            this.f24172b = str;
            this.f24173c = i3;
            this.f24174d = j2;
            this.f24175e = j3;
            this.f24176f = z;
            this.f24177g = i4;
            if (str2 != null) {
                this.f24178h = str2;
                if (str3 != null) {
                    this.f24179i = str3;
                    return;
                }
                throw new NullPointerException("Null modelClass");
            }
            throw new NullPointerException("Null manufacturer");
        }
        throw new NullPointerException("Null model");
    }

    public int a() {
        return this.f24171a;
    }

    public int b() {
        return this.f24173c;
    }

    public long d() {
        return this.f24175e;
    }

    public boolean e() {
        return this.f24176f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.DeviceData)) {
            return false;
        }
        StaticSessionData.DeviceData deviceData = (StaticSessionData.DeviceData) obj;
        return this.f24171a == deviceData.a() && this.f24172b.equals(deviceData.g()) && this.f24173c == deviceData.b() && this.f24174d == deviceData.j() && this.f24175e == deviceData.d() && this.f24176f == deviceData.e() && this.f24177g == deviceData.i() && this.f24178h.equals(deviceData.f()) && this.f24179i.equals(deviceData.h());
    }

    public String f() {
        return this.f24178h;
    }

    public String g() {
        return this.f24172b;
    }

    public String h() {
        return this.f24179i;
    }

    public int hashCode() {
        long j2 = this.f24174d;
        long j3 = this.f24175e;
        return ((((((((((((((((this.f24171a ^ 1000003) * 1000003) ^ this.f24172b.hashCode()) * 1000003) ^ this.f24173c) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f24176f ? 1231 : 1237)) * 1000003) ^ this.f24177g) * 1000003) ^ this.f24178h.hashCode()) * 1000003) ^ this.f24179i.hashCode();
    }

    public int i() {
        return this.f24177g;
    }

    public long j() {
        return this.f24174d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f24171a + ", model=" + this.f24172b + ", availableProcessors=" + this.f24173c + ", totalRam=" + this.f24174d + ", diskSpace=" + this.f24175e + ", isEmulator=" + this.f24176f + ", state=" + this.f24177g + ", manufacturer=" + this.f24178h + ", modelClass=" + this.f24179i + "}";
    }
}

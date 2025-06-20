package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Device extends CrashlyticsReport.Session.Event.Device {

    /* renamed from: a  reason: collision with root package name */
    private final Double f24121a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24122b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24123c;

    /* renamed from: d  reason: collision with root package name */
    private final int f24124d;

    /* renamed from: e  reason: collision with root package name */
    private final long f24125e;

    /* renamed from: f  reason: collision with root package name */
    private final long f24126f;

    static final class Builder extends CrashlyticsReport.Session.Event.Device.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Double f24127a;

        /* renamed from: b  reason: collision with root package name */
        private int f24128b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f24129c;

        /* renamed from: d  reason: collision with root package name */
        private int f24130d;

        /* renamed from: e  reason: collision with root package name */
        private long f24131e;

        /* renamed from: f  reason: collision with root package name */
        private long f24132f;

        /* renamed from: g  reason: collision with root package name */
        private byte f24133g;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Device a() {
            if (this.f24133g == 31) {
                return new AutoValue_CrashlyticsReport_Session_Event_Device(this.f24127a, this.f24128b, this.f24129c, this.f24130d, this.f24131e, this.f24132f);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f24133g & 1) == 0) {
                sb.append(" batteryVelocity");
            }
            if ((this.f24133g & 2) == 0) {
                sb.append(" proximityOn");
            }
            if ((this.f24133g & 4) == 0) {
                sb.append(" orientation");
            }
            if ((this.f24133g & 8) == 0) {
                sb.append(" ramUsed");
            }
            if ((this.f24133g & 16) == 0) {
                sb.append(" diskUsed");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Device.Builder b(Double d2) {
            this.f24127a = d2;
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder c(int i2) {
            this.f24128b = i2;
            this.f24133g = (byte) (this.f24133g | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder d(long j2) {
            this.f24132f = j2;
            this.f24133g = (byte) (this.f24133g | 16);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder e(int i2) {
            this.f24130d = i2;
            this.f24133g = (byte) (this.f24133g | 4);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder f(boolean z) {
            this.f24129c = z;
            this.f24133g = (byte) (this.f24133g | 2);
            return this;
        }

        public CrashlyticsReport.Session.Event.Device.Builder g(long j2) {
            this.f24131e = j2;
            this.f24133g = (byte) (this.f24133g | 8);
            return this;
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Device(@Nullable Double d2, int i2, boolean z, int i3, long j2, long j3) {
        this.f24121a = d2;
        this.f24122b = i2;
        this.f24123c = z;
        this.f24124d = i3;
        this.f24125e = j2;
        this.f24126f = j3;
    }

    @Nullable
    public Double b() {
        return this.f24121a;
    }

    public int c() {
        return this.f24122b;
    }

    public long d() {
        return this.f24126f;
    }

    public int e() {
        return this.f24124d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Device device = (CrashlyticsReport.Session.Event.Device) obj;
        Double d2 = this.f24121a;
        if (d2 != null ? d2.equals(device.b()) : device.b() == null) {
            return this.f24122b == device.c() && this.f24123c == device.g() && this.f24124d == device.e() && this.f24125e == device.f() && this.f24126f == device.d();
        }
    }

    public long f() {
        return this.f24125e;
    }

    public boolean g() {
        return this.f24123c;
    }

    public int hashCode() {
        Double d2 = this.f24121a;
        int hashCode = ((((d2 == null ? 0 : d2.hashCode()) ^ 1000003) * 1000003) ^ this.f24122b) * 1000003;
        int i2 = this.f24123c ? 1231 : 1237;
        long j2 = this.f24125e;
        long j3 = this.f24126f;
        return ((((((hashCode ^ i2) * 1000003) ^ this.f24124d) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f24121a + ", batteryVelocity=" + this.f24122b + ", proximityOn=" + this.f24123c + ", orientation=" + this.f24124d + ", ramUsed=" + this.f24125e + ", diskUsed=" + this.f24126f + "}";
    }
}

package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Device extends CrashlyticsReport.Session.Device {

    /* renamed from: a  reason: collision with root package name */
    private final int f24010a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24011b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24012c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24013d;

    /* renamed from: e  reason: collision with root package name */
    private final long f24014e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f24015f;

    /* renamed from: g  reason: collision with root package name */
    private final int f24016g;

    /* renamed from: h  reason: collision with root package name */
    private final String f24017h;

    /* renamed from: i  reason: collision with root package name */
    private final String f24018i;

    static final class Builder extends CrashlyticsReport.Session.Device.Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f24019a;

        /* renamed from: b  reason: collision with root package name */
        private String f24020b;

        /* renamed from: c  reason: collision with root package name */
        private int f24021c;

        /* renamed from: d  reason: collision with root package name */
        private long f24022d;

        /* renamed from: e  reason: collision with root package name */
        private long f24023e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f24024f;

        /* renamed from: g  reason: collision with root package name */
        private int f24025g;

        /* renamed from: h  reason: collision with root package name */
        private String f24026h;

        /* renamed from: i  reason: collision with root package name */
        private String f24027i;

        /* renamed from: j  reason: collision with root package name */
        private byte f24028j;

        Builder() {
        }

        public CrashlyticsReport.Session.Device a() {
            String str;
            String str2;
            String str3;
            if (this.f24028j == 63 && (str = this.f24020b) != null && (str2 = this.f24026h) != null && (str3 = this.f24027i) != null) {
                return new AutoValue_CrashlyticsReport_Session_Device(this.f24019a, str, this.f24021c, this.f24022d, this.f24023e, this.f24024f, this.f24025g, str2, str3);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f24028j & 1) == 0) {
                sb.append(" arch");
            }
            if (this.f24020b == null) {
                sb.append(" model");
            }
            if ((this.f24028j & 2) == 0) {
                sb.append(" cores");
            }
            if ((this.f24028j & 4) == 0) {
                sb.append(" ram");
            }
            if ((this.f24028j & 8) == 0) {
                sb.append(" diskSpace");
            }
            if ((this.f24028j & 16) == 0) {
                sb.append(" simulator");
            }
            if ((this.f24028j & 32) == 0) {
                sb.append(" state");
            }
            if (this.f24026h == null) {
                sb.append(" manufacturer");
            }
            if (this.f24027i == null) {
                sb.append(" modelClass");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Device.Builder b(int i2) {
            this.f24019a = i2;
            this.f24028j = (byte) (this.f24028j | 1);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder c(int i2) {
            this.f24021c = i2;
            this.f24028j = (byte) (this.f24028j | 2);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder d(long j2) {
            this.f24023e = j2;
            this.f24028j = (byte) (this.f24028j | 8);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder e(String str) {
            if (str != null) {
                this.f24026h = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        public CrashlyticsReport.Session.Device.Builder f(String str) {
            if (str != null) {
                this.f24020b = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        public CrashlyticsReport.Session.Device.Builder g(String str) {
            if (str != null) {
                this.f24027i = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        public CrashlyticsReport.Session.Device.Builder h(long j2) {
            this.f24022d = j2;
            this.f24028j = (byte) (this.f24028j | 4);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder i(boolean z) {
            this.f24024f = z;
            this.f24028j = (byte) (this.f24028j | 16);
            return this;
        }

        public CrashlyticsReport.Session.Device.Builder j(int i2) {
            this.f24025g = i2;
            this.f24028j = (byte) (this.f24028j | 32);
            return this;
        }
    }

    private AutoValue_CrashlyticsReport_Session_Device(int i2, String str, int i3, long j2, long j3, boolean z, int i4, String str2, String str3) {
        this.f24010a = i2;
        this.f24011b = str;
        this.f24012c = i3;
        this.f24013d = j2;
        this.f24014e = j3;
        this.f24015f = z;
        this.f24016g = i4;
        this.f24017h = str2;
        this.f24018i = str3;
    }

    @NonNull
    public int b() {
        return this.f24010a;
    }

    public int c() {
        return this.f24012c;
    }

    public long d() {
        return this.f24014e;
    }

    @NonNull
    public String e() {
        return this.f24017h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Device)) {
            return false;
        }
        CrashlyticsReport.Session.Device device = (CrashlyticsReport.Session.Device) obj;
        return this.f24010a == device.b() && this.f24011b.equals(device.f()) && this.f24012c == device.c() && this.f24013d == device.h() && this.f24014e == device.d() && this.f24015f == device.j() && this.f24016g == device.i() && this.f24017h.equals(device.e()) && this.f24018i.equals(device.g());
    }

    @NonNull
    public String f() {
        return this.f24011b;
    }

    @NonNull
    public String g() {
        return this.f24018i;
    }

    public long h() {
        return this.f24013d;
    }

    public int hashCode() {
        long j2 = this.f24013d;
        long j3 = this.f24014e;
        return ((((((((((((((((this.f24010a ^ 1000003) * 1000003) ^ this.f24011b.hashCode()) * 1000003) ^ this.f24012c) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f24015f ? 1231 : 1237)) * 1000003) ^ this.f24016g) * 1000003) ^ this.f24017h.hashCode()) * 1000003) ^ this.f24018i.hashCode();
    }

    public int i() {
        return this.f24016g;
    }

    public boolean j() {
        return this.f24015f;
    }

    public String toString() {
        return "Device{arch=" + this.f24010a + ", model=" + this.f24011b + ", cores=" + this.f24012c + ", ram=" + this.f24013d + ", diskSpace=" + this.f24014e + ", simulator=" + this.f24015f + ", state=" + this.f24016g + ", manufacturer=" + this.f24017h + ", modelClass=" + this.f24018i + "}";
    }
}

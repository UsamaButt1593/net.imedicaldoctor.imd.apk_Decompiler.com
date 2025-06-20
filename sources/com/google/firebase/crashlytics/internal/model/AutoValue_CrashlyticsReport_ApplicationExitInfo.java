package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends CrashlyticsReport.ApplicationExitInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f23932a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23933b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23934c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23935d;

    /* renamed from: e  reason: collision with root package name */
    private final long f23936e;

    /* renamed from: f  reason: collision with root package name */
    private final long f23937f;

    /* renamed from: g  reason: collision with root package name */
    private final long f23938g;

    /* renamed from: h  reason: collision with root package name */
    private final String f23939h;

    /* renamed from: i  reason: collision with root package name */
    private final List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> f23940i;

    static final class Builder extends CrashlyticsReport.ApplicationExitInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f23941a;

        /* renamed from: b  reason: collision with root package name */
        private String f23942b;

        /* renamed from: c  reason: collision with root package name */
        private int f23943c;

        /* renamed from: d  reason: collision with root package name */
        private int f23944d;

        /* renamed from: e  reason: collision with root package name */
        private long f23945e;

        /* renamed from: f  reason: collision with root package name */
        private long f23946f;

        /* renamed from: g  reason: collision with root package name */
        private long f23947g;

        /* renamed from: h  reason: collision with root package name */
        private String f23948h;

        /* renamed from: i  reason: collision with root package name */
        private List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> f23949i;

        /* renamed from: j  reason: collision with root package name */
        private byte f23950j;

        Builder() {
        }

        public CrashlyticsReport.ApplicationExitInfo a() {
            String str;
            if (this.f23950j == 63 && (str = this.f23942b) != null) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.f23941a, str, this.f23943c, this.f23944d, this.f23945e, this.f23946f, this.f23947g, this.f23948h, this.f23949i);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f23950j & 1) == 0) {
                sb.append(" pid");
            }
            if (this.f23942b == null) {
                sb.append(" processName");
            }
            if ((this.f23950j & 2) == 0) {
                sb.append(" reasonCode");
            }
            if ((this.f23950j & 4) == 0) {
                sb.append(" importance");
            }
            if ((this.f23950j & 8) == 0) {
                sb.append(" pss");
            }
            if ((this.f23950j & 16) == 0) {
                sb.append(" rss");
            }
            if ((this.f23950j & 32) == 0) {
                sb.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder b(@Nullable List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list) {
            this.f23949i = list;
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder c(int i2) {
            this.f23944d = i2;
            this.f23950j = (byte) (this.f23950j | 4);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder d(int i2) {
            this.f23941a = i2;
            this.f23950j = (byte) (this.f23950j | 1);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder e(String str) {
            if (str != null) {
                this.f23942b = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder f(long j2) {
            this.f23945e = j2;
            this.f23950j = (byte) (this.f23950j | 8);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder g(int i2) {
            this.f23943c = i2;
            this.f23950j = (byte) (this.f23950j | 2);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder h(long j2) {
            this.f23946f = j2;
            this.f23950j = (byte) (this.f23950j | 16);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder i(long j2) {
            this.f23947g = j2;
            this.f23950j = (byte) (this.f23950j | 32);
            return this;
        }

        public CrashlyticsReport.ApplicationExitInfo.Builder j(@Nullable String str) {
            this.f23948h = str;
            return this;
        }
    }

    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i2, String str, int i3, int i4, long j2, long j3, long j4, @Nullable String str2, @Nullable List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list) {
        this.f23932a = i2;
        this.f23933b = str;
        this.f23934c = i3;
        this.f23935d = i4;
        this.f23936e = j2;
        this.f23937f = j3;
        this.f23938g = j4;
        this.f23939h = str2;
        this.f23940i = list;
    }

    @Nullable
    public List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> b() {
        return this.f23940i;
    }

    @NonNull
    public int c() {
        return this.f23935d;
    }

    @NonNull
    public int d() {
        return this.f23932a;
    }

    @NonNull
    public String e() {
        return this.f23933b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = (CrashlyticsReport.ApplicationExitInfo) obj;
        if (this.f23932a == applicationExitInfo.d() && this.f23933b.equals(applicationExitInfo.e()) && this.f23934c == applicationExitInfo.g() && this.f23935d == applicationExitInfo.c() && this.f23936e == applicationExitInfo.f() && this.f23937f == applicationExitInfo.h() && this.f23938g == applicationExitInfo.i() && ((str = this.f23939h) != null ? str.equals(applicationExitInfo.j()) : applicationExitInfo.j() == null)) {
            List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list = this.f23940i;
            List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> b2 = applicationExitInfo.b();
            if (list == null) {
                if (b2 == null) {
                    return true;
                }
            } else if (list.equals(b2)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public long f() {
        return this.f23936e;
    }

    @NonNull
    public int g() {
        return this.f23934c;
    }

    @NonNull
    public long h() {
        return this.f23937f;
    }

    public int hashCode() {
        long j2 = this.f23936e;
        long j3 = this.f23937f;
        long j4 = this.f23938g;
        int hashCode = (((((((((((((this.f23932a ^ 1000003) * 1000003) ^ this.f23933b.hashCode()) * 1000003) ^ this.f23934c) * 1000003) ^ this.f23935d) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        String str = this.f23939h;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> list = this.f23940i;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 ^ i2;
    }

    @NonNull
    public long i() {
        return this.f23938g;
    }

    @Nullable
    public String j() {
        return this.f23939h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.f23932a + ", processName=" + this.f23933b + ", reasonCode=" + this.f23934c + ", importance=" + this.f23935d + ", pss=" + this.f23936e + ", rss=" + this.f23937f + ", timestamp=" + this.f23938g + ", traceFile=" + this.f23939h + ", buildIdMappingForArch=" + this.f23940i + "}";
    }
}

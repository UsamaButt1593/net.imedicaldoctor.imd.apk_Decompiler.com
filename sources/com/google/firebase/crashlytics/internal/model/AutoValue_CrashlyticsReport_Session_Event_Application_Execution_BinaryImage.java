package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {

    /* renamed from: a  reason: collision with root package name */
    private final long f24067a;

    /* renamed from: b  reason: collision with root package name */
    private final long f24068b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24069c;

    /* renamed from: d  reason: collision with root package name */
    private final String f24070d;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f24071a;

        /* renamed from: b  reason: collision with root package name */
        private long f24072b;

        /* renamed from: c  reason: collision with root package name */
        private String f24073c;

        /* renamed from: d  reason: collision with root package name */
        private String f24074d;

        /* renamed from: e  reason: collision with root package name */
        private byte f24075e;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage a() {
            String str;
            if (this.f24075e == 3 && (str = this.f24073c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.f24071a, this.f24072b, str, this.f24074d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f24075e & 1) == 0) {
                sb.append(" baseAddress");
            }
            if ((this.f24075e & 2) == 0) {
                sb.append(" size");
            }
            if (this.f24073c == null) {
                sb.append(" name");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder b(long j2) {
            this.f24071a = j2;
            this.f24075e = (byte) (this.f24075e | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder c(String str) {
            if (str != null) {
                this.f24073c = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder d(long j2) {
            this.f24072b = j2;
            this.f24075e = (byte) (this.f24075e | 2);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder e(@Nullable String str) {
            this.f24074d = str;
            return this;
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j2, long j3, String str, @Nullable String str2) {
        this.f24067a = j2;
        this.f24068b = j3;
        this.f24069c = str;
        this.f24070d = str2;
    }

    @NonNull
    public long b() {
        return this.f24067a;
    }

    @NonNull
    public String c() {
        return this.f24069c;
    }

    public long d() {
        return this.f24068b;
    }

    @Encodable.Ignore
    @Nullable
    public String e() {
        return this.f24070d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) obj;
        if (this.f24067a == binaryImage.b() && this.f24068b == binaryImage.d() && this.f24069c.equals(binaryImage.c())) {
            String str = this.f24070d;
            String e2 = binaryImage.e();
            if (str == null) {
                if (e2 == null) {
                    return true;
                }
            } else if (str.equals(e2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f24067a;
        long j3 = this.f24068b;
        int hashCode = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f24069c.hashCode()) * 1000003;
        String str = this.f24070d;
        return (str == null ? 0 : str.hashCode()) ^ hashCode;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f24067a + ", size=" + this.f24068b + ", name=" + this.f24069c + ", uuid=" + this.f24070d + "}";
    }
}

package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

final class AutoValue_LogEvent extends LogEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f19336a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f19337b;

    /* renamed from: c  reason: collision with root package name */
    private final ComplianceData f19338c;

    /* renamed from: d  reason: collision with root package name */
    private final long f19339d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f19340e;

    /* renamed from: f  reason: collision with root package name */
    private final String f19341f;

    /* renamed from: g  reason: collision with root package name */
    private final long f19342g;

    /* renamed from: h  reason: collision with root package name */
    private final NetworkConnectionInfo f19343h;

    /* renamed from: i  reason: collision with root package name */
    private final ExperimentIds f19344i;

    static final class Builder extends LogEvent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f19345a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f19346b;

        /* renamed from: c  reason: collision with root package name */
        private ComplianceData f19347c;

        /* renamed from: d  reason: collision with root package name */
        private Long f19348d;

        /* renamed from: e  reason: collision with root package name */
        private byte[] f19349e;

        /* renamed from: f  reason: collision with root package name */
        private String f19350f;

        /* renamed from: g  reason: collision with root package name */
        private Long f19351g;

        /* renamed from: h  reason: collision with root package name */
        private NetworkConnectionInfo f19352h;

        /* renamed from: i  reason: collision with root package name */
        private ExperimentIds f19353i;

        Builder() {
        }

        public LogEvent a() {
            String str = "";
            if (this.f19345a == null) {
                str = str + " eventTimeMs";
            }
            if (this.f19348d == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f19351g == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogEvent(this.f19345a.longValue(), this.f19346b, this.f19347c, this.f19348d.longValue(), this.f19349e, this.f19350f, this.f19351g.longValue(), this.f19352h, this.f19353i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public LogEvent.Builder b(@Nullable ComplianceData complianceData) {
            this.f19347c = complianceData;
            return this;
        }

        public LogEvent.Builder c(@Nullable Integer num) {
            this.f19346b = num;
            return this;
        }

        public LogEvent.Builder d(long j2) {
            this.f19345a = Long.valueOf(j2);
            return this;
        }

        public LogEvent.Builder e(long j2) {
            this.f19348d = Long.valueOf(j2);
            return this;
        }

        public LogEvent.Builder f(@Nullable ExperimentIds experimentIds) {
            this.f19353i = experimentIds;
            return this;
        }

        public LogEvent.Builder g(@Nullable NetworkConnectionInfo networkConnectionInfo) {
            this.f19352h = networkConnectionInfo;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogEvent.Builder h(@Nullable byte[] bArr) {
            this.f19349e = bArr;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogEvent.Builder i(@Nullable String str) {
            this.f19350f = str;
            return this;
        }

        public LogEvent.Builder j(long j2) {
            this.f19351g = Long.valueOf(j2);
            return this;
        }
    }

    private AutoValue_LogEvent(long j2, @Nullable Integer num, @Nullable ComplianceData complianceData, long j3, @Nullable byte[] bArr, @Nullable String str, long j4, @Nullable NetworkConnectionInfo networkConnectionInfo, @Nullable ExperimentIds experimentIds) {
        this.f19336a = j2;
        this.f19337b = num;
        this.f19338c = complianceData;
        this.f19339d = j3;
        this.f19340e = bArr;
        this.f19341f = str;
        this.f19342g = j4;
        this.f19343h = networkConnectionInfo;
        this.f19344i = experimentIds;
    }

    @Nullable
    public ComplianceData b() {
        return this.f19338c;
    }

    @Nullable
    public Integer c() {
        return this.f19337b;
    }

    public long d() {
        return this.f19336a;
    }

    public long e() {
        return this.f19339d;
    }

    public boolean equals(Object obj) {
        Integer num;
        ComplianceData complianceData;
        String str;
        NetworkConnectionInfo networkConnectionInfo;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.f19336a == logEvent.d() && ((num = this.f19337b) != null ? num.equals(logEvent.c()) : logEvent.c() == null) && ((complianceData = this.f19338c) != null ? complianceData.equals(logEvent.b()) : logEvent.b() == null) && this.f19339d == logEvent.e()) {
            if (Arrays.equals(this.f19340e, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).f19340e : logEvent.h()) && ((str = this.f19341f) != null ? str.equals(logEvent.i()) : logEvent.i() == null) && this.f19342g == logEvent.j() && ((networkConnectionInfo = this.f19343h) != null ? networkConnectionInfo.equals(logEvent.g()) : logEvent.g() == null)) {
                ExperimentIds experimentIds = this.f19344i;
                ExperimentIds f2 = logEvent.f();
                if (experimentIds == null) {
                    if (f2 == null) {
                        return true;
                    }
                } else if (experimentIds.equals(f2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public ExperimentIds f() {
        return this.f19344i;
    }

    @Nullable
    public NetworkConnectionInfo g() {
        return this.f19343h;
    }

    @Nullable
    public byte[] h() {
        return this.f19340e;
    }

    public int hashCode() {
        long j2 = this.f19336a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f19337b;
        int i3 = 0;
        int hashCode = (i2 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        ComplianceData complianceData = this.f19338c;
        int hashCode2 = complianceData == null ? 0 : complianceData.hashCode();
        long j3 = this.f19339d;
        int hashCode3 = (((((hashCode ^ hashCode2) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f19340e)) * 1000003;
        String str = this.f19341f;
        int hashCode4 = str == null ? 0 : str.hashCode();
        long j4 = this.f19342g;
        int i4 = (((hashCode3 ^ hashCode4) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f19343h;
        int hashCode5 = (i4 ^ (networkConnectionInfo == null ? 0 : networkConnectionInfo.hashCode())) * 1000003;
        ExperimentIds experimentIds = this.f19344i;
        if (experimentIds != null) {
            i3 = experimentIds.hashCode();
        }
        return hashCode5 ^ i3;
    }

    @Nullable
    public String i() {
        return this.f19341f;
    }

    public long j() {
        return this.f19342g;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f19336a + ", eventCode=" + this.f19337b + ", complianceData=" + this.f19338c + ", eventUptimeMs=" + this.f19339d + ", sourceExtension=" + Arrays.toString(this.f19340e) + ", sourceExtensionJsonProto3=" + this.f19341f + ", timezoneOffsetSeconds=" + this.f19342g + ", networkConnectionInfo=" + this.f19343h + ", experimentIds=" + this.f19344i + "}";
    }
}

package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

final class AutoValue_LogRequest extends LogRequest {

    /* renamed from: a  reason: collision with root package name */
    private final long f19354a;

    /* renamed from: b  reason: collision with root package name */
    private final long f19355b;

    /* renamed from: c  reason: collision with root package name */
    private final ClientInfo f19356c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f19357d;

    /* renamed from: e  reason: collision with root package name */
    private final String f19358e;

    /* renamed from: f  reason: collision with root package name */
    private final List<LogEvent> f19359f;

    /* renamed from: g  reason: collision with root package name */
    private final QosTier f19360g;

    static final class Builder extends LogRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f19361a;

        /* renamed from: b  reason: collision with root package name */
        private Long f19362b;

        /* renamed from: c  reason: collision with root package name */
        private ClientInfo f19363c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f19364d;

        /* renamed from: e  reason: collision with root package name */
        private String f19365e;

        /* renamed from: f  reason: collision with root package name */
        private List<LogEvent> f19366f;

        /* renamed from: g  reason: collision with root package name */
        private QosTier f19367g;

        Builder() {
        }

        public LogRequest a() {
            String str = "";
            if (this.f19361a == null) {
                str = str + " requestTimeMs";
            }
            if (this.f19362b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogRequest(this.f19361a.longValue(), this.f19362b.longValue(), this.f19363c, this.f19364d, this.f19365e, this.f19366f, this.f19367g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public LogRequest.Builder b(@Nullable ClientInfo clientInfo) {
            this.f19363c = clientInfo;
            return this;
        }

        public LogRequest.Builder c(@Nullable List<LogEvent> list) {
            this.f19366f = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogRequest.Builder d(@Nullable Integer num) {
            this.f19364d = num;
            return this;
        }

        /* access modifiers changed from: package-private */
        public LogRequest.Builder e(@Nullable String str) {
            this.f19365e = str;
            return this;
        }

        public LogRequest.Builder f(@Nullable QosTier qosTier) {
            this.f19367g = qosTier;
            return this;
        }

        public LogRequest.Builder g(long j2) {
            this.f19361a = Long.valueOf(j2);
            return this;
        }

        public LogRequest.Builder h(long j2) {
            this.f19362b = Long.valueOf(j2);
            return this;
        }
    }

    private AutoValue_LogRequest(long j2, long j3, @Nullable ClientInfo clientInfo, @Nullable Integer num, @Nullable String str, @Nullable List<LogEvent> list, @Nullable QosTier qosTier) {
        this.f19354a = j2;
        this.f19355b = j3;
        this.f19356c = clientInfo;
        this.f19357d = num;
        this.f19358e = str;
        this.f19359f = list;
        this.f19360g = qosTier;
    }

    @Nullable
    public ClientInfo b() {
        return this.f19356c;
    }

    @Nullable
    @Encodable.Field(name = "logEvent")
    public List<LogEvent> c() {
        return this.f19359f;
    }

    @Nullable
    public Integer d() {
        return this.f19357d;
    }

    @Nullable
    public String e() {
        return this.f19358e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.f19354a == logRequest.g() && this.f19355b == logRequest.h() && ((clientInfo = this.f19356c) != null ? clientInfo.equals(logRequest.b()) : logRequest.b() == null) && ((num = this.f19357d) != null ? num.equals(logRequest.d()) : logRequest.d() == null) && ((str = this.f19358e) != null ? str.equals(logRequest.e()) : logRequest.e() == null) && ((list = this.f19359f) != null ? list.equals(logRequest.c()) : logRequest.c() == null)) {
            QosTier qosTier = this.f19360g;
            QosTier f2 = logRequest.f();
            if (qosTier == null) {
                if (f2 == null) {
                    return true;
                }
            } else if (qosTier.equals(f2)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public QosTier f() {
        return this.f19360g;
    }

    public long g() {
        return this.f19354a;
    }

    public long h() {
        return this.f19355b;
    }

    public int hashCode() {
        long j2 = this.f19354a;
        long j3 = this.f19355b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        ClientInfo clientInfo = this.f19356c;
        int i3 = 0;
        int hashCode = (i2 ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f19357d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f19358e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<LogEvent> list = this.f19359f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.f19360g;
        if (qosTier != null) {
            i3 = qosTier.hashCode();
        }
        return hashCode4 ^ i3;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f19354a + ", requestUptimeMs=" + this.f19355b + ", clientInfo=" + this.f19356c + ", logSource=" + this.f19357d + ", logSourceName=" + this.f19358e + ", logEvents=" + this.f19359f + ", qosTier=" + this.f19360g + "}";
    }
}

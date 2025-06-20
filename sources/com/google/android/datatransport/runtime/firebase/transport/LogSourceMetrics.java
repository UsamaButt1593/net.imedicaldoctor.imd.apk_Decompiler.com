package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LogSourceMetrics {

    /* renamed from: c  reason: collision with root package name */
    private static final LogSourceMetrics f19510c = new Builder().b();

    /* renamed from: a  reason: collision with root package name */
    private final String f19511a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogEventDropped> f19512b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f19513a = "";

        /* renamed from: b  reason: collision with root package name */
        private List<LogEventDropped> f19514b = new ArrayList();

        Builder() {
        }

        public Builder a(LogEventDropped logEventDropped) {
            this.f19514b.add(logEventDropped);
            return this;
        }

        public LogSourceMetrics b() {
            return new LogSourceMetrics(this.f19513a, Collections.unmodifiableList(this.f19514b));
        }

        public Builder c(List<LogEventDropped> list) {
            this.f19514b = list;
            return this;
        }

        public Builder d(String str) {
            this.f19513a = str;
            return this;
        }
    }

    LogSourceMetrics(String str, List<LogEventDropped> list) {
        this.f19511a = str;
        this.f19512b = list;
    }

    public static LogSourceMetrics a() {
        return f19510c;
    }

    public static Builder d() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    @Encodable.Field(name = "logEventDropped")
    public List<LogEventDropped> b() {
        return this.f19512b;
    }

    @Protobuf(tag = 1)
    public String c() {
        return this.f19511a;
    }
}

package com.google.android.datatransport.runtime.firebase.transport;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ClientMetrics {

    /* renamed from: e  reason: collision with root package name */
    private static final ClientMetrics f19493e = new Builder().b();

    /* renamed from: a  reason: collision with root package name */
    private final TimeWindow f19494a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogSourceMetrics> f19495b;

    /* renamed from: c  reason: collision with root package name */
    private final GlobalMetrics f19496c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19497d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private TimeWindow f19498a = null;

        /* renamed from: b  reason: collision with root package name */
        private List<LogSourceMetrics> f19499b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private GlobalMetrics f19500c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f19501d = "";

        Builder() {
        }

        public Builder a(LogSourceMetrics logSourceMetrics) {
            this.f19499b.add(logSourceMetrics);
            return this;
        }

        public ClientMetrics b() {
            return new ClientMetrics(this.f19498a, Collections.unmodifiableList(this.f19499b), this.f19500c, this.f19501d);
        }

        public Builder c(String str) {
            this.f19501d = str;
            return this;
        }

        public Builder d(GlobalMetrics globalMetrics) {
            this.f19500c = globalMetrics;
            return this;
        }

        public Builder e(List<LogSourceMetrics> list) {
            this.f19499b = list;
            return this;
        }

        public Builder f(TimeWindow timeWindow) {
            this.f19498a = timeWindow;
            return this;
        }
    }

    ClientMetrics(TimeWindow timeWindow, List<LogSourceMetrics> list, GlobalMetrics globalMetrics, String str) {
        this.f19494a = timeWindow;
        this.f19495b = list;
        this.f19496c = globalMetrics;
        this.f19497d = str;
    }

    public static ClientMetrics b() {
        return f19493e;
    }

    public static Builder h() {
        return new Builder();
    }

    @Protobuf(tag = 4)
    public String a() {
        return this.f19497d;
    }

    @Encodable.Ignore
    public GlobalMetrics c() {
        GlobalMetrics globalMetrics = this.f19496c;
        return globalMetrics == null ? GlobalMetrics.a() : globalMetrics;
    }

    @Protobuf(tag = 3)
    @Encodable.Field(name = "globalMetrics")
    public GlobalMetrics d() {
        return this.f19496c;
    }

    @Protobuf(tag = 2)
    @Encodable.Field(name = "logSourceMetrics")
    public List<LogSourceMetrics> e() {
        return this.f19495b;
    }

    @Encodable.Ignore
    public TimeWindow f() {
        TimeWindow timeWindow = this.f19494a;
        return timeWindow == null ? TimeWindow.a() : timeWindow;
    }

    @Protobuf(tag = 1)
    @Encodable.Field(name = "window")
    public TimeWindow g() {
        return this.f19494a;
    }

    public byte[] i() {
        return ProtoEncoderDoNotUse.b(this);
    }

    public void j(OutputStream outputStream) throws IOException {
        ProtoEncoderDoNotUse.a(this, outputStream);
    }
}

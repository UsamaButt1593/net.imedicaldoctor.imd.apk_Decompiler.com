package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

public final class LogEventDropped {

    /* renamed from: c  reason: collision with root package name */
    private static final LogEventDropped f19505c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f19506a;

    /* renamed from: b  reason: collision with root package name */
    private final Reason f19507b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f19508a = 0;

        /* renamed from: b  reason: collision with root package name */
        private Reason f19509b = Reason.REASON_UNKNOWN;

        Builder() {
        }

        public LogEventDropped a() {
            return new LogEventDropped(this.f19508a, this.f19509b);
        }

        public Builder b(long j2) {
            this.f19508a = j2;
            return this;
        }

        public Builder c(Reason reason) {
            this.f19509b = reason;
            return this;
        }
    }

    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);
        
        private final int s;

        private Reason(int i2) {
            this.s = i2;
        }

        public int d() {
            return this.s;
        }
    }

    LogEventDropped(long j2, Reason reason) {
        this.f19506a = j2;
        this.f19507b = reason;
    }

    public static LogEventDropped a() {
        return f19505c;
    }

    public static Builder d() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public long b() {
        return this.f19506a;
    }

    @Protobuf(tag = 3)
    public Reason c() {
        return this.f19507b;
    }
}

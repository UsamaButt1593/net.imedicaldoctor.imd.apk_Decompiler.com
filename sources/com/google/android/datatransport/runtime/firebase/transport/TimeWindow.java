package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

public final class TimeWindow {

    /* renamed from: c  reason: collision with root package name */
    private static final TimeWindow f19520c = new Builder().a();

    /* renamed from: a  reason: collision with root package name */
    private final long f19521a;

    /* renamed from: b  reason: collision with root package name */
    private final long f19522b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f19523a = 0;

        /* renamed from: b  reason: collision with root package name */
        private long f19524b = 0;

        Builder() {
        }

        public TimeWindow a() {
            return new TimeWindow(this.f19523a, this.f19524b);
        }

        public Builder b(long j2) {
            this.f19524b = j2;
            return this;
        }

        public Builder c(long j2) {
            this.f19523a = j2;
            return this;
        }
    }

    TimeWindow(long j2, long j3) {
        this.f19521a = j2;
        this.f19522b = j3;
    }

    public static TimeWindow a() {
        return f19520c;
    }

    public static Builder d() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    public long b() {
        return this.f19522b;
    }

    @Protobuf(tag = 1)
    public long c() {
        return this.f19521a;
    }
}

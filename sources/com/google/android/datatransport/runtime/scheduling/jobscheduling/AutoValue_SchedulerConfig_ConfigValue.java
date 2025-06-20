package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.ConfigValue {

    /* renamed from: a  reason: collision with root package name */
    private final long f19558a;

    /* renamed from: b  reason: collision with root package name */
    private final long f19559b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<SchedulerConfig.Flag> f19560c;

    static final class Builder extends SchedulerConfig.ConfigValue.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f19561a;

        /* renamed from: b  reason: collision with root package name */
        private Long f19562b;

        /* renamed from: c  reason: collision with root package name */
        private Set<SchedulerConfig.Flag> f19563c;

        Builder() {
        }

        public SchedulerConfig.ConfigValue a() {
            String str = "";
            if (this.f19561a == null) {
                str = str + " delta";
            }
            if (this.f19562b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f19563c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.f19561a.longValue(), this.f19562b.longValue(), this.f19563c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public SchedulerConfig.ConfigValue.Builder b(long j2) {
            this.f19561a = Long.valueOf(j2);
            return this;
        }

        public SchedulerConfig.ConfigValue.Builder c(Set<SchedulerConfig.Flag> set) {
            if (set != null) {
                this.f19563c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        public SchedulerConfig.ConfigValue.Builder d(long j2) {
            this.f19562b = Long.valueOf(j2);
            return this;
        }
    }

    private AutoValue_SchedulerConfig_ConfigValue(long j2, long j3, Set<SchedulerConfig.Flag> set) {
        this.f19558a = j2;
        this.f19559b = j3;
        this.f19560c = set;
    }

    /* access modifiers changed from: package-private */
    public long b() {
        return this.f19558a;
    }

    /* access modifiers changed from: package-private */
    public Set<SchedulerConfig.Flag> c() {
        return this.f19560c;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        return this.f19559b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        return this.f19558a == configValue.b() && this.f19559b == configValue.d() && this.f19560c.equals(configValue.c());
    }

    public int hashCode() {
        long j2 = this.f19558a;
        long j3 = this.f19559b;
        return this.f19560c.hashCode() ^ ((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f19558a + ", maxAllowedDelay=" + this.f19559b + ", flags=" + this.f19560c + "}";
    }
}

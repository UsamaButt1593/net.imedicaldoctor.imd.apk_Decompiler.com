package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

final class AutoValue_SchedulerConfig extends SchedulerConfig {

    /* renamed from: e  reason: collision with root package name */
    private final Clock f19556e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Priority, SchedulerConfig.ConfigValue> f19557f;

    AutoValue_SchedulerConfig(Clock clock, Map<Priority, SchedulerConfig.ConfigValue> map) {
        if (clock != null) {
            this.f19556e = clock;
            if (map != null) {
                this.f19557f = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    /* access modifiers changed from: package-private */
    public Clock e() {
        return this.f19556e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.f19556e.equals(schedulerConfig.e()) && this.f19557f.equals(schedulerConfig.i());
    }

    public int hashCode() {
        return ((this.f19556e.hashCode() ^ 1000003) * 1000003) ^ this.f19557f.hashCode();
    }

    /* access modifiers changed from: package-private */
    public Map<Priority, SchedulerConfig.ConfigValue> i() {
        return this.f19557f;
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f19556e + ", values=" + this.f19557f + "}";
    }
}

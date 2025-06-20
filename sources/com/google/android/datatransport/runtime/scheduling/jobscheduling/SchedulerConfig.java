package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@AutoValue
public abstract class SchedulerConfig {

    /* renamed from: a  reason: collision with root package name */
    private static final long f19572a = 86400000;

    /* renamed from: b  reason: collision with root package name */
    private static final long f19573b = 30000;

    /* renamed from: c  reason: collision with root package name */
    private static final long f19574c = 1000;

    /* renamed from: d  reason: collision with root package name */
    private static final long f19575d = 10000;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Clock f19576a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Priority, ConfigValue> f19577b = new HashMap();

        public Builder a(Priority priority, ConfigValue configValue) {
            this.f19577b.put(priority, configValue);
            return this;
        }

        public SchedulerConfig b() {
            if (this.f19576a == null) {
                throw new NullPointerException("missing required property: clock");
            } else if (this.f19577b.keySet().size() >= Priority.values().length) {
                Map<Priority, ConfigValue> map = this.f19577b;
                this.f19577b = new HashMap();
                return SchedulerConfig.d(this.f19576a, map);
            } else {
                throw new IllegalStateException("Not all priorities have been configured");
            }
        }

        public Builder c(Clock clock) {
            this.f19576a = clock;
            return this;
        }
    }

    @AutoValue
    public static abstract class ConfigValue {

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract ConfigValue a();

            public abstract Builder b(long j2);

            public abstract Builder c(Set<Flag> set);

            public abstract Builder d(long j2);
        }

        public static Builder a() {
            return new AutoValue_SchedulerConfig_ConfigValue.Builder().c(Collections.emptySet());
        }

        /* access modifiers changed from: package-private */
        public abstract long b();

        /* access modifiers changed from: package-private */
        public abstract Set<Flag> c();

        /* access modifiers changed from: package-private */
        public abstract long d();
    }

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i2, long j2) {
        int i3 = i2 - 1;
        return (long) (Math.pow(3.0d, (double) i3) * ((double) j2) * Math.max(1.0d, Math.log(10000.0d) / Math.log((double) ((j2 > 1 ? j2 : 2) * ((long) i3)))));
    }

    public static Builder b() {
        return new Builder();
    }

    static SchedulerConfig d(Clock clock, Map<Priority, ConfigValue> map) {
        return new AutoValue_SchedulerConfig(clock, map);
    }

    public static SchedulerConfig f(Clock clock) {
        return b().a(Priority.DEFAULT, ConfigValue.a().b(30000).d(86400000).a()).a(Priority.HIGHEST, ConfigValue.a().b(1000).d(86400000).a()).a(Priority.VERY_LOW, ConfigValue.a().b(86400000).d(86400000).c(j(Flag.DEVICE_IDLE)).a()).c(clock).b();
    }

    private static <T> Set<T> j(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    @RequiresApi(api = 21)
    private void k(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    @RequiresApi(api = 21)
    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j2, int i2) {
        builder.setMinimumLatency(h(priority, j2, i2));
        k(builder, i().get(priority).c());
        return builder;
    }

    /* access modifiers changed from: package-private */
    public abstract Clock e();

    public Set<Flag> g(Priority priority) {
        return i().get(priority).c();
    }

    public long h(Priority priority, long j2, int i2) {
        long a2 = j2 - e().a();
        ConfigValue configValue = i().get(priority);
        return Math.min(Math.max(a(i2, configValue.b()), a2), configValue.d());
    }

    /* access modifiers changed from: package-private */
    public abstract Map<Priority, ConfigValue> i();
}

package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.google.android.datatransport.runtime.time.Monotonic"})
public final class TimeModule_UptimeClockFactory implements Factory<Clock> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final TimeModule_UptimeClockFactory f19698a = new TimeModule_UptimeClockFactory();

        private InstanceHolder() {
        }
    }

    public static TimeModule_UptimeClockFactory a() {
        return InstanceHolder.f19698a;
    }

    public static Clock c() {
        return (Clock) Preconditions.f(TimeModule.b());
    }

    /* renamed from: b */
    public Clock get() {
        return c();
    }
}

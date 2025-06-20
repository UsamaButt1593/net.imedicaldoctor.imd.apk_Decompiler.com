package com.google.android.datatransport.runtime.time;

import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata({"com.google.android.datatransport.runtime.time.WallTime"})
public final class TimeModule_EventClockFactory implements Factory<Clock> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final TimeModule_EventClockFactory f19697a = new TimeModule_EventClockFactory();

        private InstanceHolder() {
        }
    }

    public static TimeModule_EventClockFactory a() {
        return InstanceHolder.f19697a;
    }

    public static Clock b() {
        return (Clock) Preconditions.f(TimeModule.a());
    }

    /* renamed from: c */
    public Clock get() {
        return b();
    }
}

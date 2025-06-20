package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

class TimeSource {

    /* renamed from: c  reason: collision with root package name */
    private static final TimeSource f21385c = new TimeSource((Long) null, (TimeZone) null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Long f21386a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final TimeZone f21387b;

    private TimeSource(@Nullable Long l2, @Nullable TimeZone timeZone) {
        this.f21386a = l2;
        this.f21387b = timeZone;
    }

    static TimeSource a(long j2) {
        return new TimeSource(Long.valueOf(j2), (TimeZone) null);
    }

    static TimeSource b(long j2, @Nullable TimeZone timeZone) {
        return new TimeSource(Long.valueOf(j2), timeZone);
    }

    static TimeSource e() {
        return f21385c;
    }

    /* access modifiers changed from: package-private */
    public Calendar c() {
        return d(this.f21387b);
    }

    /* access modifiers changed from: package-private */
    public Calendar d(@Nullable TimeZone timeZone) {
        Calendar instance = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l2 = this.f21386a;
        if (l2 != null) {
            instance.setTimeInMillis(l2.longValue());
        }
        return instance;
    }
}

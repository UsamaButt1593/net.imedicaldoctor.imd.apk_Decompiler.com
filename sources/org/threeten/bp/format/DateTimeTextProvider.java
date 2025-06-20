package org.threeten.bp.format;

import androidx.lifecycle.g;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.temporal.TemporalField;

public abstract class DateTimeTextProvider {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<DateTimeTextProvider> f31839a = new AtomicReference<>();

    static class ProviderSingleton {

        /* renamed from: a  reason: collision with root package name */
        static final DateTimeTextProvider f31840a = a();

        ProviderSingleton() {
        }

        static DateTimeTextProvider a() {
            g.a(DateTimeTextProvider.f31839a, (Object) null, new SimpleDateTimeTextProvider());
            return (DateTimeTextProvider) DateTimeTextProvider.f31839a.get();
        }
    }

    static DateTimeTextProvider b() {
        return ProviderSingleton.f31840a;
    }

    public static void e(DateTimeTextProvider dateTimeTextProvider) {
        if (!g.a(f31839a, (Object) null, dateTimeTextProvider)) {
            throw new IllegalStateException("Provider was already set, possibly with a default during initialization");
        }
    }

    public abstract String c(TemporalField temporalField, long j2, TextStyle textStyle, Locale locale);

    public abstract Iterator<Map.Entry<String, Long>> d(TemporalField temporalField, TextStyle textStyle, Locale locale);
}

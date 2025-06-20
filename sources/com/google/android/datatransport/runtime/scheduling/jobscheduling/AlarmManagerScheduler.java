package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class AlarmManagerScheduler implements WorkScheduler {

    /* renamed from: f  reason: collision with root package name */
    private static final String f19546f = "AlarmManagerScheduler";

    /* renamed from: g  reason: collision with root package name */
    static final String f19547g = "attemptNumber";

    /* renamed from: h  reason: collision with root package name */
    static final String f19548h = "backendName";

    /* renamed from: i  reason: collision with root package name */
    static final String f19549i = "priority";

    /* renamed from: j  reason: collision with root package name */
    static final String f19550j = "extras";

    /* renamed from: a  reason: collision with root package name */
    private final Context f19551a;

    /* renamed from: b  reason: collision with root package name */
    private final EventStore f19552b;

    /* renamed from: c  reason: collision with root package name */
    private AlarmManager f19553c;

    /* renamed from: d  reason: collision with root package name */
    private final SchedulerConfig f19554d;

    /* renamed from: e  reason: collision with root package name */
    private final Clock f19555e;

    @VisibleForTesting
    AlarmManagerScheduler(Context context, EventStore eventStore, AlarmManager alarmManager, Clock clock, SchedulerConfig schedulerConfig) {
        this.f19551a = context;
        this.f19552b = eventStore;
        this.f19553c = alarmManager;
        this.f19555e = clock;
        this.f19554d = schedulerConfig;
    }

    public void a(TransportContext transportContext, int i2) {
        b(transportContext, i2, false);
    }

    public void b(TransportContext transportContext, int i2, boolean z) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter(f19548h, transportContext.b());
        builder.appendQueryParameter(f19549i, String.valueOf(PriorityMapping.a(transportContext.d())));
        if (transportContext.c() != null) {
            builder.appendQueryParameter(f19550j, Base64.encodeToString(transportContext.c(), 0));
        }
        Intent intent = new Intent(this.f19551a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra(f19547g, i2);
        if (z || !c(intent)) {
            long m2 = this.f19552b.m2(transportContext);
            long h2 = this.f19554d.h(transportContext.d(), m2, i2);
            Logging.e(f19546f, "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Long.valueOf(h2), Long.valueOf(m2), Integer.valueOf(i2));
            this.f19553c.set(3, this.f19555e.a() + h2, PendingIntent.getBroadcast(this.f19551a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
            return;
        }
        Logging.c(f19546f, "Upload for context %s is already scheduled. Returning...", transportContext);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean c(Intent intent) {
        return PendingIntent.getBroadcast(this.f19551a, 0, intent, Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912) != null;
    }

    public AlarmManagerScheduler(Context context, EventStore eventStore, Clock clock, SchedulerConfig schedulerConfig) {
        this(context, eventStore, (AlarmManager) context.getSystemService(NotificationCompat.K0), clock, schedulerConfig);
    }
}

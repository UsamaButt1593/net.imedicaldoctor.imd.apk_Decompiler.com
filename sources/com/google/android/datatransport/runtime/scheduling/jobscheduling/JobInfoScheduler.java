package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

@RequiresApi(api = 21)
public class JobInfoScheduler implements WorkScheduler {

    /* renamed from: d  reason: collision with root package name */
    private static final String f19564d = "JobInfoScheduler";

    /* renamed from: e  reason: collision with root package name */
    static final String f19565e = "attemptNumber";

    /* renamed from: f  reason: collision with root package name */
    static final String f19566f = "backendName";

    /* renamed from: g  reason: collision with root package name */
    static final String f19567g = "priority";

    /* renamed from: h  reason: collision with root package name */
    static final String f19568h = "extras";

    /* renamed from: a  reason: collision with root package name */
    private final Context f19569a;

    /* renamed from: b  reason: collision with root package name */
    private final EventStore f19570b;

    /* renamed from: c  reason: collision with root package name */
    private final SchedulerConfig f19571c;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.f19569a = context;
        this.f19570b = eventStore;
        this.f19571c = schedulerConfig;
    }

    private boolean d(JobScheduler jobScheduler, int i2, int i3) {
        for (JobInfo next : jobScheduler.getAllPendingJobs()) {
            int i4 = next.getExtras().getInt(f19565e);
            if (next.getId() == i2) {
                return i4 >= i3;
            }
        }
        return false;
    }

    public void a(TransportContext transportContext, int i2) {
        b(transportContext, i2, false);
    }

    public void b(TransportContext transportContext, int i2, boolean z) {
        TransportContext transportContext2 = transportContext;
        int i3 = i2;
        ComponentName componentName = new ComponentName(this.f19569a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f19569a.getSystemService("jobscheduler");
        int c2 = c(transportContext);
        if (z || !d(jobScheduler, c2, i3)) {
            long m2 = this.f19570b.m2(transportContext2);
            JobInfo.Builder c3 = this.f19571c.c(new JobInfo.Builder(c2, componentName), transportContext.d(), m2, i2);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt(f19565e, i3);
            persistableBundle.putString(f19566f, transportContext.b());
            persistableBundle.putInt(f19567g, PriorityMapping.a(transportContext.d()));
            if (transportContext.c() != null) {
                persistableBundle.putString(f19568h, Base64.encodeToString(transportContext.c(), 0));
            }
            c3.setExtras(persistableBundle);
            Logging.e(f19564d, "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext2, Integer.valueOf(c2), Long.valueOf(this.f19571c.h(transportContext.d(), m2, i3)), Long.valueOf(m2), Integer.valueOf(i2));
            jobScheduler.schedule(c3.build());
            return;
        }
        Logging.c(f19564d, "Upload for context %s is already scheduled. Returning...", transportContext2);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int c(TransportContext transportContext) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f19569a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(transportContext.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.a(transportContext.d())).array());
        if (transportContext.c() != null) {
            adler32.update(transportContext.c());
        }
        return (int) adler32.getValue();
    }
}

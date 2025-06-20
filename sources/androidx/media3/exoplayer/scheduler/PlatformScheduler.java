package androidx.media3.exoplayer.scheduler;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@RequiresApi(21)
@UnstableApi
public final class PlatformScheduler implements Scheduler {

    /* renamed from: d  reason: collision with root package name */
    private static final String f11872d = "PlatformScheduler";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11873e = "service_action";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11874f = "service_package";

    /* renamed from: g  reason: collision with root package name */
    private static final String f11875g = "requirements";

    /* renamed from: h  reason: collision with root package name */
    private static final int f11876h = ((Util.f9646a >= 26 ? 16 : 0) | 15);

    /* renamed from: a  reason: collision with root package name */
    private final int f11877a;

    /* renamed from: b  reason: collision with root package name */
    private final ComponentName f11878b;

    /* renamed from: c  reason: collision with root package name */
    private final JobScheduler f11879c;

    public static final class PlatformSchedulerService extends JobService {
        public boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            int d2 = new Requirements(extras.getInt("requirements")).d(this);
            if (d2 == 0) {
                Util.s2(this, new Intent((String) Assertions.g(extras.getString(PlatformScheduler.f11873e))).setPackage((String) Assertions.g(extras.getString(PlatformScheduler.f11874f))));
                return false;
            }
            Log.n(PlatformScheduler.f11872d, "Requirements not met: " + d2);
            jobFinished(jobParameters, true);
            return false;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    @RequiresPermission("android.permission.RECEIVE_BOOT_COMPLETED")
    public PlatformScheduler(Context context, int i2) {
        Context applicationContext = context.getApplicationContext();
        this.f11877a = i2;
        this.f11878b = new ComponentName(applicationContext, PlatformSchedulerService.class);
        this.f11879c = (JobScheduler) Assertions.g((JobScheduler) applicationContext.getSystemService("jobscheduler"));
    }

    private static JobInfo c(int i2, ComponentName componentName, Requirements requirements, String str, String str2) {
        Requirements b2 = requirements.b(f11876h);
        if (!b2.equals(requirements)) {
            Log.n(f11872d, "Ignoring unsupported requirements: " + (b2.g() ^ requirements.g()));
        }
        JobInfo.Builder builder = new JobInfo.Builder(i2, componentName);
        if (requirements.z()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.p()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.m());
        builder.setRequiresCharging(requirements.j());
        if (Util.f9646a >= 26 && requirements.v()) {
            JobInfo.Builder unused = builder.setRequiresStorageNotLow(true);
        }
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(f11873e, str);
        persistableBundle.putString(f11874f, str2);
        persistableBundle.putInt("requirements", requirements.g());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    public Requirements a(Requirements requirements) {
        return requirements.b(f11876h);
    }

    public boolean b(Requirements requirements, String str, String str2) {
        return this.f11879c.schedule(c(this.f11877a, this.f11878b, requirements, str2, str)) == 1;
    }

    public boolean cancel() {
        this.f11879c.cancel(this.f11877a);
        return true;
    }
}

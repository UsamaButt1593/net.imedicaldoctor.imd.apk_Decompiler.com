package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ JobParameters X;
    public final /* synthetic */ JobInfoSchedulerService s;

    public /* synthetic */ b(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.s = jobInfoSchedulerService;
        this.X = jobParameters;
    }

    public final void run() {
        this.s.b(this.X);
    }
}

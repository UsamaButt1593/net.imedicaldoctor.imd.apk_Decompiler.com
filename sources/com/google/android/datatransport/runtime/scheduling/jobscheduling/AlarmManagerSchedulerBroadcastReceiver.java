package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.util.PriorityMapping;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    /* access modifiers changed from: private */
    public static /* synthetic */ void b() {
    }

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i2 = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.f(context);
        TransportContext.Builder d2 = TransportContext.a().b(queryParameter).d(PriorityMapping.b(intValue));
        if (queryParameter2 != null) {
            d2.c(Base64.decode(queryParameter2, 0));
        }
        TransportRuntime.c().e().v(d2.a(), i2, new a());
    }
}

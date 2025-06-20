package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import java.util.concurrent.ExecutionException;

public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {

    /* renamed from: c  reason: collision with root package name */
    private static final String f24396c = "FirebaseMessaging";

    private static Intent f(@NonNull Context context, @NonNull String str, @NonNull Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public int b(@NonNull Context context, @NonNull CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.a(new FcmBroadcastProcessor(context).k(cloudMessage.N()))).intValue();
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e2);
            return 500;
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void c(@NonNull Context context, @NonNull Bundle bundle) {
        Intent f2 = f(context, CloudMessagingReceiver.IntentActionKeys.f19803b, bundle);
        if (MessagingAnalytics.E(f2)) {
            MessagingAnalytics.v(f2);
        }
    }
}

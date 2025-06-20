package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class zzg implements Runnable {
    public final /* synthetic */ CloudMessage X;
    public final /* synthetic */ CountDownLatch Y;
    public final /* synthetic */ Context s;

    public /* synthetic */ zzg(Context context, CloudMessage cloudMessage, CountDownLatch countDownLatch) {
        this.s = context;
        this.X = cloudMessage;
        this.Y = countDownLatch;
    }

    public final void run() {
        Task task;
        CloudMessage cloudMessage = this.X;
        if (TextUtils.isEmpty(cloudMessage.O())) {
            task = Tasks.g(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.MessagePayloadKeys.f24706h, cloudMessage.O());
            Integer c0 = cloudMessage.c0();
            if (c0 != null) {
                bundle.putInt(Constants.MessagePayloadKeys.o, c0.intValue());
            }
            Context context = this.s;
            bundle.putBoolean("supports_message_handled", true);
            task = zzv.b(context).c(2, bundle);
        }
        task.f(zze.s, new zzf(this.Y));
    }
}

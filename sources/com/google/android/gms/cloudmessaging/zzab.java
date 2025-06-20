package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzab implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ zzab f19821a = new zzab();

    private /* synthetic */ zzab() {
    }

    public final Object a(Task task) {
        Intent intent = (Intent) ((Bundle) task.r()).getParcelable("notification_data");
        if (intent != null) {
            return new CloudMessage(intent);
        }
        return null;
    }
}

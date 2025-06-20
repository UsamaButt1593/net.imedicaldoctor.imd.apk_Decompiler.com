package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import androidx.media3.exoplayer.dash.offline.a;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

class WithinAppServiceBinder extends Binder {

    /* renamed from: l  reason: collision with root package name */
    private final IntentHandler f24906l;

    interface IntentHandler {
        Task<Void> a(Intent intent);
    }

    WithinAppServiceBinder(IntentHandler intentHandler) {
        this.f24906l = intentHandler;
    }

    /* access modifiers changed from: package-private */
    public void c(WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable(Constants.f24670a, 3)) {
                Log.d(Constants.f24670a, "service received new intent via bind strategy");
            }
            this.f24906l.a(bindRequest.f24907a).f(new a(), new K(bindRequest));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}

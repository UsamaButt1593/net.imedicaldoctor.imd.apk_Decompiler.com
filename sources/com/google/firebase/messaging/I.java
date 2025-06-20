package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class I implements Callable {
    public final /* synthetic */ ScheduledExecutorService X;
    public final /* synthetic */ GmsRpc X2;
    public final /* synthetic */ FirebaseMessaging Y;
    public final /* synthetic */ Metadata Z;
    public final /* synthetic */ Context s;

    public /* synthetic */ I(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        this.s = context;
        this.X = scheduledExecutorService;
        this.Y = firebaseMessaging;
        this.Z = metadata;
        this.X2 = gmsRpc;
    }

    public final Object call() {
        return TopicsSubscriber.k(this.s, this.X, this.Y, this.Z, this.X2);
    }
}

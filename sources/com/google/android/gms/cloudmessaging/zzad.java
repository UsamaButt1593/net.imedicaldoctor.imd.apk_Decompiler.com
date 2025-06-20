package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class zzad implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Rpc f19822a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f19823b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f19824c;

    public /* synthetic */ zzad(Rpc rpc, String str, ScheduledFuture scheduledFuture) {
        this.f19822a = rpc;
        this.f19823b = str;
        this.f19824c = scheduledFuture;
    }

    public final void a(Task task) {
        this.f19822a.h(this.f19823b, this.f19824c, task);
    }
}

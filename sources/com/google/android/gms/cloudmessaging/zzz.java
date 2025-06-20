package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzz implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Rpc f19842a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f19843b;

    public /* synthetic */ zzz(Rpc rpc, Bundle bundle) {
        this.f19842a = rpc;
        this.f19843b = bundle;
    }

    public final Object a(Task task) {
        return this.f19842a.f(this.f19843b, task);
    }
}

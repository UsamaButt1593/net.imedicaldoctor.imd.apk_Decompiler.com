package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

final class zaf extends zag {
    final /* synthetic */ LifecycleFragment X;
    final /* synthetic */ Intent s;

    zaf(Intent intent, LifecycleFragment lifecycleFragment, int i2) {
        this.s = intent;
        this.X = lifecycleFragment;
    }

    public final void a() {
        Intent intent = this.s;
        if (intent != null) {
            this.X.startActivityForResult(intent, 2);
        }
    }
}

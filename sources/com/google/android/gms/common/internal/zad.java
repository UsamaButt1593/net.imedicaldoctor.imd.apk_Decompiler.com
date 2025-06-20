package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class zad extends zag {
    final /* synthetic */ Activity X;
    final /* synthetic */ int Y;
    final /* synthetic */ Intent s;

    zad(Intent intent, Activity activity, int i2) {
        this.s = intent;
        this.X = activity;
        this.Y = i2;
    }

    public final void a() {
        Intent intent = this.s;
        if (intent != null) {
            this.X.startActivityForResult(intent, this.Y);
        }
    }
}

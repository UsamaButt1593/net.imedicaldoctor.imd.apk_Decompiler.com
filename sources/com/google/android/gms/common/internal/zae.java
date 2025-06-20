package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

final class zae extends zag {
    final /* synthetic */ Fragment X;
    final /* synthetic */ int Y;
    final /* synthetic */ Intent s;

    zae(Intent intent, Fragment fragment, int i2) {
        this.s = intent;
        this.X = fragment;
        this.Y = i2;
    }

    public final void a() {
        Intent intent = this.s;
        if (intent != null) {
            this.X.startActivityForResult(intent, this.Y);
        }
    }
}

package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

final class zao implements Runnable {
    final /* synthetic */ zap X;
    private final zam s;

    zao(zap zap, zam zam) {
        this.X = zap;
        this.s = zam;
    }

    @MainThread
    public final void run() {
        if (this.X.X) {
            ConnectionResult b2 = this.s.b();
            if (b2.N()) {
                zap zap = this.X;
                zap.s.startActivityForResult(GoogleApiActivity.a(zap.b(), (PendingIntent) Preconditions.r(b2.I()), this.s.a(), false), 1);
                return;
            }
            zap zap2 = this.X;
            if (zap2.X2.e(zap2.b(), b2.C(), (String) null) != null) {
                zap zap3 = this.X;
                zap3.X2.K(zap3.b(), this.X.s, b2.C(), 2, this.X);
            } else if (b2.C() == 18) {
                zap zap4 = this.X;
                Dialog F = zap4.X2.F(zap4.b(), this.X);
                zap zap5 = this.X;
                zap5.X2.G(zap5.b().getApplicationContext(), new zan(this, F));
            } else {
                this.X.m(b2, this.s.a());
            }
        }
    }
}

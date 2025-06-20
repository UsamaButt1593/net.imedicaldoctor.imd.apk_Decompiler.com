package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.PendingIntent;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public final class zacc extends zap {
    private TaskCompletionSource<Void> Y2 = new TaskCompletionSource<>();

    private zacc(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment, GoogleApiAvailability.x());
        this.s.c("GmsAvailabilityHelper", this);
    }

    public static zacc u(@NonNull Activity activity) {
        LifecycleFragment c2 = LifecycleCallback.c(activity);
        zacc zacc = (zacc) c2.d("GmsAvailabilityHelper", zacc.class);
        if (zacc == null) {
            return new zacc(c2);
        }
        if (zacc.Y2.a().u()) {
            zacc.Y2 = new TaskCompletionSource<>();
        }
        return zacc;
    }

    public final void h() {
        super.h();
        this.Y2.d(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    /* access modifiers changed from: protected */
    public final void n(ConnectionResult connectionResult, int i2) {
        String H = connectionResult.H();
        if (H == null) {
            H = "Error connecting to Google Play services";
        }
        this.Y2.b(new ApiException(new Status(connectionResult, H, connectionResult.C())));
    }

    /* access modifiers changed from: protected */
    public final void o() {
        Activity f2 = this.s.f();
        if (f2 == null) {
            this.Y2.d(new ApiException(new Status(8)));
            return;
        }
        int j2 = this.X2.j(f2);
        if (j2 == 0) {
            this.Y2.e(null);
        } else if (!this.Y2.a().u()) {
            t(new ConnectionResult(j2, (PendingIntent) null), 0);
        }
    }

    public final Task<Void> v() {
        return this.Y2.a();
    }
}

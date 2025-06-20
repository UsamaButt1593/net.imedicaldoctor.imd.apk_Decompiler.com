package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zaae extends zap {
    private final ArraySet<ApiKey<?>> Y2 = new ArraySet<>();
    private final GoogleApiManager Z2;

    @VisibleForTesting
    zaae(LifecycleFragment lifecycleFragment, GoogleApiManager googleApiManager, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment, googleApiAvailability);
        this.Z2 = googleApiManager;
        this.s.c("ConnectionlessLifecycleHelper", this);
    }

    @MainThread
    public static void v(Activity activity, GoogleApiManager googleApiManager, ApiKey<?> apiKey) {
        LifecycleFragment c2 = LifecycleCallback.c(activity);
        zaae zaae = (zaae) c2.d("ConnectionlessLifecycleHelper", zaae.class);
        if (zaae == null) {
            zaae = new zaae(c2, googleApiManager, GoogleApiAvailability.x());
        }
        Preconditions.s(apiKey, "ApiKey cannot be null");
        zaae.Y2.add(apiKey);
        googleApiManager.d(zaae);
    }

    private final void w() {
        if (!this.Y2.isEmpty()) {
            this.Z2.d(this);
        }
    }

    public final void i() {
        super.i();
        w();
    }

    public final void k() {
        super.k();
        w();
    }

    public final void l() {
        super.l();
        this.Z2.e(this);
    }

    /* access modifiers changed from: protected */
    public final void n(ConnectionResult connectionResult, int i2) {
        this.Z2.M(connectionResult, i2);
    }

    /* access modifiers changed from: protected */
    public final void o() {
        this.Z2.b();
    }

    /* access modifiers changed from: package-private */
    public final ArraySet<ApiKey<?>> u() {
        return this.Y2;
    }
}

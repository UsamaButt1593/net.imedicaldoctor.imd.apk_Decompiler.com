package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.lifecycle.g;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zaq;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zap extends LifecycleCallback implements DialogInterface.OnCancelListener {
    protected volatile boolean X;
    protected final GoogleApiAvailability X2;
    protected final AtomicReference<zam> Y = new AtomicReference<>((Object) null);
    private final Handler Z = new zaq(Looper.getMainLooper());

    @VisibleForTesting
    zap(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.X2 = googleApiAvailability;
    }

    /* access modifiers changed from: private */
    public final void m(ConnectionResult connectionResult, int i2) {
        this.Y.set((Object) null);
        n(connectionResult, i2);
    }

    /* access modifiers changed from: private */
    public final void p() {
        this.Y.set((Object) null);
        o();
    }

    private static final int q(@Nullable zam zam) {
        if (zam == null) {
            return -1;
        }
        return zam.a();
    }

    public final void f(int i2, int i3, Intent intent) {
        zam zam = this.Y.get();
        if (i2 != 1) {
            if (i2 == 2) {
                int j2 = this.X2.j(b());
                if (j2 == 0) {
                    p();
                    return;
                } else if (zam != null) {
                    if (zam.b().C() == 18 && j2 == 18) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else if (i3 == -1) {
            p();
            return;
        } else if (i3 == 0) {
            if (zam != null) {
                int i4 = 13;
                if (intent != null) {
                    i4 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                }
                m(new ConnectionResult(i4, (PendingIntent) null, zam.b().toString()), q(zam));
                return;
            }
            return;
        }
        if (zam != null) {
            m(zam.b(), zam.a());
        }
    }

    public final void g(@Nullable Bundle bundle) {
        super.g(bundle);
        if (bundle != null) {
            this.Y.set(bundle.getBoolean("resolving_error", false) ? new zam(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    public final void j(Bundle bundle) {
        super.j(bundle);
        zam zam = this.Y.get();
        if (zam != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", zam.a());
            bundle.putInt("failed_status", zam.b().C());
            bundle.putParcelable("failed_resolution", zam.b().I());
        }
    }

    public void k() {
        super.k();
        this.X = true;
    }

    public void l() {
        super.l();
        this.X = false;
    }

    /* access modifiers changed from: protected */
    public abstract void n(ConnectionResult connectionResult, int i2);

    /* access modifiers changed from: protected */
    public abstract void o();

    public final void onCancel(DialogInterface dialogInterface) {
        m(new ConnectionResult(13, (PendingIntent) null), q(this.Y.get()));
    }

    public final void t(ConnectionResult connectionResult, int i2) {
        zam zam = new zam(connectionResult, i2);
        if (g.a(this.Y, (Object) null, zam)) {
            this.Z.post(new zao(this, zam));
        }
    }
}

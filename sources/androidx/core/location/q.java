package androidx.core.location;

import android.os.CancellationSignal;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class q implements CancellationSignal.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener f6033a;

    public /* synthetic */ q(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.f6033a = cancellableLocationListener;
    }

    public final void onCancel() {
        this.f6033a.c();
    }
}

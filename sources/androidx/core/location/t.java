package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ LocationManagerCompat.CancellableLocationListener s;

    public /* synthetic */ t(LocationManagerCompat.CancellableLocationListener cancellableLocationListener) {
        this.s = cancellableLocationListener;
    }

    public final void run() {
        this.s.f();
    }
}

package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class H implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport s;

    public /* synthetic */ H(LocationManagerCompat.LocationListenerTransport locationListenerTransport, int i2) {
        this.s = locationListenerTransport;
        this.X = i2;
    }

    public final void run() {
        this.s.h(this.X);
    }
}

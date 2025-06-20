package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class D implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport s;

    public /* synthetic */ D(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.s = locationListenerTransport;
        this.X = str;
    }

    public final void run() {
        this.s.l(this.X);
    }
}

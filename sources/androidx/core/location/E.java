package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class E implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport s;

    public /* synthetic */ E(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str) {
        this.s = locationListenerTransport;
        this.X = str;
    }

    public final void run() {
        this.s.k(this.X);
    }
}

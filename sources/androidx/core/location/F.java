package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.List;

public final /* synthetic */ class F implements Runnable {
    public final /* synthetic */ List X;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport s;

    public /* synthetic */ F(LocationManagerCompat.LocationListenerTransport locationListenerTransport, List list) {
        this.s = locationListenerTransport;
        this.X = list;
    }

    public final void run() {
        this.s.j(this.X);
    }
}

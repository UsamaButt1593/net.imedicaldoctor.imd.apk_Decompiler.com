package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class G implements Runnable {
    public final /* synthetic */ Location X;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport s;

    public /* synthetic */ G(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Location location) {
        this.s = locationListenerTransport;
        this.X = location;
    }

    public final void run() {
        this.s.i(this.X);
    }
}

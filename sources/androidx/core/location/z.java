package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class z implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport s;

    public /* synthetic */ z(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor) {
        this.s = gpsStatusTransport;
        this.X = executor;
    }

    public final void run() {
        this.s.e(this.X);
    }
}

package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class C implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ GnssStatusCompat Y;
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport s;

    public /* synthetic */ C(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, GnssStatusCompat gnssStatusCompat) {
        this.s = gpsStatusTransport;
        this.X = executor;
        this.Y = gnssStatusCompat;
    }

    public final void run() {
        this.s.h(this.X, this.Y);
    }
}

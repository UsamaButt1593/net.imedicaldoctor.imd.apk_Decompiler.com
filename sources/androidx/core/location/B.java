package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class B implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport s;

    public /* synthetic */ B(LocationManagerCompat.GpsStatusTransport gpsStatusTransport, Executor executor, int i2) {
        this.s = gpsStatusTransport;
        this.X = executor;
        this.Y = i2;
    }

    public final void run() {
        this.s.g(this.X, this.Y);
    }
}

package androidx.core.location;

import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class K implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ GnssStatus Y;
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport s;

    public /* synthetic */ K(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, GnssStatus gnssStatus) {
        this.s = preRGnssStatusTransport;
        this.X = executor;
        this.Y = gnssStatus;
    }

    public final void run() {
        this.s.f(this.X, this.Y);
    }
}

package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class M implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport s;

    public /* synthetic */ M(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.s = preRGnssStatusTransport;
        this.X = executor;
    }

    public final void run() {
        this.s.g(this.X);
    }
}

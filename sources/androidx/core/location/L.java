package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class L implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport s;

    public /* synthetic */ L(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor) {
        this.s = preRGnssStatusTransport;
        this.X = executor;
    }

    public final void run() {
        this.s.h(this.X);
    }
}

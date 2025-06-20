package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class J implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport s;

    public /* synthetic */ J(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i2) {
        this.s = preRGnssStatusTransport;
        this.X = executor;
        this.Y = i2;
    }

    public final void run() {
        this.s.e(this.X, this.Y);
    }
}

package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class y implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport s;

    public /* synthetic */ y(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, int i2) {
        this.s = gnssMeasurementsTransport;
        this.X = executor;
        this.Y = i2;
    }

    public final void run() {
        this.s.d(this.X, this.Y);
    }
}

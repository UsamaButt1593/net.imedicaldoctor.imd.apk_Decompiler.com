package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ Executor X;
    public final /* synthetic */ GnssMeasurementsEvent Y;
    public final /* synthetic */ LocationManagerCompat.GnssMeasurementsTransport s;

    public /* synthetic */ x(LocationManagerCompat.GnssMeasurementsTransport gnssMeasurementsTransport, Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
        this.s = gnssMeasurementsTransport;
        this.X = executor;
        this.Y = gnssMeasurementsEvent;
    }

    public final void run() {
        this.s.c(this.X, this.Y);
    }
}

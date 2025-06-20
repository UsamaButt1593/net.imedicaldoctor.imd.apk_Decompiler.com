package androidx.core.location;

import android.location.LocationManager;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Callable;

public final /* synthetic */ class r implements Callable {
    public final /* synthetic */ LocationManagerCompat.GpsStatusTransport X;
    public final /* synthetic */ LocationManager s;

    public /* synthetic */ r(LocationManager locationManager, LocationManagerCompat.GpsStatusTransport gpsStatusTransport) {
        this.s = locationManager;
        this.X = gpsStatusTransport;
    }

    public final Object call() {
        return Boolean.valueOf(this.s.addGpsStatusListener(this.X));
    }
}

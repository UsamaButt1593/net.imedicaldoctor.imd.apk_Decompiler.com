package androidx.core.location;

import android.os.Bundle;
import androidx.core.location.LocationManagerCompat;

public final /* synthetic */ class I implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ Bundle Z;
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport s;

    public /* synthetic */ I(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i2, Bundle bundle) {
        this.s = locationListenerTransport;
        this.X = str;
        this.Y = i2;
        this.Z = bundle;
    }

    public final void run() {
        this.s.m(this.X, this.Y, this.Z);
    }
}

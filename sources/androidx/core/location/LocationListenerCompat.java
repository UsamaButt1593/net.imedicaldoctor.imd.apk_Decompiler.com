package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public interface LocationListenerCompat extends LocationListener {
    void onFlushComplete(int i2);

    void onLocationChanged(@NonNull List<Location> list);

    void onProviderDisabled(@NonNull String str);

    void onProviderEnabled(@NonNull String str);

    void onStatusChanged(@NonNull String str, int i2, @Nullable Bundle bundle);
}

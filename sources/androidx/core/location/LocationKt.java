package androidx.core.location;

import android.location.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/location/Location;", "", "a", "(Landroid/location/Location;)D", "b", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class LocationKt {
    public static final double a(@NotNull Location location) {
        return location.getLatitude();
    }

    public static final double b(@NotNull Location location) {
        return location.getLongitude();
    }
}

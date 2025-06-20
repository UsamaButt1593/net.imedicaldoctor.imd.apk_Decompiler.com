package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import java.util.Calendar;
import org.apache.commons.lang3.time.DateUtils;

class TwilightManager {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2827d = "TwilightManager";

    /* renamed from: e  reason: collision with root package name */
    private static final int f2828e = 6;

    /* renamed from: f  reason: collision with root package name */
    private static final int f2829f = 22;

    /* renamed from: g  reason: collision with root package name */
    private static TwilightManager f2830g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2831a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f2832b;

    /* renamed from: c  reason: collision with root package name */
    private final TwilightState f2833c = new TwilightState();

    private static class TwilightState {

        /* renamed from: a  reason: collision with root package name */
        boolean f2834a;

        /* renamed from: b  reason: collision with root package name */
        long f2835b;

        TwilightState() {
        }
    }

    @VisibleForTesting
    TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.f2831a = context;
        this.f2832b = locationManager;
    }

    static TwilightManager a(@NonNull Context context) {
        if (f2830g == null) {
            Context applicationContext = context.getApplicationContext();
            f2830g = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f2830g;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location c2 = PermissionChecker.d(this.f2831a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        if (PermissionChecker.d(this.f2831a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = c("gps");
        }
        return (location == null || c2 == null) ? location != null ? location : c2 : location.getTime() > c2.getTime() ? location : c2;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location c(String str) {
        try {
            if (this.f2832b.isProviderEnabled(str)) {
                return this.f2832b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d(f2827d, "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.f2833c.f2835b > System.currentTimeMillis();
    }

    @VisibleForTesting
    static void f(TwilightManager twilightManager) {
        f2830g = twilightManager;
    }

    private void g(@NonNull Location location) {
        long j2;
        TwilightState twilightState = this.f2833c;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator b2 = TwilightCalculator.b();
        TwilightCalculator twilightCalculator = b2;
        twilightCalculator.a(currentTimeMillis - DateUtils.MILLIS_PER_DAY, location.getLatitude(), location.getLongitude());
        twilightCalculator.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = b2.f2826c == 1;
        long j3 = b2.f2825b;
        long j4 = b2.f2824a;
        long j5 = j3;
        b2.a(currentTimeMillis + DateUtils.MILLIS_PER_DAY, location.getLatitude(), location.getLongitude());
        long j6 = b2.f2825b;
        if (j5 == -1 || j4 == -1) {
            j2 = currentTimeMillis + 43200000;
        } else {
            if (currentTimeMillis <= j4) {
                j6 = currentTimeMillis > j5 ? j4 : j5;
            }
            j2 = j6 + 60000;
        }
        twilightState.f2834a = z;
        twilightState.f2835b = j2;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        TwilightState twilightState = this.f2833c;
        if (e()) {
            return twilightState.f2834a;
        }
        Location b2 = b();
        if (b2 != null) {
            g(b2);
            return twilightState.f2834a;
        }
        Log.i(f2827d, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}

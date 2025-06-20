package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public final class LocationCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5965a = "mockLocation";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5966b = "verticalAccuracy";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5967c = "speedAccuracy";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5968d = "bearingAccuracy";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5969e = "androidx.core.location.extra.MSL_ALTITUDE";

    /* renamed from: f  reason: collision with root package name */
    public static final String f5970f = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static Method f5971g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static Field f5972h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static Integer f5973i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static Integer f5974j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static Integer f5975k;

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float a(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        @DoNotInline
        static float b(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        @DoNotInline
        static float c(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        @DoNotInline
        static boolean d(Location location) {
            return location.hasBearingAccuracy();
        }

        @DoNotInline
        static boolean e(Location location) {
            return location.hasSpeedAccuracy();
        }

        @DoNotInline
        static boolean f(Location location) {
            return location.hasVerticalAccuracy();
        }

        @DoNotInline
        static void g(Location location) {
            try {
                LocationCompat.e().setByte(location, (byte) (LocationCompat.e().getByte(location) & (~LocationCompat.f())));
            } catch (NoSuchFieldException e2) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e2);
                throw noSuchFieldError;
            } catch (IllegalAccessException e3) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e3);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void h(Location location) {
            try {
                LocationCompat.e().setByte(location, (byte) (LocationCompat.e().getByte(location) & (~LocationCompat.g())));
            } catch (NoSuchFieldException e2) {
                NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                noSuchFieldError.initCause(e2);
                throw noSuchFieldError;
            } catch (IllegalAccessException e3) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e3);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void i(Location location) {
            try {
                LocationCompat.e().setByte(location, (byte) (LocationCompat.e().getByte(location) & (~LocationCompat.h())));
            } catch (IllegalAccessException | NoSuchFieldException e2) {
                IllegalAccessError illegalAccessError = new IllegalAccessError();
                illegalAccessError.initCause(e2);
                throw illegalAccessError;
            }
        }

        @DoNotInline
        static void j(Location location, float f2) {
            location.setBearingAccuracyDegrees(f2);
        }

        @DoNotInline
        static void k(Location location, float f2) {
            location.setSpeedAccuracyMetersPerSecond(f2);
        }

        @DoNotInline
        static void l(Location location, float f2) {
            location.setVerticalAccuracyMeters(f2);
        }
    }

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static void a(Location location) {
            Location location2 = location;
            if (location.hasBearingAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float f2 = bearing;
                float accuracy = location.getAccuracy();
                boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
                float f3 = accuracy;
                float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
                float f4 = verticalAccuracyMeters;
                float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                Bundle extras = location.getExtras();
                location.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (hasAltitude) {
                    location2.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location2.setSpeed(speed);
                }
                if (hasBearing) {
                    location2.setBearing(f2);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(f3);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f4);
                }
                if (hasSpeedAccuracy) {
                    location2.setBearingAccuracyDegrees(speedAccuracyMetersPerSecond);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        @DoNotInline
        static void b(Location location) {
            Location location2 = location;
            if (location.hasSpeedAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float f2 = bearing;
                float accuracy = location.getAccuracy();
                boolean hasVerticalAccuracy = location.hasVerticalAccuracy();
                float f3 = accuracy;
                float verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                boolean hasBearingAccuracy = location.hasBearingAccuracy();
                float f4 = verticalAccuracyMeters;
                float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                Bundle extras = location.getExtras();
                location.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (hasAltitude) {
                    location2.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location2.setSpeed(speed);
                }
                if (hasBearing) {
                    location2.setBearing(f2);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(f3);
                }
                if (hasVerticalAccuracy) {
                    location2.setVerticalAccuracyMeters(f4);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }

        @DoNotInline
        static void c(Location location) {
            Location location2 = location;
            if (location.hasVerticalAccuracy()) {
                String provider = location.getProvider();
                long time = location.getTime();
                long elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                boolean hasAltitude = location.hasAltitude();
                double altitude = location.getAltitude();
                boolean hasSpeed = location.hasSpeed();
                float speed = location.getSpeed();
                boolean hasBearing = location.hasBearing();
                float bearing = location.getBearing();
                boolean hasAccuracy = location.hasAccuracy();
                float f2 = bearing;
                float accuracy = location.getAccuracy();
                boolean hasSpeedAccuracy = location.hasSpeedAccuracy();
                float f3 = accuracy;
                float speedAccuracyMetersPerSecond = location.getSpeedAccuracyMetersPerSecond();
                boolean hasBearingAccuracy = location.hasBearingAccuracy();
                float f4 = speedAccuracyMetersPerSecond;
                float bearingAccuracyDegrees = location.getBearingAccuracyDegrees();
                Bundle extras = location.getExtras();
                location.reset();
                location2.setProvider(provider);
                location2.setTime(time);
                location2.setElapsedRealtimeNanos(elapsedRealtimeNanos);
                location2.setLatitude(latitude);
                location2.setLongitude(longitude);
                if (hasAltitude) {
                    location2.setAltitude(altitude);
                }
                if (hasSpeed) {
                    location2.setSpeed(speed);
                }
                if (hasBearing) {
                    location2.setBearing(f2);
                }
                if (hasAccuracy) {
                    location2.setAccuracy(f3);
                }
                if (hasSpeedAccuracy) {
                    location2.setSpeedAccuracyMetersPerSecond(f4);
                }
                if (hasBearingAccuracy) {
                    location2.setBearingAccuracyDegrees(bearingAccuracyDegrees);
                }
                if (extras != null) {
                    location2.setExtras(extras);
                }
            }
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(Location location) {
            if (location.hasBearingAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.a(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        @DoNotInline
        static void b(Location location) {
            if (location.hasSpeedAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.b(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }

        @DoNotInline
        static void c(Location location) {
            if (location.hasVerticalAccuracy()) {
                double elapsedRealtimeUncertaintyNanos = location.getElapsedRealtimeUncertaintyNanos();
                Api28Impl.c(location);
                location.setElapsedRealtimeUncertaintyNanos(elapsedRealtimeUncertaintyNanos);
            }
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static void a(Location location) {
            location.removeBearingAccuracy();
        }

        @DoNotInline
        static void b(Location location) {
            location.removeSpeedAccuracy();
        }

        @DoNotInline
        static void c(Location location) {
            location.removeVerticalAccuracy();
        }
    }

    @RequiresApi(34)
    private static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        static float a(Location location) {
            return location.getMslAltitudeAccuracyMeters();
        }

        @DoNotInline
        static double b(Location location) {
            return location.getMslAltitudeMeters();
        }

        @DoNotInline
        static boolean c(Location location) {
            return location.hasMslAltitude();
        }

        @DoNotInline
        static boolean d(Location location) {
            return location.hasMslAltitudeAccuracy();
        }

        @DoNotInline
        static void e(Location location) {
            location.removeMslAltitude();
        }

        @DoNotInline
        static void f(Location location) {
            location.removeMslAltitudeAccuracy();
        }

        @DoNotInline
        static void g(Location location, float f2) {
            location.setMslAltitudeAccuracyMeters(f2);
        }

        @DoNotInline
        static void h(Location location, double d2) {
            location.setMslAltitudeMeters(d2);
        }
    }

    private LocationCompat() {
    }

    public static void A(@NonNull Location location, float f2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.j(location, f2);
        } else {
            k(location).putFloat(f5968d, f2);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void B(@NonNull Location location, boolean z) {
        try {
            l().invoke(location, new Object[]{Boolean.valueOf(z)});
        } catch (NoSuchMethodException e2) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e2);
            throw noSuchMethodError;
        } catch (IllegalAccessException e3) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e3);
            throw illegalAccessError;
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static void C(@NonNull Location location, @FloatRange(from = 0.0d) float f2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.g(location, f2);
        } else {
            k(location).putFloat(f5970f, f2);
        }
    }

    public static void D(@NonNull Location location, double d2) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.h(location, d2);
        } else {
            k(location).putDouble(f5969e, d2);
        }
    }

    public static void E(@NonNull Location location, float f2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.k(location, f2);
        } else {
            k(location).putFloat(f5967c, f2);
        }
    }

    public static void F(@NonNull Location location, float f2) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.l(location, f2);
        } else {
            k(location).putFloat(f5966b, f2);
        }
    }

    private static boolean a(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        return extras != null && extras.containsKey(str);
    }

    public static float b(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(f5968d, 0.0f);
    }

    public static long c(@NonNull Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    public static long d(@NonNull Location location) {
        return location.getElapsedRealtimeNanos();
    }

    @SuppressLint({"BlockedPrivateApi"})
    static Field e() throws NoSuchFieldException {
        if (f5972h == null) {
            Field declaredField = Location.class.getDeclaredField("mFieldsMask");
            f5972h = declaredField;
            declaredField.setAccessible(true);
        }
        return f5972h;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int f() throws NoSuchFieldException, IllegalAccessException {
        if (f5974j == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_BEARING_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f5974j = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return f5974j.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int g() throws NoSuchFieldException, IllegalAccessException {
        if (f5973i == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_SPEED_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f5973i = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return f5973i.intValue();
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static int h() throws NoSuchFieldException, IllegalAccessException {
        if (f5975k == null) {
            Field declaredField = Location.class.getDeclaredField("HAS_VERTICAL_ACCURACY_MASK");
            declaredField.setAccessible(true);
            f5975k = Integer.valueOf(declaredField.getInt((Object) null));
        }
        return f5975k.intValue();
    }

    @FloatRange(from = 0.0d)
    public static float i(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.a(location) : k(location).getFloat(f5970f);
    }

    public static double j(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.b(location) : k(location).getDouble(f5969e);
    }

    private static Bundle k(@NonNull Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras;
        }
        location.setExtras(new Bundle());
        return location.getExtras();
    }

    private static Method l() throws NoSuchMethodException {
        if (f5971g == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", new Class[]{Boolean.TYPE});
            f5971g = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f5971g;
    }

    public static float m(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(f5967c, 0.0f);
    }

    public static float n(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.c(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(f5966b, 0.0f);
    }

    public static boolean o(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.d(location) : a(location, f5968d);
    }

    public static boolean p(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.c(location) : a(location, f5969e);
    }

    public static boolean q(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 34 ? Api34Impl.d(location) : a(location, f5970f);
    }

    public static boolean r(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.e(location) : a(location, f5967c);
    }

    public static boolean s(@NonNull Location location) {
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.f(location) : a(location, f5966b);
    }

    public static boolean t(@NonNull Location location) {
        return location.isFromMockProvider();
    }

    public static void u(@NonNull Location location) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            Api33Impl.a(location);
        } else if (i2 >= 29) {
            Api29Impl.a(location);
        } else if (i2 >= 28) {
            Api28Impl.a(location);
        } else if (i2 >= 26) {
            Api26Impl.g(location);
        } else {
            v(location, f5968d);
        }
    }

    private static void v(@NonNull Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(str);
            if (extras.isEmpty()) {
                location.setExtras((Bundle) null);
            }
        }
    }

    public static void w(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.e(location);
        } else {
            v(location, f5969e);
        }
    }

    public static void x(@NonNull Location location) {
        if (Build.VERSION.SDK_INT >= 34) {
            Api34Impl.f(location);
        } else {
            v(location, f5970f);
        }
    }

    public static void y(@NonNull Location location) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            Api33Impl.b(location);
        } else if (i2 >= 29) {
            Api29Impl.b(location);
        } else if (i2 >= 28) {
            Api28Impl.b(location);
        } else if (i2 >= 26) {
            Api26Impl.h(location);
        } else {
            v(location, f5967c);
        }
    }

    public static void z(@NonNull Location location) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            Api33Impl.c(location);
        } else if (i2 >= 29) {
            Api29Impl.c(location);
        } else if (i2 >= 28) {
            Api28Impl.c(location);
        } else if (i2 >= 26) {
            Api26Impl.i(location);
        } else {
            v(location, f5966b);
        }
    }
}

package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssStatus;
import android.location.GpsStatus;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class GnssStatusCompat {
    @SuppressLint({"InlinedApi"})

    /* renamed from: a  reason: collision with root package name */
    public static final int f5950a = 0;
    @SuppressLint({"InlinedApi"})

    /* renamed from: b  reason: collision with root package name */
    public static final int f5951b = 1;
    @SuppressLint({"InlinedApi"})

    /* renamed from: c  reason: collision with root package name */
    public static final int f5952c = 2;
    @SuppressLint({"InlinedApi"})

    /* renamed from: d  reason: collision with root package name */
    public static final int f5953d = 3;
    @SuppressLint({"InlinedApi"})

    /* renamed from: e  reason: collision with root package name */
    public static final int f5954e = 4;
    @SuppressLint({"InlinedApi"})

    /* renamed from: f  reason: collision with root package name */
    public static final int f5955f = 5;
    @SuppressLint({"InlinedApi"})

    /* renamed from: g  reason: collision with root package name */
    public static final int f5956g = 6;
    @SuppressLint({"InlinedApi"})

    /* renamed from: h  reason: collision with root package name */
    public static final int f5957h = 7;

    public static abstract class Callback {
        public void a(@IntRange(from = 0) int i2) {
        }

        public void b(@NonNull GnssStatusCompat gnssStatusCompat) {
        }

        public void c() {
        }

        public void d() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConstellationType {
    }

    GnssStatusCompat() {
    }

    @RequiresApi(24)
    @NonNull
    public static GnssStatusCompat n(@NonNull GnssStatus gnssStatus) {
        return new GnssStatusWrapper(gnssStatus);
    }

    @SuppressLint({"ReferencesDeprecated"})
    @NonNull
    public static GnssStatusCompat o(@NonNull GpsStatus gpsStatus) {
        return new GpsStatusWrapper(gpsStatus);
    }

    @FloatRange(from = 0.0d, to = 360.0d)
    public abstract float a(@IntRange(from = 0) int i2);

    @FloatRange(from = 0.0d, to = 63.0d)
    public abstract float b(@IntRange(from = 0) int i2);

    @FloatRange(from = 0.0d)
    public abstract float c(@IntRange(from = 0) int i2);

    @FloatRange(from = 0.0d, to = 63.0d)
    public abstract float d(@IntRange(from = 0) int i2);

    public abstract int e(@IntRange(from = 0) int i2);

    @FloatRange(from = -90.0d, to = 90.0d)
    public abstract float f(@IntRange(from = 0) int i2);

    @IntRange(from = 0)
    public abstract int g();

    @IntRange(from = 1, to = 200)
    public abstract int h(@IntRange(from = 0) int i2);

    public abstract boolean i(@IntRange(from = 0) int i2);

    public abstract boolean j(@IntRange(from = 0) int i2);

    public abstract boolean k(@IntRange(from = 0) int i2);

    public abstract boolean l(@IntRange(from = 0) int i2);

    public abstract boolean m(@IntRange(from = 0) int i2);
}

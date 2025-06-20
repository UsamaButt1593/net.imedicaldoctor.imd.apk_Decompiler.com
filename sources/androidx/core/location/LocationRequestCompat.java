package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.LocationRequest;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class LocationRequestCompat {

    /* renamed from: h  reason: collision with root package name */
    public static final long f6008h = Long.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public static final int f6009i = 100;

    /* renamed from: j  reason: collision with root package name */
    public static final int f6010j = 102;

    /* renamed from: k  reason: collision with root package name */
    public static final int f6011k = 104;

    /* renamed from: l  reason: collision with root package name */
    private static final long f6012l = -1;

    /* renamed from: a  reason: collision with root package name */
    final int f6013a;

    /* renamed from: b  reason: collision with root package name */
    final long f6014b;

    /* renamed from: c  reason: collision with root package name */
    final long f6015c;

    /* renamed from: d  reason: collision with root package name */
    final long f6016d;

    /* renamed from: e  reason: collision with root package name */
    final int f6017e;

    /* renamed from: f  reason: collision with root package name */
    final float f6018f;

    /* renamed from: g  reason: collision with root package name */
    final long f6019g;

    private static class Api19Impl {

        /* renamed from: a  reason: collision with root package name */
        private static Class<?> f6020a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f6021b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f6022c;

        /* renamed from: d  reason: collision with root package name */
        private static Method f6023d;

        /* renamed from: e  reason: collision with root package name */
        private static Method f6024e;

        /* renamed from: f  reason: collision with root package name */
        private static Method f6025f;

        private Api19Impl() {
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static Object a(LocationRequestCompat locationRequestCompat, String str) {
            try {
                if (f6020a == null) {
                    f6020a = Class.forName("android.location.LocationRequest");
                }
                if (f6021b == null) {
                    Method declaredMethod = f6020a.getDeclaredMethod("createFromDeprecatedProvider", new Class[]{String.class, Long.TYPE, Float.TYPE, Boolean.TYPE});
                    f6021b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                Object invoke = f6021b.invoke((Object) null, new Object[]{str, Long.valueOf(locationRequestCompat.b()), Float.valueOf(locationRequestCompat.e()), Boolean.FALSE});
                if (invoke == null) {
                    return null;
                }
                if (f6022c == null) {
                    Method declaredMethod2 = f6020a.getDeclaredMethod("setQuality", new Class[]{Integer.TYPE});
                    f6022c = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                f6022c.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.g())});
                if (f6023d == null) {
                    Method declaredMethod3 = f6020a.getDeclaredMethod("setFastestInterval", new Class[]{Long.TYPE});
                    f6023d = declaredMethod3;
                    declaredMethod3.setAccessible(true);
                }
                f6023d.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.f())});
                if (locationRequestCompat.d() < Integer.MAX_VALUE) {
                    if (f6024e == null) {
                        Method declaredMethod4 = f6020a.getDeclaredMethod("setNumUpdates", new Class[]{Integer.TYPE});
                        f6024e = declaredMethod4;
                        declaredMethod4.setAccessible(true);
                    }
                    f6024e.invoke(invoke, new Object[]{Integer.valueOf(locationRequestCompat.d())});
                }
                if (locationRequestCompat.a() < Long.MAX_VALUE) {
                    if (f6025f == null) {
                        Method declaredMethod5 = f6020a.getDeclaredMethod("setExpireIn", new Class[]{Long.TYPE});
                        f6025f = declaredMethod5;
                        declaredMethod5.setAccessible(true);
                    }
                    f6025f.invoke(invoke, new Object[]{Long.valueOf(locationRequestCompat.a())});
                }
                return invoke;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        public static LocationRequest a(LocationRequestCompat locationRequestCompat) {
            return new LocationRequest.Builder(locationRequestCompat.b()).setQuality(locationRequestCompat.g()).setMinUpdateIntervalMillis(locationRequestCompat.f()).setDurationMillis(locationRequestCompat.a()).setMaxUpdates(locationRequestCompat.d()).setMinUpdateDistanceMeters(locationRequestCompat.e()).setMaxUpdateDelayMillis(locationRequestCompat.c()).build();
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f6026a;

        /* renamed from: b  reason: collision with root package name */
        private int f6027b;

        /* renamed from: c  reason: collision with root package name */
        private long f6028c;

        /* renamed from: d  reason: collision with root package name */
        private int f6029d;

        /* renamed from: e  reason: collision with root package name */
        private long f6030e;

        /* renamed from: f  reason: collision with root package name */
        private float f6031f;

        /* renamed from: g  reason: collision with root package name */
        private long f6032g;

        public Builder(long j2) {
            d(j2);
            this.f6027b = 102;
            this.f6028c = Long.MAX_VALUE;
            this.f6029d = Integer.MAX_VALUE;
            this.f6030e = -1;
            this.f6031f = 0.0f;
            this.f6032g = 0;
        }

        @NonNull
        public LocationRequestCompat a() {
            Preconditions.o((this.f6026a == Long.MAX_VALUE && this.f6030e == -1) ? false : true, "passive location requests must have an explicit minimum update interval");
            long j2 = this.f6026a;
            return new LocationRequestCompat(j2, this.f6027b, this.f6028c, this.f6029d, Math.min(this.f6030e, j2), this.f6031f, this.f6032g);
        }

        @NonNull
        public Builder b() {
            this.f6030e = -1;
            return this;
        }

        @NonNull
        public Builder c(@IntRange(from = 1) long j2) {
            this.f6028c = Preconditions.h(j2, 1, Long.MAX_VALUE, "durationMillis");
            return this;
        }

        @NonNull
        public Builder d(@IntRange(from = 0) long j2) {
            this.f6026a = Preconditions.h(j2, 0, Long.MAX_VALUE, "intervalMillis");
            return this;
        }

        @NonNull
        public Builder e(@IntRange(from = 0) long j2) {
            this.f6032g = j2;
            this.f6032g = Preconditions.h(j2, 0, Long.MAX_VALUE, "maxUpdateDelayMillis");
            return this;
        }

        @NonNull
        public Builder f(@IntRange(from = 1, to = 2147483647L) int i2) {
            this.f6029d = Preconditions.g(i2, 1, Integer.MAX_VALUE, "maxUpdates");
            return this;
        }

        @NonNull
        public Builder g(@FloatRange(from = 0.0d, to = 3.4028234663852886E38d) float f2) {
            this.f6031f = f2;
            this.f6031f = Preconditions.f(f2, 0.0f, Float.MAX_VALUE, "minUpdateDistanceMeters");
            return this;
        }

        @NonNull
        public Builder h(@IntRange(from = 0) long j2) {
            this.f6030e = Preconditions.h(j2, 0, Long.MAX_VALUE, "minUpdateIntervalMillis");
            return this;
        }

        @NonNull
        public Builder i(int i2) {
            Preconditions.c(i2 == 104 || i2 == 102 || i2 == 100, "quality must be a defined QUALITY constant, not %d", Integer.valueOf(i2));
            this.f6027b = i2;
            return this;
        }

        public Builder(@NonNull LocationRequestCompat locationRequestCompat) {
            this.f6026a = locationRequestCompat.f6014b;
            this.f6027b = locationRequestCompat.f6013a;
            this.f6028c = locationRequestCompat.f6016d;
            this.f6029d = locationRequestCompat.f6017e;
            this.f6030e = locationRequestCompat.f6015c;
            this.f6031f = locationRequestCompat.f6018f;
            this.f6032g = locationRequestCompat.f6019g;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Quality {
    }

    LocationRequestCompat(long j2, int i2, long j3, int i3, long j4, float f2, long j5) {
        this.f6014b = j2;
        this.f6013a = i2;
        this.f6015c = j4;
        this.f6016d = j3;
        this.f6017e = i3;
        this.f6018f = f2;
        this.f6019g = j5;
    }

    @IntRange(from = 1)
    public long a() {
        return this.f6016d;
    }

    @IntRange(from = 0)
    public long b() {
        return this.f6014b;
    }

    @IntRange(from = 0)
    public long c() {
        return this.f6019g;
    }

    @IntRange(from = 1, to = 2147483647L)
    public int d() {
        return this.f6017e;
    }

    @FloatRange(from = 0.0d, to = 3.4028234663852886E38d)
    public float e() {
        return this.f6018f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequestCompat)) {
            return false;
        }
        LocationRequestCompat locationRequestCompat = (LocationRequestCompat) obj;
        return this.f6013a == locationRequestCompat.f6013a && this.f6014b == locationRequestCompat.f6014b && this.f6015c == locationRequestCompat.f6015c && this.f6016d == locationRequestCompat.f6016d && this.f6017e == locationRequestCompat.f6017e && Float.compare(locationRequestCompat.f6018f, this.f6018f) == 0 && this.f6019g == locationRequestCompat.f6019g;
    }

    @IntRange(from = 0)
    public long f() {
        long j2 = this.f6015c;
        return j2 == -1 ? this.f6014b : j2;
    }

    public int g() {
        return this.f6013a;
    }

    @RequiresApi(31)
    @NonNull
    public LocationRequest h() {
        return Api31Impl.a(this);
    }

    public int hashCode() {
        long j2 = this.f6014b;
        long j3 = this.f6015c;
        return (((this.f6013a * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
    }

    @SuppressLint({"NewApi"})
    @Nullable
    public LocationRequest i(@NonNull String str) {
        return Build.VERSION.SDK_INT >= 31 ? h() : N.a(Api19Impl.a(this, str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Request["
            r0.append(r1)
            long r1 = r6.f6014b
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0037
            java.lang.String r1 = "@"
            r0.append(r1)
            long r1 = r6.f6014b
            androidx.core.util.TimeUtils.e(r1, r0)
            int r1 = r6.f6013a
            r2 = 100
            if (r1 == r2) goto L_0x0034
            r2 = 102(0x66, float:1.43E-43)
            if (r1 == r2) goto L_0x0031
            r2 = 104(0x68, float:1.46E-43)
            if (r1 == r2) goto L_0x002e
            goto L_0x003c
        L_0x002e:
            java.lang.String r1 = " LOW_POWER"
            goto L_0x0039
        L_0x0031:
            java.lang.String r1 = " BALANCED"
            goto L_0x0039
        L_0x0034:
            java.lang.String r1 = " HIGH_ACCURACY"
            goto L_0x0039
        L_0x0037:
            java.lang.String r1 = "PASSIVE"
        L_0x0039:
            r0.append(r1)
        L_0x003c:
            long r1 = r6.f6016d
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x004c
            java.lang.String r1 = ", duration="
            r0.append(r1)
            long r1 = r6.f6016d
            androidx.core.util.TimeUtils.e(r1, r0)
        L_0x004c:
            int r1 = r6.f6017e
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r2) goto L_0x005d
            java.lang.String r1 = ", maxUpdates="
            r0.append(r1)
            int r1 = r6.f6017e
            r0.append(r1)
        L_0x005d:
            long r1 = r6.f6015c
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0075
            long r3 = r6.f6014b
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0075
            java.lang.String r1 = ", minUpdateInterval="
            r0.append(r1)
            long r1 = r6.f6015c
            androidx.core.util.TimeUtils.e(r1, r0)
        L_0x0075:
            float r1 = r6.f6018f
            double r1 = (double) r1
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0088
            java.lang.String r1 = ", minUpdateDistance="
            r0.append(r1)
            float r1 = r6.f6018f
            r0.append(r1)
        L_0x0088:
            long r1 = r6.f6019g
            r3 = 2
            long r1 = r1 / r3
            long r3 = r6.f6014b
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x009d
            java.lang.String r1 = ", maxUpdateDelay="
            r0.append(r1)
            long r1 = r6.f6019g
            androidx.core.util.TimeUtils.e(r1, r0)
        L_0x009d:
            r1 = 93
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.LocationRequestCompat.toString():java.lang.String");
    }
}

package androidx.core.location;

import android.annotation.SuppressLint;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class LocationManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final long f5976a = 30000;

    /* renamed from: b  reason: collision with root package name */
    private static final long f5977b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private static final long f5978c = 5;

    /* renamed from: d  reason: collision with root package name */
    private static Field f5979d;

    /* renamed from: e  reason: collision with root package name */
    private static Class<?> f5980e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f5981f;

    /* renamed from: g  reason: collision with root package name */
    private static Method f5982g;
    @GuardedBy("sLocationListeners")

    /* renamed from: h  reason: collision with root package name */
    static final WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> f5983h = new WeakHashMap<>();

    static class Api19Impl {

        /* renamed from: a  reason: collision with root package name */
        private static Class<?> f5984a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f5985b;

        private Api19Impl() {
        }

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        static boolean a(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerCompat locationListenerCompat, Looper looper) {
            try {
                if (f5984a == null) {
                    f5984a = Class.forName("android.location.LocationRequest");
                }
                if (f5985b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f5984a, LocationListener.class, Looper.class});
                    f5985b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest i2 = locationRequestCompat.i(str);
                if (i2 != null) {
                    f5985b.invoke(locationManager, new Object[]{i2, locationListenerCompat, looper});
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        static boolean b(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, LocationListenerTransport locationListenerTransport) {
            try {
                if (f5984a == null) {
                    f5984a = Class.forName("android.location.LocationRequest");
                }
                if (f5985b == null) {
                    Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f5984a, LocationListener.class, Looper.class});
                    f5985b = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                LocationRequest i2 = locationRequestCompat.i(str);
                if (i2 != null) {
                    synchronized (LocationManagerCompat.f5983h) {
                        f5985b.invoke(locationManager, new Object[]{i2, locationListenerTransport, Looper.getMainLooper()});
                        LocationManagerCompat.q(locationManager, locationListenerTransport);
                    }
                    return true;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
            }
            return false;
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean a(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback) {
            return locationManager.registerGnssMeasurementsCallback(callback);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean b(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback, @NonNull Handler handler) {
            return locationManager.registerGnssMeasurementsCallback(callback, handler);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static boolean c(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            Preconditions.a(handler != null);
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.f5994a;
            synchronized (simpleArrayMap) {
                try {
                    PreRGnssStatusTransport preRGnssStatusTransport = (PreRGnssStatusTransport) simpleArrayMap.get(callback);
                    if (preRGnssStatusTransport == null) {
                        preRGnssStatusTransport = new PreRGnssStatusTransport(callback);
                    } else {
                        preRGnssStatusTransport.j();
                    }
                    preRGnssStatusTransport.i(executor);
                    if (!locationManager.registerGnssStatusCallback(preRGnssStatusTransport, handler)) {
                        return false;
                    }
                    simpleArrayMap.put(callback, preRGnssStatusTransport);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @DoNotInline
        static void d(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback) {
            locationManager.unregisterGnssMeasurementsCallback(callback);
        }

        @DoNotInline
        static void e(LocationManager locationManager, Object obj) {
            if (obj instanceof PreRGnssStatusTransport) {
                ((PreRGnssStatusTransport) obj).j();
            }
            locationManager.unregisterGnssStatusCallback((GnssStatus.Callback) obj);
        }
    }

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static String a(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        @DoNotInline
        static int b(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        @DoNotInline
        static boolean c(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {

        /* renamed from: a  reason: collision with root package name */
        private static Class<?> f5986a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f5987b;

        private Api30Impl() {
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void a(LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
            Objects.requireNonNull(consumer);
            locationManager.getCurrentLocation(str, cancellationSignal, executor, new s(consumer));
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        public static boolean b(LocationManager locationManager, Handler handler, Executor executor, GnssStatusCompat.Callback callback) {
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.f5994a;
            synchronized (simpleArrayMap) {
                try {
                    GnssStatusTransport gnssStatusTransport = (GnssStatusTransport) simpleArrayMap.get(callback);
                    if (gnssStatusTransport == null) {
                        gnssStatusTransport = new GnssStatusTransport(callback);
                    }
                    if (!locationManager.registerGnssStatusCallback(executor, gnssStatusTransport)) {
                        return false;
                    }
                    simpleArrayMap.put(callback, gnssStatusTransport);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @DoNotInline
        public static boolean c(LocationManager locationManager, String str, LocationRequestCompat locationRequestCompat, Executor executor, LocationListenerCompat locationListenerCompat) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    if (f5986a == null) {
                        f5986a = Class.forName("android.location.LocationRequest");
                    }
                    if (f5987b == null) {
                        Method declaredMethod = LocationManager.class.getDeclaredMethod("requestLocationUpdates", new Class[]{f5986a, Executor.class, LocationListener.class});
                        f5987b = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    LocationRequest i2 = locationRequestCompat.i(str);
                    if (i2 != null) {
                        f5987b.invoke(locationManager, new Object[]{i2, executor, locationListenerCompat});
                        return true;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | UnsupportedOperationException | InvocationTargetException unused) {
                }
            }
            return false;
        }
    }

    @RequiresApi(31)
    private static class Api31Impl {
        private Api31Impl() {
        }

        @DoNotInline
        static boolean a(LocationManager locationManager, @NonNull String str) {
            return locationManager.hasProvider(str);
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        @DoNotInline
        static boolean b(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent.Callback callback) {
            return locationManager.registerGnssMeasurementsCallback(executor, callback);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        @DoNotInline
        static void c(LocationManager locationManager, @NonNull String str, @NonNull LocationRequest locationRequest, @NonNull Executor executor, @NonNull LocationListener locationListener) {
            locationManager.requestLocationUpdates(str, locationRequest, executor, locationListener);
        }
    }

    private static final class CancellableLocationListener implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        private final LocationManager f5988a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f5989b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f5990c = new Handler(Looper.getMainLooper());

        /* renamed from: d  reason: collision with root package name */
        private Consumer<Location> f5991d;
        @GuardedBy("this")

        /* renamed from: e  reason: collision with root package name */
        private boolean f5992e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        Runnable f5993f;

        CancellableLocationListener(LocationManager locationManager, Executor executor, Consumer<Location> consumer) {
            this.f5988a = locationManager;
            this.f5989b = executor;
            this.f5991d = consumer;
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        private void d() {
            this.f5991d = null;
            this.f5988a.removeUpdates(this);
            Runnable runnable = this.f5993f;
            if (runnable != null) {
                this.f5990c.removeCallbacks(runnable);
                this.f5993f = null;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f() {
            this.f5993f = null;
            onLocationChanged((Location) null);
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void c() {
            synchronized (this) {
                try {
                    if (!this.f5992e) {
                        this.f5992e = true;
                        d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        @SuppressLint({"MissingPermission"})
        public void g(long j2) {
            synchronized (this) {
                try {
                    if (!this.f5992e) {
                        t tVar = new t(this);
                        this.f5993f = tVar;
                        this.f5990c.postDelayed(tVar, j2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onLocationChanged(@Nullable Location location) {
            synchronized (this) {
                try {
                    if (!this.f5992e) {
                        this.f5992e = true;
                        this.f5989b.execute(new u(this.f5991d, location));
                        d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
        public void onProviderDisabled(@NonNull String str) {
            onLocationChanged((Location) null);
        }

        public void onProviderEnabled(@NonNull String str) {
        }

        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    private static class GnssListenersHolder {
        @GuardedBy("sGnssStatusListeners")

        /* renamed from: a  reason: collision with root package name */
        static final SimpleArrayMap<Object, Object> f5994a = new SimpleArrayMap<>();
        @GuardedBy("sGnssMeasurementListeners")

        /* renamed from: b  reason: collision with root package name */
        static final SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> f5995b = new SimpleArrayMap<>();

        private GnssListenersHolder() {
        }
    }

    @RequiresApi(24)
    private static class GnssMeasurementsTransport extends GnssMeasurementsEvent.Callback {

        /* renamed from: a  reason: collision with root package name */
        final GnssMeasurementsEvent.Callback f5996a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        volatile Executor f5997b;

        GnssMeasurementsTransport(@NonNull GnssMeasurementsEvent.Callback callback, @NonNull Executor executor) {
            this.f5996a = callback;
            this.f5997b = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(Executor executor, GnssMeasurementsEvent gnssMeasurementsEvent) {
            if (this.f5997b == executor) {
                this.f5996a.onGnssMeasurementsReceived(gnssMeasurementsEvent);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(Executor executor, int i2) {
            if (this.f5997b == executor) {
                this.f5996a.onStatusChanged(i2);
            }
        }

        public void e() {
            this.f5997b = null;
        }

        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
            Executor executor = this.f5997b;
            if (executor != null) {
                executor.execute(new x(this, executor, gnssMeasurementsEvent));
            }
        }

        public void onStatusChanged(int i2) {
            Executor executor = this.f5997b;
            if (executor != null) {
                executor.execute(new y(this, executor, i2));
            }
        }
    }

    @RequiresApi(30)
    private static class GnssStatusTransport extends GnssStatus.Callback {

        /* renamed from: a  reason: collision with root package name */
        final GnssStatusCompat.Callback f5998a;

        GnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.b(callback != null, "invalid null callback");
            this.f5998a = callback;
        }

        public void onFirstFix(int i2) {
            this.f5998a.a(i2);
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.f5998a.b(GnssStatusCompat.n(gnssStatus));
        }

        public void onStarted() {
            this.f5998a.c();
        }

        public void onStopped() {
            this.f5998a.d();
        }
    }

    private static class GpsStatusTransport implements GpsStatus.Listener {

        /* renamed from: a  reason: collision with root package name */
        private final LocationManager f5999a;

        /* renamed from: b  reason: collision with root package name */
        final GnssStatusCompat.Callback f6000b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        volatile Executor f6001c;

        GpsStatusTransport(LocationManager locationManager, GnssStatusCompat.Callback callback) {
            Preconditions.b(callback != null, "invalid null callback");
            this.f5999a = locationManager;
            this.f6000b = callback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(Executor executor) {
            if (this.f6001c == executor) {
                this.f6000b.c();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Executor executor) {
            if (this.f6001c == executor) {
                this.f6000b.d();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(Executor executor, int i2) {
            if (this.f6001c == executor) {
                this.f6000b.a(i2);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (this.f6001c == executor) {
                this.f6000b.b(gnssStatusCompat);
            }
        }

        public void i(Executor executor) {
            Preconditions.n(this.f6001c == null);
            this.f6001c = executor;
        }

        public void j() {
            this.f6001c = null;
        }

        @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
        public void onGpsStatusChanged(int i2) {
            Runnable zVar;
            Runnable b2;
            GpsStatus gpsStatus;
            Executor executor = this.f6001c;
            if (executor != null) {
                if (i2 == 1) {
                    zVar = new z(this, executor);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        GpsStatus gpsStatus2 = this.f5999a.getGpsStatus((GpsStatus) null);
                        if (gpsStatus2 != null) {
                            b2 = new B(this, executor, gpsStatus2.getTimeToFirstFix());
                        } else {
                            return;
                        }
                    } else if (i2 == 4 && (gpsStatus = this.f5999a.getGpsStatus((GpsStatus) null)) != null) {
                        b2 = new C(this, executor, GnssStatusCompat.o(gpsStatus));
                    } else {
                        return;
                    }
                    executor.execute(b2);
                    return;
                } else {
                    zVar = new A(this, executor);
                }
                executor.execute(zVar);
            }
        }
    }

    private static final class InlineHandlerExecutor implements Executor {
        private final Handler s;

        InlineHandlerExecutor(@NonNull Handler handler) {
            this.s = (Handler) Preconditions.l(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (Looper.myLooper() == this.s.getLooper()) {
                runnable.run();
            } else if (!this.s.post((Runnable) Preconditions.l(runnable))) {
                throw new RejectedExecutionException(this.s + " is shutting down");
            }
        }
    }

    private static class LocationListenerKey {

        /* renamed from: a  reason: collision with root package name */
        final String f6002a;

        /* renamed from: b  reason: collision with root package name */
        final LocationListenerCompat f6003b;

        LocationListenerKey(String str, LocationListenerCompat locationListenerCompat) {
            this.f6002a = (String) ObjectsCompat.e(str, "invalid null provider");
            this.f6003b = (LocationListenerCompat) ObjectsCompat.e(locationListenerCompat, "invalid null listener");
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LocationListenerKey)) {
                return false;
            }
            LocationListenerKey locationListenerKey = (LocationListenerKey) obj;
            return this.f6002a.equals(locationListenerKey.f6002a) && this.f6003b.equals(locationListenerKey.f6003b);
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f6002a, this.f6003b);
        }
    }

    private static class LocationListenerTransport implements LocationListener {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        volatile LocationListenerKey f6004a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f6005b;

        LocationListenerTransport(@Nullable LocationListenerKey locationListenerKey, Executor executor) {
            this.f6004a = locationListenerKey;
            this.f6005b = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(int i2) {
            LocationListenerKey locationListenerKey = this.f6004a;
            if (locationListenerKey != null) {
                locationListenerKey.f6003b.onFlushComplete(i2);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(Location location) {
            LocationListenerKey locationListenerKey = this.f6004a;
            if (locationListenerKey != null) {
                locationListenerKey.f6003b.onLocationChanged(location);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(List list) {
            LocationListenerKey locationListenerKey = this.f6004a;
            if (locationListenerKey != null) {
                locationListenerKey.f6003b.onLocationChanged(list);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(String str) {
            LocationListenerKey locationListenerKey = this.f6004a;
            if (locationListenerKey != null) {
                locationListenerKey.f6003b.onProviderDisabled(str);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(String str) {
            LocationListenerKey locationListenerKey = this.f6004a;
            if (locationListenerKey != null) {
                locationListenerKey.f6003b.onProviderEnabled(str);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(String str, int i2, Bundle bundle) {
            LocationListenerKey locationListenerKey = this.f6004a;
            if (locationListenerKey != null) {
                locationListenerKey.f6003b.onStatusChanged(str, i2, bundle);
            }
        }

        public LocationListenerKey g() {
            return (LocationListenerKey) ObjectsCompat.d(this.f6004a);
        }

        public void n() {
            this.f6004a = null;
        }

        public void onFlushComplete(int i2) {
            if (this.f6004a != null) {
                this.f6005b.execute(new H(this, i2));
            }
        }

        public void onLocationChanged(@NonNull Location location) {
            if (this.f6004a != null) {
                this.f6005b.execute(new G(this, location));
            }
        }

        public void onProviderDisabled(@NonNull String str) {
            if (this.f6004a != null) {
                this.f6005b.execute(new E(this, str));
            }
        }

        public void onProviderEnabled(@NonNull String str) {
            if (this.f6004a != null) {
                this.f6005b.execute(new D(this, str));
            }
        }

        public void onStatusChanged(String str, int i2, Bundle bundle) {
            if (this.f6004a != null) {
                this.f6005b.execute(new I(this, str, i2, bundle));
            }
        }

        public void onLocationChanged(@NonNull List<Location> list) {
            if (this.f6004a != null) {
                this.f6005b.execute(new F(this, list));
            }
        }
    }

    @RequiresApi(24)
    private static class PreRGnssStatusTransport extends GnssStatus.Callback {

        /* renamed from: a  reason: collision with root package name */
        final GnssStatusCompat.Callback f6006a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        volatile Executor f6007b;

        PreRGnssStatusTransport(GnssStatusCompat.Callback callback) {
            Preconditions.b(callback != null, "invalid null callback");
            this.f6006a = callback;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(Executor executor, int i2) {
            if (this.f6007b == executor) {
                this.f6006a.a(i2);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(Executor executor, GnssStatus gnssStatus) {
            if (this.f6007b == executor) {
                this.f6006a.b(GnssStatusCompat.n(gnssStatus));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g(Executor executor) {
            if (this.f6007b == executor) {
                this.f6006a.c();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h(Executor executor) {
            if (this.f6007b == executor) {
                this.f6006a.d();
            }
        }

        public void i(Executor executor) {
            boolean z = false;
            Preconditions.b(executor != null, "invalid null executor");
            if (this.f6007b == null) {
                z = true;
            }
            Preconditions.n(z);
            this.f6007b = executor;
        }

        public void j() {
            this.f6007b = null;
        }

        public void onFirstFix(int i2) {
            Executor executor = this.f6007b;
            if (executor != null) {
                executor.execute(new J(this, executor, i2));
            }
        }

        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            Executor executor = this.f6007b;
            if (executor != null) {
                executor.execute(new K(this, executor, gnssStatus));
            }
        }

        public void onStarted() {
            Executor executor = this.f6007b;
            if (executor != null) {
                executor.execute(new M(this, executor));
            }
        }

        public void onStopped() {
            Executor executor = this.f6007b;
            if (executor != null) {
                executor.execute(new L(this, executor));
            }
        }
    }

    private LocationManagerCompat() {
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void c(@NonNull LocationManager locationManager, @NonNull String str, @Nullable CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(locationManager, str, cancellationSignal, executor, consumer);
            return;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation == null || SystemClock.elapsedRealtime() - LocationCompat.c(lastKnownLocation) >= f5977b) {
            CancellableLocationListener cancellableLocationListener = new CancellableLocationListener(locationManager, executor, consumer);
            locationManager.requestLocationUpdates(str, 0, 0.0f, cancellableLocationListener, Looper.getMainLooper());
            if (cancellationSignal != null) {
                cancellationSignal.setOnCancelListener(new q(cancellableLocationListener));
            }
            cancellableLocationListener.g(30000);
            return;
        }
        executor.execute(new p(consumer, lastKnownLocation));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @Deprecated
    public static void d(@NonNull LocationManager locationManager, @NonNull String str, @Nullable androidx.core.os.CancellationSignal cancellationSignal, @NonNull Executor executor, @NonNull Consumer<Location> consumer) {
        c(locationManager, str, cancellationSignal != null ? (CancellationSignal) cancellationSignal.b() : null, executor, consumer);
    }

    @Nullable
    public static String e(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(locationManager);
        }
        return null;
    }

    public static int f(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.b(locationManager);
        }
        return 0;
    }

    public static boolean g(@NonNull LocationManager locationManager, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.a(locationManager, str);
        }
        if (locationManager.getAllProviders().contains(str)) {
            return true;
        }
        try {
            return locationManager.getProvider(str) != null;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean h(@NonNull LocationManager locationManager) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.c(locationManager);
        }
        return locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps");
    }

    @RequiresApi(24)
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean k(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback, @NonNull Handler handler) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 30) {
            return Api24Impl.b(locationManager, callback, handler);
        }
        if (i2 == 30) {
            return m(locationManager, ExecutorCompat.a(handler), callback);
        }
        SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> simpleArrayMap = GnssListenersHolder.f5995b;
        synchronized (simpleArrayMap) {
            try {
                u(locationManager, callback);
                if (!Api24Impl.b(locationManager, callback, handler)) {
                    return false;
                }
                simpleArrayMap.put(callback, callback);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RequiresApi(24)
    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean l(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 30) {
            return Api31Impl.b(locationManager, executor, callback);
        }
        if (i2 == 30) {
            return m(locationManager, executor, callback);
        }
        SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> simpleArrayMap = GnssListenersHolder.f5995b;
        synchronized (simpleArrayMap) {
            try {
                GnssMeasurementsTransport gnssMeasurementsTransport = new GnssMeasurementsTransport(callback, executor);
                u(locationManager, callback);
                if (!Api24Impl.a(locationManager, gnssMeasurementsTransport)) {
                    return false;
                }
                simpleArrayMap.put(callback, gnssMeasurementsTransport);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RequiresApi(30)
    private static boolean m(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssMeasurementsEvent.Callback callback) {
        if (Build.VERSION.SDK_INT == 30) {
            try {
                if (f5980e == null) {
                    f5980e = Class.forName("android.location.GnssRequest$Builder");
                }
                if (f5981f == null) {
                    Method declaredMethod = f5980e.getDeclaredMethod("build", (Class[]) null);
                    f5981f = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                if (f5982g == null) {
                    Method declaredMethod2 = LocationManager.class.getDeclaredMethod("registerGnssMeasurementsCallback", new Class[]{Class.forName("android.location.GnssRequest"), Executor.class, o.a()});
                    f5982g = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                }
                Object invoke = f5982g.invoke(locationManager, new Object[]{f5981f.invoke(f5980e.getDeclaredConstructor((Class[]) null).newInstance((Object[]) null), (Object[]) null), executor, callback});
                return invoke != null && ((Boolean) invoke).booleanValue();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                return false;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0081, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0095, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0096 */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cc A[Catch:{ all -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e1 A[Catch:{ all -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ea A[SYNTHETIC, Splitter:B:74:0x00ea] */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean n(android.location.LocationManager r9, android.os.Handler r10, java.util.concurrent.Executor r11, androidx.core.location.GnssStatusCompat.Callback r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            if (r0 < r1) goto L_0x000b
            boolean r9 = androidx.core.location.LocationManagerCompat.Api30Impl.b(r9, r10, r11, r12)
            return r9
        L_0x000b:
            r1 = 24
            if (r0 < r1) goto L_0x0014
            boolean r9 = androidx.core.location.LocationManagerCompat.Api24Impl.c(r9, r10, r11, r12)
            return r9
        L_0x0014:
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L_0x001a
            r2 = 1
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            androidx.core.util.Preconditions.a(r2)
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r2 = androidx.core.location.LocationManagerCompat.GnssListenersHolder.f5994a
            monitor-enter(r2)
            java.lang.Object r3 = r2.get(r12)     // Catch:{ all -> 0x002f }
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = (androidx.core.location.LocationManagerCompat.GpsStatusTransport) r3     // Catch:{ all -> 0x002f }
            if (r3 != 0) goto L_0x0032
            androidx.core.location.LocationManagerCompat$GpsStatusTransport r3 = new androidx.core.location.LocationManagerCompat$GpsStatusTransport     // Catch:{ all -> 0x002f }
            r3.<init>(r9, r12)     // Catch:{ all -> 0x002f }
            goto L_0x0035
        L_0x002f:
            r9 = move-exception
            goto L_0x0109
        L_0x0032:
            r3.j()     // Catch:{ all -> 0x002f }
        L_0x0035:
            r3.i(r11)     // Catch:{ all -> 0x002f }
            java.util.concurrent.FutureTask r11 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x002f }
            androidx.core.location.r r4 = new androidx.core.location.r     // Catch:{ all -> 0x002f }
            r4.<init>(r9, r3)     // Catch:{ all -> 0x002f }
            r11.<init>(r4)     // Catch:{ all -> 0x002f }
            android.os.Looper r9 = android.os.Looper.myLooper()     // Catch:{ all -> 0x002f }
            android.os.Looper r4 = r10.getLooper()     // Catch:{ all -> 0x002f }
            if (r9 != r4) goto L_0x0050
            r11.run()     // Catch:{ all -> 0x002f }
            goto L_0x0056
        L_0x0050:
            boolean r9 = r10.post(r11)     // Catch:{ all -> 0x002f }
            if (r9 == 0) goto L_0x00f2
        L_0x0056:
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x00ab, TimeoutException -> 0x00a9 }
            r4 = 5
            long r4 = r9.toNanos(r4)     // Catch:{ ExecutionException -> 0x00ab, TimeoutException -> 0x00a9 }
            long r6 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x00ab, TimeoutException -> 0x00a9 }
            long r6 = r6 + r4
            r9 = 0
        L_0x0064:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x0096, ExecutionException -> 0x0088, TimeoutException -> 0x0085, all -> 0x0082 }
            java.lang.Object r4 = r11.get(r4, r8)     // Catch:{ InterruptedException -> 0x0096, ExecutionException -> 0x0088, TimeoutException -> 0x0085, all -> 0x0082 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ InterruptedException -> 0x0096, ExecutionException -> 0x0088, TimeoutException -> 0x0085, all -> 0x0082 }
            boolean r4 = r4.booleanValue()     // Catch:{ InterruptedException -> 0x0096, ExecutionException -> 0x0088, TimeoutException -> 0x0085, all -> 0x0082 }
            if (r4 == 0) goto L_0x008b
            androidx.collection.SimpleArrayMap<java.lang.Object, java.lang.Object> r4 = androidx.core.location.LocationManagerCompat.GnssListenersHolder.f5994a     // Catch:{ InterruptedException -> 0x0096, ExecutionException -> 0x0088, TimeoutException -> 0x0085, all -> 0x0082 }
            r4.put(r12, r3)     // Catch:{ InterruptedException -> 0x0096, ExecutionException -> 0x0088, TimeoutException -> 0x0085, all -> 0x0082 }
            if (r9 == 0) goto L_0x0080
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r9.interrupt()     // Catch:{ all -> 0x002f }
        L_0x0080:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            return r1
        L_0x0082:
            r10 = move-exception
            r0 = r9
            goto L_0x00e8
        L_0x0085:
            r11 = move-exception
            r0 = r9
            goto L_0x00ad
        L_0x0088:
            r10 = move-exception
            r0 = r9
            goto L_0x00c4
        L_0x008b:
            if (r9 == 0) goto L_0x0094
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r9.interrupt()     // Catch:{ all -> 0x002f }
        L_0x0094:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            return r0
        L_0x0096:
            long r4 = java.lang.System.nanoTime()     // Catch:{ ExecutionException -> 0x00a4, TimeoutException -> 0x00a1, all -> 0x009e }
            long r4 = r6 - r4
            r9 = 1
            goto L_0x0064
        L_0x009e:
            r10 = move-exception
            r0 = 1
            goto L_0x00e8
        L_0x00a1:
            r11 = move-exception
            r0 = 1
            goto L_0x00ad
        L_0x00a4:
            r10 = move-exception
            r0 = 1
            goto L_0x00c4
        L_0x00a7:
            r10 = move-exception
            goto L_0x00e8
        L_0x00a9:
            r11 = move-exception
            goto L_0x00ad
        L_0x00ab:
            r10 = move-exception
            goto L_0x00c4
        L_0x00ad:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a7 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r12.<init>()     // Catch:{ all -> 0x00a7 }
            r12.append(r10)     // Catch:{ all -> 0x00a7 }
            java.lang.String r10 = " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread"
            r12.append(r10)     // Catch:{ all -> 0x00a7 }
            java.lang.String r10 = r12.toString()     // Catch:{ all -> 0x00a7 }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x00a7 }
            throw r9     // Catch:{ all -> 0x00a7 }
        L_0x00c4:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a7 }
            boolean r9 = r9 instanceof java.lang.RuntimeException     // Catch:{ all -> 0x00a7 }
            if (r9 != 0) goto L_0x00e1
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a7 }
            boolean r9 = r9 instanceof java.lang.Error     // Catch:{ all -> 0x00a7 }
            if (r9 == 0) goto L_0x00db
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a7 }
            java.lang.Error r9 = (java.lang.Error) r9     // Catch:{ all -> 0x00a7 }
            throw r9     // Catch:{ all -> 0x00a7 }
        L_0x00db:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a7 }
            r9.<init>(r10)     // Catch:{ all -> 0x00a7 }
            throw r9     // Catch:{ all -> 0x00a7 }
        L_0x00e1:
            java.lang.Throwable r9 = r10.getCause()     // Catch:{ all -> 0x00a7 }
            java.lang.RuntimeException r9 = (java.lang.RuntimeException) r9     // Catch:{ all -> 0x00a7 }
            throw r9     // Catch:{ all -> 0x00a7 }
        L_0x00e8:
            if (r0 == 0) goto L_0x00f1
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r9.interrupt()     // Catch:{ all -> 0x002f }
        L_0x00f1:
            throw r10     // Catch:{ all -> 0x002f }
        L_0x00f2:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002f }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r11.<init>()     // Catch:{ all -> 0x002f }
            r11.append(r10)     // Catch:{ all -> 0x002f }
            java.lang.String r10 = " is shutting down"
            r11.append(r10)     // Catch:{ all -> 0x002f }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x002f }
            r9.<init>(r10)     // Catch:{ all -> 0x002f }
            throw r9     // Catch:{ all -> 0x002f }
        L_0x0109:
            monitor-exit(r2)     // Catch:{ all -> 0x002f }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.location.LocationManagerCompat.n(android.location.LocationManager, android.os.Handler, java.util.concurrent.Executor, androidx.core.location.GnssStatusCompat$Callback):boolean");
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean o(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback, @NonNull Handler handler) {
        return Build.VERSION.SDK_INT >= 30 ? p(locationManager, ExecutorCompat.a(handler), callback) : p(locationManager, new InlineHandlerExecutor(handler), callback);
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public static boolean p(@NonNull LocationManager locationManager, @NonNull Executor executor, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            return n(locationManager, (Handler) null, executor, callback);
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return n(locationManager, new Handler(myLooper), executor, callback);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    @GuardedBy("sLocationListeners")
    static void q(LocationManager locationManager, LocationListenerTransport locationListenerTransport) {
        WeakReference put = f5983h.put(locationListenerTransport.g(), new WeakReference(locationListenerTransport));
        LocationListenerTransport locationListenerTransport2 = put != null ? (LocationListenerTransport) put.get() : null;
        if (locationListenerTransport2 != null) {
            locationListenerTransport2.n();
            locationManager.removeUpdates(locationListenerTransport2);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void r(@NonNull LocationManager locationManager, @NonNull LocationListenerCompat locationListenerCompat) {
        WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> weakHashMap = f5983h;
        synchronized (weakHashMap) {
            try {
                ArrayList arrayList = null;
                for (WeakReference<LocationListenerTransport> weakReference : weakHashMap.values()) {
                    LocationListenerTransport locationListenerTransport = (LocationListenerTransport) weakReference.get();
                    if (locationListenerTransport != null) {
                        LocationListenerKey g2 = locationListenerTransport.g();
                        if (g2.f6003b == locationListenerCompat) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(g2);
                            locationListenerTransport.n();
                            locationManager.removeUpdates(locationListenerTransport);
                        }
                    }
                }
                if (arrayList != null) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        f5983h.remove((LocationListenerKey) it2.next());
                    }
                }
            } finally {
                while (true) {
                }
            }
        }
        locationManager.removeUpdates(locationListenerCompat);
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void s(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull LocationListenerCompat locationListenerCompat, @NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.c(locationManager, str, locationRequestCompat.h(), ExecutorCompat.a(new Handler(looper)), locationListenerCompat);
        } else if (!Api19Impl.a(locationManager, str, locationRequestCompat, locationListenerCompat, looper)) {
            locationManager.requestLocationUpdates(str, locationRequestCompat.b(), locationRequestCompat.e(), locationListenerCompat, looper);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public static void t(@NonNull LocationManager locationManager, @NonNull String str, @NonNull LocationRequestCompat locationRequestCompat, @NonNull Executor executor, @NonNull LocationListenerCompat locationListenerCompat) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31) {
            Api31Impl.c(locationManager, str, locationRequestCompat.h(), executor, locationListenerCompat);
        } else if (i2 < 30 || !Api30Impl.c(locationManager, str, locationRequestCompat, executor, locationListenerCompat)) {
            LocationListenerTransport locationListenerTransport = new LocationListenerTransport(new LocationListenerKey(str, locationListenerCompat), executor);
            if (!Api19Impl.b(locationManager, str, locationRequestCompat, locationListenerTransport)) {
                synchronized (f5983h) {
                    locationManager.requestLocationUpdates(str, locationRequestCompat.b(), locationRequestCompat.e(), locationListenerTransport, Looper.getMainLooper());
                    q(locationManager, locationListenerTransport);
                }
            }
        }
    }

    @RequiresApi(24)
    public static void u(@NonNull LocationManager locationManager, @NonNull GnssMeasurementsEvent.Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api24Impl.d(locationManager, callback);
            return;
        }
        SimpleArrayMap<GnssMeasurementsEvent.Callback, GnssMeasurementsEvent.Callback> simpleArrayMap = GnssListenersHolder.f5995b;
        synchronized (simpleArrayMap) {
            try {
                GnssMeasurementsEvent.Callback a2 = C0061n.a(simpleArrayMap.remove(callback));
                if (a2 != null) {
                    if (a2 instanceof GnssMeasurementsTransport) {
                        ((GnssMeasurementsTransport) a2).e();
                    }
                    Api24Impl.d(locationManager, a2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void v(@NonNull LocationManager locationManager, @NonNull GnssStatusCompat.Callback callback) {
        if (Build.VERSION.SDK_INT >= 24) {
            SimpleArrayMap<Object, Object> simpleArrayMap = GnssListenersHolder.f5994a;
            synchronized (simpleArrayMap) {
                try {
                    Object remove = simpleArrayMap.remove(callback);
                    if (remove != null) {
                        Api24Impl.e(locationManager, remove);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        SimpleArrayMap<Object, Object> simpleArrayMap2 = GnssListenersHolder.f5994a;
        synchronized (simpleArrayMap2) {
            try {
                GpsStatusTransport gpsStatusTransport = (GpsStatusTransport) simpleArrayMap2.remove(callback);
                if (gpsStatusTransport != null) {
                    gpsStatusTransport.j();
                    locationManager.removeGpsStatusListener(gpsStatusTransport);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

package androidx.core.location;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class GpsStatusWrapper extends GnssStatusCompat {

    /* renamed from: n  reason: collision with root package name */
    private static final int f5959n = 0;
    private static final int o = 32;
    private static final int p = 33;
    private static final int q = 64;
    private static final int r = -87;
    private static final int s = 64;
    private static final int t = 24;
    private static final int u = 193;
    private static final int v = 200;
    private static final int w = 200;
    private static final int x = 35;

    /* renamed from: i  reason: collision with root package name */
    private final GpsStatus f5960i;
    @GuardedBy("mWrapped")

    /* renamed from: j  reason: collision with root package name */
    private int f5961j = -1;
    @GuardedBy("mWrapped")

    /* renamed from: k  reason: collision with root package name */
    private Iterator<GpsSatellite> f5962k;
    @GuardedBy("mWrapped")

    /* renamed from: l  reason: collision with root package name */
    private int f5963l;
    @GuardedBy("mWrapped")

    /* renamed from: m  reason: collision with root package name */
    private GpsSatellite f5964m;

    GpsStatusWrapper(GpsStatus gpsStatus) {
        GpsStatus gpsStatus2 = (GpsStatus) Preconditions.l(gpsStatus);
        this.f5960i = gpsStatus2;
        this.f5962k = gpsStatus2.getSatellites().iterator();
        this.f5963l = -1;
        this.f5964m = null;
    }

    private static int p(int i2) {
        if (i2 > 0 && i2 <= 32) {
            return 1;
        }
        if (i2 >= 33 && i2 <= 64) {
            return 2;
        }
        if (i2 > 64 && i2 <= 88) {
            return 3;
        }
        if (i2 <= 200 || i2 > 235) {
            return (i2 < u || i2 > 200) ? 0 : 4;
        }
        return 5;
    }

    private GpsSatellite q(int i2) {
        GpsSatellite gpsSatellite;
        synchronized (this.f5960i) {
            try {
                if (i2 < this.f5963l) {
                    this.f5962k = this.f5960i.getSatellites().iterator();
                    this.f5963l = -1;
                }
                while (true) {
                    int i3 = this.f5963l;
                    if (i3 >= i2) {
                        break;
                    }
                    this.f5963l = i3 + 1;
                    if (!this.f5962k.hasNext()) {
                        this.f5964m = null;
                        break;
                    }
                    this.f5964m = this.f5962k.next();
                }
                gpsSatellite = this.f5964m;
            } finally {
                while (true) {
                }
            }
        }
        return (GpsSatellite) Preconditions.l(gpsSatellite);
    }

    private static int r(int i2) {
        int p2 = p(i2);
        if (p2 == 2) {
            return i2 + 87;
        }
        if (p2 != 3) {
            return p2 != 5 ? i2 : i2 - 200;
        }
        return i2 - 64;
    }

    public float a(int i2) {
        return q(i2).getAzimuth();
    }

    public float b(int i2) {
        throw new UnsupportedOperationException();
    }

    public float c(int i2) {
        throw new UnsupportedOperationException();
    }

    public float d(int i2) {
        return q(i2).getSnr();
    }

    public int e(int i2) {
        if (Build.VERSION.SDK_INT < 24) {
            return 1;
        }
        return p(q(i2).getPrn());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GpsStatusWrapper)) {
            return false;
        }
        return this.f5960i.equals(((GpsStatusWrapper) obj).f5960i);
    }

    public float f(int i2) {
        return q(i2).getElevation();
    }

    public int g() {
        int i2;
        synchronized (this.f5960i) {
            try {
                if (this.f5961j == -1) {
                    for (GpsSatellite next : this.f5960i.getSatellites()) {
                        this.f5961j++;
                    }
                    this.f5961j++;
                }
                i2 = this.f5961j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public int h(int i2) {
        int i3 = Build.VERSION.SDK_INT;
        int prn = q(i2).getPrn();
        return i3 < 24 ? prn : r(prn);
    }

    public int hashCode() {
        return this.f5960i.hashCode();
    }

    public boolean i(int i2) {
        return q(i2).hasAlmanac();
    }

    public boolean j(int i2) {
        return false;
    }

    public boolean k(int i2) {
        return false;
    }

    public boolean l(int i2) {
        return q(i2).hasEphemeris();
    }

    public boolean m(int i2) {
        return q(i2).usedInFix();
    }
}

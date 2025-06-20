package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class GnssStatusWrapper extends GnssStatusCompat {

    /* renamed from: i  reason: collision with root package name */
    private final GnssStatus f5958i;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static float a(GnssStatus gnssStatus, int i2) {
            return gnssStatus.getCarrierFrequencyHz(i2);
        }

        @DoNotInline
        static boolean b(GnssStatus gnssStatus, int i2) {
            return gnssStatus.hasCarrierFrequencyHz(i2);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static float a(GnssStatus gnssStatus, int i2) {
            return gnssStatus.getBasebandCn0DbHz(i2);
        }

        @DoNotInline
        static boolean b(GnssStatus gnssStatus, int i2) {
            return gnssStatus.hasBasebandCn0DbHz(i2);
        }
    }

    GnssStatusWrapper(Object obj) {
        this.f5958i = C0051d.a(Preconditions.l(C0051d.a(obj)));
    }

    public float a(int i2) {
        return this.f5958i.getAzimuthDegrees(i2);
    }

    public float b(int i2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.a(this.f5958i, i2);
        }
        throw new UnsupportedOperationException();
    }

    public float c(int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.a(this.f5958i, i2);
        }
        throw new UnsupportedOperationException();
    }

    public float d(int i2) {
        return this.f5958i.getCn0DbHz(i2);
    }

    public int e(int i2) {
        return this.f5958i.getConstellationType(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GnssStatusWrapper)) {
            return false;
        }
        return this.f5958i.equals(((GnssStatusWrapper) obj).f5958i);
    }

    public float f(int i2) {
        return this.f5958i.getElevationDegrees(i2);
    }

    public int g() {
        return this.f5958i.getSatelliteCount();
    }

    public int h(int i2) {
        return this.f5958i.getSvid(i2);
    }

    public int hashCode() {
        return this.f5958i.hashCode();
    }

    public boolean i(int i2) {
        return this.f5958i.hasAlmanacData(i2);
    }

    public boolean j(int i2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.b(this.f5958i, i2);
        }
        return false;
    }

    public boolean k(int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.b(this.f5958i, i2);
        }
        return false;
    }

    public boolean l(int i2) {
        return this.f5958i.hasEphemerisData(i2);
    }

    public boolean m(int i2) {
        return this.f5958i.usedInFix(i2);
    }
}

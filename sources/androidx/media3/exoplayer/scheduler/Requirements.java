package androidx.media3.exoplayer.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class Requirements implements Parcelable {
    public static final Parcelable.Creator<Requirements> CREATOR = new Parcelable.Creator<Requirements>() {
        /* renamed from: a */
        public Requirements createFromParcel(Parcel parcel) {
            return new Requirements(parcel.readInt());
        }

        /* renamed from: b */
        public Requirements[] newArray(int i2) {
            return new Requirements[i2];
        }
    };
    public static final int X = 1;
    public static final int X2 = 8;
    public static final int Y = 2;
    public static final int Y2 = 16;
    public static final int Z = 4;
    private final int s;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequirementFlags {
    }

    public Requirements(int i2) {
        this.s = (i2 & 2) != 0 ? i2 | 1 : i2;
    }

    private int c(Context context) {
        if (!p()) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) Assertions.g(context.getSystemService("connectivity"));
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || !o(connectivityManager)) {
            return this.s & 3;
        }
        return (!z() || !connectivityManager.isActiveNetworkMetered()) ? 0 : 2;
    }

    private boolean k(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra(NotificationCompat.T0, -1);
        return intExtra == 2 || intExtra == 5;
    }

    private boolean l(Context context) {
        PowerManager powerManager = (PowerManager) Assertions.g(context.getSystemService("power"));
        int i2 = Util.f9646a;
        if (i2 >= 23) {
            return powerManager.isDeviceIdleMode();
        }
        return i2 < 20 ? !powerManager.isScreenOn() : !powerManager.isInteractive();
    }

    private static boolean o(ConnectivityManager connectivityManager) {
        if (Util.f9646a < 24) {
            return true;
        }
        Network a2 = connectivityManager.getActiveNetwork();
        if (a2 == null) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(a2);
            return networkCapabilities != null && networkCapabilities.hasCapability(16);
        } catch (SecurityException unused) {
            return true;
        }
    }

    private boolean t(Context context) {
        return context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) == null;
    }

    public boolean a(Context context) {
        return d(context) == 0;
    }

    public Requirements b(int i2) {
        int i3 = this.s;
        int i4 = i2 & i3;
        return i4 == i3 ? this : new Requirements(i4);
    }

    public int d(Context context) {
        int c2 = c(context);
        if (j() && !k(context)) {
            c2 |= 8;
        }
        if (m() && !l(context)) {
            c2 |= 4;
        }
        return (!v() || t(context)) ? c2 : c2 | 16;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Requirements.class == obj.getClass() && this.s == ((Requirements) obj).s;
    }

    public int g() {
        return this.s;
    }

    public int hashCode() {
        return this.s;
    }

    public boolean j() {
        return (this.s & 8) != 0;
    }

    public boolean m() {
        return (this.s & 4) != 0;
    }

    public boolean p() {
        return (this.s & 1) != 0;
    }

    public boolean v() {
        return (this.s & 16) != 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.s);
    }

    public boolean z() {
        return (this.s & 2) != 0;
    }
}

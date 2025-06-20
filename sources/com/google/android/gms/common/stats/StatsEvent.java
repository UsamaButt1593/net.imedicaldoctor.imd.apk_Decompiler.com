package com.google.android.gms.common.stats;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public interface Types {
        @KeepForSdk

        /* renamed from: a  reason: collision with root package name */
        public static final int f20356a = 7;
        @KeepForSdk

        /* renamed from: b  reason: collision with root package name */
        public static final int f20357b = 8;
    }

    public abstract int C();

    public abstract long H();

    @NonNull
    public abstract String I();

    @NonNull
    public final String toString() {
        long H = H();
        int C = C();
        String I = I();
        return H + "\t" + C + "\t-1" + I;
    }
}

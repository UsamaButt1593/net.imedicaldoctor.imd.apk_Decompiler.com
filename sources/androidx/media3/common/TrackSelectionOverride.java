package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.Collections;
import java.util.List;

public final class TrackSelectionOverride implements Bundleable {
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<TrackSelectionOverride> X2 = new o1();
    private static final String Y = Util.d1(0);
    private static final String Z = Util.d1(1);
    public final ImmutableList<Integer> X;
    public final TrackGroup s;

    public TrackSelectionOverride(TrackGroup trackGroup, int i2) {
        this(trackGroup, (List<Integer>) ImmutableList.K(Integer.valueOf(i2)));
    }

    @UnstableApi
    public static TrackSelectionOverride b(Bundle bundle) {
        return new TrackSelectionOverride(TrackGroup.c((Bundle) Assertions.g(bundle.getBundle(Y))), Ints.c((int[]) Assertions.g(bundle.getIntArray(Z))));
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putBundle(Y, this.s.a());
        bundle.putIntArray(Z, Ints.D(this.X));
        return bundle;
    }

    public int c() {
        return this.s.Y;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionOverride.class != obj.getClass()) {
            return false;
        }
        TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) obj;
        return this.s.equals(trackSelectionOverride.s) && this.X.equals(trackSelectionOverride.X);
    }

    public int hashCode() {
        return this.s.hashCode() + (this.X.hashCode() * 31);
    }

    public TrackSelectionOverride(TrackGroup trackGroup, List<Integer> list) {
        if (list.isEmpty() || (((Integer) Collections.min(list)).intValue() >= 0 && ((Integer) Collections.max(list)).intValue() < trackGroup.s)) {
            this.s = trackGroup;
            this.X = ImmutableList.B(list);
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}

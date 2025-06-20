package androidx.media3.exoplayer.source;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;

@UnstableApi
public final class TrackGroupArray implements Bundleable {
    public static final TrackGroupArray X2 = new TrackGroupArray(new TrackGroup[0]);
    private static final String Y2 = Util.d1(0);
    private static final String Z = "TrackGroupArray";
    @Deprecated
    public static final Bundleable.Creator<TrackGroupArray> Z2 = new F();
    private final ImmutableList<TrackGroup> X;
    private int Y;
    public final int s;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.X = ImmutableList.D(trackGroupArr);
        this.s = trackGroupArr.length;
        i();
    }

    public static TrackGroupArray c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Y2);
        return parcelableArrayList == null ? new TrackGroupArray(new TrackGroup[0]) : new TrackGroupArray((TrackGroup[]) BundleCollectionUtil.d(new I(), parcelableArrayList).toArray(new TrackGroup[0]));
    }

    private void i() {
        int i2 = 0;
        while (i2 < this.X.size()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.X.size(); i4++) {
                if (this.X.get(i2).equals(this.X.get(i4))) {
                    Log.e(Z, "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i2 = i3;
        }
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Y2, BundleCollectionUtil.i(this.X, new H()));
        return bundle;
    }

    public TrackGroup d(int i2) {
        return this.X.get(i2);
    }

    public ImmutableList<Integer> e() {
        return ImmutableList.B(Lists.D(this.X, new G()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.s == trackGroupArray.s && this.X.equals(trackGroupArray.X);
    }

    public int f(TrackGroup trackGroup) {
        int indexOf = this.X.indexOf(trackGroup);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public boolean g() {
        return this.s == 0;
    }

    public int hashCode() {
        if (this.Y == 0) {
            this.Y = this.X.hashCode();
        }
        return this.Y;
    }
}

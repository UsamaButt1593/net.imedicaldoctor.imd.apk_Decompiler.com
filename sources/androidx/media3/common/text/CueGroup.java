package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class CueGroup implements Bundleable {
    private static final String X2 = Util.d1(1);
    @UnstableApi
    public static final CueGroup Y = new CueGroup(ImmutableList.I(), 0);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<CueGroup> Y2 = new b();
    private static final String Z = Util.d1(0);
    @UnstableApi
    public final long X;
    public final ImmutableList<Cue> s;

    @UnstableApi
    public CueGroup(List<Cue> list, long j2) {
        this.s = ImmutableList.B(list);
        this.X = j2;
    }

    private static ImmutableList<Cue> b(List<Cue> list) {
        ImmutableList.Builder r = ImmutableList.r();
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).Z == null) {
                r.g(list.get(i2));
            }
        }
        return r.e();
    }

    @UnstableApi
    public static CueGroup c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Z);
        return new CueGroup(parcelableArrayList == null ? ImmutableList.I() : BundleCollectionUtil.d(new c(), parcelableArrayList), bundle.getLong(X2));
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Z, BundleCollectionUtil.i(b(this.s), new d()));
        bundle.putLong(X2, this.X);
        return bundle;
    }
}

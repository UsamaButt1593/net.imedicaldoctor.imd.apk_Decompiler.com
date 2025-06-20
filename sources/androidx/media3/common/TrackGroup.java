package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.Arrays;

public final class TrackGroup implements Bundleable {
    private static final String Y2 = "TrackGroup";
    private static final String Z2 = Util.d1(0);
    private static final String a3 = Util.d1(1);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<TrackGroup> b3 = new n1();
    @UnstableApi
    public final String X;
    private int X2;
    @UnstableApi
    public final int Y;
    private final Format[] Z;
    @UnstableApi
    public final int s;

    @UnstableApi
    public TrackGroup(String str, Format... formatArr) {
        Assertions.a(formatArr.length > 0);
        this.X = str;
        this.Z = formatArr;
        this.s = formatArr.length;
        int l2 = MimeTypes.l(formatArr[0].f3);
        this.Y = l2 == -1 ? MimeTypes.l(formatArr[0].e3) : l2;
        i();
    }

    @UnstableApi
    public static TrackGroup c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Z2);
        return new TrackGroup(bundle.getString(a3, ""), (Format[]) (parcelableArrayList == null ? ImmutableList.I() : BundleCollectionUtil.d(new m1(), parcelableArrayList)).toArray(new Format[0]));
    }

    private static void f(String str, @Nullable String str2, @Nullable String str3, int i2) {
        Log.e(Y2, "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i2 + ")"));
    }

    private static String g(@Nullable String str) {
        return (str == null || str.equals(C.k1)) ? "" : str;
    }

    private static int h(int i2) {
        return i2 | 16384;
    }

    private void i() {
        String g2 = g(this.Z[0].Z);
        int h2 = h(this.Z[0].Y2);
        int i2 = 1;
        while (true) {
            Format[] formatArr = this.Z;
            if (i2 >= formatArr.length) {
                return;
            }
            if (!g2.equals(g(formatArr[i2].Z))) {
                Format[] formatArr2 = this.Z;
                f("languages", formatArr2[0].Z, formatArr2[i2].Z, i2);
                return;
            } else if (h2 != h(this.Z[i2].Y2)) {
                f("role flags", Integer.toBinaryString(this.Z[0].Y2), Integer.toBinaryString(this.Z[i2].Y2), i2);
                return;
            } else {
                i2++;
            }
        }
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList(this.Z.length);
        for (Format l2 : this.Z) {
            arrayList.add(l2.l(true));
        }
        bundle.putParcelableArrayList(Z2, arrayList);
        bundle.putString(a3, this.X);
        return bundle;
    }

    @CheckResult
    @UnstableApi
    public TrackGroup b(String str) {
        return new TrackGroup(str, this.Z);
    }

    @UnstableApi
    public Format d(int i2) {
        return this.Z[i2];
    }

    @UnstableApi
    public int e(Format format) {
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.Z;
            if (i2 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.X.equals(trackGroup.X) && Arrays.equals(this.Z, trackGroup.Z);
    }

    public int hashCode() {
        if (this.X2 == 0) {
            this.X2 = ((MetaDo.w + this.X.hashCode()) * 31) + Arrays.hashCode(this.Z);
        }
        return this.X2;
    }

    @UnstableApi
    public TrackGroup(Format... formatArr) {
        this("", formatArr);
    }
}

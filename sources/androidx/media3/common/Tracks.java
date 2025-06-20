package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tracks implements Bundleable {
    public static final Tracks X = new Tracks(ImmutableList.I());
    private static final String Y = Util.d1(0);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<Tracks> Z = new s1();
    private final ImmutableList<Group> s;

    public static final class Group implements Bundleable {
        private static final String Y2 = Util.d1(0);
        private static final String Z2 = Util.d1(1);
        private static final String a3 = Util.d1(3);
        private static final String b3 = Util.d1(4);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<Group> c3 = new v1();
        private final TrackGroup X;
        private final boolean[] X2;
        private final boolean Y;
        private final int[] Z;
        public final int s;

        @UnstableApi
        public Group(TrackGroup trackGroup, boolean z, int[] iArr, boolean[] zArr) {
            int i2 = trackGroup.s;
            this.s = i2;
            boolean z2 = false;
            Assertions.a(i2 == iArr.length && i2 == zArr.length);
            this.X = trackGroup;
            if (z && i2 > 1) {
                z2 = true;
            }
            this.Y = z2;
            this.Z = (int[]) iArr.clone();
            this.X2 = (boolean[]) zArr.clone();
        }

        @UnstableApi
        public static Group c(Bundle bundle) {
            TrackGroup c2 = TrackGroup.c((Bundle) Assertions.g(bundle.getBundle(Y2)));
            return new Group(c2, bundle.getBoolean(b3, false), (int[]) MoreObjects.a(bundle.getIntArray(Z2), new int[c2.s]), (boolean[]) MoreObjects.a(bundle.getBooleanArray(a3), new boolean[c2.s]));
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putBundle(Y2, this.X.a());
            bundle.putIntArray(Z2, this.Z);
            bundle.putBooleanArray(a3, this.X2);
            bundle.putBoolean(b3, this.Y);
            return bundle;
        }

        @UnstableApi
        public Group b(String str) {
            return new Group(this.X.b(str), this.Y, this.Z, this.X2);
        }

        public TrackGroup d() {
            return this.X;
        }

        public Format e(int i2) {
            return this.X.d(i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Group.class != obj.getClass()) {
                return false;
            }
            Group group = (Group) obj;
            return this.Y == group.Y && this.X.equals(group.X) && Arrays.equals(this.Z, group.Z) && Arrays.equals(this.X2, group.X2);
        }

        @UnstableApi
        public int f(int i2) {
            return this.Z[i2];
        }

        public int g() {
            return this.X.Y;
        }

        public boolean h() {
            return this.Y;
        }

        public int hashCode() {
            return (((((this.X.hashCode() * 31) + (this.Y ? 1 : 0)) * 31) + Arrays.hashCode(this.Z)) * 31) + Arrays.hashCode(this.X2);
        }

        public boolean i() {
            return Booleans.f(this.X2, true);
        }

        public boolean j() {
            return k(false);
        }

        public boolean k(boolean z) {
            for (int i2 = 0; i2 < this.Z.length; i2++) {
                if (n(i2, z)) {
                    return true;
                }
            }
            return false;
        }

        public boolean l(int i2) {
            return this.X2[i2];
        }

        public boolean m(int i2) {
            return n(i2, false);
        }

        public boolean n(int i2, boolean z) {
            int i3 = this.Z[i2];
            return i3 == 4 || (z && i3 == 3);
        }
    }

    @UnstableApi
    public Tracks(List<Group> list) {
        this.s = ImmutableList.B(list);
    }

    @UnstableApi
    public static Tracks c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Y);
        return new Tracks(parcelableArrayList == null ? ImmutableList.I() : BundleCollectionUtil.d(new u1(), parcelableArrayList));
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Y, BundleCollectionUtil.i(this.s, new t1()));
        return bundle;
    }

    public boolean b(int i2) {
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            if (this.s.get(i3).g() == i2) {
                return true;
            }
        }
        return false;
    }

    public ImmutableList<Group> d() {
        return this.s;
    }

    public boolean e() {
        return this.s.isEmpty();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Tracks.class != obj.getClass()) {
            return false;
        }
        return this.s.equals(((Tracks) obj).s);
    }

    public boolean f(int i2) {
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            Group group = this.s.get(i3);
            if (group.i() && group.g() == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean g(int i2) {
        return h(i2, false);
    }

    public boolean h(int i2, boolean z) {
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            if (this.s.get(i3).g() == i2 && this.s.get(i3).k(z)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.s.hashCode();
    }

    @UnstableApi
    @Deprecated
    public boolean i(int i2) {
        return j(i2, false);
    }

    @UnstableApi
    @Deprecated
    public boolean j(int i2, boolean z) {
        return !b(i2) || h(i2, z);
    }
}

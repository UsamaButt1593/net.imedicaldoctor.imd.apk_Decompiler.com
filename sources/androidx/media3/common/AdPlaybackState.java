package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Bundleable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.dd.plist.ASCIIPropertyListParser;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;

@UnstableApi
public final class AdPlaybackState implements Bundleable {
    public static final int Z2 = 0;
    public static final int a3 = 1;
    public static final int b3 = 2;
    public static final int c3 = 3;
    public static final int d3 = 4;
    public static final AdPlaybackState e3 = new AdPlaybackState((Object) null, new AdGroup[0], 0, C.f9084b, 0);
    private static final AdGroup f3 = new AdGroup(0).m(0);
    private static final String g3 = Util.d1(1);
    private static final String h3 = Util.d1(2);
    private static final String i3 = Util.d1(3);
    private static final String j3 = Util.d1(4);
    @Deprecated
    public static final Bundleable.Creator<AdPlaybackState> k3 = new C0135a();
    public final int X;
    public final int X2;
    public final long Y;
    private final AdGroup[] Y2;
    public final long Z;
    @Nullable
    public final Object s;

    public static final class AdGroup implements Bundleable {
        private static final String c3 = Util.d1(0);
        private static final String d3 = Util.d1(1);
        private static final String e3 = Util.d1(2);
        private static final String f3 = Util.d1(3);
        private static final String g3 = Util.d1(4);
        private static final String h3 = Util.d1(5);
        private static final String i3 = Util.d1(6);
        private static final String j3 = Util.d1(7);
        @VisibleForTesting
        static final String k3 = Util.d1(8);
        @Deprecated
        public static final Bundleable.Creator<AdGroup> l3 = new C0137b();
        public final int X;
        public final MediaItem[] X2;
        public final int Y;
        public final int[] Y2;
        @Deprecated
        public final Uri[] Z;
        public final long[] Z2;
        public final long a3;
        public final boolean b3;
        public final long s;

        public AdGroup(long j2) {
            this(j2, -1, -1, new int[0], new MediaItem[0], new long[0], 0, false);
        }

        @CheckResult
        private static long[] c(long[] jArr, int i2) {
            int length = jArr.length;
            int max = Math.max(i2, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, C.f9084b);
            return copyOf;
        }

        @CheckResult
        private static int[] d(int[] iArr, int i2) {
            int length = iArr.length;
            int max = Math.max(i2, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public static AdGroup e(Bundle bundle) {
            long j2 = bundle.getLong(c3);
            int i2 = bundle.getInt(d3);
            int i4 = bundle.getInt(j3);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(e3);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(k3);
            int[] intArray = bundle.getIntArray(f3);
            long[] longArray = bundle.getLongArray(g3);
            long j4 = bundle.getLong(h3);
            boolean z = bundle.getBoolean(i3);
            if (intArray == null) {
                intArray = new int[0];
            }
            return new AdGroup(j2, i2, i4, intArray, h(parcelableArrayList2, parcelableArrayList), longArray == null ? new long[0] : longArray, j4, z);
        }

        private ArrayList<Bundle> g() {
            ArrayList<Bundle> arrayList = new ArrayList<>();
            MediaItem[] mediaItemArr = this.X2;
            int length = mediaItemArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                MediaItem mediaItem = mediaItemArr[i2];
                arrayList.add(mediaItem == null ? null : mediaItem.g());
            }
            return arrayList;
        }

        private static MediaItem[] h(@Nullable ArrayList<Bundle> arrayList, @Nullable ArrayList<Uri> arrayList2) {
            int i2 = 0;
            if (arrayList != null) {
                MediaItem[] mediaItemArr = new MediaItem[arrayList.size()];
                while (i2 < arrayList.size()) {
                    Bundle bundle = arrayList.get(i2);
                    mediaItemArr[i2] = bundle == null ? null : MediaItem.c(bundle);
                    i2++;
                }
                return mediaItemArr;
            } else if (arrayList2 == null) {
                return new MediaItem[0];
            } else {
                MediaItem[] mediaItemArr2 = new MediaItem[arrayList2.size()];
                while (i2 < arrayList2.size()) {
                    Uri uri = arrayList2.get(i2);
                    mediaItemArr2[i2] = uri == null ? null : MediaItem.d(uri);
                    i2++;
                }
                return mediaItemArr2;
            }
        }

        /* access modifiers changed from: private */
        public boolean k() {
            return this.b3 && this.s == Long.MIN_VALUE && this.X == -1;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putLong(c3, this.s);
            bundle.putInt(d3, this.X);
            bundle.putInt(j3, this.Y);
            bundle.putParcelableArrayList(e3, new ArrayList(Arrays.asList(this.Z)));
            bundle.putParcelableArrayList(k3, g());
            bundle.putIntArray(f3, this.Y2);
            bundle.putLongArray(g3, this.Z2);
            bundle.putLong(h3, this.a3);
            bundle.putBoolean(i3, this.b3);
            return bundle;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AdGroup.class != obj.getClass()) {
                return false;
            }
            AdGroup adGroup = (AdGroup) obj;
            return this.s == adGroup.s && this.X == adGroup.X && this.Y == adGroup.Y && Arrays.equals(this.X2, adGroup.X2) && Arrays.equals(this.Y2, adGroup.Y2) && Arrays.equals(this.Z2, adGroup.Z2) && this.a3 == adGroup.a3 && this.b3 == adGroup.b3;
        }

        public int f() {
            return i(-1);
        }

        public int hashCode() {
            long j2 = this.s;
            long j4 = this.a3;
            return (((((((((((((this.X * 31) + this.Y) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.X2)) * 31) + Arrays.hashCode(this.Y2)) * 31) + Arrays.hashCode(this.Z2)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.b3 ? 1 : 0);
        }

        public int i(@IntRange(from = -1) int i2) {
            int i4;
            int i5 = i2 + 1;
            while (true) {
                int[] iArr = this.Y2;
                if (i5 >= iArr.length || this.b3 || (i4 = iArr[i5]) == 0 || i4 == 1) {
                    return i5;
                }
                i5++;
            }
            return i5;
        }

        public boolean j() {
            if (this.X == -1) {
                return true;
            }
            for (int i2 = 0; i2 < this.X; i2++) {
                int i4 = this.Y2[i2];
                if (i4 == 0 || i4 == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean l() {
            return this.X == -1 || f() < this.X;
        }

        @CheckResult
        public AdGroup m(int i2) {
            int[] d2 = d(this.Y2, i2);
            long[] c2 = c(this.Z2, i2);
            return new AdGroup(this.s, i2, this.Y, d2, (MediaItem[]) Arrays.copyOf(this.X2, i2), c2, this.a3, this.b3);
        }

        @CheckResult
        public AdGroup n(long[] jArr) {
            int length = jArr.length;
            MediaItem[] mediaItemArr = this.X2;
            if (length < mediaItemArr.length) {
                jArr = c(jArr, mediaItemArr.length);
            } else if (this.X != -1 && jArr.length > mediaItemArr.length) {
                jArr = Arrays.copyOf(jArr, mediaItemArr.length);
            }
            return new AdGroup(this.s, this.X, this.Y, this.Y2, this.X2, jArr, this.a3, this.b3);
        }

        @CheckResult
        public AdGroup o(MediaItem mediaItem, @IntRange(from = 0) int i2) {
            int[] d2 = d(this.Y2, i2 + 1);
            long[] jArr = this.Z2;
            if (jArr.length != d2.length) {
                jArr = c(jArr, d2.length);
            }
            long[] jArr2 = jArr;
            MediaItem[] mediaItemArr = (MediaItem[]) Arrays.copyOf(this.X2, d2.length);
            mediaItemArr[i2] = mediaItem;
            d2[i2] = 1;
            return new AdGroup(this.s, this.X, this.Y, d2, mediaItemArr, jArr2, this.a3, this.b3);
        }

        @CheckResult
        public AdGroup p(int i2, @IntRange(from = 0) int i4) {
            int i5 = i2;
            int i6 = i4;
            int i7 = this.X;
            boolean z = false;
            Assertions.a(i7 == -1 || i6 < i7);
            int[] d2 = d(this.Y2, i6 + 1);
            int i8 = d2[i6];
            if (i8 == 0 || i8 == 1 || i8 == i5) {
                z = true;
            }
            Assertions.a(z);
            long[] jArr = this.Z2;
            if (jArr.length != d2.length) {
                jArr = c(jArr, d2.length);
            }
            long[] jArr2 = jArr;
            MediaItem[] mediaItemArr = this.X2;
            if (mediaItemArr.length != d2.length) {
                mediaItemArr = (MediaItem[]) Arrays.copyOf(mediaItemArr, d2.length);
            }
            MediaItem[] mediaItemArr2 = mediaItemArr;
            d2[i6] = i5;
            return new AdGroup(this.s, this.X, this.Y, d2, mediaItemArr2, jArr2, this.a3, this.b3);
        }

        @CheckResult
        @Deprecated
        public AdGroup q(Uri uri, @IntRange(from = 0) int i2) {
            return o(MediaItem.d(uri), i2);
        }

        @CheckResult
        public AdGroup r() {
            if (this.X == -1) {
                return this;
            }
            int[] iArr = this.Y2;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i2 = 0; i2 < length; i2++) {
                int i4 = copyOf[i2];
                if (i4 == 3 || i4 == 2 || i4 == 4) {
                    copyOf[i2] = this.X2[i2] == null ? 0 : 1;
                }
            }
            return new AdGroup(this.s, length, this.Y, copyOf, this.X2, this.Z2, this.a3, this.b3);
        }

        @CheckResult
        public AdGroup s() {
            if (this.X == -1) {
                return new AdGroup(this.s, 0, this.Y, new int[0], new MediaItem[0], new long[0], this.a3, this.b3);
            }
            int[] iArr = this.Y2;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i2 = 0; i2 < length; i2++) {
                int i4 = copyOf[i2];
                if (i4 == 1 || i4 == 0) {
                    copyOf[i2] = 2;
                }
            }
            return new AdGroup(this.s, length, this.Y, copyOf, this.X2, this.Z2, this.a3, this.b3);
        }

        @CheckResult
        public AdGroup t(long j2) {
            return new AdGroup(this.s, this.X, this.Y, this.Y2, this.X2, this.Z2, j2, this.b3);
        }

        @CheckResult
        public AdGroup u(boolean z) {
            return new AdGroup(this.s, this.X, this.Y, this.Y2, this.X2, this.Z2, this.a3, z);
        }

        public AdGroup v() {
            int[] iArr = this.Y2;
            int length = iArr.length - 1;
            int[] copyOf = Arrays.copyOf(iArr, length);
            MediaItem[] mediaItemArr = (MediaItem[]) Arrays.copyOf(this.X2, length);
            long[] jArr = this.Z2;
            if (jArr.length > length) {
                jArr = Arrays.copyOf(jArr, length);
            }
            long[] jArr2 = jArr;
            return new AdGroup(this.s, length, this.Y, copyOf, mediaItemArr, jArr2, Util.u2(jArr2), this.b3);
        }

        public AdGroup w(int i2) {
            return new AdGroup(this.s, this.X, i2, this.Y2, this.X2, this.Z2, this.a3, this.b3);
        }

        @CheckResult
        public AdGroup x(long j2) {
            return new AdGroup(j2, this.X, this.Y, this.Y2, this.X2, this.Z2, this.a3, this.b3);
        }

        private AdGroup(long j2, int i2, int i4, int[] iArr, MediaItem[] mediaItemArr, long[] jArr, long j4, boolean z) {
            int i5 = 0;
            Assertions.a(iArr.length == mediaItemArr.length);
            this.s = j2;
            this.X = i2;
            this.Y = i4;
            this.Y2 = iArr;
            this.X2 = mediaItemArr;
            this.Z2 = jArr;
            this.a3 = j4;
            this.b3 = z;
            this.Z = new Uri[mediaItemArr.length];
            while (true) {
                Uri[] uriArr = this.Z;
                if (i5 < uriArr.length) {
                    MediaItem mediaItem = mediaItemArr[i5];
                    uriArr[i5] = mediaItem == null ? null : ((MediaItem.LocalConfiguration) Assertions.g(mediaItem.X)).s;
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public AdPlaybackState(Object obj, long... jArr) {
        this(obj, b(jArr), 0, C.f9084b, 0);
    }

    private static AdGroup[] b(long[] jArr) {
        int length = jArr.length;
        AdGroup[] adGroupArr = new AdGroup[length];
        for (int i2 = 0; i2 < length; i2++) {
            adGroupArr[i2] = new AdGroup(jArr[i2]);
        }
        return adGroupArr;
    }

    public static AdPlaybackState d(Object obj, AdPlaybackState adPlaybackState) {
        AdPlaybackState adPlaybackState2 = adPlaybackState;
        int i2 = adPlaybackState2.X - adPlaybackState2.X2;
        AdGroup[] adGroupArr = new AdGroup[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            AdGroup adGroup = adPlaybackState2.Y2[i4];
            long j2 = adGroup.s;
            int i5 = adGroup.X;
            int i6 = adGroup.Y;
            int[] iArr = adGroup.Y2;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            MediaItem[] mediaItemArr = adGroup.X2;
            long[] jArr = adGroup.Z2;
            adGroupArr[i4] = new AdGroup(j2, i5, i6, copyOf, (MediaItem[]) Arrays.copyOf(mediaItemArr, mediaItemArr.length), Arrays.copyOf(jArr, jArr.length), adGroup.a3, adGroup.b3);
        }
        return new AdPlaybackState(obj, adGroupArr, adPlaybackState2.Y, adPlaybackState2.Z, adPlaybackState2.X2);
    }

    public static AdPlaybackState e(Bundle bundle) {
        AdGroup[] adGroupArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(g3);
        if (parcelableArrayList == null) {
            adGroupArr = new AdGroup[0];
        } else {
            AdGroup[] adGroupArr2 = new AdGroup[parcelableArrayList.size()];
            for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
                adGroupArr2[i2] = AdGroup.e((Bundle) parcelableArrayList.get(i2));
            }
            adGroupArr = adGroupArr2;
        }
        String str = h3;
        AdPlaybackState adPlaybackState = e3;
        return new AdPlaybackState((Object) null, adGroupArr, bundle.getLong(str, adPlaybackState.Y), bundle.getLong(i3, adPlaybackState.Z), bundle.getInt(j3, adPlaybackState.X2));
    }

    private boolean k(long j2, long j4, int i2) {
        if (j2 == Long.MIN_VALUE) {
            return false;
        }
        AdGroup f2 = f(i2);
        long j5 = f2.s;
        return j5 == Long.MIN_VALUE ? j4 == C.f9084b || (f2.b3 && f2.X == -1) || j2 < j4 : j2 < j5;
    }

    @CheckResult
    public AdPlaybackState A(@IntRange(from = 0) int i2, int i4) {
        int i5 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        if (adGroupArr[i5].Y == i4) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = adGroupArr2[i5].w(i4);
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState B(@IntRange(from = 0) int i2, @IntRange(from = 0) int i4) {
        int i5 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = adGroupArr2[i5].p(3, i4);
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState C(@IntRange(from = 0) int i2) {
        int i4 = this.X2;
        if (i4 == i2) {
            return this;
        }
        Assertions.a(i2 > i4);
        int i5 = this.X - i2;
        AdGroup[] adGroupArr = new AdGroup[i5];
        System.arraycopy(this.Y2, i2 - this.X2, adGroupArr, 0, i5);
        return new AdPlaybackState(this.s, adGroupArr, this.Y, this.Z, i2);
    }

    @CheckResult
    public AdPlaybackState D(@IntRange(from = 0) int i2) {
        int i4 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].r();
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState E(@IntRange(from = 0) int i2, @IntRange(from = 0) int i4) {
        int i5 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = adGroupArr2[i5].p(2, i4);
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState F(@IntRange(from = 0) int i2) {
        int i4 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].s();
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (AdGroup a2 : this.Y2) {
            arrayList.add(a2.a());
        }
        if (!arrayList.isEmpty()) {
            bundle.putParcelableArrayList(g3, arrayList);
        }
        long j2 = this.Y;
        AdPlaybackState adPlaybackState = e3;
        if (j2 != adPlaybackState.Y) {
            bundle.putLong(h3, j2);
        }
        long j4 = this.Z;
        if (j4 != adPlaybackState.Z) {
            bundle.putLong(i3, j4);
        }
        int i2 = this.X2;
        if (i2 != adPlaybackState.X2) {
            bundle.putInt(j3, i2);
        }
        return bundle;
    }

    public boolean c() {
        int i2 = this.X - 1;
        return i2 >= 0 && j(i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AdPlaybackState.class != obj.getClass()) {
            return false;
        }
        AdPlaybackState adPlaybackState = (AdPlaybackState) obj;
        return Util.g(this.s, adPlaybackState.s) && this.X == adPlaybackState.X && this.Y == adPlaybackState.Y && this.Z == adPlaybackState.Z && this.X2 == adPlaybackState.X2 && Arrays.equals(this.Y2, adPlaybackState.Y2);
    }

    public AdGroup f(@IntRange(from = 0) int i2) {
        int i4 = this.X2;
        return i2 < i4 ? f3 : this.Y2[i2 - i4];
    }

    public int g(long j2, long j4) {
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        if (j4 != C.f9084b && j2 >= j4) {
            return -1;
        }
        int i2 = this.X2;
        while (i2 < this.X && ((f(i2).s != Long.MIN_VALUE && f(i2).s <= j2) || !f(i2).l())) {
            i2++;
        }
        if (i2 < this.X) {
            return i2;
        }
        return -1;
    }

    public int h(long j2, long j4) {
        int i2 = this.X - 1;
        int i4 = i2 - (j(i2) ? 1 : 0);
        while (i4 >= 0 && k(j2, j4, i4)) {
            i4--;
        }
        if (i4 < 0 || !f(i4).j()) {
            return -1;
        }
        return i4;
    }

    public int hashCode() {
        int i2 = this.X * 31;
        Object obj = this.s;
        return ((((((((i2 + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.Y)) * 31) + ((int) this.Z)) * 31) + this.X2) * 31) + Arrays.hashCode(this.Y2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r4 = f(r4);
        r0 = r4.X;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i(@androidx.annotation.IntRange(from = 0) int r4, @androidx.annotation.IntRange(from = 0) int r5) {
        /*
            r3 = this;
            int r0 = r3.X
            r1 = 0
            if (r4 < r0) goto L_0x0006
            return r1
        L_0x0006:
            androidx.media3.common.AdPlaybackState$AdGroup r4 = r3.f(r4)
            int r0 = r4.X
            r2 = -1
            if (r0 == r2) goto L_0x001a
            if (r5 < r0) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            int[] r4 = r4.Y2
            r4 = r4[r5]
            r5 = 4
            if (r4 != r5) goto L_0x001a
            r1 = 1
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.AdPlaybackState.i(int, int):boolean");
    }

    public boolean j(int i2) {
        return i2 == this.X - 1 && f(i2).k();
    }

    @CheckResult
    public AdPlaybackState l(@IntRange(from = 0) int i2, @IntRange(from = 1) int i4) {
        Assertions.a(i4 > 0);
        int i5 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        if (adGroupArr[i5].X == i4) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = this.Y2[i5].m(i4);
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState m(@IntRange(from = 0) int i2, long... jArr) {
        int i4 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].n(jArr);
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState n(long[][] jArr) {
        Assertions.i(this.X2 == 0);
        AdGroup[] adGroupArr = this.Y2;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        for (int i2 = 0; i2 < this.X; i2++) {
            adGroupArr2[i2] = adGroupArr2[i2].n(jArr[i2]);
        }
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState o(@IntRange(from = 0) int i2, long j2) {
        int i4 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = this.Y2[i4].x(j2);
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState p(@IntRange(from = 0) int i2, @IntRange(from = 0) int i4) {
        int i5 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i5] = adGroupArr2[i5].p(4, i4);
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState q(long j2) {
        if (this.Y == j2) {
            return this;
        }
        return new AdPlaybackState(this.s, this.Y2, j2, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState r(@IntRange(from = 0) int i2, @IntRange(from = 0) int i4) {
        return s(i2, i4, MediaItem.d(Uri.EMPTY));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r0 = r12.X;
     */
    @androidx.annotation.CheckResult
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.common.AdPlaybackState s(@androidx.annotation.IntRange(from = 0) int r10, @androidx.annotation.IntRange(from = 0) int r11, androidx.media3.common.MediaItem r12) {
        /*
            r9 = this;
            int r0 = r9.X2
            int r10 = r10 - r0
            androidx.media3.common.AdPlaybackState$AdGroup[] r0 = r9.Y2
            int r1 = r0.length
            java.lang.Object[] r0 = androidx.media3.common.util.Util.O1(r0, r1)
            r3 = r0
            androidx.media3.common.AdPlaybackState$AdGroup[] r3 = (androidx.media3.common.AdPlaybackState.AdGroup[]) r3
            r0 = r3[r10]
            boolean r0 = r0.b3
            if (r0 != 0) goto L_0x0024
            androidx.media3.common.MediaItem$LocalConfiguration r0 = r12.X
            if (r0 == 0) goto L_0x0022
            android.net.Uri r0 = r0.s
            android.net.Uri r1 = android.net.Uri.EMPTY
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r0 = 0
            goto L_0x0025
        L_0x0024:
            r0 = 1
        L_0x0025:
            androidx.media3.common.util.Assertions.i(r0)
            r0 = r3[r10]
            androidx.media3.common.AdPlaybackState$AdGroup r11 = r0.o(r12, r11)
            r3[r10] = r11
            androidx.media3.common.AdPlaybackState r10 = new androidx.media3.common.AdPlaybackState
            java.lang.Object r2 = r9.s
            long r4 = r9.Y
            long r6 = r9.Z
            int r8 = r9.X2
            r1 = r10
            r1.<init>(r2, r3, r4, r6, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.AdPlaybackState.s(int, int, androidx.media3.common.MediaItem):androidx.media3.common.AdPlaybackState");
    }

    @CheckResult
    @Deprecated
    public AdPlaybackState t(@IntRange(from = 0) int i2, @IntRange(from = 0) int i4, Uri uri) {
        return s(i2, i4, MediaItem.d(uri));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adsId=");
        sb.append(this.s);
        sb.append(", adResumePositionUs=");
        sb.append(this.Y);
        sb.append(", adGroups=[");
        for (int i2 = 0; i2 < this.Y2.length; i2++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.Y2[i2].s);
            sb.append(", ads=[");
            for (int i4 = 0; i4 < this.Y2[i2].Y2.length; i4++) {
                sb.append("ad(state=");
                int i5 = this.Y2[i2].Y2[i4];
                sb.append(i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? '?' : '!' : 'P' : 'S' : ASCIIPropertyListParser.y : '_');
                sb.append(", durationUs=");
                sb.append(this.Y2[i2].Z2[i4]);
                sb.append(ASCIIPropertyListParser.f18650h);
                if (i4 < this.Y2[i2].Y2.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < this.Y2.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }

    @CheckResult
    public AdPlaybackState u(long j2) {
        if (this.Z == j2) {
            return this;
        }
        return new AdPlaybackState(this.s, this.Y2, this.Y, j2, this.X2);
    }

    @CheckResult
    public AdPlaybackState v(@IntRange(from = 0) int i2, long j2) {
        int i4 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        if (adGroupArr[i4].a3 == j2) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].t(j2);
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState w(@IntRange(from = 0) int i2, boolean z) {
        int i4 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        if (adGroupArr[i4].b3 == z) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].u(z);
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    @CheckResult
    public AdPlaybackState x(@IntRange(from = 0) int i2) {
        int i4 = i2 - this.X2;
        AdGroup[] adGroupArr = this.Y2;
        AdGroup[] adGroupArr2 = (AdGroup[]) Util.O1(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].v();
        return new AdPlaybackState(this.s, adGroupArr2, this.Y, this.Z, this.X2);
    }

    public AdPlaybackState y() {
        return z(this.X, Long.MIN_VALUE).w(this.X, true);
    }

    @CheckResult
    public AdPlaybackState z(@IntRange(from = 0) int i2, long j2) {
        int i4 = i2 - this.X2;
        AdGroup adGroup = new AdGroup(j2);
        AdGroup[] adGroupArr = (AdGroup[]) Util.M1(this.Y2, adGroup);
        System.arraycopy(adGroupArr, i4, adGroupArr, i4 + 1, this.Y2.length - i4);
        adGroupArr[i4] = adGroup;
        return new AdPlaybackState(this.s, adGroupArr, this.Y, this.Z, this.X2);
    }

    private AdPlaybackState(@Nullable Object obj, AdGroup[] adGroupArr, long j2, long j4, int i2) {
        this.s = obj;
        this.Y = j2;
        this.Z = j4;
        this.X = adGroupArr.length + i2;
        this.Y2 = adGroupArr;
        this.X2 = i2;
    }
}

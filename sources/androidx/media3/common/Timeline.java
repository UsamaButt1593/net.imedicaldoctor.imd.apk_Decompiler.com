package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.Bundleable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.BundleUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.util.ArrayList;

public abstract class Timeline implements Bundleable {
    private static final String X = Util.d1(0);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<Timeline> X2 = new j1();
    private static final String Y = Util.d1(1);
    private static final String Z = Util.d1(2);
    public static final Timeline s = new Timeline() {
        public int g(Object obj) {
            return -1;
        }

        public Period l(int i2, Period period, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        public int n() {
            return 0;
        }

        public Object t(int i2) {
            throw new IndexOutOfBoundsException();
        }

        public Window v(int i2, Window window, long j2) {
            throw new IndexOutOfBoundsException();
        }

        public int w() {
            return 0;
        }
    };

    public static final class Period implements Bundleable {
        private static final String a3 = Util.d1(0);
        private static final String b3 = Util.d1(1);
        private static final String c3 = Util.d1(2);
        private static final String d3 = Util.d1(3);
        private static final String e3 = Util.d1(4);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<Period> f3 = new k1();
        @Nullable
        public Object X;
        @UnstableApi
        public long X2;
        public int Y;
        public boolean Y2;
        @UnstableApi
        public long Z;
        /* access modifiers changed from: private */
        public AdPlaybackState Z2 = AdPlaybackState.e3;
        @Nullable
        public Object s;

        @UnstableApi
        public static Period c(Bundle bundle) {
            int i2 = bundle.getInt(a3, 0);
            long j2 = bundle.getLong(b3, C.f9084b);
            long j3 = bundle.getLong(c3, 0);
            boolean z = bundle.getBoolean(d3, false);
            Bundle bundle2 = bundle.getBundle(e3);
            AdPlaybackState e2 = bundle2 != null ? AdPlaybackState.e(bundle2) : AdPlaybackState.e3;
            Period period = new Period();
            period.y((Object) null, (Object) null, i2, j2, j3, e2, z);
            return period;
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            int i2 = this.Y;
            if (i2 != 0) {
                bundle.putInt(a3, i2);
            }
            long j2 = this.Z;
            if (j2 != C.f9084b) {
                bundle.putLong(b3, j2);
            }
            long j3 = this.X2;
            if (j3 != 0) {
                bundle.putLong(c3, j3);
            }
            boolean z = this.Y2;
            if (z) {
                bundle.putBoolean(d3, z);
            }
            if (!this.Z2.equals(AdPlaybackState.e3)) {
                bundle.putBundle(e3, this.Z2.a());
            }
            return bundle;
        }

        public int d(int i2) {
            return this.Z2.f(i2).X;
        }

        public long e(int i2, int i3) {
            AdPlaybackState.AdGroup f2 = this.Z2.f(i2);
            return f2.X != -1 ? f2.Z2[i3] : C.f9084b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (Period.class.equals(obj.getClass())) {
                    Period period = (Period) obj;
                    return Util.g(this.s, period.s) && Util.g(this.X, period.X) && this.Y == period.Y && this.Z == period.Z && this.X2 == period.X2 && this.Y2 == period.Y2 && Util.g(this.Z2, period.Z2);
                }
            }
            return false;
        }

        public int f() {
            return this.Z2.X;
        }

        public int g(long j2) {
            return this.Z2.g(j2, this.Z);
        }

        public int h(long j2) {
            return this.Z2.h(j2, this.Z);
        }

        public int hashCode() {
            Object obj = this.s;
            int i2 = 0;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.X;
            if (obj2 != null) {
                i2 = obj2.hashCode();
            }
            long j2 = this.Z;
            long j3 = this.X2;
            return ((((((((((hashCode + i2) * 31) + this.Y) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.Y2 ? 1 : 0)) * 31) + this.Z2.hashCode();
        }

        public long i(int i2) {
            return this.Z2.f(i2).s;
        }

        public long j() {
            return this.Z2.Y;
        }

        @UnstableApi
        public int k(int i2, int i3) {
            AdPlaybackState.AdGroup f2 = this.Z2.f(i2);
            if (f2.X != -1) {
                return f2.Y2[i3];
            }
            return 0;
        }

        @Nullable
        public Object l() {
            return this.Z2.s;
        }

        @UnstableApi
        public long m(int i2) {
            return this.Z2.f(i2).a3;
        }

        public long n() {
            return Util.H2(this.Z);
        }

        public long o() {
            return this.Z;
        }

        public int p(int i2) {
            return this.Z2.f(i2).f();
        }

        public int q(int i2, int i3) {
            return this.Z2.f(i2).i(i3);
        }

        public long r() {
            return Util.H2(this.X2);
        }

        public long s() {
            return this.X2;
        }

        public int t() {
            return this.Z2.X2;
        }

        public boolean u(int i2) {
            return !this.Z2.f(i2).j();
        }

        @UnstableApi
        public boolean v(int i2) {
            return i2 == f() - 1 && this.Z2.j(i2);
        }

        @UnstableApi
        public boolean w(int i2) {
            return this.Z2.f(i2).b3;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Period x(@Nullable Object obj, @Nullable Object obj2, int i2, long j2, long j3) {
            return y(obj, obj2, i2, j2, j3, AdPlaybackState.e3, false);
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Period y(@Nullable Object obj, @Nullable Object obj2, int i2, long j2, long j3, AdPlaybackState adPlaybackState, boolean z) {
            this.s = obj;
            this.X = obj2;
            this.Y = i2;
            this.Z = j2;
            this.X2 = j3;
            this.Z2 = adPlaybackState;
            this.Y2 = z;
            return this;
        }
    }

    @UnstableApi
    public static final class RemotableTimeline extends Timeline {
        private final ImmutableList<Window> Y2;
        private final ImmutableList<Period> Z2;
        private final int[] a3;
        private final int[] b3;

        public RemotableTimeline(ImmutableList<Window> immutableList, ImmutableList<Period> immutableList2, int[] iArr) {
            Assertions.a(immutableList.size() == iArr.length);
            this.Y2 = immutableList;
            this.Z2 = immutableList2;
            this.a3 = iArr;
            this.b3 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                this.b3[iArr[i2]] = i2;
            }
        }

        public int f(boolean z) {
            if (x()) {
                return -1;
            }
            if (z) {
                return this.a3[0];
            }
            return 0;
        }

        public int g(Object obj) {
            throw new UnsupportedOperationException();
        }

        public int h(boolean z) {
            if (x()) {
                return -1;
            }
            return z ? this.a3[w() - 1] : w() - 1;
        }

        public int j(int i2, int i3, boolean z) {
            if (i3 == 1) {
                return i2;
            }
            if (i2 != h(z)) {
                return z ? this.a3[this.b3[i2] + 1] : i2 + 1;
            }
            if (i3 == 2) {
                return f(z);
            }
            return -1;
        }

        public Period l(int i2, Period period, boolean z) {
            Period period2 = this.Z2.get(i2);
            period.y(period2.s, period2.X, period2.Y, period2.Z, period2.X2, period2.Z2, period2.Y2);
            return period;
        }

        public int n() {
            return this.Z2.size();
        }

        public int s(int i2, int i3, boolean z) {
            if (i3 == 1) {
                return i2;
            }
            if (i2 != f(z)) {
                return z ? this.a3[this.b3[i2] - 1] : i2 - 1;
            }
            if (i3 == 2) {
                return h(z);
            }
            return -1;
        }

        public Object t(int i2) {
            throw new UnsupportedOperationException();
        }

        public Window v(int i2, Window window, long j2) {
            Window window2 = window;
            Window window3 = this.Y2.get(i2);
            Object obj = window3.s;
            MediaItem mediaItem = window3.Y;
            MediaItem mediaItem2 = mediaItem;
            Window window4 = window3;
            Window window5 = window;
            window5.k(obj, mediaItem2, window3.Z, window3.X2, window3.Y2, window3.Z2, window3.a3, window3.b3, window3.d3, window3.f3, window4.g3, window4.h3, window4.i3, window4.j3);
            Window window6 = window;
            window6.e3 = window4.e3;
            return window6;
        }

        public int w() {
            return this.Y2.size();
        }
    }

    public static final class Window implements Bundleable {
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<Window> A3 = new l1();
        public static final Object k3 = new Object();
        private static final Object l3 = new Object();
        private static final MediaItem m3 = new MediaItem.Builder().E("androidx.media3.common.Timeline").M(Uri.EMPTY).a();
        private static final String n3 = Util.d1(1);
        private static final String o3 = Util.d1(2);
        private static final String p3 = Util.d1(3);
        private static final String q3 = Util.d1(4);
        private static final String r3 = Util.d1(5);
        private static final String s3 = Util.d1(6);
        private static final String t3 = Util.d1(7);
        private static final String u3 = Util.d1(8);
        private static final String v3 = Util.d1(9);
        private static final String w3 = Util.d1(10);
        private static final String x3 = Util.d1(11);
        private static final String y3 = Util.d1(12);
        private static final String z3 = Util.d1(13);
        @UnstableApi
        @Deprecated
        @Nullable
        public Object X;
        public long X2;
        public MediaItem Y = m3;
        public long Y2;
        @Nullable
        public Object Z;
        public long Z2;
        public boolean a3;
        public boolean b3;
        @UnstableApi
        @Deprecated
        public boolean c3;
        @Nullable
        public MediaItem.LiveConfiguration d3;
        public boolean e3;
        @UnstableApi
        public long f3;
        @UnstableApi
        public long g3;
        public int h3;
        public int i3;
        @UnstableApi
        public long j3;
        public Object s = k3;

        @UnstableApi
        public static Window b(Bundle bundle) {
            Bundle bundle2 = bundle;
            Bundle bundle3 = bundle2.getBundle(n3);
            MediaItem c2 = bundle3 != null ? MediaItem.c(bundle3) : MediaItem.c3;
            long j2 = bundle2.getLong(o3, C.f9084b);
            long j4 = bundle2.getLong(p3, C.f9084b);
            long j5 = bundle2.getLong(q3, C.f9084b);
            boolean z = bundle2.getBoolean(r3, false);
            boolean z2 = bundle2.getBoolean(s3, false);
            Bundle bundle4 = bundle2.getBundle(t3);
            MediaItem.LiveConfiguration c4 = bundle4 != null ? MediaItem.LiveConfiguration.c(bundle4) : null;
            boolean z4 = bundle2.getBoolean(u3, false);
            long j6 = bundle2.getLong(v3, 0);
            long j7 = bundle2.getLong(w3, C.f9084b);
            int i2 = bundle2.getInt(x3, 0);
            int i4 = bundle2.getInt(y3, 0);
            long j8 = bundle2.getLong(z3, 0);
            Window window = r0;
            Window window2 = new Window();
            window.k(l3, c2, (Object) null, j2, j4, j5, z, z2, c4, j6, j7, i2, i4, j8);
            window2.e3 = z4;
            return window2;
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            if (!MediaItem.c3.equals(this.Y)) {
                bundle.putBundle(n3, this.Y.a());
            }
            long j2 = this.X2;
            if (j2 != C.f9084b) {
                bundle.putLong(o3, j2);
            }
            long j4 = this.Y2;
            if (j4 != C.f9084b) {
                bundle.putLong(p3, j4);
            }
            long j5 = this.Z2;
            if (j5 != C.f9084b) {
                bundle.putLong(q3, j5);
            }
            boolean z = this.a3;
            if (z) {
                bundle.putBoolean(r3, z);
            }
            boolean z2 = this.b3;
            if (z2) {
                bundle.putBoolean(s3, z2);
            }
            MediaItem.LiveConfiguration liveConfiguration = this.d3;
            if (liveConfiguration != null) {
                bundle.putBundle(t3, liveConfiguration.a());
            }
            boolean z4 = this.e3;
            if (z4) {
                bundle.putBoolean(u3, z4);
            }
            long j6 = this.f3;
            if (j6 != 0) {
                bundle.putLong(v3, j6);
            }
            long j7 = this.g3;
            if (j7 != C.f9084b) {
                bundle.putLong(w3, j7);
            }
            int i2 = this.h3;
            if (i2 != 0) {
                bundle.putInt(x3, i2);
            }
            int i4 = this.i3;
            if (i4 != 0) {
                bundle.putInt(y3, i4);
            }
            long j8 = this.j3;
            if (j8 != 0) {
                bundle.putLong(z3, j8);
            }
            return bundle;
        }

        public long c() {
            return Util.B0(this.Z2);
        }

        public long d() {
            return Util.H2(this.f3);
        }

        public long e() {
            return this.f3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (Window.class.equals(obj.getClass())) {
                    Window window = (Window) obj;
                    return Util.g(this.s, window.s) && Util.g(this.Y, window.Y) && Util.g(this.Z, window.Z) && Util.g(this.d3, window.d3) && this.X2 == window.X2 && this.Y2 == window.Y2 && this.Z2 == window.Z2 && this.a3 == window.a3 && this.b3 == window.b3 && this.e3 == window.e3 && this.f3 == window.f3 && this.g3 == window.g3 && this.h3 == window.h3 && this.i3 == window.i3 && this.j3 == window.j3;
                }
            }
            return false;
        }

        public long f() {
            return Util.H2(this.g3);
        }

        public long g() {
            return this.g3;
        }

        public long h() {
            return Util.H2(this.j3);
        }

        public int hashCode() {
            int hashCode = (((217 + this.s.hashCode()) * 31) + this.Y.hashCode()) * 31;
            Object obj = this.Z;
            int i2 = 0;
            int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            MediaItem.LiveConfiguration liveConfiguration = this.d3;
            if (liveConfiguration != null) {
                i2 = liveConfiguration.hashCode();
            }
            long j2 = this.X2;
            long j4 = this.Y2;
            long j5 = this.Z2;
            long j6 = this.f3;
            long j7 = this.g3;
            long j8 = this.j3;
            return ((((((((((((((((((((((hashCode2 + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + (this.a3 ? 1 : 0)) * 31) + (this.b3 ? 1 : 0)) * 31) + (this.e3 ? 1 : 0)) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.h3) * 31) + this.i3) * 31) + ((int) (j8 ^ (j8 >>> 32)));
        }

        public long i() {
            return this.j3;
        }

        public boolean j() {
            Assertions.i(this.c3 == (this.d3 != null));
            return this.d3 != null;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Window k(Object obj, @Nullable MediaItem mediaItem, @Nullable Object obj2, long j2, long j4, long j5, boolean z, boolean z2, @Nullable MediaItem.LiveConfiguration liveConfiguration, long j6, long j7, int i2, int i4, long j8) {
            MediaItem.LocalConfiguration localConfiguration;
            MediaItem mediaItem2 = mediaItem;
            MediaItem.LiveConfiguration liveConfiguration2 = liveConfiguration;
            this.s = obj;
            this.Y = mediaItem2 != null ? mediaItem2 : m3;
            this.X = (mediaItem2 == null || (localConfiguration = mediaItem2.X) == null) ? null : localConfiguration.b3;
            this.Z = obj2;
            this.X2 = j2;
            this.Y2 = j4;
            this.Z2 = j5;
            this.a3 = z;
            this.b3 = z2;
            this.c3 = liveConfiguration2 != null;
            this.d3 = liveConfiguration2;
            this.f3 = j6;
            this.g3 = j7;
            this.h3 = i2;
            this.i3 = i4;
            this.j3 = j8;
            this.e3 = false;
            return this;
        }
    }

    @UnstableApi
    protected Timeline() {
    }

    @UnstableApi
    public static Timeline c(Bundle bundle) {
        ImmutableList d2 = d(new h1(), BundleUtil.a(bundle, X));
        ImmutableList d3 = d(new i1(), BundleUtil.a(bundle, Y));
        int[] intArray = bundle.getIntArray(Z);
        if (intArray == null) {
            intArray = e(d2.size());
        }
        return new RemotableTimeline(d2, d3, intArray);
    }

    private static <T> ImmutableList<T> d(Function<Bundle, T> function, @Nullable IBinder iBinder) {
        return iBinder == null ? ImmutableList.I() : BundleCollectionUtil.d(function, BundleListRetriever.a(iBinder));
    }

    private static int[] e(int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = i3;
        }
        return iArr;
    }

    @UnstableApi
    public final Bundle a() {
        ArrayList arrayList = new ArrayList();
        int w = w();
        Window window = new Window();
        for (int i2 = 0; i2 < w; i2++) {
            arrayList.add(v(i2, window, 0).a());
        }
        ArrayList arrayList2 = new ArrayList();
        int n2 = n();
        Period period = new Period();
        for (int i3 = 0; i3 < n2; i3++) {
            arrayList2.add(l(i3, period, false).a());
        }
        int[] iArr = new int[w];
        if (w > 0) {
            iArr[0] = f(true);
        }
        for (int i4 = 1; i4 < w; i4++) {
            iArr[i4] = j(iArr[i4 - 1], 0, true);
        }
        Bundle bundle = new Bundle();
        BundleUtil.c(bundle, X, new BundleListRetriever(arrayList));
        BundleUtil.c(bundle, Y, new BundleListRetriever(arrayList2));
        bundle.putIntArray(Z, iArr);
        return bundle;
    }

    @UnstableApi
    public final Timeline b(int i2) {
        if (w() == 1) {
            return this;
        }
        Window v = v(i2, new Window(), 0);
        ImmutableList.Builder r = ImmutableList.r();
        int i3 = v.h3;
        while (true) {
            int i4 = v.i3;
            if (i3 <= i4) {
                Period l2 = l(i3, new Period(), true);
                l2.Y = 0;
                r.g(l2);
                i3++;
            } else {
                v.i3 = i4 - v.h3;
                v.h3 = 0;
                return new RemotableTimeline(ImmutableList.K(v), r.e(), new int[]{0});
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        int h2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.w() != w() || timeline.n() != n()) {
            return false;
        }
        Window window = new Window();
        Period period = new Period();
        Window window2 = new Window();
        Period period2 = new Period();
        for (int i2 = 0; i2 < w(); i2++) {
            if (!u(i2, window).equals(timeline.u(i2, window2))) {
                return false;
            }
        }
        for (int i3 = 0; i3 < n(); i3++) {
            if (!l(i3, period, true).equals(timeline.l(i3, period2, true))) {
                return false;
            }
        }
        int f2 = f(true);
        if (f2 != timeline.f(true) || (h2 = h(true)) != timeline.h(true)) {
            return false;
        }
        while (f2 != h2) {
            int j2 = j(f2, 0, true);
            if (j2 != timeline.j(f2, 0, true)) {
                return false;
            }
            f2 = j2;
        }
        return true;
    }

    public int f(boolean z) {
        return x() ? -1 : 0;
    }

    public abstract int g(Object obj);

    public int h(boolean z) {
        if (x()) {
            return -1;
        }
        return w() - 1;
    }

    public int hashCode() {
        int i2;
        Window window = new Window();
        Period period = new Period();
        int w = 217 + w();
        int i3 = 0;
        while (true) {
            i2 = w * 31;
            if (i3 >= w()) {
                break;
            }
            w = i2 + u(i3, window).hashCode();
            i3++;
        }
        int n2 = i2 + n();
        for (int i4 = 0; i4 < n(); i4++) {
            n2 = (n2 * 31) + l(i4, period, true).hashCode();
        }
        int f2 = f(true);
        while (f2 != -1) {
            n2 = (n2 * 31) + f2;
            f2 = j(f2, 0, true);
        }
        return n2;
    }

    public final int i(int i2, Period period, Window window, int i3, boolean z) {
        int i4 = k(i2, period).Y;
        if (u(i4, window).i3 != i2) {
            return i2 + 1;
        }
        int j2 = j(i4, i3, z);
        if (j2 == -1) {
            return -1;
        }
        return u(j2, window).h3;
    }

    public int j(int i2, int i3, boolean z) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 == 2) {
                return i2 == h(z) ? f(z) : i2 + 1;
            }
            throw new IllegalStateException();
        } else if (i2 == h(z)) {
            return -1;
        } else {
            return i2 + 1;
        }
    }

    public final Period k(int i2, Period period) {
        return l(i2, period, false);
    }

    public abstract Period l(int i2, Period period, boolean z);

    public Period m(Object obj, Period period) {
        return l(g(obj), period, true);
    }

    public abstract int n();

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs)")
    @UnstableApi
    @Deprecated
    public final Pair<Object, Long> o(Window window, Period period, int i2, long j2) {
        return q(window, period, i2, j2);
    }

    @InlineMe(replacement = "this.getPeriodPositionUs(window, period, windowIndex, windowPositionUs, defaultPositionProjectionUs)")
    @UnstableApi
    @Nullable
    @Deprecated
    public final Pair<Object, Long> p(Window window, Period period, int i2, long j2, long j3) {
        return r(window, period, i2, j2, j3);
    }

    public final Pair<Object, Long> q(Window window, Period period, int i2, long j2) {
        return (Pair) Assertions.g(r(window, period, i2, j2, 0));
    }

    @Nullable
    public final Pair<Object, Long> r(Window window, Period period, int i2, long j2, long j3) {
        Assertions.c(i2, 0, w());
        v(i2, window, j3);
        if (j2 == C.f9084b) {
            j2 = window.e();
            if (j2 == C.f9084b) {
                return null;
            }
        }
        int i3 = window.h3;
        k(i3, period);
        while (i3 < window.i3 && period.X2 != j2) {
            int i4 = i3 + 1;
            if (k(i4, period).X2 > j2) {
                break;
            }
            i3 = i4;
        }
        l(i3, period, true);
        long j4 = j2 - period.X2;
        long j5 = period.Z;
        if (j5 != C.f9084b) {
            j4 = Math.min(j4, j5 - 1);
        }
        return Pair.create(Assertions.g(period.X), Long.valueOf(Math.max(0, j4)));
    }

    public int s(int i2, int i3, boolean z) {
        if (i3 != 0) {
            if (i3 == 1) {
                return i2;
            }
            if (i3 == 2) {
                return i2 == f(z) ? h(z) : i2 - 1;
            }
            throw new IllegalStateException();
        } else if (i2 == f(z)) {
            return -1;
        } else {
            return i2 - 1;
        }
    }

    public abstract Object t(int i2);

    public final Window u(int i2, Window window) {
        return v(i2, window, 0);
    }

    public abstract Window v(int i2, Window window, long j2);

    public abstract int w();

    public final boolean x() {
        return w() == 0;
    }

    public final boolean y(int i2, Period period, Window window, int i3, boolean z) {
        return i(i2, period, window, i3, z) == -1;
    }
}

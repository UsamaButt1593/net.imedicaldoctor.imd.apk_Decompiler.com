package androidx.media3.common;

import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Bundleable;
import androidx.media3.common.FlagSet;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public interface Player {
    public static final int A = 0;
    public static final int A0 = 14;
    public static final int B = 1;
    public static final int B0 = 15;
    public static final int C = 2;
    public static final int C0 = 16;
    public static final int D = 3;
    public static final int D0 = 17;
    public static final int E = 0;
    @Deprecated
    public static final int E0 = 18;
    public static final int F = 1;
    public static final int F0 = 18;
    public static final int G = 2;
    @Deprecated
    public static final int G0 = 19;
    public static final int H = 3;
    public static final int H0 = 19;
    public static final int I = 4;
    public static final int I0 = 31;
    public static final int J = 5;
    public static final int J0 = 20;
    public static final int K = 6;
    public static final int K0 = 21;
    public static final int L = 7;
    public static final int L0 = 22;
    public static final int M = 8;
    public static final int M0 = 23;
    public static final int N = 9;
    public static final int N0 = 24;
    public static final int O = 10;
    @Deprecated
    public static final int O0 = 25;
    public static final int P = 11;
    public static final int P0 = 33;
    public static final int Q = 12;
    @Deprecated
    public static final int Q0 = 26;
    public static final int R = 13;
    public static final int R0 = 34;
    public static final int S = 14;
    public static final int S0 = 35;
    public static final int T = 15;
    public static final int T0 = 27;
    public static final int U = 16;
    public static final int U0 = 28;
    public static final int V = 17;
    public static final int V0 = 29;
    public static final int W = 18;
    public static final int W0 = 30;
    public static final int X = 19;
    public static final int X0 = 32;
    public static final int Y = 20;
    public static final int Y0 = -1;
    public static final int Z = 21;

    /* renamed from: a  reason: collision with root package name */
    public static final int f9246a = 1;
    public static final int a0 = 22;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9247b = 2;
    public static final int b0 = 23;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9248c = 3;
    public static final int c0 = 24;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9249d = 4;
    public static final int d0 = 25;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9250e = 1;
    public static final int e0 = 26;

    /* renamed from: f  reason: collision with root package name */
    public static final int f9251f = 2;
    public static final int f0 = 27;

    /* renamed from: g  reason: collision with root package name */
    public static final int f9252g = 3;
    public static final int g0 = 28;

    /* renamed from: h  reason: collision with root package name */
    public static final int f9253h = 4;
    public static final int h0 = 29;

    /* renamed from: i  reason: collision with root package name */
    public static final int f9254i = 5;
    public static final int i0 = 30;

    /* renamed from: j  reason: collision with root package name */
    public static final int f9255j = 6;
    public static final int j0 = 1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f9256k = 0;
    public static final int k0 = 2;

    /* renamed from: l  reason: collision with root package name */
    public static final int f9257l = 1;
    public static final int l0 = 3;
    @Deprecated

    /* renamed from: m  reason: collision with root package name */
    public static final int f9258m = 2;
    public static final int m0 = 4;

    /* renamed from: n  reason: collision with root package name */
    public static final int f9259n = 3;
    public static final int n0 = 5;
    public static final int o = 0;
    @UnstableApi
    @Deprecated
    public static final int o0 = 5;
    public static final int p = 1;
    public static final int p0 = 6;
    public static final int q = 2;
    @UnstableApi
    @Deprecated
    public static final int q0 = 6;
    public static final int r = 0;
    public static final int r0 = 7;
    public static final int s = 1;
    public static final int s0 = 8;
    public static final int t = 2;
    @UnstableApi
    @Deprecated
    public static final int t0 = 8;
    public static final int u = 3;
    public static final int u0 = 9;
    public static final int v = 4;
    public static final int v0 = 10;
    public static final int w = 5;
    @UnstableApi
    @Deprecated
    public static final int w0 = 10;
    public static final int x = 6;
    public static final int x0 = 11;
    public static final int y = 0;
    public static final int y0 = 12;
    public static final int z = 1;
    public static final int z0 = 13;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Command {
    }

    public static final class Commands implements Bundleable {
        public static final Commands X = new Builder().f();
        private static final String Y = Util.d1(0);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<Commands> Z = new K();
        /* access modifiers changed from: private */
        public final FlagSet s;

        @UnstableApi
        public static final class Builder {

            /* renamed from: b  reason: collision with root package name */
            private static final int[] f9260b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 31, 20, 21, 22, 23, 24, 25, 33, 26, 34, 35, 27, 28, 29, 30, 32};

            /* renamed from: a  reason: collision with root package name */
            private final FlagSet.Builder f9261a;

            public Builder() {
                this.f9261a = new FlagSet.Builder();
            }

            @CanIgnoreReturnValue
            public Builder a(int i2) {
                this.f9261a.a(i2);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder b(Commands commands) {
                this.f9261a.b(commands.s);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder c(int... iArr) {
                this.f9261a.c(iArr);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder d() {
                this.f9261a.c(f9260b);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder e(int i2, boolean z) {
                this.f9261a.d(i2, z);
                return this;
            }

            public Commands f() {
                return new Commands(this.f9261a.e());
            }

            @CanIgnoreReturnValue
            public Builder g(int i2) {
                this.f9261a.f(i2);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder h(int... iArr) {
                this.f9261a.g(iArr);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder i(int i2, boolean z) {
                this.f9261a.h(i2, z);
                return this;
            }

            private Builder(Commands commands) {
                FlagSet.Builder builder = new FlagSet.Builder();
                this.f9261a = builder;
                builder.b(commands.s);
            }
        }

        private Commands(FlagSet flagSet) {
            this.s = flagSet;
        }

        @UnstableApi
        public static Commands f(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(Y);
            if (integerArrayList == null) {
                return X;
            }
            Builder builder = new Builder();
            for (int i2 = 0; i2 < integerArrayList.size(); i2++) {
                builder.a(integerArrayList.get(i2).intValue());
            }
            return builder.f();
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.s.d(); i2++) {
                arrayList.add(Integer.valueOf(this.s.c(i2)));
            }
            bundle.putIntegerArrayList(Y, arrayList);
            return bundle;
        }

        @UnstableApi
        public Builder c() {
            return new Builder();
        }

        public boolean d(int i2) {
            return this.s.a(i2);
        }

        public boolean e(int... iArr) {
            return this.s.b(iArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Commands)) {
                return false;
            }
            return this.s.equals(((Commands) obj).s);
        }

        public int g(int i2) {
            return this.s.c(i2);
        }

        public int h() {
            return this.s.d();
        }

        public int hashCode() {
            return this.s.hashCode();
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Event {
    }

    public static final class Events {

        /* renamed from: a  reason: collision with root package name */
        private final FlagSet f9262a;

        @UnstableApi
        public Events(FlagSet flagSet) {
            this.f9262a = flagSet;
        }

        public boolean a(int i2) {
            return this.f9262a.a(i2);
        }

        public boolean b(int... iArr) {
            return this.f9262a.b(iArr);
        }

        public int c(int i2) {
            return this.f9262a.c(i2);
        }

        public int d() {
            return this.f9262a.d();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Events)) {
                return false;
            }
            return this.f9262a.equals(((Events) obj).f9262a);
        }

        public int hashCode() {
            return this.f9262a.hashCode();
        }
    }

    public interface Listener {
        void D(int i2);

        @UnstableApi
        @Deprecated
        void E(boolean z);

        @UnstableApi
        @Deprecated
        void F(int i2);

        void H(boolean z);

        void I(Player player, Events events);

        void K(float f2);

        @UnstableApi
        void L(int i2);

        void M(int i2);

        void N(AudioAttributes audioAttributes);

        void S(Timeline timeline, int i2);

        void U(boolean z);

        void W(int i2, boolean z);

        @UnstableApi
        @Deprecated
        void X(boolean z, int i2);

        void Y(long j2);

        void Z(MediaMetadata mediaMetadata);

        void a0(MediaMetadata mediaMetadata);

        void b0(long j2);

        void c(VideoSize videoSize);

        void d0(TrackSelectionParameters trackSelectionParameters);

        void e(boolean z);

        void e0();

        void f0(Tracks tracks);

        void g0(DeviceInfo deviceInfo);

        void h0(@Nullable MediaItem mediaItem, int i2);

        void j0(@Nullable PlaybackException playbackException);

        void k(PlaybackParameters playbackParameters);

        void k0(long j2);

        void l0(boolean z, int i2);

        void p(CueGroup cueGroup);

        void p0(PlaybackException playbackException);

        @UnstableApi
        void q(Metadata metadata);

        @UnstableApi
        @Deprecated
        void s(List<Cue> list);

        void s0(int i2, int i3);

        void t0(Commands commands);

        void u0(PositionInfo positionInfo, PositionInfo positionInfo2, int i2);

        void x(int i2);

        void y0(boolean z);
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaItemTransitionReason {
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayWhenReadyChangeReason {
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackSuppressionReason {
    }

    public static final class PositionInfo implements Bundleable {
        @VisibleForTesting
        static final String d3 = Util.d1(0);
        private static final String e3 = Util.d1(1);
        @VisibleForTesting
        static final String f3 = Util.d1(2);
        @VisibleForTesting
        static final String g3 = Util.d1(3);
        @VisibleForTesting
        static final String h3 = Util.d1(4);
        private static final String i3 = Util.d1(5);
        private static final String j3 = Util.d1(6);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<PositionInfo> k3 = new M();
        @UnstableApi
        @Deprecated
        public final int X;
        @Nullable
        public final Object X2;
        public final int Y;
        public final int Y2;
        @UnstableApi
        @Nullable
        public final MediaItem Z;
        public final long Z2;
        public final long a3;
        public final int b3;
        public final int c3;
        @Nullable
        public final Object s;

        @UnstableApi
        public PositionInfo(@Nullable Object obj, int i2, @Nullable MediaItem mediaItem, @Nullable Object obj2, int i4, long j2, long j4, int i5, int i6) {
            this.s = obj;
            this.X = i2;
            this.Y = i2;
            this.Z = mediaItem;
            this.X2 = obj2;
            this.Y2 = i4;
            this.Z2 = j2;
            this.a3 = j4;
            this.b3 = i5;
            this.c3 = i6;
        }

        @UnstableApi
        public static PositionInfo d(Bundle bundle) {
            int i2 = bundle.getInt(d3, 0);
            Bundle bundle2 = bundle.getBundle(e3);
            return new PositionInfo((Object) null, i2, bundle2 == null ? null : MediaItem.c(bundle2), (Object) null, bundle.getInt(f3, 0), bundle.getLong(g3, 0), bundle.getLong(h3, 0), bundle.getInt(i3, -1), bundle.getInt(j3, -1));
        }

        @UnstableApi
        public Bundle a() {
            return e(Integer.MAX_VALUE);
        }

        @UnstableApi
        public boolean b(PositionInfo positionInfo) {
            return this.Y == positionInfo.Y && this.Y2 == positionInfo.Y2 && this.Z2 == positionInfo.Z2 && this.a3 == positionInfo.a3 && this.b3 == positionInfo.b3 && this.c3 == positionInfo.c3 && Objects.a(this.Z, positionInfo.Z);
        }

        @UnstableApi
        public PositionInfo c(boolean z, boolean z2) {
            if (z && z2) {
                return this;
            }
            Object obj = this.s;
            int i2 = z2 ? this.Y : 0;
            MediaItem mediaItem = z ? this.Z : null;
            Object obj2 = this.X2;
            int i4 = z2 ? this.Y2 : 0;
            long j2 = 0;
            long j4 = z ? this.Z2 : 0;
            if (z) {
                j2 = this.a3;
            }
            return new PositionInfo(obj, i2, mediaItem, obj2, i4, j4, j2, z ? this.b3 : -1, z ? this.c3 : -1);
        }

        @UnstableApi
        public Bundle e(int i2) {
            Bundle bundle = new Bundle();
            if (i2 < 3 || this.Y != 0) {
                bundle.putInt(d3, this.Y);
            }
            MediaItem mediaItem = this.Z;
            if (mediaItem != null) {
                bundle.putBundle(e3, mediaItem.a());
            }
            if (i2 < 3 || this.Y2 != 0) {
                bundle.putInt(f3, this.Y2);
            }
            if (i2 < 3 || this.Z2 != 0) {
                bundle.putLong(g3, this.Z2);
            }
            if (i2 < 3 || this.a3 != 0) {
                bundle.putLong(h3, this.a3);
            }
            int i4 = this.b3;
            if (i4 != -1) {
                bundle.putInt(i3, i4);
            }
            int i5 = this.c3;
            if (i5 != -1) {
                bundle.putInt(j3, i5);
            }
            return bundle;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || PositionInfo.class != obj.getClass()) {
                return false;
            }
            PositionInfo positionInfo = (PositionInfo) obj;
            return b(positionInfo) && Objects.a(this.s, positionInfo.s) && Objects.a(this.X2, positionInfo.X2);
        }

        public int hashCode() {
            return Objects.b(this.s, Integer.valueOf(this.Y), this.Z, this.X2, Integer.valueOf(this.Y2), Long.valueOf(this.Z2), Long.valueOf(this.a3), Integer.valueOf(this.b3), Integer.valueOf(this.c3));
        }

        @UnstableApi
        @Deprecated
        public PositionInfo(@Nullable Object obj, int i2, @Nullable Object obj2, int i4, long j2, long j4, int i5, int i6) {
            this(obj, i2, MediaItem.c3, obj2, i4, j2, j4, i5, i6);
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    void A(AudioAttributes audioAttributes, boolean z2);

    long A0();

    long A2();

    @FloatRange(from = 0.0d, to = 1.0d)
    float B();

    int B0();

    boolean B2();

    DeviceInfo C();

    @UnstableApi
    @Deprecated
    boolean C0();

    void C1(int i2);

    @Deprecated
    void D();

    void D0();

    Tracks D1();

    void E(@Nullable SurfaceView surfaceView);

    void E0();

    void F(int i2, int i3, List<MediaItem> list);

    void F0(List<MediaItem> list, boolean z2);

    void F1(MediaItem mediaItem);

    void G(long j2);

    void H();

    boolean H1();

    void I(@Nullable SurfaceHolder surfaceHolder);

    MediaMetadata I1();

    boolean J1();

    void K0(@IntRange(from = 0) int i2, int i3);

    void K1(MediaItem mediaItem, long j2);

    boolean L0();

    CueGroup M();

    int M1();

    @Deprecated
    void N(boolean z2);

    void N0(int i2);

    void N1(Listener listener);

    void O(@Nullable SurfaceView surfaceView);

    int O0();

    int O1();

    int P1();

    long Q();

    @UnstableApi
    @Deprecated
    void Q0();

    boolean R();

    boolean R1(int i2);

    @UnstableApi
    @Deprecated
    boolean S0();

    @UnstableApi
    Size T0();

    @UnstableApi
    @Deprecated
    int U1();

    @Deprecated
    void V();

    void V0(MediaMetadata mediaMetadata);

    boolean W0();

    @Deprecated
    void X(@IntRange(from = 0) int i2);

    void X1(TrackSelectionParameters trackSelectionParameters);

    void Y(@Nullable TextureView textureView);

    void Y0(int i2);

    void Z(@Nullable SurfaceHolder surfaceHolder);

    int Z0();

    void a();

    @UnstableApi
    @Deprecated
    boolean a1();

    void a2(int i2, int i3);

    @UnstableApi
    @Deprecated
    boolean b2();

    boolean c();

    boolean c0();

    void c1(int i2, int i3);

    void c2(int i2, int i3, int i4);

    AudioAttributes d();

    @UnstableApi
    @Deprecated
    int d1();

    long e0();

    boolean e2();

    void f(PlaybackParameters playbackParameters);

    void f0(int i2, MediaItem mediaItem);

    void f1();

    void f2(Listener listener);

    void g(@FloatRange(from = 0.0d, to = 1.0d) float f2);

    @UnstableApi
    @Deprecated
    boolean g0();

    int g2();

    void h();

    long h0();

    void h1(List<MediaItem> list, int i2, long j2);

    void h2(List<MediaItem> list);

    @UnstableApi
    @Deprecated
    boolean hasNext();

    @UnstableApi
    @Deprecated
    boolean hasPrevious();

    int i();

    void i0(int i2, long j2);

    void i1(boolean z2);

    @Nullable
    PlaybackException j();

    Commands j0();

    Timeline j2();

    void k();

    void k0(boolean z2, int i2);

    void k1(int i2);

    Looper k2();

    long l1();

    void m(@FloatRange(from = 0.0d, fromInclusive = false) float f2);

    boolean m0();

    boolean m2();

    void n0();

    long n1();

    @UnstableApi
    @Deprecated
    void next();

    void o();

    @Nullable
    MediaItem o0();

    TrackSelectionParameters o2();

    void p(int i2);

    void p0(boolean z2);

    @UnstableApi
    @Deprecated
    void p1();

    long p2();

    @UnstableApi
    @Deprecated
    void previous();

    int q();

    void q1(int i2, List<MediaItem> list);

    void q2();

    PlaybackParameters r();

    @UnstableApi
    @Deprecated
    int r1();

    void s2();

    void stop();

    @IntRange(from = 0, to = 100)
    int t0();

    @UnstableApi
    @Nullable
    Object t1();

    @IntRange(from = 0)
    int u();

    long u1();

    void v(@Nullable Surface surface);

    MediaItem v0(int i2);

    void v2();

    void w(@Nullable Surface surface);

    long w0();

    boolean w1();

    void x(int i2, MediaItem mediaItem);

    void x1(MediaItem mediaItem, boolean z2);

    MediaMetadata x2();

    void y(@Nullable TextureView textureView);

    int y0();

    void y1(MediaItem mediaItem);

    void y2(List<MediaItem> list);

    VideoSize z();

    void z1();

    long z2();
}

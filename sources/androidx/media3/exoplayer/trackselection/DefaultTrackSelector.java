package androidx.media3.exoplayer.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.a;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Bundleable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.V0;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import com.google.common.base.Predicate;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@UnstableApi
public class DefaultTrackSelector extends MappingTrackSelector implements RendererCapabilities.Listener {

    /* renamed from: k  reason: collision with root package name */
    private static final String f12371k = "DefaultTrackSelector";

    /* renamed from: l  reason: collision with root package name */
    private static final String f12372l = "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.";

    /* renamed from: m  reason: collision with root package name */
    protected static final int f12373m = 0;

    /* renamed from: n  reason: collision with root package name */
    protected static final int f12374n = 1;
    protected static final int o = 2;
    private static final float p = 0.98f;
    /* access modifiers changed from: private */
    public static final Ordering<Integer> q = Ordering.i(new C0347b());
    /* access modifiers changed from: private */
    public static final Ordering<Integer> r = Ordering.i(new C0349d());

    /* renamed from: d  reason: collision with root package name */
    private final Object f12375d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Context f12376e;

    /* renamed from: f  reason: collision with root package name */
    private final ExoTrackSelection.Factory f12377f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f12378g;
    @GuardedBy("lock")

    /* renamed from: h  reason: collision with root package name */
    private Parameters f12379h;
    @GuardedBy("lock")
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private SpatializerWrapperV32 f12380i;
    @GuardedBy("lock")

    /* renamed from: j  reason: collision with root package name */
    private AudioAttributes f12381j;

    private static final class AudioTrackInfo extends TrackInfo<AudioTrackInfo> implements Comparable<AudioTrackInfo> {
        private final int X2;
        private final boolean Y2;
        @Nullable
        private final String Z2;
        private final Parameters a3;
        private final boolean b3;
        private final int c3;
        private final int d3;
        private final int e3;
        private final boolean f3;
        private final boolean g3;
        private final int h3;
        private final int i3;
        private final boolean j3;
        private final int k3;
        private final int l3;
        private final int m3;
        private final int n3;
        private final boolean o3;
        private final boolean p3;

        public AudioTrackInfo(int i2, TrackGroup trackGroup, int i4, Parameters parameters, int i5, boolean z, Predicate<Format> predicate, int i6) {
            super(i2, trackGroup, i4);
            int i7;
            int i8;
            int i9;
            this.a3 = parameters;
            int i10 = parameters.n4 ? 24 : 16;
            boolean z2 = true;
            this.f3 = parameters.j4 && (i6 & i10) != 0;
            this.Z2 = DefaultTrackSelector.d0(this.Z.Z);
            this.b3 = DefaultTrackSelector.S(i5, false);
            int i11 = 0;
            while (true) {
                i7 = Integer.MAX_VALUE;
                if (i11 >= parameters.g3.size()) {
                    i11 = Integer.MAX_VALUE;
                    i8 = 0;
                    break;
                }
                i8 = DefaultTrackSelector.K(this.Z, parameters.g3.get(i11), false);
                if (i8 > 0) {
                    break;
                }
                i11++;
            }
            this.d3 = i11;
            this.c3 = i8;
            this.e3 = DefaultTrackSelector.O(this.Z.Y2, parameters.h3);
            Format format = this.Z;
            int i12 = format.Y2;
            this.g3 = i12 == 0 || (i12 & 1) != 0;
            this.j3 = (format.X2 & 1) != 0;
            int i13 = format.s3;
            this.k3 = i13;
            this.l3 = format.t3;
            int i14 = format.b3;
            this.m3 = i14;
            this.Y2 = (i14 == -1 || i14 <= parameters.j3) && (i13 == -1 || i13 <= parameters.i3) && predicate.apply(format);
            String[] L0 = Util.L0();
            int i15 = 0;
            while (true) {
                if (i15 >= L0.length) {
                    i15 = Integer.MAX_VALUE;
                    i9 = 0;
                    break;
                }
                i9 = DefaultTrackSelector.K(this.Z, L0[i15], false);
                if (i9 > 0) {
                    break;
                }
                i15++;
            }
            this.h3 = i15;
            this.i3 = i9;
            int i16 = 0;
            while (true) {
                if (i16 < parameters.k3.size()) {
                    String str = this.Z.f3;
                    if (str != null && str.equals(parameters.k3.get(i16))) {
                        i7 = i16;
                        break;
                    }
                    i16++;
                } else {
                    break;
                }
            }
            this.n3 = i7;
            this.o3 = V0.j(i5) == 128;
            this.p3 = V0.l(i5) != 64 ? false : z2;
            this.X2 = g(i5, z, i10);
        }

        public static int c(List<AudioTrackInfo> list, List<AudioTrackInfo> list2) {
            return ((AudioTrackInfo) Collections.max(list)).compareTo((AudioTrackInfo) Collections.max(list2));
        }

        public static ImmutableList<AudioTrackInfo> f(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr, boolean z, Predicate<Format> predicate, int i4) {
            ImmutableList.Builder r = ImmutableList.r();
            TrackGroup trackGroup2 = trackGroup;
            for (int i5 = 0; i5 < trackGroup2.s; i5++) {
                r.g(new AudioTrackInfo(i2, trackGroup, i5, parameters, iArr[i5], z, predicate, i4));
            }
            return r.e();
        }

        private int g(int i2, boolean z, int i4) {
            if (!DefaultTrackSelector.S(i2, this.a3.p4)) {
                return 0;
            }
            if (!this.Y2 && !this.a3.i4) {
                return 0;
            }
            Parameters parameters = this.a3;
            if (parameters.l3.s == 2 && !DefaultTrackSelector.e0(parameters, i2, this.Z)) {
                return 0;
            }
            if (DefaultTrackSelector.S(i2, false) && this.Y2 && this.Z.b3 != -1) {
                Parameters parameters2 = this.a3;
                return (parameters2.s3 || parameters2.r3 || (!parameters2.r4 && z) || parameters2.l3.s == 2 || (i2 & i4) == 0) ? 1 : 2;
            }
        }

        public int a() {
            return this.X2;
        }

        /* renamed from: e */
        public int compareTo(AudioTrackInfo audioTrackInfo) {
            Ordering E = (!this.Y2 || !this.b3) ? DefaultTrackSelector.q.E() : DefaultTrackSelector.q;
            ComparisonChain j2 = ComparisonChain.n().k(this.b3, audioTrackInfo.b3).j(Integer.valueOf(this.d3), Integer.valueOf(audioTrackInfo.d3), Ordering.z().E()).f(this.c3, audioTrackInfo.c3).f(this.e3, audioTrackInfo.e3).k(this.j3, audioTrackInfo.j3).k(this.g3, audioTrackInfo.g3).j(Integer.valueOf(this.h3), Integer.valueOf(audioTrackInfo.h3), Ordering.z().E()).f(this.i3, audioTrackInfo.i3).k(this.Y2, audioTrackInfo.Y2).j(Integer.valueOf(this.n3), Integer.valueOf(audioTrackInfo.n3), Ordering.z().E()).j(Integer.valueOf(this.m3), Integer.valueOf(audioTrackInfo.m3), this.a3.r3 ? DefaultTrackSelector.q.E() : DefaultTrackSelector.r).k(this.o3, audioTrackInfo.o3).k(this.p3, audioTrackInfo.p3).j(Integer.valueOf(this.k3), Integer.valueOf(audioTrackInfo.k3), E).j(Integer.valueOf(this.l3), Integer.valueOf(audioTrackInfo.l3), E);
            Integer valueOf = Integer.valueOf(this.m3);
            Integer valueOf2 = Integer.valueOf(audioTrackInfo.m3);
            if (!Util.g(this.Z2, audioTrackInfo.Z2)) {
                E = DefaultTrackSelector.r;
            }
            return j2.j(valueOf, valueOf2, E).m();
        }

        /* renamed from: h */
        public boolean b(AudioTrackInfo audioTrackInfo) {
            int i2;
            String str;
            int i4;
            if ((this.a3.l4 || ((i4 = this.Z.s3) != -1 && i4 == audioTrackInfo.Z.s3)) && (this.f3 || ((str = this.Z.f3) != null && TextUtils.equals(str, audioTrackInfo.Z.f3)))) {
                Parameters parameters = this.a3;
                if ((parameters.k4 || ((i2 = this.Z.t3) != -1 && i2 == audioTrackInfo.Z.t3)) && (parameters.m4 || (this.o3 == audioTrackInfo.o3 && this.p3 == audioTrackInfo.p3))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class ImageTrackInfo extends TrackInfo<ImageTrackInfo> implements Comparable<ImageTrackInfo> {
        private final int X2;
        private final int Y2 = this.Z.h();

        public ImageTrackInfo(int i2, TrackGroup trackGroup, int i3, Parameters parameters, int i4) {
            super(i2, trackGroup, i3);
            this.X2 = DefaultTrackSelector.S(i4, parameters.p4) ? 1 : 0;
        }

        public static int c(List<ImageTrackInfo> list, List<ImageTrackInfo> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<ImageTrackInfo> f(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr) {
            ImmutableList.Builder r = ImmutableList.r();
            for (int i3 = 0; i3 < trackGroup.s; i3++) {
                r.g(new ImageTrackInfo(i2, trackGroup, i3, parameters, iArr[i3]));
            }
            return r.e();
        }

        public int a() {
            return this.X2;
        }

        /* renamed from: e */
        public int compareTo(ImageTrackInfo imageTrackInfo) {
            return Integer.compare(this.Y2, imageTrackInfo.Y2);
        }

        /* renamed from: g */
        public boolean b(ImageTrackInfo imageTrackInfo) {
            return false;
        }
    }

    private static final class OtherTrackScore implements Comparable<OtherTrackScore> {
        private final boolean X;
        private final boolean s;

        public OtherTrackScore(Format format, int i2) {
            this.s = (format.X2 & 1) == 0 ? false : true;
            this.X = DefaultTrackSelector.S(i2, false);
        }

        /* renamed from: a */
        public int compareTo(OtherTrackScore otherTrackScore) {
            return ComparisonChain.n().k(this.X, otherTrackScore.X).k(this.s, otherTrackScore.s).m();
        }
    }

    public static final class Parameters extends TrackSelectionParameters implements Bundleable {
        /* access modifiers changed from: private */
        public static final String A4 = Util.d1(1003);
        /* access modifiers changed from: private */
        public static final String B4 = Util.d1(1004);
        /* access modifiers changed from: private */
        public static final String C4 = Util.d1(AnalyticsListener.K);
        /* access modifiers changed from: private */
        public static final String D4 = Util.d1(1006);
        /* access modifiers changed from: private */
        public static final String E4 = Util.d1(1007);
        /* access modifiers changed from: private */
        public static final String F4 = Util.d1(1008);
        /* access modifiers changed from: private */
        public static final String G4 = Util.d1(1009);
        /* access modifiers changed from: private */
        public static final String H4 = Util.d1(1010);
        /* access modifiers changed from: private */
        public static final String I4 = Util.d1(1011);
        /* access modifiers changed from: private */
        public static final String J4 = Util.d1(1012);
        /* access modifiers changed from: private */
        public static final String K4 = Util.d1(1013);
        /* access modifiers changed from: private */
        public static final String L4 = Util.d1(1014);
        /* access modifiers changed from: private */
        public static final String M4 = Util.d1(1015);
        /* access modifiers changed from: private */
        public static final String N4 = Util.d1(1016);
        /* access modifiers changed from: private */
        public static final String O4 = Util.d1(1017);
        /* access modifiers changed from: private */
        public static final String P4 = Util.d1(1018);
        @Deprecated
        public static final Bundleable.Creator<Parameters> Q4 = new m();
        public static final Parameters v4;
        @Deprecated
        public static final Parameters w4;
        /* access modifiers changed from: private */
        public static final String x4 = Util.d1(1000);
        /* access modifiers changed from: private */
        public static final String y4 = Util.d1(1001);
        /* access modifiers changed from: private */
        public static final String z4 = Util.d1(1002);
        public final boolean e4;
        public final boolean f4;
        public final boolean g4;
        public final boolean h4;
        public final boolean i4;
        public final boolean j4;
        public final boolean k4;
        public final boolean l4;
        public final boolean m4;
        public final boolean n4;
        public final boolean o4;
        public final boolean p4;
        public final boolean q4;
        public final boolean r4;
        public final boolean s4;
        /* access modifiers changed from: private */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> t4;
        /* access modifiers changed from: private */
        public final SparseBooleanArray u4;

        public static final class Builder extends TrackSelectionParameters.Builder {
            /* access modifiers changed from: private */
            public boolean C;
            /* access modifiers changed from: private */
            public boolean D;
            /* access modifiers changed from: private */
            public boolean E;
            /* access modifiers changed from: private */
            public boolean F;
            /* access modifiers changed from: private */
            public boolean G;
            /* access modifiers changed from: private */
            public boolean H;
            /* access modifiers changed from: private */
            public boolean I;
            /* access modifiers changed from: private */
            public boolean J;
            /* access modifiers changed from: private */
            public boolean K;
            /* access modifiers changed from: private */
            public boolean L;
            /* access modifiers changed from: private */
            public boolean M;
            /* access modifiers changed from: private */
            public boolean N;
            /* access modifiers changed from: private */
            public boolean O;
            /* access modifiers changed from: private */
            public boolean P;
            /* access modifiers changed from: private */
            public boolean Q;
            /* access modifiers changed from: private */
            public final SparseArray<Map<TrackGroupArray, SelectionOverride>> R;
            /* access modifiers changed from: private */
            public final SparseBooleanArray S;

            @Deprecated
            public Builder() {
                this.R = new SparseArray<>();
                this.S = new SparseBooleanArray();
                W0();
            }

            private void R1(Bundle bundle) {
                int[] intArray = bundle.getIntArray(Parameters.H4);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(Parameters.I4);
                ImmutableList I2 = parcelableArrayList == null ? ImmutableList.I() : BundleCollectionUtil.d(new p(), parcelableArrayList);
                SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(Parameters.J4);
                SparseArray sparseArray = sparseParcelableArray == null ? new SparseArray() : BundleCollectionUtil.e(new q(), sparseParcelableArray);
                if (intArray != null && intArray.length == I2.size()) {
                    for (int i2 = 0; i2 < intArray.length; i2++) {
                        Q1(intArray[i2], (TrackGroupArray) I2.get(i2), (SelectionOverride) sparseArray.get(i2));
                    }
                }
            }

            private static SparseArray<Map<TrackGroupArray, SelectionOverride>> V0(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
                SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    sparseArray2.put(sparseArray.keyAt(i2), new HashMap(sparseArray.valueAt(i2)));
                }
                return sparseArray2;
            }

            private void W0() {
                this.C = true;
                this.D = false;
                this.E = true;
                this.F = false;
                this.G = true;
                this.H = false;
                this.I = false;
                this.J = false;
                this.K = false;
                this.L = true;
                this.M = true;
                this.N = true;
                this.O = false;
                this.P = true;
                this.Q = false;
            }

            private SparseBooleanArray X0(@Nullable int[] iArr) {
                if (iArr == null) {
                    return new SparseBooleanArray();
                }
                SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
                for (int append : iArr) {
                    sparseBooleanArray.append(append, true);
                }
                return sparseBooleanArray;
            }

            @CanIgnoreReturnValue
            /* renamed from: A1 */
            public Builder a0(int i2, int i3) {
                super.a0(i2, i3);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: B1 */
            public Builder b0(TrackSelectionOverride trackSelectionOverride) {
                super.b0(trackSelectionOverride);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: C1 */
            public Builder c0(@Nullable String str) {
                super.c0(str);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: D1 */
            public Builder d0(String... strArr) {
                super.d0(strArr);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: E1 */
            public Builder e0(@Nullable String str) {
                super.e0(str);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: F1 */
            public Builder f0(String... strArr) {
                super.f0(strArr);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: G1 */
            public Builder g0(int i2) {
                super.g0(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: H1 */
            public Builder h0(@Nullable String str) {
                super.h0(str);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: I1 */
            public Builder i0(Context context) {
                super.i0(context);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: J1 */
            public Builder k0(String... strArr) {
                super.k0(strArr);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: K1 */
            public Builder l0(int i2) {
                super.l0(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: L0 */
            public Builder C(TrackSelectionOverride trackSelectionOverride) {
                super.C(trackSelectionOverride);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: L1 */
            public Builder m0(@Nullable String str) {
                super.m0(str);
                return this;
            }

            /* renamed from: M0 */
            public Parameters D() {
                return new Parameters(this);
            }

            @CanIgnoreReturnValue
            /* renamed from: M1 */
            public Builder n0(String... strArr) {
                super.n0(strArr);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: N0 */
            public Builder E(TrackGroup trackGroup) {
                super.E(trackGroup);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: N1 */
            public Builder o0(int i2) {
                super.o0(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: O0 */
            public Builder F() {
                super.F();
                return this;
            }

            @CanIgnoreReturnValue
            public Builder O1(int i2, boolean z) {
                if (this.S.get(i2) == z) {
                    return this;
                }
                if (z) {
                    this.S.put(i2, true);
                } else {
                    this.S.delete(i2);
                }
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: P0 */
            public Builder G(int i2) {
                super.G(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: P1 */
            public Builder q0(boolean z) {
                super.q0(z);
                return this;
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder Q0(int i2, TrackGroupArray trackGroupArray) {
                Map map = this.R.get(i2);
                if (map != null && map.containsKey(trackGroupArray)) {
                    map.remove(trackGroupArray);
                    if (map.isEmpty()) {
                        this.R.remove(i2);
                    }
                }
                return this;
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder Q1(int i2, TrackGroupArray trackGroupArray, @Nullable SelectionOverride selectionOverride) {
                Map map = this.R.get(i2);
                if (map == null) {
                    map = new HashMap();
                    this.R.put(i2, map);
                }
                if (map.containsKey(trackGroupArray) && Util.g(map.get(trackGroupArray), selectionOverride)) {
                    return this;
                }
                map.put(trackGroupArray, selectionOverride);
                return this;
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder R0() {
                if (this.R.size() == 0) {
                    return this;
                }
                this.R.clear();
                return this;
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder S0(int i2) {
                Map map = this.R.get(i2);
                if (map != null && !map.isEmpty()) {
                    this.R.remove(i2);
                }
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: S1 */
            public Builder r0(int i2, boolean z) {
                super.r0(i2, z);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: T0 */
            public Builder H() {
                super.H();
                return this;
            }

            @CanIgnoreReturnValue
            public Builder T1(boolean z) {
                this.O = z;
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: U0 */
            public Builder I() {
                super.I();
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: U1 */
            public Builder s0(int i2, int i3, boolean z) {
                super.s0(i2, i3, z);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: V1 */
            public Builder t0(Context context, boolean z) {
                super.t0(context, z);
                return this;
            }

            /* access modifiers changed from: protected */
            @CanIgnoreReturnValue
            /* renamed from: Y0 */
            public Builder M(TrackSelectionParameters trackSelectionParameters) {
                super.M(trackSelectionParameters);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder Z0(boolean z) {
                this.J = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder a1(boolean z) {
                this.K = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder b1(boolean z) {
                this.H = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder c1(boolean z) {
                this.I = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder d1(boolean z) {
                this.L = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder e1(boolean z) {
                this.Q = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder f1(boolean z) {
                this.P = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder g1(boolean z) {
                this.F = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder h1(boolean z) {
                this.D = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder i1(boolean z) {
                this.E = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder j1(boolean z) {
                this.M = z;
                return this;
            }

            @CanIgnoreReturnValue
            @Deprecated
            public Builder k1(int i2) {
                return R(i2);
            }

            @CanIgnoreReturnValue
            @Deprecated
            /* renamed from: l1 */
            public Builder O(Set<Integer> set) {
                super.O(set);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder m1(boolean z) {
                this.G = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder n1(boolean z) {
                this.N = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder o1(boolean z) {
                this.C = z;
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: p1 */
            public Builder P(boolean z) {
                super.P(z);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: q1 */
            public Builder Q(boolean z) {
                super.Q(z);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: r1 */
            public Builder R(int i2) {
                super.R(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: s1 */
            public Builder S(int i2) {
                super.S(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: t1 */
            public Builder T(int i2) {
                super.T(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: u1 */
            public Builder U(int i2) {
                super.U(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: v1 */
            public Builder V(int i2) {
                super.V(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: w1 */
            public Builder W(int i2, int i3) {
                super.W(i2, i3);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: x1 */
            public Builder X() {
                super.X();
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: y1 */
            public Builder Y(int i2) {
                super.Y(i2);
                return this;
            }

            @CanIgnoreReturnValue
            /* renamed from: z1 */
            public Builder Z(int i2) {
                super.Z(i2);
                return this;
            }

            public Builder(Context context) {
                super(context);
                this.R = new SparseArray<>();
                this.S = new SparseBooleanArray();
                W0();
            }

            private Builder(Bundle bundle) {
                super(bundle);
                W0();
                Parameters parameters = Parameters.v4;
                o1(bundle.getBoolean(Parameters.x4, parameters.e4));
                h1(bundle.getBoolean(Parameters.y4, parameters.f4));
                i1(bundle.getBoolean(Parameters.z4, parameters.g4));
                g1(bundle.getBoolean(Parameters.L4, parameters.h4));
                m1(bundle.getBoolean(Parameters.A4, parameters.i4));
                b1(bundle.getBoolean(Parameters.B4, parameters.j4));
                c1(bundle.getBoolean(Parameters.C4, parameters.k4));
                Z0(bundle.getBoolean(Parameters.D4, parameters.l4));
                a1(bundle.getBoolean(Parameters.M4, parameters.m4));
                d1(bundle.getBoolean(Parameters.P4, parameters.n4));
                j1(bundle.getBoolean(Parameters.N4, parameters.o4));
                n1(bundle.getBoolean(Parameters.E4, parameters.p4));
                T1(bundle.getBoolean(Parameters.F4, parameters.q4));
                f1(bundle.getBoolean(Parameters.G4, parameters.r4));
                e1(bundle.getBoolean(Parameters.O4, parameters.s4));
                this.R = new SparseArray<>();
                R1(bundle);
                this.S = X0(bundle.getIntArray(Parameters.K4));
            }

            private Builder(Parameters parameters) {
                super((TrackSelectionParameters) parameters);
                this.C = parameters.e4;
                this.D = parameters.f4;
                this.E = parameters.g4;
                this.F = parameters.h4;
                this.G = parameters.i4;
                this.H = parameters.j4;
                this.I = parameters.k4;
                this.J = parameters.l4;
                this.K = parameters.m4;
                this.L = parameters.n4;
                this.M = parameters.o4;
                this.N = parameters.p4;
                this.O = parameters.q4;
                this.P = parameters.r4;
                this.Q = parameters.s4;
                this.R = V0(parameters.t4);
                this.S = parameters.u4.clone();
            }
        }

        static {
            Parameters M0 = new Builder().D();
            v4 = M0;
            w4 = M0;
        }

        private Parameters(Builder builder) {
            super(builder);
            this.e4 = builder.C;
            this.f4 = builder.D;
            this.g4 = builder.E;
            this.h4 = builder.F;
            this.i4 = builder.G;
            this.j4 = builder.H;
            this.k4 = builder.I;
            this.l4 = builder.J;
            this.m4 = builder.K;
            this.n4 = builder.L;
            this.o4 = builder.M;
            this.p4 = builder.N;
            this.q4 = builder.O;
            this.r4 = builder.P;
            this.s4 = builder.Q;
            this.t4 = builder.R;
            this.u4 = builder.S;
        }

        private static boolean L(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean M(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                if (indexOfKey < 0 || !N(sparseArray.valueAt(i2), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean N(java.util.Map<androidx.media3.exoplayer.source.TrackGroupArray, androidx.media3.exoplayer.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<androidx.media3.exoplayer.source.TrackGroupArray, androidx.media3.exoplayer.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                androidx.media3.exoplayer.source.TrackGroupArray r1 = (androidx.media3.exoplayer.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = androidx.media3.common.util.Util.g(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.Parameters.N(java.util.Map, java.util.Map):boolean");
        }

        public static Parameters P(Bundle bundle) {
            return new Builder(bundle).D();
        }

        public static Parameters Q(Context context) {
            return new Builder(context).D();
        }

        private static int[] R(SparseBooleanArray sparseBooleanArray) {
            int[] iArr = new int[sparseBooleanArray.size()];
            for (int i2 = 0; i2 < sparseBooleanArray.size(); i2++) {
                iArr[i2] = sparseBooleanArray.keyAt(i2);
            }
            return iArr;
        }

        private static void V(Bundle bundle, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray2 = new SparseArray();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                for (Map.Entry entry : sparseArray.valueAt(i2).entrySet()) {
                    SelectionOverride selectionOverride = (SelectionOverride) entry.getValue();
                    if (selectionOverride != null) {
                        sparseArray2.put(arrayList2.size(), selectionOverride);
                    }
                    arrayList2.add((TrackGroupArray) entry.getKey());
                    arrayList.add(Integer.valueOf(keyAt));
                }
                bundle.putIntArray(H4, Ints.D(arrayList));
                bundle.putParcelableArrayList(I4, BundleCollectionUtil.i(arrayList2, new n()));
                bundle.putSparseParcelableArray(J4, BundleCollectionUtil.k(sparseArray2, new o()));
            }
        }

        /* renamed from: O */
        public Builder G() {
            return new Builder();
        }

        public boolean S(int i2) {
            return this.u4.get(i2);
        }

        @Deprecated
        @Nullable
        public SelectionOverride T(int i2, TrackGroupArray trackGroupArray) {
            Map map = this.t4.get(i2);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        @Deprecated
        public boolean U(int i2, TrackGroupArray trackGroupArray) {
            Map map = this.t4.get(i2);
            return map != null && map.containsKey(trackGroupArray);
        }

        public Bundle a() {
            Bundle a2 = super.a();
            a2.putBoolean(x4, this.e4);
            a2.putBoolean(y4, this.f4);
            a2.putBoolean(z4, this.g4);
            a2.putBoolean(L4, this.h4);
            a2.putBoolean(A4, this.i4);
            a2.putBoolean(B4, this.j4);
            a2.putBoolean(C4, this.k4);
            a2.putBoolean(D4, this.l4);
            a2.putBoolean(M4, this.m4);
            a2.putBoolean(P4, this.n4);
            a2.putBoolean(N4, this.o4);
            a2.putBoolean(E4, this.p4);
            a2.putBoolean(F4, this.q4);
            a2.putBoolean(G4, this.r4);
            a2.putBoolean(O4, this.s4);
            V(a2, this.t4);
            a2.putIntArray(K4, R(this.u4));
            return a2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Parameters.class != obj.getClass()) {
                return false;
            }
            Parameters parameters = (Parameters) obj;
            return super.equals(parameters) && this.e4 == parameters.e4 && this.f4 == parameters.f4 && this.g4 == parameters.g4 && this.h4 == parameters.h4 && this.i4 == parameters.i4 && this.j4 == parameters.j4 && this.k4 == parameters.k4 && this.l4 == parameters.l4 && this.m4 == parameters.m4 && this.n4 == parameters.n4 && this.o4 == parameters.o4 && this.p4 == parameters.p4 && this.q4 == parameters.q4 && this.r4 == parameters.r4 && this.s4 == parameters.s4 && L(this.u4, parameters.u4) && M(this.t4, parameters.t4);
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.e4 ? 1 : 0)) * 31) + (this.f4 ? 1 : 0)) * 31) + (this.g4 ? 1 : 0)) * 31) + (this.h4 ? 1 : 0)) * 31) + (this.i4 ? 1 : 0)) * 31) + (this.j4 ? 1 : 0)) * 31) + (this.k4 ? 1 : 0)) * 31) + (this.l4 ? 1 : 0)) * 31) + (this.m4 ? 1 : 0)) * 31) + (this.n4 ? 1 : 0)) * 31) + (this.o4 ? 1 : 0)) * 31) + (this.p4 ? 1 : 0)) * 31) + (this.q4 ? 1 : 0)) * 31) + (this.r4 ? 1 : 0)) * 31) + (this.s4 ? 1 : 0);
        }
    }

    @Deprecated
    public static final class ParametersBuilder extends TrackSelectionParameters.Builder {
        private final Parameters.Builder C;

        @Deprecated
        public ParametersBuilder() {
            this.C = new Parameters.Builder();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder A0() {
            this.C.R0();
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder B0(int i2) {
            this.C.S0(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: C0 */
        public ParametersBuilder H() {
            this.C.H();
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: D0 */
        public ParametersBuilder I() {
            this.C.I();
            return this;
        }

        /* access modifiers changed from: protected */
        @CanIgnoreReturnValue
        /* renamed from: E0 */
        public ParametersBuilder M(TrackSelectionParameters trackSelectionParameters) {
            this.C.M(trackSelectionParameters);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder F0(boolean z) {
            this.C.Z0(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder G0(boolean z) {
            this.C.a1(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder H0(boolean z) {
            this.C.b1(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder I0(boolean z) {
            this.C.c1(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder J0(boolean z) {
            this.C.f1(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder K0(boolean z) {
            this.C.g1(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder L0(boolean z) {
            this.C.h1(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder M0(boolean z) {
            this.C.i1(z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: N0 */
        public ParametersBuilder N(TrackSelectionParameters.AudioOffloadPreferences audioOffloadPreferences) {
            this.C.N(audioOffloadPreferences);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder O0(int i2) {
            this.C.k1(i2);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        /* renamed from: P0 */
        public ParametersBuilder O(Set<Integer> set) {
            this.C.O(set);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder Q0(boolean z) {
            this.C.m1(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder R0(boolean z) {
            this.C.n1(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder S0(boolean z) {
            this.C.o1(z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: T0 */
        public ParametersBuilder P(boolean z) {
            this.C.P(z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: U0 */
        public ParametersBuilder Q(boolean z) {
            this.C.Q(z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: V0 */
        public ParametersBuilder R(int i2) {
            this.C.R(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: W0 */
        public ParametersBuilder S(int i2) {
            this.C.S(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: X0 */
        public ParametersBuilder T(int i2) {
            this.C.T(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: Y0 */
        public ParametersBuilder U(int i2) {
            this.C.U(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: Z0 */
        public ParametersBuilder V(int i2) {
            this.C.V(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: a1 */
        public ParametersBuilder W(int i2, int i3) {
            this.C.W(i2, i3);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: b1 */
        public ParametersBuilder X() {
            this.C.X();
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: c1 */
        public ParametersBuilder Y(int i2) {
            this.C.Y(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: d1 */
        public ParametersBuilder Z(int i2) {
            this.C.Z(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: e1 */
        public ParametersBuilder a0(int i2, int i3) {
            this.C.a0(i2, i3);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: f1 */
        public ParametersBuilder b0(TrackSelectionOverride trackSelectionOverride) {
            this.C.b0(trackSelectionOverride);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: g1 */
        public ParametersBuilder c0(@Nullable String str) {
            this.C.c0(str);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: h1 */
        public ParametersBuilder d0(String... strArr) {
            this.C.d0(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: i1 */
        public ParametersBuilder e0(@Nullable String str) {
            this.C.e0(str);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: j1 */
        public ParametersBuilder f0(String... strArr) {
            this.C.f0(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: k1 */
        public ParametersBuilder g0(int i2) {
            this.C.g0(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: l1 */
        public ParametersBuilder h0(@Nullable String str) {
            this.C.h0(str);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: m1 */
        public ParametersBuilder i0(Context context) {
            this.C.i0(context);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: n1 */
        public ParametersBuilder k0(String... strArr) {
            this.C.k0(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: o1 */
        public ParametersBuilder l0(int i2) {
            this.C.l0(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: p1 */
        public ParametersBuilder m0(@Nullable String str) {
            this.C.m0(str);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: q1 */
        public ParametersBuilder n0(String... strArr) {
            this.C.n0(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: r1 */
        public ParametersBuilder o0(int i2) {
            this.C.o0(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: s1 */
        public ParametersBuilder p0(boolean z) {
            this.C.p0(z);
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder t1(int i2, boolean z) {
            this.C.O1(i2, z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: u0 */
        public ParametersBuilder C(TrackSelectionOverride trackSelectionOverride) {
            this.C.C(trackSelectionOverride);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: u1 */
        public ParametersBuilder q0(boolean z) {
            this.C.q0(z);
            return this;
        }

        /* renamed from: v0 */
        public Parameters D() {
            return this.C.D();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder v1(int i2, TrackGroupArray trackGroupArray, @Nullable SelectionOverride selectionOverride) {
            this.C.Q1(i2, trackGroupArray, selectionOverride);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: w0 */
        public ParametersBuilder E(TrackGroup trackGroup) {
            this.C.E(trackGroup);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: w1 */
        public ParametersBuilder r0(int i2, boolean z) {
            this.C.r0(i2, z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: x0 */
        public ParametersBuilder F() {
            this.C.F();
            return this;
        }

        @CanIgnoreReturnValue
        public ParametersBuilder x1(boolean z) {
            this.C.T1(z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: y0 */
        public ParametersBuilder G(int i2) {
            this.C.G(i2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: y1 */
        public ParametersBuilder s0(int i2, int i3, boolean z) {
            this.C.s0(i2, i3, z);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public ParametersBuilder z0(int i2, TrackGroupArray trackGroupArray) {
            this.C.Q0(i2, trackGroupArray);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: z1 */
        public ParametersBuilder t0(Context context, boolean z) {
            this.C.t0(context, z);
            return this;
        }

        public ParametersBuilder(Context context) {
            this.C = new Parameters.Builder(context);
        }
    }

    public static final class SelectionOverride implements Bundleable {
        private static final String X2 = Util.d1(0);
        private static final String Y2 = Util.d1(1);
        private static final String Z2 = Util.d1(2);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<SelectionOverride> a3 = new r();
        public final int[] X;
        public final int Y;
        public final int Z;
        public final int s;

        public SelectionOverride(int i2, int... iArr) {
            this(i2, iArr, 0);
        }

        @UnstableApi
        public static SelectionOverride c(Bundle bundle) {
            int i2 = bundle.getInt(X2, -1);
            int[] intArray = bundle.getIntArray(Y2);
            int i3 = bundle.getInt(Z2, -1);
            Assertions.a(i2 >= 0 && i3 >= 0);
            Assertions.g(intArray);
            return new SelectionOverride(i2, intArray, i3);
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putInt(X2, this.s);
            bundle.putIntArray(Y2, this.X);
            bundle.putInt(Z2, this.Z);
            return bundle;
        }

        public boolean b(int i2) {
            for (int i3 : this.X) {
                if (i3 == i2) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SelectionOverride.class != obj.getClass()) {
                return false;
            }
            SelectionOverride selectionOverride = (SelectionOverride) obj;
            return this.s == selectionOverride.s && Arrays.equals(this.X, selectionOverride.X) && this.Z == selectionOverride.Z;
        }

        public int hashCode() {
            return (((this.s * 31) + Arrays.hashCode(this.X)) * 31) + this.Z;
        }

        @UnstableApi
        public SelectionOverride(int i2, int[] iArr, int i3) {
            this.s = i2;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.X = copyOf;
            this.Y = iArr.length;
            this.Z = i3;
            Arrays.sort(copyOf);
        }
    }

    @RequiresApi(32)
    private static class SpatializerWrapperV32 {

        /* renamed from: a  reason: collision with root package name */
        private final Spatializer f12382a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f12383b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Handler f12384c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Spatializer.OnSpatializerStateChangedListener f12385d;

        private SpatializerWrapperV32(Spatializer spatializer) {
            this.f12382a = spatializer;
            this.f12383b = spatializer.getImmersiveAudioLevel() != 0;
        }

        @Nullable
        public static SpatializerWrapperV32 g(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return null;
            }
            return new SpatializerWrapperV32(audioManager.getSpatializer());
        }

        public boolean a(AudioAttributes audioAttributes, Format format) {
            AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(Util.a0((!MimeTypes.S.equals(format.f3) || format.s3 != 16) ? format.s3 : 12));
            int i2 = format.t3;
            if (i2 != -1) {
                channelMask.setSampleRate(i2);
            }
            return this.f12382a.canBeSpatialized(audioAttributes.c().f9067a, channelMask.build());
        }

        public void b(final DefaultTrackSelector defaultTrackSelector, Looper looper) {
            if (this.f12385d == null && this.f12384c == null) {
                this.f12385d = new Spatializer.OnSpatializerStateChangedListener() {
                    public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
                        defaultTrackSelector.b0();
                    }

                    public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
                        defaultTrackSelector.b0();
                    }
                };
                Handler handler = new Handler(looper);
                this.f12384c = handler;
                Spatializer spatializer = this.f12382a;
                Objects.requireNonNull(handler);
                spatializer.addOnSpatializerStateChangedListener(new a(handler), this.f12385d);
            }
        }

        public boolean c() {
            return this.f12382a.isAvailable();
        }

        public boolean d() {
            return this.f12382a.isEnabled();
        }

        public boolean e() {
            return this.f12383b;
        }

        public void f() {
            Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.f12385d;
            if (onSpatializerStateChangedListener != null && this.f12384c != null) {
                this.f12382a.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
                ((Handler) Util.o(this.f12384c)).removeCallbacksAndMessages((Object) null);
                this.f12384c = null;
                this.f12385d = null;
            }
        }
    }

    private static final class TextTrackInfo extends TrackInfo<TextTrackInfo> implements Comparable<TextTrackInfo> {
        private final int X2;
        private final boolean Y2;
        private final boolean Z2;
        private final boolean a3;
        private final int b3;
        private final int c3;
        private final int d3;
        private final int e3;
        private final boolean f3;

        public TextTrackInfo(int i2, TrackGroup trackGroup, int i3, Parameters parameters, int i4, @Nullable String str) {
            super(i2, trackGroup, i3);
            int i5;
            int i6 = 0;
            this.Y2 = DefaultTrackSelector.S(i4, false);
            int i7 = this.Z.X2 & (~parameters.o3);
            this.Z2 = (i7 & 1) != 0;
            this.a3 = (i7 & 2) != 0;
            ImmutableList<String> K = parameters.m3.isEmpty() ? ImmutableList.K("") : parameters.m3;
            int i8 = 0;
            while (true) {
                if (i8 >= K.size()) {
                    i8 = Integer.MAX_VALUE;
                    i5 = 0;
                    break;
                }
                i5 = DefaultTrackSelector.K(this.Z, K.get(i8), parameters.p3);
                if (i5 > 0) {
                    break;
                }
                i8++;
            }
            this.b3 = i8;
            this.c3 = i5;
            int A = DefaultTrackSelector.O(this.Z.Y2, parameters.n3);
            this.d3 = A;
            this.f3 = (this.Z.Y2 & 1088) != 0;
            int K2 = DefaultTrackSelector.K(this.Z, str, DefaultTrackSelector.d0(str) == null);
            this.e3 = K2;
            boolean z = i5 > 0 || (parameters.m3.isEmpty() && A > 0) || this.Z2 || (this.a3 && K2 > 0);
            if (DefaultTrackSelector.S(i4, parameters.p4) && z) {
                i6 = 1;
            }
            this.X2 = i6;
        }

        public static int c(List<TextTrackInfo> list, List<TextTrackInfo> list2) {
            return list.get(0).compareTo(list2.get(0));
        }

        public static ImmutableList<TextTrackInfo> f(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr, @Nullable String str) {
            ImmutableList.Builder r = ImmutableList.r();
            for (int i3 = 0; i3 < trackGroup.s; i3++) {
                r.g(new TextTrackInfo(i2, trackGroup, i3, parameters, iArr[i3], str));
            }
            return r.e();
        }

        public int a() {
            return this.X2;
        }

        /* renamed from: e */
        public int compareTo(TextTrackInfo textTrackInfo) {
            ComparisonChain f2 = ComparisonChain.n().k(this.Y2, textTrackInfo.Y2).j(Integer.valueOf(this.b3), Integer.valueOf(textTrackInfo.b3), Ordering.z().E()).f(this.c3, textTrackInfo.c3).f(this.d3, textTrackInfo.d3).k(this.Z2, textTrackInfo.Z2).j(Boolean.valueOf(this.a3), Boolean.valueOf(textTrackInfo.a3), this.c3 == 0 ? Ordering.z() : Ordering.z().E()).f(this.e3, textTrackInfo.e3);
            if (this.d3 == 0) {
                f2 = f2.l(this.f3, textTrackInfo.f3);
            }
            return f2.m();
        }

        /* renamed from: g */
        public boolean b(TextTrackInfo textTrackInfo) {
            return false;
        }
    }

    private static abstract class TrackInfo<T extends TrackInfo<T>> {
        public final TrackGroup X;
        public final int Y;
        public final Format Z;
        public final int s;

        public interface Factory<T extends TrackInfo<T>> {
            List<T> a(int i2, TrackGroup trackGroup, int[] iArr);
        }

        public TrackInfo(int i2, TrackGroup trackGroup, int i3) {
            this.s = i2;
            this.X = trackGroup;
            this.Y = i3;
            this.Z = trackGroup.d(i3);
        }

        public abstract int a();

        public abstract boolean b(T t);
    }

    private static final class VideoTrackInfo extends TrackInfo<VideoTrackInfo> {
        private static final float m3 = 10.0f;
        private final boolean X2;
        private final Parameters Y2;
        private final boolean Z2;
        private final boolean a3;
        private final boolean b3;
        private final int c3;
        private final int d3;
        private final int e3;
        private final int f3;
        private final boolean g3;
        private final boolean h3;
        private final int i3;
        private final boolean j3;
        private final boolean k3;
        private final int l3;

        /* JADX WARNING: Removed duplicated region for block: B:54:0x0090  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00c3  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x00e6  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x00f3  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x00d9 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public VideoTrackInfo(int r5, androidx.media3.common.TrackGroup r6, int r7, androidx.media3.exoplayer.trackselection.DefaultTrackSelector.Parameters r8, int r9, int r10, boolean r11) {
            /*
                r4 = this;
                r4.<init>(r5, r6, r7)
                r4.Y2 = r8
                boolean r5 = r8.g4
                if (r5 == 0) goto L_0x000c
                r5 = 24
                goto L_0x000e
            L_0x000c:
                r5 = 16
            L_0x000e:
                boolean r6 = r8.f4
                r7 = 0
                r0 = 1
                if (r6 == 0) goto L_0x001a
                r6 = r10 & r5
                if (r6 == 0) goto L_0x001a
                r6 = 1
                goto L_0x001b
            L_0x001a:
                r6 = 0
            L_0x001b:
                r4.h3 = r6
                r6 = -1082130432(0xffffffffbf800000, float:-1.0)
                r10 = -1
                if (r11 == 0) goto L_0x004b
                androidx.media3.common.Format r1 = r4.Z
                int r2 = r1.k3
                if (r2 == r10) goto L_0x002c
                int r3 = r8.s
                if (r2 > r3) goto L_0x004b
            L_0x002c:
                int r2 = r1.l3
                if (r2 == r10) goto L_0x0034
                int r3 = r8.X
                if (r2 > r3) goto L_0x004b
            L_0x0034:
                float r2 = r1.m3
                int r3 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r3 == 0) goto L_0x0041
                int r3 = r8.Y
                float r3 = (float) r3
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 > 0) goto L_0x004b
            L_0x0041:
                int r1 = r1.b3
                if (r1 == r10) goto L_0x0049
                int r2 = r8.Z
                if (r1 > r2) goto L_0x004b
            L_0x0049:
                r1 = 1
                goto L_0x004c
            L_0x004b:
                r1 = 0
            L_0x004c:
                r4.X2 = r1
                if (r11 == 0) goto L_0x0079
                androidx.media3.common.Format r11 = r4.Z
                int r1 = r11.k3
                if (r1 == r10) goto L_0x005a
                int r2 = r8.X2
                if (r1 < r2) goto L_0x0079
            L_0x005a:
                int r1 = r11.l3
                if (r1 == r10) goto L_0x0062
                int r2 = r8.Y2
                if (r1 < r2) goto L_0x0079
            L_0x0062:
                float r1 = r11.m3
                int r2 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r2 == 0) goto L_0x006f
                int r2 = r8.Z2
                float r2 = (float) r2
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 < 0) goto L_0x0079
            L_0x006f:
                int r11 = r11.b3
                if (r11 == r10) goto L_0x0077
                int r10 = r8.a3
                if (r11 < r10) goto L_0x0079
            L_0x0077:
                r10 = 1
                goto L_0x007a
            L_0x0079:
                r10 = 0
            L_0x007a:
                r4.Z2 = r10
                boolean r10 = androidx.media3.exoplayer.trackselection.DefaultTrackSelector.S(r9, r7)
                r4.a3 = r10
                androidx.media3.common.Format r10 = r4.Z
                float r11 = r10.m3
                int r6 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r6 == 0) goto L_0x0092
                r6 = 1092616192(0x41200000, float:10.0)
                int r6 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r6 < 0) goto L_0x0092
                r6 = 1
                goto L_0x0093
            L_0x0092:
                r6 = 0
            L_0x0093:
                r4.b3 = r6
                int r6 = r10.b3
                r4.c3 = r6
                int r6 = r10.h()
                r4.d3 = r6
                androidx.media3.common.Format r6 = r4.Z
                int r6 = r6.Y2
                int r10 = r8.f3
                int r6 = androidx.media3.exoplayer.trackselection.DefaultTrackSelector.O(r6, r10)
                r4.f3 = r6
                androidx.media3.common.Format r6 = r4.Z
                int r6 = r6.Y2
                if (r6 == 0) goto L_0x00b7
                r6 = r6 & r0
                if (r6 == 0) goto L_0x00b5
                goto L_0x00b7
            L_0x00b5:
                r6 = 0
                goto L_0x00b8
            L_0x00b7:
                r6 = 1
            L_0x00b8:
                r4.g3 = r6
                r6 = 0
            L_0x00bb:
                com.google.common.collect.ImmutableList<java.lang.String> r10 = r8.e3
                int r10 = r10.size()
                if (r6 >= r10) goto L_0x00d9
                androidx.media3.common.Format r10 = r4.Z
                java.lang.String r10 = r10.f3
                if (r10 == 0) goto L_0x00d6
                com.google.common.collect.ImmutableList<java.lang.String> r11 = r8.e3
                java.lang.Object r11 = r11.get(r6)
                boolean r10 = r10.equals(r11)
                if (r10 == 0) goto L_0x00d6
                goto L_0x00dc
            L_0x00d6:
                int r6 = r6 + 1
                goto L_0x00bb
            L_0x00d9:
                r6 = 2147483647(0x7fffffff, float:NaN)
            L_0x00dc:
                r4.e3 = r6
                int r6 = androidx.media3.exoplayer.V0.j(r9)
                r8 = 128(0x80, float:1.794E-43)
                if (r6 != r8) goto L_0x00e8
                r6 = 1
                goto L_0x00e9
            L_0x00e8:
                r6 = 0
            L_0x00e9:
                r4.j3 = r6
                int r6 = androidx.media3.exoplayer.V0.l(r9)
                r8 = 64
                if (r6 != r8) goto L_0x00f4
                r7 = 1
            L_0x00f4:
                r4.k3 = r7
                androidx.media3.common.Format r6 = r4.Z
                java.lang.String r6 = r6.f3
                int r6 = androidx.media3.exoplayer.trackselection.DefaultTrackSelector.P(r6)
                r4.l3 = r6
                int r5 = r4.j(r9, r5)
                r4.i3 = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.VideoTrackInfo.<init>(int, androidx.media3.common.TrackGroup, int, androidx.media3.exoplayer.trackselection.DefaultTrackSelector$Parameters, int, int, boolean):void");
        }

        /* access modifiers changed from: private */
        public static int f(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            ComparisonChain k2 = ComparisonChain.n().k(videoTrackInfo.a3, videoTrackInfo2.a3).f(videoTrackInfo.f3, videoTrackInfo2.f3).k(videoTrackInfo.g3, videoTrackInfo2.g3).k(videoTrackInfo.b3, videoTrackInfo2.b3).k(videoTrackInfo.X2, videoTrackInfo2.X2).k(videoTrackInfo.Z2, videoTrackInfo2.Z2).j(Integer.valueOf(videoTrackInfo.e3), Integer.valueOf(videoTrackInfo2.e3), Ordering.z().E()).k(videoTrackInfo.j3, videoTrackInfo2.j3).k(videoTrackInfo.k3, videoTrackInfo2.k3);
            if (videoTrackInfo.j3 && videoTrackInfo.k3) {
                k2 = k2.f(videoTrackInfo.l3, videoTrackInfo2.l3);
            }
            return k2.m();
        }

        /* access modifiers changed from: private */
        public static int g(VideoTrackInfo videoTrackInfo, VideoTrackInfo videoTrackInfo2) {
            Ordering E = (!videoTrackInfo.X2 || !videoTrackInfo.a3) ? DefaultTrackSelector.q.E() : DefaultTrackSelector.q;
            return ComparisonChain.n().j(Integer.valueOf(videoTrackInfo.c3), Integer.valueOf(videoTrackInfo2.c3), videoTrackInfo.Y2.r3 ? DefaultTrackSelector.q.E() : DefaultTrackSelector.r).j(Integer.valueOf(videoTrackInfo.d3), Integer.valueOf(videoTrackInfo2.d3), E).j(Integer.valueOf(videoTrackInfo.c3), Integer.valueOf(videoTrackInfo2.c3), E).m();
        }

        public static int h(List<VideoTrackInfo> list, List<VideoTrackInfo> list2) {
            return ComparisonChain.n().j((VideoTrackInfo) Collections.max(list, new z()), (VideoTrackInfo) Collections.max(list2, new z()), new z()).f(list.size(), list2.size()).j((VideoTrackInfo) Collections.max(list, new A()), (VideoTrackInfo) Collections.max(list2, new A()), new A()).m();
        }

        public static ImmutableList<VideoTrackInfo> i(int i2, TrackGroup trackGroup, Parameters parameters, int[] iArr, int i4) {
            TrackGroup trackGroup2 = trackGroup;
            Parameters parameters2 = parameters;
            int z = DefaultTrackSelector.L(trackGroup2, parameters2.b3, parameters2.c3, parameters2.d3);
            ImmutableList.Builder r = ImmutableList.r();
            for (int i5 = 0; i5 < trackGroup2.s; i5++) {
                int h2 = trackGroup2.d(i5).h();
                r.g(new VideoTrackInfo(i2, trackGroup, i5, parameters, iArr[i5], i4, z == Integer.MAX_VALUE || (h2 != -1 && h2 <= z)));
            }
            return r.e();
        }

        private int j(int i2, int i4) {
            if ((this.Z.Y2 & 16384) != 0 || !DefaultTrackSelector.S(i2, this.Y2.p4)) {
                return 0;
            }
            if (!this.X2 && !this.Y2.e4) {
                return 0;
            }
            if (DefaultTrackSelector.S(i2, false) && this.Z2 && this.X2 && this.Z.b3 != -1) {
                Parameters parameters = this.Y2;
                return (parameters.s3 || parameters.r3 || (i2 & i4) == 0) ? 1 : 2;
            }
        }

        public int a() {
            return this.i3;
        }

        /* renamed from: k */
        public boolean b(VideoTrackInfo videoTrackInfo) {
            return (this.h3 || Util.g(this.Z.f3, videoTrackInfo.Z.f3)) && (this.Y2.h4 || (this.j3 == videoTrackInfo.j3 && this.k3 == videoTrackInfo.k3));
        }
    }

    public DefaultTrackSelector(Context context) {
        this(context, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    private static void G(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, Parameters parameters, ExoTrackSelection.Definition[] definitionArr) {
        int d2 = mappedTrackInfo.d();
        for (int i2 = 0; i2 < d2; i2++) {
            TrackGroupArray h2 = mappedTrackInfo.h(i2);
            if (parameters.U(i2, h2)) {
                SelectionOverride T = parameters.T(i2, h2);
                definitionArr[i2] = (T == null || T.X.length == 0) ? null : new ExoTrackSelection.Definition(h2.d(T.s), T.X, T.Z);
            }
        }
    }

    private static void H(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Definition[] definitionArr) {
        int d2 = mappedTrackInfo.d();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < d2; i2++) {
            J(mappedTrackInfo.h(i2), trackSelectionParameters, hashMap);
        }
        J(mappedTrackInfo.k(), trackSelectionParameters, hashMap);
        for (int i3 = 0; i3 < d2; i3++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) hashMap.get(Integer.valueOf(mappedTrackInfo.g(i3)));
            if (trackSelectionOverride != null) {
                definitionArr[i3] = (trackSelectionOverride.X.isEmpty() || mappedTrackInfo.h(i3).f(trackSelectionOverride.s) == -1) ? null : new ExoTrackSelection.Definition(trackSelectionOverride.s, Ints.D(trackSelectionOverride.X));
            }
        }
    }

    private static void J(TrackGroupArray trackGroupArray, TrackSelectionParameters trackSelectionParameters, Map<Integer, TrackSelectionOverride> map) {
        TrackSelectionOverride trackSelectionOverride;
        for (int i2 = 0; i2 < trackGroupArray.s; i2++) {
            TrackSelectionOverride trackSelectionOverride2 = trackSelectionParameters.t3.get(trackGroupArray.d(i2));
            if (trackSelectionOverride2 != null && ((trackSelectionOverride = map.get(Integer.valueOf(trackSelectionOverride2.c()))) == null || (trackSelectionOverride.X.isEmpty() && !trackSelectionOverride2.X.isEmpty()))) {
                map.put(Integer.valueOf(trackSelectionOverride2.c()), trackSelectionOverride2);
            }
        }
    }

    protected static int K(Format format, @Nullable String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(format.Z)) {
            return 4;
        }
        String d0 = d0(str);
        String d02 = d0(format.Z);
        if (d02 == null || d0 == null) {
            return (!z || d02 != null) ? 0 : 1;
        }
        if (d02.startsWith(d0) || d0.startsWith(d02)) {
            return 3;
        }
        return Util.q2(d02, "-")[0].equals(Util.q2(d0, "-")[0]) ? 2 : 0;
    }

    /* access modifiers changed from: private */
    public static int L(TrackGroup trackGroup, int i2, int i3, boolean z) {
        int i4;
        int i5 = Integer.MAX_VALUE;
        if (!(i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE)) {
            for (int i6 = 0; i6 < trackGroup.s; i6++) {
                Format d2 = trackGroup.d(i6);
                int i7 = d2.k3;
                if (i7 > 0 && (i4 = d2.l3) > 0) {
                    Point M = M(z, i2, i3, i7, i4);
                    int i8 = d2.k3;
                    int i9 = d2.l3;
                    int i10 = i8 * i9;
                    if (i8 >= ((int) (((float) M.x) * p)) && i9 >= ((int) (((float) M.y) * p)) && i10 < i5) {
                        i5 = i10;
                    }
                }
            }
        }
        return i5;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r1 != r3) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point M(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x000f
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            r3 = 1
        L_0x000c:
            if (r1 == r3) goto L_0x000f
            goto L_0x0012
        L_0x000f:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0012:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0022
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = androidx.media3.common.util.Util.q(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0022:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = androidx.media3.common.util.Util.q(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.M(boolean, int, int, int, int):android.graphics.Point");
    }

    /* access modifiers changed from: private */
    public static int O(int i2, int i3) {
        if (i2 == 0 || i2 != i3) {
            return Integer.bitCount(i2 & i3);
        }
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: private */
    public static int P(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1851077871:
                if (str.equals(MimeTypes.w)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1662735862:
                if (str.equals(MimeTypes.f9239n)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1662541442:
                if (str.equals(MimeTypes.f9236k)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1331836730:
                if (str.equals(MimeTypes.f9235j)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1599127257:
                if (str.equals(MimeTypes.f9238m)) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 5;
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 1;
            case 4:
                return 2;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: private */
    public boolean Q(Format format) {
        boolean z;
        SpatializerWrapperV32 spatializerWrapperV32;
        SpatializerWrapperV32 spatializerWrapperV322;
        synchronized (this.f12375d) {
            try {
                if (this.f12379h.o4 && !this.f12378g && format.s3 > 2) {
                    if (R(format)) {
                        if (Util.f9646a >= 32 && (spatializerWrapperV322 = this.f12380i) != null && spatializerWrapperV322.e()) {
                        }
                    }
                    if (Util.f9646a < 32 || (spatializerWrapperV32 = this.f12380i) == null || !spatializerWrapperV32.e() || !this.f12380i.c() || !this.f12380i.d() || !this.f12380i.a(this.f12381j, format)) {
                        z = false;
                    }
                }
                z = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    private static boolean R(Format format) {
        String str = format.f3;
        if (str == null) {
            return false;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.S)) {
                    c2 = 0;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(MimeTypes.Q)) {
                    c2 = 1;
                    break;
                }
                break;
            case 187078297:
                if (str.equals(MimeTypes.T)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(MimeTypes.R)) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    protected static boolean S(int i2, boolean z) {
        int k2 = V0.k(i2);
        return k2 == 4 || (z && k2 == 3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List T(Parameters parameters, boolean z, int[] iArr, int i2, TrackGroup trackGroup, int[] iArr2) {
        return AudioTrackInfo.f(i2, trackGroup, parameters, iArr2, z, new g(this), iArr[i2]);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int X(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int Y(Integer num, Integer num2) {
        return 0;
    }

    private static void Z(Parameters parameters, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int i2 = -1;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        while (i3 < mappedTrackInfo.d()) {
            int g2 = mappedTrackInfo.g(i3);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i3];
            if (g2 == 1 || exoTrackSelection == null) {
                if (g2 == 1 && exoTrackSelection != null && exoTrackSelection.length() == 1) {
                    if (e0(parameters, iArr[i3][mappedTrackInfo.h(i3).f(exoTrackSelection.d())][exoTrackSelection.k(0)], exoTrackSelection.o())) {
                        i4++;
                        i2 = i3;
                    }
                }
                i3++;
            } else {
                return;
            }
        }
        if (i4 == 1) {
            int i5 = parameters.l3.X ? 1 : 2;
            RendererConfiguration rendererConfiguration = rendererConfigurationArr[i2];
            if (rendererConfiguration != null && rendererConfiguration.f10444b) {
                z = true;
            }
            rendererConfigurationArr[i2] = new RendererConfiguration(i5, z);
        }
    }

    private static void a0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr) {
        boolean z;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            if (i2 >= mappedTrackInfo.d()) {
                z = true;
                break;
            }
            int g2 = mappedTrackInfo.g(i2);
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if ((g2 == 1 || g2 == 2) && exoTrackSelection != null && f0(iArr[i2], mappedTrackInfo.h(i2), exoTrackSelection)) {
                if (g2 == 1) {
                    if (i4 != -1) {
                        break;
                    }
                    i4 = i2;
                } else if (i3 != -1) {
                    break;
                } else {
                    i3 = i2;
                }
            }
            i2++;
        }
        z = false;
        if (z && ((i4 == -1 || i3 == -1) ? false : true)) {
            RendererConfiguration rendererConfiguration = new RendererConfiguration(0, true);
            rendererConfigurationArr[i4] = rendererConfiguration;
            rendererConfigurationArr[i3] = rendererConfiguration;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r1 = r3.f12380i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b0() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f12375d
            monitor-enter(r0)
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector$Parameters r1 = r3.f12379h     // Catch:{ all -> 0x001f }
            boolean r1 = r1.o4     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0021
            boolean r1 = r3.f12378g     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0021
            int r1 = androidx.media3.common.util.Util.f9646a     // Catch:{ all -> 0x001f }
            r2 = 32
            if (r1 < r2) goto L_0x0021
            androidx.media3.exoplayer.trackselection.DefaultTrackSelector$SpatializerWrapperV32 r1 = r3.f12380i     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0021
            boolean r1 = r1.e()     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0021
            r1 = 1
            goto L_0x0022
        L_0x001f:
            r1 = move-exception
            goto L_0x0029
        L_0x0021:
            r1 = 0
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0028
            r3.f()
        L_0x0028:
            return
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.DefaultTrackSelector.b0():void");
    }

    private void c0(Renderer renderer) {
        boolean z;
        synchronized (this.f12375d) {
            z = this.f12379h.s4;
        }
        if (z) {
            g(renderer);
        }
    }

    @Nullable
    protected static String d0(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.k1)) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: private */
    public static boolean e0(Parameters parameters, int i2, Format format) {
        if (V0.i(i2) == 0) {
            return false;
        }
        if (parameters.l3.Y && (V0.i(i2) & 2048) == 0) {
            return false;
        }
        if (!parameters.l3.X) {
            return true;
        }
        return !(format.v3 != 0 || format.w3 != 0) || ((V0.i(i2) & 1024) != 0);
    }

    private static boolean f0(int[][] iArr, TrackGroupArray trackGroupArray, ExoTrackSelection exoTrackSelection) {
        if (exoTrackSelection == null) {
            return false;
        }
        int f2 = trackGroupArray.f(exoTrackSelection.d());
        for (int i2 = 0; i2 < exoTrackSelection.length(); i2++) {
            if (V0.m(iArr[f2][exoTrackSelection.k(i2)]) != 32) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private <T extends TrackInfo<T>> Pair<ExoTrackSelection.Definition, Integer> l0(int i2, MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, TrackInfo.Factory<T> factory, Comparator<List<T>> comparator) {
        int i3;
        Object obj;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        int d2 = mappedTrackInfo.d();
        int i4 = 0;
        while (i4 < d2) {
            if (i2 == mappedTrackInfo2.g(i4)) {
                TrackGroupArray h2 = mappedTrackInfo2.h(i4);
                int i5 = 0;
                while (i5 < h2.s) {
                    TrackGroup d3 = h2.d(i5);
                    List<T> a2 = factory.a(i4, d3, iArr[i4][i5]);
                    boolean[] zArr = new boolean[d3.s];
                    int i6 = 0;
                    while (i6 < d3.s) {
                        TrackInfo trackInfo = (TrackInfo) a2.get(i6);
                        int a3 = trackInfo.a();
                        if (zArr[i6] || a3 == 0) {
                            i3 = d2;
                        } else {
                            if (a3 == 1) {
                                obj = ImmutableList.K(trackInfo);
                                i3 = d2;
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(trackInfo);
                                int i7 = i6 + 1;
                                while (i7 < d3.s) {
                                    TrackInfo trackInfo2 = (TrackInfo) a2.get(i7);
                                    int i8 = d2;
                                    if (trackInfo2.a() == 2 && trackInfo.b(trackInfo2)) {
                                        arrayList2.add(trackInfo2);
                                        zArr[i7] = true;
                                    }
                                    i7++;
                                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo3 = mappedTrackInfo;
                                    d2 = i8;
                                }
                                i3 = d2;
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        i6++;
                        MappingTrackSelector.MappedTrackInfo mappedTrackInfo4 = mappedTrackInfo;
                        d2 = i3;
                    }
                    int i9 = d2;
                    i5++;
                    MappingTrackSelector.MappedTrackInfo mappedTrackInfo5 = mappedTrackInfo;
                }
            }
            TrackInfo.Factory<T> factory2 = factory;
            i4++;
            mappedTrackInfo2 = mappedTrackInfo;
            d2 = d2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            iArr2[i10] = ((TrackInfo) list.get(i10)).Y;
        }
        TrackInfo trackInfo3 = (TrackInfo) list.get(0);
        return Pair.create(new ExoTrackSelection.Definition(trackInfo3.X, iArr2), Integer.valueOf(trackInfo3.s));
    }

    private void p0(Parameters parameters) {
        boolean z;
        Assertions.g(parameters);
        synchronized (this.f12375d) {
            z = !this.f12379h.equals(parameters);
            this.f12379h = parameters;
        }
        if (z) {
            if (parameters.o4 && this.f12376e == null) {
                Log.n(f12371k, f12372l);
            }
            f();
        }
    }

    public Parameters.Builder I() {
        return c().G();
    }

    /* renamed from: N */
    public Parameters c() {
        Parameters parameters;
        synchronized (this.f12375d) {
            parameters = this.f12379h;
        }
        return parameters;
    }

    public void a(Renderer renderer) {
        c0(renderer);
    }

    @Nullable
    public RendererCapabilities.Listener d() {
        return this;
    }

    /* access modifiers changed from: protected */
    public ExoTrackSelection.Definition[] g0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        int d2 = mappedTrackInfo.d();
        ExoTrackSelection.Definition[] definitionArr = new ExoTrackSelection.Definition[d2];
        Pair<ExoTrackSelection.Definition, Integer> m0 = m0(mappedTrackInfo, iArr, iArr2, parameters);
        String str = null;
        Pair<ExoTrackSelection.Definition, Integer> i0 = (parameters.q3 || m0 == null) ? i0(mappedTrackInfo, iArr, parameters) : null;
        if (i0 != null) {
            definitionArr[((Integer) i0.second).intValue()] = (ExoTrackSelection.Definition) i0.first;
        } else if (m0 != null) {
            definitionArr[((Integer) m0.second).intValue()] = (ExoTrackSelection.Definition) m0.first;
        }
        Pair<ExoTrackSelection.Definition, Integer> h0 = h0(mappedTrackInfo, iArr, iArr2, parameters);
        if (h0 != null) {
            definitionArr[((Integer) h0.second).intValue()] = (ExoTrackSelection.Definition) h0.first;
        }
        if (h0 != null) {
            Object obj = h0.first;
            str = ((ExoTrackSelection.Definition) obj).f12389a.d(((ExoTrackSelection.Definition) obj).f12390b[0]).Z;
        }
        Pair<ExoTrackSelection.Definition, Integer> k0 = k0(mappedTrackInfo, iArr, parameters, str);
        if (k0 != null) {
            definitionArr[((Integer) k0.second).intValue()] = (ExoTrackSelection.Definition) k0.first;
        }
        for (int i2 = 0; i2 < d2; i2++) {
            int g2 = mappedTrackInfo.g(i2);
            if (!(g2 == 2 || g2 == 1 || g2 == 3 || g2 == 4)) {
                definitionArr[i2] = j0(g2, mappedTrackInfo.h(i2), iArr[i2], parameters);
            }
        }
        return definitionArr;
    }

    public boolean h() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> h0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < mappedTrackInfo.d()) {
                if (2 == mappedTrackInfo.g(i2) && mappedTrackInfo.h(i2).s > 0) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return l0(1, mappedTrackInfo, iArr, new h(this, parameters, z, iArr2), new i());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> i0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, Parameters parameters) throws ExoPlaybackException {
        if (parameters.l3.s == 2) {
            return null;
        }
        return l0(4, mappedTrackInfo, iArr, new e(parameters), new f());
    }

    public void j() {
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f12375d) {
            try {
                if (Util.f9646a >= 32 && (spatializerWrapperV32 = this.f12380i) != null) {
                    spatializerWrapperV32.f();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        super.j();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ExoTrackSelection.Definition j0(int i2, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        if (parameters.l3.s == 2) {
            return null;
        }
        TrackGroup trackGroup = null;
        OtherTrackScore otherTrackScore = null;
        int i3 = 0;
        for (int i4 = 0; i4 < trackGroupArray.s; i4++) {
            TrackGroup d2 = trackGroupArray.d(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < d2.s; i5++) {
                if (S(iArr2[i5], parameters.p4)) {
                    OtherTrackScore otherTrackScore2 = new OtherTrackScore(d2.d(i5), iArr2[i5]);
                    if (otherTrackScore == null || otherTrackScore2.compareTo(otherTrackScore) > 0) {
                        trackGroup = d2;
                        i3 = i5;
                        otherTrackScore = otherTrackScore2;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new ExoTrackSelection.Definition(trackGroup, i3);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> k0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, Parameters parameters, @Nullable String str) throws ExoPlaybackException {
        if (parameters.l3.s == 2) {
            return null;
        }
        return l0(3, mappedTrackInfo, iArr, new l(parameters, str), new C0348c());
    }

    public void l(AudioAttributes audioAttributes) {
        boolean z;
        synchronized (this.f12375d) {
            z = !this.f12381j.equals(audioAttributes);
            this.f12381j = audioAttributes;
        }
        if (z) {
            b0();
        }
    }

    public void m(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters instanceof Parameters) {
            p0((Parameters) trackSelectionParameters);
        }
        p0(new Parameters.Builder().M(trackSelectionParameters).D());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Pair<ExoTrackSelection.Definition, Integer> m0(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        if (parameters.l3.s == 2) {
            return null;
        }
        return l0(2, mappedTrackInfo, iArr, new j(parameters, iArr2), new k());
    }

    public void n0(Parameters.Builder builder) {
        p0(builder.D());
    }

    @Deprecated
    public void o0(ParametersBuilder parametersBuilder) {
        p0(parametersBuilder.D());
    }

    /* access modifiers changed from: protected */
    public final Pair<RendererConfiguration[], ExoTrackSelection[]> r(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException {
        Parameters parameters;
        SpatializerWrapperV32 spatializerWrapperV32;
        synchronized (this.f12375d) {
            try {
                parameters = this.f12379h;
                if (parameters.o4 && Util.f9646a >= 32 && (spatializerWrapperV32 = this.f12380i) != null) {
                    spatializerWrapperV32.b(this, (Looper) Assertions.k(Looper.myLooper()));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        int d2 = mappedTrackInfo.d();
        ExoTrackSelection.Definition[] g0 = g0(mappedTrackInfo, iArr, iArr2, parameters);
        H(mappedTrackInfo, parameters, g0);
        G(mappedTrackInfo, parameters, g0);
        for (int i2 = 0; i2 < d2; i2++) {
            int g2 = mappedTrackInfo.g(i2);
            if (parameters.S(i2) || parameters.u3.contains(Integer.valueOf(g2))) {
                g0[i2] = null;
            }
        }
        ExoTrackSelection[] a2 = this.f12377f.a(g0, b(), mediaPeriodId, timeline);
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[d2];
        for (int i3 = 0; i3 < d2; i3++) {
            rendererConfigurationArr[i3] = (parameters.S(i3) || parameters.u3.contains(Integer.valueOf(mappedTrackInfo.g(i3))) || (mappedTrackInfo.g(i3) != -2 && a2[i3] == null)) ? null : RendererConfiguration.f10442c;
        }
        if (parameters.q4) {
            a0(mappedTrackInfo, iArr, rendererConfigurationArr, a2);
        }
        if (parameters.l3.s != 0) {
            Z(parameters, mappedTrackInfo, iArr, rendererConfigurationArr, a2);
        }
        return Pair.create(rendererConfigurationArr, a2);
    }

    public DefaultTrackSelector(Context context, TrackSelectionParameters trackSelectionParameters) {
        this(context, trackSelectionParameters, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context, TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, context);
    }

    public DefaultTrackSelector(Context context, ExoTrackSelection.Factory factory) {
        this(context, (TrackSelectionParameters) Parameters.Q(context), factory);
    }

    @Deprecated
    public DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory) {
        this(trackSelectionParameters, factory, (Context) null);
    }

    private DefaultTrackSelector(TrackSelectionParameters trackSelectionParameters, ExoTrackSelection.Factory factory, @Nullable Context context) {
        Parameters M0;
        this.f12375d = new Object();
        this.f12376e = context != null ? context.getApplicationContext() : null;
        this.f12377f = factory;
        if (trackSelectionParameters instanceof Parameters) {
            M0 = (Parameters) trackSelectionParameters;
        } else {
            M0 = (context == null ? Parameters.v4 : Parameters.Q(context)).G().M(trackSelectionParameters).D();
        }
        this.f12379h = M0;
        this.f12381j = AudioAttributes.Z2;
        boolean z = context != null && Util.q1(context);
        this.f12378g = z;
        if (!z && context != null && Util.f9646a >= 32) {
            this.f12380i = SpatializerWrapperV32.g(context);
        }
        if (this.f12379h.o4 && context == null) {
            Log.n(f12371k, f12372l);
        }
    }
}

package androidx.media3.common;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class TrackSelectionParameters implements Bundleable {
    /* access modifiers changed from: private */
    public static final String A3 = Util.d1(4);
    /* access modifiers changed from: private */
    public static final String B3 = Util.d1(5);
    /* access modifiers changed from: private */
    public static final String C3 = Util.d1(6);
    /* access modifiers changed from: private */
    public static final String D3 = Util.d1(7);
    /* access modifiers changed from: private */
    public static final String E3 = Util.d1(8);
    /* access modifiers changed from: private */
    public static final String F3 = Util.d1(9);
    /* access modifiers changed from: private */
    public static final String G3 = Util.d1(10);
    /* access modifiers changed from: private */
    public static final String H3 = Util.d1(11);
    /* access modifiers changed from: private */
    public static final String I3 = Util.d1(12);
    /* access modifiers changed from: private */
    public static final String J3 = Util.d1(13);
    /* access modifiers changed from: private */
    public static final String K3 = Util.d1(14);
    /* access modifiers changed from: private */
    public static final String L3 = Util.d1(15);
    /* access modifiers changed from: private */
    public static final String M3 = Util.d1(16);
    /* access modifiers changed from: private */
    public static final String N3 = Util.d1(17);
    /* access modifiers changed from: private */
    public static final String O3 = Util.d1(18);
    /* access modifiers changed from: private */
    public static final String P3 = Util.d1(19);
    /* access modifiers changed from: private */
    public static final String Q3 = Util.d1(20);
    /* access modifiers changed from: private */
    public static final String R3 = Util.d1(21);
    /* access modifiers changed from: private */
    public static final String S3 = Util.d1(22);
    /* access modifiers changed from: private */
    public static final String T3 = Util.d1(23);
    /* access modifiers changed from: private */
    public static final String U3 = Util.d1(24);
    /* access modifiers changed from: private */
    public static final String V3 = Util.d1(25);
    /* access modifiers changed from: private */
    public static final String W3 = Util.d1(26);
    /* access modifiers changed from: private */
    public static final String X3 = Util.d1(27);
    /* access modifiers changed from: private */
    public static final String Y3 = Util.d1(28);
    /* access modifiers changed from: private */
    public static final String Z3 = Util.d1(29);
    /* access modifiers changed from: private */
    public static final String a4 = Util.d1(30);
    /* access modifiers changed from: private */
    public static final String b4 = Util.d1(31);
    @UnstableApi
    protected static final int c4 = 1000;
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<TrackSelectionParameters> d4 = new q1();
    @UnstableApi
    public static final TrackSelectionParameters v3;
    @UnstableApi
    @Deprecated
    public static final TrackSelectionParameters w3;
    /* access modifiers changed from: private */
    public static final String x3 = Util.d1(1);
    /* access modifiers changed from: private */
    public static final String y3 = Util.d1(2);
    /* access modifiers changed from: private */
    public static final String z3 = Util.d1(3);
    public final int X;
    public final int X2;
    public final int Y;
    public final int Y2;
    public final int Z;
    public final int Z2;
    public final int a3;
    public final int b3;
    public final int c3;
    public final boolean d3;
    public final ImmutableList<String> e3;
    public final int f3;
    public final ImmutableList<String> g3;
    public final int h3;
    public final int i3;
    public final int j3;
    public final ImmutableList<String> k3;
    @UnstableApi
    public final AudioOffloadPreferences l3;
    public final ImmutableList<String> m3;
    public final int n3;
    public final int o3;
    public final boolean p3;
    @UnstableApi
    public final boolean q3;
    public final boolean r3;
    public final int s;
    public final boolean s3;
    public final ImmutableMap<TrackGroup, TrackSelectionOverride> t3;
    public final ImmutableSet<Integer> u3;

    @UnstableApi
    public static final class AudioOffloadPreferences implements Bundleable {
        public static final int X2 = 1;
        public static final int Y2 = 0;
        public static final int Z = 2;
        public static final AudioOffloadPreferences Z2 = new Builder().d();
        private static final String a3 = Util.d1(1);
        private static final String b3 = Util.d1(2);
        private static final String c3 = Util.d1(3);
        public final boolean X;
        public final boolean Y;
        public final int s;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface AudioOffloadMode {
        }

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f9340a = 0;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public boolean f9341b = false;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public boolean f9342c = false;

            public AudioOffloadPreferences d() {
                return new AudioOffloadPreferences(this);
            }

            @CanIgnoreReturnValue
            public Builder e(int i2) {
                this.f9340a = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder f(boolean z) {
                this.f9341b = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder g(boolean z) {
                this.f9342c = z;
                return this;
            }
        }

        private AudioOffloadPreferences(Builder builder) {
            this.s = builder.f9340a;
            this.X = builder.f9341b;
            this.Y = builder.f9342c;
        }

        public static AudioOffloadPreferences c(Bundle bundle) {
            Builder builder = new Builder();
            String str = a3;
            AudioOffloadPreferences audioOffloadPreferences = Z2;
            return builder.e(bundle.getInt(str, audioOffloadPreferences.s)).f(bundle.getBoolean(b3, audioOffloadPreferences.X)).g(bundle.getBoolean(c3, audioOffloadPreferences.Y)).d();
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putInt(a3, this.s);
            bundle.putBoolean(b3, this.X);
            bundle.putBoolean(c3, this.Y);
            return bundle;
        }

        public Builder b() {
            return new Builder().e(this.s).f(this.X).g(this.Y);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || AudioOffloadPreferences.class != obj.getClass()) {
                return false;
            }
            AudioOffloadPreferences audioOffloadPreferences = (AudioOffloadPreferences) obj;
            return this.s == audioOffloadPreferences.s && this.X == audioOffloadPreferences.X && this.Y == audioOffloadPreferences.Y;
        }

        public int hashCode() {
            return ((((this.s + 31) * 31) + (this.X ? 1 : 0)) * 31) + (this.Y ? 1 : 0);
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public HashMap<TrackGroup, TrackSelectionOverride> A;
        /* access modifiers changed from: private */
        public HashSet<Integer> B;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f9343a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f9344b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f9345c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f9346d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f9347e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f9348f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f9349g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f9350h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f9351i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public int f9352j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public boolean f9353k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public ImmutableList<String> f9354l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f9355m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public ImmutableList<String> f9356n;
        /* access modifiers changed from: private */
        public int o;
        /* access modifiers changed from: private */
        public int p;
        /* access modifiers changed from: private */
        public int q;
        /* access modifiers changed from: private */
        public ImmutableList<String> r;
        /* access modifiers changed from: private */
        public AudioOffloadPreferences s;
        /* access modifiers changed from: private */
        public ImmutableList<String> t;
        /* access modifiers changed from: private */
        public int u;
        /* access modifiers changed from: private */
        public int v;
        /* access modifiers changed from: private */
        public boolean w;
        /* access modifiers changed from: private */
        public boolean x;
        /* access modifiers changed from: private */
        public boolean y;
        /* access modifiers changed from: private */
        public boolean z;

        @UnstableApi
        @Deprecated
        public Builder() {
            this.f9343a = Integer.MAX_VALUE;
            this.f9344b = Integer.MAX_VALUE;
            this.f9345c = Integer.MAX_VALUE;
            this.f9346d = Integer.MAX_VALUE;
            this.f9351i = Integer.MAX_VALUE;
            this.f9352j = Integer.MAX_VALUE;
            this.f9353k = true;
            this.f9354l = ImmutableList.I();
            this.f9355m = 0;
            this.f9356n = ImmutableList.I();
            this.o = 0;
            this.p = Integer.MAX_VALUE;
            this.q = Integer.MAX_VALUE;
            this.r = ImmutableList.I();
            this.s = AudioOffloadPreferences.Z2;
            this.t = ImmutableList.I();
            this.u = 0;
            this.v = 0;
            this.w = false;
            this.x = false;
            this.y = false;
            this.z = false;
            this.A = new HashMap<>();
            this.B = new HashSet<>();
        }

        private static AudioOffloadPreferences J(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(TrackSelectionParameters.a4);
            if (bundle2 != null) {
                return AudioOffloadPreferences.c(bundle2);
            }
            AudioOffloadPreferences.Builder builder = new AudioOffloadPreferences.Builder();
            String z2 = TrackSelectionParameters.X3;
            AudioOffloadPreferences audioOffloadPreferences = AudioOffloadPreferences.Z2;
            return builder.e(bundle.getInt(z2, audioOffloadPreferences.s)).f(bundle.getBoolean(TrackSelectionParameters.Y3, audioOffloadPreferences.X)).g(bundle.getBoolean(TrackSelectionParameters.Z3, audioOffloadPreferences.Y)).d();
        }

        @EnsuresNonNull({"preferredVideoMimeTypes", "preferredAudioLanguages", "preferredAudioMimeTypes", "audioOffloadPreferences", "preferredTextLanguages", "overrides", "disabledTrackTypes"})
        private void K(TrackSelectionParameters trackSelectionParameters) {
            this.f9343a = trackSelectionParameters.s;
            this.f9344b = trackSelectionParameters.X;
            this.f9345c = trackSelectionParameters.Y;
            this.f9346d = trackSelectionParameters.Z;
            this.f9347e = trackSelectionParameters.X2;
            this.f9348f = trackSelectionParameters.Y2;
            this.f9349g = trackSelectionParameters.Z2;
            this.f9350h = trackSelectionParameters.a3;
            this.f9351i = trackSelectionParameters.b3;
            this.f9352j = trackSelectionParameters.c3;
            this.f9353k = trackSelectionParameters.d3;
            this.f9354l = trackSelectionParameters.e3;
            this.f9355m = trackSelectionParameters.f3;
            this.f9356n = trackSelectionParameters.g3;
            this.o = trackSelectionParameters.h3;
            this.p = trackSelectionParameters.i3;
            this.q = trackSelectionParameters.j3;
            this.r = trackSelectionParameters.k3;
            this.s = trackSelectionParameters.l3;
            this.t = trackSelectionParameters.m3;
            this.u = trackSelectionParameters.n3;
            this.v = trackSelectionParameters.o3;
            this.w = trackSelectionParameters.p3;
            this.x = trackSelectionParameters.q3;
            this.y = trackSelectionParameters.r3;
            this.z = trackSelectionParameters.s3;
            this.B = new HashSet<>(trackSelectionParameters.u3);
            this.A = new HashMap<>(trackSelectionParameters.t3);
        }

        private static ImmutableList<String> L(String[] strArr) {
            ImmutableList.Builder r2 = ImmutableList.r();
            for (String g2 : (String[]) Assertions.g(strArr)) {
                r2.g(Util.L1((String) Assertions.g(g2)));
            }
            return r2.e();
        }

        @RequiresApi(19)
        private void j0(Context context) {
            CaptioningManager captioningManager;
            if ((Util.f9646a >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.u = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.t = ImmutableList.K(Util.x0(locale));
                }
            }
        }

        @CanIgnoreReturnValue
        public Builder C(TrackSelectionOverride trackSelectionOverride) {
            this.A.put(trackSelectionOverride.s, trackSelectionOverride);
            return this;
        }

        public TrackSelectionParameters D() {
            return new TrackSelectionParameters(this);
        }

        @CanIgnoreReturnValue
        public Builder E(TrackGroup trackGroup) {
            this.A.remove(trackGroup);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder F() {
            this.A.clear();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder G(int i2) {
            Iterator<TrackSelectionOverride> it2 = this.A.values().iterator();
            while (it2.hasNext()) {
                if (it2.next().c() == i2) {
                    it2.remove();
                }
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder H() {
            return W(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        @CanIgnoreReturnValue
        public Builder I() {
            return s0(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        /* access modifiers changed from: protected */
        @UnstableApi
        @CanIgnoreReturnValue
        public Builder M(TrackSelectionParameters trackSelectionParameters) {
            K(trackSelectionParameters);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder N(AudioOffloadPreferences audioOffloadPreferences) {
            this.s = audioOffloadPreferences;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder O(Set<Integer> set) {
            this.B.clear();
            this.B.addAll(set);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder P(boolean z2) {
            this.z = z2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder Q(boolean z2) {
            this.y = z2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder R(int i2) {
            this.v = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder S(int i2) {
            this.q = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder T(int i2) {
            this.p = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder U(int i2) {
            this.f9346d = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder V(int i2) {
            this.f9345c = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder W(int i2, int i3) {
            this.f9343a = i2;
            this.f9344b = i3;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder X() {
            return W(AdaptiveTrackSelection.D, AdaptiveTrackSelection.E);
        }

        @CanIgnoreReturnValue
        public Builder Y(int i2) {
            this.f9350h = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder Z(int i2) {
            this.f9349g = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder a0(int i2, int i3) {
            this.f9347e = i2;
            this.f9348f = i3;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder b0(TrackSelectionOverride trackSelectionOverride) {
            G(trackSelectionOverride.c());
            this.A.put(trackSelectionOverride.s, trackSelectionOverride);
            return this;
        }

        public Builder c0(@Nullable String str) {
            return str == null ? d0(new String[0]) : d0(str);
        }

        @CanIgnoreReturnValue
        public Builder d0(String... strArr) {
            this.f9356n = L(strArr);
            return this;
        }

        public Builder e0(@Nullable String str) {
            return str == null ? f0(new String[0]) : f0(str);
        }

        @CanIgnoreReturnValue
        public Builder f0(String... strArr) {
            this.r = ImmutableList.D(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g0(int i2) {
            this.o = i2;
            return this;
        }

        public Builder h0(@Nullable String str) {
            return str == null ? k0(new String[0]) : k0(str);
        }

        @CanIgnoreReturnValue
        public Builder i0(Context context) {
            if (Util.f9646a >= 19) {
                j0(context);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder k0(String... strArr) {
            this.t = L(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder l0(int i2) {
            this.u = i2;
            return this;
        }

        public Builder m0(@Nullable String str) {
            return str == null ? n0(new String[0]) : n0(str);
        }

        @CanIgnoreReturnValue
        public Builder n0(String... strArr) {
            this.f9354l = ImmutableList.D(strArr);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder o0(int i2) {
            this.f9355m = i2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder p0(boolean z2) {
            this.x = z2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder q0(boolean z2) {
            this.w = z2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder r0(int i2, boolean z2) {
            if (z2) {
                this.B.add(Integer.valueOf(i2));
            } else {
                this.B.remove(Integer.valueOf(i2));
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder s0(int i2, int i3, boolean z2) {
            this.f9351i = i2;
            this.f9352j = i3;
            this.f9353k = z2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder t0(Context context, boolean z2) {
            Point j0 = Util.j0(context);
            return s0(j0.x, j0.y, z2);
        }

        public Builder(Context context) {
            this();
            i0(context);
            t0(context, true);
        }

        @UnstableApi
        protected Builder(Bundle bundle) {
            String b2 = TrackSelectionParameters.C3;
            TrackSelectionParameters trackSelectionParameters = TrackSelectionParameters.v3;
            this.f9343a = bundle.getInt(b2, trackSelectionParameters.s);
            this.f9344b = bundle.getInt(TrackSelectionParameters.D3, trackSelectionParameters.X);
            this.f9345c = bundle.getInt(TrackSelectionParameters.E3, trackSelectionParameters.Y);
            this.f9346d = bundle.getInt(TrackSelectionParameters.F3, trackSelectionParameters.Z);
            this.f9347e = bundle.getInt(TrackSelectionParameters.G3, trackSelectionParameters.X2);
            this.f9348f = bundle.getInt(TrackSelectionParameters.H3, trackSelectionParameters.Y2);
            this.f9349g = bundle.getInt(TrackSelectionParameters.I3, trackSelectionParameters.Z2);
            this.f9350h = bundle.getInt(TrackSelectionParameters.J3, trackSelectionParameters.a3);
            this.f9351i = bundle.getInt(TrackSelectionParameters.K3, trackSelectionParameters.b3);
            this.f9352j = bundle.getInt(TrackSelectionParameters.L3, trackSelectionParameters.c3);
            this.f9353k = bundle.getBoolean(TrackSelectionParameters.M3, trackSelectionParameters.d3);
            this.f9354l = ImmutableList.D((String[]) MoreObjects.a(bundle.getStringArray(TrackSelectionParameters.N3), new String[0]));
            this.f9355m = bundle.getInt(TrackSelectionParameters.V3, trackSelectionParameters.f3);
            this.f9356n = L((String[]) MoreObjects.a(bundle.getStringArray(TrackSelectionParameters.x3), new String[0]));
            this.o = bundle.getInt(TrackSelectionParameters.y3, trackSelectionParameters.h3);
            this.p = bundle.getInt(TrackSelectionParameters.O3, trackSelectionParameters.i3);
            this.q = bundle.getInt(TrackSelectionParameters.P3, trackSelectionParameters.j3);
            this.r = ImmutableList.D((String[]) MoreObjects.a(bundle.getStringArray(TrackSelectionParameters.Q3), new String[0]));
            this.s = J(bundle);
            this.t = L((String[]) MoreObjects.a(bundle.getStringArray(TrackSelectionParameters.z3), new String[0]));
            this.u = bundle.getInt(TrackSelectionParameters.A3, trackSelectionParameters.n3);
            this.v = bundle.getInt(TrackSelectionParameters.W3, trackSelectionParameters.o3);
            this.w = bundle.getBoolean(TrackSelectionParameters.B3, trackSelectionParameters.p3);
            this.x = bundle.getBoolean(TrackSelectionParameters.b4, trackSelectionParameters.q3);
            this.y = bundle.getBoolean(TrackSelectionParameters.R3, trackSelectionParameters.r3);
            this.z = bundle.getBoolean(TrackSelectionParameters.S3, trackSelectionParameters.s3);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(TrackSelectionParameters.T3);
            ImmutableList I = parcelableArrayList == null ? ImmutableList.I() : BundleCollectionUtil.d(new r1(), parcelableArrayList);
            this.A = new HashMap<>();
            for (int i2 = 0; i2 < I.size(); i2++) {
                TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) I.get(i2);
                this.A.put(trackSelectionOverride.s, trackSelectionOverride);
            }
            int[] iArr = (int[]) MoreObjects.a(bundle.getIntArray(TrackSelectionParameters.U3), new int[0]);
            this.B = new HashSet<>();
            for (int valueOf : iArr) {
                this.B.add(Integer.valueOf(valueOf));
            }
        }

        @UnstableApi
        protected Builder(TrackSelectionParameters trackSelectionParameters) {
            K(trackSelectionParameters);
        }
    }

    static {
        TrackSelectionParameters D = new Builder().D();
        v3 = D;
        w3 = D;
    }

    @UnstableApi
    protected TrackSelectionParameters(Builder builder) {
        this.s = builder.f9343a;
        this.X = builder.f9344b;
        this.Y = builder.f9345c;
        this.Z = builder.f9346d;
        this.X2 = builder.f9347e;
        this.Y2 = builder.f9348f;
        this.Z2 = builder.f9349g;
        this.a3 = builder.f9350h;
        this.b3 = builder.f9351i;
        this.c3 = builder.f9352j;
        this.d3 = builder.f9353k;
        this.e3 = builder.f9354l;
        this.f3 = builder.f9355m;
        this.g3 = builder.f9356n;
        this.h3 = builder.o;
        this.i3 = builder.p;
        this.j3 = builder.q;
        this.k3 = builder.r;
        this.l3 = builder.s;
        this.m3 = builder.t;
        this.n3 = builder.u;
        this.o3 = builder.v;
        this.p3 = builder.w;
        this.q3 = builder.x;
        this.r3 = builder.y;
        this.s3 = builder.z;
        this.t3 = ImmutableMap.g(builder.A);
        this.u3 = ImmutableSet.C(builder.B);
    }

    public static TrackSelectionParameters H(Bundle bundle) {
        return new Builder(bundle).D();
    }

    public static TrackSelectionParameters I(Context context) {
        return new Builder(context).D();
    }

    public Builder G() {
        return new Builder(this);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(C3, this.s);
        bundle.putInt(D3, this.X);
        bundle.putInt(E3, this.Y);
        bundle.putInt(F3, this.Z);
        bundle.putInt(G3, this.X2);
        bundle.putInt(H3, this.Y2);
        bundle.putInt(I3, this.Z2);
        bundle.putInt(J3, this.a3);
        bundle.putInt(K3, this.b3);
        bundle.putInt(L3, this.c3);
        bundle.putBoolean(M3, this.d3);
        bundle.putStringArray(N3, (String[]) this.e3.toArray(new String[0]));
        bundle.putInt(V3, this.f3);
        bundle.putStringArray(x3, (String[]) this.g3.toArray(new String[0]));
        bundle.putInt(y3, this.h3);
        bundle.putInt(O3, this.i3);
        bundle.putInt(P3, this.j3);
        bundle.putStringArray(Q3, (String[]) this.k3.toArray(new String[0]));
        bundle.putStringArray(z3, (String[]) this.m3.toArray(new String[0]));
        bundle.putInt(A3, this.n3);
        bundle.putInt(W3, this.o3);
        bundle.putBoolean(B3, this.p3);
        bundle.putInt(X3, this.l3.s);
        bundle.putBoolean(Y3, this.l3.X);
        bundle.putBoolean(Z3, this.l3.Y);
        bundle.putBundle(a4, this.l3.a());
        bundle.putBoolean(b4, this.q3);
        bundle.putBoolean(R3, this.r3);
        bundle.putBoolean(S3, this.s3);
        bundle.putParcelableArrayList(T3, BundleCollectionUtil.i(this.t3.values(), new p1()));
        bundle.putIntArray(U3, Ints.D(this.u3));
        return bundle;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.s == trackSelectionParameters.s && this.X == trackSelectionParameters.X && this.Y == trackSelectionParameters.Y && this.Z == trackSelectionParameters.Z && this.X2 == trackSelectionParameters.X2 && this.Y2 == trackSelectionParameters.Y2 && this.Z2 == trackSelectionParameters.Z2 && this.a3 == trackSelectionParameters.a3 && this.d3 == trackSelectionParameters.d3 && this.b3 == trackSelectionParameters.b3 && this.c3 == trackSelectionParameters.c3 && this.e3.equals(trackSelectionParameters.e3) && this.f3 == trackSelectionParameters.f3 && this.g3.equals(trackSelectionParameters.g3) && this.h3 == trackSelectionParameters.h3 && this.i3 == trackSelectionParameters.i3 && this.j3 == trackSelectionParameters.j3 && this.k3.equals(trackSelectionParameters.k3) && this.l3.equals(trackSelectionParameters.l3) && this.m3.equals(trackSelectionParameters.m3) && this.n3 == trackSelectionParameters.n3 && this.o3 == trackSelectionParameters.o3 && this.p3 == trackSelectionParameters.p3 && this.q3 == trackSelectionParameters.q3 && this.r3 == trackSelectionParameters.r3 && this.s3 == trackSelectionParameters.s3 && this.t3.equals(trackSelectionParameters.t3) && this.u3.equals(trackSelectionParameters.u3);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((this.s + 31) * 31) + this.X) * 31) + this.Y) * 31) + this.Z) * 31) + this.X2) * 31) + this.Y2) * 31) + this.Z2) * 31) + this.a3) * 31) + (this.d3 ? 1 : 0)) * 31) + this.b3) * 31) + this.c3) * 31) + this.e3.hashCode()) * 31) + this.f3) * 31) + this.g3.hashCode()) * 31) + this.h3) * 31) + this.i3) * 31) + this.j3) * 31) + this.k3.hashCode()) * 31) + this.l3.hashCode()) * 31) + this.m3.hashCode()) * 31) + this.n3) * 31) + this.o3) * 31) + (this.p3 ? 1 : 0)) * 31) + (this.q3 ? 1 : 0)) * 31) + (this.r3 ? 1 : 0)) * 31) + (this.s3 ? 1 : 0)) * 31) + this.t3.hashCode()) * 31) + this.u3.hashCode();
    }
}

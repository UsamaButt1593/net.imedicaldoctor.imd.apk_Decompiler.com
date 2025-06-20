package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class MediaItem implements Bundleable {
    public static final String b3 = "";
    public static final MediaItem c3 = new Builder().a();
    private static final String d3 = Util.d1(0);
    private static final String e3 = Util.d1(1);
    private static final String f3 = Util.d1(2);
    private static final String g3 = Util.d1(3);
    private static final String h3 = Util.d1(4);
    private static final String i3 = Util.d1(5);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<MediaItem> j3 = new C0171s();
    @Nullable
    public final LocalConfiguration X;
    public final MediaMetadata X2;
    @UnstableApi
    @Deprecated
    @Nullable
    public final LocalConfiguration Y;
    public final ClippingConfiguration Y2;
    public final LiveConfiguration Z;
    @UnstableApi
    @Deprecated
    public final ClippingProperties Z2;
    public final RequestMetadata a3;
    public final String s;

    public static final class AdsConfiguration implements Bundleable {
        private static final String Y = Util.d1(0);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<AdsConfiguration> Z = new C0173t();
        @Nullable
        public final Object X;
        public final Uri s;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Uri f9160a;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            public Object f9161b;

            public Builder(Uri uri) {
                this.f9160a = uri;
            }

            public AdsConfiguration c() {
                return new AdsConfiguration(this);
            }

            @CanIgnoreReturnValue
            public Builder d(Uri uri) {
                this.f9160a = uri;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder e(@Nullable Object obj) {
                this.f9161b = obj;
                return this;
            }
        }

        private AdsConfiguration(Builder builder) {
            this.s = builder.f9160a;
            this.X = builder.f9161b;
        }

        @UnstableApi
        public static AdsConfiguration c(Bundle bundle) {
            Uri uri = (Uri) bundle.getParcelable(Y);
            Assertions.g(uri);
            return new Builder(uri).c();
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Y, this.s);
            return bundle;
        }

        public Builder b() {
            return new Builder(this.s).e(this.X);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdsConfiguration)) {
                return false;
            }
            AdsConfiguration adsConfiguration = (AdsConfiguration) obj;
            return this.s.equals(adsConfiguration.s) && Util.g(this.X, adsConfiguration.X);
        }

        public int hashCode() {
            int hashCode = this.s.hashCode() * 31;
            Object obj = this.X;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private String f9162a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Uri f9163b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f9164c;

        /* renamed from: d  reason: collision with root package name */
        private ClippingConfiguration.Builder f9165d;

        /* renamed from: e  reason: collision with root package name */
        private DrmConfiguration.Builder f9166e;

        /* renamed from: f  reason: collision with root package name */
        private List<StreamKey> f9167f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private String f9168g;

        /* renamed from: h  reason: collision with root package name */
        private ImmutableList<SubtitleConfiguration> f9169h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private AdsConfiguration f9170i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private Object f9171j;

        /* renamed from: k  reason: collision with root package name */
        private long f9172k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private MediaMetadata f9173l;

        /* renamed from: m  reason: collision with root package name */
        private LiveConfiguration.Builder f9174m;

        /* renamed from: n  reason: collision with root package name */
        private RequestMetadata f9175n;

        public Builder() {
            this.f9165d = new ClippingConfiguration.Builder();
            this.f9166e = new DrmConfiguration.Builder();
            this.f9167f = Collections.emptyList();
            this.f9169h = ImmutableList.I();
            this.f9174m = new LiveConfiguration.Builder();
            this.f9175n = RequestMetadata.Z;
            this.f9172k = C.f9084b;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder A(float f2) {
            this.f9174m.h(f2);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder B(long j2) {
            this.f9174m.i(j2);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder C(float f2) {
            this.f9174m.j(f2);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder D(long j2) {
            this.f9174m.k(j2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder E(String str) {
            this.f9162a = (String) Assertions.g(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder F(MediaMetadata mediaMetadata) {
            this.f9173l = mediaMetadata;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder G(@Nullable String str) {
            this.f9164c = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder H(RequestMetadata requestMetadata) {
            this.f9175n = requestMetadata;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder I(@Nullable List<StreamKey> list) {
            this.f9167f = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder J(List<SubtitleConfiguration> list) {
            this.f9169h = ImmutableList.B(list);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder K(@Nullable List<Subtitle> list) {
            this.f9169h = list != null ? ImmutableList.B(list) : ImmutableList.I();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder L(@Nullable Object obj) {
            this.f9171j = obj;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder M(@Nullable Uri uri) {
            this.f9163b = uri;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder N(@Nullable String str) {
            return M(str == null ? null : Uri.parse(str));
        }

        public MediaItem a() {
            LocalConfiguration localConfiguration;
            Assertions.i(this.f9166e.f9182b == null || this.f9166e.f9181a != null);
            Uri uri = this.f9163b;
            DrmConfiguration drmConfiguration = null;
            if (uri != null) {
                String str = this.f9164c;
                if (this.f9166e.f9181a != null) {
                    drmConfiguration = this.f9166e.j();
                }
                localConfiguration = new LocalConfiguration(uri, str, drmConfiguration, this.f9170i, this.f9167f, this.f9168g, this.f9169h, this.f9171j, this.f9172k);
            } else {
                localConfiguration = null;
            }
            String str2 = this.f9162a;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingProperties g2 = this.f9165d.g();
            LiveConfiguration f2 = this.f9174m.f();
            MediaMetadata mediaMetadata = this.f9173l;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.O4;
            }
            return new MediaItem(str3, g2, localConfiguration, f2, mediaMetadata, this.f9175n);
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder b(@Nullable Uri uri) {
            return c(uri, (Object) null);
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder c(@Nullable Uri uri, @Nullable Object obj) {
            this.f9170i = uri != null ? new AdsConfiguration.Builder(uri).e(obj).c() : null;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder d(@Nullable String str) {
            return b(str != null ? Uri.parse(str) : null);
        }

        @CanIgnoreReturnValue
        public Builder e(@Nullable AdsConfiguration adsConfiguration) {
            this.f9170i = adsConfiguration;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder f(long j2) {
            this.f9165d.h(j2);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder g(boolean z) {
            this.f9165d.j(z);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder h(boolean z) {
            this.f9165d.k(z);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder i(@IntRange(from = 0) long j2) {
            this.f9165d.l(j2);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder j(boolean z) {
            this.f9165d.n(z);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder k(ClippingConfiguration clippingConfiguration) {
            this.f9165d = clippingConfiguration.b();
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder l(@Nullable String str) {
            this.f9168g = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder m(@Nullable DrmConfiguration drmConfiguration) {
            this.f9166e = drmConfiguration != null ? drmConfiguration.c() : new DrmConfiguration.Builder();
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder n(boolean z) {
            this.f9166e.l(z);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder o(@Nullable byte[] bArr) {
            this.f9166e.o(bArr);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder p(@Nullable Map<String, String> map) {
            DrmConfiguration.Builder builder = this.f9166e;
            if (map == null) {
                map = ImmutableMap.s();
            }
            builder.p(map);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder q(@Nullable Uri uri) {
            this.f9166e.q(uri);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder r(@Nullable String str) {
            this.f9166e.r(str);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder s(boolean z) {
            this.f9166e.s(z);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder t(boolean z) {
            this.f9166e.u(z);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder u(boolean z) {
            this.f9166e.m(z);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder v(@Nullable List<Integer> list) {
            DrmConfiguration.Builder builder = this.f9166e;
            if (list == null) {
                list = ImmutableList.I();
            }
            builder.n(list);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder w(@Nullable UUID uuid) {
            DrmConfiguration.Builder unused = this.f9166e.t(uuid);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder x(long j2) {
            Assertions.a(j2 > 0 || j2 == C.f9084b);
            this.f9172k = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder y(LiveConfiguration liveConfiguration) {
            this.f9174m = liveConfiguration.b();
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder z(long j2) {
            this.f9174m.g(j2);
            return this;
        }

        private Builder(MediaItem mediaItem) {
            this();
            this.f9165d = mediaItem.Y2.b();
            this.f9162a = mediaItem.s;
            this.f9173l = mediaItem.X2;
            this.f9174m = mediaItem.Z.b();
            this.f9175n = mediaItem.a3;
            LocalConfiguration localConfiguration = mediaItem.X;
            if (localConfiguration != null) {
                this.f9168g = localConfiguration.Y2;
                this.f9164c = localConfiguration.X;
                this.f9163b = localConfiguration.s;
                this.f9167f = localConfiguration.X2;
                this.f9169h = localConfiguration.Z2;
                this.f9171j = localConfiguration.b3;
                DrmConfiguration drmConfiguration = localConfiguration.Y;
                this.f9166e = drmConfiguration != null ? drmConfiguration.c() : new DrmConfiguration.Builder();
                this.f9170i = localConfiguration.Z;
                this.f9172k = localConfiguration.c3;
            }
        }
    }

    public static class ClippingConfiguration implements Bundleable {
        public static final ClippingConfiguration a3 = new Builder().f();
        private static final String b3 = Util.d1(0);
        private static final String c3 = Util.d1(1);
        private static final String d3 = Util.d1(2);
        private static final String e3 = Util.d1(3);
        private static final String f3 = Util.d1(4);
        static final String g3 = Util.d1(5);
        static final String h3 = Util.d1(6);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<ClippingProperties> i3 = new C0175u();
        @UnstableApi
        @IntRange(from = 0)
        public final long X;
        public final boolean X2;
        public final long Y;
        public final boolean Y2;
        @UnstableApi
        public final long Z;
        public final boolean Z2;
        @IntRange(from = 0)
        public final long s;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f9176a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f9177b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public boolean f9178c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public boolean f9179d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public boolean f9180e;

            public Builder() {
                this.f9177b = Long.MIN_VALUE;
            }

            public ClippingConfiguration f() {
                return new ClippingConfiguration(this);
            }

            @UnstableApi
            @Deprecated
            public ClippingProperties g() {
                return new ClippingProperties(this);
            }

            @CanIgnoreReturnValue
            public Builder h(long j2) {
                return i(Util.I1(j2));
            }

            @UnstableApi
            @CanIgnoreReturnValue
            public Builder i(long j2) {
                Assertions.a(j2 == Long.MIN_VALUE || j2 >= 0);
                this.f9177b = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder j(boolean z) {
                this.f9179d = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder k(boolean z) {
                this.f9178c = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder l(@IntRange(from = 0) long j2) {
                return m(Util.I1(j2));
            }

            @UnstableApi
            @CanIgnoreReturnValue
            public Builder m(@IntRange(from = 0) long j2) {
                Assertions.a(j2 >= 0);
                this.f9176a = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder n(boolean z) {
                this.f9180e = z;
                return this;
            }

            private Builder(ClippingConfiguration clippingConfiguration) {
                this.f9176a = clippingConfiguration.X;
                this.f9177b = clippingConfiguration.Z;
                this.f9178c = clippingConfiguration.X2;
                this.f9179d = clippingConfiguration.Y2;
                this.f9180e = clippingConfiguration.Z2;
            }
        }

        private ClippingConfiguration(Builder builder) {
            this.s = Util.H2(builder.f9176a);
            this.Y = Util.H2(builder.f9177b);
            this.X = builder.f9176a;
            this.Z = builder.f9177b;
            this.X2 = builder.f9178c;
            this.Y2 = builder.f9179d;
            this.Z2 = builder.f9180e;
        }

        @UnstableApi
        public static ClippingProperties c(Bundle bundle) {
            Builder builder = new Builder();
            String str = b3;
            ClippingConfiguration clippingConfiguration = a3;
            Builder n2 = builder.l(bundle.getLong(str, clippingConfiguration.s)).h(bundle.getLong(c3, clippingConfiguration.Y)).k(bundle.getBoolean(d3, clippingConfiguration.X2)).j(bundle.getBoolean(e3, clippingConfiguration.Y2)).n(bundle.getBoolean(f3, clippingConfiguration.Z2));
            long j2 = bundle.getLong(g3, clippingConfiguration.X);
            if (j2 != clippingConfiguration.X) {
                n2.m(j2);
            }
            long j3 = bundle.getLong(h3, clippingConfiguration.Z);
            if (j3 != clippingConfiguration.Z) {
                n2.i(j3);
            }
            return n2.g();
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            long j2 = this.s;
            ClippingConfiguration clippingConfiguration = a3;
            if (j2 != clippingConfiguration.s) {
                bundle.putLong(b3, j2);
            }
            long j3 = this.Y;
            if (j3 != clippingConfiguration.Y) {
                bundle.putLong(c3, j3);
            }
            long j4 = this.X;
            if (j4 != clippingConfiguration.X) {
                bundle.putLong(g3, j4);
            }
            long j5 = this.Z;
            if (j5 != clippingConfiguration.Z) {
                bundle.putLong(h3, j5);
            }
            boolean z = this.X2;
            if (z != clippingConfiguration.X2) {
                bundle.putBoolean(d3, z);
            }
            boolean z2 = this.Y2;
            if (z2 != clippingConfiguration.Y2) {
                bundle.putBoolean(e3, z2);
            }
            boolean z3 = this.Z2;
            if (z3 != clippingConfiguration.Z2) {
                bundle.putBoolean(f3, z3);
            }
            return bundle;
        }

        public Builder b() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingConfiguration)) {
                return false;
            }
            ClippingConfiguration clippingConfiguration = (ClippingConfiguration) obj;
            return this.X == clippingConfiguration.X && this.Z == clippingConfiguration.Z && this.X2 == clippingConfiguration.X2 && this.Y2 == clippingConfiguration.Y2 && this.Z2 == clippingConfiguration.Z2;
        }

        public int hashCode() {
            long j2 = this.X;
            long j3 = this.Z;
            return (((((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.X2 ? 1 : 0)) * 31) + (this.Y2 ? 1 : 0)) * 31) + (this.Z2 ? 1 : 0);
        }
    }

    @UnstableApi
    @Deprecated
    public static final class ClippingProperties extends ClippingConfiguration {
        public static final ClippingProperties j3 = new ClippingConfiguration.Builder().g();

        private ClippingProperties(ClippingConfiguration.Builder builder) {
            super(builder);
        }
    }

    public static final class DrmConfiguration implements Bundleable {
        private static final String e3 = Util.d1(0);
        private static final String f3 = Util.d1(1);
        private static final String g3 = Util.d1(2);
        private static final String h3 = Util.d1(3);
        @VisibleForTesting
        static final String i3 = Util.d1(4);
        private static final String j3 = Util.d1(5);
        private static final String k3 = Util.d1(6);
        private static final String l3 = Util.d1(7);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<DrmConfiguration> m3 = new C0182v();
        @UnstableApi
        @Deprecated
        public final UUID X;
        public final ImmutableMap<String, String> X2;
        @Nullable
        public final Uri Y;
        public final boolean Y2;
        @UnstableApi
        @Deprecated
        public final ImmutableMap<String, String> Z;
        public final boolean Z2;
        public final boolean a3;
        @UnstableApi
        @Deprecated
        public final ImmutableList<Integer> b3;
        public final ImmutableList<Integer> c3;
        /* access modifiers changed from: private */
        @Nullable
        public final byte[] d3;
        public final UUID s;

        private DrmConfiguration(Builder builder) {
            Assertions.i(!builder.f9186f || builder.f9182b != null);
            UUID uuid = (UUID) Assertions.g(builder.f9181a);
            this.s = uuid;
            this.X = uuid;
            this.Y = builder.f9182b;
            this.Z = builder.f9183c;
            this.X2 = builder.f9183c;
            this.Y2 = builder.f9184d;
            this.a3 = builder.f9186f;
            this.Z2 = builder.f9185e;
            this.b3 = builder.f9187g;
            this.c3 = builder.f9187g;
            this.d3 = builder.f9188h != null ? Arrays.copyOf(builder.f9188h, builder.f9188h.length) : null;
        }

        @UnstableApi
        public static DrmConfiguration d(Bundle bundle) {
            UUID fromString = UUID.fromString((String) Assertions.g(bundle.getString(e3)));
            ImmutableMap<String, String> b2 = BundleCollectionUtil.b(BundleCollectionUtil.f(bundle, g3, Bundle.EMPTY));
            boolean z = bundle.getBoolean(h3, false);
            boolean z2 = bundle.getBoolean(i3, false);
            boolean z3 = bundle.getBoolean(j3, false);
            ImmutableList<Integer> B = ImmutableList.B(BundleCollectionUtil.g(bundle, k3, new ArrayList()));
            return new Builder(fromString).q((Uri) bundle.getParcelable(f3)).p(b2).s(z).l(z3).u(z2).n(B).o(bundle.getByteArray(l3)).j();
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString(e3, this.s.toString());
            Uri uri = this.Y;
            if (uri != null) {
                bundle.putParcelable(f3, uri);
            }
            if (!this.X2.isEmpty()) {
                bundle.putBundle(g3, BundleCollectionUtil.h(this.X2));
            }
            boolean z = this.Y2;
            if (z) {
                bundle.putBoolean(h3, z);
            }
            boolean z2 = this.Z2;
            if (z2) {
                bundle.putBoolean(i3, z2);
            }
            boolean z3 = this.a3;
            if (z3) {
                bundle.putBoolean(j3, z3);
            }
            if (!this.c3.isEmpty()) {
                bundle.putIntegerArrayList(k3, new ArrayList(this.c3));
            }
            byte[] bArr = this.d3;
            if (bArr != null) {
                bundle.putByteArray(l3, bArr);
            }
            return bundle;
        }

        public Builder c() {
            return new Builder();
        }

        @Nullable
        public byte[] e() {
            byte[] bArr = this.d3;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            return this.s.equals(drmConfiguration.s) && Util.g(this.Y, drmConfiguration.Y) && Util.g(this.X2, drmConfiguration.X2) && this.Y2 == drmConfiguration.Y2 && this.a3 == drmConfiguration.a3 && this.Z2 == drmConfiguration.Z2 && this.c3.equals(drmConfiguration.c3) && Arrays.equals(this.d3, drmConfiguration.d3);
        }

        public int hashCode() {
            int hashCode = this.s.hashCode() * 31;
            Uri uri = this.Y;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.X2.hashCode()) * 31) + (this.Y2 ? 1 : 0)) * 31) + (this.a3 ? 1 : 0)) * 31) + (this.Z2 ? 1 : 0)) * 31) + this.c3.hashCode()) * 31) + Arrays.hashCode(this.d3);
        }

        public static final class Builder {
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: a  reason: collision with root package name */
            public UUID f9181a;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            public Uri f9182b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public ImmutableMap<String, String> f9183c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public boolean f9184d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public boolean f9185e;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public boolean f9186f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public ImmutableList<Integer> f9187g;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: h  reason: collision with root package name */
            public byte[] f9188h;

            @Deprecated
            private Builder() {
                this.f9183c = ImmutableMap.s();
                this.f9185e = true;
                this.f9187g = ImmutableList.I();
            }

            /* access modifiers changed from: private */
            @CanIgnoreReturnValue
            @Deprecated
            public Builder t(@Nullable UUID uuid) {
                this.f9181a = uuid;
                return this;
            }

            public DrmConfiguration j() {
                return new DrmConfiguration(this);
            }

            @InlineMe(replacement = "this.setForceSessionsForAudioAndVideoTracks(forceSessionsForAudioAndVideoTracks)")
            @UnstableApi
            @CanIgnoreReturnValue
            @Deprecated
            public Builder k(boolean z) {
                return m(z);
            }

            @CanIgnoreReturnValue
            public Builder l(boolean z) {
                this.f9186f = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder m(boolean z) {
                n(z ? ImmutableList.L(2, 1) : ImmutableList.I());
                return this;
            }

            @CanIgnoreReturnValue
            public Builder n(List<Integer> list) {
                this.f9187g = ImmutableList.B(list);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder o(@Nullable byte[] bArr) {
                this.f9188h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder p(Map<String, String> map) {
                this.f9183c = ImmutableMap.g(map);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder q(@Nullable Uri uri) {
                this.f9182b = uri;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder r(@Nullable String str) {
                this.f9182b = str == null ? null : Uri.parse(str);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder s(boolean z) {
                this.f9184d = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder u(boolean z) {
                this.f9185e = z;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder v(UUID uuid) {
                this.f9181a = uuid;
                return this;
            }

            private Builder(DrmConfiguration drmConfiguration) {
                this.f9181a = drmConfiguration.s;
                this.f9182b = drmConfiguration.Y;
                this.f9183c = drmConfiguration.X2;
                this.f9184d = drmConfiguration.Y2;
                this.f9185e = drmConfiguration.Z2;
                this.f9186f = drmConfiguration.a3;
                this.f9187g = drmConfiguration.c3;
                this.f9188h = drmConfiguration.d3;
            }

            public Builder(UUID uuid) {
                this();
                this.f9181a = uuid;
            }
        }
    }

    public static final class LiveConfiguration implements Bundleable {
        public static final LiveConfiguration Y2 = new Builder().f();
        private static final String Z2 = Util.d1(0);
        private static final String a3 = Util.d1(1);
        private static final String b3 = Util.d1(2);
        private static final String c3 = Util.d1(3);
        private static final String d3 = Util.d1(4);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<LiveConfiguration> e3 = new C0184w();
        public final long X;
        public final float X2;
        public final long Y;
        public final float Z;
        public final long s;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public long f9189a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public long f9190b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public long f9191c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public float f9192d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public float f9193e;

            public Builder() {
                this.f9189a = C.f9084b;
                this.f9190b = C.f9084b;
                this.f9191c = C.f9084b;
                this.f9192d = -3.4028235E38f;
                this.f9193e = -3.4028235E38f;
            }

            public LiveConfiguration f() {
                return new LiveConfiguration(this);
            }

            @CanIgnoreReturnValue
            public Builder g(long j2) {
                this.f9191c = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder h(float f2) {
                this.f9193e = f2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder i(long j2) {
                this.f9190b = j2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder j(float f2) {
                this.f9192d = f2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder k(long j2) {
                this.f9189a = j2;
                return this;
            }

            private Builder(LiveConfiguration liveConfiguration) {
                this.f9189a = liveConfiguration.s;
                this.f9190b = liveConfiguration.X;
                this.f9191c = liveConfiguration.Y;
                this.f9192d = liveConfiguration.Z;
                this.f9193e = liveConfiguration.X2;
            }
        }

        @UnstableApi
        @Deprecated
        public LiveConfiguration(long j2, long j3, long j4, float f2, float f3) {
            this.s = j2;
            this.X = j3;
            this.Y = j4;
            this.Z = f2;
            this.X2 = f3;
        }

        @UnstableApi
        public static LiveConfiguration c(Bundle bundle) {
            Builder builder = new Builder();
            String str = Z2;
            LiveConfiguration liveConfiguration = Y2;
            return builder.k(bundle.getLong(str, liveConfiguration.s)).i(bundle.getLong(a3, liveConfiguration.X)).g(bundle.getLong(b3, liveConfiguration.Y)).j(bundle.getFloat(c3, liveConfiguration.Z)).h(bundle.getFloat(d3, liveConfiguration.X2)).f();
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            long j2 = this.s;
            LiveConfiguration liveConfiguration = Y2;
            if (j2 != liveConfiguration.s) {
                bundle.putLong(Z2, j2);
            }
            long j3 = this.X;
            if (j3 != liveConfiguration.X) {
                bundle.putLong(a3, j3);
            }
            long j4 = this.Y;
            if (j4 != liveConfiguration.Y) {
                bundle.putLong(b3, j4);
            }
            float f2 = this.Z;
            if (f2 != liveConfiguration.Z) {
                bundle.putFloat(c3, f2);
            }
            float f3 = this.X2;
            if (f3 != liveConfiguration.X2) {
                bundle.putFloat(d3, f3);
            }
            return bundle;
        }

        public Builder b() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            return this.s == liveConfiguration.s && this.X == liveConfiguration.X && this.Y == liveConfiguration.Y && this.Z == liveConfiguration.Z && this.X2 == liveConfiguration.X2;
        }

        public int hashCode() {
            long j2 = this.s;
            long j3 = this.X;
            long j4 = this.Y;
            int i2 = ((((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            float f2 = this.Z;
            int i3 = 0;
            int floatToIntBits = (i2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.X2;
            if (f3 != 0.0f) {
                i3 = Float.floatToIntBits(f3);
            }
            return floatToIntBits + i3;
        }

        private LiveConfiguration(Builder builder) {
            this(builder.f9189a, builder.f9190b, builder.f9191c, builder.f9192d, builder.f9193e);
        }
    }

    public static final class LocalConfiguration implements Bundleable {
        private static final String d3 = Util.d1(0);
        private static final String e3 = Util.d1(1);
        private static final String f3 = Util.d1(2);
        private static final String g3 = Util.d1(3);
        private static final String h3 = Util.d1(4);
        private static final String i3 = Util.d1(5);
        private static final String j3 = Util.d1(6);
        private static final String k3 = Util.d1(7);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<LocalConfiguration> l3 = new C0190z();
        @Nullable
        public final String X;
        @UnstableApi
        public final List<StreamKey> X2;
        @Nullable
        public final DrmConfiguration Y;
        @UnstableApi
        @Nullable
        public final String Y2;
        @Nullable
        public final AdsConfiguration Z;
        public final ImmutableList<SubtitleConfiguration> Z2;
        @UnstableApi
        @Deprecated
        public final List<Subtitle> a3;
        @Nullable
        public final Object b3;
        @UnstableApi
        public final long c3;
        public final Uri s;

        private LocalConfiguration(Uri uri, @Nullable String str, @Nullable DrmConfiguration drmConfiguration, @Nullable AdsConfiguration adsConfiguration, List<StreamKey> list, @Nullable String str2, ImmutableList<SubtitleConfiguration> immutableList, @Nullable Object obj, long j2) {
            this.s = uri;
            this.X = MimeTypes.u(str);
            this.Y = drmConfiguration;
            this.Z = adsConfiguration;
            this.X2 = list;
            this.Y2 = str2;
            this.Z2 = immutableList;
            ImmutableList.Builder r = ImmutableList.r();
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                r.g(immutableList.get(i2).b().j());
            }
            this.a3 = r.e();
            this.b3 = obj;
            this.c3 = j2;
        }

        @UnstableApi
        public static LocalConfiguration b(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(f3);
            AdsConfiguration adsConfiguration = null;
            DrmConfiguration d2 = bundle2 == null ? null : DrmConfiguration.d(bundle2);
            Bundle bundle3 = bundle.getBundle(g3);
            if (bundle3 != null) {
                adsConfiguration = AdsConfiguration.c(bundle3);
            }
            AdsConfiguration adsConfiguration2 = adsConfiguration;
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(h3);
            ImmutableList I = parcelableArrayList == null ? ImmutableList.I() : BundleCollectionUtil.d(new A(), parcelableArrayList);
            ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(j3);
            return new LocalConfiguration((Uri) Assertions.g((Uri) bundle.getParcelable(d3)), bundle.getString(e3), d2, adsConfiguration2, I, bundle.getString(i3), parcelableArrayList2 == null ? ImmutableList.I() : BundleCollectionUtil.d(new B(), parcelableArrayList2), (Object) null, bundle.getLong(k3, C.f9084b));
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(d3, this.s);
            String str = this.X;
            if (str != null) {
                bundle.putString(e3, str);
            }
            DrmConfiguration drmConfiguration = this.Y;
            if (drmConfiguration != null) {
                bundle.putBundle(f3, drmConfiguration.a());
            }
            AdsConfiguration adsConfiguration = this.Z;
            if (adsConfiguration != null) {
                bundle.putBundle(g3, adsConfiguration.a());
            }
            if (!this.X2.isEmpty()) {
                bundle.putParcelableArrayList(h3, BundleCollectionUtil.i(this.X2, new C0186x()));
            }
            String str2 = this.Y2;
            if (str2 != null) {
                bundle.putString(i3, str2);
            }
            if (!this.Z2.isEmpty()) {
                bundle.putParcelableArrayList(j3, BundleCollectionUtil.i(this.Z2, new C0188y()));
            }
            long j2 = this.c3;
            if (j2 != C.f9084b) {
                bundle.putLong(k3, j2);
            }
            return bundle;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalConfiguration)) {
                return false;
            }
            LocalConfiguration localConfiguration = (LocalConfiguration) obj;
            return this.s.equals(localConfiguration.s) && Util.g(this.X, localConfiguration.X) && Util.g(this.Y, localConfiguration.Y) && Util.g(this.Z, localConfiguration.Z) && this.X2.equals(localConfiguration.X2) && Util.g(this.Y2, localConfiguration.Y2) && this.Z2.equals(localConfiguration.Z2) && Util.g(this.b3, localConfiguration.b3) && Util.g(Long.valueOf(this.c3), Long.valueOf(localConfiguration.c3));
        }

        public int hashCode() {
            int hashCode = this.s.hashCode() * 31;
            String str = this.X;
            int i2 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration = this.Y;
            int hashCode3 = (hashCode2 + (drmConfiguration == null ? 0 : drmConfiguration.hashCode())) * 31;
            AdsConfiguration adsConfiguration = this.Z;
            int hashCode4 = (((hashCode3 + (adsConfiguration == null ? 0 : adsConfiguration.hashCode())) * 31) + this.X2.hashCode()) * 31;
            String str2 = this.Y2;
            int hashCode5 = (((hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.Z2.hashCode()) * 31;
            Object obj = this.b3;
            if (obj != null) {
                i2 = obj.hashCode();
            }
            return (int) ((((long) (hashCode5 + i2)) * 31) + this.c3);
        }
    }

    public static final class RequestMetadata implements Bundleable {
        private static final String X2 = Util.d1(0);
        private static final String Y2 = Util.d1(1);
        public static final RequestMetadata Z = new Builder().d();
        private static final String Z2 = Util.d1(2);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<RequestMetadata> a3 = new D();
        @Nullable
        public final String X;
        @Nullable
        public final Bundle Y;
        @Nullable
        public final Uri s;

        public static final class Builder {
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: a  reason: collision with root package name */
            public Uri f9194a;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            public String f9195b;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            public Bundle f9196c;

            public Builder() {
            }

            public RequestMetadata d() {
                return new RequestMetadata(this);
            }

            @CanIgnoreReturnValue
            public Builder e(@Nullable Bundle bundle) {
                this.f9196c = bundle;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder f(@Nullable Uri uri) {
                this.f9194a = uri;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder g(@Nullable String str) {
                this.f9195b = str;
                return this;
            }

            private Builder(RequestMetadata requestMetadata) {
                this.f9194a = requestMetadata.s;
                this.f9195b = requestMetadata.X;
                this.f9196c = requestMetadata.Y;
            }
        }

        private RequestMetadata(Builder builder) {
            this.s = builder.f9194a;
            this.X = builder.f9195b;
            this.Y = builder.f9196c;
        }

        @UnstableApi
        public static RequestMetadata c(Bundle bundle) {
            return new Builder().f((Uri) bundle.getParcelable(X2)).g(bundle.getString(Y2)).e(bundle.getBundle(Z2)).d();
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            Uri uri = this.s;
            if (uri != null) {
                bundle.putParcelable(X2, uri);
            }
            String str = this.X;
            if (str != null) {
                bundle.putString(Y2, str);
            }
            Bundle bundle2 = this.Y;
            if (bundle2 != null) {
                bundle.putBundle(Z2, bundle2);
            }
            return bundle;
        }

        public Builder b() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestMetadata)) {
                return false;
            }
            RequestMetadata requestMetadata = (RequestMetadata) obj;
            if (Util.g(this.s, requestMetadata.s) && Util.g(this.X, requestMetadata.X)) {
                if ((this.Y == null) == (requestMetadata.Y == null)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Uri uri = this.s;
            int i2 = 0;
            int hashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.X;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            if (this.Y != null) {
                i2 = 1;
            }
            return hashCode2 + i2;
        }
    }

    @UnstableApi
    @Deprecated
    public static final class Subtitle extends SubtitleConfiguration {
        @UnstableApi
        @Deprecated
        public Subtitle(Uri uri, String str, @Nullable String str2) {
            this(uri, str, str2, 0);
        }

        @UnstableApi
        @Deprecated
        public Subtitle(Uri uri, String str, @Nullable String str2, int i2) {
            this(uri, str, str2, i2, 0, (String) null);
        }

        @UnstableApi
        @Deprecated
        public Subtitle(Uri uri, String str, @Nullable String str2, int i2, int i3, @Nullable String str3) {
            super(uri, str, str2, i2, i3, str3, (String) null);
        }

        private Subtitle(SubtitleConfiguration.Builder builder) {
            super(builder);
        }
    }

    private MediaItem(String str, ClippingProperties clippingProperties, @Nullable LocalConfiguration localConfiguration, LiveConfiguration liveConfiguration, MediaMetadata mediaMetadata, RequestMetadata requestMetadata) {
        this.s = str;
        this.X = localConfiguration;
        this.Y = localConfiguration;
        this.Z = liveConfiguration;
        this.X2 = mediaMetadata;
        this.Y2 = clippingProperties;
        this.Z2 = clippingProperties;
        this.a3 = requestMetadata;
    }

    @UnstableApi
    public static MediaItem c(Bundle bundle) {
        String str = (String) Assertions.g(bundle.getString(d3, ""));
        Bundle bundle2 = bundle.getBundle(e3);
        LiveConfiguration c2 = bundle2 == null ? LiveConfiguration.Y2 : LiveConfiguration.c(bundle2);
        Bundle bundle3 = bundle.getBundle(f3);
        MediaMetadata c4 = bundle3 == null ? MediaMetadata.O4 : MediaMetadata.c(bundle3);
        Bundle bundle4 = bundle.getBundle(g3);
        ClippingProperties c5 = bundle4 == null ? ClippingProperties.j3 : ClippingConfiguration.c(bundle4);
        Bundle bundle5 = bundle.getBundle(h3);
        RequestMetadata c6 = bundle5 == null ? RequestMetadata.Z : RequestMetadata.c(bundle5);
        Bundle bundle6 = bundle.getBundle(i3);
        return new MediaItem(str, c5, bundle6 == null ? null : LocalConfiguration.b(bundle6), c2, c4, c6);
    }

    public static MediaItem d(Uri uri) {
        return new Builder().M(uri).a();
    }

    public static MediaItem e(String str) {
        return new Builder().N(str).a();
    }

    @UnstableApi
    private Bundle f(boolean z) {
        LocalConfiguration localConfiguration;
        Bundle bundle = new Bundle();
        if (!this.s.equals("")) {
            bundle.putString(d3, this.s);
        }
        if (!this.Z.equals(LiveConfiguration.Y2)) {
            bundle.putBundle(e3, this.Z.a());
        }
        if (!this.X2.equals(MediaMetadata.O4)) {
            bundle.putBundle(f3, this.X2.a());
        }
        if (!this.Y2.equals(ClippingConfiguration.a3)) {
            bundle.putBundle(g3, this.Y2.a());
        }
        if (!this.a3.equals(RequestMetadata.Z)) {
            bundle.putBundle(h3, this.a3.a());
        }
        if (z && (localConfiguration = this.X) != null) {
            bundle.putBundle(i3, localConfiguration.a());
        }
        return bundle;
    }

    @UnstableApi
    public Bundle a() {
        return f(false);
    }

    public Builder b() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        return Util.g(this.s, mediaItem.s) && this.Y2.equals(mediaItem.Y2) && Util.g(this.X, mediaItem.X) && Util.g(this.Z, mediaItem.Z) && Util.g(this.X2, mediaItem.X2) && Util.g(this.a3, mediaItem.a3);
    }

    @UnstableApi
    public Bundle g() {
        return f(true);
    }

    public int hashCode() {
        int hashCode = this.s.hashCode() * 31;
        LocalConfiguration localConfiguration = this.X;
        return ((((((((hashCode + (localConfiguration != null ? localConfiguration.hashCode() : 0)) * 31) + this.Z.hashCode()) * 31) + this.Y2.hashCode()) * 31) + this.X2.hashCode()) * 31) + this.a3.hashCode();
    }

    public static class SubtitleConfiguration implements Bundleable {
        private static final String a3 = Util.d1(0);
        private static final String b3 = Util.d1(1);
        private static final String c3 = Util.d1(2);
        private static final String d3 = Util.d1(3);
        private static final String e3 = Util.d1(4);
        private static final String f3 = Util.d1(5);
        private static final String g3 = Util.d1(6);
        @UnstableApi
        @Deprecated
        public static final Bundleable.Creator<SubtitleConfiguration> h3 = new E();
        @Nullable
        public final String X;
        public final int X2;
        @Nullable
        public final String Y;
        @Nullable
        public final String Y2;
        public final int Z;
        @Nullable
        public final String Z2;
        public final Uri s;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public Uri f9197a;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            public String f9198b;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            public String f9199c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public int f9200d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public int f9201e;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            public String f9202f;
            /* access modifiers changed from: private */
            @Nullable

            /* renamed from: g  reason: collision with root package name */
            public String f9203g;

            public Builder(Uri uri) {
                this.f9197a = uri;
            }

            /* access modifiers changed from: private */
            public Subtitle j() {
                return new Subtitle(this);
            }

            public SubtitleConfiguration i() {
                return new SubtitleConfiguration(this);
            }

            @CanIgnoreReturnValue
            public Builder k(@Nullable String str) {
                this.f9203g = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder l(@Nullable String str) {
                this.f9202f = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder m(@Nullable String str) {
                this.f9199c = str;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder n(@Nullable String str) {
                this.f9198b = MimeTypes.u(str);
                return this;
            }

            @CanIgnoreReturnValue
            public Builder o(int i2) {
                this.f9201e = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder p(int i2) {
                this.f9200d = i2;
                return this;
            }

            @CanIgnoreReturnValue
            public Builder q(Uri uri) {
                this.f9197a = uri;
                return this;
            }

            private Builder(SubtitleConfiguration subtitleConfiguration) {
                this.f9197a = subtitleConfiguration.s;
                this.f9198b = subtitleConfiguration.X;
                this.f9199c = subtitleConfiguration.Y;
                this.f9200d = subtitleConfiguration.Z;
                this.f9201e = subtitleConfiguration.X2;
                this.f9202f = subtitleConfiguration.Y2;
                this.f9203g = subtitleConfiguration.Z2;
            }
        }

        private SubtitleConfiguration(Uri uri, String str, @Nullable String str2, int i2, int i3, @Nullable String str3, @Nullable String str4) {
            this.s = uri;
            this.X = MimeTypes.u(str);
            this.Y = str2;
            this.Z = i2;
            this.X2 = i3;
            this.Y2 = str3;
            this.Z2 = str4;
        }

        @UnstableApi
        public static SubtitleConfiguration c(Bundle bundle) {
            String string = bundle.getString(b3);
            String string2 = bundle.getString(c3);
            int i2 = bundle.getInt(d3, 0);
            int i3 = bundle.getInt(e3, 0);
            String string3 = bundle.getString(f3);
            return new Builder((Uri) Assertions.g((Uri) bundle.getParcelable(a3))).n(string).m(string2).p(i2).o(i3).l(string3).k(bundle.getString(g3)).i();
        }

        @UnstableApi
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(a3, this.s);
            String str = this.X;
            if (str != null) {
                bundle.putString(b3, str);
            }
            String str2 = this.Y;
            if (str2 != null) {
                bundle.putString(c3, str2);
            }
            int i2 = this.Z;
            if (i2 != 0) {
                bundle.putInt(d3, i2);
            }
            int i3 = this.X2;
            if (i3 != 0) {
                bundle.putInt(e3, i3);
            }
            String str3 = this.Y2;
            if (str3 != null) {
                bundle.putString(f3, str3);
            }
            String str4 = this.Z2;
            if (str4 != null) {
                bundle.putString(g3, str4);
            }
            return bundle;
        }

        public Builder b() {
            return new Builder();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubtitleConfiguration)) {
                return false;
            }
            SubtitleConfiguration subtitleConfiguration = (SubtitleConfiguration) obj;
            return this.s.equals(subtitleConfiguration.s) && Util.g(this.X, subtitleConfiguration.X) && Util.g(this.Y, subtitleConfiguration.Y) && this.Z == subtitleConfiguration.Z && this.X2 == subtitleConfiguration.X2 && Util.g(this.Y2, subtitleConfiguration.Y2) && Util.g(this.Z2, subtitleConfiguration.Z2);
        }

        public int hashCode() {
            int hashCode = this.s.hashCode() * 31;
            String str = this.X;
            int i2 = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.Y;
            int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.Z) * 31) + this.X2) * 31;
            String str3 = this.Y2;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.Z2;
            if (str4 != null) {
                i2 = str4.hashCode();
            }
            return hashCode4 + i2;
        }

        private SubtitleConfiguration(Builder builder) {
            this.s = builder.f9197a;
            this.X = builder.f9198b;
            this.Y = builder.f9199c;
            this.Z = builder.f9200d;
            this.X2 = builder.f9201e;
            this.Y2 = builder.f9202f;
            this.Z2 = builder.f9203g;
        }
    }
}

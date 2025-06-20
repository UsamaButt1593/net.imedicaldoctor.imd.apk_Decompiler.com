package androidx.media3.common;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.BundleCollectionUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;

public final class Format implements Bundleable {
    @UnstableApi
    public static final int D3 = 1;
    @UnstableApi
    public static final int E3 = 2;
    public static final int F3 = -1;
    @UnstableApi
    public static final long G3 = Long.MAX_VALUE;
    private static final Format H3 = new Builder().I();
    private static final String I3 = Util.d1(0);
    private static final String J3 = Util.d1(1);
    private static final String K3 = Util.d1(2);
    private static final String L3 = Util.d1(3);
    private static final String M3 = Util.d1(4);
    private static final String N3 = Util.d1(5);
    private static final String O3 = Util.d1(6);
    private static final String P3 = Util.d1(7);
    private static final String Q3 = Util.d1(8);
    private static final String R3 = Util.d1(9);
    private static final String S3 = Util.d1(10);
    private static final String T3 = Util.d1(11);
    private static final String U3 = Util.d1(12);
    private static final String V3 = Util.d1(13);
    private static final String W3 = Util.d1(14);
    private static final String X3 = Util.d1(15);
    private static final String Y3 = Util.d1(16);
    private static final String Z3 = Util.d1(17);
    private static final String a4 = Util.d1(18);
    private static final String b4 = Util.d1(19);
    private static final String c4 = Util.d1(20);
    private static final String d4 = Util.d1(21);
    private static final String e4 = Util.d1(22);
    private static final String f4 = Util.d1(23);
    private static final String g4 = Util.d1(24);
    private static final String h4 = Util.d1(25);
    private static final String i4 = Util.d1(26);
    private static final String j4 = Util.d1(27);
    private static final String k4 = Util.d1(28);
    private static final String l4 = Util.d1(29);
    private static final String m4 = Util.d1(30);
    private static final String n4 = Util.d1(31);
    private static final String o4 = Util.d1(32);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<Format> p4 = new C0163o();
    @UnstableApi
    public final int A3;
    @UnstableApi
    public final int B3;
    private int C3;
    @Nullable
    public final String X;
    public final int X2;
    @UnstableApi
    public final List<Label> Y;
    public final int Y2;
    @Nullable
    public final String Z;
    @UnstableApi
    public final int Z2;
    @UnstableApi
    public final int a3;
    @UnstableApi
    public final int b3;
    @Nullable
    public final String c3;
    @UnstableApi
    @Nullable
    public final Metadata d3;
    @Nullable
    public final String e3;
    @Nullable
    public final String f3;
    @UnstableApi
    public final int g3;
    @UnstableApi
    public final List<byte[]> h3;
    @UnstableApi
    @Nullable
    public final DrmInitData i3;
    @UnstableApi
    public final long j3;
    public final int k3;
    public final int l3;
    public final float m3;
    @UnstableApi
    public final int n3;
    public final float o3;
    @UnstableApi
    @Nullable
    public final byte[] p3;
    @UnstableApi
    public final int q3;
    @UnstableApi
    @Nullable
    public final ColorInfo r3;
    @Nullable
    public final String s;
    public final int s3;
    public final int t3;
    @UnstableApi
    public final int u3;
    @UnstableApi
    public final int v3;
    @UnstableApi
    public final int w3;
    @UnstableApi
    public final int x3;
    @UnstableApi
    public final int y3;
    @UnstableApi
    public final int z3;

    @UnstableApi
    public static final class Builder {
        /* access modifiers changed from: private */
        public int A;
        /* access modifiers changed from: private */
        public int B;
        /* access modifiers changed from: private */
        public int C;
        /* access modifiers changed from: private */
        public int D;
        /* access modifiers changed from: private */
        @UnstableApi
        public int E;
        /* access modifiers changed from: private */
        public int F;
        /* access modifiers changed from: private */
        public int G;
        /* access modifiers changed from: private */
        public int H;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public String f9125a;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public String f9126b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public List<Label> f9127c;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public String f9128d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f9129e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f9130f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f9131g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f9132h;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public String f9133i;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public Metadata f9134j;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        public String f9135k;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        public String f9136l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public int f9137m;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: n  reason: collision with root package name */
        public List<byte[]> f9138n;
        /* access modifiers changed from: private */
        @Nullable
        public DrmInitData o;
        /* access modifiers changed from: private */
        public long p;
        /* access modifiers changed from: private */
        public int q;
        /* access modifiers changed from: private */
        public int r;
        /* access modifiers changed from: private */
        public float s;
        /* access modifiers changed from: private */
        public int t;
        /* access modifiers changed from: private */
        public float u;
        /* access modifiers changed from: private */
        @Nullable
        public byte[] v;
        /* access modifiers changed from: private */
        public int w;
        /* access modifiers changed from: private */
        @Nullable
        public ColorInfo x;
        /* access modifiers changed from: private */
        public int y;
        /* access modifiers changed from: private */
        public int z;

        public Builder() {
            this.f9127c = ImmutableList.I();
            this.f9131g = -1;
            this.f9132h = -1;
            this.f9137m = -1;
            this.p = Long.MAX_VALUE;
            this.q = -1;
            this.r = -1;
            this.s = -1.0f;
            this.u = 1.0f;
            this.w = -1;
            this.y = -1;
            this.z = -1;
            this.A = -1;
            this.D = -1;
            this.E = 1;
            this.F = -1;
            this.G = -1;
            this.H = 0;
        }

        public Format I() {
            return new Format(this);
        }

        @CanIgnoreReturnValue
        public Builder J(int i2) {
            this.D = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder K(int i2) {
            this.f9131g = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder L(int i2) {
            this.y = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder M(@Nullable String str) {
            this.f9133i = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder N(@Nullable ColorInfo colorInfo) {
            this.x = colorInfo;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder O(@Nullable String str) {
            this.f9135k = MimeTypes.u(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder P(int i2) {
            this.H = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder Q(int i2) {
            this.E = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder R(@Nullable DrmInitData drmInitData) {
            this.o = drmInitData;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder S(int i2) {
            this.B = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder T(int i2) {
            this.C = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder U(float f2) {
            this.s = f2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder V(int i2) {
            this.r = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder W(int i2) {
            this.f9125a = Integer.toString(i2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder X(@Nullable String str) {
            this.f9125a = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder Y(@Nullable List<byte[]> list) {
            this.f9138n = list;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder Z(@Nullable String str) {
            this.f9126b = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder a0(List<Label> list) {
            this.f9127c = ImmutableList.B(list);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder b0(@Nullable String str) {
            this.f9128d = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c0(int i2) {
            this.f9137m = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d0(@Nullable Metadata metadata) {
            this.f9134j = metadata;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e0(int i2) {
            this.A = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f0(int i2) {
            this.f9132h = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g0(float f2) {
            this.u = f2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h0(@Nullable byte[] bArr) {
            this.v = bArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder i0(int i2) {
            this.f9130f = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder j0(int i2) {
            this.t = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder k0(@Nullable String str) {
            this.f9136l = MimeTypes.u(str);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder l0(int i2) {
            this.z = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder m0(int i2) {
            this.f9129e = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder n0(int i2) {
            this.w = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder o0(long j2) {
            this.p = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder p0(int i2) {
            this.F = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder q0(int i2) {
            this.G = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder r0(int i2) {
            this.q = i2;
            return this;
        }

        private Builder(Format format) {
            this.f9125a = format.s;
            this.f9126b = format.X;
            this.f9127c = format.Y;
            this.f9128d = format.Z;
            this.f9129e = format.X2;
            this.f9130f = format.Y2;
            this.f9131g = format.Z2;
            this.f9132h = format.a3;
            this.f9133i = format.c3;
            this.f9134j = format.d3;
            this.f9135k = format.e3;
            this.f9136l = format.f3;
            this.f9137m = format.g3;
            this.f9138n = format.h3;
            this.o = format.i3;
            this.p = format.j3;
            this.q = format.k3;
            this.r = format.l3;
            this.s = format.m3;
            this.t = format.n3;
            this.u = format.o3;
            this.v = format.p3;
            this.w = format.q3;
            this.x = format.r3;
            this.y = format.s3;
            this.z = format.t3;
            this.A = format.u3;
            this.B = format.v3;
            this.C = format.w3;
            this.D = format.x3;
            this.E = format.y3;
            this.F = format.z3;
            this.G = format.A3;
            this.H = format.B3;
        }
    }

    @UnstableApi
    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CueReplacementBehavior {
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Format(androidx.media3.common.Format.Builder r8) {
        /*
            r7 = this;
            r7.<init>()
            java.lang.String r0 = r8.f9125a
            r7.s = r0
            java.lang.String r0 = r8.f9128d
            java.lang.String r0 = androidx.media3.common.util.Util.L1(r0)
            r7.Z = r0
            java.util.List r1 = r8.f9127c
            boolean r1 = r1.isEmpty()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = r8.f9126b
            if (r1 == 0) goto L_0x003b
            androidx.media3.common.Label r1 = new androidx.media3.common.Label
            java.lang.String r4 = r8.f9126b
            r1.<init>(r0, r4)
            com.google.common.collect.ImmutableList r0 = com.google.common.collect.ImmutableList.K(r1)
        L_0x0032:
            r7.Y = r0
            java.lang.String r0 = r8.f9126b
        L_0x0038:
            r7.X = r0
            goto L_0x0088
        L_0x003b:
            java.util.List r1 = r8.f9127c
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x005a
            java.lang.String r1 = r8.f9126b
            if (r1 != 0) goto L_0x005a
            java.util.List r1 = r8.f9127c
            r7.Y = r1
            java.util.List r1 = r8.f9127c
            java.lang.String r0 = g(r1, r0)
            goto L_0x0038
        L_0x005a:
            java.util.List r0 = r8.f9127c
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = r8.f9126b
            if (r0 == 0) goto L_0x007d
        L_0x006a:
            java.util.List r0 = r8.f9127c
            java.util.stream.Stream r0 = androidx.media3.common.C0157l.a(r0)
            androidx.media3.common.q r1 = new androidx.media3.common.q
            r1.<init>(r8)
            boolean r0 = androidx.media3.common.C0159m.a(r0, r1)
            if (r0 == 0) goto L_0x007f
        L_0x007d:
            r0 = 1
            goto L_0x0080
        L_0x007f:
            r0 = 0
        L_0x0080:
            androidx.media3.common.util.Assertions.i(r0)
            java.util.List r0 = r8.f9127c
            goto L_0x0032
        L_0x0088:
            int r0 = r8.f9129e
            r7.X2 = r0
            int r0 = r8.f9130f
            r7.Y2 = r0
            int r0 = r8.f9131g
            r7.Z2 = r0
            int r1 = r8.f9132h
            r7.a3 = r1
            r4 = -1
            if (r1 == r4) goto L_0x00a4
            r0 = r1
        L_0x00a4:
            r7.b3 = r0
            java.lang.String r0 = r8.f9133i
            r7.c3 = r0
            androidx.media3.common.Metadata r0 = r8.f9134j
            r7.d3 = r0
            java.lang.String r0 = r8.f9135k
            r7.e3 = r0
            java.lang.String r0 = r8.f9136l
            r7.f3 = r0
            int r0 = r8.f9137m
            r7.g3 = r0
            java.util.List r0 = r8.f9138n
            if (r0 != 0) goto L_0x00cf
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00d3
        L_0x00cf:
            java.util.List r0 = r8.f9138n
        L_0x00d3:
            r7.h3 = r0
            androidx.media3.common.DrmInitData r0 = r8.o
            r7.i3 = r0
            long r5 = r8.p
            r7.j3 = r5
            int r1 = r8.q
            r7.k3 = r1
            int r1 = r8.r
            r7.l3 = r1
            float r1 = r8.s
            r7.m3 = r1
            int r1 = r8.t
            if (r1 != r4) goto L_0x00fb
            r1 = 0
            goto L_0x00ff
        L_0x00fb:
            int r1 = r8.t
        L_0x00ff:
            r7.n3 = r1
            float r1 = r8.u
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x010e
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0112
        L_0x010e:
            float r1 = r8.u
        L_0x0112:
            r7.o3 = r1
            byte[] r1 = r8.v
            r7.p3 = r1
            int r1 = r8.w
            r7.q3 = r1
            androidx.media3.common.ColorInfo r1 = r8.x
            r7.r3 = r1
            int r1 = r8.y
            r7.s3 = r1
            int r1 = r8.z
            r7.t3 = r1
            int r1 = r8.A
            r7.u3 = r1
            int r1 = r8.B
            if (r1 != r4) goto L_0x0140
            r1 = 0
            goto L_0x0144
        L_0x0140:
            int r1 = r8.B
        L_0x0144:
            r7.v3 = r1
            int r1 = r8.C
            if (r1 != r4) goto L_0x014d
            goto L_0x0151
        L_0x014d:
            int r3 = r8.C
        L_0x0151:
            r7.w3 = r3
            int r1 = r8.D
            r7.x3 = r1
            int r1 = r8.E
            r7.y3 = r1
            int r1 = r8.F
            r7.z3 = r1
            int r1 = r8.G
            r7.A3 = r1
            int r1 = r8.H
            if (r1 != 0) goto L_0x0176
            if (r0 == 0) goto L_0x0176
            r7.B3 = r2
            goto L_0x017c
        L_0x0176:
            int r8 = r8.H
            r7.B3 = r8
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.Format.<init>(androidx.media3.common.Format$Builder):void");
    }

    @Nullable
    private static <T> T e(@Nullable T t, @Nullable T t2) {
        return t != null ? t : t2;
    }

    @UnstableApi
    public static Format f(Bundle bundle) {
        Builder builder = new Builder();
        BundleCollectionUtil.c(bundle);
        String string = bundle.getString(I3);
        Format format = H3;
        builder.X((String) e(string, format.s)).Z((String) e(bundle.getString(J3), format.X));
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(o4);
        builder.a0(parcelableArrayList == null ? ImmutableList.I() : BundleCollectionUtil.d(new C0161n(), parcelableArrayList)).b0((String) e(bundle.getString(K3), format.Z)).m0(bundle.getInt(L3, format.X2)).i0(bundle.getInt(M3, format.Y2)).K(bundle.getInt(N3, format.Z2)).f0(bundle.getInt(O3, format.a3)).M((String) e(bundle.getString(P3), format.c3)).d0((Metadata) e((Metadata) bundle.getParcelable(Q3), format.d3)).O((String) e(bundle.getString(R3), format.e3)).k0((String) e(bundle.getString(S3), format.f3)).c0(bundle.getInt(T3, format.g3));
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(j(i2));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i2++;
        }
        Builder R = builder.Y(arrayList).R((DrmInitData) bundle.getParcelable(V3));
        String str = W3;
        Format format2 = H3;
        R.o0(bundle.getLong(str, format2.j3)).r0(bundle.getInt(X3, format2.k3)).V(bundle.getInt(Y3, format2.l3)).U(bundle.getFloat(Z3, format2.m3)).j0(bundle.getInt(a4, format2.n3)).g0(bundle.getFloat(b4, format2.o3)).h0(bundle.getByteArray(c4)).n0(bundle.getInt(d4, format2.q3));
        Bundle bundle2 = bundle.getBundle(e4);
        if (bundle2 != null) {
            builder.N(ColorInfo.g(bundle2));
        }
        builder.L(bundle.getInt(f4, format2.s3)).l0(bundle.getInt(g4, format2.t3)).e0(bundle.getInt(h4, format2.u3)).S(bundle.getInt(i4, format2.v3)).T(bundle.getInt(j4, format2.w3)).J(bundle.getInt(k4, format2.x3)).p0(bundle.getInt(m4, format2.z3)).q0(bundle.getInt(n4, format2.A3)).P(bundle.getInt(l4, format2.B3));
        return builder.I();
    }

    private static String g(List<Label> list, @Nullable String str) {
        for (Label next : list) {
            if (TextUtils.equals(next.f9158a, str)) {
                return next.f9159b;
            }
        }
        return list.get(0).f9159b;
    }

    private static String j(int i2) {
        return U3 + "_" + Integer.toString(i2, 36);
    }

    @UnstableApi
    public static String m(@Nullable Format format) {
        String str;
        if (format == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(format.s);
        sb.append(", mimeType=");
        sb.append(format.f3);
        if (format.e3 != null) {
            sb.append(", container=");
            sb.append(format.e3);
        }
        if (format.b3 != -1) {
            sb.append(", bitrate=");
            sb.append(format.b3);
        }
        if (format.c3 != null) {
            sb.append(", codecs=");
            sb.append(format.c3);
        }
        if (format.i3 != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i2 = 0;
            while (true) {
                DrmInitData drmInitData = format.i3;
                if (i2 >= drmInitData.Z) {
                    break;
                }
                UUID uuid = drmInitData.g(i2).X;
                if (uuid.equals(C.i2)) {
                    str = C.d2;
                } else if (uuid.equals(C.j2)) {
                    str = "clearkey";
                } else if (uuid.equals(C.l2)) {
                    str = "playready";
                } else if (uuid.equals(C.k2)) {
                    str = "widevine";
                } else if (uuid.equals(C.h2)) {
                    str = "universal";
                } else {
                    str = "unknown (" + uuid + ")";
                }
                linkedHashSet.add(str);
                i2++;
            }
            sb.append(", drm=[");
            Joiner.o(ASCIIPropertyListParser.f18651i).f(sb, linkedHashSet);
            sb.append(']');
        }
        if (!(format.k3 == -1 || format.l3 == -1)) {
            sb.append(", res=");
            sb.append(format.k3);
            sb.append("x");
            sb.append(format.l3);
        }
        ColorInfo colorInfo = format.r3;
        if (colorInfo != null && colorInfo.l()) {
            sb.append(", color=");
            sb.append(format.r3.p());
        }
        if (format.m3 != -1.0f) {
            sb.append(", fps=");
            sb.append(format.m3);
        }
        if (format.s3 != -1) {
            sb.append(", channels=");
            sb.append(format.s3);
        }
        if (format.t3 != -1) {
            sb.append(", sample_rate=");
            sb.append(format.t3);
        }
        if (format.Z != null) {
            sb.append(", language=");
            sb.append(format.Z);
        }
        if (!format.Y.isEmpty()) {
            sb.append(", labels=[");
            Joiner.o(ASCIIPropertyListParser.f18651i).f(sb, format.Y);
            sb.append("]");
        }
        if (format.X2 != 0) {
            sb.append(", selectionFlags=[");
            Joiner.o(ASCIIPropertyListParser.f18651i).f(sb, Util.I0(format.X2));
            sb.append("]");
        }
        if (format.Y2 != 0) {
            sb.append(", roleFlags=[");
            Joiner.o(ASCIIPropertyListParser.f18651i).f(sb, Util.H0(format.Y2));
            sb.append("]");
        }
        return sb.toString();
    }

    @UnstableApi
    public Bundle a() {
        return l(false);
    }

    @UnstableApi
    public Builder c() {
        return new Builder();
    }

    @UnstableApi
    public Format d(int i2) {
        return c().P(i2).I();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r3 = r8.C3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@androidx.annotation.Nullable java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r8 == 0) goto L_0x011d
            java.lang.Class r2 = r8.getClass()
            java.lang.Class<androidx.media3.common.Format> r3 = androidx.media3.common.Format.class
            if (r3 == r2) goto L_0x0011
            goto L_0x011d
        L_0x0011:
            androidx.media3.common.Format r8 = (androidx.media3.common.Format) r8
            int r2 = r7.C3
            if (r2 == 0) goto L_0x001e
            int r3 = r8.C3
            if (r3 == 0) goto L_0x001e
            if (r2 == r3) goto L_0x001e
            return r1
        L_0x001e:
            int r2 = r7.X2
            int r3 = r8.X2
            if (r2 != r3) goto L_0x011b
            int r2 = r7.Y2
            int r3 = r8.Y2
            if (r2 != r3) goto L_0x011b
            int r2 = r7.Z2
            int r3 = r8.Z2
            if (r2 != r3) goto L_0x011b
            int r2 = r7.a3
            int r3 = r8.a3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.g3
            int r3 = r8.g3
            if (r2 != r3) goto L_0x011b
            long r2 = r7.j3
            long r4 = r8.j3
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x011b
            int r2 = r7.k3
            int r3 = r8.k3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.l3
            int r3 = r8.l3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.n3
            int r3 = r8.n3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.q3
            int r3 = r8.q3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.s3
            int r3 = r8.s3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.t3
            int r3 = r8.t3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.u3
            int r3 = r8.u3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.v3
            int r3 = r8.v3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.w3
            int r3 = r8.w3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.x3
            int r3 = r8.x3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.z3
            int r3 = r8.z3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.A3
            int r3 = r8.A3
            if (r2 != r3) goto L_0x011b
            int r2 = r7.B3
            int r3 = r8.B3
            if (r2 != r3) goto L_0x011b
            float r2 = r7.m3
            float r3 = r8.m3
            int r2 = java.lang.Float.compare(r2, r3)
            if (r2 != 0) goto L_0x011b
            float r2 = r7.o3
            float r3 = r8.o3
            int r2 = java.lang.Float.compare(r2, r3)
            if (r2 != 0) goto L_0x011b
            java.lang.String r2 = r7.s
            java.lang.String r3 = r8.s
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x011b
            java.lang.String r2 = r7.X
            java.lang.String r3 = r8.X
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x011b
            java.util.List<androidx.media3.common.Label> r2 = r7.Y
            java.util.List<androidx.media3.common.Label> r3 = r8.Y
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x011b
            java.lang.String r2 = r7.c3
            java.lang.String r3 = r8.c3
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x011b
            java.lang.String r2 = r7.e3
            java.lang.String r3 = r8.e3
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x011b
            java.lang.String r2 = r7.f3
            java.lang.String r3 = r8.f3
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x011b
            java.lang.String r2 = r7.Z
            java.lang.String r3 = r8.Z
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x011b
            byte[] r2 = r7.p3
            byte[] r3 = r8.p3
            boolean r2 = java.util.Arrays.equals(r2, r3)
            if (r2 == 0) goto L_0x011b
            androidx.media3.common.Metadata r2 = r7.d3
            androidx.media3.common.Metadata r3 = r8.d3
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x011b
            androidx.media3.common.ColorInfo r2 = r7.r3
            androidx.media3.common.ColorInfo r3 = r8.r3
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x011b
            androidx.media3.common.DrmInitData r2 = r7.i3
            androidx.media3.common.DrmInitData r3 = r8.i3
            boolean r2 = androidx.media3.common.util.Util.g(r2, r3)
            if (r2 == 0) goto L_0x011b
            boolean r8 = r7.i(r8)
            if (r8 == 0) goto L_0x011b
            goto L_0x011c
        L_0x011b:
            r0 = 0
        L_0x011c:
            return r0
        L_0x011d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.Format.equals(java.lang.Object):boolean");
    }

    @UnstableApi
    public int h() {
        int i2;
        int i5 = this.k3;
        if (i5 == -1 || (i2 = this.l3) == -1) {
            return -1;
        }
        return i5 * i2;
    }

    public int hashCode() {
        if (this.C3 == 0) {
            String str = this.s;
            int i2 = 0;
            int hashCode = (MetaDo.w + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.X;
            int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.Y.hashCode()) * 31;
            String str3 = this.Z;
            int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.X2) * 31) + this.Y2) * 31) + this.Z2) * 31) + this.a3) * 31;
            String str4 = this.c3;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.d3;
            int hashCode5 = (hashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.e3;
            int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f3;
            if (str6 != null) {
                i2 = str6.hashCode();
            }
            this.C3 = ((((((((((((((((((((((((((((((((((hashCode6 + i2) * 31) + this.g3) * 31) + ((int) this.j3)) * 31) + this.k3) * 31) + this.l3) * 31) + Float.floatToIntBits(this.m3)) * 31) + this.n3) * 31) + Float.floatToIntBits(this.o3)) * 31) + this.q3) * 31) + this.s3) * 31) + this.t3) * 31) + this.u3) * 31) + this.v3) * 31) + this.w3) * 31) + this.x3) * 31) + this.z3) * 31) + this.A3) * 31) + this.B3;
        }
        return this.C3;
    }

    @UnstableApi
    public boolean i(Format format) {
        if (this.h3.size() != format.h3.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.h3.size(); i2++) {
            if (!Arrays.equals(this.h3.get(i2), format.h3.get(i2))) {
                return false;
            }
        }
        return true;
    }

    @UnstableApi
    public Bundle l(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString(I3, this.s);
        bundle.putString(J3, this.X);
        bundle.putParcelableArrayList(o4, BundleCollectionUtil.i(this.Y, new C0165p()));
        bundle.putString(K3, this.Z);
        bundle.putInt(L3, this.X2);
        bundle.putInt(M3, this.Y2);
        bundle.putInt(N3, this.Z2);
        bundle.putInt(O3, this.a3);
        bundle.putString(P3, this.c3);
        if (!z) {
            bundle.putParcelable(Q3, this.d3);
        }
        bundle.putString(R3, this.e3);
        bundle.putString(S3, this.f3);
        bundle.putInt(T3, this.g3);
        for (int i2 = 0; i2 < this.h3.size(); i2++) {
            bundle.putByteArray(j(i2), this.h3.get(i2));
        }
        bundle.putParcelable(V3, this.i3);
        bundle.putLong(W3, this.j3);
        bundle.putInt(X3, this.k3);
        bundle.putInt(Y3, this.l3);
        bundle.putFloat(Z3, this.m3);
        bundle.putInt(a4, this.n3);
        bundle.putFloat(b4, this.o3);
        bundle.putByteArray(c4, this.p3);
        bundle.putInt(d4, this.q3);
        ColorInfo colorInfo = this.r3;
        if (colorInfo != null) {
            bundle.putBundle(e4, colorInfo.a());
        }
        bundle.putInt(f4, this.s3);
        bundle.putInt(g4, this.t3);
        bundle.putInt(h4, this.u3);
        bundle.putInt(i4, this.v3);
        bundle.putInt(j4, this.w3);
        bundle.putInt(k4, this.x3);
        bundle.putInt(m4, this.z3);
        bundle.putInt(n4, this.A3);
        bundle.putInt(l4, this.B3);
        return bundle;
    }

    @UnstableApi
    public Format n(Format format) {
        String str;
        if (this == format) {
            return this;
        }
        int l2 = MimeTypes.l(this.f3);
        String str2 = format.s;
        int i2 = format.z3;
        int i5 = format.A3;
        String str3 = format.X;
        if (str3 == null) {
            str3 = this.X;
        }
        List<Label> list = !format.Y.isEmpty() ? format.Y : this.Y;
        String str4 = this.Z;
        if ((l2 == 3 || l2 == 1) && (str = format.Z) != null) {
            str4 = str;
        }
        int i6 = this.Z2;
        if (i6 == -1) {
            i6 = format.Z2;
        }
        int i7 = this.a3;
        if (i7 == -1) {
            i7 = format.a3;
        }
        String str5 = this.c3;
        if (str5 == null) {
            String g0 = Util.g0(format.c3, l2);
            if (Util.r2(g0).length == 1) {
                str5 = g0;
            }
        }
        Metadata metadata = this.d3;
        Metadata b2 = metadata == null ? format.d3 : metadata.b(format.d3);
        float f2 = this.m3;
        if (f2 == -1.0f && l2 == 2) {
            f2 = format.m3;
        }
        return c().X(str2).Z(str3).a0(list).b0(str4).m0(this.X2 | format.X2).i0(this.Y2 | format.Y2).K(i6).f0(i7).M(str5).d0(b2).R(DrmInitData.d(format.i3, this.i3)).U(f2).p0(i2).q0(i5).I();
    }

    public String toString() {
        return "Format(" + this.s + ", " + this.X + ", " + this.e3 + ", " + this.f3 + ", " + this.c3 + ", " + this.b3 + ", " + this.Z + ", [" + this.k3 + ", " + this.l3 + ", " + this.m3 + ", " + this.r3 + "], [" + this.s3 + ", " + this.t3 + "])";
    }
}

package androidx.media3.common;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;

public final class MediaMetadata implements Bundleable {
    public static final int A4 = 7;
    public static final int B3 = 0;
    public static final int B4 = 8;
    public static final int C3 = 1;
    public static final int C4 = 9;
    public static final int D3 = 2;
    public static final int D4 = 10;
    public static final int E3 = 3;
    public static final int E4 = 11;
    public static final int F3 = 4;
    public static final int F4 = 12;
    public static final int G3 = 5;
    public static final int G4 = 13;
    public static final int H3 = 6;
    public static final int H4 = 14;
    public static final int I3 = 7;
    public static final int I4 = 15;
    public static final int J3 = 8;
    public static final int J4 = 16;
    public static final int K3 = 9;
    public static final int K4 = 17;
    public static final int L3 = 10;
    public static final int L4 = 18;
    public static final int M3 = 11;
    public static final int M4 = 19;
    public static final int N3 = 12;
    public static final int N4 = 20;
    public static final int O3 = 13;
    public static final MediaMetadata O4 = new Builder().H();
    public static final int P3 = 14;
    private static final String P4 = Util.d1(0);
    public static final int Q3 = 15;
    private static final String Q4 = Util.d1(1);
    public static final int R3 = 16;
    private static final String R4 = Util.d1(2);
    public static final int S3 = 17;
    private static final String S4 = Util.d1(3);
    public static final int T3 = 18;
    private static final String T4 = Util.d1(4);
    public static final int U3 = 19;
    private static final String U4 = Util.d1(5);
    public static final int V3 = 20;
    private static final String V4 = Util.d1(6);
    public static final int W3 = 21;
    private static final String W4 = Util.d1(8);
    public static final int X3 = 22;
    private static final String X4 = Util.d1(9);
    public static final int Y3 = 23;
    private static final String Y4 = Util.d1(10);
    public static final int Z3 = 24;
    private static final String Z4 = Util.d1(11);
    public static final int a4 = 25;
    private static final String a5 = Util.d1(12);
    public static final int b4 = 26;
    private static final String b5 = Util.d1(13);
    public static final int c4 = 27;
    private static final String c5 = Util.d1(14);
    public static final int d4 = 28;
    private static final String d5 = Util.d1(15);
    public static final int e4 = 29;
    private static final String e5 = Util.d1(16);
    public static final int f4 = 30;
    private static final String f5 = Util.d1(17);
    public static final int g4 = 31;
    private static final String g5 = Util.d1(18);
    public static final int h4 = 32;
    private static final String h5 = Util.d1(19);
    public static final int i4 = 33;
    private static final String i5 = Util.d1(20);
    public static final int j4 = 34;
    private static final String j5 = Util.d1(21);
    public static final int k4 = 35;
    private static final String k5 = Util.d1(22);
    @Deprecated
    public static final int l4 = -1;
    private static final String l5 = Util.d1(23);
    @Deprecated
    public static final int m4 = 0;
    private static final String m5 = Util.d1(24);
    @Deprecated
    public static final int n4 = 1;
    private static final String n5 = Util.d1(25);
    @Deprecated
    public static final int o4 = 2;
    private static final String o5 = Util.d1(26);
    @Deprecated
    public static final int p4 = 3;
    private static final String p5 = Util.d1(27);
    @Deprecated
    public static final int q4 = 4;
    private static final String q5 = Util.d1(28);
    @Deprecated
    public static final int r4 = 5;
    private static final String r5 = Util.d1(29);
    @Deprecated
    public static final int s4 = 6;
    private static final String s5 = Util.d1(30);
    public static final int t4 = 0;
    private static final String t5 = Util.d1(31);
    public static final int u4 = 1;
    private static final String u5 = Util.d1(32);
    public static final int v4 = 2;
    private static final String v5 = Util.d1(1000);
    public static final int w4 = 3;
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<MediaMetadata> w5 = new F();
    public static final int x4 = 4;
    public static final int y4 = 5;
    public static final int z4 = 6;
    @Nullable
    public final Bundle A3;
    @Nullable
    public final CharSequence X;
    @Nullable
    public final CharSequence X2;
    @Nullable
    public final CharSequence Y;
    @Nullable
    public final CharSequence Y2;
    @Nullable
    public final CharSequence Z;
    @Nullable
    public final CharSequence Z2;
    @Nullable
    public final Rating a3;
    @Nullable
    public final Rating b3;
    @Nullable
    public final byte[] c3;
    @Nullable
    public final Integer d3;
    @Nullable
    public final Uri e3;
    @Nullable
    public final Integer f3;
    @Nullable
    public final Integer g3;
    @Deprecated
    @Nullable
    public final Integer h3;
    @Nullable
    public final Boolean i3;
    @Nullable
    public final Boolean j3;
    @UnstableApi
    @Deprecated
    @Nullable
    public final Integer k3;
    @Nullable
    public final Integer l3;
    @Nullable
    public final Integer m3;
    @Nullable
    public final Integer n3;
    @Nullable
    public final Integer o3;
    @Nullable
    public final Integer p3;
    @Nullable
    public final Integer q3;
    @Nullable
    public final CharSequence r3;
    @Nullable
    public final CharSequence s;
    @Nullable
    public final CharSequence s3;
    @Nullable
    public final CharSequence t3;
    @Nullable
    public final Integer u3;
    @Nullable
    public final Integer v3;
    @Nullable
    public final CharSequence w3;
    @Nullable
    public final CharSequence x3;
    @Nullable
    public final CharSequence y3;
    @Nullable
    public final Integer z3;

    public static final class Builder {
        /* access modifiers changed from: private */
        @Nullable
        public Integer A;
        /* access modifiers changed from: private */
        @Nullable
        public Integer B;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence C;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence D;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence E;
        /* access modifiers changed from: private */
        @Nullable
        public Integer F;
        /* access modifiers changed from: private */
        @Nullable
        public Bundle G;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f9212a;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f9213b;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f9214c;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f9215d;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f9216e;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f9217f;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public CharSequence f9218g;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public Rating f9219h;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public Rating f9220i;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public byte[] f9221j;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        public Integer f9222k;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        public Uri f9223l;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        public Integer f9224m;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: n  reason: collision with root package name */
        public Integer f9225n;
        /* access modifiers changed from: private */
        @Nullable
        public Integer o;
        /* access modifiers changed from: private */
        @Nullable
        public Boolean p;
        /* access modifiers changed from: private */
        @Nullable
        public Boolean q;
        /* access modifiers changed from: private */
        @Nullable
        public Integer r;
        /* access modifiers changed from: private */
        @Nullable
        public Integer s;
        /* access modifiers changed from: private */
        @Nullable
        public Integer t;
        /* access modifiers changed from: private */
        @Nullable
        public Integer u;
        /* access modifiers changed from: private */
        @Nullable
        public Integer v;
        /* access modifiers changed from: private */
        @Nullable
        public Integer w;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence x;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence y;
        /* access modifiers changed from: private */
        @Nullable
        public CharSequence z;

        public Builder() {
        }

        public MediaMetadata H() {
            return new MediaMetadata(this);
        }

        @CanIgnoreReturnValue
        public Builder I(byte[] bArr, int i2) {
            if (this.f9221j == null || Util.g(Integer.valueOf(i2), 3) || !Util.g(this.f9222k, 3)) {
                this.f9221j = (byte[]) bArr.clone();
                this.f9222k = Integer.valueOf(i2);
            }
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder J(@Nullable MediaMetadata mediaMetadata) {
            if (mediaMetadata == null) {
                return this;
            }
            CharSequence charSequence = mediaMetadata.s;
            if (charSequence != null) {
                n0(charSequence);
            }
            CharSequence charSequence2 = mediaMetadata.X;
            if (charSequence2 != null) {
                O(charSequence2);
            }
            CharSequence charSequence3 = mediaMetadata.Y;
            if (charSequence3 != null) {
                N(charSequence3);
            }
            CharSequence charSequence4 = mediaMetadata.Z;
            if (charSequence4 != null) {
                M(charSequence4);
            }
            CharSequence charSequence5 = mediaMetadata.X2;
            if (charSequence5 != null) {
                X(charSequence5);
            }
            CharSequence charSequence6 = mediaMetadata.Y2;
            if (charSequence6 != null) {
                m0(charSequence6);
            }
            CharSequence charSequence7 = mediaMetadata.Z2;
            if (charSequence7 != null) {
                V(charSequence7);
            }
            Rating rating = mediaMetadata.a3;
            if (rating != null) {
                r0(rating);
            }
            Rating rating2 = mediaMetadata.b3;
            if (rating2 != null) {
                e0(rating2);
            }
            Uri uri = mediaMetadata.e3;
            if (!(uri == null && mediaMetadata.c3 == null)) {
                R(uri);
                Q(mediaMetadata.c3, mediaMetadata.d3);
            }
            Integer num = mediaMetadata.f3;
            if (num != null) {
                q0(num);
            }
            Integer num2 = mediaMetadata.g3;
            if (num2 != null) {
                p0(num2);
            }
            Integer num3 = mediaMetadata.h3;
            if (num3 != null) {
                Z(num3);
            }
            Boolean bool = mediaMetadata.i3;
            if (bool != null) {
                b0(bool);
            }
            Boolean bool2 = mediaMetadata.j3;
            if (bool2 != null) {
                c0(bool2);
            }
            Integer num4 = mediaMetadata.k3;
            if (num4 != null) {
                h0(num4);
            }
            Integer num5 = mediaMetadata.l3;
            if (num5 != null) {
                h0(num5);
            }
            Integer num6 = mediaMetadata.m3;
            if (num6 != null) {
                g0(num6);
            }
            Integer num7 = mediaMetadata.n3;
            if (num7 != null) {
                f0(num7);
            }
            Integer num8 = mediaMetadata.o3;
            if (num8 != null) {
                k0(num8);
            }
            Integer num9 = mediaMetadata.p3;
            if (num9 != null) {
                j0(num9);
            }
            Integer num10 = mediaMetadata.q3;
            if (num10 != null) {
                i0(num10);
            }
            CharSequence charSequence8 = mediaMetadata.r3;
            if (charSequence8 != null) {
                s0(charSequence8);
            }
            CharSequence charSequence9 = mediaMetadata.s3;
            if (charSequence9 != null) {
                T(charSequence9);
            }
            CharSequence charSequence10 = mediaMetadata.t3;
            if (charSequence10 != null) {
                U(charSequence10);
            }
            Integer num11 = mediaMetadata.u3;
            if (num11 != null) {
                W(num11);
            }
            Integer num12 = mediaMetadata.v3;
            if (num12 != null) {
                o0(num12);
            }
            CharSequence charSequence11 = mediaMetadata.w3;
            if (charSequence11 != null) {
                a0(charSequence11);
            }
            CharSequence charSequence12 = mediaMetadata.x3;
            if (charSequence12 != null) {
                S(charSequence12);
            }
            CharSequence charSequence13 = mediaMetadata.y3;
            if (charSequence13 != null) {
                l0(charSequence13);
            }
            Integer num13 = mediaMetadata.z3;
            if (num13 != null) {
                d0(num13);
            }
            Bundle bundle = mediaMetadata.A3;
            if (bundle != null) {
                Y(bundle);
            }
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder K(Metadata metadata) {
            for (int i2 = 0; i2 < metadata.g(); i2++) {
                metadata.d(i2).q(this);
            }
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder L(List<Metadata> list) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                Metadata metadata = list.get(i2);
                for (int i3 = 0; i3 < metadata.g(); i3++) {
                    metadata.d(i3).q(this);
                }
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder M(@Nullable CharSequence charSequence) {
            this.f9215d = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder N(@Nullable CharSequence charSequence) {
            this.f9214c = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder O(@Nullable CharSequence charSequence) {
            this.f9213b = charSequence;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder P(@Nullable byte[] bArr) {
            return Q(bArr, (Integer) null);
        }

        @CanIgnoreReturnValue
        public Builder Q(@Nullable byte[] bArr, @Nullable Integer num) {
            this.f9221j = bArr == null ? null : (byte[]) bArr.clone();
            this.f9222k = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder R(@Nullable Uri uri) {
            this.f9223l = uri;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder S(@Nullable CharSequence charSequence) {
            this.D = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder T(@Nullable CharSequence charSequence) {
            this.y = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder U(@Nullable CharSequence charSequence) {
            this.z = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder V(@Nullable CharSequence charSequence) {
            this.f9218g = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder W(@Nullable Integer num) {
            this.A = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder X(@Nullable CharSequence charSequence) {
            this.f9216e = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder Y(@Nullable Bundle bundle) {
            this.G = bundle;
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder Z(@Nullable Integer num) {
            this.o = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder a0(@Nullable CharSequence charSequence) {
            this.C = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder b0(@Nullable Boolean bool) {
            this.p = bool;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c0(@Nullable Boolean bool) {
            this.q = bool;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d0(@Nullable Integer num) {
            this.F = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e0(@Nullable Rating rating) {
            this.f9220i = rating;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f0(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.t = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g0(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.s = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h0(@Nullable Integer num) {
            this.r = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder i0(@IntRange(from = 1, to = 31) @Nullable Integer num) {
            this.w = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder j0(@IntRange(from = 1, to = 12) @Nullable Integer num) {
            this.v = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder k0(@Nullable Integer num) {
            this.u = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder l0(@Nullable CharSequence charSequence) {
            this.E = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder m0(@Nullable CharSequence charSequence) {
            this.f9217f = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder n0(@Nullable CharSequence charSequence) {
            this.f9212a = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder o0(@Nullable Integer num) {
            this.B = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder p0(@Nullable Integer num) {
            this.f9225n = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder q0(@Nullable Integer num) {
            this.f9224m = num;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder r0(@Nullable Rating rating) {
            this.f9219h = rating;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder s0(@Nullable CharSequence charSequence) {
            this.x = charSequence;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        @Deprecated
        public Builder t0(@Nullable Integer num) {
            return h0(num);
        }

        private Builder(MediaMetadata mediaMetadata) {
            this.f9212a = mediaMetadata.s;
            this.f9213b = mediaMetadata.X;
            this.f9214c = mediaMetadata.Y;
            this.f9215d = mediaMetadata.Z;
            this.f9216e = mediaMetadata.X2;
            this.f9217f = mediaMetadata.Y2;
            this.f9218g = mediaMetadata.Z2;
            this.f9219h = mediaMetadata.a3;
            this.f9220i = mediaMetadata.b3;
            this.f9221j = mediaMetadata.c3;
            this.f9222k = mediaMetadata.d3;
            this.f9223l = mediaMetadata.e3;
            this.f9224m = mediaMetadata.f3;
            this.f9225n = mediaMetadata.g3;
            this.o = mediaMetadata.h3;
            this.p = mediaMetadata.i3;
            this.q = mediaMetadata.j3;
            this.r = mediaMetadata.l3;
            this.s = mediaMetadata.m3;
            this.t = mediaMetadata.n3;
            this.u = mediaMetadata.o3;
            this.v = mediaMetadata.p3;
            this.w = mediaMetadata.q3;
            this.x = mediaMetadata.r3;
            this.y = mediaMetadata.s3;
            this.z = mediaMetadata.t3;
            this.A = mediaMetadata.u3;
            this.B = mediaMetadata.v3;
            this.C = mediaMetadata.w3;
            this.D = mediaMetadata.x3;
            this.E = mediaMetadata.y3;
            this.F = mediaMetadata.z3;
            this.G = mediaMetadata.A3;
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Deprecated
    @Retention(RetentionPolicy.SOURCE)
    public @interface FolderType {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaType {
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PictureType {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private MediaMetadata(androidx.media3.common.MediaMetadata.Builder r7) {
        /*
            r6 = this;
            r6.<init>()
            java.lang.Boolean r0 = r7.p
            java.lang.Integer r1 = r7.o
            java.lang.Integer r2 = r7.F
            r3 = 0
            r4 = -1
            if (r0 == 0) goto L_0x0035
            boolean r5 = r0.booleanValue()
            if (r5 != 0) goto L_0x001e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x0052
        L_0x001e:
            if (r1 == 0) goto L_0x0026
            int r5 = r1.intValue()
            if (r5 != r4) goto L_0x0052
        L_0x0026:
            if (r2 == 0) goto L_0x0030
            int r1 = r2.intValue()
            int r3 = d(r1)
        L_0x0030:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x0052
        L_0x0035:
            if (r1 == 0) goto L_0x0052
            int r0 = r1.intValue()
            if (r0 == r4) goto L_0x003e
            r3 = 1
        L_0x003e:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            if (r3 == 0) goto L_0x0052
            if (r2 != 0) goto L_0x0052
            int r2 = r1.intValue()
            int r2 = e(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0052:
            java.lang.CharSequence r3 = r7.f9212a
            r6.s = r3
            java.lang.CharSequence r3 = r7.f9213b
            r6.X = r3
            java.lang.CharSequence r3 = r7.f9214c
            r6.Y = r3
            java.lang.CharSequence r3 = r7.f9215d
            r6.Z = r3
            java.lang.CharSequence r3 = r7.f9216e
            r6.X2 = r3
            java.lang.CharSequence r3 = r7.f9217f
            r6.Y2 = r3
            java.lang.CharSequence r3 = r7.f9218g
            r6.Z2 = r3
            androidx.media3.common.Rating r3 = r7.f9219h
            r6.a3 = r3
            androidx.media3.common.Rating r3 = r7.f9220i
            r6.b3 = r3
            byte[] r3 = r7.f9221j
            r6.c3 = r3
            java.lang.Integer r3 = r7.f9222k
            r6.d3 = r3
            android.net.Uri r3 = r7.f9223l
            r6.e3 = r3
            java.lang.Integer r3 = r7.f9224m
            r6.f3 = r3
            java.lang.Integer r3 = r7.f9225n
            r6.g3 = r3
            r6.h3 = r1
            r6.i3 = r0
            java.lang.Boolean r0 = r7.q
            r6.j3 = r0
            java.lang.Integer r0 = r7.r
            r6.k3 = r0
            java.lang.Integer r0 = r7.r
            r6.l3 = r0
            java.lang.Integer r0 = r7.s
            r6.m3 = r0
            java.lang.Integer r0 = r7.t
            r6.n3 = r0
            java.lang.Integer r0 = r7.u
            r6.o3 = r0
            java.lang.Integer r0 = r7.v
            r6.p3 = r0
            java.lang.Integer r0 = r7.w
            r6.q3 = r0
            java.lang.CharSequence r0 = r7.x
            r6.r3 = r0
            java.lang.CharSequence r0 = r7.y
            r6.s3 = r0
            java.lang.CharSequence r0 = r7.z
            r6.t3 = r0
            java.lang.Integer r0 = r7.A
            r6.u3 = r0
            java.lang.Integer r0 = r7.B
            r6.v3 = r0
            java.lang.CharSequence r0 = r7.C
            r6.w3 = r0
            java.lang.CharSequence r0 = r7.D
            r6.x3 = r0
            java.lang.CharSequence r0 = r7.E
            r6.y3 = r0
            r6.z3 = r2
            android.os.Bundle r7 = r7.G
            r6.A3 = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.MediaMetadata.<init>(androidx.media3.common.MediaMetadata$Builder):void");
    }

    @UnstableApi
    public static MediaMetadata c(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        Builder builder = new Builder();
        Builder V = builder.n0(bundle.getCharSequence(P4)).O(bundle.getCharSequence(Q4)).N(bundle.getCharSequence(R4)).M(bundle.getCharSequence(S4)).X(bundle.getCharSequence(T4)).m0(bundle.getCharSequence(U4)).V(bundle.getCharSequence(V4));
        byte[] byteArray = bundle.getByteArray(Y4);
        String str = r5;
        V.Q(byteArray, bundle.containsKey(str) ? Integer.valueOf(bundle.getInt(str)) : null).R((Uri) bundle.getParcelable(Z4)).s0(bundle.getCharSequence(k5)).T(bundle.getCharSequence(l5)).U(bundle.getCharSequence(m5)).a0(bundle.getCharSequence(p5)).S(bundle.getCharSequence(q5)).l0(bundle.getCharSequence(s5)).Y(bundle.getBundle(v5));
        String str2 = W4;
        if (bundle.containsKey(str2) && (bundle3 = bundle.getBundle(str2)) != null) {
            builder.r0(Rating.b(bundle3));
        }
        String str3 = X4;
        if (bundle.containsKey(str3) && (bundle2 = bundle.getBundle(str3)) != null) {
            builder.e0(Rating.b(bundle2));
        }
        String str4 = a5;
        if (bundle.containsKey(str4)) {
            builder.q0(Integer.valueOf(bundle.getInt(str4)));
        }
        String str5 = b5;
        if (bundle.containsKey(str5)) {
            builder.p0(Integer.valueOf(bundle.getInt(str5)));
        }
        String str6 = c5;
        if (bundle.containsKey(str6)) {
            builder.Z(Integer.valueOf(bundle.getInt(str6)));
        }
        String str7 = u5;
        if (bundle.containsKey(str7)) {
            builder.b0(Boolean.valueOf(bundle.getBoolean(str7)));
        }
        String str8 = d5;
        if (bundle.containsKey(str8)) {
            builder.c0(Boolean.valueOf(bundle.getBoolean(str8)));
        }
        String str9 = e5;
        if (bundle.containsKey(str9)) {
            builder.h0(Integer.valueOf(bundle.getInt(str9)));
        }
        String str10 = f5;
        if (bundle.containsKey(str10)) {
            builder.g0(Integer.valueOf(bundle.getInt(str10)));
        }
        String str11 = g5;
        if (bundle.containsKey(str11)) {
            builder.f0(Integer.valueOf(bundle.getInt(str11)));
        }
        String str12 = h5;
        if (bundle.containsKey(str12)) {
            builder.k0(Integer.valueOf(bundle.getInt(str12)));
        }
        String str13 = i5;
        if (bundle.containsKey(str13)) {
            builder.j0(Integer.valueOf(bundle.getInt(str13)));
        }
        String str14 = j5;
        if (bundle.containsKey(str14)) {
            builder.i0(Integer.valueOf(bundle.getInt(str14)));
        }
        String str15 = n5;
        if (bundle.containsKey(str15)) {
            builder.W(Integer.valueOf(bundle.getInt(str15)));
        }
        String str16 = o5;
        if (bundle.containsKey(str16)) {
            builder.o0(Integer.valueOf(bundle.getInt(str16)));
        }
        String str17 = t5;
        if (bundle.containsKey(str17)) {
            builder.d0(Integer.valueOf(bundle.getInt(str17)));
        }
        return builder.H();
    }

    private static int d(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                return 1;
            case 21:
                return 2;
            case 22:
                return 3;
            case 23:
                return 4;
            case 24:
                return 5;
            case 25:
                return 6;
            default:
                return 0;
        }
    }

    private static int e(int i2) {
        switch (i2) {
            case 1:
                return 0;
            case 2:
                return 21;
            case 3:
                return 22;
            case 4:
                return 23;
            case 5:
                return 24;
            case 6:
                return 25;
            default:
                return 20;
        }
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.s;
        if (charSequence != null) {
            bundle.putCharSequence(P4, charSequence);
        }
        CharSequence charSequence2 = this.X;
        if (charSequence2 != null) {
            bundle.putCharSequence(Q4, charSequence2);
        }
        CharSequence charSequence3 = this.Y;
        if (charSequence3 != null) {
            bundle.putCharSequence(R4, charSequence3);
        }
        CharSequence charSequence4 = this.Z;
        if (charSequence4 != null) {
            bundle.putCharSequence(S4, charSequence4);
        }
        CharSequence charSequence5 = this.X2;
        if (charSequence5 != null) {
            bundle.putCharSequence(T4, charSequence5);
        }
        CharSequence charSequence6 = this.Y2;
        if (charSequence6 != null) {
            bundle.putCharSequence(U4, charSequence6);
        }
        CharSequence charSequence7 = this.Z2;
        if (charSequence7 != null) {
            bundle.putCharSequence(V4, charSequence7);
        }
        byte[] bArr = this.c3;
        if (bArr != null) {
            bundle.putByteArray(Y4, bArr);
        }
        Uri uri = this.e3;
        if (uri != null) {
            bundle.putParcelable(Z4, uri);
        }
        CharSequence charSequence8 = this.r3;
        if (charSequence8 != null) {
            bundle.putCharSequence(k5, charSequence8);
        }
        CharSequence charSequence9 = this.s3;
        if (charSequence9 != null) {
            bundle.putCharSequence(l5, charSequence9);
        }
        CharSequence charSequence10 = this.t3;
        if (charSequence10 != null) {
            bundle.putCharSequence(m5, charSequence10);
        }
        CharSequence charSequence11 = this.w3;
        if (charSequence11 != null) {
            bundle.putCharSequence(p5, charSequence11);
        }
        CharSequence charSequence12 = this.x3;
        if (charSequence12 != null) {
            bundle.putCharSequence(q5, charSequence12);
        }
        CharSequence charSequence13 = this.y3;
        if (charSequence13 != null) {
            bundle.putCharSequence(s5, charSequence13);
        }
        Rating rating = this.a3;
        if (rating != null) {
            bundle.putBundle(W4, rating.a());
        }
        Rating rating2 = this.b3;
        if (rating2 != null) {
            bundle.putBundle(X4, rating2.a());
        }
        Integer num = this.f3;
        if (num != null) {
            bundle.putInt(a5, num.intValue());
        }
        Integer num2 = this.g3;
        if (num2 != null) {
            bundle.putInt(b5, num2.intValue());
        }
        Integer num3 = this.h3;
        if (num3 != null) {
            bundle.putInt(c5, num3.intValue());
        }
        Boolean bool = this.i3;
        if (bool != null) {
            bundle.putBoolean(u5, bool.booleanValue());
        }
        Boolean bool2 = this.j3;
        if (bool2 != null) {
            bundle.putBoolean(d5, bool2.booleanValue());
        }
        Integer num4 = this.l3;
        if (num4 != null) {
            bundle.putInt(e5, num4.intValue());
        }
        Integer num5 = this.m3;
        if (num5 != null) {
            bundle.putInt(f5, num5.intValue());
        }
        Integer num6 = this.n3;
        if (num6 != null) {
            bundle.putInt(g5, num6.intValue());
        }
        Integer num7 = this.o3;
        if (num7 != null) {
            bundle.putInt(h5, num7.intValue());
        }
        Integer num8 = this.p3;
        if (num8 != null) {
            bundle.putInt(i5, num8.intValue());
        }
        Integer num9 = this.q3;
        if (num9 != null) {
            bundle.putInt(j5, num9.intValue());
        }
        Integer num10 = this.u3;
        if (num10 != null) {
            bundle.putInt(n5, num10.intValue());
        }
        Integer num11 = this.v3;
        if (num11 != null) {
            bundle.putInt(o5, num11.intValue());
        }
        Integer num12 = this.d3;
        if (num12 != null) {
            bundle.putInt(r5, num12.intValue());
        }
        Integer num13 = this.z3;
        if (num13 != null) {
            bundle.putInt(t5, num13.intValue());
        }
        Bundle bundle2 = this.A3;
        if (bundle2 != null) {
            bundle.putBundle(v5, bundle2);
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
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        if (Util.g(this.s, mediaMetadata.s) && Util.g(this.X, mediaMetadata.X) && Util.g(this.Y, mediaMetadata.Y) && Util.g(this.Z, mediaMetadata.Z) && Util.g(this.X2, mediaMetadata.X2) && Util.g(this.Y2, mediaMetadata.Y2) && Util.g(this.Z2, mediaMetadata.Z2) && Util.g(this.a3, mediaMetadata.a3) && Util.g(this.b3, mediaMetadata.b3) && Arrays.equals(this.c3, mediaMetadata.c3) && Util.g(this.d3, mediaMetadata.d3) && Util.g(this.e3, mediaMetadata.e3) && Util.g(this.f3, mediaMetadata.f3) && Util.g(this.g3, mediaMetadata.g3) && Util.g(this.h3, mediaMetadata.h3) && Util.g(this.i3, mediaMetadata.i3) && Util.g(this.j3, mediaMetadata.j3) && Util.g(this.l3, mediaMetadata.l3) && Util.g(this.m3, mediaMetadata.m3) && Util.g(this.n3, mediaMetadata.n3) && Util.g(this.o3, mediaMetadata.o3) && Util.g(this.p3, mediaMetadata.p3) && Util.g(this.q3, mediaMetadata.q3) && Util.g(this.r3, mediaMetadata.r3) && Util.g(this.s3, mediaMetadata.s3) && Util.g(this.t3, mediaMetadata.t3) && Util.g(this.u3, mediaMetadata.u3) && Util.g(this.v3, mediaMetadata.v3) && Util.g(this.w3, mediaMetadata.w3) && Util.g(this.x3, mediaMetadata.x3) && Util.g(this.y3, mediaMetadata.y3) && Util.g(this.z3, mediaMetadata.z3)) {
            if ((this.A3 == null) == (mediaMetadata.A3 == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(this.s, this.X, this.Y, this.Z, this.X2, this.Y2, this.Z2, this.a3, this.b3, Integer.valueOf(Arrays.hashCode(this.c3)), this.d3, this.e3, this.f3, this.g3, this.h3, this.i3, this.j3, this.l3, this.m3, this.n3, this.o3, this.p3, this.q3, this.r3, this.s3, this.t3, this.u3, this.v3, this.w3, this.x3, this.y3, this.z3, Boolean.valueOf(this.A3 == null));
    }
}

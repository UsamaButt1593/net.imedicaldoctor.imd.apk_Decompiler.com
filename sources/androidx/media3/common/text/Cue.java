package androidx.media3.common.text;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import org.checkerframework.dataflow.qual.Pure;

public final class Cue implements Bundleable {
    private static final String A3 = Util.d1(2);
    private static final String B3 = Util.d1(3);
    private static final String C3 = Util.d1(18);
    private static final String D3 = Util.d1(4);
    private static final String E3 = Util.d1(5);
    private static final String F3 = Util.d1(6);
    private static final String G3 = Util.d1(7);
    private static final String H3 = Util.d1(8);
    private static final String I3 = Util.d1(9);
    private static final String J3 = Util.d1(10);
    private static final String K3 = Util.d1(11);
    private static final String L3 = Util.d1(12);
    private static final String M3 = Util.d1(13);
    private static final String N3 = Util.d1(14);
    private static final String O3 = Util.d1(15);
    private static final String P3 = Util.d1(16);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<Cue> Q3 = new a();
    @Deprecated
    public static final Cue k3 = new Builder().A("").a();
    public static final float l3 = -3.4028235E38f;
    public static final int m3 = Integer.MIN_VALUE;
    public static final int n3 = 0;
    public static final int o3 = 1;
    public static final int p3 = 2;
    public static final int q3 = 0;
    public static final int r3 = 1;
    public static final int s3 = 0;
    public static final int t3 = 1;
    public static final int u3 = 2;
    public static final int v3 = 1;
    public static final int w3 = 2;
    private static final String x3 = Util.d1(0);
    private static final String y3 = Util.d1(17);
    private static final String z3 = Util.d1(1);
    @Nullable
    public final Layout.Alignment X;
    public final float X2;
    @Nullable
    public final Layout.Alignment Y;
    public final int Y2;
    @Nullable
    public final Bitmap Z;
    public final int Z2;
    public final float a3;
    public final int b3;
    public final float c3;
    public final float d3;
    public final boolean e3;
    public final int f3;
    public final int g3;
    public final float h3;
    public final int i3;
    public final float j3;
    @Nullable
    public final CharSequence s;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AnchorType {
    }

    @UnstableApi
    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private CharSequence f9453a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Bitmap f9454b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Layout.Alignment f9455c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Layout.Alignment f9456d;

        /* renamed from: e  reason: collision with root package name */
        private float f9457e;

        /* renamed from: f  reason: collision with root package name */
        private int f9458f;

        /* renamed from: g  reason: collision with root package name */
        private int f9459g;

        /* renamed from: h  reason: collision with root package name */
        private float f9460h;

        /* renamed from: i  reason: collision with root package name */
        private int f9461i;

        /* renamed from: j  reason: collision with root package name */
        private int f9462j;

        /* renamed from: k  reason: collision with root package name */
        private float f9463k;

        /* renamed from: l  reason: collision with root package name */
        private float f9464l;

        /* renamed from: m  reason: collision with root package name */
        private float f9465m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f9466n;
        @ColorInt
        private int o;
        private int p;
        private float q;

        public Builder() {
            this.f9453a = null;
            this.f9454b = null;
            this.f9455c = null;
            this.f9456d = null;
            this.f9457e = -3.4028235E38f;
            this.f9458f = Integer.MIN_VALUE;
            this.f9459g = Integer.MIN_VALUE;
            this.f9460h = -3.4028235E38f;
            this.f9461i = Integer.MIN_VALUE;
            this.f9462j = Integer.MIN_VALUE;
            this.f9463k = -3.4028235E38f;
            this.f9464l = -3.4028235E38f;
            this.f9465m = -3.4028235E38f;
            this.f9466n = false;
            this.o = ViewCompat.y;
            this.p = Integer.MIN_VALUE;
        }

        @CanIgnoreReturnValue
        public Builder A(CharSequence charSequence) {
            this.f9453a = charSequence;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder B(@Nullable Layout.Alignment alignment) {
            this.f9455c = alignment;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder C(float f2, int i2) {
            this.f9463k = f2;
            this.f9462j = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder D(int i2) {
            this.p = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder E(@ColorInt int i2) {
            this.o = i2;
            this.f9466n = true;
            return this;
        }

        public Cue a() {
            return new Cue(this.f9453a, this.f9455c, this.f9456d, this.f9454b, this.f9457e, this.f9458f, this.f9459g, this.f9460h, this.f9461i, this.f9462j, this.f9463k, this.f9464l, this.f9465m, this.f9466n, this.o, this.p, this.q);
        }

        @CanIgnoreReturnValue
        public Builder b() {
            this.f9466n = false;
            return this;
        }

        @Nullable
        @Pure
        public Bitmap c() {
            return this.f9454b;
        }

        @Pure
        public float d() {
            return this.f9465m;
        }

        @Pure
        public float e() {
            return this.f9457e;
        }

        @Pure
        public int f() {
            return this.f9459g;
        }

        @Pure
        public int g() {
            return this.f9458f;
        }

        @Pure
        public float h() {
            return this.f9460h;
        }

        @Pure
        public int i() {
            return this.f9461i;
        }

        @Pure
        public float j() {
            return this.f9464l;
        }

        @Nullable
        @Pure
        public CharSequence k() {
            return this.f9453a;
        }

        @Nullable
        @Pure
        public Layout.Alignment l() {
            return this.f9455c;
        }

        @Pure
        public float m() {
            return this.f9463k;
        }

        @Pure
        public int n() {
            return this.f9462j;
        }

        @Pure
        public int o() {
            return this.p;
        }

        @ColorInt
        @Pure
        public int p() {
            return this.o;
        }

        public boolean q() {
            return this.f9466n;
        }

        @CanIgnoreReturnValue
        public Builder r(Bitmap bitmap) {
            this.f9454b = bitmap;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder s(float f2) {
            this.f9465m = f2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder t(float f2, int i2) {
            this.f9457e = f2;
            this.f9458f = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder u(int i2) {
            this.f9459g = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder v(@Nullable Layout.Alignment alignment) {
            this.f9456d = alignment;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder w(float f2) {
            this.f9460h = f2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder x(int i2) {
            this.f9461i = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder y(float f2) {
            this.q = f2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder z(float f2) {
            this.f9464l = f2;
            return this;
        }

        private Builder(Cue cue) {
            this.f9453a = cue.s;
            this.f9454b = cue.Z;
            this.f9455c = cue.X;
            this.f9456d = cue.Y;
            this.f9457e = cue.X2;
            this.f9458f = cue.Y2;
            this.f9459g = cue.Z2;
            this.f9460h = cue.a3;
            this.f9461i = cue.b3;
            this.f9462j = cue.g3;
            this.f9463k = cue.h3;
            this.f9464l = cue.c3;
            this.f9465m = cue.d3;
            this.f9466n = cue.e3;
            this.o = cue.f3;
            this.p = cue.i3;
            this.q = cue.j3;
        }
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType {
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextSizeType {
    }

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface VerticalType {
    }

    private Cue(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f2, int i2, int i4, float f4, int i5, int i6, float f5, float f6, float f7, boolean z, int i7, int i8, float f8) {
        CharSequence charSequence2 = charSequence;
        Bitmap bitmap2 = bitmap;
        if (charSequence2 == null) {
            Assertions.g(bitmap);
        } else {
            Assertions.a(bitmap2 == null);
        }
        this.s = charSequence2 instanceof Spanned ? SpannedString.valueOf(charSequence) : charSequence2 != null ? charSequence.toString() : null;
        this.X = alignment;
        this.Y = alignment2;
        this.Z = bitmap2;
        this.X2 = f2;
        this.Y2 = i2;
        this.Z2 = i4;
        this.a3 = f4;
        this.b3 = i5;
        this.c3 = f6;
        this.d3 = f7;
        this.e3 = z;
        this.f3 = i7;
        this.g3 = i6;
        this.h3 = f5;
        this.i3 = i8;
        this.j3 = f8;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011c  */
    @androidx.media3.common.util.UnstableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media3.common.text.Cue c(android.os.Bundle r5) {
        /*
            androidx.media3.common.text.Cue$Builder r0 = new androidx.media3.common.text.Cue$Builder
            r0.<init>()
            java.lang.String r1 = x3
            java.lang.CharSequence r1 = r5.getCharSequence(r1)
            if (r1 == 0) goto L_0x0033
            r0.A(r1)
            java.lang.String r2 = y3
            java.util.ArrayList r2 = r5.getParcelableArrayList(r2)
            if (r2 == 0) goto L_0x0033
            android.text.SpannableString r1 = android.text.SpannableString.valueOf(r1)
            java.util.Iterator r2 = r2.iterator()
        L_0x0020:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0030
            java.lang.Object r3 = r2.next()
            android.os.Bundle r3 = (android.os.Bundle) r3
            androidx.media3.common.text.CustomSpanBundler.c(r3, r1)
            goto L_0x0020
        L_0x0030:
            r0.A(r1)
        L_0x0033:
            java.lang.String r1 = z3
            java.io.Serializable r1 = r5.getSerializable(r1)
            android.text.Layout$Alignment r1 = (android.text.Layout.Alignment) r1
            if (r1 == 0) goto L_0x0040
            r0.B(r1)
        L_0x0040:
            java.lang.String r1 = A3
            java.io.Serializable r1 = r5.getSerializable(r1)
            android.text.Layout$Alignment r1 = (android.text.Layout.Alignment) r1
            if (r1 == 0) goto L_0x004d
            r0.v(r1)
        L_0x004d:
            java.lang.String r1 = B3
            android.os.Parcelable r1 = r5.getParcelable(r1)
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            r2 = 0
            if (r1 == 0) goto L_0x005c
        L_0x0058:
            r0.r(r1)
            goto L_0x006a
        L_0x005c:
            java.lang.String r1 = C3
            byte[] r1 = r5.getByteArray(r1)
            if (r1 == 0) goto L_0x006a
            int r3 = r1.length
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r2, r3)
            goto L_0x0058
        L_0x006a:
            java.lang.String r1 = D3
            boolean r3 = r5.containsKey(r1)
            if (r3 == 0) goto L_0x0085
            java.lang.String r3 = E3
            boolean r4 = r5.containsKey(r3)
            if (r4 == 0) goto L_0x0085
            float r1 = r5.getFloat(r1)
            int r3 = r5.getInt(r3)
            r0.t(r1, r3)
        L_0x0085:
            java.lang.String r1 = F3
            boolean r3 = r5.containsKey(r1)
            if (r3 == 0) goto L_0x0094
            int r1 = r5.getInt(r1)
            r0.u(r1)
        L_0x0094:
            java.lang.String r1 = G3
            boolean r3 = r5.containsKey(r1)
            if (r3 == 0) goto L_0x00a3
            float r1 = r5.getFloat(r1)
            r0.w(r1)
        L_0x00a3:
            java.lang.String r1 = H3
            boolean r3 = r5.containsKey(r1)
            if (r3 == 0) goto L_0x00b2
            int r1 = r5.getInt(r1)
            r0.x(r1)
        L_0x00b2:
            java.lang.String r1 = J3
            boolean r3 = r5.containsKey(r1)
            if (r3 == 0) goto L_0x00cd
            java.lang.String r3 = I3
            boolean r4 = r5.containsKey(r3)
            if (r4 == 0) goto L_0x00cd
            float r1 = r5.getFloat(r1)
            int r3 = r5.getInt(r3)
            r0.C(r1, r3)
        L_0x00cd:
            java.lang.String r1 = K3
            boolean r3 = r5.containsKey(r1)
            if (r3 == 0) goto L_0x00dc
            float r1 = r5.getFloat(r1)
            r0.z(r1)
        L_0x00dc:
            java.lang.String r1 = L3
            boolean r3 = r5.containsKey(r1)
            if (r3 == 0) goto L_0x00eb
            float r1 = r5.getFloat(r1)
            r0.s(r1)
        L_0x00eb:
            java.lang.String r1 = M3
            boolean r3 = r5.containsKey(r1)
            if (r3 == 0) goto L_0x00fa
            int r1 = r5.getInt(r1)
            r0.E(r1)
        L_0x00fa:
            java.lang.String r1 = N3
            boolean r1 = r5.getBoolean(r1, r2)
            if (r1 != 0) goto L_0x0105
            r0.b()
        L_0x0105:
            java.lang.String r1 = O3
            boolean r2 = r5.containsKey(r1)
            if (r2 == 0) goto L_0x0114
            int r1 = r5.getInt(r1)
            r0.D(r1)
        L_0x0114:
            java.lang.String r1 = P3
            boolean r2 = r5.containsKey(r1)
            if (r2 == 0) goto L_0x0123
            float r5 = r5.getFloat(r1)
            r0.y(r5)
        L_0x0123:
            androidx.media3.common.text.Cue r5 = r0.a()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.text.Cue.c(android.os.Bundle):androidx.media3.common.text.Cue");
    }

    private Bundle e() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.s;
        if (charSequence != null) {
            bundle.putCharSequence(x3, charSequence);
            CharSequence charSequence2 = this.s;
            if (charSequence2 instanceof Spanned) {
                ArrayList<Bundle> a2 = CustomSpanBundler.a((Spanned) charSequence2);
                if (!a2.isEmpty()) {
                    bundle.putParcelableArrayList(y3, a2);
                }
            }
        }
        bundle.putSerializable(z3, this.X);
        bundle.putSerializable(A3, this.Y);
        bundle.putFloat(D3, this.X2);
        bundle.putInt(E3, this.Y2);
        bundle.putInt(F3, this.Z2);
        bundle.putFloat(G3, this.a3);
        bundle.putInt(H3, this.b3);
        bundle.putInt(I3, this.g3);
        bundle.putFloat(J3, this.h3);
        bundle.putFloat(K3, this.c3);
        bundle.putFloat(L3, this.d3);
        bundle.putBoolean(N3, this.e3);
        bundle.putInt(M3, this.f3);
        bundle.putInt(O3, this.i3);
        bundle.putFloat(P3, this.j3);
        return bundle;
    }

    @UnstableApi
    @Deprecated
    public Bundle a() {
        return d();
    }

    @UnstableApi
    public Builder b() {
        return new Builder();
    }

    @UnstableApi
    public Bundle d() {
        Bundle e2 = e();
        Bitmap bitmap = this.Z;
        if (bitmap != null) {
            e2.putParcelable(B3, bitmap);
        }
        return e2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        r2 = r4.Z;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        r3 = r5.Z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@androidx.annotation.Nullable java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r5 == 0) goto L_0x0099
            java.lang.Class r2 = r5.getClass()
            java.lang.Class<androidx.media3.common.text.Cue> r3 = androidx.media3.common.text.Cue.class
            if (r3 == r2) goto L_0x0011
            goto L_0x0099
        L_0x0011:
            androidx.media3.common.text.Cue r5 = (androidx.media3.common.text.Cue) r5
            java.lang.CharSequence r2 = r4.s
            java.lang.CharSequence r3 = r5.s
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L_0x0097
            android.text.Layout$Alignment r2 = r4.X
            android.text.Layout$Alignment r3 = r5.X
            if (r2 != r3) goto L_0x0097
            android.text.Layout$Alignment r2 = r4.Y
            android.text.Layout$Alignment r3 = r5.Y
            if (r2 != r3) goto L_0x0097
            android.graphics.Bitmap r2 = r4.Z
            if (r2 != 0) goto L_0x0032
            android.graphics.Bitmap r2 = r5.Z
            if (r2 != 0) goto L_0x0097
            goto L_0x003c
        L_0x0032:
            android.graphics.Bitmap r3 = r5.Z
            if (r3 == 0) goto L_0x0097
            boolean r2 = r2.sameAs(r3)
            if (r2 == 0) goto L_0x0097
        L_0x003c:
            float r2 = r4.X2
            float r3 = r5.X2
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0097
            int r2 = r4.Y2
            int r3 = r5.Y2
            if (r2 != r3) goto L_0x0097
            int r2 = r4.Z2
            int r3 = r5.Z2
            if (r2 != r3) goto L_0x0097
            float r2 = r4.a3
            float r3 = r5.a3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0097
            int r2 = r4.b3
            int r3 = r5.b3
            if (r2 != r3) goto L_0x0097
            float r2 = r4.c3
            float r3 = r5.c3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0097
            float r2 = r4.d3
            float r3 = r5.d3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0097
            boolean r2 = r4.e3
            boolean r3 = r5.e3
            if (r2 != r3) goto L_0x0097
            int r2 = r4.f3
            int r3 = r5.f3
            if (r2 != r3) goto L_0x0097
            int r2 = r4.g3
            int r3 = r5.g3
            if (r2 != r3) goto L_0x0097
            float r2 = r4.h3
            float r3 = r5.h3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0097
            int r2 = r4.i3
            int r3 = r5.i3
            if (r2 != r3) goto L_0x0097
            float r2 = r4.j3
            float r5 = r5.j3
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r0 = 0
        L_0x0098:
            return r0
        L_0x0099:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.text.Cue.equals(java.lang.Object):boolean");
    }

    @UnstableApi
    public Bundle f() {
        Bundle e2 = e();
        if (this.Z != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Assertions.i(this.Z.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            e2.putByteArray(C3, byteArrayOutputStream.toByteArray());
        }
        return e2;
    }

    public int hashCode() {
        return Objects.b(this.s, this.X, this.Y, this.Z, Float.valueOf(this.X2), Integer.valueOf(this.Y2), Integer.valueOf(this.Z2), Float.valueOf(this.a3), Integer.valueOf(this.b3), Float.valueOf(this.c3), Float.valueOf(this.d3), Boolean.valueOf(this.e3), Integer.valueOf(this.f3), Integer.valueOf(this.g3), Float.valueOf(this.h3), Integer.valueOf(this.i3), Float.valueOf(this.j3));
    }
}

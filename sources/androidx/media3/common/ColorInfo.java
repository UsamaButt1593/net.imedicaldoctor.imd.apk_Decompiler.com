package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.itextpdf.text.pdf.codec.PngImage;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

@UnstableApi
public final class ColorInfo implements Bundleable {
    public static final ColorInfo a3 = new Builder().d(1).c(2).e(3).a();
    public static final ColorInfo b3 = new Builder().d(1).c(1).e(2).a();
    private static final String c3 = Util.d1(0);
    private static final String d3 = Util.d1(1);
    private static final String e3 = Util.d1(2);
    private static final String f3 = Util.d1(3);
    private static final String g3 = Util.d1(4);
    private static final String h3 = Util.d1(5);
    @Deprecated
    public static final Bundleable.Creator<ColorInfo> i3 = new C0149h();
    public final int X;
    public final int X2;
    public final int Y;
    public final int Y2;
    @Nullable
    public final byte[] Z;
    private int Z2;
    public final int s;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f9097a;

        /* renamed from: b  reason: collision with root package name */
        private int f9098b;

        /* renamed from: c  reason: collision with root package name */
        private int f9099c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private byte[] f9100d;

        /* renamed from: e  reason: collision with root package name */
        private int f9101e;

        /* renamed from: f  reason: collision with root package name */
        private int f9102f;

        public Builder() {
            this.f9097a = -1;
            this.f9098b = -1;
            this.f9099c = -1;
            this.f9101e = -1;
            this.f9102f = -1;
        }

        public ColorInfo a() {
            return new ColorInfo(this.f9097a, this.f9098b, this.f9099c, this.f9100d, this.f9101e, this.f9102f);
        }

        @CanIgnoreReturnValue
        public Builder b(int i2) {
            this.f9102f = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(int i2) {
            this.f9098b = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(int i2) {
            this.f9097a = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(int i2) {
            this.f9099c = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(@Nullable byte[] bArr) {
            this.f9100d = bArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g(int i2) {
            this.f9101e = i2;
            return this;
        }

        private Builder(ColorInfo colorInfo) {
            this.f9097a = colorInfo.s;
            this.f9098b = colorInfo.X;
            this.f9099c = colorInfo.Y;
            this.f9100d = colorInfo.Z;
            this.f9101e = colorInfo.X2;
            this.f9102f = colorInfo.Y2;
        }
    }

    private ColorInfo(int i2, int i4, int i5, @Nullable byte[] bArr, int i6, int i7) {
        this.s = i2;
        this.X = i4;
        this.Y = i5;
        this.Z = bArr;
        this.X2 = i6;
        this.Y2 = i7;
    }

    private static String c(int i2) {
        if (i2 == -1) {
            return "NA";
        }
        return i2 + "bit Chroma";
    }

    private static String d(int i2) {
        if (i2 == -1) {
            return "Unset color range";
        }
        if (i2 != 1) {
            return i2 != 2 ? "Undefined color range" : "Limited range";
        }
        return "Full range";
    }

    private static String e(int i2) {
        if (i2 == -1) {
            return "Unset color space";
        }
        if (i2 == 6) {
            return "BT2020";
        }
        if (i2 != 1) {
            return i2 != 2 ? "Undefined color space" : "BT601";
        }
        return "BT709";
    }

    private static String f(int i2) {
        if (i2 == -1) {
            return "Unset color transfer";
        }
        if (i2 == 10) {
            return "Gamma 2.2";
        }
        if (i2 == 1) {
            return "Linear";
        }
        if (i2 == 2) {
            return PngImage.U;
        }
        if (i2 == 3) {
            return "SDR SMPTE 170M";
        }
        if (i2 != 6) {
            return i2 != 7 ? "Undefined color transfer" : "HLG";
        }
        return "ST2084 PQ";
    }

    public static ColorInfo g(Bundle bundle) {
        return new ColorInfo(bundle.getInt(c3, -1), bundle.getInt(d3, -1), bundle.getInt(e3, -1), bundle.getByteArray(f3), bundle.getInt(g3, -1), bundle.getInt(h3, -1));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r1 = r4.Y;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001f, code lost:
        r1 = r4.Y2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
        r4 = r4.X2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r1 = r4.X;
     */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"#1"}, result = false)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean j(@androidx.annotation.Nullable androidx.media3.common.ColorInfo r4) {
        /*
            r0 = 1
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.s
            r2 = 2
            r3 = -1
            if (r1 == r3) goto L_0x000e
            if (r1 == r0) goto L_0x000e
            if (r1 != r2) goto L_0x002e
        L_0x000e:
            int r1 = r4.X
            if (r1 == r3) goto L_0x0014
            if (r1 != r2) goto L_0x002e
        L_0x0014:
            int r1 = r4.Y
            if (r1 == r3) goto L_0x001b
            r2 = 3
            if (r1 != r2) goto L_0x002e
        L_0x001b:
            byte[] r1 = r4.Z
            if (r1 != 0) goto L_0x002e
            int r1 = r4.Y2
            r2 = 8
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x002e
        L_0x0027:
            int r4 = r4.X2
            if (r4 == r3) goto L_0x002f
            if (r4 != r2) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.ColorInfo.j(androidx.media3.common.ColorInfo):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.Y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean k(@androidx.annotation.Nullable androidx.media3.common.ColorInfo r1) {
        /*
            if (r1 == 0) goto L_0x000c
            int r1 = r1.Y
            r0 = 7
            if (r1 == r0) goto L_0x000a
            r0 = 6
            if (r1 != r0) goto L_0x000c
        L_0x000a:
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.ColorInfo.k(androidx.media3.common.ColorInfo):boolean");
    }

    @Pure
    public static int m(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int n(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 13) {
            return 2;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String o(int i2) {
        if (i2 == -1) {
            return "NA";
        }
        return i2 + "bit Luma";
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(c3, this.s);
        bundle.putInt(d3, this.X);
        bundle.putInt(e3, this.Y);
        bundle.putByteArray(f3, this.Z);
        bundle.putInt(g3, this.X2);
        bundle.putInt(h3, this.Y2);
        return bundle;
    }

    public Builder b() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ColorInfo.class != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        return this.s == colorInfo.s && this.X == colorInfo.X && this.Y == colorInfo.Y && Arrays.equals(this.Z, colorInfo.Z) && this.X2 == colorInfo.X2 && this.Y2 == colorInfo.Y2;
    }

    public boolean h() {
        return (this.X2 == -1 || this.Y2 == -1) ? false : true;
    }

    public int hashCode() {
        if (this.Z2 == 0) {
            this.Z2 = ((((((((((MetaDo.w + this.s) * 31) + this.X) * 31) + this.Y) * 31) + Arrays.hashCode(this.Z)) * 31) + this.X2) * 31) + this.Y2;
        }
        return this.Z2;
    }

    public boolean i() {
        return (this.s == -1 || this.X == -1 || this.Y == -1) ? false : true;
    }

    public boolean l() {
        return h() || i();
    }

    public String p() {
        String str;
        String str2;
        if (i()) {
            str = Util.S("%s/%s/%s", e(this.s), d(this.X), f(this.Y));
        } else {
            str = "NA/NA/NA";
        }
        if (h()) {
            str2 = this.X2 + "/" + this.Y2;
        } else {
            str2 = "NA/NA";
        }
        return str + "/" + str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(e(this.s));
        sb.append(", ");
        sb.append(d(this.X));
        sb.append(", ");
        sb.append(f(this.Y));
        sb.append(", ");
        sb.append(this.Z != null);
        sb.append(", ");
        sb.append(o(this.X2));
        sb.append(", ");
        sb.append(c(this.Y2));
        sb.append(")");
        return sb.toString();
    }
}

package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

final class Projection {

    /* renamed from: e  reason: collision with root package name */
    public static final int f12824e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f12825f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f12826g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f12827h = 2;

    /* renamed from: i  reason: collision with root package name */
    public static final int f12828i = 3;

    /* renamed from: a  reason: collision with root package name */
    public final Mesh f12829a;

    /* renamed from: b  reason: collision with root package name */
    public final Mesh f12830b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12831c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f12832d;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static final class Mesh {

        /* renamed from: a  reason: collision with root package name */
        private final SubMesh[] f12833a;

        public Mesh(SubMesh... subMeshArr) {
            this.f12833a = subMeshArr;
        }

        public SubMesh a(int i2) {
            return this.f12833a[i2];
        }

        public int b() {
            return this.f12833a.length;
        }
    }

    public static final class SubMesh {

        /* renamed from: e  reason: collision with root package name */
        public static final int f12834e = 0;

        /* renamed from: a  reason: collision with root package name */
        public final int f12835a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12836b;

        /* renamed from: c  reason: collision with root package name */
        public final float[] f12837c;

        /* renamed from: d  reason: collision with root package name */
        public final float[] f12838d;

        public SubMesh(int i2, float[] fArr, float[] fArr2, int i3) {
            this.f12835a = i2;
            Assertions.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f12837c = fArr;
            this.f12838d = fArr2;
            this.f12836b = i3;
        }

        public int a() {
            return this.f12837c.length / 3;
        }
    }

    public Projection(Mesh mesh, int i2) {
        this(mesh, mesh, i2);
    }

    public static Projection a(float f2, int i2, int i3, float f3, float f4, int i4) {
        int i5;
        float f5;
        float f6;
        int i6;
        int i7;
        float f7 = f2;
        int i8 = i2;
        int i9 = i3;
        float f8 = f3;
        float f9 = f4;
        Assertions.a(f7 > 0.0f);
        Assertions.a(i8 >= 1);
        Assertions.a(i9 >= 1);
        Assertions.a(f8 > 0.0f && f8 <= 180.0f);
        Assertions.a(f9 > 0.0f && f9 <= 360.0f);
        float radians = (float) Math.toRadians((double) f8);
        float radians2 = (float) Math.toRadians((double) f9);
        float f10 = radians / ((float) i8);
        float f11 = radians2 / ((float) i9);
        int i10 = i9 + 1;
        int i11 = ((i10 * 2) + 2) * i8;
        float[] fArr = new float[(i11 * 3)];
        float[] fArr2 = new float[(i11 * 2)];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i8) {
            float f12 = radians / 2.0f;
            float f13 = (((float) i12) * f10) - f12;
            int i15 = i12 + 1;
            float f14 = (((float) i15) * f10) - f12;
            int i16 = 0;
            while (true) {
                i5 = i15;
                if (i16 >= i10) {
                    break;
                }
                float f15 = f13;
                int i17 = i14;
                int i18 = 0;
                while (i18 < 2) {
                    if (i18 == 0) {
                        f6 = f15;
                        f5 = f14;
                    } else {
                        f6 = f14;
                        f5 = f6;
                    }
                    float f16 = ((float) i16) * f11;
                    float f17 = f11;
                    float f18 = radians;
                    double d2 = (double) f7;
                    int i19 = i10;
                    double d3 = (double) ((f16 + 3.1415927f) - (radians2 / 2.0f));
                    int i20 = i16;
                    double d4 = (double) f6;
                    float f19 = radians2;
                    int i21 = i18;
                    fArr[i13] = -((float) (Math.sin(d3) * d2 * Math.cos(d4)));
                    float f20 = f10;
                    fArr[i13 + 1] = (float) (d2 * Math.sin(d4));
                    int i22 = i13 + 3;
                    fArr[i13 + 2] = (float) (d2 * Math.cos(d3) * Math.cos(d4));
                    fArr2[i17] = f16 / f19;
                    int i23 = i17 + 2;
                    fArr2[i17 + 1] = (((float) (i12 + i21)) * f20) / f18;
                    if (i20 == 0 && i21 == 0) {
                        int i24 = i3;
                        i6 = i21;
                        i7 = i20;
                    } else {
                        i7 = i20;
                        i6 = i21;
                        if (!(i7 == i3 && i6 == 1)) {
                            i17 = i23;
                            i13 = i22;
                            i16 = i7;
                            f10 = f20;
                            i18 = i6 + 1;
                            f14 = f5;
                            f11 = f17;
                            radians = f18;
                            i10 = i19;
                            radians2 = f19;
                        }
                    }
                    System.arraycopy(fArr, i13, fArr, i22, 3);
                    i13 += 6;
                    System.arraycopy(fArr2, i17, fArr2, i23, 2);
                    i17 += 4;
                    i16 = i7;
                    f10 = f20;
                    i18 = i6 + 1;
                    f14 = f5;
                    f11 = f17;
                    radians = f18;
                    i10 = i19;
                    radians2 = f19;
                }
                float f21 = radians2;
                float f22 = f10;
                float f23 = f11;
                int i25 = i10;
                i15 = i5;
                f13 = f15;
                i14 = i17;
                i16++;
                f14 = f14;
                radians = radians;
                radians2 = f21;
                int i26 = i2;
            }
            i8 = i2;
            i12 = i5;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr, fArr2, 1)), i4);
    }

    public static Projection b(int i2) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i2);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i2) {
        this.f12829a = mesh;
        this.f12830b = mesh2;
        this.f12831c = i2;
        this.f12832d = mesh == mesh2;
    }
}

package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

public final class PathParser {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5831a = "PathParser";

    private static class ExtractFloatResult {

        /* renamed from: a  reason: collision with root package name */
        int f5832a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5833b;

        ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public char f5834a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final float[] f5835b;

        PathDataNode(char c2, float[] fArr) {
            this.f5834a = c2;
            this.f5835b = fArr;
        }

        /* access modifiers changed from: private */
        public static void e(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i2;
            int i3;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            Path path2 = path;
            char c4 = c3;
            float[] fArr3 = fArr2;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[2];
            float f15 = fArr[3];
            float f16 = fArr[4];
            float f17 = fArr[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f16, f17);
                    f12 = f16;
                    f14 = f12;
                    f13 = f17;
                    f15 = f13;
                    break;
            }
            i2 = 2;
            float f18 = f12;
            float f19 = f13;
            float f20 = f16;
            float f21 = f17;
            int i4 = 0;
            char c5 = c2;
            while (i4 < fArr3.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i3 = i4;
                        int i5 = i3 + 2;
                        int i6 = i3 + 3;
                        int i7 = i3 + 4;
                        int i8 = i3 + 5;
                        path.cubicTo(fArr3[i3], fArr3[i3 + 1], fArr3[i5], fArr3[i6], fArr3[i7], fArr3[i8]);
                        f18 = fArr3[i7];
                        float f22 = fArr3[i8];
                        float f23 = fArr3[i5];
                        float f24 = fArr3[i6];
                        f19 = f22;
                        f15 = f24;
                        f14 = f23;
                    } else if (c4 == 'H') {
                        i3 = i4;
                        path2.lineTo(fArr3[i3], f19);
                        f18 = fArr3[i3];
                    } else if (c4 == 'Q') {
                        i3 = i4;
                        int i9 = i3 + 1;
                        int i10 = i3 + 2;
                        int i11 = i3 + 3;
                        path2.quadTo(fArr3[i3], fArr3[i9], fArr3[i10], fArr3[i11]);
                        float f25 = fArr3[i3];
                        float f26 = fArr3[i9];
                        f18 = fArr3[i10];
                        f19 = fArr3[i11];
                        f14 = f25;
                        f15 = f26;
                    } else if (c4 == 'V') {
                        i3 = i4;
                        path2.lineTo(f18, fArr3[i3]);
                        f19 = fArr3[i3];
                    } else if (c4 != 'a') {
                        if (c4 == 'c') {
                            int i12 = i4 + 2;
                            int i13 = i4 + 3;
                            int i14 = i4 + 4;
                            int i15 = i4 + 5;
                            path.rCubicTo(fArr3[i4], fArr3[i4 + 1], fArr3[i12], fArr3[i13], fArr3[i14], fArr3[i15]);
                            f4 = fArr3[i12] + f18;
                            f5 = fArr3[i13] + f19;
                            f18 += fArr3[i14];
                            f6 = fArr3[i15];
                            f19 += f6;
                            f14 = f4;
                            f15 = f5;
                        } else if (c4 != 'h') {
                            if (c4 != 'q') {
                                if (c4 == 'v') {
                                    path2.rLineTo(0.0f, fArr3[i4]);
                                    f7 = fArr3[i4];
                                } else if (c4 != 'L') {
                                    if (c4 == 'M') {
                                        f18 = fArr3[i4];
                                        f19 = fArr3[i4 + 1];
                                        if (i4 > 0) {
                                            path2.lineTo(f18, f19);
                                        } else {
                                            path2.moveTo(f18, f19);
                                        }
                                    } else if (c4 == 'S') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            f18 = (f18 * 2.0f) - f14;
                                            f19 = (f19 * 2.0f) - f15;
                                        }
                                        float f27 = f19;
                                        float f28 = f18;
                                        int i16 = i4 + 1;
                                        int i17 = i4 + 2;
                                        int i18 = i4 + 3;
                                        path.cubicTo(f28, f27, fArr3[i4], fArr3[i16], fArr3[i17], fArr3[i18]);
                                        f4 = fArr3[i4];
                                        f5 = fArr3[i16];
                                        f18 = fArr3[i17];
                                        f19 = fArr3[i18];
                                        f14 = f4;
                                        f15 = f5;
                                    } else if (c4 == 'T') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f18 = (f18 * 2.0f) - f14;
                                            f19 = (f19 * 2.0f) - f15;
                                        }
                                        int i19 = i4 + 1;
                                        path2.quadTo(f18, f19, fArr3[i4], fArr3[i19]);
                                        i3 = i4;
                                        f15 = f19;
                                        f14 = f18;
                                        f18 = fArr3[i4];
                                        f19 = fArr3[i19];
                                    } else if (c4 == 'l') {
                                        int i20 = i4 + 1;
                                        path2.rLineTo(fArr3[i4], fArr3[i20]);
                                        f18 += fArr3[i4];
                                        f7 = fArr3[i20];
                                    } else if (c4 == 'm') {
                                        float f29 = fArr3[i4];
                                        f18 += f29;
                                        float f30 = fArr3[i4 + 1];
                                        f19 += f30;
                                        if (i4 > 0) {
                                            path2.rLineTo(f29, f30);
                                        } else {
                                            path2.rMoveTo(f29, f30);
                                        }
                                    } else if (c4 == 's') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            float f31 = f18 - f14;
                                            f8 = f19 - f15;
                                            f9 = f31;
                                        } else {
                                            f9 = 0.0f;
                                            f8 = 0.0f;
                                        }
                                        int i21 = i4 + 1;
                                        int i22 = i4 + 2;
                                        int i23 = i4 + 3;
                                        path.rCubicTo(f9, f8, fArr3[i4], fArr3[i21], fArr3[i22], fArr3[i23]);
                                        f4 = fArr3[i4] + f18;
                                        f5 = fArr3[i21] + f19;
                                        f18 += fArr3[i22];
                                        f6 = fArr3[i23];
                                    } else if (c4 == 't') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f10 = f18 - f14;
                                            f11 = f19 - f15;
                                        } else {
                                            f11 = 0.0f;
                                            f10 = 0.0f;
                                        }
                                        int i24 = i4 + 1;
                                        path2.rQuadTo(f10, f11, fArr3[i4], fArr3[i24]);
                                        float f32 = f10 + f18;
                                        float f33 = f11 + f19;
                                        f18 += fArr3[i4];
                                        f19 += fArr3[i24];
                                        f15 = f33;
                                        f14 = f32;
                                    }
                                    i3 = i4;
                                    f21 = f19;
                                    f20 = f18;
                                } else {
                                    int i25 = i4 + 1;
                                    path2.lineTo(fArr3[i4], fArr3[i25]);
                                    f18 = fArr3[i4];
                                    f19 = fArr3[i25];
                                }
                                f19 += f7;
                            } else {
                                int i26 = i4 + 1;
                                int i27 = i4 + 2;
                                int i28 = i4 + 3;
                                path2.rQuadTo(fArr3[i4], fArr3[i26], fArr3[i27], fArr3[i28]);
                                f4 = fArr3[i4] + f18;
                                f5 = fArr3[i26] + f19;
                                f18 += fArr3[i27];
                                f6 = fArr3[i28];
                            }
                            f19 += f6;
                            f14 = f4;
                            f15 = f5;
                        } else {
                            path2.rLineTo(fArr3[i4], 0.0f);
                            f18 += fArr3[i4];
                        }
                        i3 = i4;
                    } else {
                        int i29 = i4 + 5;
                        int i30 = i4 + 6;
                        i3 = i4;
                        g(path, f18, f19, fArr3[i29] + f18, fArr3[i30] + f19, fArr3[i4], fArr3[i4 + 1], fArr3[i4 + 2], fArr3[i4 + 3] != 0.0f, fArr3[i4 + 4] != 0.0f);
                        f2 = f18 + fArr3[i29];
                        f3 = f19 + fArr3[i30];
                    }
                    i4 = i3 + i2;
                    c5 = c3;
                    c4 = c5;
                } else {
                    i3 = i4;
                    int i31 = i3 + 5;
                    int i32 = i3 + 6;
                    g(path, f18, f19, fArr3[i31], fArr3[i32], fArr3[i3], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                    f2 = fArr3[i31];
                    f3 = fArr3[i32];
                }
                f15 = f19;
                f14 = f18;
                i4 = i3 + i2;
                c5 = c3;
                c4 = c5;
            }
            fArr[0] = f18;
            fArr[1] = f19;
            fArr[2] = f14;
            fArr[3] = f15;
            fArr[4] = f20;
            fArr[5] = f21;
        }

        private static void f(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = d10 / ((double) ceil);
            double d20 = d9;
            double d21 = d18;
            double d22 = d15;
            int i2 = 0;
            double d23 = d6;
            double d24 = d7;
            while (i2 < ceil) {
                double d25 = d20 + d19;
                double sin3 = Math.sin(d25);
                double cos3 = Math.cos(d25);
                double d26 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d27 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d28 = (d13 * sin3) - (d14 * cos3);
                double d29 = (sin3 * d16) + (cos3 * d17);
                double d30 = d25 - d20;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d31 = d23 + (d22 * sin4);
                double d32 = cos;
                double d33 = sin;
                path.rLineTo(0.0f, 0.0f);
                float f2 = (float) (d26 - (sin4 * d28));
                float f3 = (float) (d27 - (sin4 * d29));
                path.cubicTo((float) d31, (float) (d24 + (d21 * sin4)), f2, f3, (float) d26, (float) d27);
                i2++;
                d19 = d19;
                sin = d33;
                d23 = d26;
                d16 = d16;
                cos = d32;
                d20 = d25;
                d21 = d29;
                d22 = d28;
                ceil = ceil;
                d24 = d27;
                d11 = d4;
            }
        }

        private static void g(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            float f9 = f2;
            float f10 = f4;
            float f11 = f6;
            boolean z3 = z2;
            double radians = Math.toRadians((double) f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = (double) f9;
            double d5 = d4 * cos;
            double d6 = d4;
            double d7 = (double) f3;
            double d8 = (double) f11;
            double d9 = (d5 + (d7 * sin)) / d8;
            double d10 = (((double) (-f9)) * sin) + (d7 * cos);
            double d11 = d7;
            double d12 = (double) f7;
            double d13 = d10 / d12;
            double d14 = (double) f5;
            double d15 = ((((double) f10) * cos) + (d14 * sin)) / d8;
            double d16 = d8;
            double d17 = ((((double) (-f10)) * sin) + (d14 * cos)) / d12;
            double d18 = d9 - d15;
            double d19 = d13 - d17;
            double d20 = (d9 + d15) / 2.0d;
            double d21 = (d13 + d17) / 2.0d;
            double d22 = sin;
            double d23 = (d18 * d18) + (d19 * d19);
            if (d23 == 0.0d) {
                Log.w(PathParser.f5831a, " Points are coincident");
                return;
            }
            double d24 = (1.0d / d23) - 0.25d;
            if (d24 < 0.0d) {
                Log.w(PathParser.f5831a, "Points are too far apart " + d23);
                float sqrt = (float) (Math.sqrt(d23) / 1.99999d);
                g(path, f2, f3, f4, f5, f11 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d24);
            double d25 = d18 * sqrt2;
            double d26 = sqrt2 * d19;
            boolean z4 = z2;
            if (z == z4) {
                d3 = d20 - d26;
                d2 = d21 + d25;
            } else {
                d3 = d20 + d26;
                d2 = d21 - d25;
            }
            double atan2 = Math.atan2(d13 - d2, d9 - d3);
            double atan22 = Math.atan2(d17 - d2, d15 - d3) - atan2;
            int i2 = (atan22 > 0.0d ? 1 : (atan22 == 0.0d ? 0 : -1));
            if (z4 != (i2 >= 0)) {
                atan22 = i2 > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d27 = d3 * d16;
            double d28 = d2 * d12;
            f(path, (d27 * cos) - (d28 * d22), (d27 * d22) + (d28 * cos), d16, d12, d6, d11, radians, atan2, atan22);
        }

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static void k(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.l(pathDataNodeArr, path);
        }

        @NonNull
        public float[] h() {
            return this.f5835b;
        }

        public char i() {
            return this.f5834a;
        }

        public void j(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f2) {
            this.f5834a = pathDataNode.f5834a;
            int i2 = 0;
            while (true) {
                float[] fArr = pathDataNode.f5835b;
                if (i2 < fArr.length) {
                    this.f5835b[i2] = (fArr[i2] * (1.0f - f2)) + (pathDataNode2.f5835b[i2] * f2);
                    i2++;
                } else {
                    return;
                }
            }
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.f5834a = pathDataNode.f5834a;
            float[] fArr = pathDataNode.f5835b;
            this.f5835b = PathParser.c(fArr, 0, fArr.length);
        }
    }

    private PathParser() {
    }

    private static void a(ArrayList<PathDataNode> arrayList, char c2, float[] fArr) {
        arrayList.add(new PathDataNode(c2, fArr));
    }

    public static boolean b(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            if (pathDataNodeArr[i2].f5834a != pathDataNodeArr2[i2].f5834a || pathDataNodeArr[i2].f5835b.length != pathDataNodeArr2[i2].f5835b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i2, int i3) {
        if (i2 <= i3) {
            int length = fArr.length;
            if (i2 < 0 || i2 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = i3 - i2;
            int min = Math.min(i4, length - i2);
            float[] fArr2 = new float[i4];
            System.arraycopy(fArr, i2, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static PathDataNode[] d(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int k2 = k(str, i2);
            String trim = str.substring(i3, k2).trim();
            if (!trim.isEmpty()) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i3 = k2;
            i2 = k2 + 1;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            a(arrayList, str.charAt(i3), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path e(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.k(d(str), path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing " + str, e2);
        }
    }

    @NonNull
    public static PathDataNode[] f(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            pathDataNodeArr2[i2] = new PathDataNode(pathDataNodeArr[i2]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r10.f5833b = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r2 == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[LOOP:0: B:1:0x0007->B:19:0x0037, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void g(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.f5833b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003a
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0029
            r6 = 69
            if (r5 == r6) goto L_0x0033
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0033
            switch(r5) {
                case 44: goto L_0x0029;
                case 45: goto L_0x002c;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x0031
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = 0
            r3 = 1
            goto L_0x0034
        L_0x0027:
            r10.f5833b = r7
        L_0x0029:
            r2 = 0
            r4 = 1
            goto L_0x0034
        L_0x002c:
            if (r1 == r9) goto L_0x0031
            if (r2 != 0) goto L_0x0031
            goto L_0x0027
        L_0x0031:
            r2 = 0
            goto L_0x0034
        L_0x0033:
            r2 = 1
        L_0x0034:
            if (r4 == 0) goto L_0x0037
            goto L_0x003a
        L_0x0037:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003a:
            r10.f5832a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.g(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i2 = 1;
            int i3 = 0;
            while (i2 < length) {
                g(str, i2, extractFloatResult);
                int i4 = extractFloatResult.f5832a;
                if (i2 < i4) {
                    fArr[i3] = Float.parseFloat(str.substring(i2, i4));
                    i3++;
                }
                i2 = extractFloatResult.f5833b ? i4 : i4 + 1;
            }
            return c(fArr, 0, i3);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }

    public static void i(@NonNull PathDataNode[] pathDataNodeArr, float f2, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (!j(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f2)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static boolean j(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f2) {
        if (pathDataNodeArr.length == pathDataNodeArr2.length && pathDataNodeArr2.length == pathDataNodeArr3.length) {
            if (!b(pathDataNodeArr2, pathDataNodeArr3)) {
                return false;
            }
            for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                pathDataNodeArr[i2].j(pathDataNodeArr2[i2], pathDataNodeArr3[i2], f2);
            }
            return true;
        }
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }

    private static int k(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public static void l(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c2 = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.e(path, fArr, c2, pathDataNode.f5834a, pathDataNode.f5835b);
            c2 = pathDataNode.f5834a;
        }
    }

    public static void m(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i2 = 0; i2 < pathDataNodeArr2.length; i2++) {
            char unused = pathDataNodeArr[i2].f5834a = pathDataNodeArr2[i2].f5834a;
            for (int i3 = 0; i3 < pathDataNodeArr2[i2].f5835b.length; i3++) {
                pathDataNodeArr[i2].f5835b[i3] = pathDataNodeArr2[i2].f5835b[i3];
            }
        }
    }
}

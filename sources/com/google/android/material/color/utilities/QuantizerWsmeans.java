package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWsmeans {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21224a = 10;

    /* renamed from: b  reason: collision with root package name */
    private static final double f21225b = 3.0d;

    private static final class Distance implements Comparable<Distance> {
        double X = -1.0d;
        int s = -1;

        Distance() {
        }

        /* renamed from: a */
        public int compareTo(Distance distance) {
            return Double.valueOf(this.X).compareTo(Double.valueOf(distance.X));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> a(int[] iArr, int[] iArr2, int i2) {
        int[] iArr3;
        int i3;
        int i4;
        Integer valueOf;
        int valueOf2;
        int[] iArr4 = iArr;
        int[] iArr5 = iArr2;
        int i5 = 1;
        Random random = new Random(272008);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr = new double[iArr4.length][];
        int[] iArr6 = new int[iArr4.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i6 = 0;
        for (int i7 : iArr4) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i7));
            if (num == null) {
                dArr[i6] = pointProviderLab.c(i7);
                iArr6[i6] = i7;
                i6++;
                valueOf = Integer.valueOf(i7);
                valueOf2 = 1;
            } else {
                valueOf = Integer.valueOf(i7);
                valueOf2 = Integer.valueOf(num.intValue() + 1);
            }
            linkedHashMap.put(valueOf, valueOf2);
        }
        int[] iArr7 = new int[i6];
        for (int i8 = 0; i8 < i6; i8++) {
            iArr7[i8] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr6[i8]))).intValue();
        }
        int min = Math.min(i2, i6);
        if (iArr5.length != 0) {
            min = Math.min(min, iArr5.length);
        }
        double[][] dArr2 = new double[min][];
        int i9 = 0;
        for (int i10 = 0; i10 < iArr5.length; i10++) {
            dArr2[i10] = pointProviderLab.c(iArr5[i10]);
            i9++;
        }
        int i11 = min - i9;
        if (i11 > 0) {
            for (int i12 = 0; i12 < i11; i12++) {
            }
        }
        int[] iArr8 = new int[i6];
        for (int i13 = 0; i13 < i6; i13++) {
            iArr8[i13] = random.nextInt(min);
        }
        int[][] iArr9 = new int[min][];
        for (int i14 = 0; i14 < min; i14++) {
            iArr9[i14] = new int[min];
        }
        Distance[][] distanceArr = new Distance[min][];
        for (int i15 = 0; i15 < min; i15++) {
            distanceArr[i15] = new Distance[min];
            for (int i16 = 0; i16 < min; i16++) {
                distanceArr[i15][i16] = new Distance();
            }
        }
        int[] iArr10 = new int[min];
        int i17 = 0;
        while (true) {
            if (i17 >= 10) {
                iArr3 = iArr10;
                break;
            }
            int i18 = 0;
            while (i18 < min) {
                int i19 = i18 + 1;
                int i20 = i19;
                while (i20 < min) {
                    int[] iArr11 = iArr10;
                    double a2 = pointProviderLab.a(dArr2[i18], dArr2[i20]);
                    Distance distance = distanceArr[i20][i18];
                    distance.X = a2;
                    distance.s = i18;
                    Distance distance2 = distanceArr[i18][i20];
                    distance2.X = a2;
                    distance2.s = i20;
                    i5 = 1;
                    i20++;
                    iArr10 = iArr11;
                    i17 = i17;
                }
                int[] iArr12 = iArr10;
                int i21 = i17;
                Arrays.sort(distanceArr[i18]);
                for (int i22 = 0; i22 < min; i22 += i5) {
                    iArr9[i18][i22] = distanceArr[i18][i22].s;
                }
                iArr10 = iArr12;
                i17 = i21;
                i18 = i19;
            }
            int[] iArr13 = iArr10;
            int i23 = i17;
            int i24 = 0;
            int i25 = 0;
            while (i24 < i6) {
                double[] dArr3 = dArr[i24];
                int i26 = iArr8[i24];
                double a3 = pointProviderLab.a(dArr3, dArr2[i26]);
                int[][] iArr14 = iArr9;
                double d2 = a3;
                int i27 = -1;
                int i28 = 0;
                while (i28 < min) {
                    Distance[][] distanceArr2 = distanceArr;
                    int i29 = i6;
                    if (distanceArr[i26][i28].X < 4.0d * a3) {
                        double a4 = pointProviderLab.a(dArr3, dArr2[i28]);
                        if (a4 < d2) {
                            d2 = a4;
                            i27 = i28;
                        }
                    }
                    i28++;
                    i6 = i29;
                    distanceArr = distanceArr2;
                }
                Distance[][] distanceArr3 = distanceArr;
                int i30 = i6;
                if (i27 != -1 && Math.abs(Math.sqrt(d2) - Math.sqrt(a3)) > 3.0d) {
                    i25++;
                    iArr8[i24] = i27;
                }
                i24++;
                iArr9 = iArr14;
                i6 = i30;
                distanceArr = distanceArr3;
            }
            int[][] iArr15 = iArr9;
            Distance[][] distanceArr4 = distanceArr;
            int i31 = i6;
            if (i25 == 0 && i23 != 0) {
                iArr3 = iArr13;
                break;
            }
            double[] dArr4 = new double[min];
            double[] dArr5 = new double[min];
            double[] dArr6 = new double[min];
            int[] iArr16 = iArr13;
            char c2 = 0;
            Arrays.fill(iArr16, 0);
            int i32 = 0;
            while (true) {
                i3 = i31;
                if (i32 >= i3) {
                    break;
                }
                int i33 = iArr8[i32];
                double[] dArr7 = dArr[i32];
                int i34 = iArr7[i32];
                iArr16[i33] = iArr16[i33] + i34;
                double d3 = dArr4[i33];
                double d4 = dArr7[c2];
                int[] iArr17 = iArr7;
                double d5 = (double) i34;
                dArr4[i33] = d3 + (d4 * d5);
                dArr5[i33] = dArr5[i33] + (dArr7[1] * d5);
                dArr6[i33] = dArr6[i33] + (dArr7[2] * d5);
                i32++;
                iArr7 = iArr17;
                iArr8 = iArr8;
                c2 = 0;
                i31 = i3;
            }
            int[] iArr18 = iArr7;
            int[] iArr19 = iArr8;
            int i35 = 0;
            while (i35 < min) {
                int i36 = iArr16[i35];
                if (i36 == 0) {
                    dArr2[i35] = new double[]{0.0d, 0.0d, 0.0d};
                    i4 = 1;
                } else {
                    double d6 = (double) i36;
                    double[] dArr8 = dArr2[i35];
                    dArr8[0] = dArr4[i35] / d6;
                    i4 = 1;
                    dArr8[1] = dArr5[i35] / d6;
                    dArr8[2] = dArr6[i35] / d6;
                }
                i35 += i4;
            }
            i17 = i23 + 1;
            iArr7 = iArr18;
            iArr10 = iArr16;
            i6 = i3;
            iArr9 = iArr15;
            iArr8 = iArr19;
            distanceArr = distanceArr4;
            i5 = 1;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i37 = 0; i37 < min; i37++) {
            int i38 = iArr3[i37];
            if (i38 != 0) {
                int b2 = pointProviderLab.b(dArr2[i37]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(b2))) {
                    linkedHashMap2.put(Integer.valueOf(b2), Integer.valueOf(i38));
                }
            }
        }
        return linkedHashMap2;
    }
}

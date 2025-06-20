package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class StepCurve extends Easing {
    private static final boolean q = false;
    MonotonicCurveFit p;

    StepCurve(String str) {
        this.f3770a = str;
        double[] dArr = new double[(str.length() / 2)];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i2 = 0;
        while (indexOf2 != -1) {
            dArr[i2] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i2++;
        }
        dArr[i2] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        this.p = e(Arrays.copyOf(dArr, i2 + 1));
    }

    private static MonotonicCurveFit d(String str) {
        String[] split = str.split("\\s+");
        int length = split.length;
        double[] dArr = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr[i2] = Double.parseDouble(split[i2]);
        }
        return e(dArr);
    }

    private static MonotonicCurveFit e(double[] dArr) {
        double[] dArr2 = dArr;
        int length = (dArr2.length * 3) - 2;
        int length2 = dArr2.length - 1;
        double d2 = 1.0d / ((double) length2);
        int[] iArr = new int[2];
        iArr[1] = 1;
        iArr[0] = length;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, iArr);
        double[] dArr4 = new double[length];
        for (int i2 = 0; i2 < dArr2.length; i2++) {
            double d3 = dArr2[i2];
            int i3 = i2 + length2;
            dArr3[i3][0] = d3;
            double d4 = ((double) i2) * d2;
            dArr4[i3] = d4;
            if (i2 > 0) {
                int i4 = (length2 * 2) + i2;
                dArr3[i4][0] = d3 + 1.0d;
                dArr4[i4] = d4 + 1.0d;
                int i5 = i2 - 1;
                dArr3[i5][0] = (d3 - 1.0d) - d2;
                dArr4[i5] = (d4 - 4.0d) - d2;
            }
        }
        MonotonicCurveFit monotonicCurveFit = new MonotonicCurveFit(dArr4, dArr3);
        PrintStream printStream = System.out;
        printStream.println(" 0 " + monotonicCurveFit.c(0.0d, 0));
        printStream.println(" 1 " + monotonicCurveFit.c(1.0d, 0));
        return monotonicCurveFit;
    }

    public double a(double d2) {
        return this.p.c(d2, 0);
    }

    public double b(double d2) {
        return this.p.f(d2, 0);
    }
}

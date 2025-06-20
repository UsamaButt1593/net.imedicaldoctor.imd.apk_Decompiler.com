package com.itextpdf.text.pdf.codec;

import java.io.Serializable;
import kotlin.jvm.internal.CharCompanionObject;

public class TIFFField implements Comparable<TIFFField>, Serializable {
    private static final long X2 = 9088332901412823834L;
    public static final int Y2 = 1;
    public static final int Z2 = 2;
    public static final int a3 = 3;
    public static final int b3 = 4;
    public static final int c3 = 5;
    public static final int d3 = 6;
    public static final int e3 = 7;
    public static final int f3 = 8;
    public static final int g3 = 9;
    public static final int h3 = 10;
    public static final int i3 = 11;
    public static final int j3 = 12;
    int X;
    int Y;
    Object Z;
    int s;

    TIFFField() {
    }

    /* renamed from: a */
    public int compareTo(TIFFField tIFFField) {
        if (tIFFField != null) {
            int u = tIFFField.u();
            int i2 = this.s;
            if (i2 < u) {
                return -1;
            }
            return i2 > u ? 1 : 0;
        }
        throw new IllegalArgumentException();
    }

    public byte[] b() {
        return (byte[]) this.Z;
    }

    public char[] c() {
        return (char[]) this.Z;
    }

    public double e(int i2) {
        double d2;
        double d4;
        switch (this.X) {
            case 1:
                return (double) (((byte[]) this.Z)[i2] & 255);
            case 3:
                return (double) (((char[]) this.Z)[i2] & CharCompanionObject.f28914c);
            case 4:
                return (double) ((long[]) this.Z)[i2];
            case 5:
                long[] m2 = m(i2);
                d2 = (double) m2[0];
                d4 = (double) m2[1];
                break;
            case 6:
                return (double) ((byte[]) this.Z)[i2];
            case 8:
                return (double) ((short[]) this.Z)[i2];
            case 9:
                return (double) ((int[]) this.Z)[i2];
            case 10:
                int[] o = o(i2);
                d2 = (double) o[0];
                d4 = (double) o[1];
                break;
            case 11:
                return (double) ((float[]) this.Z)[i2];
            case 12:
                return ((double[]) this.Z)[i2];
            default:
                throw new ClassCastException();
        }
        return d2 / d4;
    }

    public double[] f() {
        return (double[]) this.Z;
    }

    public float g(int i2) {
        switch (this.X) {
            case 1:
                return (float) (((byte[]) this.Z)[i2] & 255);
            case 3:
                return (float) (((char[]) this.Z)[i2] & CharCompanionObject.f28914c);
            case 4:
                return (float) ((long[]) this.Z)[i2];
            case 5:
                long[] m2 = m(i2);
                return (float) (((double) m2[0]) / ((double) m2[1]));
            case 6:
                return (float) ((byte[]) this.Z)[i2];
            case 8:
                return (float) ((short[]) this.Z)[i2];
            case 9:
                return (float) ((int[]) this.Z)[i2];
            case 10:
                int[] o = o(i2);
                return (float) (((double) o[0]) / ((double) o[1]));
            case 11:
                return ((float[]) this.Z)[i2];
            case 12:
                return (float) ((double[]) this.Z)[i2];
            default:
                throw new ClassCastException();
        }
    }

    public float[] h() {
        return (float[]) this.Z;
    }

    public int i(int i2) {
        int i4 = this.X;
        if (i4 != 1) {
            if (i4 == 3) {
                return ((char[]) this.Z)[i2] & CharCompanionObject.f28914c;
            }
            switch (i4) {
                case 6:
                    return ((byte[]) this.Z)[i2];
                case 7:
                    break;
                case 8:
                    return ((short[]) this.Z)[i2];
                case 9:
                    return ((int[]) this.Z)[i2];
                default:
                    throw new ClassCastException();
            }
        }
        return ((byte[]) this.Z)[i2] & 255;
    }

    public int[] j() {
        return (int[]) this.Z;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [byte, short], vars: [r4v2 ?, r4v7 ?, r4v4 ?, r4v5 ?, r4v6 ?, r4v8 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public long k(int r4) {
        /*
            r3 = this;
            int r0 = r3.X
            switch(r0) {
                case 1: goto L_0x0033;
                case 2: goto L_0x0005;
                case 3: goto L_0x0028;
                case 4: goto L_0x0021;
                case 5: goto L_0x0005;
                case 6: goto L_0x001a;
                case 7: goto L_0x0033;
                case 8: goto L_0x0013;
                case 9: goto L_0x000b;
                default: goto L_0x0005;
            }
        L_0x0005:
            java.lang.ClassCastException r4 = new java.lang.ClassCastException
            r4.<init>()
            throw r4
        L_0x000b:
            java.lang.Object r0 = r3.Z
            int[] r0 = (int[]) r0
            r4 = r0[r4]
        L_0x0011:
            long r0 = (long) r4
            return r0
        L_0x0013:
            java.lang.Object r0 = r3.Z
            short[] r0 = (short[]) r0
            short r4 = r0[r4]
            goto L_0x0011
        L_0x001a:
            java.lang.Object r0 = r3.Z
            byte[] r0 = (byte[]) r0
            byte r4 = r0[r4]
            goto L_0x0011
        L_0x0021:
            java.lang.Object r0 = r3.Z
            long[] r0 = (long[]) r0
            r1 = r0[r4]
            return r1
        L_0x0028:
            java.lang.Object r0 = r3.Z
            char[] r0 = (char[]) r0
            char r4 = r0[r4]
            r0 = 65535(0xffff, float:9.1834E-41)
            r4 = r4 & r0
            goto L_0x0011
        L_0x0033:
            java.lang.Object r0 = r3.Z
            byte[] r0 = (byte[]) r0
            byte r4 = r0[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFField.k(int):long");
    }

    public long[] l() {
        return (long[]) this.Z;
    }

    public long[] m(int i2) {
        return this.X == 4 ? l() : ((long[][]) this.Z)[i2];
    }

    public long[][] n() {
        return (long[][]) this.Z;
    }

    public int[] o(int i2) {
        return ((int[][]) this.Z)[i2];
    }

    public int[][] p() {
        return (int[][]) this.Z;
    }

    public short[] q() {
        return (short[]) this.Z;
    }

    public String r(int i2) {
        return ((String[]) this.Z)[i2];
    }

    public int s() {
        return this.Y;
    }

    public int u() {
        return this.s;
    }

    public int v() {
        return this.X;
    }

    public TIFFField(int i2, int i4, int i5, Object obj) {
        this.s = i2;
        this.X = i4;
        this.Y = i5;
        this.Z = obj;
    }
}

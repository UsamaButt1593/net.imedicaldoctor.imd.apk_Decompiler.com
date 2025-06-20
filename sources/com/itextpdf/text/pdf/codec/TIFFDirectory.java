package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.EOFException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class TIFFDirectory implements Serializable {
    private static final long Z2 = -168636766193675380L;
    private static final int[] a3 = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    int X;
    long X2 = 8;
    TIFFField[] Y;
    long Y2 = 0;
    Hashtable<Integer, Integer> Z = new Hashtable<>();
    boolean s;

    TIFFDirectory() {
    }

    private int A(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        return this.s ? randomAccessFileOrArray.readUnsignedShort() : randomAccessFileOrArray.q();
    }

    private static int B(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) throws IOException {
        return z ? randomAccessFileOrArray.readUnsignedShort() : randomAccessFileOrArray.q();
    }

    public static int m(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        long d2 = randomAccessFileOrArray.d();
        randomAccessFileOrArray.r(0);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        int i2 = 0;
        if (s(readUnsignedShort)) {
            boolean z = readUnsignedShort == 19789;
            if (B(randomAccessFileOrArray, z) == 42) {
                randomAccessFileOrArray.r(4);
                long z2 = z(randomAccessFileOrArray, z);
                while (z2 != 0) {
                    int i3 = i2 + 1;
                    try {
                        randomAccessFileOrArray.r(z2);
                        randomAccessFileOrArray.skip((long) (B(randomAccessFileOrArray, z) * 12));
                        z2 = z(randomAccessFileOrArray, z);
                        i2 = i3;
                    } catch (EOFException unused) {
                    }
                }
                randomAccessFileOrArray.r(d2);
                return i2;
            }
            throw new IllegalArgumentException(MessageLocalization.b("bad.magic.number.should.be.42", new Object[0]));
        }
        throw new IllegalArgumentException(MessageLocalization.b("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [char[], short[]], vars: [r10v9 ?, r10v8 ?, r10v11 ?, r10v12 ?, r10v13 ?, r10v16 ?, r10v17 ?, r10v18 ?, r10v21 ?, r10v22 ?, r10v23 ?, r10v24 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    private void p(com.itextpdf.text.pdf.RandomAccessFileOrArray r20) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            long r2 = r20.e()
            long r4 = r20.d()
            r0.X2 = r4
            int r4 = r19.A(r20)
            r0.X = r4
            com.itextpdf.text.pdf.codec.TIFFField[] r4 = new com.itextpdf.text.pdf.codec.TIFFField[r4]
            r0.Y = r4
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x001c:
            int r10 = r0.X
            if (r7 >= r10) goto L_0x014f
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x014f
            int r8 = r19.A(r20)
            int r9 = r19.A(r20)
            long r10 = r19.y(r20)
            int r11 = (int) r10
            long r12 = r20.d()
            r14 = 4
            long r12 = r12 + r14
            int[] r10 = a3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0146 }
            r10 = r10[r9]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0146 }
            int r10 = r10 * r11
            r14 = 4
            if (r10 <= r14) goto L_0x004c
            long r14 = r19.y(r20)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0146 }
            int r10 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x0146
            r1.r(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0146 }
        L_0x004c:
            java.util.Hashtable<java.lang.Integer, java.lang.Integer> r10 = r0.Z
            java.lang.Integer r14 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r7)
            r10.put(r14, r15)
            r10 = 2
            r14 = 1
            switch(r9) {
                case 1: goto L_0x00fe;
                case 2: goto L_0x00fe;
                case 3: goto L_0x00ef;
                case 4: goto L_0x00e1;
                case 5: goto L_0x00bd;
                case 6: goto L_0x00fe;
                case 7: goto L_0x00fe;
                case 8: goto L_0x00af;
                case 9: goto L_0x00a1;
                case 10: goto L_0x007d;
                case 11: goto L_0x006f;
                case 12: goto L_0x0061;
                default: goto L_0x005e;
            }
        L_0x005e:
            r10 = 0
            goto L_0x013d
        L_0x0061:
            double[] r10 = new double[r11]
            r14 = 0
        L_0x0064:
            if (r14 >= r11) goto L_0x013d
            double r15 = r19.t(r20)
            r10[r14] = r15
            int r14 = r14 + 1
            goto L_0x0064
        L_0x006f:
            float[] r10 = new float[r11]
            r14 = 0
        L_0x0072:
            if (r14 >= r11) goto L_0x013d
            float r15 = r19.u(r20)
            r10[r14] = r15
            int r14 = r14 + 1
            goto L_0x0072
        L_0x007d:
            int[] r15 = new int[r10]
            r15[r14] = r10
            r15[r6] = r11
            java.lang.Class r10 = java.lang.Integer.TYPE
            java.lang.Object r10 = java.lang.reflect.Array.newInstance(r10, r15)
            int[][] r10 = (int[][]) r10
            r15 = 0
        L_0x008c:
            if (r15 >= r11) goto L_0x013d
            r16 = r10[r15]
            int r17 = r19.v(r20)
            r16[r6] = r17
            r16 = r10[r15]
            int r17 = r19.v(r20)
            r16[r14] = r17
            int r15 = r15 + 1
            goto L_0x008c
        L_0x00a1:
            int[] r10 = new int[r11]
            r14 = 0
        L_0x00a4:
            if (r14 >= r11) goto L_0x013d
            int r15 = r19.v(r20)
            r10[r14] = r15
            int r14 = r14 + 1
            goto L_0x00a4
        L_0x00af:
            short[] r10 = new short[r11]
            r14 = 0
        L_0x00b2:
            if (r14 >= r11) goto L_0x013d
            short r15 = r19.x(r20)
            r10[r14] = r15
            int r14 = r14 + 1
            goto L_0x00b2
        L_0x00bd:
            int[] r15 = new int[r10]
            r15[r14] = r10
            r15[r6] = r11
            java.lang.Class r10 = java.lang.Long.TYPE
            java.lang.Object r10 = java.lang.reflect.Array.newInstance(r10, r15)
            long[][] r10 = (long[][]) r10
            r15 = 0
        L_0x00cc:
            if (r15 >= r11) goto L_0x013d
            r16 = r10[r15]
            long r17 = r19.y(r20)
            r16[r6] = r17
            r16 = r10[r15]
            long r17 = r19.y(r20)
            r16[r14] = r17
            int r15 = r15 + 1
            goto L_0x00cc
        L_0x00e1:
            long[] r10 = new long[r11]
            r14 = 0
        L_0x00e4:
            if (r14 >= r11) goto L_0x013d
            long r15 = r19.y(r20)
            r10[r14] = r15
            int r14 = r14 + 1
            goto L_0x00e4
        L_0x00ef:
            char[] r10 = new char[r11]
            r14 = 0
        L_0x00f2:
            if (r14 >= r11) goto L_0x013d
            int r15 = r19.A(r20)
            char r15 = (char) r15
            r10[r14] = r15
            int r14 = r14 + 1
            goto L_0x00f2
        L_0x00fe:
            byte[] r14 = new byte[r11]
            r1.readFully(r14, r6, r11)
            if (r9 != r10) goto L_0x013c
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r15 = 0
        L_0x010b:
            if (r15 >= r11) goto L_0x0126
        L_0x010d:
            if (r15 >= r11) goto L_0x011a
            int r17 = r15 + 1
            byte r15 = r14[r15]
            if (r15 == 0) goto L_0x0118
            r15 = r17
            goto L_0x010d
        L_0x0118:
            r15 = r17
        L_0x011a:
            java.lang.String r4 = new java.lang.String
            int r5 = r15 - r6
            r4.<init>(r14, r6, r5)
            r10.add(r4)
            r6 = r15
            goto L_0x010b
        L_0x0126:
            int r11 = r10.size()
            java.lang.String[] r4 = new java.lang.String[r11]
            r5 = 0
        L_0x012d:
            if (r5 >= r11) goto L_0x013a
            java.lang.Object r6 = r10.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x012d
        L_0x013a:
            r10 = r4
            goto L_0x013d
        L_0x013c:
            r10 = r14
        L_0x013d:
            com.itextpdf.text.pdf.codec.TIFFField[] r4 = r0.Y
            com.itextpdf.text.pdf.codec.TIFFField r5 = new com.itextpdf.text.pdf.codec.TIFFField
            r5.<init>(r8, r9, r11, r10)
            r4[r7] = r5
        L_0x0146:
            r1.r(r12)
            int r7 = r7 + 1
            r8 = r12
            r6 = 0
            goto L_0x001c
        L_0x014f:
            long r1 = r19.y(r20)     // Catch:{ Exception -> 0x0156 }
            r0.Y2 = r1     // Catch:{ Exception -> 0x0156 }
            goto L_0x015a
        L_0x0156:
            r1 = 0
            r0.Y2 = r1
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.TIFFDirectory.p(com.itextpdf.text.pdf.RandomAccessFileOrArray):void");
    }

    private static boolean s(int i2) {
        return i2 == 18761 || i2 == 19789;
    }

    private double t(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        return this.s ? randomAccessFileOrArray.readDouble() : randomAccessFileOrArray.i();
    }

    private float u(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        return this.s ? randomAccessFileOrArray.readFloat() : randomAccessFileOrArray.j();
    }

    private int v(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        return this.s ? randomAccessFileOrArray.readInt() : randomAccessFileOrArray.k();
    }

    private long w(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        return this.s ? randomAccessFileOrArray.readLong() : randomAccessFileOrArray.l();
    }

    private short x(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        return this.s ? randomAccessFileOrArray.readShort() : randomAccessFileOrArray.m();
    }

    private long y(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        return this.s ? randomAccessFileOrArray.o() : randomAccessFileOrArray.p();
    }

    private static long z(RandomAccessFileOrArray randomAccessFileOrArray, boolean z) throws IOException {
        return z ? randomAccessFileOrArray.o() : randomAccessFileOrArray.p();
    }

    public TIFFField a(int i2) {
        Integer num = this.Z.get(Integer.valueOf(i2));
        if (num == null) {
            return null;
        }
        return this.Y[num.intValue()];
    }

    public byte b(int i2) {
        return c(i2, 0);
    }

    public byte c(int i2, int i3) {
        return this.Y[this.Z.get(Integer.valueOf(i2)).intValue()].b()[i3];
    }

    public double d(int i2) {
        return e(i2, 0);
    }

    public double e(int i2, int i3) {
        return this.Y[this.Z.get(Integer.valueOf(i2)).intValue()].e(i3);
    }

    public float f(int i2) {
        return g(i2, 0);
    }

    public float g(int i2, int i3) {
        return this.Y[this.Z.get(Integer.valueOf(i2)).intValue()].g(i3);
    }

    public long h(int i2) {
        return i(i2, 0);
    }

    public long i(int i2, int i3) {
        return this.Y[this.Z.get(Integer.valueOf(i2)).intValue()].k(i3);
    }

    public TIFFField[] j() {
        return this.Y;
    }

    public long k() {
        return this.X2;
    }

    public long l() {
        return this.Y2;
    }

    public int n() {
        return this.X;
    }

    public int[] o() {
        int[] iArr = new int[this.Z.size()];
        Enumeration<Integer> keys = this.Z.keys();
        int i2 = 0;
        while (keys.hasMoreElements()) {
            iArr[i2] = keys.nextElement().intValue();
            i2++;
        }
        return iArr;
    }

    public boolean q() {
        return this.s;
    }

    public boolean r(int i2) {
        return this.Z.containsKey(Integer.valueOf(i2));
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, int i2) throws IOException {
        long d2 = randomAccessFileOrArray.d();
        randomAccessFileOrArray.r(0);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (s(readUnsignedShort)) {
            this.s = readUnsignedShort == 19789;
            if (A(randomAccessFileOrArray) == 42) {
                long y = y(randomAccessFileOrArray);
                int i3 = 0;
                while (i3 < i2) {
                    if (y != 0) {
                        randomAccessFileOrArray.r(y);
                        randomAccessFileOrArray.skip((long) (A(randomAccessFileOrArray) * 12));
                        y = y(randomAccessFileOrArray);
                        i3++;
                    } else {
                        throw new IllegalArgumentException(MessageLocalization.b("directory.number.too.large", new Object[0]));
                    }
                }
                randomAccessFileOrArray.r(y);
                p(randomAccessFileOrArray);
                randomAccessFileOrArray.r(d2);
                return;
            }
            throw new IllegalArgumentException(MessageLocalization.b("bad.magic.number.should.be.42", new Object[0]));
        }
        throw new IllegalArgumentException(MessageLocalization.b("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }

    public TIFFDirectory(RandomAccessFileOrArray randomAccessFileOrArray, long j2, int i2) throws IOException {
        long d2 = randomAccessFileOrArray.d();
        randomAccessFileOrArray.r(0);
        int readUnsignedShort = randomAccessFileOrArray.readUnsignedShort();
        if (s(readUnsignedShort)) {
            this.s = readUnsignedShort == 19789;
            randomAccessFileOrArray.r(j2);
            for (int i3 = 0; i3 < i2; i3++) {
                randomAccessFileOrArray.r(j2 + ((long) (A(randomAccessFileOrArray) * 12)));
                j2 = y(randomAccessFileOrArray);
                randomAccessFileOrArray.r(j2);
            }
            p(randomAccessFileOrArray);
            randomAccessFileOrArray.r(d2);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("bad.endianness.tag.not.0x4949.or.0x4d4d", new Object[0]));
    }
}

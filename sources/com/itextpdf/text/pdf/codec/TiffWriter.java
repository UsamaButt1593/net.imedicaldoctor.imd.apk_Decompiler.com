package com.itextpdf.text.pdf.codec;

import java.io.IOException;
import java.io.OutputStream;
import java.util.TreeMap;

public class TiffWriter {

    /* renamed from: a  reason: collision with root package name */
    private TreeMap<Integer, FieldBase> f26704a = new TreeMap<>();

    public static class FieldAscii extends FieldBase {
        public FieldAscii(int i2, String str) {
            super(i2, 2, str.getBytes().length + 1);
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[(bytes.length + 1)];
            this.f26708d = bArr;
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        }
    }

    public static abstract class FieldBase {

        /* renamed from: a  reason: collision with root package name */
        private int f26705a;

        /* renamed from: b  reason: collision with root package name */
        private int f26706b;

        /* renamed from: c  reason: collision with root package name */
        private int f26707c;

        /* renamed from: d  reason: collision with root package name */
        protected byte[] f26708d;

        /* renamed from: e  reason: collision with root package name */
        private int f26709e;

        protected FieldBase(int i2, int i3, int i4) {
            this.f26705a = i2;
            this.f26706b = i3;
            this.f26707c = i4;
        }

        public int a() {
            return this.f26705a;
        }

        public int b() {
            return (this.f26708d.length + 1) & -2;
        }

        public void c(int i2) {
            this.f26709e = i2;
        }

        public void d(OutputStream outputStream) throws IOException {
            TiffWriter.f(this.f26705a, outputStream);
            TiffWriter.f(this.f26706b, outputStream);
            TiffWriter.e(this.f26707c, outputStream);
            byte[] bArr = this.f26708d;
            if (bArr.length <= 4) {
                outputStream.write(bArr);
                for (int length = this.f26708d.length; length < 4; length++) {
                    outputStream.write(0);
                }
                return;
            }
            TiffWriter.e(this.f26709e, outputStream);
        }

        public void e(OutputStream outputStream) throws IOException {
            byte[] bArr = this.f26708d;
            if (bArr.length > 4) {
                outputStream.write(bArr);
                if ((this.f26708d.length & 1) == 1) {
                    outputStream.write(0);
                }
            }
        }
    }

    public static class FieldByte extends FieldBase {
        public FieldByte(int i2, byte[] bArr) {
            super(i2, 1, bArr.length);
            this.f26708d = bArr;
        }
    }

    public static class FieldImage extends FieldBase {
        public FieldImage(byte[] bArr) {
            super(TIFFConstants.h0, 4, 1);
            this.f26708d = bArr;
        }
    }

    public static class FieldLong extends FieldBase {
        public FieldLong(int i2, int i3) {
            super(i2, 4, 1);
            byte[] bArr = new byte[4];
            this.f26708d = bArr;
            bArr[0] = (byte) (i3 >> 24);
            bArr[1] = (byte) (i3 >> 16);
            bArr[2] = (byte) (i3 >> 8);
            bArr[3] = (byte) i3;
        }

        public FieldLong(int i2, int[] iArr) {
            super(i2, 4, iArr.length);
            this.f26708d = new byte[(iArr.length * 4)];
            int i3 = 0;
            for (int i4 : iArr) {
                byte[] bArr = this.f26708d;
                bArr[i3] = (byte) (i4 >> 24);
                bArr[i3 + 1] = (byte) (i4 >> 16);
                int i5 = i3 + 3;
                bArr[i3 + 2] = (byte) (i4 >> 8);
                i3 += 4;
                bArr[i5] = (byte) i4;
            }
        }
    }

    public static class FieldRational extends FieldBase {
        public FieldRational(int i2, int[] iArr) {
            this(i2, new int[][]{iArr});
        }

        public FieldRational(int i2, int[][] iArr) {
            super(i2, 5, iArr.length);
            this.f26708d = new byte[(iArr.length * 8)];
            int i3 = 0;
            for (int[] iArr2 : iArr) {
                byte[] bArr = this.f26708d;
                int i4 = iArr2[0];
                bArr[i3] = (byte) (i4 >> 24);
                bArr[i3 + 1] = (byte) (i4 >> 16);
                bArr[i3 + 2] = (byte) (i4 >> 8);
                bArr[i3 + 3] = (byte) i4;
                int i5 = iArr2[1];
                bArr[i3 + 4] = (byte) (i5 >> 24);
                bArr[i3 + 5] = (byte) (i5 >> 16);
                int i6 = i3 + 7;
                bArr[i3 + 6] = (byte) (i5 >> 8);
                i3 += 8;
                bArr[i6] = (byte) i5;
            }
        }
    }

    public static class FieldShort extends FieldBase {
        public FieldShort(int i2, int i3) {
            super(i2, 3, 1);
            byte[] bArr = new byte[2];
            this.f26708d = bArr;
            bArr[0] = (byte) (i3 >> 8);
            bArr[1] = (byte) i3;
        }

        public FieldShort(int i2, int[] iArr) {
            super(i2, 3, iArr.length);
            this.f26708d = new byte[(iArr.length * 2)];
            int i3 = 0;
            for (int i4 : iArr) {
                byte[] bArr = this.f26708d;
                int i5 = i3 + 1;
                bArr[i3] = (byte) (i4 >> 8);
                i3 += 2;
                bArr[i5] = (byte) i4;
            }
        }
    }

    public static class FieldUndefined extends FieldBase {
        public FieldUndefined(int i2, byte[] bArr) {
            super(i2, 7, bArr.length);
            this.f26708d = bArr;
        }
    }

    public static void b(OutputStream outputStream, int i2, byte[] bArr, int i3, int i4, int i5) throws IOException {
        boolean z = true;
        LZWCompressor lZWCompressor = new LZWCompressor(outputStream, 8, true);
        if (i2 != 2) {
            z = false;
        }
        if (!z) {
            lZWCompressor.a(bArr, 0, bArr.length);
        } else {
            byte[] bArr2 = z ? new byte[i5] : null;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                System.arraycopy(bArr, i6, bArr2, 0, i5);
                for (int i8 = i5 - 1; i8 >= i4; i8--) {
                    bArr2[i8] = (byte) (bArr2[i8] - bArr2[i8 - i4]);
                }
                lZWCompressor.a(bArr2, 0, i5);
                i6 += i5;
            }
        }
        lZWCompressor.b();
    }

    public static void e(int i2, OutputStream outputStream) throws IOException {
        outputStream.write((i2 >> 24) & 255);
        outputStream.write((i2 >> 16) & 255);
        outputStream.write((i2 >> 8) & 255);
        outputStream.write(i2 & 255);
    }

    public static void f(int i2, OutputStream outputStream) throws IOException {
        outputStream.write((i2 >> 8) & 255);
        outputStream.write(i2 & 255);
    }

    public void a(FieldBase fieldBase) {
        this.f26704a.put(Integer.valueOf(fieldBase.a()), fieldBase);
    }

    public int c() {
        return (this.f26704a.size() * 12) + 6;
    }

    public void d(OutputStream outputStream) throws IOException {
        outputStream.write(77);
        outputStream.write(77);
        outputStream.write(0);
        outputStream.write(42);
        e(8, outputStream);
        f(this.f26704a.size(), outputStream);
        int c2 = c() + 8;
        for (FieldBase next : this.f26704a.values()) {
            int b2 = next.b();
            if (b2 > 4) {
                next.c(c2);
                c2 += b2;
            }
            next.d(outputStream);
        }
        e(0, outputStream);
        for (FieldBase e2 : this.f26704a.values()) {
            e2.e(outputStream);
        }
    }
}

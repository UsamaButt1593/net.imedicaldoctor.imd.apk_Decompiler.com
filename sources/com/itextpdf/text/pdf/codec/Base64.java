package com.itextpdf.text.pdf.codec;

import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ByteBuffer;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public class Base64 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f26522a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f26523b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f26524c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f26525d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f26526e = 8;

    /* renamed from: f  reason: collision with root package name */
    public static final int f26527f = 16;

    /* renamed from: g  reason: collision with root package name */
    public static final int f26528g = 32;

    /* renamed from: h  reason: collision with root package name */
    private static final int f26529h = 76;

    /* renamed from: i  reason: collision with root package name */
    private static final byte f26530i = 61;

    /* renamed from: j  reason: collision with root package name */
    private static final byte f26531j = 10;

    /* renamed from: k  reason: collision with root package name */
    private static final String f26532k = "UTF-8";

    /* renamed from: l  reason: collision with root package name */
    private static final byte f26533l = -5;

    /* renamed from: m  reason: collision with root package name */
    private static final byte f26534m = -1;

    /* renamed from: n  reason: collision with root package name */
    private static final byte[] f26535n = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, DocWriter.g3};
    private static final byte[] o;
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] q;
    private static final byte[] r = {45, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] s;

    public static class InputStream extends FilterInputStream {
        private int X;
        private int X2;
        private byte[] Y;
        private int Y2;
        private int Z;
        private boolean Z2;
        private int a3;
        private byte[] b3;
        private byte[] c3;
        private boolean s;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0051 A[LOOP:1: B:19:0x003b->B:25:0x0051, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0057 A[EDGE_INSN: B:58:0x0057->B:26:0x0057 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
                r10 = this;
                int r0 = r10.X
                r1 = -1
                r2 = 0
                if (r0 >= 0) goto L_0x0077
                boolean r0 = r10.s
                r3 = 4
                if (r0 == 0) goto L_0x0038
                r0 = 3
                byte[] r4 = new byte[r0]
                r5 = 0
                r6 = 0
            L_0x0010:
                if (r5 >= r0) goto L_0x0027
                java.io.InputStream r7 = r10.in     // Catch:{ IOException -> 0x0020 }
                int r7 = r7.read()     // Catch:{ IOException -> 0x0020 }
                if (r7 < 0) goto L_0x0023
                byte r7 = (byte) r7     // Catch:{ IOException -> 0x0020 }
                r4[r5] = r7     // Catch:{ IOException -> 0x0020 }
                int r6 = r6 + 1
                goto L_0x0023
            L_0x0020:
                r7 = move-exception
                if (r5 == 0) goto L_0x0026
            L_0x0023:
                int r5 = r5 + 1
                goto L_0x0010
            L_0x0026:
                throw r7
            L_0x0027:
                if (r6 <= 0) goto L_0x0037
                byte[] r7 = r10.Y
                r8 = 0
                int r9 = r10.a3
                r5 = 0
                byte[] unused = com.itextpdf.text.pdf.codec.Base64.n(r4, r5, r6, r7, r8, r9)
                r10.X = r2
                r10.X2 = r3
                goto L_0x0077
            L_0x0037:
                return r1
            L_0x0038:
                byte[] r0 = new byte[r3]
                r4 = 0
            L_0x003b:
                if (r4 >= r3) goto L_0x0057
            L_0x003d:
                java.io.InputStream r5 = r10.in
                int r5 = r5.read()
                if (r5 < 0) goto L_0x004e
                byte[] r6 = r10.c3
                r7 = r5 & 127(0x7f, float:1.78E-43)
                byte r6 = r6[r7]
                r7 = -5
                if (r6 <= r7) goto L_0x003d
            L_0x004e:
                if (r5 >= 0) goto L_0x0051
                goto L_0x0057
            L_0x0051:
                byte r5 = (byte) r5
                r0[r4] = r5
                int r4 = r4 + 1
                goto L_0x003b
            L_0x0057:
                if (r4 != r3) goto L_0x0066
                byte[] r3 = r10.Y
                int r4 = r10.a3
                int r0 = com.itextpdf.text.pdf.codec.Base64.i(r0, r2, r3, r2, r4)
                r10.X2 = r0
                r10.X = r2
                goto L_0x0077
            L_0x0066:
                if (r4 != 0) goto L_0x0069
                return r1
            L_0x0069:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "improperly.padded.base64.input"
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)
                r0.<init>(r1)
                throw r0
            L_0x0077:
                int r0 = r10.X
                if (r0 < 0) goto L_0x00aa
                int r3 = r10.X2
                if (r0 < r3) goto L_0x0080
                return r1
            L_0x0080:
                boolean r3 = r10.s
                if (r3 == 0) goto L_0x0093
                boolean r3 = r10.Z2
                if (r3 == 0) goto L_0x0093
                int r3 = r10.Y2
                r4 = 76
                if (r3 < r4) goto L_0x0093
                r10.Y2 = r2
                r0 = 10
                return r0
            L_0x0093:
                int r2 = r10.Y2
                int r2 = r2 + 1
                r10.Y2 = r2
                byte[] r2 = r10.Y
                int r3 = r0 + 1
                r10.X = r3
                byte r0 = r2[r0]
                int r2 = r10.Z
                if (r3 < r2) goto L_0x00a7
                r10.X = r1
            L_0x00a7:
                r0 = r0 & 255(0xff, float:3.57E-43)
                return r0
            L_0x00aa:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "error.in.base64.code.reading.stream"
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.Base64.InputStream.read():int");
        }

        public InputStream(java.io.InputStream inputStream, int i2) {
            super(inputStream);
            boolean z = true;
            this.Z2 = (i2 & 8) != 8;
            z = (i2 & 1) != 1 ? false : z;
            this.s = z;
            int i3 = z ? 4 : 3;
            this.Z = i3;
            this.Y = new byte[i3];
            this.X = -1;
            this.Y2 = 0;
            this.a3 = i2;
            this.b3 = Base64.y(i2);
            this.c3 = Base64.z(i2);
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i2 + i4] = (byte) read;
                    i4++;
                } else if (i4 == 0) {
                    return -1;
                }
            }
            return i4;
        }
    }

    public static class OutputStream extends FilterOutputStream {
        private int X;
        private int X2;
        private byte[] Y;
        private boolean Y2;
        private int Z;
        private byte[] Z2;
        private boolean a3;
        private int b3;
        private byte[] c3;
        private byte[] d3;
        private boolean s;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public void b() throws IOException {
            int i2 = this.X;
            if (i2 <= 0) {
                return;
            }
            if (this.s) {
                this.out.write(Base64.o(this.Z2, this.Y, i2, this.b3));
                this.X = 0;
                return;
            }
            throw new IOException(MessageLocalization.b("base64.input.not.properly.padded", new Object[0]));
        }

        public void c() {
            this.a3 = false;
        }

        public void close() throws IOException {
            b();
            super.close();
            this.Y = null;
            this.out = null;
        }

        public void d() throws IOException {
            b();
            this.a3 = true;
        }

        public void write(int i2) throws IOException {
            if (this.a3) {
                this.out.write(i2);
                return;
            }
            if (this.s) {
                byte[] bArr = this.Y;
                int i3 = this.X;
                int i4 = i3 + 1;
                this.X = i4;
                bArr[i3] = (byte) i2;
                int i5 = this.Z;
                if (i4 >= i5) {
                    this.out.write(Base64.o(this.Z2, bArr, i5, this.b3));
                    int i6 = this.X2 + 4;
                    this.X2 = i6;
                    if (this.Y2 && i6 >= 76) {
                        this.out.write(10);
                        this.X2 = 0;
                    }
                } else {
                    return;
                }
            } else {
                byte b2 = this.d3[i2 & WorkQueueKt.f29430c];
                if (b2 > -5) {
                    byte[] bArr2 = this.Y;
                    int i7 = this.X;
                    int i8 = i7 + 1;
                    this.X = i8;
                    bArr2[i7] = (byte) i2;
                    if (i8 >= this.Z) {
                        this.out.write(this.Z2, 0, Base64.i(bArr2, 0, this.Z2, 0, this.b3));
                    } else {
                        return;
                    }
                } else if (b2 != -5) {
                    throw new IOException(MessageLocalization.b("invalid.character.in.base64.data", new Object[0]));
                } else {
                    return;
                }
            }
            this.X = 0;
        }

        public OutputStream(java.io.OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.Y2 = (i2 & 8) != 8;
            z = (i2 & 1) != 1 ? false : z;
            this.s = z;
            int i3 = z ? 3 : 4;
            this.Z = i3;
            this.Y = new byte[i3];
            this.X = 0;
            this.X2 = 0;
            this.a3 = false;
            this.Z2 = new byte[4];
            this.b3 = i2;
            this.c3 = Base64.y(i2);
            this.d3 = Base64.z(i2);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.a3) {
                this.out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }

    static {
        byte[] bArr = new byte[WorkQueueKt.f29430c];
        // fill-array-data instruction
        bArr[0] = -9;
        bArr[1] = -9;
        bArr[2] = -9;
        bArr[3] = -9;
        bArr[4] = -9;
        bArr[5] = -9;
        bArr[6] = -9;
        bArr[7] = -9;
        bArr[8] = -9;
        bArr[9] = -5;
        bArr[10] = -5;
        bArr[11] = -9;
        bArr[12] = -9;
        bArr[13] = -5;
        bArr[14] = -9;
        bArr[15] = -9;
        bArr[16] = -9;
        bArr[17] = -9;
        bArr[18] = -9;
        bArr[19] = -9;
        bArr[20] = -9;
        bArr[21] = -9;
        bArr[22] = -9;
        bArr[23] = -9;
        bArr[24] = -9;
        bArr[25] = -9;
        bArr[26] = -9;
        bArr[27] = -9;
        bArr[28] = -9;
        bArr[29] = -9;
        bArr[30] = -9;
        bArr[31] = -9;
        bArr[32] = -5;
        bArr[33] = -9;
        bArr[34] = -9;
        bArr[35] = -9;
        bArr[36] = -9;
        bArr[37] = -9;
        bArr[38] = -9;
        bArr[39] = -9;
        bArr[40] = -9;
        bArr[41] = -9;
        bArr[42] = -9;
        bArr[43] = 62;
        bArr[44] = -9;
        bArr[45] = -9;
        bArr[46] = -9;
        bArr[47] = 63;
        bArr[48] = 52;
        bArr[49] = 53;
        bArr[50] = 54;
        bArr[51] = 55;
        bArr[52] = 56;
        bArr[53] = 57;
        bArr[54] = 58;
        bArr[55] = 59;
        bArr[56] = 60;
        bArr[57] = 61;
        bArr[58] = -9;
        bArr[59] = -9;
        bArr[60] = -9;
        bArr[61] = -1;
        bArr[62] = -9;
        bArr[63] = -9;
        bArr[64] = -9;
        bArr[65] = 0;
        bArr[66] = 1;
        bArr[67] = 2;
        bArr[68] = 3;
        bArr[69] = 4;
        bArr[70] = 5;
        bArr[71] = 6;
        bArr[72] = 7;
        bArr[73] = 8;
        bArr[74] = 9;
        bArr[75] = 10;
        bArr[76] = 11;
        bArr[77] = 12;
        bArr[78] = 13;
        bArr[79] = 14;
        bArr[80] = 15;
        bArr[81] = 16;
        bArr[82] = 17;
        bArr[83] = 18;
        bArr[84] = 19;
        bArr[85] = 20;
        bArr[86] = 21;
        bArr[87] = 22;
        bArr[88] = 23;
        bArr[89] = 24;
        bArr[90] = 25;
        bArr[91] = -9;
        bArr[92] = -9;
        bArr[93] = -9;
        bArr[94] = -9;
        bArr[95] = -9;
        bArr[96] = -9;
        bArr[97] = 26;
        bArr[98] = 27;
        bArr[99] = 28;
        bArr[100] = 29;
        bArr[101] = 30;
        bArr[102] = 31;
        bArr[103] = 32;
        bArr[104] = 33;
        bArr[105] = 34;
        bArr[106] = 35;
        bArr[107] = 36;
        bArr[108] = 37;
        bArr[109] = 38;
        bArr[110] = 39;
        bArr[111] = 40;
        bArr[112] = 41;
        bArr[113] = 42;
        bArr[114] = 43;
        bArr[115] = 44;
        bArr[116] = 45;
        bArr[117] = 46;
        bArr[118] = 47;
        bArr[119] = 48;
        bArr[120] = 49;
        bArr[121] = 50;
        bArr[122] = 51;
        bArr[123] = -9;
        bArr[124] = -9;
        bArr[125] = -9;
        bArr[126] = -9;
        o = bArr;
        byte[] bArr2 = new byte[WorkQueueKt.f29430c];
        // fill-array-data instruction
        bArr2[0] = -9;
        bArr2[1] = -9;
        bArr2[2] = -9;
        bArr2[3] = -9;
        bArr2[4] = -9;
        bArr2[5] = -9;
        bArr2[6] = -9;
        bArr2[7] = -9;
        bArr2[8] = -9;
        bArr2[9] = -5;
        bArr2[10] = -5;
        bArr2[11] = -9;
        bArr2[12] = -9;
        bArr2[13] = -5;
        bArr2[14] = -9;
        bArr2[15] = -9;
        bArr2[16] = -9;
        bArr2[17] = -9;
        bArr2[18] = -9;
        bArr2[19] = -9;
        bArr2[20] = -9;
        bArr2[21] = -9;
        bArr2[22] = -9;
        bArr2[23] = -9;
        bArr2[24] = -9;
        bArr2[25] = -9;
        bArr2[26] = -9;
        bArr2[27] = -9;
        bArr2[28] = -9;
        bArr2[29] = -9;
        bArr2[30] = -9;
        bArr2[31] = -9;
        bArr2[32] = -5;
        bArr2[33] = -9;
        bArr2[34] = -9;
        bArr2[35] = -9;
        bArr2[36] = -9;
        bArr2[37] = -9;
        bArr2[38] = -9;
        bArr2[39] = -9;
        bArr2[40] = -9;
        bArr2[41] = -9;
        bArr2[42] = -9;
        bArr2[43] = -9;
        bArr2[44] = -9;
        bArr2[45] = 62;
        bArr2[46] = -9;
        bArr2[47] = -9;
        bArr2[48] = 52;
        bArr2[49] = 53;
        bArr2[50] = 54;
        bArr2[51] = 55;
        bArr2[52] = 56;
        bArr2[53] = 57;
        bArr2[54] = 58;
        bArr2[55] = 59;
        bArr2[56] = 60;
        bArr2[57] = 61;
        bArr2[58] = -9;
        bArr2[59] = -9;
        bArr2[60] = -9;
        bArr2[61] = -1;
        bArr2[62] = -9;
        bArr2[63] = -9;
        bArr2[64] = -9;
        bArr2[65] = 0;
        bArr2[66] = 1;
        bArr2[67] = 2;
        bArr2[68] = 3;
        bArr2[69] = 4;
        bArr2[70] = 5;
        bArr2[71] = 6;
        bArr2[72] = 7;
        bArr2[73] = 8;
        bArr2[74] = 9;
        bArr2[75] = 10;
        bArr2[76] = 11;
        bArr2[77] = 12;
        bArr2[78] = 13;
        bArr2[79] = 14;
        bArr2[80] = 15;
        bArr2[81] = 16;
        bArr2[82] = 17;
        bArr2[83] = 18;
        bArr2[84] = 19;
        bArr2[85] = 20;
        bArr2[86] = 21;
        bArr2[87] = 22;
        bArr2[88] = 23;
        bArr2[89] = 24;
        bArr2[90] = 25;
        bArr2[91] = -9;
        bArr2[92] = -9;
        bArr2[93] = -9;
        bArr2[94] = -9;
        bArr2[95] = 63;
        bArr2[96] = -9;
        bArr2[97] = 26;
        bArr2[98] = 27;
        bArr2[99] = 28;
        bArr2[100] = 29;
        bArr2[101] = 30;
        bArr2[102] = 31;
        bArr2[103] = 32;
        bArr2[104] = 33;
        bArr2[105] = 34;
        bArr2[106] = 35;
        bArr2[107] = 36;
        bArr2[108] = 37;
        bArr2[109] = 38;
        bArr2[110] = 39;
        bArr2[111] = 40;
        bArr2[112] = 41;
        bArr2[113] = 42;
        bArr2[114] = 43;
        bArr2[115] = 44;
        bArr2[116] = 45;
        bArr2[117] = 46;
        bArr2[118] = 47;
        bArr2[119] = 48;
        bArr2[120] = 49;
        bArr2[121] = 50;
        bArr2[122] = 51;
        bArr2[123] = -9;
        bArr2[124] = -9;
        bArr2[125] = -9;
        bArr2[126] = -9;
        q = bArr2;
        byte[] bArr3 = new byte[WorkQueueKt.f29430c];
        // fill-array-data instruction
        bArr3[0] = -9;
        bArr3[1] = -9;
        bArr3[2] = -9;
        bArr3[3] = -9;
        bArr3[4] = -9;
        bArr3[5] = -9;
        bArr3[6] = -9;
        bArr3[7] = -9;
        bArr3[8] = -9;
        bArr3[9] = -5;
        bArr3[10] = -5;
        bArr3[11] = -9;
        bArr3[12] = -9;
        bArr3[13] = -5;
        bArr3[14] = -9;
        bArr3[15] = -9;
        bArr3[16] = -9;
        bArr3[17] = -9;
        bArr3[18] = -9;
        bArr3[19] = -9;
        bArr3[20] = -9;
        bArr3[21] = -9;
        bArr3[22] = -9;
        bArr3[23] = -9;
        bArr3[24] = -9;
        bArr3[25] = -9;
        bArr3[26] = -9;
        bArr3[27] = -9;
        bArr3[28] = -9;
        bArr3[29] = -9;
        bArr3[30] = -9;
        bArr3[31] = -9;
        bArr3[32] = -5;
        bArr3[33] = -9;
        bArr3[34] = -9;
        bArr3[35] = -9;
        bArr3[36] = -9;
        bArr3[37] = -9;
        bArr3[38] = -9;
        bArr3[39] = -9;
        bArr3[40] = -9;
        bArr3[41] = -9;
        bArr3[42] = -9;
        bArr3[43] = -9;
        bArr3[44] = -9;
        bArr3[45] = 0;
        bArr3[46] = -9;
        bArr3[47] = -9;
        bArr3[48] = 1;
        bArr3[49] = 2;
        bArr3[50] = 3;
        bArr3[51] = 4;
        bArr3[52] = 5;
        bArr3[53] = 6;
        bArr3[54] = 7;
        bArr3[55] = 8;
        bArr3[56] = 9;
        bArr3[57] = 10;
        bArr3[58] = -9;
        bArr3[59] = -9;
        bArr3[60] = -9;
        bArr3[61] = -1;
        bArr3[62] = -9;
        bArr3[63] = -9;
        bArr3[64] = -9;
        bArr3[65] = 11;
        bArr3[66] = 12;
        bArr3[67] = 13;
        bArr3[68] = 14;
        bArr3[69] = 15;
        bArr3[70] = 16;
        bArr3[71] = 17;
        bArr3[72] = 18;
        bArr3[73] = 19;
        bArr3[74] = 20;
        bArr3[75] = 21;
        bArr3[76] = 22;
        bArr3[77] = 23;
        bArr3[78] = 24;
        bArr3[79] = 25;
        bArr3[80] = 26;
        bArr3[81] = 27;
        bArr3[82] = 28;
        bArr3[83] = 29;
        bArr3[84] = 30;
        bArr3[85] = 31;
        bArr3[86] = 32;
        bArr3[87] = 33;
        bArr3[88] = 34;
        bArr3[89] = 35;
        bArr3[90] = 36;
        bArr3[91] = -9;
        bArr3[92] = -9;
        bArr3[93] = -9;
        bArr3[94] = -9;
        bArr3[95] = 37;
        bArr3[96] = -9;
        bArr3[97] = 38;
        bArr3[98] = 39;
        bArr3[99] = 40;
        bArr3[100] = 41;
        bArr3[101] = 42;
        bArr3[102] = 43;
        bArr3[103] = 44;
        bArr3[104] = 45;
        bArr3[105] = 46;
        bArr3[106] = 47;
        bArr3[107] = 48;
        bArr3[108] = 49;
        bArr3[109] = 50;
        bArr3[110] = 51;
        bArr3[111] = 52;
        bArr3[112] = 53;
        bArr3[113] = 54;
        bArr3[114] = 55;
        bArr3[115] = 56;
        bArr3[116] = 57;
        bArr3[117] = 58;
        bArr3[118] = 59;
        bArr3[119] = 60;
        bArr3[120] = 61;
        bArr3[121] = 62;
        bArr3[122] = 63;
        bArr3[123] = -9;
        bArr3[124] = -9;
        bArr3[125] = -9;
        bArr3[126] = -9;
        s = bArr3;
    }

    private Base64() {
    }

    private static final void A(String str) {
        PrintStream printStream = System.err;
        printStream.println(str);
        printStream.println("Usage: java Base64 -e|-d inputfile outputfile");
    }

    public static byte[] f(String str) {
        return g(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:11|12|13|(8:14|15|16|17|(3:18|19|(1:21)(1:57))|26|27|28)|29|30|31|32) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:22|23|45|46|47|48|49|50|51) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0054 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0057 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0071 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0074 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] g(java.lang.String r5, int r6) {
        /*
            java.lang.String r0 = "UTF-8"
            byte[] r5 = r5.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0007 }
            goto L_0x000b
        L_0x0007:
            byte[] r5 = r5.getBytes()
        L_0x000b:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = h(r5, r1, r0, r6)
            if (r5 == 0) goto L_0x007c
            int r6 = r5.length
            r0 = 4
            if (r6 < r0) goto L_0x007c
            byte r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r0 = 1
            byte r0 = r5[r0]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L_0x007c
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x006b, all -> 0x0067 }
            r2.<init>()     // Catch:{ IOException -> 0x006b, all -> 0x0067 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0064, all -> 0x0060 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0064, all -> 0x0060 }
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x005e, all -> 0x005b }
            r4.<init>(r3)     // Catch:{ IOException -> 0x005e, all -> 0x005b }
        L_0x003e:
            int r0 = r4.read(r6)     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            if (r0 < 0) goto L_0x004d
            r2.write(r6, r1, r0)     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            goto L_0x003e
        L_0x0048:
            r5 = move-exception
        L_0x0049:
            r0 = r2
            goto L_0x006e
        L_0x004b:
            r0 = r2
            goto L_0x0078
        L_0x004d:
            byte[] r5 = r2.toByteArray()     // Catch:{ IOException -> 0x004b, all -> 0x0048 }
            r2.close()     // Catch:{ Exception -> 0x0054 }
        L_0x0054:
            r4.close()     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            r3.close()     // Catch:{ Exception -> 0x007c }
            goto L_0x007c
        L_0x005b:
            r5 = move-exception
            r4 = r0
            goto L_0x0049
        L_0x005e:
            r4 = r0
            goto L_0x004b
        L_0x0060:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x0049
        L_0x0064:
            r3 = r0
            r4 = r3
            goto L_0x004b
        L_0x0067:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x006e
        L_0x006b:
            r3 = r0
            r4 = r3
            goto L_0x0078
        L_0x006e:
            r0.close()     // Catch:{ Exception -> 0x0071 }
        L_0x0071:
            r4.close()     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            r3.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            throw r5
        L_0x0078:
            r0.close()     // Catch:{ Exception -> 0x0054 }
            goto L_0x0054
        L_0x007c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.Base64.g(java.lang.String, int):byte[]");
    }

    public static byte[] h(byte[] bArr, int i2, int i3, int i4) {
        byte[] z = z(i4);
        byte[] bArr2 = new byte[((i3 * 3) / 4)];
        byte[] bArr3 = new byte[4];
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i2 + i3) {
            byte b2 = (byte) (bArr[i5] & Byte.MAX_VALUE);
            byte b3 = z[b2];
            if (b3 >= -5) {
                if (b3 >= -1) {
                    int i8 = i6 + 1;
                    bArr3[i6] = b2;
                    if (i8 > 3) {
                        i7 += i(bArr3, 0, bArr2, i7, i4);
                        if (b2 == 61) {
                            break;
                        }
                        i6 = 0;
                    } else {
                        i6 = i8;
                    }
                }
                i5++;
            } else {
                PrintStream printStream = System.err;
                printStream.println("Bad Base64 input character at " + i5 + ": " + bArr[i5] + "(decimal)");
                return null;
            }
        }
        byte[] bArr4 = new byte[i7];
        System.arraycopy(bArr2, 0, bArr4, 0, i7);
        return bArr4;
    }

    /* access modifiers changed from: private */
    public static int i(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        byte[] z = z(i4);
        int i5 = i2 + 2;
        byte b2 = bArr[i5];
        if (b2 == 61) {
            bArr2[i3] = (byte) ((((z[bArr[i2 + 1]] & 255) << 12) | ((z[bArr[i2]] & 255) << 18)) >>> 16);
            return 1;
        }
        int i6 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 == 61) {
            int i7 = ((z[bArr[i2 + 1]] & 255) << 12) | ((z[bArr[i2]] & 255) << 18) | ((z[b2] & 255) << 6);
            bArr2[i3] = (byte) (i7 >>> 16);
            bArr2[i3 + 1] = (byte) (i7 >>> 8);
            return 2;
        }
        try {
            byte b4 = ((z[b2] & 255) << 6) | ((z[bArr[i2]] & 255) << 18) | ((z[bArr[i2 + 1]] & 255) << 12) | (z[b3] & 255);
            bArr2[i3] = (byte) (b4 >> 16);
            bArr2[i3 + 1] = (byte) (b4 >> 8);
            bArr2[i3 + 2] = (byte) b4;
            return 3;
        } catch (Exception unused) {
            PrintStream printStream = System.out;
            printStream.println("" + bArr[i2] + ": " + z[bArr[i2]]);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            int i8 = i2 + 1;
            sb.append(bArr[i8]);
            sb.append(": ");
            sb.append(z[bArr[i8]]);
            printStream.println(sb.toString());
            printStream.println("" + bArr[i5] + ": " + z[bArr[i5]]);
            printStream.println("" + bArr[i6] + ": " + z[bArr[i6]]);
            return -1;
        }
    }

    public static void j(String str, String str2) {
        byte[] k2 = k(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(k2);
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    bufferedOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedOutputStream.close();
                throw th;
            }
            try {
                bufferedOutputStream2.close();
            } catch (Exception unused2) {
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            bufferedOutputStream.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A[SYNTHETIC, Splitter:B:27:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084 A[SYNTHETIC, Splitter:B:33:0x0084] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] k(java.lang.String r7) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0033 }
            r1.<init>(r7)     // Catch:{ IOException -> 0x0033 }
            long r2 = r1.length()     // Catch:{ IOException -> 0x0033 }
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0035
            java.io.PrintStream r2 = java.lang.System.err     // Catch:{ IOException -> 0x0033 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0033 }
            r3.<init>()     // Catch:{ IOException -> 0x0033 }
            java.lang.String r4 = "File is too big for this convenience method ("
            r3.append(r4)     // Catch:{ IOException -> 0x0033 }
            long r4 = r1.length()     // Catch:{ IOException -> 0x0033 }
            r3.append(r4)     // Catch:{ IOException -> 0x0033 }
            java.lang.String r1 = " bytes)."
            r3.append(r1)     // Catch:{ IOException -> 0x0033 }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x0033 }
            r2.println(r1)     // Catch:{ IOException -> 0x0033 }
            return r0
        L_0x0031:
            r7 = move-exception
            goto L_0x0082
        L_0x0033:
            r1 = r0
            goto L_0x0065
        L_0x0035:
            long r2 = r1.length()     // Catch:{ IOException -> 0x0033 }
            int r3 = (int) r2     // Catch:{ IOException -> 0x0033 }
            byte[] r2 = new byte[r3]     // Catch:{ IOException -> 0x0033 }
            com.itextpdf.text.pdf.codec.Base64$InputStream r3 = new com.itextpdf.text.pdf.codec.Base64$InputStream     // Catch:{ IOException -> 0x0033 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0033 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0033 }
            r5.<init>(r1)     // Catch:{ IOException -> 0x0033 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0033 }
            r1 = 0
            r3.<init>(r4, r1)     // Catch:{ IOException -> 0x0033 }
            r4 = 0
        L_0x004d:
            r5 = 4096(0x1000, float:5.74E-42)
            int r5 = r3.read(r2, r4, r5)     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            if (r5 < 0) goto L_0x0057
            int r4 = r4 + r5
            goto L_0x004d
        L_0x0057:
            byte[] r0 = new byte[r4]     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            java.lang.System.arraycopy(r2, r1, r0, r1, r4)     // Catch:{ IOException -> 0x0063, all -> 0x0060 }
            r3.close()     // Catch:{ Exception -> 0x0081 }
            goto L_0x0081
        L_0x0060:
            r7 = move-exception
            r0 = r3
            goto L_0x0082
        L_0x0063:
            r1 = r0
            r0 = r3
        L_0x0065:
            java.io.PrintStream r2 = java.lang.System.err     // Catch:{ all -> 0x0031 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r3.<init>()     // Catch:{ all -> 0x0031 }
            java.lang.String r4 = "Error decoding from file "
            r3.append(r4)     // Catch:{ all -> 0x0031 }
            r3.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0031 }
            r2.println(r7)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0080
            r0.close()     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            r0 = r1
        L_0x0081:
            return r0
        L_0x0082:
            if (r0 == 0) goto L_0x0087
            r0.close()     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.Base64.k(java.lang.String):byte[]");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean l(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            com.itextpdf.text.pdf.codec.Base64$OutputStream r2 = new com.itextpdf.text.pdf.codec.Base64$OutputStream     // Catch:{ IOException -> 0x0024, all -> 0x001f }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0024, all -> 0x001f }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0024, all -> 0x001f }
            r2.<init>(r3, r0)     // Catch:{ IOException -> 0x0024, all -> 0x001f }
            java.lang.String r5 = "UTF-8"
            byte[] r4 = r4.getBytes(r5)     // Catch:{ IOException -> 0x001d, all -> 0x001a }
            r2.write(r4)     // Catch:{ IOException -> 0x001d, all -> 0x001a }
            r2.close()     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            r0 = 1
            goto L_0x0027
        L_0x001a:
            r4 = move-exception
            r1 = r2
            goto L_0x0020
        L_0x001d:
            r1 = r2
            goto L_0x0024
        L_0x001f:
            r4 = move-exception
        L_0x0020:
            r1.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            throw r4
        L_0x0024:
            r1.close()     // Catch:{ Exception -> 0x0027 }
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.Base64.l(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:11|31|32|33|34|35) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|(3:1|2|(4:3|4|5|6))|7|8|9|10|29) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0044 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object m(java.lang.String r4) {
        /*
            byte[] r4 = f(r4)
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0034, ClassNotFoundException -> 0x0030, all -> 0x002b }
            r1.<init>(r4)     // Catch:{ IOException -> 0x0034, ClassNotFoundException -> 0x0030, all -> 0x002b }
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0028, ClassNotFoundException -> 0x0025, all -> 0x0020 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0028, ClassNotFoundException -> 0x0025, all -> 0x0020 }
            java.lang.Object r0 = r4.readObject()     // Catch:{ IOException -> 0x001e, ClassNotFoundException -> 0x001c }
        L_0x0013:
            r1.close()     // Catch:{ Exception -> 0x0016 }
        L_0x0016:
            r4.close()     // Catch:{ Exception -> 0x0040 }
            goto L_0x0040
        L_0x001a:
            r0 = move-exception
            goto L_0x0041
        L_0x001c:
            r2 = move-exception
            goto L_0x0038
        L_0x001e:
            r2 = move-exception
            goto L_0x003c
        L_0x0020:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x0041
        L_0x0025:
            r2 = move-exception
            r4 = r0
            goto L_0x0038
        L_0x0028:
            r2 = move-exception
            r4 = r0
            goto L_0x003c
        L_0x002b:
            r4 = move-exception
            r1 = r0
            r0 = r4
            r4 = r1
            goto L_0x0041
        L_0x0030:
            r2 = move-exception
            r4 = r0
            r1 = r4
            goto L_0x0038
        L_0x0034:
            r2 = move-exception
            r4 = r0
            r1 = r4
            goto L_0x003c
        L_0x0038:
            r2.printStackTrace()     // Catch:{ all -> 0x001a }
            goto L_0x0013
        L_0x003c:
            r2.printStackTrace()     // Catch:{ all -> 0x001a }
            goto L_0x0013
        L_0x0040:
            return r0
        L_0x0041:
            r1.close()     // Catch:{ Exception -> 0x0044 }
        L_0x0044:
            r4.close()     // Catch:{ Exception -> 0x0047 }
        L_0x0047:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.Base64.m(java.lang.String):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static byte[] n(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] y = y(i5);
        int i6 = 0;
        int i7 = (i3 > 0 ? (bArr[i2] << Ascii.B) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << Ascii.B) >>> 16 : 0);
        if (i3 > 2) {
            i6 = (bArr[i2 + 2] << Ascii.B) >>> 24;
        }
        int i8 = i7 | i6;
        if (i3 == 1) {
            bArr2[i4] = y[i8 >>> 18];
            bArr2[i4 + 1] = y[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 == 2) {
            bArr2[i4] = y[i8 >>> 18];
            bArr2[i4 + 1] = y[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = y[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 != 3) {
            return bArr2;
        } else {
            bArr2[i4] = y[i8 >>> 18];
            bArr2[i4 + 1] = y[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = y[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = y[i8 & 63];
            return bArr2;
        }
    }

    /* access modifiers changed from: private */
    public static byte[] o(byte[] bArr, byte[] bArr2, int i2, int i3) {
        n(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    public static String p(byte[] bArr) {
        return s(bArr, 0, bArr.length, 0);
    }

    public static String q(byte[] bArr, int i2) {
        return s(bArr, 0, bArr.length, i2);
    }

    public static String r(byte[] bArr, int i2, int i3) {
        return s(bArr, i2, i3, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.itextpdf.text.pdf.codec.Base64$OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: com.itextpdf.text.pdf.codec.Base64$OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: com.itextpdf.text.pdf.codec.Base64$OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: com.itextpdf.text.pdf.codec.Base64$OutputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:10|11|12|13|14|15|16|17|18|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:28|29|39|40|41|42|43|44|45|46|47) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:24|25|49|50|51|52|53|54|55) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0064 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0067 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x006e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0071 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String s(byte[] r18, int r19, int r20, int r21) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21 & 8
            r3 = r21 & 2
            java.lang.String r8 = "UTF-8"
            r4 = 1
            r5 = 2
            if (r3 != r5) goto L_0x0075
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x005a, all -> 0x0056 }
            r3.<init>()     // Catch:{ IOException -> 0x005a, all -> 0x0056 }
            com.itextpdf.text.pdf.codec.Base64$OutputStream r5 = new com.itextpdf.text.pdf.codec.Base64$OutputStream     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            r4 = r21 | 1
            r5.<init>(r3, r4)     // Catch:{ IOException -> 0x0052, all -> 0x004f }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x004c, all -> 0x004a }
            r4.<init>(r5)     // Catch:{ IOException -> 0x004c, all -> 0x004a }
            r9 = r18
            r4.write(r9, r0, r1)     // Catch:{ IOException -> 0x0048 }
            r4.close()     // Catch:{ IOException -> 0x0048 }
            r4.close()     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            r5.close()     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            r3.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x003b }
            byte[] r1 = r3.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x003b }
            r0.<init>(r1, r8)     // Catch:{ UnsupportedEncodingException -> 0x003b }
            return r0
        L_0x003b:
            java.lang.String r0 = new java.lang.String
            byte[] r1 = r3.toByteArray()
            r0.<init>(r1)
            return r0
        L_0x0045:
            r0 = move-exception
            r2 = r4
            goto L_0x006b
        L_0x0048:
            r0 = move-exception
            goto L_0x005e
        L_0x004a:
            r0 = move-exception
            goto L_0x006b
        L_0x004c:
            r0 = move-exception
            r4 = r2
            goto L_0x005e
        L_0x004f:
            r0 = move-exception
            r5 = r2
            goto L_0x006b
        L_0x0052:
            r0 = move-exception
            r4 = r2
        L_0x0054:
            r5 = r4
            goto L_0x005e
        L_0x0056:
            r0 = move-exception
            r3 = r2
            r5 = r3
            goto L_0x006b
        L_0x005a:
            r0 = move-exception
            r3 = r2
            r4 = r3
            goto L_0x0054
        L_0x005e:
            r0.printStackTrace()     // Catch:{ all -> 0x0045 }
            r4.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            r5.close()     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            r3.close()     // Catch:{ Exception -> 0x006a }
        L_0x006a:
            return r2
        L_0x006b:
            r2.close()     // Catch:{ Exception -> 0x006e }
        L_0x006e:
            r5.close()     // Catch:{ Exception -> 0x0071 }
        L_0x0071:
            r3.close()     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            throw r0
        L_0x0075:
            r9 = r18
            if (r2 != 0) goto L_0x007b
            r11 = 1
            goto L_0x007c
        L_0x007b:
            r11 = 0
        L_0x007c:
            int r2 = r1 * 4
            int r2 = r2 / 3
            int r3 = r1 % 3
            r12 = 4
            if (r3 <= 0) goto L_0x0087
            r3 = 4
            goto L_0x0088
        L_0x0087:
            r3 = 0
        L_0x0088:
            int r3 = r3 + r2
            r13 = 76
            if (r11 == 0) goto L_0x008f
            int r2 = r2 / r13
            goto L_0x0090
        L_0x008f:
            r2 = 0
        L_0x0090:
            int r3 = r3 + r2
            byte[] r14 = new byte[r3]
            int r15 = r1 + -2
            r7 = 0
            r16 = 0
            r17 = 0
        L_0x009a:
            if (r7 >= r15) goto L_0x00c2
            int r3 = r7 + r0
            r4 = 3
            r2 = r18
            r5 = r14
            r6 = r16
            r10 = r7
            r7 = r21
            n(r2, r3, r4, r5, r6, r7)
            int r2 = r17 + 4
            if (r11 == 0) goto L_0x00bb
            if (r2 != r13) goto L_0x00bb
            int r2 = r16 + 4
            r3 = 10
            r14[r2] = r3
            int r16 = r16 + 1
            r17 = 0
            goto L_0x00bd
        L_0x00bb:
            r17 = r2
        L_0x00bd:
            int r7 = r10 + 3
            int r16 = r16 + 4
            goto L_0x009a
        L_0x00c2:
            r10 = r7
            if (r10 >= r1) goto L_0x00d7
            int r2 = r10 + r0
            int r3 = r1 - r10
            r0 = r18
            r1 = r2
            r2 = r3
            r3 = r14
            r4 = r16
            r5 = r21
            n(r0, r1, r2, r3, r4, r5)
            int r16 = r16 + 4
        L_0x00d7:
            r0 = r16
            java.lang.String r1 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x00e0 }
            r2 = 0
            r1.<init>(r14, r2, r0, r8)     // Catch:{ UnsupportedEncodingException -> 0x00e1 }
            return r1
        L_0x00e0:
            r2 = 0
        L_0x00e1:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r14, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.Base64.s(byte[], int, int, int):java.lang.String");
    }

    public static void t(String str, String str2) {
        String u = u(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(u.getBytes("US-ASCII"));
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    bufferedOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedOutputStream.close();
                throw th;
            }
            try {
                bufferedOutputStream2.close();
            } catch (Exception unused2) {
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            bufferedOutputStream.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        java.lang.System.err.println("Error encoding from file " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String u(java.lang.String r7) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r1.<init>(r7)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            long r2 = r1.length()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            double r2 = (double) r2     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r4 = 4608983858650965606(0x3ff6666666666666, double:1.4)
            double r2 = r2 * r4
            int r2 = (int) r2     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r3 = 40
            int r2 = java.lang.Math.max(r2, r3)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            com.itextpdf.text.pdf.codec.Base64$InputStream r3 = new com.itextpdf.text.pdf.codec.Base64$InputStream     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r5.<init>(r1)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r1 = 1
            r3.<init>(r4, r1)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r1 = 0
            r4 = 0
        L_0x002d:
            r5 = 4096(0x1000, float:5.74E-42)
            int r5 = r3.read(r2, r4, r5)     // Catch:{ IOException -> 0x0049 }
            if (r5 < 0) goto L_0x0037
            int r4 = r4 + r5
            goto L_0x002d
        L_0x0037:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x0049 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r2, r1, r4, r6)     // Catch:{ IOException -> 0x0049 }
            r3.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            r0 = r5
            goto L_0x0062
        L_0x0043:
            r7 = move-exception
            r0 = r3
            goto L_0x0063
        L_0x0046:
            r7 = move-exception
            goto L_0x0063
        L_0x0048:
            r3 = r0
        L_0x0049:
            java.io.PrintStream r1 = java.lang.System.err     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r4 = "Error encoding from file "
            r2.append(r4)     // Catch:{ all -> 0x0043 }
            r2.append(r7)     // Catch:{ all -> 0x0043 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x0043 }
            r1.println(r7)     // Catch:{ all -> 0x0043 }
            r3.close()     // Catch:{ Exception -> 0x0062 }
        L_0x0062:
            return r0
        L_0x0063:
            r0.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.Base64.u(java.lang.String):java.lang.String");
    }

    public static String v(Serializable serializable) {
        return w(serializable, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:11|60|61|62|63|64|65|66|67|68) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:48|49|50|51|52|53|54|55|56|57|58) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:21|22|23|24|25|26|27|28|29|30|31|32|33) */
    /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|(4:7|8|9|10)(3:18|19|20)|21|22|23|24|25|26|27|28|29|30|31|32|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0055, code lost:
        return new java.lang.String(r2.toByteArray());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0037 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x003a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0074 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0081 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0084 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:66:0x0087 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String w(java.io.Serializable r4, int r5) {
        /*
            r0 = r5 & 2
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0069, all -> 0x0064 }
            r2.<init>()     // Catch:{ IOException -> 0x0069, all -> 0x0064 }
            com.itextpdf.text.pdf.codec.Base64$OutputStream r3 = new com.itextpdf.text.pdf.codec.Base64$OutputStream     // Catch:{ IOException -> 0x005f, all -> 0x005b }
            r5 = r5 | 1
            r3.<init>(r2, r5)     // Catch:{ IOException -> 0x005f, all -> 0x005b }
            r5 = 2
            if (r0 != r5) goto L_0x002b
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0020, all -> 0x001d }
            r0.<init>(r5)     // Catch:{ IOException -> 0x0020, all -> 0x001d }
            goto L_0x0031
        L_0x001d:
            r4 = move-exception
            goto L_0x007e
        L_0x0020:
            r4 = move-exception
            r0 = r1
            goto L_0x006e
        L_0x0023:
            r4 = move-exception
            r5 = r1
            goto L_0x007e
        L_0x0027:
            r4 = move-exception
            r5 = r1
            r0 = r5
            goto L_0x006e
        L_0x002b:
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0027, all -> 0x0023 }
            r5 = r1
        L_0x0031:
            r0.writeObject(r4)     // Catch:{ IOException -> 0x0059 }
            r0.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            r5.close()     // Catch:{ Exception -> 0x003a }
        L_0x003a:
            r3.close()     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            r2.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            java.lang.String r4 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x004c }
            byte[] r5 = r2.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x004c }
            java.lang.String r0 = "UTF-8"
            r4.<init>(r5, r0)     // Catch:{ UnsupportedEncodingException -> 0x004c }
            return r4
        L_0x004c:
            java.lang.String r4 = new java.lang.String
            byte[] r5 = r2.toByteArray()
            r4.<init>(r5)
            return r4
        L_0x0056:
            r4 = move-exception
            r1 = r0
            goto L_0x007e
        L_0x0059:
            r4 = move-exception
            goto L_0x006e
        L_0x005b:
            r4 = move-exception
            r5 = r1
            r3 = r5
            goto L_0x007e
        L_0x005f:
            r4 = move-exception
            r5 = r1
            r0 = r5
            r3 = r0
            goto L_0x006e
        L_0x0064:
            r4 = move-exception
            r5 = r1
            r2 = r5
            r3 = r2
            goto L_0x007e
        L_0x0069:
            r4 = move-exception
            r5 = r1
            r0 = r5
            r2 = r0
            r3 = r2
        L_0x006e:
            r4.printStackTrace()     // Catch:{ all -> 0x0056 }
            r0.close()     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            r5.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            r3.close()     // Catch:{ Exception -> 0x007a }
        L_0x007a:
            r2.close()     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            return r1
        L_0x007e:
            r1.close()     // Catch:{ Exception -> 0x0081 }
        L_0x0081:
            r5.close()     // Catch:{ Exception -> 0x0084 }
        L_0x0084:
            r3.close()     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            r2.close()     // Catch:{ Exception -> 0x008a }
        L_0x008a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.Base64.w(java.io.Serializable, int):java.lang.String");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean x(byte[] r3, java.lang.String r4) {
        /*
            r0 = 0
            com.itextpdf.text.pdf.codec.Base64$OutputStream r1 = new com.itextpdf.text.pdf.codec.Base64$OutputStream     // Catch:{ IOException -> 0x001d, all -> 0x0018 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x001d, all -> 0x0018 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x001d, all -> 0x0018 }
            r4 = 1
            r1.<init>(r2, r4)     // Catch:{ IOException -> 0x001d, all -> 0x0018 }
            r1.write(r3)     // Catch:{ IOException -> 0x0016, all -> 0x0013 }
            r1.close()     // Catch:{ Exception -> 0x0021 }
            goto L_0x0021
        L_0x0013:
            r3 = move-exception
            r0 = r1
            goto L_0x0019
        L_0x0016:
            r0 = r1
            goto L_0x001d
        L_0x0018:
            r3 = move-exception
        L_0x0019:
            r0.close()     // Catch:{ Exception -> 0x001c }
        L_0x001c:
            throw r3
        L_0x001d:
            r0.close()     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            r4 = 0
        L_0x0021:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.Base64.x(byte[], java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public static final byte[] y(int i2) {
        if ((i2 & 16) == 16) {
            return p;
        }
        return (i2 & 32) == 32 ? r : f26535n;
    }

    /* access modifiers changed from: private */
    public static final byte[] z(int i2) {
        if ((i2 & 16) == 16) {
            return q;
        }
        return (i2 & 32) == 32 ? s : o;
    }
}

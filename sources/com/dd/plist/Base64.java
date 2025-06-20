package com.dd.plist;

import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import okio.Utf8;

public class Base64 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f18659a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f18660b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f18661c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f18662d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f18663e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f18664f = 8;

    /* renamed from: g  reason: collision with root package name */
    public static final int f18665g = 16;

    /* renamed from: h  reason: collision with root package name */
    public static final int f18666h = 32;

    /* renamed from: i  reason: collision with root package name */
    private static final int f18667i = 76;

    /* renamed from: j  reason: collision with root package name */
    private static final byte f18668j = 61;

    /* renamed from: k  reason: collision with root package name */
    private static final byte f18669k = 10;

    /* renamed from: l  reason: collision with root package name */
    private static final String f18670l = "US-ASCII";

    /* renamed from: m  reason: collision with root package name */
    private static final byte f18671m = -5;

    /* renamed from: n  reason: collision with root package name */
    private static final byte f18672n = -1;
    private static final byte[] o = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, DocWriter.g3};
    private static final byte[] p = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f18671m, f18671m, -9, -9, f18671m, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f18671m, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, DocWriter.f3, -9, -9, -9, Utf8.f31404a, 52, 53, 54, 55, 56, 57, 58, 59, DocWriter.b3, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.x, Ascii.y, Ascii.z, Ascii.A, Ascii.B, Ascii.C, -9, -9, -9, -9, -9, -9, Ascii.D, Ascii.E, Ascii.F, Ascii.G, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, DocWriter.g3, ByteBuffer.X2, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] q = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] r = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f18671m, f18671m, -9, -9, f18671m, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f18671m, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, DocWriter.f3, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, DocWriter.b3, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.x, Ascii.y, Ascii.z, Ascii.A, Ascii.B, Ascii.C, -9, -9, -9, -9, Utf8.f31404a, -9, Ascii.D, Ascii.E, Ascii.F, Ascii.G, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, DocWriter.g3, ByteBuffer.X2, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] s = {45, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] t = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f18671m, f18671m, -9, -9, f18671m, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f18671m, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.x, Ascii.y, Ascii.z, Ascii.A, Ascii.B, Ascii.C, Ascii.D, Ascii.E, Ascii.F, Ascii.G, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, DocWriter.g3, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, DocWriter.b3, 61, DocWriter.f3, Utf8.f31404a, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    static final /* synthetic */ boolean u = false;

    public static class InputStream extends FilterInputStream {
        private int X;
        private int X2;
        private byte[] Y;
        private int Y2;
        private int Z;
        private boolean Z2;
        private int a3;
        private byte[] b3;
        private boolean s;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[LOOP:1: B:13:0x0036->B:19:0x004c, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0052 A[EDGE_INSN: B:49:0x0052->B:20:0x0052 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
                r10 = this;
                int r0 = r10.X
                r1 = -1
                r2 = 0
                if (r0 >= 0) goto L_0x006c
                boolean r0 = r10.s
                r3 = 4
                if (r0 == 0) goto L_0x0033
                r0 = 3
                byte[] r4 = new byte[r0]
                r5 = 0
                r6 = 0
            L_0x0010:
                if (r5 >= r0) goto L_0x0022
                java.io.InputStream r7 = r10.in
                int r7 = r7.read()
                if (r7 < 0) goto L_0x0022
                byte r7 = (byte) r7
                r4[r5] = r7
                int r6 = r6 + 1
                int r5 = r5 + 1
                goto L_0x0010
            L_0x0022:
                if (r6 <= 0) goto L_0x0032
                byte[] r7 = r10.Y
                r8 = 0
                int r9 = r10.a3
                r5 = 0
                byte[] unused = com.dd.plist.Base64.q(r4, r5, r6, r7, r8, r9)
                r10.X = r2
                r10.X2 = r3
                goto L_0x006c
            L_0x0032:
                return r1
            L_0x0033:
                byte[] r0 = new byte[r3]
                r4 = 0
            L_0x0036:
                if (r4 >= r3) goto L_0x0052
            L_0x0038:
                java.io.InputStream r5 = r10.in
                int r5 = r5.read()
                if (r5 < 0) goto L_0x0049
                byte[] r6 = r10.b3
                r7 = r5 & 127(0x7f, float:1.78E-43)
                byte r6 = r6[r7]
                r7 = -5
                if (r6 <= r7) goto L_0x0038
            L_0x0049:
                if (r5 >= 0) goto L_0x004c
                goto L_0x0052
            L_0x004c:
                byte r5 = (byte) r5
                r0[r4] = r5
                int r4 = r4 + 1
                goto L_0x0036
            L_0x0052:
                if (r4 != r3) goto L_0x0061
                byte[] r3 = r10.Y
                int r4 = r10.a3
                int r0 = com.dd.plist.Base64.i(r0, r2, r3, r2, r4)
                r10.X2 = r0
                r10.X = r2
                goto L_0x006c
            L_0x0061:
                if (r4 != 0) goto L_0x0064
                return r1
            L_0x0064:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Improperly padded Base64 input."
                r0.<init>(r1)
                throw r0
            L_0x006c:
                int r0 = r10.X
                if (r0 < 0) goto L_0x009f
                int r3 = r10.X2
                if (r0 < r3) goto L_0x0075
                return r1
            L_0x0075:
                boolean r3 = r10.s
                if (r3 == 0) goto L_0x0088
                boolean r3 = r10.Z2
                if (r3 == 0) goto L_0x0088
                int r3 = r10.Y2
                r4 = 76
                if (r3 < r4) goto L_0x0088
                r10.Y2 = r2
                r0 = 10
                return r0
            L_0x0088:
                int r2 = r10.Y2
                int r2 = r2 + 1
                r10.Y2 = r2
                byte[] r2 = r10.Y
                int r3 = r0 + 1
                r10.X = r3
                byte r0 = r2[r0]
                int r2 = r10.Z
                if (r3 < r2) goto L_0x009c
                r10.X = r1
            L_0x009c:
                r0 = r0 & 255(0xff, float:3.57E-43)
                return r0
            L_0x009f:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Error in Base64 code reading stream."
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dd.plist.Base64.InputStream.read():int");
        }

        public InputStream(java.io.InputStream inputStream, int i2) {
            super(inputStream);
            this.a3 = i2;
            boolean z = true;
            this.Z2 = (i2 & 8) > 0;
            z = (i2 & 1) <= 0 ? false : z;
            this.s = z;
            int i3 = z ? 4 : 3;
            this.Z = i3;
            this.Y = new byte[i3];
            this.X = -1;
            this.Y2 = 0;
            this.b3 = Base64.E(i2);
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
                this.out.write(Base64.r(this.Z2, this.Y, i2, this.b3));
                this.X = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
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
                    this.out.write(Base64.r(this.Z2, bArr, i5, this.b3));
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
                byte b2 = this.c3[i2 & WorkQueueKt.f29430c];
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
                    throw new IOException("Invalid character in Base64 data.");
                } else {
                    return;
                }
            }
            this.X = 0;
        }

        public OutputStream(java.io.OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.Y2 = (i2 & 8) != 0;
            z = (i2 & 1) == 0 ? false : z;
            this.s = z;
            int i3 = z ? 3 : 4;
            this.Z = i3;
            this.Y = new byte[i3];
            this.X = 0;
            this.X2 = 0;
            this.a3 = false;
            this.Z2 = new byte[4];
            this.b3 = i2;
            this.c3 = Base64.E(i2);
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

    private Base64() {
    }

    public static String A(Serializable serializable) throws IOException {
        return B(serializable, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.ObjectOutputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:13|51|52|53|54|55|56|57|58|59) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:4|5|6|(5:8|9|10|11|12)(3:20|21|22)|23|24|25|26|27|28|29|30|31|32|33|34|35) */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:2|3|4|5|6|(5:8|9|10|11|12)(3:20|21|22)|23|24|25|26|27|28|29|30|31|32|33|34|35) */
    /* JADX WARNING: Can't wrap try/catch for region: R(20:1|2|3|4|5|6|(5:8|9|10|11|12)(3:20|21|22)|23|24|25|26|27|28|29|30|31|32|33|34|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005b, code lost:
        return new java.lang.String(r1.toByteArray());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0043 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0046 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x007d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String B(java.io.Serializable r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0081
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r1.<init>()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            com.dd.plist.Base64$OutputStream r2 = new com.dd.plist.Base64$OutputStream     // Catch:{ IOException -> 0x0060, all -> 0x005c }
            r3 = r6 | 1
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x0060, all -> 0x005c }
            r6 = r6 & 2
            if (r6 == 0) goto L_0x002f
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0 = r3
            goto L_0x0037
        L_0x001f:
            r5 = move-exception
            goto L_0x0074
        L_0x0022:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x006f
        L_0x0027:
            r5 = move-exception
            r6 = r0
            goto L_0x0074
        L_0x002a:
            r5 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x006f
        L_0x002f:
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0037:
            r0.writeObject(r5)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0.close()     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            r6.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            r2.close()     // Catch:{ Exception -> 0x0043 }
        L_0x0043:
            r1.close()     // Catch:{ Exception -> 0x0046 }
        L_0x0046:
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0052 }
            byte[] r6 = r1.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x0052 }
            java.lang.String r0 = "US-ASCII"
            r5.<init>(r6, r0)     // Catch:{ UnsupportedEncodingException -> 0x0052 }
            return r5
        L_0x0052:
            java.lang.String r5 = new java.lang.String
            byte[] r6 = r1.toByteArray()
            r5.<init>(r6)
            return r5
        L_0x005c:
            r5 = move-exception
            r6 = r0
            r2 = r6
            goto L_0x0074
        L_0x0060:
            r5 = move-exception
            r6 = r0
            r2 = r6
            r0 = r1
            r1 = r2
            goto L_0x006f
        L_0x0066:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
            goto L_0x0074
        L_0x006b:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
        L_0x006f:
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0074:
            r0.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            r6.close()     // Catch:{ Exception -> 0x007a }
        L_0x007a:
            r2.close()     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            r1.close()     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            throw r5
        L_0x0081:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Cannot serialize a null object."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.plist.Base64.B(java.io.Serializable, int):java.lang.String");
    }

    public static void C(byte[] bArr, String str) throws IOException {
        if (bArr != null) {
            OutputStream outputStream = null;
            try {
                OutputStream outputStream2 = new OutputStream(new FileOutputStream(str), 1);
                try {
                    outputStream2.write(bArr);
                    try {
                        outputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                    e = e2;
                    outputStream = outputStream2;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = outputStream2;
                    try {
                        outputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                throw e;
            }
        } else {
            throw new NullPointerException("Data to encode was null.");
        }
    }

    private static final byte[] D(int i2) {
        if ((i2 & 16) == 16) {
            return q;
        }
        return (i2 & 32) == 32 ? s : o;
    }

    /* access modifiers changed from: private */
    public static final byte[] E(int i2) {
        if ((i2 & 16) == 16) {
            return r;
        }
        return (i2 & 32) == 32 ? t : p;
    }

    public static byte[] e(String str) throws IOException {
        return f(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|(5:17|18|19|20|(6:21|22|(3:23|24|(1:26)(1:67))|31|32|33))|34|35|(2:36|37)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:54|55|56|57|58|59|60|61) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x005f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0062 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0086 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x0089 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] f(java.lang.String r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x008e
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0009 }
            goto L_0x000d
        L_0x0009:
            byte[] r5 = r5.getBytes()
        L_0x000d:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = h(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L_0x001a
            r6 = 1
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            if (r5 == 0) goto L_0x008d
            int r3 = r5.length
            if (r3 < r0) goto L_0x008d
            if (r6 != 0) goto L_0x008d
            byte r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L_0x008d
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            r2.<init>()     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0070, all -> 0x006c }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0070, all -> 0x006c }
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
        L_0x0048:
            int r0 = r4.read(r6)     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            if (r0 < 0) goto L_0x0058
            r2.write(r6, r1, r0)     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            goto L_0x0048
        L_0x0052:
            r5 = move-exception
        L_0x0053:
            r0 = r2
            goto L_0x0083
        L_0x0055:
            r6 = move-exception
        L_0x0056:
            r0 = r2
            goto L_0x007b
        L_0x0058:
            byte[] r5 = r2.toByteArray()     // Catch:{ IOException -> 0x0055, all -> 0x0052 }
            r2.close()     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            r4.close()     // Catch:{ Exception -> 0x0062 }
        L_0x0062:
            r3.close()     // Catch:{ Exception -> 0x008d }
            goto L_0x008d
        L_0x0066:
            r5 = move-exception
            r4 = r0
            goto L_0x0053
        L_0x0069:
            r6 = move-exception
            r4 = r0
            goto L_0x0056
        L_0x006c:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x0053
        L_0x0070:
            r6 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x0056
        L_0x0074:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x0083
        L_0x0078:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L_0x007b:
            r6.printStackTrace()     // Catch:{ all -> 0x0082 }
            r0.close()     // Catch:{ Exception -> 0x005f }
            goto L_0x005f
        L_0x0082:
            r5 = move-exception
        L_0x0083:
            r0.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            r4.close()     // Catch:{ Exception -> 0x0089 }
        L_0x0089:
            r3.close()     // Catch:{ Exception -> 0x008c }
        L_0x008c:
            throw r5
        L_0x008d:
            return r5
        L_0x008e:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Input string was null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.plist.Base64.f(java.lang.String, int):byte[]");
    }

    public static byte[] g(byte[] bArr) throws IOException {
        return h(bArr, 0, bArr.length, 0);
    }

    public static byte[] h(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        } else if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
        } else if (i3 == 0) {
            return new byte[0];
        } else {
            if (i3 >= 4) {
                byte[] E = E(i4);
                byte[] bArr2 = new byte[((i3 * 3) / 4)];
                byte[] bArr3 = new byte[4];
                int i6 = 0;
                int i7 = 0;
                while (i2 < i5) {
                    byte b2 = bArr[i2];
                    byte b3 = E[b2 & 255];
                    if (b3 >= -5) {
                        if (b3 >= -1) {
                            int i8 = i6 + 1;
                            bArr3[i6] = b2;
                            if (i8 > 3) {
                                i7 += i(bArr3, 0, bArr2, i7, i4);
                                if (bArr[i2] == 61) {
                                    break;
                                }
                                i6 = 0;
                            } else {
                                i6 = i8;
                            }
                        }
                        i2++;
                    } else {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[]{Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)}));
                    }
                }
                byte[] bArr4 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr4, 0, i7);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
    }

    /* access modifiers changed from: private */
    public static int i(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        } else if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        } else if (i2 < 0 || (i5 = i2 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2)}));
        } else if (i3 < 0 || (i6 = i3 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i3)}));
        } else {
            byte[] E = E(i4);
            byte b2 = bArr[i2 + 2];
            if (b2 == 61) {
                bArr2[i3] = (byte) ((((E[bArr[i2 + 1]] & 255) << 12) | ((E[bArr[i2]] & 255) << 18)) >>> 16);
                return 1;
            }
            byte b3 = bArr[i5];
            if (b3 == 61) {
                int i7 = ((E[bArr[i2 + 1]] & 255) << 12) | ((E[bArr[i2]] & 255) << 18) | ((E[b2] & 255) << 6);
                bArr2[i3] = (byte) (i7 >>> 16);
                bArr2[i3 + 1] = (byte) (i7 >>> 8);
                return 2;
            }
            byte b4 = ((E[bArr[i2 + 1]] & 255) << 12) | ((E[bArr[i2]] & 255) << 18) | ((E[b2] & 255) << 6) | (E[b3] & 255);
            bArr2[i3] = (byte) (b4 >> 16);
            bArr2[i3 + 1] = (byte) (b4 >> 8);
            bArr2[i6] = (byte) b4;
            return 3;
        }
    }

    public static void j(String str, String str2) throws IOException {
        byte[] k2 = k(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(k2);
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static byte[] k(String str) throws IOException {
        InputStream inputStream = null;
        try {
            File file = new File(str);
            if (file.length() <= 2147483647L) {
                byte[] bArr = new byte[((int) file.length())];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                int i2 = 0;
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        e = e2;
                        inputStream = inputStream2;
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            }
            throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static void l(String str, String str2) throws IOException {
        OutputStream outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str2), 0);
            try {
                outputStream2.write(str.getBytes("US-ASCII"));
                try {
                    outputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                outputStream = outputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static Object m(String str) throws IOException, ClassNotFoundException {
        return n(str, 0, (ClassLoader) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|(2:4|5)(1:13)|6|14|15|16|17|18|19) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0040 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object n(java.lang.String r1, int r2, final java.lang.ClassLoader r3) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            byte[] r1 = f(r1, r2)
            r2 = 0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0036, ClassNotFoundException -> 0x0033, all -> 0x0030 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0036, ClassNotFoundException -> 0x0033, all -> 0x0030 }
            if (r3 != 0) goto L_0x001f
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x001b, ClassNotFoundException -> 0x0017, all -> 0x0013 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x001b, ClassNotFoundException -> 0x0017, all -> 0x0013 }
        L_0x0011:
            r2 = r1
            goto L_0x0025
        L_0x0013:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x003d
        L_0x0017:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0039
        L_0x001b:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x003c
        L_0x001f:
            com.dd.plist.Base64$1 r1 = new com.dd.plist.Base64$1     // Catch:{ IOException -> 0x001b, ClassNotFoundException -> 0x0017, all -> 0x0013 }
            r1.<init>(r0, r3)     // Catch:{ IOException -> 0x001b, ClassNotFoundException -> 0x0017, all -> 0x0013 }
            goto L_0x0011
        L_0x0025:
            java.lang.Object r1 = r2.readObject()     // Catch:{ IOException -> 0x001b, ClassNotFoundException -> 0x0017, all -> 0x0013 }
            r0.close()     // Catch:{ Exception -> 0x002c }
        L_0x002c:
            r2.close()     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            return r1
        L_0x0030:
            r1 = move-exception
            r3 = r2
            goto L_0x003d
        L_0x0033:
            r1 = move-exception
            r3 = r2
            goto L_0x0039
        L_0x0036:
            r1 = move-exception
            r3 = r2
            goto L_0x003c
        L_0x0039:
            throw r1     // Catch:{ all -> 0x003a }
        L_0x003a:
            r1 = move-exception
            goto L_0x003d
        L_0x003c:
            throw r1     // Catch:{ all -> 0x003a }
        L_0x003d:
            r2.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            r3.close()     // Catch:{ Exception -> 0x0043 }
        L_0x0043:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.plist.Base64.n(java.lang.String, int, java.lang.ClassLoader):java.lang.Object");
    }

    public static void o(java.nio.ByteBuffer byteBuffer, java.nio.ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            r(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static void p(java.nio.ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            r(bArr2, bArr, min, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & 255));
            }
        }
    }

    /* access modifiers changed from: private */
    public static byte[] q(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] D = D(i5);
        int i6 = 0;
        int i7 = (i3 > 0 ? (bArr[i2] << Ascii.B) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << Ascii.B) >>> 16 : 0);
        if (i3 > 2) {
            i6 = (bArr[i2 + 2] << Ascii.B) >>> 24;
        }
        int i8 = i7 | i6;
        if (i3 == 1) {
            bArr2[i4] = D[i8 >>> 18];
            bArr2[i4 + 1] = D[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 == 2) {
            bArr2[i4] = D[i8 >>> 18];
            bArr2[i4 + 1] = D[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = D[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 != 3) {
            return bArr2;
        } else {
            bArr2[i4] = D[i8 >>> 18];
            bArr2[i4 + 1] = D[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = D[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = D[i8 & 63];
            return bArr2;
        }
    }

    /* access modifiers changed from: private */
    public static byte[] r(byte[] bArr, byte[] bArr2, int i2, int i3) {
        q(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    public static String s(byte[] bArr) {
        try {
            return v(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String t(byte[] bArr, int i2) throws IOException {
        return v(bArr, 0, bArr.length, i2);
    }

    public static String u(byte[] bArr, int i2, int i3) {
        try {
            return v(bArr, i2, i3, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String v(byte[] bArr, int i2, int i3, int i4) throws IOException {
        byte[] x = x(bArr, i2, i3, i4);
        try {
            return new String(x, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(x);
        }
    }

    public static byte[] w(byte[] bArr) {
        try {
            return x(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:26|27|45|46|47|48|49|50|51) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0036 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0061 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0064 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] x(byte[] r19, int r20, int r21, int r22) throws java.io.IOException {
        /*
            r0 = r19
            r7 = r20
            r8 = r21
            r9 = 76
            r11 = 4
            r12 = 1
            r1 = 2
            r13 = 3
            if (r0 == 0) goto L_0x012d
            if (r7 < 0) goto L_0x0116
            if (r8 < 0) goto L_0x00ff
            int r2 = r7 + r8
            int r3 = r0.length
            if (r2 > r3) goto L_0x00dc
            r2 = r22 & 2
            if (r2 == 0) goto L_0x0068
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0057, all -> 0x0053 }
            r2.<init>()     // Catch:{ IOException -> 0x0057, all -> 0x0053 }
            com.dd.plist.Base64$OutputStream r3 = new com.dd.plist.Base64$OutputStream     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r4 = r22 | 1
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0049, all -> 0x0047 }
            r4.write(r0, r7, r8)     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r4.close()     // Catch:{ IOException -> 0x0044, all -> 0x0041 }
            r4.close()     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            r3.close()     // Catch:{ Exception -> 0x0039 }
        L_0x0039:
            r2.close()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            byte[] r0 = r2.toByteArray()
            return r0
        L_0x0041:
            r0 = move-exception
        L_0x0042:
            r1 = r4
            goto L_0x005e
        L_0x0044:
            r0 = move-exception
        L_0x0045:
            r1 = r2
            goto L_0x005a
        L_0x0047:
            r0 = move-exception
            goto L_0x005e
        L_0x0049:
            r0 = move-exception
            r4 = r1
            goto L_0x0045
        L_0x004c:
            r0 = move-exception
            r3 = r1
            goto L_0x005e
        L_0x004f:
            r0 = move-exception
            r3 = r1
            r4 = r3
            goto L_0x0045
        L_0x0053:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x005e
        L_0x0057:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x005a:
            throw r0     // Catch:{ all -> 0x005b }
        L_0x005b:
            r0 = move-exception
            r2 = r1
            goto L_0x0042
        L_0x005e:
            r1.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            r3.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            r2.close()     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            throw r0
        L_0x0068:
            r2 = r22 & 8
            if (r2 == 0) goto L_0x006e
            r14 = 1
            goto L_0x006f
        L_0x006e:
            r14 = 0
        L_0x006f:
            int r2 = r8 / 3
            int r2 = r2 * 4
            int r3 = r8 % 3
            if (r3 <= 0) goto L_0x0079
            r3 = 4
            goto L_0x007a
        L_0x0079:
            r3 = 0
        L_0x007a:
            int r2 = r2 + r3
            if (r14 == 0) goto L_0x0080
            int r3 = r2 / 76
            int r2 = r2 + r3
        L_0x0080:
            r15 = r2
            byte[] r6 = new byte[r15]
            int r5 = r8 + -2
            r4 = 0
            r16 = 0
            r17 = 0
        L_0x008a:
            if (r4 >= r5) goto L_0x00bb
            int r2 = r4 + r7
            r3 = 3
            r1 = r19
            r10 = r4
            r4 = r6
            r18 = r5
            r5 = r16
            r13 = r6
            r6 = r22
            q(r1, r2, r3, r4, r5, r6)
            int r1 = r17 + 4
            if (r14 == 0) goto L_0x00af
            if (r1 < r9) goto L_0x00af
            int r1 = r16 + 4
            r2 = 10
            r13[r1] = r2
            int r16 = r16 + 1
            r1 = 3
            r17 = 0
            goto L_0x00b2
        L_0x00af:
            r17 = r1
            r1 = 3
        L_0x00b2:
            int r4 = r10 + 3
            int r16 = r16 + 4
            r6 = r13
            r5 = r18
            r13 = 3
            goto L_0x008a
        L_0x00bb:
            r10 = r4
            r13 = r6
            if (r10 >= r8) goto L_0x00cf
            int r2 = r10 + r7
            int r3 = r8 - r10
            r1 = r19
            r4 = r13
            r5 = r16
            r6 = r22
            q(r1, r2, r3, r4, r5, r6)
            int r16 = r16 + 4
        L_0x00cf:
            r0 = r16
            int r15 = r15 - r12
            if (r0 > r15) goto L_0x00db
            byte[] r1 = new byte[r0]
            r2 = 0
            java.lang.System.arraycopy(r13, r2, r1, r2, r0)
            return r1
        L_0x00db:
            return r13
        L_0x00dc:
            r2 = 0
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.Integer r4 = java.lang.Integer.valueOf(r20)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r21)
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r4
            r6[r12] = r5
            r6[r1] = r0
            java.lang.String r0 = "Cannot have offset of %d and length of %d with array of length %d"
            java.lang.String r0 = java.lang.String.format(r0, r6)
            r3.<init>(r0)
            throw r3
        L_0x00ff:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have length offset: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0116:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have negative offset: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x012d:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Cannot serialize a null array."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.plist.Base64.x(byte[], int, int, int):byte[]");
    }

    public static void y(String str, String str2) throws IOException {
        String z = z(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(z.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }

    public static String z(String str) throws IOException {
        InputStream inputStream = null;
        try {
            File file = new File(str);
            byte[] bArr = new byte[Math.max((int) ((((double) file.length()) * 1.4d) + 1.0d), 40)];
            InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
            int i2 = 0;
            while (true) {
                try {
                    int read = inputStream2.read(bArr, i2, 4096);
                    if (read < 0) {
                        break;
                    }
                    i2 += read;
                } catch (IOException e2) {
                    e = e2;
                    inputStream = inputStream2;
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i2, "US-ASCII");
            try {
                inputStream2.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (IOException e3) {
            e = e3;
            throw e;
        }
    }
}

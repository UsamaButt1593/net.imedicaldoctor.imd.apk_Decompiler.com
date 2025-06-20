package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: b  reason: collision with root package name */
    private static final String f18250b = "DfltImageHeaderParser";

    /* renamed from: c  reason: collision with root package name */
    private static final int f18251c = 4671814;

    /* renamed from: d  reason: collision with root package name */
    private static final int f18252d = -1991225785;

    /* renamed from: e  reason: collision with root package name */
    static final int f18253e = 65496;

    /* renamed from: f  reason: collision with root package name */
    private static final int f18254f = 19789;

    /* renamed from: g  reason: collision with root package name */
    private static final int f18255g = 18761;

    /* renamed from: h  reason: collision with root package name */
    private static final String f18256h = "Exif\u0000\u0000";

    /* renamed from: i  reason: collision with root package name */
    static final byte[] f18257i = f18256h.getBytes(Charset.forName("UTF-8"));

    /* renamed from: j  reason: collision with root package name */
    private static final int f18258j = 218;

    /* renamed from: k  reason: collision with root package name */
    private static final int f18259k = 217;

    /* renamed from: l  reason: collision with root package name */
    static final int f18260l = 255;

    /* renamed from: m  reason: collision with root package name */
    static final int f18261m = 225;

    /* renamed from: n  reason: collision with root package name */
    private static final int f18262n = 274;
    private static final int[] o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final int p = 1380533830;
    private static final int q = 1464156752;
    private static final int r = 1448097792;
    private static final int s = -256;
    private static final int t = 255;
    private static final int u = 88;
    private static final int v = 76;
    private static final int w = 16;
    private static final int x = 8;

    private static final class ByteBufferReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f18263a;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.f18263a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() throws Reader.EndOfFileException {
            return (c() << 8) | c();
        }

        public int b(byte[] bArr, int i2) {
            int min = Math.min(i2, this.f18263a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f18263a.get(bArr, 0, min);
            return min;
        }

        public short c() throws Reader.EndOfFileException {
            if (this.f18263a.remaining() >= 1) {
                return (short) (this.f18263a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j2) {
            int min = (int) Math.min((long) this.f18263a.remaining(), j2);
            ByteBuffer byteBuffer = this.f18263a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    private static final class RandomAccessReader {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f18264a;

        RandomAccessReader(byte[] bArr, int i2) {
            this.f18264a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        private boolean c(int i2, int i3) {
            return this.f18264a.remaining() - i2 >= i3;
        }

        /* access modifiers changed from: package-private */
        public short a(int i2) {
            if (c(i2, 2)) {
                return this.f18264a.getShort(i2);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int b(int i2) {
            if (c(i2, 4)) {
                return this.f18264a.getInt(i2);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.f18264a.remaining();
        }

        /* access modifiers changed from: package-private */
        public void e(ByteOrder byteOrder) {
            this.f18264a.order(byteOrder);
        }
    }

    private interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long s = 1;

            EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a() throws IOException;

        int b(byte[] bArr, int i2) throws IOException;

        short c() throws IOException;

        long skip(long j2) throws IOException;
    }

    private static final class StreamReader implements Reader {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f18265a;

        StreamReader(InputStream inputStream) {
            this.f18265a = inputStream;
        }

        public int a() throws IOException {
            return (c() << 8) | c();
        }

        public int b(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.f18265a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 != 0 || i4 != -1) {
                return i3;
            }
            throw new Reader.EndOfFileException();
        }

        public short c() throws IOException {
            int read = this.f18265a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        public long skip(long j2) throws IOException {
            if (j2 < 0) {
                return 0;
            }
            long j3 = j2;
            while (j3 > 0) {
                long skip = this.f18265a.skip(j3);
                if (skip <= 0) {
                    if (this.f18265a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j3 -= skip;
            }
            return j2 - j3;
        }
    }

    private static int e(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    private int f(Reader reader, ArrayPool arrayPool) throws IOException {
        byte[] bArr;
        try {
            int a2 = reader.a();
            if (!h(a2)) {
                if (Log.isLoggable(f18250b, 3)) {
                    Log.d(f18250b, "Parser doesn't handle magic number: " + a2);
                }
                return -1;
            }
            int j2 = j(reader);
            if (j2 == -1) {
                if (Log.isLoggable(f18250b, 3)) {
                    Log.d(f18250b, "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            bArr = (byte[]) arrayPool.f(j2, byte[].class);
            int l2 = l(reader, bArr, j2);
            arrayPool.put(bArr);
            return l2;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        } catch (Throwable th) {
            arrayPool.put(bArr);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.load.ImageHeaderParser.ImageType g(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.c()     // Catch:{ EndOfFileException -> 0x0039 }
            r0 = 3
            if (r6 < r0) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ EndOfFileException -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x0039 }
        L_0x0038:
            return r6
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x0044
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0044:
            r0 = 4
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = 1464156752(0x57454250, float:2.16888601E14)
            if (r2 == r3) goto L_0x005c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x005c:
            int r2 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.a()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = r2 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r3 == r4) goto L_0x0071
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0071:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 88
            if (r2 != r3) goto L_0x0088
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 16
            if (r6 == 0) goto L_0x0085
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x0087
        L_0x0085:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x0087:
            return r6
        L_0x0088:
            r3 = 76
            if (r2 != r3) goto L_0x009d
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.c()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 8
            if (r6 == 0) goto L_0x009a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x009c
        L_0x009a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x009c:
            return r6
        L_0x009d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x00a0:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.g(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    private static boolean h(int i2) {
        return (i2 & f18253e) == f18253e || i2 == f18254f || i2 == f18255g;
    }

    private boolean i(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > f18257i.length;
        if (z) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = f18257i;
                if (i3 >= bArr2.length) {
                    break;
                } else if (bArr[i3] != bArr2[i3]) {
                    return false;
                } else {
                    i3++;
                }
            }
        }
        return z;
    }

    private int j(Reader reader) throws IOException {
        short c2;
        int a2;
        long j2;
        long skip;
        do {
            short c3 = reader.c();
            if (c3 != 255) {
                if (Log.isLoggable(f18250b, 3)) {
                    Log.d(f18250b, "Unknown segmentId=" + c3);
                }
                return -1;
            }
            c2 = reader.c();
            if (c2 == f18258j) {
                return -1;
            }
            if (c2 == f18259k) {
                if (Log.isLoggable(f18250b, 3)) {
                    Log.d(f18250b, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = reader.a() - 2;
            if (c2 == f18261m) {
                return a2;
            }
            j2 = (long) a2;
            skip = reader.skip(j2);
        } while (skip == j2);
        if (Log.isLoggable(f18250b, 3)) {
            Log.d(f18250b, "Unable to skip enough data, type: " + c2 + ", wanted to skip: " + a2 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int k(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        StringBuilder sb;
        String str;
        String sb2;
        short a2 = randomAccessReader.a(6);
        if (a2 != f18255g) {
            if (a2 != f18254f && Log.isLoggable(f18250b, 3)) {
                Log.d(f18250b, "Unknown endianness = " + a2);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        randomAccessReader.e(byteOrder);
        int b2 = randomAccessReader.b(10) + 6;
        short a3 = randomAccessReader.a(b2);
        for (int i2 = 0; i2 < a3; i2++) {
            int e2 = e(b2, i2);
            short a4 = randomAccessReader.a(e2);
            if (a4 == 274) {
                short a5 = randomAccessReader.a(e2 + 2);
                if (a5 >= 1 && a5 <= 12) {
                    int b3 = randomAccessReader.b(e2 + 4);
                    if (b3 >= 0) {
                        if (Log.isLoggable(f18250b, 3)) {
                            Log.d(f18250b, "Got tagIndex=" + i2 + " tagType=" + a4 + " formatCode=" + a5 + " componentCount=" + b3);
                        }
                        int i3 = b3 + o[a5];
                        if (i3 <= 4) {
                            int i4 = e2 + 8;
                            if (i4 < 0 || i4 > randomAccessReader.d()) {
                                if (Log.isLoggable(f18250b, 3)) {
                                    sb2 = "Illegal tagValueOffset=" + i4 + " tagType=" + a4;
                                }
                            } else if (i3 >= 0 && i3 + i4 <= randomAccessReader.d()) {
                                return randomAccessReader.a(i4);
                            } else {
                                if (Log.isLoggable(f18250b, 3)) {
                                    sb = new StringBuilder();
                                    sb.append("Illegal number of bytes for TI tag data tagType=");
                                    sb.append(a4);
                                    sb2 = sb.toString();
                                }
                            }
                        } else if (Log.isLoggable(f18250b, 3)) {
                            sb = new StringBuilder();
                            str = "Got byte count > 4, not orientation, continuing, formatCode=";
                            sb.append(str);
                            sb.append(a5);
                            sb2 = sb.toString();
                        }
                    } else if (Log.isLoggable(f18250b, 3)) {
                        sb2 = "Negative tiff component count";
                    }
                } else if (Log.isLoggable(f18250b, 3)) {
                    sb = new StringBuilder();
                    str = "Got invalid format code = ";
                    sb.append(str);
                    sb.append(a5);
                    sb2 = sb.toString();
                }
                Log.d(f18250b, sb2);
            }
        }
        return -1;
    }

    private int l(Reader reader, byte[] bArr, int i2) throws IOException {
        int b2 = reader.b(bArr, i2);
        if (b2 != i2) {
            if (Log.isLoggable(f18250b, 3)) {
                Log.d(f18250b, "Unable to read exif segment data, length: " + i2 + ", actually read: " + b2);
            }
            return -1;
        } else if (i(bArr, i2)) {
            return k(new RandomAccessReader(bArr, i2));
        } else {
            if (Log.isLoggable(f18250b, 3)) {
                Log.d(f18250b, "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException {
        return g(new ByteBufferReader((ByteBuffer) Preconditions.d(byteBuffer)));
    }

    public int b(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException {
        return f(new ByteBufferReader((ByteBuffer) Preconditions.d(byteBuffer)), (ArrayPool) Preconditions.d(arrayPool));
    }

    @NonNull
    public ImageHeaderParser.ImageType c(@NonNull InputStream inputStream) throws IOException {
        return g(new StreamReader((InputStream) Preconditions.d(inputStream)));
    }

    public int d(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        return f(new StreamReader((InputStream) Preconditions.d(inputStream)), (ArrayPool) Preconditions.d(arrayPool));
    }
}

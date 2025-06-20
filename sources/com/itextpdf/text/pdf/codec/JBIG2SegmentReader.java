package com.itextpdf.text.pdf.codec;

import com.google.common.base.Ascii;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import net.lingala.zip4j.util.InternalZipConstants;

public class JBIG2SegmentReader {
    public static final int A = 52;
    public static final int B = 53;
    public static final int C = 62;

    /* renamed from: i  reason: collision with root package name */
    public static final int f26586i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f26587j = 4;

    /* renamed from: k  reason: collision with root package name */
    public static final int f26588k = 6;

    /* renamed from: l  reason: collision with root package name */
    public static final int f26589l = 7;

    /* renamed from: m  reason: collision with root package name */
    public static final int f26590m = 16;

    /* renamed from: n  reason: collision with root package name */
    public static final int f26591n = 20;
    public static final int o = 22;
    public static final int p = 23;
    public static final int q = 36;
    public static final int r = 38;
    public static final int s = 39;
    public static final int t = 40;
    public static final int u = 42;
    public static final int v = 43;
    public static final int w = 48;
    public static final int x = 49;
    public static final int y = 50;
    public static final int z = 51;

    /* renamed from: a  reason: collision with root package name */
    private final SortedMap<Integer, JBIG2Segment> f26592a = new TreeMap();

    /* renamed from: b  reason: collision with root package name */
    private final SortedMap<Integer, JBIG2Page> f26593b = new TreeMap();

    /* renamed from: c  reason: collision with root package name */
    private final SortedSet<JBIG2Segment> f26594c = new TreeSet();

    /* renamed from: d  reason: collision with root package name */
    private RandomAccessFileOrArray f26595d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26596e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26597f;

    /* renamed from: g  reason: collision with root package name */
    private int f26598g = -1;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26599h = false;

    public static class JBIG2Page {

        /* renamed from: a  reason: collision with root package name */
        public final int f26600a;

        /* renamed from: b  reason: collision with root package name */
        private final JBIG2SegmentReader f26601b;

        /* renamed from: c  reason: collision with root package name */
        private final SortedMap<Integer, JBIG2Segment> f26602c = new TreeMap();

        /* renamed from: d  reason: collision with root package name */
        public int f26603d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f26604e = -1;

        public JBIG2Page(int i2, JBIG2SegmentReader jBIG2SegmentReader) {
            this.f26600a = i2;
            this.f26601b = jBIG2SegmentReader;
        }

        public void a(JBIG2Segment jBIG2Segment) {
            this.f26602c.put(Integer.valueOf(jBIG2Segment.s), jBIG2Segment);
        }

        public byte[] b(boolean z) throws IOException {
            int i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (Integer num : this.f26602c.keySet()) {
                JBIG2Segment jBIG2Segment = this.f26602c.get(num);
                if (!z || !((i2 = jBIG2Segment.Y2) == 51 || i2 == 49)) {
                    byte[] bArr = jBIG2Segment.c3;
                    if (z) {
                        byte[] a2 = JBIG2SegmentReader.a(bArr);
                        if (jBIG2Segment.d3) {
                            int i3 = jBIG2Segment.e3;
                            a2[i3] = 0;
                            a2[i3 + 1] = 0;
                            a2[i3 + 2] = 0;
                            a2[i3 + 3] = 1;
                        } else {
                            a2[jBIG2Segment.e3] = 1;
                        }
                        byteArrayOutputStream.write(a2);
                    } else {
                        byteArrayOutputStream.write(bArr);
                    }
                    byteArrayOutputStream.write(jBIG2Segment.b3);
                }
            }
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static class JBIG2Segment implements Comparable<JBIG2Segment> {
        public long X = -1;
        public boolean[] X2 = null;
        public int Y = -1;
        public int Y2 = -1;
        public int[] Z = null;
        public boolean Z2 = false;
        public int a3 = -1;
        public byte[] b3 = null;
        public byte[] c3 = null;
        public boolean d3 = false;
        public int e3 = -1;
        public final int s;

        public JBIG2Segment(int i2) {
            this.s = i2;
        }

        /* renamed from: a */
        public int compareTo(JBIG2Segment jBIG2Segment) {
            return this.s - jBIG2Segment.s;
        }
    }

    public JBIG2SegmentReader(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        this.f26595d = randomAccessFileOrArray;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public byte[] b(boolean z2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (JBIG2Segment next : this.f26594c) {
                if (z2) {
                    int i2 = next.Y2;
                    if (i2 != 51) {
                        if (i2 == 49) {
                        }
                    }
                }
                byteArrayOutputStream.write(next.c3);
                byteArrayOutputStream.write(next.b3);
            }
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (byteArrayOutputStream.size() <= 0) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public JBIG2Page c(int i2) {
        return this.f26593b.get(Integer.valueOf(i2));
    }

    public int d(int i2) {
        return this.f26593b.get(Integer.valueOf(i2)).f26604e;
    }

    public int e(int i2) {
        return this.f26593b.get(Integer.valueOf(i2)).f26603d;
    }

    public int f() {
        return this.f26593b.size();
    }

    public void g() throws IOException {
        JBIG2Segment i2;
        if (!this.f26599h) {
            this.f26599h = true;
            h();
            if (this.f26596e) {
                do {
                    JBIG2Segment i3 = i();
                    j(i3);
                    this.f26592a.put(Integer.valueOf(i3.s), i3);
                } while (this.f26595d.d() < this.f26595d.e());
                return;
            }
            do {
                i2 = i();
                this.f26592a.put(Integer.valueOf(i2.s), i2);
            } while (i2.Y2 != 51);
            for (Integer num : this.f26592a.keySet()) {
                j(this.f26592a.get(num));
            }
            return;
        }
        throw new IllegalStateException(MessageLocalization.b("already.attempted.a.read.on.this.jbig2.file", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void h() throws IOException {
        boolean z2 = true;
        this.f26595d.r(0);
        byte[] bArr = new byte[8];
        this.f26595d.read(bArr);
        byte[] bArr2 = {-105, 74, 66, 50, 13, 10, Ascii.D, 10};
        int i2 = 0;
        while (i2 < 8) {
            if (bArr[i2] == bArr2[i2]) {
                i2++;
            } else {
                throw new IllegalStateException(MessageLocalization.a("file.header.idstring.not.good.at.byte.1", i2));
            }
        }
        int read = this.f26595d.read();
        this.f26596e = (read & 1) == 1;
        if ((read & 2) != 0) {
            z2 = false;
        }
        this.f26597f = z2;
        if ((read & 252) != 0) {
            throw new IllegalStateException(MessageLocalization.b("file.header.flags.bits.2.7.not.0", new Object[0]));
        } else if (z2) {
            this.f26598g = this.f26595d.readInt();
        }
    }

    /* access modifiers changed from: package-private */
    public JBIG2Segment i() throws IOException {
        boolean[] zArr;
        int d2 = (int) this.f26595d.d();
        int readInt = this.f26595d.readInt();
        JBIG2Segment jBIG2Segment = new JBIG2Segment(readInt);
        int read = this.f26595d.read();
        jBIG2Segment.Z2 = (read & 128) == 128;
        boolean z2 = (read & 64) == 64;
        jBIG2Segment.Y2 = read & 63;
        int read2 = this.f26595d.read();
        int i2 = (read2 & 224) >> 5;
        if (i2 == 7) {
            RandomAccessFileOrArray randomAccessFileOrArray = this.f26595d;
            randomAccessFileOrArray.r(randomAccessFileOrArray.d() - 1);
            int readInt2 = this.f26595d.readInt() & 536870911;
            zArr = new boolean[(readInt2 + 1)];
            int i3 = 0;
            int i4 = 0;
            do {
                int i5 = i3 % 8;
                if (i5 == 0) {
                    i4 = this.f26595d.read();
                }
                zArr[i3] = (((1 << i5) & i4) >> i5) == 1;
                i3++;
            } while (i3 <= readInt2);
            i2 = readInt2;
        } else if (i2 <= 4) {
            zArr = new boolean[(i2 + 1)];
            int i6 = read2 & 31;
            for (int i7 = 0; i7 <= i2; i7++) {
                zArr[i7] = (((1 << i7) & i6) >> i7) == 1;
            }
        } else if (i2 == 5 || i2 == 6) {
            throw new IllegalStateException(MessageLocalization.b("count.of.referred.to.segments.had.bad.value.in.header.for.segment.1.starting.at.2", String.valueOf(readInt), String.valueOf(d2)));
        } else {
            zArr = null;
        }
        jBIG2Segment.X2 = zArr;
        jBIG2Segment.a3 = i2;
        int[] iArr = new int[(i2 + 1)];
        for (int i8 = 1; i8 <= i2; i8++) {
            if (readInt <= 256) {
                iArr[i8] = this.f26595d.read();
            } else if (readInt <= 65536) {
                iArr[i8] = this.f26595d.readUnsignedShort();
            } else {
                iArr[i8] = (int) this.f26595d.o();
            }
        }
        jBIG2Segment.Z = iArr;
        int d3 = ((int) this.f26595d.d()) - d2;
        RandomAccessFileOrArray randomAccessFileOrArray2 = this.f26595d;
        int readInt3 = z2 ? randomAccessFileOrArray2.readInt() : randomAccessFileOrArray2.read();
        if (readInt3 >= 0) {
            jBIG2Segment.Y = readInt3;
            jBIG2Segment.d3 = z2;
            jBIG2Segment.e3 = d3;
            if (readInt3 > 0 && !this.f26593b.containsKey(Integer.valueOf(readInt3))) {
                this.f26593b.put(Integer.valueOf(readInt3), new JBIG2Page(readInt3, this));
            }
            if (readInt3 > 0) {
                this.f26593b.get(Integer.valueOf(readInt3)).a(jBIG2Segment);
            } else {
                this.f26594c.add(jBIG2Segment);
            }
            jBIG2Segment.X = this.f26595d.o();
            int d4 = (int) this.f26595d.d();
            this.f26595d.r((long) d2);
            byte[] bArr = new byte[(d4 - d2)];
            this.f26595d.read(bArr);
            jBIG2Segment.c3 = bArr;
            return jBIG2Segment;
        }
        throw new IllegalStateException(MessageLocalization.b("page.1.invalid.for.segment.2.starting.at.3", String.valueOf(readInt3), String.valueOf(readInt), String.valueOf(d2)));
    }

    /* access modifiers changed from: package-private */
    public void j(JBIG2Segment jBIG2Segment) throws IOException {
        int d2 = (int) this.f26595d.d();
        long j2 = jBIG2Segment.X;
        if (j2 != InternalZipConstants.f30717k) {
            byte[] bArr = new byte[((int) j2)];
            this.f26595d.read(bArr);
            jBIG2Segment.b3 = bArr;
            if (jBIG2Segment.Y2 == 48) {
                int d3 = (int) this.f26595d.d();
                this.f26595d.r((long) d2);
                int readInt = this.f26595d.readInt();
                int readInt2 = this.f26595d.readInt();
                this.f26595d.r((long) d3);
                JBIG2Page jBIG2Page = this.f26593b.get(Integer.valueOf(jBIG2Segment.Y));
                if (jBIG2Page != null) {
                    jBIG2Page.f26603d = readInt;
                    jBIG2Page.f26604e = readInt2;
                    return;
                }
                throw new IllegalStateException(MessageLocalization.a("referring.to.widht.height.of.page.we.havent.seen.yet.1", jBIG2Segment.Y));
            }
        }
    }

    public String toString() {
        if (!this.f26599h) {
            return "Jbig2SegmentReader in indeterminate state.";
        }
        return "Jbig2SegmentReader: number of pages: " + f();
    }
}

package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.upstream.Allocation;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

class SampleDataQueue {

    /* renamed from: h  reason: collision with root package name */
    private static final int f12202h = 32;

    /* renamed from: a  reason: collision with root package name */
    private final Allocator f12203a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12204b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f12205c = new ParsableByteArray(32);

    /* renamed from: d  reason: collision with root package name */
    private AllocationNode f12206d;

    /* renamed from: e  reason: collision with root package name */
    private AllocationNode f12207e;

    /* renamed from: f  reason: collision with root package name */
    private AllocationNode f12208f;

    /* renamed from: g  reason: collision with root package name */
    private long f12209g;

    private static final class AllocationNode implements Allocator.AllocationNode {

        /* renamed from: a  reason: collision with root package name */
        public long f12210a;

        /* renamed from: b  reason: collision with root package name */
        public long f12211b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public Allocation f12212c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public AllocationNode f12213d;

        public AllocationNode(long j2, int i2) {
            d(j2, i2);
        }

        public Allocation a() {
            return (Allocation) Assertions.g(this.f12212c);
        }

        public AllocationNode b() {
            this.f12212c = null;
            AllocationNode allocationNode = this.f12213d;
            this.f12213d = null;
            return allocationNode;
        }

        public void c(Allocation allocation, AllocationNode allocationNode) {
            this.f12212c = allocation;
            this.f12213d = allocationNode;
        }

        public void d(long j2, int i2) {
            Assertions.i(this.f12212c == null);
            this.f12210a = j2;
            this.f12211b = j2 + ((long) i2);
        }

        public int e(long j2) {
            return ((int) (j2 - this.f12210a)) + this.f12212c.f12432b;
        }

        @Nullable
        public Allocator.AllocationNode next() {
            AllocationNode allocationNode = this.f12213d;
            if (allocationNode == null || allocationNode.f12212c == null) {
                return null;
            }
            return allocationNode;
        }
    }

    public SampleDataQueue(Allocator allocator) {
        this.f12203a = allocator;
        int f2 = allocator.f();
        this.f12204b = f2;
        AllocationNode allocationNode = new AllocationNode(0, f2);
        this.f12206d = allocationNode;
        this.f12207e = allocationNode;
        this.f12208f = allocationNode;
    }

    private void a(AllocationNode allocationNode) {
        if (allocationNode.f12212c != null) {
            this.f12203a.a(allocationNode);
            allocationNode.b();
        }
    }

    private static AllocationNode d(AllocationNode allocationNode, long j2) {
        while (j2 >= allocationNode.f12211b) {
            allocationNode = allocationNode.f12213d;
        }
        return allocationNode;
    }

    private void g(int i2) {
        long j2 = this.f12209g + ((long) i2);
        this.f12209g = j2;
        AllocationNode allocationNode = this.f12208f;
        if (j2 == allocationNode.f12211b) {
            this.f12208f = allocationNode.f12213d;
        }
    }

    private int h(int i2) {
        AllocationNode allocationNode = this.f12208f;
        if (allocationNode.f12212c == null) {
            allocationNode.c(this.f12203a.b(), new AllocationNode(this.f12208f.f12211b, this.f12204b));
        }
        return Math.min(i2, (int) (this.f12208f.f12211b - this.f12209g));
    }

    private static AllocationNode i(AllocationNode allocationNode, long j2, ByteBuffer byteBuffer, int i2) {
        AllocationNode d2 = d(allocationNode, j2);
        while (i2 > 0) {
            int min = Math.min(i2, (int) (d2.f12211b - j2));
            byteBuffer.put(d2.f12212c.f12431a, d2.e(j2), min);
            i2 -= min;
            j2 += (long) min;
            if (j2 == d2.f12211b) {
                d2 = d2.f12213d;
            }
        }
        return d2;
    }

    private static AllocationNode j(AllocationNode allocationNode, long j2, byte[] bArr, int i2) {
        AllocationNode d2 = d(allocationNode, j2);
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, (int) (d2.f12211b - j2));
            System.arraycopy(d2.f12212c.f12431a, d2.e(j2), bArr, i2 - i3, min);
            i3 -= min;
            j2 += (long) min;
            if (j2 == d2.f12211b) {
                d2 = d2.f12213d;
            }
        }
        return d2;
    }

    private static AllocationNode k(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        int i2;
        SampleQueue.SampleExtrasHolder sampleExtrasHolder2 = sampleExtrasHolder;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        long j2 = sampleExtrasHolder2.f12226b;
        parsableByteArray2.U(1);
        AllocationNode j3 = j(allocationNode, j2, parsableByteArray.e(), 1);
        long j4 = j2 + 1;
        byte b2 = parsableByteArray.e()[0];
        boolean z = (b2 & 128) != 0;
        byte b3 = b2 & Byte.MAX_VALUE;
        CryptoInfo cryptoInfo = decoderInputBuffer.Y;
        byte[] bArr = cryptoInfo.f10051a;
        if (bArr == null) {
            cryptoInfo.f10051a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        AllocationNode j5 = j(j3, j4, cryptoInfo.f10051a, b3);
        long j6 = j4 + ((long) b3);
        if (z) {
            parsableByteArray2.U(2);
            j5 = j(j5, j6, parsableByteArray.e(), 2);
            j6 += 2;
            i2 = parsableByteArray.R();
        } else {
            i2 = 1;
        }
        int[] iArr = cryptoInfo.f10054d;
        if (iArr == null || iArr.length < i2) {
            iArr = new int[i2];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo.f10055e;
        if (iArr3 == null || iArr3.length < i2) {
            iArr3 = new int[i2];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i2 * 6;
            parsableByteArray2.U(i3);
            j5 = j(j5, j6, parsableByteArray.e(), i3);
            j6 += (long) i3;
            parsableByteArray2.Y(0);
            for (int i4 = 0; i4 < i2; i4++) {
                iArr2[i4] = parsableByteArray.R();
                iArr4[i4] = parsableByteArray.P();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder2.f12225a - ((int) (j6 - sampleExtrasHolder2.f12226b));
        }
        TrackOutput.CryptoData cryptoData = (TrackOutput.CryptoData) Util.o(sampleExtrasHolder2.f12227c);
        cryptoInfo.c(i2, iArr2, iArr4, cryptoData.f13136b, cryptoInfo.f10051a, cryptoData.f13135a, cryptoData.f13137c, cryptoData.f13138d);
        long j7 = sampleExtrasHolder2.f12226b;
        int i5 = (int) (j6 - j7);
        sampleExtrasHolder2.f12226b = j7 + ((long) i5);
        sampleExtrasHolder2.f12225a -= i5;
        return j5;
    }

    private static AllocationNode l(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        long j2;
        ByteBuffer byteBuffer;
        if (decoderInputBuffer.u()) {
            allocationNode = k(allocationNode, decoderInputBuffer, sampleExtrasHolder, parsableByteArray);
        }
        if (decoderInputBuffer.j()) {
            parsableByteArray.U(4);
            AllocationNode j3 = j(allocationNode, sampleExtrasHolder.f12226b, parsableByteArray.e(), 4);
            int P = parsableByteArray.P();
            sampleExtrasHolder.f12226b += 4;
            sampleExtrasHolder.f12225a -= 4;
            decoderInputBuffer.r(P);
            allocationNode = i(j3, sampleExtrasHolder.f12226b, decoderInputBuffer.Z, P);
            sampleExtrasHolder.f12226b += (long) P;
            int i2 = sampleExtrasHolder.f12225a - P;
            sampleExtrasHolder.f12225a = i2;
            decoderInputBuffer.w(i2);
            j2 = sampleExtrasHolder.f12226b;
            byteBuffer = decoderInputBuffer.Z2;
        } else {
            decoderInputBuffer.r(sampleExtrasHolder.f12225a);
            j2 = sampleExtrasHolder.f12226b;
            byteBuffer = decoderInputBuffer.Z;
        }
        return i(allocationNode, j2, byteBuffer, sampleExtrasHolder.f12225a);
    }

    public void b(long j2) {
        AllocationNode allocationNode;
        if (j2 != -1) {
            while (true) {
                allocationNode = this.f12206d;
                if (j2 < allocationNode.f12211b) {
                    break;
                }
                this.f12203a.c(allocationNode.f12212c);
                this.f12206d = this.f12206d.b();
            }
            if (this.f12207e.f12210a < allocationNode.f12210a) {
                this.f12207e = allocationNode;
            }
        }
    }

    public void c(long j2) {
        Assertions.a(j2 <= this.f12209g);
        this.f12209g = j2;
        if (j2 != 0) {
            AllocationNode allocationNode = this.f12206d;
            if (j2 != allocationNode.f12210a) {
                while (this.f12209g > allocationNode.f12211b) {
                    allocationNode = allocationNode.f12213d;
                }
                AllocationNode allocationNode2 = (AllocationNode) Assertions.g(allocationNode.f12213d);
                a(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.f12211b, this.f12204b);
                allocationNode.f12213d = allocationNode3;
                if (this.f12209g == allocationNode.f12211b) {
                    allocationNode = allocationNode3;
                }
                this.f12208f = allocationNode;
                if (this.f12207e == allocationNode2) {
                    this.f12207e = allocationNode3;
                    return;
                }
                return;
            }
        }
        a(this.f12206d);
        AllocationNode allocationNode4 = new AllocationNode(this.f12209g, this.f12204b);
        this.f12206d = allocationNode4;
        this.f12207e = allocationNode4;
        this.f12208f = allocationNode4;
    }

    public long e() {
        return this.f12209g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        l(this.f12207e, decoderInputBuffer, sampleExtrasHolder, this.f12205c);
    }

    public void m(DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder) {
        this.f12207e = l(this.f12207e, decoderInputBuffer, sampleExtrasHolder, this.f12205c);
    }

    public void n() {
        a(this.f12206d);
        this.f12206d.d(0, this.f12204b);
        AllocationNode allocationNode = this.f12206d;
        this.f12207e = allocationNode;
        this.f12208f = allocationNode;
        this.f12209g = 0;
        this.f12203a.d();
    }

    public void o() {
        this.f12207e = this.f12206d;
    }

    public int p(DataReader dataReader, int i2, boolean z) throws IOException {
        int h2 = h(i2);
        AllocationNode allocationNode = this.f12208f;
        int read = dataReader.read(allocationNode.f12212c.f12431a, allocationNode.e(this.f12209g), h2);
        if (read != -1) {
            g(read);
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void q(ParsableByteArray parsableByteArray, int i2) {
        while (i2 > 0) {
            int h2 = h(i2);
            AllocationNode allocationNode = this.f12208f;
            parsableByteArray.n(allocationNode.f12212c.f12431a, allocationNode.e(this.f12209g), h2);
            i2 -= h2;
            g(h2);
        }
    }
}

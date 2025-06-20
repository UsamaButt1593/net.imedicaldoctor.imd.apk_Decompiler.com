package androidx.datastore.preferences.protobuf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.datastore.preferences.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class RopeByteString extends ByteString {
    static final int[] g3 = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.z, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long h3 = 1;
    private final int b3;
    /* access modifiers changed from: private */
    public final ByteString c3;
    /* access modifiers changed from: private */
    public final ByteString d3;
    private final int e3;
    private final int f3;

    private static class Balancer {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayDeque<ByteString> f7241a;

        private Balancer() {
            this.f7241a = new ArrayDeque<>();
        }

        /* access modifiers changed from: private */
        public ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString pop = this.f7241a.pop();
            while (!this.f7241a.isEmpty()) {
                pop = new RopeByteString(this.f7241a.pop(), pop);
            }
            return pop;
        }

        private void c(ByteString byteString) {
            if (byteString.M()) {
                e(byteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                c(ropeByteString.c3);
                c(ropeByteString.d3);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int d(int i2) {
            int binarySearch = Arrays.binarySearch(RopeByteString.g3, i2);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void e(ByteString byteString) {
            int d2 = d(byteString.size());
            int[] iArr = RopeByteString.g3;
            int i2 = iArr[d2 + 1];
            if (this.f7241a.isEmpty() || this.f7241a.peek().size() >= i2) {
                this.f7241a.push(byteString);
                return;
            }
            int i3 = iArr[d2];
            ByteString pop = this.f7241a.pop();
            while (!this.f7241a.isEmpty() && this.f7241a.peek().size() < i3) {
                pop = new RopeByteString(this.f7241a.pop(), pop);
            }
            RopeByteString ropeByteString = new RopeByteString(pop, byteString);
            while (!this.f7241a.isEmpty()) {
                if (this.f7241a.peek().size() >= RopeByteString.g3[d(ropeByteString.size()) + 1]) {
                    break;
                }
                ropeByteString = new RopeByteString(this.f7241a.pop(), ropeByteString);
            }
            this.f7241a.push(ropeByteString);
        }
    }

    private static final class PieceIterator implements Iterator<ByteString.LeafByteString> {
        private ByteString.LeafByteString X;
        private final ArrayDeque<RopeByteString> s;

        private PieceIterator(ByteString byteString) {
            ByteString.LeafByteString leafByteString;
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.K());
                this.s = arrayDeque;
                arrayDeque.push(ropeByteString);
                leafByteString = a(ropeByteString.c3);
            } else {
                this.s = null;
                leafByteString = (ByteString.LeafByteString) byteString;
            }
            this.X = leafByteString;
        }

        private ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.s.push(ropeByteString);
                byteString = ropeByteString.c3;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString b() {
            ByteString.LeafByteString a2;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.s;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                a2 = a(this.s.pop().d3);
            } while (a2.isEmpty());
            return a2;
        }

        /* renamed from: c */
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.X;
            if (leafByteString != null) {
                this.X = b();
                return leafByteString;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.X != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeInputStream extends InputStream {
        private ByteString.LeafByteString X;
        private int X2;
        private int Y;
        private int Y2;
        private int Z;
        private PieceIterator s;

        public RopeInputStream() {
            c();
        }

        private void b() {
            int i2;
            if (this.X != null && this.Z == (i2 = this.Y)) {
                this.X2 += i2;
                int i3 = 0;
                this.Z = 0;
                if (this.s.hasNext()) {
                    ByteString.LeafByteString c2 = this.s.next();
                    this.X = c2;
                    i3 = c2.size();
                } else {
                    this.X = null;
                }
                this.Y = i3;
            }
        }

        private void c() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.s = pieceIterator;
            ByteString.LeafByteString c2 = pieceIterator.next();
            this.X = c2;
            this.Y = c2.size();
            this.Z = 0;
            this.X2 = 0;
        }

        private int d(byte[] bArr, int i2, int i3) {
            int i4 = i3;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                b();
                if (this.X != null) {
                    int min = Math.min(this.Y - this.Z, i4);
                    if (bArr != null) {
                        this.X.E(bArr, this.Z, i2, min);
                        i2 += min;
                    }
                    this.Z += min;
                    i4 -= min;
                } else if (i4 == i3) {
                    return -1;
                }
            }
            return i3 - i4;
        }

        public int available() throws IOException {
            return RopeByteString.this.size() - (this.X2 + this.Z);
        }

        public void mark(int i2) {
            this.Y2 = this.X2 + this.Z;
        }

        public boolean markSupported() {
            return true;
        }

        public int read() throws IOException {
            b();
            ByteString.LeafByteString leafByteString = this.X;
            if (leafByteString == null) {
                return -1;
            }
            int i2 = this.Z;
            this.Z = i2 + 1;
            return leafByteString.h(i2) & 255;
        }

        public synchronized void reset() {
            c();
            d((byte[]) null, 0, this.Y2);
        }

        public long skip(long j2) {
            if (j2 >= 0) {
                if (j2 > 2147483647L) {
                    j2 = 2147483647L;
                }
                return (long) d((byte[]) null, 0, (int) j2);
            }
            throw new IndexOutOfBoundsException();
        }

        public int read(byte[] bArr, int i2, int i3) {
            bArr.getClass();
            if (i2 >= 0 && i3 >= 0 && i3 <= bArr.length - i2) {
                return d(bArr, i2, i3);
            }
            throw new IndexOutOfBoundsException();
        }
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.c3 = byteString;
        this.d3 = byteString2;
        int size = byteString.size();
        this.e3 = size;
        this.b3 = size + byteString2.size();
        this.f3 = Math.max(byteString.K(), byteString2.K()) + 1;
    }

    static ByteString F0(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return G0(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.d3.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.c3, G0(ropeByteString.d3, byteString2));
            } else if (ropeByteString.c3.K() > ropeByteString.d3.K() && ropeByteString.K() > byteString2.K()) {
                return new RopeByteString(ropeByteString.c3, new RopeByteString(ropeByteString.d3, byteString2));
            }
        }
        return size >= g3[Math.max(byteString.K(), byteString2.K()) + 1] ? new RopeByteString(byteString, byteString2) : new Balancer().b(byteString, byteString2);
    }

    private static ByteString G0(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.E(bArr, 0, 0, size);
        byteString2.E(bArr, 0, size, size2);
        return ByteString.t0(bArr);
    }

    private boolean H0(ByteString byteString) {
        PieceIterator pieceIterator = new PieceIterator(this);
        ByteString.LeafByteString leafByteString = (ByteString.LeafByteString) pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        ByteString.LeafByteString leafByteString2 = (ByteString.LeafByteString) pieceIterator2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int size = leafByteString.size() - i2;
            int size2 = leafByteString2.size() - i3;
            int min = Math.min(size, size2);
            if (!(i2 == 0 ? leafByteString.B0(leafByteString2, i3, min) : leafByteString2.B0(leafByteString, i2, min))) {
                return false;
            }
            i4 += min;
            int i5 = this.b3;
            if (i4 < i5) {
                if (min == size) {
                    leafByteString = (ByteString.LeafByteString) pieceIterator.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
                if (min == size2) {
                    leafByteString2 = (ByteString.LeafByteString) pieceIterator2.next();
                    i3 = 0;
                } else {
                    i3 += min;
                }
            } else if (i4 == i5) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    static RopeByteString I0(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    private void J0(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    /* access modifiers changed from: package-private */
    public void A0(ByteOutput byteOutput) throws IOException {
        this.d3.A0(byteOutput);
        this.c3.A0(byteOutput);
    }

    public void C(ByteBuffer byteBuffer) {
        this.c3.C(byteBuffer);
        this.d3.C(byteBuffer);
    }

    /* access modifiers changed from: protected */
    public void H(byte[] bArr, int i2, int i3, int i4) {
        ByteString byteString;
        int i5 = i2 + i4;
        int i6 = this.e3;
        if (i5 <= i6) {
            byteString = this.c3;
        } else if (i2 >= i6) {
            byteString = this.d3;
            i2 -= i6;
        } else {
            int i7 = i6 - i2;
            this.c3.H(bArr, i2, i3, i7);
            this.d3.H(bArr, 0, i3 + i7, i4 - i7);
            return;
        }
        byteString.H(bArr, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public int K() {
        return this.f3;
    }

    /* access modifiers changed from: package-private */
    public byte L(int i2) {
        int i3 = this.e3;
        return i2 < i3 ? this.c3.L(i2) : this.d3.L(i2 - i3);
    }

    /* access modifiers changed from: protected */
    public boolean M() {
        return this.b3 >= g3[this.f3];
    }

    /* access modifiers changed from: package-private */
    public Object M0() {
        return ByteString.t0(j0());
    }

    public boolean N() {
        int X = this.c3.X(0, 0, this.e3);
        ByteString byteString = this.d3;
        return byteString.X(X, 0, byteString.size()) == 0;
    }

    /* renamed from: O */
    public ByteString.ByteIterator iterator() {
        return new ByteString.AbstractByteIterator() {
            ByteString.ByteIterator X = b();
            final PieceIterator s;

            {
                this.s = new PieceIterator(RopeByteString.this);
            }

            private ByteString.ByteIterator b() {
                if (this.s.hasNext()) {
                    return this.s.next().iterator();
                }
                return null;
            }

            public byte K() {
                ByteString.ByteIterator byteIterator = this.X;
                if (byteIterator != null) {
                    byte K = byteIterator.K();
                    if (!this.X.hasNext()) {
                        this.X = b();
                    }
                    return K;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                return this.X != null;
            }
        };
    }

    public CodedInputStream R() {
        return CodedInputStream.j(new RopeInputStream());
    }

    public InputStream T() {
        return new RopeInputStream();
    }

    /* access modifiers changed from: protected */
    public int W(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.e3;
        if (i5 <= i6) {
            return this.c3.W(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.d3.W(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.d3.W(this.c3.W(i2, i3, i7), 0, i4 - i7);
    }

    /* access modifiers changed from: protected */
    public int X(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.e3;
        if (i5 <= i6) {
            return this.c3.X(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.d3.X(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.d3.X(this.c3.X(i2, i3, i7), 0, i4 - i7);
    }

    public ByteBuffer c() {
        return ByteBuffer.wrap(j0()).asReadOnlyBuffer();
    }

    public List<ByteBuffer> d() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().c());
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.b3 != byteString.size()) {
            return false;
        }
        if (this.b3 == 0) {
            return true;
        }
        int Y = Y();
        int Y2 = byteString.Y();
        if (Y == 0 || Y2 == 0 || Y == Y2) {
            return H0(byteString);
        }
        return false;
    }

    public byte h(int i2) {
        ByteString.j(i2, this.b3);
        return L(i2);
    }

    public ByteString i0(int i2, int i3) {
        int k2 = ByteString.k(i2, i3, this.b3);
        if (k2 == 0) {
            return ByteString.X2;
        }
        if (k2 == this.b3) {
            return this;
        }
        int i4 = this.e3;
        if (i3 <= i4) {
            return this.c3.i0(i2, i3);
        }
        return i2 >= i4 ? this.d3.i0(i2 - i4, i3 - i4) : new RopeByteString(this.c3.f0(i2), this.d3.i0(0, i3 - this.e3));
    }

    /* access modifiers changed from: protected */
    public String n0(Charset charset) {
        return new String(j0(), charset);
    }

    public int size() {
        return this.b3;
    }

    /* access modifiers changed from: package-private */
    public void w0(ByteOutput byteOutput) throws IOException {
        this.c3.w0(byteOutput);
        this.d3.w0(byteOutput);
    }

    public void x0(OutputStream outputStream) throws IOException {
        this.c3.x0(outputStream);
        this.d3.x0(outputStream);
    }

    /* access modifiers changed from: package-private */
    public void z0(OutputStream outputStream, int i2, int i3) throws IOException {
        ByteString byteString;
        int i4 = i2 + i3;
        int i5 = this.e3;
        if (i4 <= i5) {
            byteString = this.c3;
        } else if (i2 >= i5) {
            byteString = this.d3;
            i2 -= i5;
        } else {
            int i6 = i5 - i2;
            this.c3.z0(outputStream, i2, i6);
            this.d3.z0(outputStream, 0, i3 - i6);
            return;
        }
        byteString.z0(outputStream, i2, i3);
    }
}

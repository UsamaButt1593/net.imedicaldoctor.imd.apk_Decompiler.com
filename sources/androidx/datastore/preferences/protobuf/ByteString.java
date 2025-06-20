package androidx.datastore.preferences.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int X = 128;
    public static final ByteString X2 = new LiteralByteString(Internal.f7169d);
    static final int Y = 256;
    private static final ByteArrayCopier Y2 = (Android.c() ? new SystemByteArrayCopier() : new ArraysByteArrayCopier());
    static final int Z = 8192;
    private static final int Z2 = 255;
    private static final Comparator<ByteString> a3 = new Comparator<ByteString>() {
        /* renamed from: a */
        public int compare(ByteString byteString, ByteString byteString2) {
            ByteIterator O = byteString.iterator();
            ByteIterator O2 = byteString2.iterator();
            while (O.hasNext() && O2.hasNext()) {
                int compare = Integer.compare(ByteString.k0(O.K()), ByteString.k0(O2.K()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(byteString.size(), byteString2.size());
        }
    };
    private int s = 0;

    static abstract class AbstractByteIterator implements ByteIterator {
        AbstractByteIterator() {
        }

        /* renamed from: a */
        public final Byte next() {
            return Byte.valueOf(K());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        public byte[] a(byte[] bArr, int i2, int i3) {
            return Arrays.copyOfRange(bArr, i2, i3 + i2);
        }
    }

    private static final class BoundedByteString extends LiteralByteString {
        private static final long f3 = 1;
        private final int d3;
        private final int e3;

        BoundedByteString(byte[] bArr, int i2, int i3) {
            super(bArr);
            ByteString.k(i2, i2 + i3, bArr.length);
            this.d3 = i2;
            this.e3 = i3;
        }

        private void F0(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        /* access modifiers changed from: protected */
        public int E0() {
            return this.d3;
        }

        /* access modifiers changed from: package-private */
        public Object G0() {
            return ByteString.t0(j0());
        }

        /* access modifiers changed from: protected */
        public void H(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.b3, E0() + i2, bArr, i3, i4);
        }

        /* access modifiers changed from: package-private */
        public byte L(int i2) {
            return this.b3[this.d3 + i2];
        }

        public byte h(int i2) {
            ByteString.j(i2, size());
            return this.b3[this.d3 + i2];
        }

        public int size() {
            return this.e3;
        }
    }

    private interface ByteArrayCopier {
        byte[] a(byte[] bArr, int i2, int i3);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte K();
    }

    static final class CodedBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final CodedOutputStream f7027a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f7028b;

        private CodedBuilder(int i2) {
            byte[] bArr = new byte[i2];
            this.f7028b = bArr;
            this.f7027a = CodedOutputStream.n1(bArr);
        }

        public ByteString a() {
            this.f7027a.Z();
            return new LiteralByteString(this.f7028b);
        }

        public CodedOutputStream b() {
            return this.f7027a;
        }
    }

    static abstract class LeafByteString extends ByteString {
        LeafByteString() {
        }

        /* access modifiers changed from: package-private */
        public void A0(ByteOutput byteOutput) throws IOException {
            w0(byteOutput);
        }

        /* access modifiers changed from: package-private */
        public abstract boolean B0(ByteString byteString, int i2, int i3);

        /* access modifiers changed from: protected */
        public final int K() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public final boolean M() {
            return true;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ByteString.super.iterator();
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long c3 = 1;
        protected final byte[] b3;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.b3 = bArr;
        }

        /* access modifiers changed from: package-private */
        public final boolean B0(ByteString byteString, int i2, int i3) {
            if (i3 <= byteString.size()) {
                int i4 = i2 + i3;
                if (i4 > byteString.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i2 + ", " + i3 + ", " + byteString.size());
                } else if (!(byteString instanceof LiteralByteString)) {
                    return byteString.i0(i2, i4).equals(i0(0, i3));
                } else {
                    LiteralByteString literalByteString = (LiteralByteString) byteString;
                    byte[] bArr = this.b3;
                    byte[] bArr2 = literalByteString.b3;
                    int E0 = E0() + i3;
                    int E02 = E0();
                    int E03 = literalByteString.E0() + i2;
                    while (E02 < E0) {
                        if (bArr[E02] != bArr2[E03]) {
                            return false;
                        }
                        E02++;
                        E03++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i3 + size());
            }
        }

        public final void C(ByteBuffer byteBuffer) {
            byteBuffer.put(this.b3, E0(), size());
        }

        /* access modifiers changed from: protected */
        public int E0() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public void H(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.b3, i2, bArr, i3, i4);
        }

        /* access modifiers changed from: package-private */
        public byte L(int i2) {
            return this.b3[i2];
        }

        public final boolean N() {
            int E0 = E0();
            return Utf8.u(this.b3, E0, size() + E0);
        }

        public final CodedInputStream R() {
            return CodedInputStream.r(this.b3, E0(), size(), true);
        }

        public final InputStream T() {
            return new ByteArrayInputStream(this.b3, E0(), size());
        }

        /* access modifiers changed from: protected */
        public final int W(int i2, int i3, int i4) {
            return Internal.w(i2, this.b3, E0() + i3, i4);
        }

        /* access modifiers changed from: protected */
        public final int X(int i2, int i3, int i4) {
            int E0 = E0() + i3;
            return Utf8.w(i2, this.b3, E0, i4 + E0);
        }

        public final ByteBuffer c() {
            return ByteBuffer.wrap(this.b3, E0(), size()).asReadOnlyBuffer();
        }

        public final List<ByteBuffer> d() {
            return Collections.singletonList(c());
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int Y = Y();
            int Y2 = literalByteString.Y();
            if (Y == 0 || Y2 == 0 || Y == Y2) {
                return B0(literalByteString, 0, size());
            }
            return false;
        }

        public byte h(int i2) {
            return this.b3[i2];
        }

        public final ByteString i0(int i2, int i3) {
            int k2 = ByteString.k(i2, i3, size());
            return k2 == 0 ? ByteString.X2 : new BoundedByteString(this.b3, E0() + i2, k2);
        }

        /* access modifiers changed from: protected */
        public final String n0(Charset charset) {
            return new String(this.b3, E0(), size(), charset);
        }

        public int size() {
            return this.b3.length;
        }

        /* access modifiers changed from: package-private */
        public final void w0(ByteOutput byteOutput) throws IOException {
            byteOutput.X(this.b3, E0(), size());
        }

        public final void x0(OutputStream outputStream) throws IOException {
            outputStream.write(j0());
        }

        /* access modifiers changed from: package-private */
        public final void z0(OutputStream outputStream, int i2, int i3) throws IOException {
            outputStream.write(this.b3, E0() + i2, i3);
        }
    }

    public static final class Output extends OutputStream {
        private static final byte[] Y2 = new byte[0];
        private final ArrayList<ByteString> X;
        private int X2;
        private int Y;
        private byte[] Z;
        private final int s;

        Output(int i2) {
            if (i2 >= 0) {
                this.s = i2;
                this.X = new ArrayList<>();
                this.Z = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] b(byte[] bArr, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i2));
            return bArr2;
        }

        private void c(int i2) {
            this.X.add(new LiteralByteString(this.Z));
            int length = this.Y + this.Z.length;
            this.Y = length;
            this.Z = new byte[Math.max(this.s, Math.max(i2, length >>> 1))];
            this.X2 = 0;
        }

        private void d() {
            int i2 = this.X2;
            byte[] bArr = this.Z;
            if (i2 >= bArr.length) {
                this.X.add(new LiteralByteString(this.Z));
                this.Z = Y2;
            } else if (i2 > 0) {
                this.X.add(new LiteralByteString(b(bArr, i2)));
            }
            this.Y += this.X2;
            this.X2 = 0;
        }

        public synchronized void e() {
            this.X.clear();
            this.Y = 0;
            this.X2 = 0;
        }

        public synchronized int f() {
            return this.Y + this.X2;
        }

        public synchronized ByteString h() {
            d();
            return ByteString.n(this.X);
        }

        public void i(OutputStream outputStream) throws IOException {
            ByteString[] byteStringArr;
            byte[] bArr;
            int i2;
            synchronized (this) {
                ArrayList<ByteString> arrayList = this.X;
                byteStringArr = (ByteString[]) arrayList.toArray(new ByteString[arrayList.size()]);
                bArr = this.Z;
                i2 = this.X2;
            }
            for (ByteString x0 : byteStringArr) {
                x0.x0(outputStream);
            }
            outputStream.write(b(bArr, i2));
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(f())});
        }

        public synchronized void write(int i2) {
            try {
                if (this.X2 == this.Z.length) {
                    c(1);
                }
                byte[] bArr = this.Z;
                int i3 = this.X2;
                this.X2 = i3 + 1;
                bArr[i3] = (byte) i2;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        public synchronized void write(byte[] bArr, int i2, int i3) {
            try {
                byte[] bArr2 = this.Z;
                int length = bArr2.length;
                int i4 = this.X2;
                if (i3 <= length - i4) {
                    System.arraycopy(bArr, i2, bArr2, i4, i3);
                    this.X2 += i3;
                } else {
                    int length2 = bArr2.length - i4;
                    System.arraycopy(bArr, i2, bArr2, i4, length2);
                    int i5 = i3 - length2;
                    c(i5);
                    System.arraycopy(bArr, i2 + length2, this.Z, 0, i5);
                    this.X2 = i5;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        public byte[] a(byte[] bArr, int i2, int i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
    }

    ByteString() {
    }

    public static ByteString B(String str) {
        return new LiteralByteString(str.getBytes(Internal.f7166a));
    }

    static CodedBuilder P(int i2) {
        return new CodedBuilder(i2);
    }

    public static Output U() {
        return new Output(128);
    }

    public static Output V(int i2) {
        return new Output(i2);
    }

    private static ByteString Z(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        if (i3 == 0) {
            return null;
        }
        return z(bArr, 0, i3);
    }

    public static ByteString a0(InputStream inputStream) throws IOException {
        return d0(inputStream, 256, 8192);
    }

    public static ByteString b0(InputStream inputStream, int i2) throws IOException {
        return d0(inputStream, i2, i2);
    }

    public static ByteString d0(InputStream inputStream, int i2, int i3) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString Z3 = Z(inputStream, i2);
            if (Z3 == null) {
                return n(arrayList);
            }
            arrayList.add(Z3);
            i2 = Math.min(i2 * 2, i3);
        }
    }

    private static ByteString g(Iterator<ByteString> it2, int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i2)}));
        } else if (i2 == 1) {
            return it2.next();
        } else {
            int i3 = i2 >>> 1;
            return g(it2, i3).m(g(it2, i2 - i3));
        }
    }

    static void j(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return;
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i2);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i2 + ", " + i3);
    }

    static int k(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        } else if (i3 < i2) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + ", " + i3);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i3 + " >= " + i4);
        }
    }

    /* access modifiers changed from: private */
    public static int k0(byte b2) {
        return b2 & 255;
    }

    public static ByteString n(Iterable<ByteString> iterable) {
        int i2;
        if (!(iterable instanceof Collection)) {
            Iterator<ByteString> it2 = iterable.iterator();
            i2 = 0;
            while (it2.hasNext()) {
                it2.next();
                i2++;
            }
        } else {
            i2 = ((Collection) iterable).size();
        }
        return i2 == 0 ? X2 : g(iterable.iterator(), i2);
    }

    public static ByteString o(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static Comparator<ByteString> p0() {
        return a3;
    }

    public static ByteString q(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    static ByteString q0(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return u0(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public static ByteString r(ByteBuffer byteBuffer) {
        return t(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString t(ByteBuffer byteBuffer, int i2) {
        k(0, i2, byteBuffer.remaining());
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    static ByteString t0(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    static ByteString u0(byte[] bArr, int i2, int i3) {
        return new BoundedByteString(bArr, i2, i3);
    }

    public static ByteString x(byte[] bArr) {
        return z(bArr, 0, bArr.length);
    }

    public static ByteString z(byte[] bArr, int i2, int i3) {
        k(i2, i2 + i3, bArr.length);
        return new LiteralByteString(Y2.a(bArr, i2, i3));
    }

    /* access modifiers changed from: package-private */
    public abstract void A0(ByteOutput byteOutput) throws IOException;

    public abstract void C(ByteBuffer byteBuffer);

    public void D(byte[] bArr, int i2) {
        E(bArr, 0, i2, size());
    }

    @Deprecated
    public final void E(byte[] bArr, int i2, int i3, int i4) {
        k(i2, i2 + i4, size());
        k(i3, i3 + i4, bArr.length);
        if (i4 > 0) {
            H(bArr, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void H(byte[] bArr, int i2, int i3, int i4);

    public final boolean I(ByteString byteString) {
        return size() >= byteString.size() && f0(size() - byteString.size()).equals(byteString);
    }

    /* access modifiers changed from: protected */
    public abstract int K();

    /* access modifiers changed from: package-private */
    public abstract byte L(int i2);

    /* access modifiers changed from: protected */
    public abstract boolean M();

    public abstract boolean N();

    /* renamed from: O */
    public ByteIterator iterator() {
        return new AbstractByteIterator() {
            private final int X;
            private int s = 0;

            {
                this.X = ByteString.this.size();
            }

            public byte K() {
                int i2 = this.s;
                if (i2 < this.X) {
                    this.s = i2 + 1;
                    return ByteString.this.L(i2);
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                return this.s < this.X;
            }
        };
    }

    public abstract CodedInputStream R();

    public abstract InputStream T();

    /* access modifiers changed from: protected */
    public abstract int W(int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract int X(int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public final int Y() {
        return this.s;
    }

    public abstract ByteBuffer c();

    public abstract List<ByteBuffer> d();

    public final boolean e0(ByteString byteString) {
        return size() >= byteString.size() && i0(0, byteString.size()).equals(byteString);
    }

    public abstract boolean equals(Object obj);

    public final ByteString f0(int i2) {
        return i0(i2, size());
    }

    public abstract byte h(int i2);

    public final int hashCode() {
        int i2 = this.s;
        if (i2 == 0) {
            int size = size();
            i2 = W(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.s = i2;
        }
        return i2;
    }

    public abstract ByteString i0(int i2, int i3);

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final byte[] j0() {
        int size = size();
        if (size == 0) {
            return Internal.f7169d;
        }
        byte[] bArr = new byte[size];
        H(bArr, 0, 0, size);
        return bArr;
    }

    public final String l0(String str) throws UnsupportedEncodingException {
        try {
            return m0(Charset.forName(str));
        } catch (UnsupportedCharsetException e2) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e2);
            throw unsupportedEncodingException;
        }
    }

    public final ByteString m(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.F0(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public final String m0(Charset charset) {
        return size() == 0 ? "" : n0(charset);
    }

    /* access modifiers changed from: protected */
    public abstract String n0(Charset charset);

    public final String o0() {
        return m0(Internal.f7166a);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* access modifiers changed from: package-private */
    public abstract void w0(ByteOutput byteOutput) throws IOException;

    public abstract void x0(OutputStream outputStream) throws IOException;

    /* access modifiers changed from: package-private */
    public final void y0(OutputStream outputStream, int i2, int i3) throws IOException {
        k(i2, i2 + i3, size());
        if (i3 > 0) {
            z0(outputStream, i2, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void z0(OutputStream outputStream, int i2, int i3) throws IOException;
}

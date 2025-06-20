package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class NioByteString extends ByteString.LeafByteString {
    /* access modifiers changed from: private */
    public final ByteBuffer b3;

    NioByteString(ByteBuffer byteBuffer) {
        Internal.e(byteBuffer, "buffer");
        this.b3 = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void F0(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer G0(int i2, int i3) {
        if (i2 < this.b3.position() || i3 > this.b3.limit() || i2 > i3) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
        }
        ByteBuffer slice = this.b3.slice();
        slice.position(i2 - this.b3.position());
        slice.limit(i3 - this.b3.position());
        return slice;
    }

    private Object H0() {
        return ByteString.r(this.b3.slice());
    }

    /* access modifiers changed from: package-private */
    public boolean B0(ByteString byteString, int i2, int i3) {
        return i0(0, i3).equals(byteString.i0(i2, i3 + i2));
    }

    public void C(ByteBuffer byteBuffer) {
        byteBuffer.put(this.b3.slice());
    }

    /* access modifiers changed from: protected */
    public void H(byte[] bArr, int i2, int i3, int i4) {
        ByteBuffer slice = this.b3.slice();
        slice.position(i2);
        slice.get(bArr, i3, i4);
    }

    public byte L(int i2) {
        return h(i2);
    }

    public boolean N() {
        return Utf8.s(this.b3);
    }

    public CodedInputStream R() {
        return CodedInputStream.o(this.b3, true);
    }

    public InputStream T() {
        return new InputStream() {
            private final ByteBuffer s;

            {
                this.s = NioByteString.this.b3.slice();
            }

            public int available() throws IOException {
                return this.s.remaining();
            }

            public void mark(int i2) {
                this.s.mark();
            }

            public boolean markSupported() {
                return true;
            }

            public int read() throws IOException {
                if (!this.s.hasRemaining()) {
                    return -1;
                }
                return this.s.get() & 255;
            }

            public void reset() throws IOException {
                try {
                    this.s.reset();
                } catch (InvalidMarkException e2) {
                    throw new IOException(e2);
                }
            }

            public int read(byte[] bArr, int i2, int i3) throws IOException {
                if (!this.s.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i3, this.s.remaining());
                this.s.get(bArr, i2, min);
                return min;
            }
        };
    }

    /* access modifiers changed from: protected */
    public int W(int i2, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + this.b3.get(i5);
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public int X(int i2, int i3, int i4) {
        return Utf8.v(i2, this.b3, i3, i4 + i3);
    }

    public ByteBuffer c() {
        return this.b3.asReadOnlyBuffer();
    }

    public List<ByteBuffer> d() {
        return Collections.singletonList(c());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        return obj instanceof NioByteString ? this.b3.equals(((NioByteString) obj).b3) : obj instanceof RopeByteString ? obj.equals(this) : this.b3.equals(byteString.c());
    }

    public byte h(int i2) {
        try {
            return this.b3.get(i2);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new ArrayIndexOutOfBoundsException(e3.getMessage());
        }
    }

    public ByteString i0(int i2, int i3) {
        try {
            return new NioByteString(G0(i2, i3));
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new ArrayIndexOutOfBoundsException(e3.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public String n0(Charset charset) {
        int i2;
        int i3;
        byte[] bArr;
        if (this.b3.hasArray()) {
            bArr = this.b3.array();
            i3 = this.b3.arrayOffset() + this.b3.position();
            i2 = this.b3.remaining();
        } else {
            bArr = j0();
            i2 = bArr.length;
            i3 = 0;
        }
        return new String(bArr, i3, i2, charset);
    }

    public int size() {
        return this.b3.remaining();
    }

    /* access modifiers changed from: package-private */
    public void w0(ByteOutput byteOutput) throws IOException {
        byteOutput.W(this.b3.slice());
    }

    public void x0(OutputStream outputStream) throws IOException {
        outputStream.write(j0());
    }

    /* access modifiers changed from: package-private */
    public void z0(OutputStream outputStream, int i2, int i3) throws IOException {
        if (this.b3.hasArray()) {
            outputStream.write(this.b3.array(), this.b3.arrayOffset() + this.b3.position() + i2, i3);
            return;
        }
        ByteBufferWriter.h(G0(i2, i3 + i2), outputStream);
    }
}

package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

class IterableByteBufferInputStream extends InputStream {
    private ByteBuffer X;
    private int X2;
    private int Y = 0;
    private boolean Y2;
    private int Z;
    private byte[] Z2;
    private int a3;
    private long b3;
    private Iterator<ByteBuffer> s;

    IterableByteBufferInputStream(Iterable<ByteBuffer> iterable) {
        this.s = iterable.iterator();
        for (ByteBuffer next : iterable) {
            this.Y++;
        }
        this.Z = -1;
        if (!b()) {
            this.X = Internal.f7170e;
            this.Z = 0;
            this.X2 = 0;
            this.b3 = 0;
        }
    }

    private boolean b() {
        this.Z++;
        if (!this.s.hasNext()) {
            return false;
        }
        ByteBuffer next = this.s.next();
        this.X = next;
        this.X2 = next.position();
        if (this.X.hasArray()) {
            this.Y2 = true;
            this.Z2 = this.X.array();
            this.a3 = this.X.arrayOffset();
        } else {
            this.Y2 = false;
            this.b3 = UnsafeUtil.i(this.X);
            this.Z2 = null;
        }
        return true;
    }

    private void c(int i2) {
        int i3 = this.X2 + i2;
        this.X2 = i3;
        if (i3 == this.X.limit()) {
            b();
        }
    }

    public int read() throws IOException {
        if (this.Z == this.Y) {
            return -1;
        }
        byte y = (this.Y2 ? this.Z2[this.X2 + this.a3] : UnsafeUtil.y(((long) this.X2) + this.b3)) & 255;
        c(1);
        return y;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.Z == this.Y) {
            return -1;
        }
        int limit = this.X.limit();
        int i4 = this.X2;
        int i5 = limit - i4;
        if (i3 > i5) {
            i3 = i5;
        }
        if (this.Y2) {
            System.arraycopy(this.Z2, i4 + this.a3, bArr, i2, i3);
        } else {
            int position = this.X.position();
            this.X.position(this.X2);
            this.X.get(bArr, i2, i3);
            this.X.position(position);
        }
        c(i3);
        return i3;
    }
}

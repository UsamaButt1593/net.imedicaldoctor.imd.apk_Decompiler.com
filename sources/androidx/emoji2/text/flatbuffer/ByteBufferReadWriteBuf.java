package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferReadWriteBuf implements ReadWriteBuf {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f7693a;

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.f7693a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public void A(int i2, boolean z) {
        m(i2, z ? (byte) 1 : 0);
    }

    public void a(double d2) {
        this.f7693a.putDouble(d2);
    }

    public void b(short s) {
        this.f7693a.putShort(s);
    }

    public void c(boolean z) {
        this.f7693a.put(z ? (byte) 1 : 0);
    }

    public void d(float f2) {
        this.f7693a.putFloat(f2);
    }

    public void e(int i2) {
        this.f7693a.putInt(i2);
    }

    public void f(long j2) {
        this.f7693a.putLong(j2);
    }

    public int g() {
        return this.f7693a.limit();
    }

    public byte get(int i2) {
        return this.f7693a.get(i2);
    }

    public double getDouble(int i2) {
        return this.f7693a.getDouble(i2);
    }

    public float getFloat(int i2) {
        return this.f7693a.getFloat(i2);
    }

    public int getInt(int i2) {
        return this.f7693a.getInt(i2);
    }

    public long getLong(int i2) {
        return this.f7693a.getLong(i2);
    }

    public short getShort(int i2) {
        return this.f7693a.getShort(i2);
    }

    public void h(int i2, byte[] bArr, int i3, int i4) {
        l((i4 - i3) + i2);
        int position = this.f7693a.position();
        this.f7693a.position(i2);
        this.f7693a.put(bArr, i3, i4);
        this.f7693a.position(position);
    }

    public byte[] i() {
        return this.f7693a.array();
    }

    public String j(int i2, int i3) {
        return Utf8Safe.h(this.f7693a, i2, i3);
    }

    public void k(int i2, short s) {
        l(i2 + 2);
        this.f7693a.putShort(i2, s);
    }

    public boolean l(int i2) {
        return i2 <= this.f7693a.limit();
    }

    public void m(int i2, byte b2) {
        l(i2 + 1);
        this.f7693a.put(i2, b2);
    }

    public int n() {
        return this.f7693a.position();
    }

    public void o(byte[] bArr, int i2, int i3) {
        this.f7693a.put(bArr, i2, i3);
    }

    public void p(int i2, double d2) {
        l(i2 + 8);
        this.f7693a.putDouble(i2, d2);
    }

    public void q(byte b2) {
        this.f7693a.put(b2);
    }

    public void s(int i2, int i3) {
        l(i2 + 4);
        this.f7693a.putInt(i2, i3);
    }

    public boolean v(int i2) {
        return get(i2) != 0;
    }

    public void w(int i2, float f2) {
        l(i2 + 4);
        this.f7693a.putFloat(i2, f2);
    }

    public void y(int i2, long j2) {
        l(i2 + 8);
        this.f7693a.putLong(i2, j2);
    }
}

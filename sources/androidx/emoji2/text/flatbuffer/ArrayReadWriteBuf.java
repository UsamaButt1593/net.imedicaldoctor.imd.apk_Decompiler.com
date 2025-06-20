package androidx.emoji2.text.flatbuffer;

import com.google.common.base.Ascii;
import java.util.Arrays;

public class ArrayReadWriteBuf implements ReadWriteBuf {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f7687a;

    /* renamed from: b  reason: collision with root package name */
    private int f7688b;

    public ArrayReadWriteBuf() {
        this(10);
    }

    public void A(int i2, boolean z) {
        m(i2, z ? (byte) 1 : 0);
    }

    public void a(double d2) {
        p(this.f7688b, d2);
        this.f7688b += 8;
    }

    public void b(short s) {
        k(this.f7688b, s);
        this.f7688b += 2;
    }

    public void c(boolean z) {
        A(this.f7688b, z);
        this.f7688b++;
    }

    public void d(float f2) {
        w(this.f7688b, f2);
        this.f7688b += 4;
    }

    public void e(int i2) {
        s(this.f7688b, i2);
        this.f7688b += 4;
    }

    public void f(long j2) {
        y(this.f7688b, j2);
        this.f7688b += 8;
    }

    public int g() {
        return this.f7688b;
    }

    public byte get(int i2) {
        return this.f7687a[i2];
    }

    public double getDouble(int i2) {
        return Double.longBitsToDouble(getLong(i2));
    }

    public float getFloat(int i2) {
        return Float.intBitsToFloat(getInt(i2));
    }

    public int getInt(int i2) {
        byte[] bArr = this.f7687a;
        return (bArr[i2] & 255) | (bArr[i2 + 3] << Ascii.B) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 1] & 255) << 8);
    }

    public long getLong(int i2) {
        byte[] bArr = this.f7687a;
        return (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48) | (((long) bArr[i2 + 7]) << 56);
    }

    public short getShort(int i2) {
        byte[] bArr = this.f7687a;
        return (short) ((bArr[i2] & 255) | (bArr[i2 + 1] << 8));
    }

    public void h(int i2, byte[] bArr, int i3, int i4) {
        l((i4 - i3) + i2);
        System.arraycopy(bArr, i3, this.f7687a, i2, i4);
    }

    public byte[] i() {
        return this.f7687a;
    }

    public String j(int i2, int i3) {
        return Utf8Safe.g(this.f7687a, i2, i3);
    }

    public void k(int i2, short s) {
        l(i2 + 2);
        byte[] bArr = this.f7687a;
        bArr[i2] = (byte) (s & 255);
        bArr[i2 + 1] = (byte) ((s >> 8) & 255);
    }

    public boolean l(int i2) {
        byte[] bArr = this.f7687a;
        if (bArr.length > i2) {
            return true;
        }
        int length = bArr.length;
        this.f7687a = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    public void m(int i2, byte b2) {
        l(i2 + 1);
        this.f7687a[i2] = b2;
    }

    public int n() {
        return this.f7688b;
    }

    public void o(byte[] bArr, int i2, int i3) {
        h(this.f7688b, bArr, i2, i3);
        this.f7688b += i3;
    }

    public void p(int i2, double d2) {
        l(i2 + 8);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
        int i3 = (int) doubleToRawLongBits;
        byte[] bArr = this.f7687a;
        bArr[i2] = (byte) (i3 & 255);
        bArr[i2 + 1] = (byte) ((i3 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i3 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i3 >> 24) & 255);
        int i4 = (int) (doubleToRawLongBits >> 32);
        bArr[i2 + 4] = (byte) (i4 & 255);
        bArr[i2 + 5] = (byte) ((i4 >> 8) & 255);
        bArr[i2 + 6] = (byte) ((i4 >> 16) & 255);
        bArr[i2 + 7] = (byte) ((i4 >> 24) & 255);
    }

    public void q(byte b2) {
        m(this.f7688b, b2);
        this.f7688b++;
    }

    public void s(int i2, int i3) {
        l(i2 + 4);
        byte[] bArr = this.f7687a;
        bArr[i2] = (byte) (i3 & 255);
        bArr[i2 + 1] = (byte) ((i3 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i3 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i3 >> 24) & 255);
    }

    public boolean v(int i2) {
        return this.f7687a[i2] != 0;
    }

    public void w(int i2, float f2) {
        l(i2 + 4);
        int floatToRawIntBits = Float.floatToRawIntBits(f2);
        byte[] bArr = this.f7687a;
        bArr[i2] = (byte) (floatToRawIntBits & 255);
        bArr[i2 + 1] = (byte) ((floatToRawIntBits >> 8) & 255);
        bArr[i2 + 2] = (byte) ((floatToRawIntBits >> 16) & 255);
        bArr[i2 + 3] = (byte) ((floatToRawIntBits >> 24) & 255);
    }

    public void y(int i2, long j2) {
        l(i2 + 8);
        int i3 = (int) j2;
        byte[] bArr = this.f7687a;
        bArr[i2] = (byte) (i3 & 255);
        bArr[i2 + 1] = (byte) ((i3 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i3 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i3 >> 24) & 255);
        int i4 = (int) (j2 >> 32);
        bArr[i2 + 4] = (byte) (i4 & 255);
        bArr[i2 + 5] = (byte) ((i4 >> 8) & 255);
        bArr[i2 + 6] = (byte) ((i4 >> 16) & 255);
        bArr[i2 + 7] = (byte) ((i4 >> 24) & 255);
    }

    public ArrayReadWriteBuf(int i2) {
        this(new byte[i2]);
    }

    public ArrayReadWriteBuf(byte[] bArr) {
        this.f7687a = bArr;
        this.f7688b = 0;
    }

    public ArrayReadWriteBuf(byte[] bArr, int i2) {
        this.f7687a = bArr;
        this.f7688b = i2;
    }
}

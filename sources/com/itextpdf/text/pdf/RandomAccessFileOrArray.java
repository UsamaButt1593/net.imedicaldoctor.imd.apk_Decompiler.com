package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.io.IndependentRandomAccessSource;
import com.itextpdf.text.io.RandomAccessSource;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import net.lingala.zip4j.util.InternalZipConstants;

public class RandomAccessFileOrArray implements DataInput {
    private long X;
    private byte Y;
    private boolean Z;
    private final RandomAccessSource s;

    public RandomAccessFileOrArray(RandomAccessSource randomAccessSource) {
        this.Z = false;
        this.s = randomAccessSource;
    }

    public RandomAccessSource a() {
        return new IndependentRandomAccessSource(this.s);
    }

    public RandomAccessFileOrArray b() {
        return new RandomAccessFileOrArray((RandomAccessSource) new IndependentRandomAccessSource(this.s));
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public RandomAccessSource c() {
        return this.s;
    }

    public void close() throws IOException {
        this.Z = false;
        this.s.close();
    }

    public long d() throws IOException {
        return this.X - (this.Z ? 1 : 0);
    }

    public long e() throws IOException {
        return this.s.length();
    }

    public void f(byte b2) {
        this.Y = b2;
        this.Z = true;
    }

    @Deprecated
    public void g() throws IOException {
        r(0);
    }

    public final char h() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (char) ((read2 << 8) + read);
        }
        throw new EOFException();
    }

    public final double i() throws IOException {
        return Double.longBitsToDouble(l());
    }

    public final float j() throws IOException {
        return Float.intBitsToFloat(k());
    }

    public final int k() throws IOException {
        int read = read();
        int read2 = read();
        int read3 = read();
        int read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
        }
        throw new EOFException();
    }

    public final long l() throws IOException {
        return (((long) k()) << 32) + (((long) k()) & InternalZipConstants.f30717k);
    }

    public final short m() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (short) ((read2 << 8) + read);
        }
        throw new EOFException();
    }

    public String n(int i2, String str) throws IOException {
        byte[] bArr = new byte[i2];
        readFully(bArr);
        try {
            return new String(bArr, str);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public final long o() throws IOException {
        long read = (long) read();
        long read2 = (long) read();
        long read3 = (long) read();
        long read4 = (long) read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new EOFException();
    }

    public final long p() throws IOException {
        long read = (long) read();
        long read2 = (long) read();
        long read3 = (long) read();
        long read4 = (long) read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
        }
        throw new EOFException();
    }

    public final int q() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (read2 << 8) + read;
        }
        throw new EOFException();
    }

    public void r(long j2) throws IOException {
        this.X = j2;
        this.Z = false;
    }

    public int read() throws IOException {
        if (this.Z) {
            this.Z = false;
            return this.Y & 255;
        }
        RandomAccessSource randomAccessSource = this.s;
        long j2 = this.X;
        this.X = 1 + j2;
        return randomAccessSource.b(j2);
    }

    public boolean readBoolean() throws IOException {
        int read = read();
        if (read >= 0) {
            return read != 0;
        }
        throw new EOFException();
    }

    public byte readByte() throws IOException {
        int read = read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    public char readChar() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (char) ((read << 8) + read2);
        }
        throw new EOFException();
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    public int readInt() throws IOException {
        int read = read();
        int read2 = read();
        int read3 = read();
        int read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new EOFException();
    }

    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i2 = -1;
        while (!z) {
            i2 = read();
            if (!(i2 == -1 || i2 == 10)) {
                if (i2 != 13) {
                    sb.append((char) i2);
                } else {
                    long d2 = d();
                    if (read() != 10) {
                        r(d2);
                    }
                }
            }
            z = true;
        }
        if (i2 == -1 && sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    public long readLong() throws IOException {
        return (((long) readInt()) << 32) + (((long) readInt()) & InternalZipConstants.f30717k);
    }

    public short readShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (short) ((read << 8) + read2);
        }
        throw new EOFException();
    }

    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    public int readUnsignedByte() throws IOException {
        int read = read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    public int readUnsignedShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (read << 8) + read2;
        }
        throw new EOFException();
    }

    public long skip(long j2) throws IOException {
        if (j2 <= 0) {
            return 0;
        }
        int i2 = 0;
        if (this.Z) {
            this.Z = false;
            if (j2 == 1) {
                return 1;
            }
            j2--;
            i2 = 1;
        }
        long d2 = d();
        long e2 = e();
        long j3 = j2 + d2;
        if (j3 <= e2) {
            e2 = j3;
        }
        r(e2);
        return (e2 - d2) + ((long) i2);
    }

    public int skipBytes(int i2) throws IOException {
        return (int) skip((long) i2);
    }

    @Deprecated
    public RandomAccessFileOrArray(RandomAccessFileOrArray randomAccessFileOrArray) {
        this((RandomAccessSource) new IndependentRandomAccessSource(randomAccessFileOrArray.s));
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int read = read(bArr, i2 + i4, i3 - i4);
            if (read >= 0) {
                i4 += read;
            } else {
                throw new EOFException();
            }
        } while (i4 < i3);
    }

    @Deprecated
    public RandomAccessFileOrArray(InputStream inputStream) throws IOException {
        this(new RandomAccessSourceFactory().g(inputStream));
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        int a2;
        int i6 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (!this.Z || i3 <= 0) {
            i5 = i2;
            i4 = i3;
        } else {
            this.Z = false;
            bArr[i2] = this.Y;
            i4 = i3 - 1;
            i5 = i2 + 1;
            i6 = 1;
        }
        if (i4 > 0 && (a2 = this.s.a(this.X, bArr, i5, i4)) > 0) {
            i6 += a2;
            this.X += (long) a2;
        }
        if (i6 == 0) {
            return -1;
        }
        return i6;
    }

    @Deprecated
    public RandomAccessFileOrArray(String str) throws IOException {
        this(new RandomAccessSourceFactory().l(false).m(Document.m3).b(str));
    }

    @Deprecated
    public RandomAccessFileOrArray(String str, boolean z, boolean z2) throws IOException {
        this(new RandomAccessSourceFactory().l(z).m(z2).b(str));
    }

    @Deprecated
    public RandomAccessFileOrArray(URL url) throws IOException {
        this(new RandomAccessSourceFactory().i(url));
    }

    @Deprecated
    public RandomAccessFileOrArray(byte[] bArr) {
        this(new RandomAccessSourceFactory().j(bArr));
    }
}

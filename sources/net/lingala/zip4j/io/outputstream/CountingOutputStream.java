package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.exception.ZipException;

public class CountingOutputStream extends OutputStream implements OutputStreamWithSplitZipSupport {
    private long X = 0;
    private OutputStream s;

    public CountingOutputStream(OutputStream outputStream) {
        this.s = outputStream;
    }

    public int b() {
        if (i()) {
            return ((SplitOutputStream) this.s).b();
        }
        return 0;
    }

    public long c() throws IOException {
        OutputStream outputStream = this.s;
        return outputStream instanceof SplitOutputStream ? ((SplitOutputStream) outputStream).c() : this.X;
    }

    public void close() throws IOException {
        this.s.close();
    }

    public boolean d(int i2) throws ZipException {
        if (!i()) {
            return false;
        }
        return ((SplitOutputStream) this.s).d(i2);
    }

    public long e() throws IOException {
        OutputStream outputStream = this.s;
        return outputStream instanceof SplitOutputStream ? ((SplitOutputStream) outputStream).c() : this.X;
    }

    public long f() throws IOException {
        OutputStream outputStream = this.s;
        return outputStream instanceof SplitOutputStream ? ((SplitOutputStream) outputStream).c() : this.X;
    }

    public long h() {
        if (i()) {
            return ((SplitOutputStream) this.s).e();
        }
        return 0;
    }

    public boolean i() {
        OutputStream outputStream = this.s;
        return (outputStream instanceof SplitOutputStream) && ((SplitOutputStream) outputStream).i();
    }

    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.s.write(bArr, i2, i3);
        this.X += (long) i3;
    }
}

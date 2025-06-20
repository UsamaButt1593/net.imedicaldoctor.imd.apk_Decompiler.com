package net.lingala.zip4j.io.inputstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;

public abstract class SplitInputStream extends InputStream {
    protected File X;
    private byte[] X2 = new byte[1];
    private boolean Y;
    private int Z = 0;
    protected RandomAccessFile s;

    public SplitInputStream(File file, boolean z, int i2) throws FileNotFoundException {
        this.s = new RandomAccessFile(file, RandomAccessFileMode.READ.a());
        this.X = file;
        this.Y = z;
        if (z) {
            this.Z = i2;
        }
    }

    /* access modifiers changed from: protected */
    public abstract File b(int i2) throws IOException;

    /* access modifiers changed from: protected */
    public void c(int i2) throws IOException {
        File b2 = b(i2);
        if (b2.exists()) {
            this.s.close();
            this.s = new RandomAccessFile(b2, RandomAccessFileMode.READ.a());
            return;
        }
        throw new FileNotFoundException("zip split file does not exist: " + b2);
    }

    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.s;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    public void d(FileHeader fileHeader) throws IOException {
        if (this.Y && this.Z != fileHeader.P()) {
            c(fileHeader.P());
            this.Z = fileHeader.P();
        }
        this.s.seek(fileHeader.U());
    }

    public int read() throws IOException {
        if (read(this.X2) == -1) {
            return -1;
        }
        return this.X2[0];
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.s.read(bArr, i2, i3);
        if ((read == i3 && read != -1) || !this.Y) {
            return read;
        }
        c(this.Z + 1);
        this.Z++;
        if (read < 0) {
            read = 0;
        }
        int read2 = this.s.read(bArr, read, i3 - read);
        return read2 > 0 ? read + read2 : read;
    }
}

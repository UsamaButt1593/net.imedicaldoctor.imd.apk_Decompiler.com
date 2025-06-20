package net.lingala.zip4j.io.inputstream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.util.FileUtils;

public class NumberedSplitRandomAccessFile extends RandomAccessFile {
    private File[] X;
    private int X2;
    private RandomAccessFile Y;
    private String Y2;
    private byte[] Z;
    private long s;

    public NumberedSplitRandomAccessFile(File file, String str) throws IOException {
        this(file, str, FileUtils.i(file));
    }

    private void b(File[] fileArr) throws IOException {
        int length = fileArr.length;
        int i2 = 1;
        int i3 = 0;
        while (i3 < length) {
            String m2 = FileUtils.m(fileArr[i3]);
            try {
                if (i2 == Integer.parseInt(m2)) {
                    i2++;
                    i3++;
                } else {
                    throw new IOException("Split file number " + i2 + " does not exist");
                }
            } catch (NumberFormatException unused) {
                throw new IOException("Split file extension not in expected format. Found: " + m2 + " expected of format: .001, .002, etc");
            }
        }
    }

    private void d(int i2) throws IOException {
        if (this.X2 != i2) {
            if (i2 <= this.X.length - 1) {
                RandomAccessFile randomAccessFile = this.Y;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.Y = new RandomAccessFile(this.X[i2], this.Y2);
                this.X2 = i2;
                return;
            }
            throw new IOException("split counter greater than number of split files");
        }
    }

    public void c() throws IOException {
        d(this.X.length - 1);
    }

    public void e(long j2) throws IOException {
        this.Y.seek(j2);
    }

    public long getFilePointer() throws IOException {
        return this.Y.getFilePointer();
    }

    public long length() throws IOException {
        return this.Y.length();
    }

    public int read() throws IOException {
        if (read(this.Z) == -1) {
            return -1;
        }
        return this.Z[0] & 255;
    }

    public void seek(long j2) throws IOException {
        int i2 = (int) (j2 / this.s);
        if (i2 != this.X2) {
            d(i2);
        }
        this.Y.seek(j2 - (((long) i2) * this.s));
    }

    public void write(int i2) throws IOException {
        throw new UnsupportedOperationException();
    }

    public NumberedSplitRandomAccessFile(File file, String str, File[] fileArr) throws IOException {
        super(file, str);
        this.Z = new byte[1];
        this.X2 = 0;
        super.close();
        if (!RandomAccessFileMode.WRITE.a().equals(str)) {
            b(fileArr);
            this.Y = new RandomAccessFile(file, str);
            this.X = fileArr;
            this.s = file.length();
            this.Y2 = str;
            return;
        }
        throw new IllegalArgumentException("write mode is not allowed for NumberedSplitRandomAccessFile");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public NumberedSplitRandomAccessFile(String str, String str2) throws IOException {
        this(new File(str), str2);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = this.Y.read(bArr, i2, i3);
        if (read != -1) {
            return read;
        }
        int i4 = this.X2;
        if (i4 == this.X.length - 1) {
            return -1;
        }
        d(i4 + 1);
        return read(bArr, i2, i3);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        throw new UnsupportedOperationException();
    }
}

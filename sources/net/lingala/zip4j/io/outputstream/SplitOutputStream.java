package net.lingala.zip4j.io.outputstream;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.RawIO;

public class SplitOutputStream extends OutputStream implements OutputStreamWithSplitZipSupport {
    private long X;
    private long X2;
    private File Y;
    private RawIO Y2;
    private int Z;
    private RandomAccessFile s;

    public SplitOutputStream(File file) throws FileNotFoundException, ZipException {
        this(file, -1);
    }

    private boolean f(int i2) {
        long j2 = this.X;
        return j2 < PlaybackStateCompat.v3 || this.X2 + ((long) i2) <= j2;
    }

    private boolean h(byte[] bArr) {
        int d2 = this.Y2.d(bArr);
        for (HeaderSignature headerSignature : HeaderSignature.values()) {
            if (headerSignature != HeaderSignature.SPLIT_ZIP && headerSignature.a() == ((long) d2)) {
                return true;
            }
        }
        return false;
    }

    private void p() throws IOException {
        String str;
        String w = FileUtils.w(this.Y.getName());
        String absolutePath = this.Y.getAbsolutePath();
        if (this.Y.getParent() == null) {
            str = "";
        } else {
            str = this.Y.getParent() + System.getProperty("file.separator");
        }
        String str2 = ".z0" + (this.Z + 1);
        if (this.Z >= 9) {
            str2 = ".z" + (this.Z + 1);
        }
        File file = new File(str + w + str2);
        this.s.close();
        if (file.exists()) {
            throw new IOException("split file: " + file.getName() + " already exists in the current directory, cannot rename this file");
        } else if (this.Y.renameTo(file)) {
            this.Y = new File(absolutePath);
            this.s = new RandomAccessFile(this.Y, RandomAccessFileMode.WRITE.a());
            this.Z++;
        } else {
            throw new IOException("cannot rename newly created split file");
        }
    }

    public int b() {
        return this.Z;
    }

    public long c() throws IOException {
        return this.s.getFilePointer();
    }

    public void close() throws IOException {
        this.s.close();
    }

    public boolean d(int i2) throws ZipException {
        if (i2 < 0) {
            throw new ZipException("negative buffersize for checkBufferSizeAndStartNextSplitFile");
        } else if (f(i2)) {
            return false;
        } else {
            try {
                p();
                this.X2 = 0;
                return true;
            } catch (IOException e2) {
                throw new ZipException((Exception) e2);
            }
        }
    }

    public long e() {
        return this.X;
    }

    public boolean i() {
        return this.X != -1;
    }

    public void k(long j2) throws IOException {
        this.s.seek(j2);
    }

    public int n(int i2) throws IOException {
        return this.s.skipBytes(i2);
    }

    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public SplitOutputStream(File file, long j2) throws FileNotFoundException, ZipException {
        this.Y2 = new RawIO();
        if (j2 < 0 || j2 >= PlaybackStateCompat.v3) {
            this.s = new RandomAccessFile(file, RandomAccessFileMode.WRITE.a());
            this.X = j2;
            this.Y = file;
            this.Z = 0;
            this.X2 = 0;
            return;
        }
        throw new ZipException("split length less than minimum allowed split length of 65536 Bytes");
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        long j2;
        if (i3 > 0) {
            long j3 = this.X;
            if (j3 == -1) {
                this.s.write(bArr, i2, i3);
                this.X2 += (long) i3;
                return;
            }
            long j4 = this.X2;
            if (j4 >= j3) {
                p();
                this.s.write(bArr, i2, i3);
                j2 = (long) i3;
            } else {
                long j5 = (long) i3;
                if (j4 + j5 > j3) {
                    if (h(bArr)) {
                        p();
                        this.s.write(bArr, i2, i3);
                    } else {
                        this.s.write(bArr, i2, (int) (this.X - this.X2));
                        p();
                        RandomAccessFile randomAccessFile = this.s;
                        long j6 = this.X;
                        long j7 = this.X2;
                        randomAccessFile.write(bArr, i2 + ((int) (j6 - j7)), (int) (j5 - (j6 - j7)));
                        j5 -= this.X - this.X2;
                    }
                    this.X2 = j5;
                    return;
                }
                this.s.write(bArr, i2, i3);
                j2 = this.X2 + j5;
            }
            this.X2 = j2;
        }
    }
}

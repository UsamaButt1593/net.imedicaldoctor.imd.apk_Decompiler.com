package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderReader;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.DataDescriptor;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

public class ZipInputStream extends InputStream {
    private DecompressedInputStream X;
    private LocalFileHeader X2;
    private HeaderReader Y;
    private CRC32 Y2;
    private char[] Z;
    private byte[] Z2;
    private boolean a3;
    private Charset b3;
    private PushbackInputStream s;

    public ZipInputStream(InputStream inputStream) {
        this(inputStream, (char[]) null, InternalZipConstants.u);
    }

    private boolean b(List<ExtraDataRecord> list) {
        if (list == null) {
            return false;
        }
        for (ExtraDataRecord d2 : list) {
            if (d2.d() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.a()) {
                return true;
            }
        }
        return false;
    }

    private void c() throws IOException {
        this.X.d(this.s);
        this.X.b(this.s);
        s();
        v();
        u();
    }

    private long e(LocalFileHeader localFileHeader) {
        if (Zip4jUtil.g(localFileHeader).equals(CompressionMethod.STORE)) {
            return localFileHeader.p();
        }
        if (!localFileHeader.s() || this.a3) {
            return localFileHeader.d() - ((long) f(localFileHeader));
        }
        return -1;
    }

    private int f(LocalFileHeader localFileHeader) {
        if (!localFileHeader.u()) {
            return 0;
        }
        if (localFileHeader.h().equals(EncryptionMethod.AES)) {
            return localFileHeader.c().c().f() + 12;
        }
        return localFileHeader.h().equals(EncryptionMethod.ZIP_STANDARD) ? 12 : 0;
    }

    private CipherInputStream k(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader) throws IOException {
        if (!localFileHeader.u()) {
            return new NoCipherInputStream(zipEntryInputStream, localFileHeader, this.Z);
        }
        if (localFileHeader.h() == EncryptionMethod.AES) {
            return new AesCipherInputStream(zipEntryInputStream, localFileHeader, this.Z);
        }
        if (localFileHeader.h() == EncryptionMethod.ZIP_STANDARD) {
            return new ZipStandardCipherInputStream(zipEntryInputStream, localFileHeader, this.Z);
        }
        throw new ZipException(String.format("Entry [%s] Strong Encryption not supported", new Object[]{localFileHeader.k()}), ZipException.Type.UNSUPPORTED_ENCRYPTION);
    }

    private DecompressedInputStream n(CipherInputStream cipherInputStream, LocalFileHeader localFileHeader) {
        return Zip4jUtil.g(localFileHeader) == CompressionMethod.DEFLATE ? new InflaterInputStream(cipherInputStream) : new StoreInputStream(cipherInputStream);
    }

    private DecompressedInputStream p(LocalFileHeader localFileHeader) throws IOException {
        return n(k(new ZipEntryInputStream(this.s, e(localFileHeader)), localFileHeader), localFileHeader);
    }

    private boolean q(LocalFileHeader localFileHeader) {
        return localFileHeader.u() && EncryptionMethod.ZIP_STANDARD.equals(localFileHeader.h());
    }

    private boolean r(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    private void s() throws IOException {
        if (this.X2.s() && !this.a3) {
            DataDescriptor i2 = this.Y.i(this.s, b(this.X2.i()));
            this.X2.x(i2.c());
            this.X2.M(i2.e());
            this.X2.z(i2.d());
        }
    }

    private void t() throws IOException {
        if (!this.X2.t() && this.X2.d() != 0) {
            if (this.Z2 == null) {
                this.Z2 = new byte[512];
            }
            do {
            } while (read(this.Z2) != -1);
        }
    }

    private void u() {
        this.X2 = null;
        this.Y2.reset();
    }

    private void v() throws IOException {
        if ((this.X2.h() != EncryptionMethod.AES || !this.X2.c().d().equals(AesVersion.TWO)) && this.X2.f() != this.Y2.getValue()) {
            ZipException.Type type = ZipException.Type.CHECKSUM_MISMATCH;
            if (q(this.X2)) {
                type = ZipException.Type.WRONG_PASSWORD;
            }
            throw new ZipException("Reached end of entry, but crc verification failed for " + this.X2.k(), type);
        }
    }

    private void w(LocalFileHeader localFileHeader) throws IOException {
        if (!r(localFileHeader.k()) && localFileHeader.e() == CompressionMethod.STORE && localFileHeader.p() < 0) {
            throw new IOException("Invalid local file header for: " + localFileHeader.k() + ". Uncompressed size has to be set for entry of compression type store which is not a directory");
        }
    }

    public void close() throws IOException {
        DecompressedInputStream decompressedInputStream = this.X;
        if (decompressedInputStream != null) {
            decompressedInputStream.close();
        }
    }

    public int d() throws IOException {
        return this.s.available();
    }

    public LocalFileHeader h() throws IOException {
        return i((FileHeader) null);
    }

    public LocalFileHeader i(FileHeader fileHeader) throws IOException {
        boolean z;
        if (this.X2 != null) {
            t();
        }
        LocalFileHeader o = this.Y.o(this.s, this.b3);
        this.X2 = o;
        if (o == null) {
            return null;
        }
        w(o);
        this.Y2.reset();
        if (fileHeader != null) {
            this.X2.z(fileHeader.f());
            this.X2.x(fileHeader.d());
            this.X2.M(fileHeader.p());
            z = true;
        } else {
            z = false;
        }
        this.a3 = z;
        this.X = p(this.X2);
        return this.X2;
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    public ZipInputStream(InputStream inputStream, Charset charset) {
        this(inputStream, (char[]) null, charset);
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public ZipInputStream(InputStream inputStream, char[] cArr) {
        this(inputStream, cArr, InternalZipConstants.u);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 < 0) {
            throw new IllegalArgumentException("Negative read length");
        } else if (i3 == 0) {
            return 0;
        } else {
            if (this.X2 == null) {
                return -1;
            }
            try {
                int read = this.X.read(bArr, i2, i3);
                if (read == -1) {
                    c();
                } else {
                    this.Y2.update(bArr, i2, read);
                }
                return read;
            } catch (IOException e2) {
                if (e2.getCause() == null || !(e2.getCause() instanceof DataFormatException) || !q(this.X2)) {
                    throw e2;
                }
                throw new ZipException(e2.getMessage(), e2.getCause(), ZipException.Type.WRONG_PASSWORD);
            }
        }
    }

    public ZipInputStream(InputStream inputStream, char[] cArr, Charset charset) {
        this.Y = new HeaderReader();
        this.Y2 = new CRC32();
        this.a3 = false;
        charset = charset == null ? InternalZipConstants.u : charset;
        this.s = new PushbackInputStream(inputStream, 4096);
        this.Z = cArr;
        this.b3 = charset;
    }
}

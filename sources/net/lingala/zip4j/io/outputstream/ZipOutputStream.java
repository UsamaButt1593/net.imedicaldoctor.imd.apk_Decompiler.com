package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.CRC32;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.FileHeaderFactory;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;

public class ZipOutputStream extends OutputStream {
    private char[] X;
    private FileHeader X2;
    private ZipModel Y;
    private LocalFileHeader Y2;
    private CompressedOutputStream Z;
    private FileHeaderFactory Z2;
    private HeaderWriter a3;
    private CRC32 b3;
    private RawIO c3;
    private long d3;
    private Charset e3;
    private boolean f3;
    private CountingOutputStream s;

    public ZipOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, (char[]) null, InternalZipConstants.u);
    }

    private void c() throws IOException {
        if (this.f3) {
            throw new IOException("Stream is closed");
        }
    }

    private void d(ZipParameters zipParameters) throws IOException {
        FileHeader d2 = this.Z2.d(zipParameters, this.s.i(), this.s.b(), this.e3, this.c3);
        this.X2 = d2;
        d2.b0(this.s.f());
        LocalFileHeader f2 = this.Z2.f(this.X2);
        this.Y2 = f2;
        this.a3.q(this.Y, f2, this.s, this.e3);
    }

    private CipherOutputStream e(ZipEntryOutputStream zipEntryOutputStream, ZipParameters zipParameters) throws IOException {
        if (!zipParameters.o()) {
            return new NoCipherOutputStream(zipEntryOutputStream, zipParameters, (char[]) null);
        }
        char[] cArr = this.X;
        if (cArr == null || cArr.length == 0) {
            throw new ZipException("password not set");
        } else if (zipParameters.f() == EncryptionMethod.AES) {
            return new AesCipherOutputStream(zipEntryOutputStream, zipParameters, this.X);
        } else {
            if (zipParameters.f() == EncryptionMethod.ZIP_STANDARD) {
                return new ZipStandardCipherOutputStream(zipEntryOutputStream, zipParameters, this.X);
            }
            throw new ZipException("Invalid encryption method");
        }
    }

    private CompressedOutputStream f(CipherOutputStream cipherOutputStream, ZipParameters zipParameters) {
        return zipParameters.d() == CompressionMethod.DEFLATE ? new DeflaterOutputStream(cipherOutputStream, zipParameters.c()) : new StoreOutputStream(cipherOutputStream);
    }

    private CompressedOutputStream h(ZipParameters zipParameters) throws IOException {
        return f(e(new ZipEntryOutputStream(this.s), zipParameters), zipParameters);
    }

    private ZipModel i(ZipModel zipModel, CountingOutputStream countingOutputStream) {
        if (zipModel == null) {
            zipModel = new ZipModel();
        }
        if (countingOutputStream.i()) {
            zipModel.x(true);
            zipModel.y(countingOutputStream.h());
        }
        return zipModel;
    }

    private boolean k(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    private void p() throws IOException {
        this.d3 = 0;
        this.b3.reset();
        this.Z.close();
    }

    private void r(ZipParameters zipParameters) {
        if (zipParameters.d() == CompressionMethod.STORE && zipParameters.h() < 0 && !k(zipParameters.k()) && zipParameters.u()) {
            throw new IllegalArgumentException("uncompressed size should be set for zip entries of compression type store");
        }
    }

    private boolean s(FileHeader fileHeader) {
        if (!fileHeader.u() || !fileHeader.h().equals(EncryptionMethod.AES)) {
            return true;
        }
        return fileHeader.c().d().equals(AesVersion.ONE);
    }

    private void t() throws IOException {
        if (this.s.i()) {
            this.c3.o(this.s, (int) HeaderSignature.SPLIT_ZIP.a());
        }
    }

    public FileHeader b() throws IOException {
        this.Z.b();
        long c2 = this.Z.c();
        this.X2.x(c2);
        this.Y2.x(c2);
        this.X2.M(this.d3);
        this.Y2.M(this.d3);
        if (s(this.X2)) {
            this.X2.z(this.b3.getValue());
            this.Y2.z(this.b3.getValue());
        }
        this.Y.f().add(this.Y2);
        this.Y.b().b().add(this.X2);
        if (this.Y2.s()) {
            this.a3.o(this.Y2, this.s);
        }
        p();
        return this.X2;
    }

    public void close() throws IOException {
        this.Y.e().o(this.s.e());
        this.a3.d(this.Y, this.s, this.e3);
        this.s.close();
        this.f3 = true;
    }

    public void n(ZipParameters zipParameters) throws IOException {
        r(zipParameters);
        d(zipParameters);
        this.Z = h(zipParameters);
    }

    public void q(String str) throws IOException {
        c();
        this.Y.e().k(str);
    }

    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public ZipOutputStream(OutputStream outputStream, Charset charset) throws IOException {
        this(outputStream, (char[]) null, charset);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr) throws IOException {
        this(outputStream, cArr, InternalZipConstants.u);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        c();
        this.b3.update(bArr, i2, i3);
        this.Z.write(bArr, i2, i3);
        this.d3 += (long) i3;
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr, Charset charset) throws IOException {
        this(outputStream, cArr, charset, new ZipModel());
    }

    public ZipOutputStream(OutputStream outputStream, char[] cArr, Charset charset, ZipModel zipModel) throws IOException {
        this.Z2 = new FileHeaderFactory();
        this.a3 = new HeaderWriter();
        this.b3 = new CRC32();
        this.c3 = new RawIO();
        this.d3 = 0;
        charset = charset == null ? InternalZipConstants.u : charset;
        CountingOutputStream countingOutputStream = new CountingOutputStream(outputStream);
        this.s = countingOutputStream;
        this.X = cArr;
        this.e3 = charset;
        this.Y = i(zipModel, countingOutputStream);
        this.f3 = false;
        t();
    }
}

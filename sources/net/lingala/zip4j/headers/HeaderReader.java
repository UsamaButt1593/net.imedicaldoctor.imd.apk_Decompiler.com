package net.lingala.zip4j.headers;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.DataDescriptor;
import net.lingala.zip4j.model.DigitalSignature;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.Zip64ExtendedInfo;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;

public class HeaderReader {

    /* renamed from: a  reason: collision with root package name */
    private ZipModel f30573a;

    /* renamed from: b  reason: collision with root package name */
    private RawIO f30574b = new RawIO();

    /* renamed from: c  reason: collision with root package name */
    private byte[] f30575c = new byte[4];

    private long a(RandomAccessFile randomAccessFile) throws IOException {
        byte[] bArr = new byte[4096];
        long filePointer = randomAccessFile.getFilePointer();
        do {
            int i2 = filePointer > PlaybackStateCompat.r3 ? 4096 : (int) filePointer;
            filePointer = (filePointer - ((long) i2)) + 4;
            if (filePointer == 4) {
                filePointer = 0;
            }
            v(randomAccessFile, filePointer);
            randomAccessFile.read(bArr, 0, i2);
            for (int i3 = 0; i3 < i2 - 3; i3++) {
                if (((long) this.f30574b.e(bArr, i3)) == HeaderSignature.END_OF_CENTRAL_DIRECTORY.a()) {
                    return filePointer + ((long) i3);
                }
            }
        } while (filePointer > 0);
        throw new ZipException("Zip headers not found. Probably not a zip file");
    }

    private long b(ZipModel zipModel) {
        return zipModel.p() ? zipModel.l().i() : (long) zipModel.e().i();
    }

    private List<ExtraDataRecord> c(byte[] bArr, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < i2) {
            ExtraDataRecord extraDataRecord = new ExtraDataRecord();
            extraDataRecord.g((long) this.f30574b.m(bArr, i3));
            int m2 = this.f30574b.m(bArr, i3 + 2);
            extraDataRecord.h(m2);
            int i4 = i3 + 4;
            if (m2 > 0) {
                byte[] bArr2 = new byte[m2];
                System.arraycopy(bArr, i4, bArr2, 0, m2);
                extraDataRecord.f(bArr2);
            }
            i3 = i4 + m2;
            arrayList.add(extraDataRecord);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private AESExtraDataRecord d(List<ExtraDataRecord> list, RawIO rawIO) throws ZipException {
        if (list == null) {
            return null;
        }
        for (ExtraDataRecord next : list) {
            if (next != null) {
                long d2 = next.d();
                HeaderSignature headerSignature = HeaderSignature.AES_EXTRA_DATA_RECORD;
                if (d2 == headerSignature.a()) {
                    if (next.c() != null) {
                        AESExtraDataRecord aESExtraDataRecord = new AESExtraDataRecord();
                        aESExtraDataRecord.b(headerSignature);
                        aESExtraDataRecord.k(next.e());
                        byte[] c2 = next.c();
                        aESExtraDataRecord.i(AesVersion.a(rawIO.m(c2, 0)));
                        byte[] bArr = new byte[2];
                        System.arraycopy(c2, 2, bArr, 0, 2);
                        aESExtraDataRecord.l(new String(bArr));
                        aESExtraDataRecord.h(AesKeyStrength.a(c2[4] & 255));
                        aESExtraDataRecord.j(CompressionMethod.b(rawIO.m(c2, 5)));
                        return aESExtraDataRecord;
                    }
                    throw new ZipException("corrupt AES extra data records");
                }
            }
        }
        return null;
    }

    private void e(FileHeader fileHeader, RawIO rawIO) throws ZipException {
        AESExtraDataRecord d2;
        if (fileHeader.i() != null && fileHeader.i().size() > 0 && (d2 = d(fileHeader.i(), rawIO)) != null) {
            fileHeader.w(d2);
            fileHeader.E(EncryptionMethod.AES);
        }
    }

    private void f(LocalFileHeader localFileHeader, RawIO rawIO) throws ZipException {
        AESExtraDataRecord d2;
        if (localFileHeader.i() != null && localFileHeader.i().size() > 0 && (d2 = d(localFileHeader.i(), rawIO)) != null) {
            localFileHeader.w(d2);
            localFileHeader.E(EncryptionMethod.AES);
        }
    }

    private CentralDirectory h(RandomAccessFile randomAccessFile, RawIO rawIO, Charset charset) throws IOException {
        RandomAccessFile randomAccessFile2 = randomAccessFile;
        RawIO rawIO2 = rawIO;
        Charset charset2 = charset;
        CentralDirectory centralDirectory = new CentralDirectory();
        ArrayList arrayList = new ArrayList();
        long f2 = HeaderUtil.f(this.f30573a);
        long b2 = b(this.f30573a);
        randomAccessFile2.seek(f2);
        int i2 = 2;
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int i3 = 0;
        int i4 = 0;
        while (((long) i4) < b2) {
            FileHeader fileHeader = new FileHeader();
            byte[] bArr3 = bArr2;
            long c2 = (long) rawIO2.c(randomAccessFile2);
            HeaderSignature headerSignature = HeaderSignature.CENTRAL_DIRECTORY;
            if (c2 == headerSignature.a()) {
                fileHeader.b(headerSignature);
                fileHeader.c0(rawIO2.l(randomAccessFile2));
                fileHeader.N(rawIO2.l(randomAccessFile2));
                byte[] bArr4 = new byte[i2];
                randomAccessFile2.readFully(bArr4);
                fileHeader.D(BitUtils.a(bArr4[i3], i3));
                fileHeader.B(BitUtils.a(bArr4[i3], 3));
                fileHeader.J(BitUtils.a(bArr4[1], 3));
                fileHeader.K((byte[]) bArr4.clone());
                fileHeader.y(CompressionMethod.b(rawIO2.l(randomAccessFile2)));
                fileHeader.L((long) rawIO2.c(randomAccessFile2));
                byte[] bArr5 = bArr3;
                randomAccessFile2.readFully(bArr5);
                fileHeader.z(rawIO2.j(bArr5, i3));
                fileHeader.A(bArr5);
                fileHeader.x(rawIO2.i(randomAccessFile2, 4));
                fileHeader.M(rawIO2.i(randomAccessFile2, 4));
                int l2 = rawIO2.l(randomAccessFile2);
                fileHeader.I(l2);
                fileHeader.G(rawIO2.l(randomAccessFile2));
                int l3 = rawIO2.l(randomAccessFile2);
                fileHeader.Z(l3);
                fileHeader.W(rawIO2.l(randomAccessFile2));
                byte[] bArr6 = bArr;
                randomAccessFile2.readFully(bArr6);
                fileHeader.a0((byte[]) bArr6.clone());
                randomAccessFile2.readFully(bArr5);
                fileHeader.X((byte[]) bArr5.clone());
                randomAccessFile2.readFully(bArr5);
                long j2 = b2;
                fileHeader.b0(rawIO2.j(bArr5, 0));
                if (l2 > 0) {
                    byte[] bArr7 = new byte[l2];
                    randomAccessFile2.readFully(bArr7);
                    String b3 = HeaderUtil.b(bArr7, fileHeader.v(), charset2);
                    if (b3.contains(":\\")) {
                        b3 = b3.substring(b3.indexOf(":\\") + 2);
                    }
                    fileHeader.H(b3);
                    fileHeader.C(b3.endsWith("/") || b3.endsWith("\\"));
                } else {
                    fileHeader.H((String) null);
                }
                n(randomAccessFile2, fileHeader);
                s(fileHeader, rawIO2);
                e(fileHeader, rawIO2);
                if (l3 > 0) {
                    byte[] bArr8 = new byte[l3];
                    randomAccessFile2.readFully(bArr8);
                    fileHeader.Y(HeaderUtil.b(bArr8, fileHeader.v(), charset2));
                }
                if (fileHeader.u()) {
                    fileHeader.E(fileHeader.c() != null ? EncryptionMethod.AES : EncryptionMethod.ZIP_STANDARD);
                }
                arrayList.add(fileHeader);
                i4++;
                bArr = bArr6;
                bArr2 = bArr5;
                b2 = j2;
                i2 = 2;
                i3 = 0;
            } else {
                throw new ZipException("Expected central directory entry not found (#" + (i4 + 1) + ")");
            }
        }
        centralDirectory.d(arrayList);
        DigitalSignature digitalSignature = new DigitalSignature();
        HeaderSignature headerSignature2 = HeaderSignature.DIGITAL_SIGNATURE;
        if (((long) rawIO2.c(randomAccessFile2)) == headerSignature2.a()) {
            digitalSignature.b(headerSignature2);
            digitalSignature.f(rawIO2.l(randomAccessFile2));
            if (digitalSignature.d() > 0) {
                byte[] bArr9 = new byte[digitalSignature.d()];
                randomAccessFile2.readFully(bArr9);
                digitalSignature.e(new String(bArr9));
            }
        }
        return centralDirectory;
    }

    private EndOfCentralDirectoryRecord j(RandomAccessFile randomAccessFile, RawIO rawIO, Charset charset) throws IOException {
        long length = randomAccessFile.length() - 22;
        v(randomAccessFile, length);
        HeaderSignature headerSignature = HeaderSignature.END_OF_CENTRAL_DIRECTORY;
        if (((long) rawIO.c(randomAccessFile)) != headerSignature.a()) {
            length = a(randomAccessFile);
            randomAccessFile.seek(4 + length);
        }
        EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = new EndOfCentralDirectoryRecord();
        endOfCentralDirectoryRecord.b(headerSignature);
        endOfCentralDirectoryRecord.l(rawIO.l(randomAccessFile));
        endOfCentralDirectoryRecord.m(rawIO.l(randomAccessFile));
        endOfCentralDirectoryRecord.r(rawIO.l(randomAccessFile));
        endOfCentralDirectoryRecord.q(rawIO.l(randomAccessFile));
        endOfCentralDirectoryRecord.p(rawIO.c(randomAccessFile));
        endOfCentralDirectoryRecord.n(length);
        randomAccessFile.readFully(this.f30575c);
        boolean z = false;
        endOfCentralDirectoryRecord.o(rawIO.j(this.f30575c, 0));
        endOfCentralDirectoryRecord.k(u(randomAccessFile, rawIO.l(randomAccessFile), charset));
        ZipModel zipModel = this.f30573a;
        if (endOfCentralDirectoryRecord.d() > 0) {
            z = true;
        }
        zipModel.x(z);
        return endOfCentralDirectoryRecord;
    }

    private List<ExtraDataRecord> k(InputStream inputStream, int i2) throws IOException {
        if (i2 >= 4) {
            byte[] bArr = new byte[i2];
            Zip4jUtil.i(inputStream, bArr);
            try {
                return c(bArr, i2);
            } catch (Exception unused) {
                return Collections.emptyList();
            }
        } else if (i2 <= 0) {
            return null;
        } else {
            inputStream.skip((long) i2);
            return null;
        }
    }

    private List<ExtraDataRecord> l(RandomAccessFile randomAccessFile, int i2) throws IOException {
        if (i2 >= 4) {
            byte[] bArr = new byte[i2];
            randomAccessFile.read(bArr);
            try {
                return c(bArr, i2);
            } catch (Exception unused) {
                return Collections.emptyList();
            }
        } else if (i2 <= 0) {
            return null;
        } else {
            randomAccessFile.skipBytes(i2);
            return null;
        }
    }

    private void m(InputStream inputStream, LocalFileHeader localFileHeader) throws IOException {
        int j2 = localFileHeader.j();
        if (j2 > 0) {
            localFileHeader.F(k(inputStream, j2));
        }
    }

    private void n(RandomAccessFile randomAccessFile, FileHeader fileHeader) throws IOException {
        int j2 = fileHeader.j();
        if (j2 > 0) {
            fileHeader.F(l(randomAccessFile, j2));
        }
    }

    private Zip64EndOfCentralDirectoryRecord p(RandomAccessFile randomAccessFile, RawIO rawIO) throws IOException {
        if (this.f30573a.i() != null) {
            long d2 = this.f30573a.i().d();
            if (d2 >= 0) {
                randomAccessFile.seek(d2);
                Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = new Zip64EndOfCentralDirectoryRecord();
                long c2 = (long) rawIO.c(randomAccessFile);
                HeaderSignature headerSignature = HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD;
                if (c2 == headerSignature.a()) {
                    zip64EndOfCentralDirectoryRecord.b(headerSignature);
                    zip64EndOfCentralDirectoryRecord.r(rawIO.h(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.u(rawIO.l(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.v(rawIO.l(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.n(rawIO.c(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.o(rawIO.c(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.t(rawIO.h(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.s(rawIO.h(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.q(rawIO.h(randomAccessFile));
                    zip64EndOfCentralDirectoryRecord.p(rawIO.h(randomAccessFile));
                    long h2 = zip64EndOfCentralDirectoryRecord.h() - 44;
                    if (h2 > 0) {
                        byte[] bArr = new byte[((int) h2)];
                        randomAccessFile.readFully(bArr);
                        zip64EndOfCentralDirectoryRecord.m(bArr);
                    }
                    return zip64EndOfCentralDirectoryRecord;
                }
                throw new ZipException("invalid signature for zip64 end of central directory record");
            }
            throw new ZipException("invalid offset for start of end of central directory record");
        }
        throw new ZipException("invalid zip64 end of central directory locator");
    }

    private Zip64EndOfCentralDirectoryLocator q(RandomAccessFile randomAccessFile, RawIO rawIO, long j2) throws IOException {
        Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator = new Zip64EndOfCentralDirectoryLocator();
        w(randomAccessFile, j2);
        HeaderSignature headerSignature = HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR;
        if (((long) rawIO.c(randomAccessFile)) == headerSignature.a()) {
            this.f30573a.D(true);
            zip64EndOfCentralDirectoryLocator.b(headerSignature);
            zip64EndOfCentralDirectoryLocator.f(rawIO.c(randomAccessFile));
            zip64EndOfCentralDirectoryLocator.g(rawIO.h(randomAccessFile));
            zip64EndOfCentralDirectoryLocator.h(rawIO.c(randomAccessFile));
            return zip64EndOfCentralDirectoryLocator;
        }
        this.f30573a.D(false);
        return null;
    }

    private Zip64ExtendedInfo r(List<ExtraDataRecord> list, RawIO rawIO, long j2, long j3, long j4, int i2) {
        RawIO rawIO2 = rawIO;
        for (ExtraDataRecord next : list) {
            if (next != null) {
                if (HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.a() == next.d()) {
                    Zip64ExtendedInfo zip64ExtendedInfo = new Zip64ExtendedInfo();
                    byte[] c2 = next.c();
                    if (next.e() <= 0) {
                        return null;
                    }
                    int i3 = 0;
                    if (next.e() > 0 && j2 == InternalZipConstants.f30717k) {
                        zip64ExtendedInfo.l(rawIO.j(c2, 0));
                        i3 = 8;
                    }
                    if (i3 < next.e() && j3 == InternalZipConstants.f30717k) {
                        zip64ExtendedInfo.h(rawIO.j(c2, i3));
                        i3 += 8;
                    }
                    if (i3 < next.e() && j4 == InternalZipConstants.f30717k) {
                        zip64ExtendedInfo.j(rawIO.j(c2, i3));
                        i3 += 8;
                    }
                    if (i3 < next.e() && i2 == 65535) {
                        zip64ExtendedInfo.i(rawIO.e(c2, i3));
                    }
                    return zip64ExtendedInfo;
                }
                int i4 = i2;
            }
        }
        return null;
    }

    private void s(FileHeader fileHeader, RawIO rawIO) throws ZipException {
        Zip64ExtendedInfo r;
        if (fileHeader.i() != null && fileHeader.i().size() > 0 && (r = r(fileHeader.i(), rawIO, fileHeader.p(), fileHeader.d(), fileHeader.U(), fileHeader.P())) != null) {
            fileHeader.O(r);
            if (r.g() != -1) {
                fileHeader.M(r.g());
            }
            if (r.c() != -1) {
                fileHeader.x(r.c());
            }
            if (r.e() != -1) {
                fileHeader.b0(r.e());
            }
            if (r.d() != -1) {
                fileHeader.W(r.d());
            }
        }
    }

    private void t(LocalFileHeader localFileHeader, RawIO rawIO) throws ZipException {
        Zip64ExtendedInfo r;
        if (localFileHeader == null) {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        } else if (localFileHeader.i() != null && localFileHeader.i().size() > 0 && (r = r(localFileHeader.i(), rawIO, localFileHeader.p(), localFileHeader.d(), 0, 0)) != null) {
            localFileHeader.O(r);
            if (r.g() != -1) {
                localFileHeader.M(r.g());
            }
            if (r.c() != -1) {
                localFileHeader.x(r.c());
            }
        }
    }

    private String u(RandomAccessFile randomAccessFile, int i2, Charset charset) {
        if (i2 <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i2];
            randomAccessFile.readFully(bArr);
            return new String(bArr, charset);
        } catch (IOException unused) {
            return null;
        }
    }

    private void v(RandomAccessFile randomAccessFile, long j2) throws IOException {
        if (randomAccessFile instanceof NumberedSplitRandomAccessFile) {
            ((NumberedSplitRandomAccessFile) randomAccessFile).e(j2);
        } else {
            randomAccessFile.seek(j2);
        }
    }

    private void w(RandomAccessFile randomAccessFile, long j2) throws IOException {
        v(randomAccessFile, j2 - 20);
    }

    public ZipModel g(RandomAccessFile randomAccessFile, Charset charset) throws IOException {
        ZipModel zipModel;
        boolean z;
        if (randomAccessFile.length() >= 22) {
            ZipModel zipModel2 = new ZipModel();
            this.f30573a = zipModel2;
            try {
                zipModel2.u(j(randomAccessFile, this.f30574b, charset));
                if (this.f30573a.e().i() == 0) {
                    return this.f30573a;
                }
                ZipModel zipModel3 = this.f30573a;
                zipModel3.A(q(randomAccessFile, this.f30574b, zipModel3.e().f()));
                if (this.f30573a.p()) {
                    this.f30573a.B(p(randomAccessFile, this.f30574b));
                    if (this.f30573a.l() == null || this.f30573a.l().d() <= 0) {
                        zipModel = this.f30573a;
                        z = false;
                    } else {
                        zipModel = this.f30573a;
                        z = true;
                    }
                    zipModel.x(z);
                }
                this.f30573a.r(h(randomAccessFile, this.f30574b, charset));
                return this.f30573a;
            } catch (ZipException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new ZipException("Zip headers not found. Probably not a zip file or a corrupted zip file", (Exception) e3);
            }
        } else {
            throw new ZipException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        }
    }

    public DataDescriptor i(InputStream inputStream, boolean z) throws IOException {
        long b2;
        DataDescriptor dataDescriptor = new DataDescriptor();
        byte[] bArr = new byte[4];
        Zip4jUtil.i(inputStream, bArr);
        long j2 = this.f30574b.j(bArr, 0);
        HeaderSignature headerSignature = HeaderSignature.EXTRA_DATA_RECORD;
        if (j2 == headerSignature.a()) {
            dataDescriptor.b(headerSignature);
            Zip4jUtil.i(inputStream, bArr);
            dataDescriptor.g(this.f30574b.j(bArr, 0));
        } else {
            dataDescriptor.g(j2);
        }
        if (z) {
            dataDescriptor.f(this.f30574b.f(inputStream));
            b2 = this.f30574b.f(inputStream);
        } else {
            dataDescriptor.f((long) this.f30574b.b(inputStream));
            b2 = (long) this.f30574b.b(inputStream);
        }
        dataDescriptor.h(b2);
        return dataDescriptor;
    }

    public LocalFileHeader o(InputStream inputStream, Charset charset) throws IOException {
        LocalFileHeader localFileHeader = new LocalFileHeader();
        byte[] bArr = new byte[4];
        HeaderSignature headerSignature = HeaderSignature.LOCAL_FILE_HEADER;
        if (((long) this.f30574b.b(inputStream)) != headerSignature.a()) {
            return null;
        }
        localFileHeader.b(headerSignature);
        localFileHeader.N(this.f30574b.k(inputStream));
        byte[] bArr2 = new byte[2];
        if (Zip4jUtil.i(inputStream, bArr2) == 2) {
            localFileHeader.D(BitUtils.a(bArr2[0], 0));
            localFileHeader.B(BitUtils.a(bArr2[0], 3));
            boolean z = true;
            localFileHeader.J(BitUtils.a(bArr2[1], 3));
            localFileHeader.K((byte[]) bArr2.clone());
            localFileHeader.y(CompressionMethod.b(this.f30574b.k(inputStream)));
            localFileHeader.L((long) this.f30574b.b(inputStream));
            Zip4jUtil.i(inputStream, bArr);
            localFileHeader.z(this.f30574b.j(bArr, 0));
            localFileHeader.A((byte[]) bArr.clone());
            localFileHeader.x(this.f30574b.g(inputStream, 4));
            localFileHeader.M(this.f30574b.g(inputStream, 4));
            int k2 = this.f30574b.k(inputStream);
            localFileHeader.I(k2);
            localFileHeader.G(this.f30574b.k(inputStream));
            if (k2 > 0) {
                byte[] bArr3 = new byte[k2];
                Zip4jUtil.i(inputStream, bArr3);
                String b2 = HeaderUtil.b(bArr3, localFileHeader.v(), charset);
                if (b2 != null) {
                    if (b2.contains(":" + System.getProperty("file.separator"))) {
                        b2 = b2.substring(b2.indexOf(":" + System.getProperty("file.separator")) + 2);
                    }
                    localFileHeader.H(b2);
                    if (!b2.endsWith("/") && !b2.endsWith("\\")) {
                        z = false;
                    }
                    localFileHeader.C(z);
                } else {
                    throw new ZipException("file name is null, cannot assign file name to local file header");
                }
            } else {
                localFileHeader.H((String) null);
            }
            m(inputStream, localFileHeader);
            t(localFileHeader, this.f30574b);
            f(localFileHeader, this.f30574b);
            if (localFileHeader.u() && localFileHeader.h() != EncryptionMethod.AES) {
                localFileHeader.E(BigInteger.valueOf((long) localFileHeader.m()[0]).testBit(6) ? EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG : EncryptionMethod.ZIP_STANDARD);
            }
            return localFileHeader;
        }
        throw new ZipException("Could not read enough bytes for generalPurposeFlags");
    }
}

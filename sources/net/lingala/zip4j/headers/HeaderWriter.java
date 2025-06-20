package net.lingala.zip4j.headers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.outputstream.CountingOutputStream;
import net.lingala.zip4j.io.outputstream.OutputStreamWithSplitZipSupport;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryLocator;
import net.lingala.zip4j.model.Zip64EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;

public class HeaderWriter {

    /* renamed from: d  reason: collision with root package name */
    private static final short f30576d = 16;

    /* renamed from: e  reason: collision with root package name */
    private static final short f30577e = 28;

    /* renamed from: f  reason: collision with root package name */
    private static final short f30578f = 11;

    /* renamed from: a  reason: collision with root package name */
    private RawIO f30579a = new RawIO();

    /* renamed from: b  reason: collision with root package name */
    private byte[] f30580b = new byte[8];

    /* renamed from: c  reason: collision with root package name */
    private byte[] f30581c = new byte[4];

    private Zip64EndOfCentralDirectoryRecord a(ZipModel zipModel, int i2, long j2) throws ZipException {
        Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord = new Zip64EndOfCentralDirectoryRecord();
        zip64EndOfCentralDirectoryRecord.b(HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD);
        zip64EndOfCentralDirectoryRecord.r(44);
        if (!(zipModel.b() == null || zipModel.b().b() == null || zipModel.b().b().size() <= 0)) {
            FileHeader fileHeader = zipModel.b().b().get(0);
            zip64EndOfCentralDirectoryRecord.u(fileHeader.V());
            zip64EndOfCentralDirectoryRecord.v(fileHeader.q());
        }
        zip64EndOfCentralDirectoryRecord.n(zipModel.e().d());
        zip64EndOfCentralDirectoryRecord.o(zipModel.e().e());
        long size = (long) zipModel.b().b().size();
        zip64EndOfCentralDirectoryRecord.t(zipModel.o() ? c(zipModel.b().b(), zipModel.e().d()) : size);
        zip64EndOfCentralDirectoryRecord.s(size);
        zip64EndOfCentralDirectoryRecord.q((long) i2);
        zip64EndOfCentralDirectoryRecord.p(j2);
        return zip64EndOfCentralDirectoryRecord;
    }

    private int b(FileHeader fileHeader, boolean z) throws IOException {
        int i2 = z ? 32 : 0;
        if (fileHeader.c() != null) {
            i2 += 11;
        }
        if (fileHeader.i() != null) {
            for (ExtraDataRecord next : fileHeader.i()) {
                if (!(next.d() == HeaderSignature.AES_EXTRA_DATA_RECORD.a() || next.d() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.a())) {
                    i2 += next.e() + 4;
                }
            }
        }
        return i2;
    }

    private long c(List<FileHeader> list, int i2) throws ZipException {
        if (list != null) {
            int i3 = 0;
            for (FileHeader P : list) {
                if (P.P() == i2) {
                    i3++;
                }
            }
            return (long) i3;
        }
        throw new ZipException("file headers are null, cannot calculate number of entries on this disk");
    }

    private int f(OutputStream outputStream) {
        return outputStream instanceof SplitOutputStream ? ((SplitOutputStream) outputStream).b() : ((CountingOutputStream) outputStream).b();
    }

    private long g(ZipModel zipModel) {
        return (!zipModel.p() || zipModel.l() == null || zipModel.l().f() == -1) ? zipModel.e().g() : zipModel.l().f();
    }

    private boolean h(OutputStream outputStream) {
        if (outputStream instanceof SplitOutputStream) {
            return ((SplitOutputStream) outputStream).i();
        }
        if (outputStream instanceof CountingOutputStream) {
            return ((CountingOutputStream) outputStream).i();
        }
        return false;
    }

    private boolean i(FileHeader fileHeader) {
        return fileHeader.d() >= InternalZipConstants.f30717k || fileHeader.p() >= InternalZipConstants.f30717k || fileHeader.U() >= InternalZipConstants.f30717k || fileHeader.P() >= 65535;
    }

    private void j(ZipModel zipModel, OutputStream outputStream) throws IOException {
        int i2;
        if (outputStream instanceof OutputStreamWithSplitZipSupport) {
            OutputStreamWithSplitZipSupport outputStreamWithSplitZipSupport = (OutputStreamWithSplitZipSupport) outputStream;
            zipModel.e().o(outputStreamWithSplitZipSupport.c());
            i2 = outputStreamWithSplitZipSupport.b();
        } else {
            i2 = 0;
        }
        if (zipModel.p()) {
            if (zipModel.l() == null) {
                zipModel.B(new Zip64EndOfCentralDirectoryRecord());
            }
            if (zipModel.i() == null) {
                zipModel.A(new Zip64EndOfCentralDirectoryLocator());
            }
            zipModel.l().p(zipModel.e().g());
            zipModel.i().f(i2);
            zipModel.i().h(i2 + 1);
        }
        zipModel.e().l(i2);
        zipModel.e().m(i2);
    }

    private void k(SplitOutputStream splitOutputStream, FileHeader fileHeader) throws IOException {
        int i2 = (fileHeader.p() > InternalZipConstants.f30717k ? 1 : (fileHeader.p() == InternalZipConstants.f30717k ? 0 : -1));
        RawIO rawIO = this.f30579a;
        byte[] bArr = this.f30580b;
        if (i2 >= 0) {
            rawIO.r(bArr, 0, InternalZipConstants.f30717k);
            splitOutputStream.write(this.f30580b, 0, 4);
            splitOutputStream.write(this.f30580b, 0, 4);
            int l2 = fileHeader.l() + 8;
            if (splitOutputStream.n(l2) == l2) {
                this.f30579a.q(splitOutputStream, fileHeader.p());
                this.f30579a.q(splitOutputStream, fileHeader.d());
                return;
            }
            throw new ZipException("Unable to skip " + l2 + " bytes to update LFH");
        }
        rawIO.r(bArr, 0, fileHeader.d());
        splitOutputStream.write(this.f30580b, 0, 4);
        this.f30579a.r(this.f30580b, 0, fileHeader.p());
        splitOutputStream.write(this.f30580b, 0, 4);
    }

    private void m(ZipModel zipModel, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO, Charset charset) throws ZipException {
        if (zipModel.b() != null && zipModel.b().b() != null && zipModel.b().b().size() > 0) {
            for (FileHeader p : zipModel.b().b()) {
                p(zipModel, p, byteArrayOutputStream, rawIO, charset);
            }
        }
    }

    private void n(ZipModel zipModel, int i2, long j2, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO, Charset charset) throws IOException {
        byte[] bArr = new byte[8];
        rawIO.o(byteArrayOutputStream, (int) HeaderSignature.END_OF_CENTRAL_DIRECTORY.a());
        rawIO.s(byteArrayOutputStream, zipModel.e().d());
        rawIO.s(byteArrayOutputStream, zipModel.e().e());
        long size = (long) zipModel.b().b().size();
        long c2 = zipModel.o() ? c(zipModel.b().b(), zipModel.e().d()) : size;
        if (c2 > 65535) {
            c2 = 65535;
        }
        rawIO.s(byteArrayOutputStream, (int) c2);
        if (size > 65535) {
            size = 65535;
        }
        rawIO.s(byteArrayOutputStream, (int) size);
        rawIO.o(byteArrayOutputStream, i2);
        if (j2 > InternalZipConstants.f30717k) {
            rawIO.r(bArr, 0, InternalZipConstants.f30717k);
        } else {
            rawIO.r(bArr, 0, j2);
        }
        byteArrayOutputStream.write(bArr, 0, 4);
        String c3 = zipModel.e().c();
        if (Zip4jUtil.h(c3)) {
            byte[] bytes = c3.getBytes(charset);
            rawIO.s(byteArrayOutputStream, bytes.length);
            byteArrayOutputStream.write(bytes);
            return;
        }
        rawIO.s(byteArrayOutputStream, 0);
    }

    private void p(ZipModel zipModel, FileHeader fileHeader, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO, Charset charset) throws ZipException {
        ZipModel zipModel2 = zipModel;
        FileHeader fileHeader2 = fileHeader;
        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
        RawIO rawIO2 = rawIO;
        Charset charset2 = charset;
        if (fileHeader2 != null) {
            try {
                byte[] bArr = {0, 0};
                boolean i2 = i(fileHeader2);
                rawIO2.o(byteArrayOutputStream2, (int) fileHeader.a().a());
                rawIO2.s(byteArrayOutputStream2, fileHeader.V());
                rawIO2.s(byteArrayOutputStream2, fileHeader.q());
                byteArrayOutputStream2.write(fileHeader.m());
                rawIO2.s(byteArrayOutputStream2, fileHeader.e().a());
                rawIO2.r(this.f30580b, 0, fileHeader.n());
                byteArrayOutputStream2.write(this.f30580b, 0, 4);
                rawIO2.r(this.f30580b, 0, fileHeader.f());
                byteArrayOutputStream2.write(this.f30580b, 0, 4);
                if (i2) {
                    rawIO2.r(this.f30580b, 0, InternalZipConstants.f30717k);
                    byteArrayOutputStream2.write(this.f30580b, 0, 4);
                    byteArrayOutputStream2.write(this.f30580b, 0, 4);
                    zipModel2.D(true);
                } else {
                    rawIO2.r(this.f30580b, 0, fileHeader.d());
                    byteArrayOutputStream2.write(this.f30580b, 0, 4);
                    rawIO2.r(this.f30580b, 0, fileHeader.p());
                    byteArrayOutputStream2.write(this.f30580b, 0, 4);
                }
                byte[] bArr2 = new byte[0];
                if (Zip4jUtil.h(fileHeader.k())) {
                    bArr2 = fileHeader.k().getBytes(charset2);
                }
                rawIO2.s(byteArrayOutputStream2, bArr2.length);
                byte[] bArr3 = new byte[4];
                if (i2) {
                    rawIO2.r(this.f30580b, 0, InternalZipConstants.f30717k);
                    System.arraycopy(this.f30580b, 0, bArr3, 0, 4);
                } else {
                    rawIO2.r(this.f30580b, 0, fileHeader.U());
                    System.arraycopy(this.f30580b, 0, bArr3, 0, 4);
                }
                rawIO2.s(byteArrayOutputStream2, b(fileHeader2, i2));
                String R = fileHeader.R();
                byte[] bArr4 = new byte[0];
                if (Zip4jUtil.h(R)) {
                    bArr4 = R.getBytes(charset2);
                }
                rawIO2.s(byteArrayOutputStream2, bArr4.length);
                if (i2) {
                    rawIO2.p(this.f30581c, 0, 65535);
                    byteArrayOutputStream2.write(this.f30581c, 0, 2);
                } else {
                    rawIO2.s(byteArrayOutputStream2, fileHeader.P());
                }
                byteArrayOutputStream2.write(bArr);
                byteArrayOutputStream2.write(fileHeader.Q());
                byteArrayOutputStream2.write(bArr3);
                if (bArr2.length > 0) {
                    byteArrayOutputStream2.write(bArr2);
                }
                if (i2) {
                    zipModel2.D(true);
                    rawIO2.s(byteArrayOutputStream2, (int) HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.a());
                    rawIO2.s(byteArrayOutputStream2, 28);
                    rawIO2.q(byteArrayOutputStream2, fileHeader.p());
                    rawIO2.q(byteArrayOutputStream2, fileHeader.d());
                    rawIO2.q(byteArrayOutputStream2, fileHeader.U());
                    rawIO2.o(byteArrayOutputStream2, fileHeader.P());
                }
                if (fileHeader.c() != null) {
                    AESExtraDataRecord c2 = fileHeader.c();
                    rawIO2.s(byteArrayOutputStream2, (int) c2.a().a());
                    rawIO2.s(byteArrayOutputStream2, c2.f());
                    rawIO2.s(byteArrayOutputStream2, c2.d().b());
                    byteArrayOutputStream2.write(c2.g().getBytes());
                    byteArrayOutputStream2.write(new byte[]{(byte) c2.c().e()});
                    rawIO2.s(byteArrayOutputStream2, c2.e().a());
                }
                r(fileHeader2, byteArrayOutputStream2);
                if (bArr4.length > 0) {
                    byteArrayOutputStream2.write(bArr4);
                }
            } catch (Exception e2) {
                throw new ZipException(e2);
            }
        } else {
            throw new ZipException("input parameters is null, cannot write local file header");
        }
    }

    private void r(FileHeader fileHeader, OutputStream outputStream) throws IOException {
        if (fileHeader.i() != null && fileHeader.i().size() != 0) {
            for (ExtraDataRecord next : fileHeader.i()) {
                if (!(next.d() == HeaderSignature.AES_EXTRA_DATA_RECORD.a() || next.d() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.a())) {
                    this.f30579a.s(outputStream, (int) next.d());
                    this.f30579a.s(outputStream, next.e());
                    if (next.e() > 0 && next.c() != null) {
                        outputStream.write(next.c());
                    }
                }
            }
        }
    }

    private void s(Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO) throws IOException {
        rawIO.o(byteArrayOutputStream, (int) HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR.a());
        rawIO.o(byteArrayOutputStream, zip64EndOfCentralDirectoryLocator.c());
        rawIO.q(byteArrayOutputStream, zip64EndOfCentralDirectoryLocator.d());
        rawIO.o(byteArrayOutputStream, zip64EndOfCentralDirectoryLocator.e());
    }

    private void t(Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord, ByteArrayOutputStream byteArrayOutputStream, RawIO rawIO) throws IOException {
        rawIO.o(byteArrayOutputStream, (int) zip64EndOfCentralDirectoryRecord.a().a());
        rawIO.q(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.h());
        rawIO.s(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.k());
        rawIO.s(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.l());
        rawIO.o(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.d());
        rawIO.o(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.e());
        rawIO.q(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.j());
        rawIO.q(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.i());
        rawIO.q(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.g());
        rawIO.q(byteArrayOutputStream, zip64EndOfCentralDirectoryRecord.f());
    }

    private void u(ZipModel zipModel, OutputStream outputStream, byte[] bArr, Charset charset) throws IOException {
        if (bArr == null) {
            throw new ZipException("invalid buff to write as zip headers");
        } else if (!(outputStream instanceof CountingOutputStream) || !((CountingOutputStream) outputStream).d(bArr.length)) {
            outputStream.write(bArr);
        } else {
            d(zipModel, outputStream, charset);
        }
    }

    public void d(ZipModel zipModel, OutputStream outputStream, Charset charset) throws IOException {
        if (zipModel == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot finalize zip file");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            j(zipModel, outputStream);
            long g2 = g(zipModel);
            m(zipModel, byteArrayOutputStream, this.f30579a, charset);
            int size = byteArrayOutputStream.size();
            if (!zipModel.p() && g2 < InternalZipConstants.f30717k) {
                if (zipModel.b().b().size() >= 65535) {
                }
                n(zipModel, size, g2, byteArrayOutputStream, this.f30579a, charset);
                u(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
                byteArrayOutputStream.close();
            }
            if (zipModel.l() == null) {
                zipModel.B(new Zip64EndOfCentralDirectoryRecord());
            }
            if (zipModel.i() == null) {
                zipModel.A(new Zip64EndOfCentralDirectoryLocator());
            }
            zipModel.i().g(((long) size) + g2);
            if (h(outputStream)) {
                int f2 = f(outputStream);
                zipModel.i().f(f2);
                zipModel.i().h(f2 + 1);
            } else {
                zipModel.i().f(0);
                zipModel.i().h(1);
            }
            Zip64EndOfCentralDirectoryRecord a2 = a(zipModel, size, g2);
            zipModel.B(a2);
            t(a2, byteArrayOutputStream, this.f30579a);
            s(zipModel.i(), byteArrayOutputStream, this.f30579a);
            n(zipModel, size, g2, byteArrayOutputStream, this.f30579a, charset);
            u(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void e(ZipModel zipModel, OutputStream outputStream, Charset charset) throws IOException {
        if (zipModel == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot finalize zip file without validations");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            long g2 = zipModel.e().g();
            m(zipModel, byteArrayOutputStream, this.f30579a, charset);
            int size = byteArrayOutputStream.size();
            if (!zipModel.p() && g2 < InternalZipConstants.f30717k) {
                if (zipModel.b().b().size() >= 65535) {
                }
                n(zipModel, size, g2, byteArrayOutputStream, this.f30579a, charset);
                u(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
                byteArrayOutputStream.close();
            }
            if (zipModel.l() == null) {
                zipModel.B(new Zip64EndOfCentralDirectoryRecord());
            }
            if (zipModel.i() == null) {
                zipModel.A(new Zip64EndOfCentralDirectoryLocator());
            }
            zipModel.i().g(((long) size) + g2);
            Zip64EndOfCentralDirectoryRecord a2 = a(zipModel, size, g2);
            zipModel.B(a2);
            t(a2, byteArrayOutputStream, this.f30579a);
            s(zipModel.i(), byteArrayOutputStream, this.f30579a);
            n(zipModel, size, g2, byteArrayOutputStream, this.f30579a, charset);
            u(zipModel, outputStream, byteArrayOutputStream.toByteArray(), charset);
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void l(FileHeader fileHeader, ZipModel zipModel, SplitOutputStream splitOutputStream) throws IOException {
        boolean z;
        SplitOutputStream splitOutputStream2;
        StringBuilder sb;
        String str;
        if (fileHeader == null || zipModel == null) {
            throw new ZipException("invalid input parameters, cannot update local file header");
        }
        if (fileHeader.P() != splitOutputStream.b()) {
            String parent = zipModel.m().getParent();
            String w = FileUtils.w(zipModel.m().getName());
            String str2 = parent + System.getProperty("file.separator");
            z = true;
            if (fileHeader.P() < 9) {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(w);
                str = ".z0";
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append(w);
                str = ".z";
            }
            sb.append(str);
            sb.append(fileHeader.P() + 1);
            splitOutputStream2 = new SplitOutputStream(new File(sb.toString()));
        } else {
            splitOutputStream2 = splitOutputStream;
            z = false;
        }
        long c2 = splitOutputStream2.c();
        splitOutputStream2.k(fileHeader.U() + 14);
        this.f30579a.r(this.f30580b, 0, fileHeader.f());
        splitOutputStream2.write(this.f30580b, 0, 4);
        k(splitOutputStream2, fileHeader);
        if (z) {
            splitOutputStream2.close();
        } else {
            splitOutputStream.k(c2);
        }
    }

    public void o(LocalFileHeader localFileHeader, OutputStream outputStream) throws IOException {
        if (localFileHeader == null || outputStream == null) {
            throw new ZipException("input parameters is null, cannot write extended local header");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.f30579a.o(byteArrayOutputStream, (int) HeaderSignature.EXTRA_DATA_RECORD.a());
            this.f30579a.r(this.f30580b, 0, localFileHeader.f());
            byteArrayOutputStream.write(this.f30580b, 0, 4);
            if (localFileHeader.R()) {
                this.f30579a.q(byteArrayOutputStream, localFileHeader.d());
                this.f30579a.q(byteArrayOutputStream, localFileHeader.p());
            } else {
                this.f30579a.r(this.f30580b, 0, localFileHeader.d());
                byteArrayOutputStream.write(this.f30580b, 0, 4);
                this.f30579a.r(this.f30580b, 0, localFileHeader.p());
                byteArrayOutputStream.write(this.f30580b, 0, 4);
            }
            outputStream.write(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0071 A[Catch:{ all -> 0x006b, all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0089 A[Catch:{ all -> 0x006b, all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00b8 A[Catch:{ all -> 0x006b, all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c8 A[Catch:{ all -> 0x006b, all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00cb A[Catch:{ all -> 0x006b, all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d2 A[Catch:{ all -> 0x006b, all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00dc A[Catch:{ all -> 0x006b, all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e1 A[Catch:{ all -> 0x006b, all -> 0x0168 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010c A[Catch:{ all -> 0x006b, all -> 0x0168 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(net.lingala.zip4j.model.ZipModel r10, net.lingala.zip4j.model.LocalFileHeader r11, java.io.OutputStream r12, java.nio.charset.Charset r13) throws java.io.IOException {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            net.lingala.zip4j.util.RawIO r3 = r9.f30579a     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.headers.HeaderSignature r4 = r11.a()     // Catch:{ all -> 0x006b }
            long r4 = r4.a()     // Catch:{ all -> 0x006b }
            int r5 = (int) r4     // Catch:{ all -> 0x006b }
            r3.o(r2, r5)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r3 = r9.f30579a     // Catch:{ all -> 0x006b }
            int r4 = r11.q()     // Catch:{ all -> 0x006b }
            r3.s(r2, r4)     // Catch:{ all -> 0x006b }
            byte[] r3 = r11.m()     // Catch:{ all -> 0x006b }
            r2.write(r3)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r3 = r9.f30579a     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.model.enums.CompressionMethod r4 = r11.e()     // Catch:{ all -> 0x006b }
            int r4 = r4.a()     // Catch:{ all -> 0x006b }
            r3.s(r2, r4)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r3 = r9.f30579a     // Catch:{ all -> 0x006b }
            byte[] r4 = r9.f30580b     // Catch:{ all -> 0x006b }
            long r5 = r11.n()     // Catch:{ all -> 0x006b }
            r3.r(r4, r1, r5)     // Catch:{ all -> 0x006b }
            byte[] r3 = r9.f30580b     // Catch:{ all -> 0x006b }
            r4 = 4
            r2.write(r3, r1, r4)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r3 = r9.f30579a     // Catch:{ all -> 0x006b }
            byte[] r5 = r9.f30580b     // Catch:{ all -> 0x006b }
            long r6 = r11.f()     // Catch:{ all -> 0x006b }
            r3.r(r5, r1, r6)     // Catch:{ all -> 0x006b }
            byte[] r3 = r9.f30580b     // Catch:{ all -> 0x006b }
            r2.write(r3, r1, r4)     // Catch:{ all -> 0x006b }
            long r5 = r11.d()     // Catch:{ all -> 0x006b }
            r7 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x006e
            long r5 = r11.p()     // Catch:{ all -> 0x006b }
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x0069
            goto L_0x006e
        L_0x0069:
            r3 = 0
            goto L_0x006f
        L_0x006b:
            r10 = move-exception
            goto L_0x0167
        L_0x006e:
            r3 = 1
        L_0x006f:
            if (r3 == 0) goto L_0x0089
            net.lingala.zip4j.util.RawIO r5 = r9.f30579a     // Catch:{ all -> 0x006b }
            byte[] r6 = r9.f30580b     // Catch:{ all -> 0x006b }
            r5.r(r6, r1, r7)     // Catch:{ all -> 0x006b }
            byte[] r5 = r9.f30580b     // Catch:{ all -> 0x006b }
            r2.write(r5, r1, r4)     // Catch:{ all -> 0x006b }
            byte[] r5 = r9.f30580b     // Catch:{ all -> 0x006b }
            r2.write(r5, r1, r4)     // Catch:{ all -> 0x006b }
            r10.D(r0)     // Catch:{ all -> 0x006b }
            r11.U(r0)     // Catch:{ all -> 0x006b }
            goto L_0x00ac
        L_0x0089:
            net.lingala.zip4j.util.RawIO r10 = r9.f30579a     // Catch:{ all -> 0x006b }
            byte[] r5 = r9.f30580b     // Catch:{ all -> 0x006b }
            long r6 = r11.d()     // Catch:{ all -> 0x006b }
            r10.r(r5, r1, r6)     // Catch:{ all -> 0x006b }
            byte[] r10 = r9.f30580b     // Catch:{ all -> 0x006b }
            r2.write(r10, r1, r4)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r10 = r9.f30579a     // Catch:{ all -> 0x006b }
            byte[] r5 = r9.f30580b     // Catch:{ all -> 0x006b }
            long r6 = r11.p()     // Catch:{ all -> 0x006b }
            r10.r(r5, r1, r6)     // Catch:{ all -> 0x006b }
            byte[] r10 = r9.f30580b     // Catch:{ all -> 0x006b }
            r2.write(r10, r1, r4)     // Catch:{ all -> 0x006b }
            r11.U(r1)     // Catch:{ all -> 0x006b }
        L_0x00ac:
            byte[] r10 = new byte[r1]     // Catch:{ all -> 0x006b }
            java.lang.String r4 = r11.k()     // Catch:{ all -> 0x006b }
            boolean r4 = net.lingala.zip4j.util.Zip4jUtil.h(r4)     // Catch:{ all -> 0x006b }
            if (r4 == 0) goto L_0x00c0
            java.lang.String r10 = r11.k()     // Catch:{ all -> 0x006b }
            byte[] r10 = r10.getBytes(r13)     // Catch:{ all -> 0x006b }
        L_0x00c0:
            net.lingala.zip4j.util.RawIO r13 = r9.f30579a     // Catch:{ all -> 0x006b }
            int r4 = r10.length     // Catch:{ all -> 0x006b }
            r13.s(r2, r4)     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x00cb
            r13 = 20
            goto L_0x00cc
        L_0x00cb:
            r13 = 0
        L_0x00cc:
            net.lingala.zip4j.model.AESExtraDataRecord r4 = r11.c()     // Catch:{ all -> 0x006b }
            if (r4 == 0) goto L_0x00d4
            int r13 = r13 + 11
        L_0x00d4:
            net.lingala.zip4j.util.RawIO r4 = r9.f30579a     // Catch:{ all -> 0x006b }
            r4.s(r2, r13)     // Catch:{ all -> 0x006b }
            int r13 = r10.length     // Catch:{ all -> 0x006b }
            if (r13 <= 0) goto L_0x00df
            r2.write(r10)     // Catch:{ all -> 0x006b }
        L_0x00df:
            if (r3 == 0) goto L_0x0106
            net.lingala.zip4j.util.RawIO r10 = r9.f30579a     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.headers.HeaderSignature r13 = net.lingala.zip4j.headers.HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE     // Catch:{ all -> 0x006b }
            long r3 = r13.a()     // Catch:{ all -> 0x006b }
            int r13 = (int) r3     // Catch:{ all -> 0x006b }
            r10.s(r2, r13)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r10 = r9.f30579a     // Catch:{ all -> 0x006b }
            r13 = 16
            r10.s(r2, r13)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r10 = r9.f30579a     // Catch:{ all -> 0x006b }
            long r3 = r11.p()     // Catch:{ all -> 0x006b }
            r10.q(r2, r3)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r10 = r9.f30579a     // Catch:{ all -> 0x006b }
            long r3 = r11.d()     // Catch:{ all -> 0x006b }
            r10.q(r2, r3)     // Catch:{ all -> 0x006b }
        L_0x0106:
            net.lingala.zip4j.model.AESExtraDataRecord r10 = r11.c()     // Catch:{ all -> 0x006b }
            if (r10 == 0) goto L_0x015c
            net.lingala.zip4j.model.AESExtraDataRecord r10 = r11.c()     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r11 = r9.f30579a     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.headers.HeaderSignature r13 = r10.a()     // Catch:{ all -> 0x006b }
            long r3 = r13.a()     // Catch:{ all -> 0x006b }
            int r13 = (int) r3     // Catch:{ all -> 0x006b }
            r11.s(r2, r13)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r11 = r9.f30579a     // Catch:{ all -> 0x006b }
            int r13 = r10.f()     // Catch:{ all -> 0x006b }
            r11.s(r2, r13)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r11 = r9.f30579a     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.model.enums.AesVersion r13 = r10.d()     // Catch:{ all -> 0x006b }
            int r13 = r13.b()     // Catch:{ all -> 0x006b }
            r11.s(r2, r13)     // Catch:{ all -> 0x006b }
            java.lang.String r11 = r10.g()     // Catch:{ all -> 0x006b }
            byte[] r11 = r11.getBytes()     // Catch:{ all -> 0x006b }
            r2.write(r11)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.model.enums.AesKeyStrength r11 = r10.c()     // Catch:{ all -> 0x006b }
            int r11 = r11.e()     // Catch:{ all -> 0x006b }
            byte r11 = (byte) r11     // Catch:{ all -> 0x006b }
            byte[] r13 = new byte[r0]     // Catch:{ all -> 0x006b }
            r13[r1] = r11     // Catch:{ all -> 0x006b }
            r2.write(r13)     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.util.RawIO r11 = r9.f30579a     // Catch:{ all -> 0x006b }
            net.lingala.zip4j.model.enums.CompressionMethod r10 = r10.e()     // Catch:{ all -> 0x006b }
            int r10 = r10.a()     // Catch:{ all -> 0x006b }
            r11.s(r2, r10)     // Catch:{ all -> 0x006b }
        L_0x015c:
            byte[] r10 = r2.toByteArray()     // Catch:{ all -> 0x006b }
            r12.write(r10)     // Catch:{ all -> 0x006b }
            r2.close()
            return
        L_0x0167:
            throw r10     // Catch:{ all -> 0x0168 }
        L_0x0168:
            r11 = move-exception
            r2.close()     // Catch:{ all -> 0x016d }
            goto L_0x0171
        L_0x016d:
            r12 = move-exception
            r10.addSuppressed(r12)
        L_0x0171:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.lingala.zip4j.headers.HeaderWriter.q(net.lingala.zip4j.model.ZipModel, net.lingala.zip4j.model.LocalFileHeader, java.io.OutputStream, java.nio.charset.Charset):void");
    }
}

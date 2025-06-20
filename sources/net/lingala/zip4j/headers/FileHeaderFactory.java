package net.lingala.zip4j.headers;

import java.nio.charset.Charset;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.Zip4jUtil;
import net.lingala.zip4j.util.ZipVersionUtils;

public class FileHeaderFactory {
    private int a(String str, Charset charset) {
        return str.getBytes(charset).length;
    }

    private byte[] b(boolean z, ZipParameters zipParameters, Charset charset) {
        byte[] bArr = new byte[2];
        bArr[0] = e(z, zipParameters);
        if (charset.equals(InternalZipConstants.u)) {
            bArr[1] = BitUtils.b(bArr[1], 3);
        }
        return bArr;
    }

    private AESExtraDataRecord c(ZipParameters zipParameters) throws ZipException {
        AESExtraDataRecord aESExtraDataRecord = new AESExtraDataRecord();
        if (zipParameters.b() != null) {
            aESExtraDataRecord.i(zipParameters.b());
        }
        AesKeyStrength a2 = zipParameters.a();
        AesKeyStrength aesKeyStrength = AesKeyStrength.KEY_STRENGTH_128;
        if (a2 == aesKeyStrength || zipParameters.a() == (aesKeyStrength = AesKeyStrength.KEY_STRENGTH_192) || zipParameters.a() == (aesKeyStrength = AesKeyStrength.KEY_STRENGTH_256)) {
            aESExtraDataRecord.h(aesKeyStrength);
            aESExtraDataRecord.j(zipParameters.d());
            return aESExtraDataRecord;
        }
        throw new ZipException("invalid AES key strength");
    }

    private byte e(boolean z, ZipParameters zipParameters) {
        byte b2;
        byte b3;
        byte b4 = 0;
        if (z) {
            b4 = BitUtils.b((byte) 0, 0);
        }
        if (CompressionMethod.DEFLATE.equals(zipParameters.d())) {
            if (CompressionLevel.NORMAL.equals(zipParameters.c())) {
                b3 = BitUtils.c(b4, 1);
            } else if (CompressionLevel.MAXIMUM.equals(zipParameters.c())) {
                b3 = BitUtils.b(b4, 1);
            } else {
                if (CompressionLevel.FAST.equals(zipParameters.c())) {
                    b2 = BitUtils.c(b4, 1);
                } else if (CompressionLevel.FASTEST.equals(zipParameters.c()) || CompressionLevel.ULTRA.equals(zipParameters.c())) {
                    b2 = BitUtils.b(b4, 1);
                }
                b4 = BitUtils.b(b2, 2);
            }
            b4 = BitUtils.c(b3, 2);
        }
        return zipParameters.u() ? BitUtils.b(b4, 3) : b4;
    }

    private String g(String str) throws ZipException {
        if (Zip4jUtil.h(str)) {
            return str;
        }
        throw new ZipException("fileNameInZip is null or empty");
    }

    public FileHeader d(ZipParameters zipParameters, boolean z, int i2, Charset charset, RawIO rawIO) throws ZipException {
        FileHeader fileHeader = new FileHeader();
        fileHeader.b(HeaderSignature.CENTRAL_DIRECTORY);
        fileHeader.c0(ZipVersionUtils.a(zipParameters, rawIO));
        fileHeader.N(ZipVersionUtils.b(zipParameters).a());
        if (!zipParameters.o() || zipParameters.f() != EncryptionMethod.AES) {
            fileHeader.y(zipParameters.d());
        } else {
            fileHeader.y(CompressionMethod.AES_INTERNAL_ONLY);
            fileHeader.w(c(zipParameters));
            fileHeader.G(fileHeader.j() + 11);
        }
        if (zipParameters.o()) {
            if (zipParameters.f() == null || zipParameters.f() == EncryptionMethod.NONE) {
                throw new ZipException("Encryption method has to be set when encryptFiles flag is set in zip parameters");
            }
            fileHeader.D(true);
            fileHeader.E(zipParameters.f());
        }
        String g2 = g(zipParameters.k());
        fileHeader.H(g2);
        fileHeader.I(a(g2, charset));
        if (!z) {
            i2 = 0;
        }
        fileHeader.W(i2);
        fileHeader.L(Zip4jUtil.f(zipParameters.l() > 0 ? zipParameters.l() : System.currentTimeMillis()));
        boolean C = FileUtils.C(g2);
        fileHeader.C(C);
        fileHeader.X(FileUtils.j(C));
        if (!zipParameters.u() || zipParameters.h() != -1) {
            fileHeader.M(zipParameters.h());
        } else {
            fileHeader.M(0);
        }
        if (zipParameters.o() && zipParameters.f() == EncryptionMethod.ZIP_STANDARD) {
            fileHeader.z(zipParameters.g());
        }
        fileHeader.K(b(fileHeader.u(), zipParameters, charset));
        fileHeader.B(zipParameters.u());
        fileHeader.Y(zipParameters.j());
        return fileHeader;
    }

    public LocalFileHeader f(FileHeader fileHeader) {
        LocalFileHeader localFileHeader = new LocalFileHeader();
        localFileHeader.b(HeaderSignature.LOCAL_FILE_HEADER);
        localFileHeader.N(fileHeader.q());
        localFileHeader.y(fileHeader.e());
        localFileHeader.L(fileHeader.n());
        localFileHeader.M(fileHeader.p());
        localFileHeader.I(fileHeader.l());
        localFileHeader.H(fileHeader.k());
        localFileHeader.D(fileHeader.u());
        localFileHeader.E(fileHeader.h());
        localFileHeader.w(fileHeader.c());
        localFileHeader.z(fileHeader.f());
        localFileHeader.x(fileHeader.d());
        localFileHeader.K((byte[]) fileHeader.m().clone());
        localFileHeader.B(fileHeader.s());
        localFileHeader.G(fileHeader.j());
        return localFileHeader;
    }
}

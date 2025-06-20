package net.lingala.zip4j.util;

import androidx.media3.exoplayer.ExoPlayer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;

public class Zip4jUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final long f30724a = 2162688;

    /* renamed from: b  reason: collision with root package name */
    private static final int f30725b = 15;

    public static byte[] a(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            bArr[i2] = (byte) cArr[i2];
        }
        return bArr;
    }

    public static boolean b(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("output path is null");
        } else if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            throw new ZipException("output directory is not valid");
        } else if (file.mkdirs()) {
            return true;
        } else {
            throw new ZipException("Cannot create output directories");
        }
    }

    private static long c(long j2) {
        int i2 = (int) ((j2 << 1) & 62);
        int i3 = (int) ((j2 >> 5) & 63);
        int i4 = (int) ((j2 >> 11) & 31);
        int i5 = (int) ((j2 >> 16) & 31);
        int i6 = (int) (((j2 >> 25) & 127) + 1980);
        Calendar instance = Calendar.getInstance();
        instance.set(i6, (int) (((j2 >> 21) & 15) - 1), i5, i4, i3, i2);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static long d(long j2) {
        return c(j2) + (j2 >> 32);
    }

    private static long e(long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j2);
        int i2 = instance.get(1);
        if (i2 < 1980) {
            return f30724a;
        }
        return (long) ((instance.get(13) >> 1) | ((i2 - 1980) << 25) | ((instance.get(2) + 1) << 21) | (instance.get(5) << 16) | (instance.get(11) << 11) | (instance.get(12) << 5));
    }

    public static long f(long j2) {
        if (j2 < 0) {
            return f30724a;
        }
        long e2 = e(j2);
        return e2 != f30724a ? e2 + ((j2 % ExoPlayer.a1) << 32) : f30724a;
    }

    public static CompressionMethod g(LocalFileHeader localFileHeader) {
        if (localFileHeader.e() != CompressionMethod.AES_INTERNAL_ONLY) {
            return localFileHeader.e();
        }
        if (localFileHeader.c() != null) {
            return localFileHeader.c().e();
        }
        throw new RuntimeException("AesExtraDataRecord not present in local header for aes encrypted data");
    }

    public static boolean h(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static int i(InputStream inputStream, byte[] bArr) throws IOException {
        int read = inputStream.read(bArr);
        if (read == bArr.length || (read = k(inputStream, bArr, read)) == bArr.length) {
            return read;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    public static int j(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative offset");
        } else if (i3 >= 0) {
            int i4 = 0;
            if (i3 == 0) {
                return 0;
            }
            if (i2 + i3 <= bArr.length) {
                while (i4 != i3) {
                    int read = inputStream.read(bArr, i2 + i4, i3 - i4);
                    if (read != -1) {
                        i4 += read;
                    } else if (i4 == 0) {
                        return -1;
                    } else {
                        return i4;
                    }
                }
                return i4;
            }
            throw new IllegalArgumentException("Length greater than buffer size");
        } else {
            throw new IllegalArgumentException("Negative length");
        }
    }

    private static int k(InputStream inputStream, byte[] bArr, int i2) throws IOException {
        int length = bArr.length - i2;
        int i3 = 0;
        int i4 = 1;
        while (i2 < bArr.length && i3 != -1 && i4 < 15) {
            i3 = inputStream.read(bArr, i2, length);
            if (i3 > 0) {
                i2 += i3;
                length -= i3;
            }
            i4++;
        }
        return i2;
    }
}

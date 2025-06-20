package com.itextpdf.text.io;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class StreamUtil {
    private StreamUtil() {
    }

    public static void a(RandomAccessSource randomAccessSource, long j2, long j3, OutputStream outputStream) throws IOException {
        if (j3 > 0) {
            byte[] bArr = new byte[8192];
            while (j3 > 0) {
                long a2 = (long) randomAccessSource.a(j2, bArr, 0, (int) Math.min((long) 8192, j3));
                if (a2 > 0) {
                    outputStream.write(bArr, 0, (int) a2);
                    j2 += a2;
                    j3 -= a2;
                } else {
                    throw new EOFException();
                }
            }
        }
    }

    public static InputStream b(String str) {
        return c(str, (ClassLoader) null);
    }

    public static InputStream c(String str, ClassLoader classLoader) {
        InputStream inputStream;
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        if (classLoader != null) {
            inputStream = classLoader.getResourceAsStream(str);
            if (inputStream != null) {
                return inputStream;
            }
        } else {
            inputStream = null;
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                inputStream = contextClassLoader.getResourceAsStream(str);
            }
        } catch (Throwable unused) {
        }
        if (inputStream == null) {
            inputStream = StreamUtil.class.getResourceAsStream("/" + str);
        }
        return inputStream == null ? ClassLoader.getSystemResourceAsStream(str) : inputStream;
    }

    public static byte[] d(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 1) {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}

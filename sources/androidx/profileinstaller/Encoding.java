package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

@RequiresApi(19)
class Encoding {

    /* renamed from: a  reason: collision with root package name */
    static final int f15082a = 8;

    /* renamed from: b  reason: collision with root package name */
    static final int f15083b = 1;

    /* renamed from: c  reason: collision with root package name */
    static final int f15084c = 2;

    /* renamed from: d  reason: collision with root package name */
    static final int f15085d = 4;

    private Encoding() {
    }

    static int a(int i2) {
        return ((i2 + 7) & -8) / 8;
    }

    static byte[] b(@NonNull byte[] bArr) throws IOException {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
        throw th;
    }

    @NonNull
    static RuntimeException c(@Nullable String str) {
        return new IllegalStateException(str);
    }

    @NonNull
    static byte[] d(@NonNull InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read >= 0) {
                i3 += read;
            } else {
                throw c("Not enough bytes to read: " + i2);
            }
        }
        return bArr;
    }

    @NonNull
    static byte[] e(@NonNull InputStream inputStream, int i2, int i3) throws IOException {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[2048];
            int i4 = 0;
            int i5 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i4 < i2) {
                int read = inputStream.read(bArr2);
                if (read >= 0) {
                    inflater.setInput(bArr2, 0, read);
                    i5 += inflater.inflate(bArr, i5, i3 - i5);
                    i4 += read;
                } else {
                    throw c("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i2 + " bytes");
                }
            }
            if (i4 != i2) {
                throw c("Didn't read enough bytes during decompression. expected=" + i2 + " actual=" + i4);
            } else if (inflater.finished()) {
                inflater.end();
                return bArr;
            } else {
                throw c("Inflater did not finish");
            }
        } catch (DataFormatException e2) {
            throw c(e2.getMessage());
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    @NonNull
    static String f(InputStream inputStream, int i2) throws IOException {
        return new String(d(inputStream, i2), StandardCharsets.UTF_8);
    }

    static long g(@NonNull InputStream inputStream, int i2) throws IOException {
        byte[] d2 = d(inputStream, i2);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 += ((long) (d2[i3] & 255)) << (i3 * 8);
        }
        return j2;
    }

    static int h(@NonNull InputStream inputStream) throws IOException {
        return (int) g(inputStream, 2);
    }

    static long i(@NonNull InputStream inputStream) throws IOException {
        return g(inputStream, 4);
    }

    static int j(@NonNull InputStream inputStream) throws IOException {
        return (int) g(inputStream, 1);
    }

    static int k(@NonNull String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    static void l(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    static void m(@NonNull OutputStream outputStream, byte[] bArr) throws IOException {
        q(outputStream, (long) bArr.length);
        byte[] b2 = b(bArr);
        q(outputStream, (long) b2.length);
        outputStream.write(b2);
    }

    static void n(@NonNull OutputStream outputStream, @NonNull String str) throws IOException {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    static void o(@NonNull OutputStream outputStream, long j2, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((int) ((j2 >> (i3 * 8)) & 255));
        }
        outputStream.write(bArr);
    }

    static void p(@NonNull OutputStream outputStream, int i2) throws IOException {
        o(outputStream, (long) i2, 2);
    }

    static void q(@NonNull OutputStream outputStream, long j2) throws IOException {
        o(outputStream, j2, 4);
    }

    static void r(@NonNull OutputStream outputStream, int i2) throws IOException {
        o(outputStream, (long) i2, 1);
    }
}

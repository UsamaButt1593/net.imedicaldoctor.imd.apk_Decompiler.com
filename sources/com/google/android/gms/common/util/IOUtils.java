package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

@ShowFirstParty
@KeepForSdk
@Deprecated
public final class IOUtils {
    private IOUtils() {
    }

    @KeepForSdk
    public static void a(@Nullable ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }

    @KeepForSdk
    public static void b(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @Deprecated
    public static long c(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) throws IOException {
        return d(inputStream, outputStream, false, 1024);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @Deprecated
    public static long d(@NonNull InputStream inputStream, @NonNull OutputStream outputStream, boolean z, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        long j2 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i2);
                if (read == -1) {
                    break;
                }
                j2 += (long) read;
                outputStream.write(bArr, 0, read);
            } catch (Throwable th) {
                if (z) {
                    b(inputStream);
                    b(outputStream);
                }
                throw th;
            }
        }
        if (z) {
            b(inputStream);
            b(outputStream);
        }
        return j2;
    }

    @KeepForSdk
    public static boolean e(@NonNull byte[] bArr) {
        if (bArr.length > 1) {
            if ((((bArr[1] & 255) << 8) | (bArr[0] & 255)) == 35615) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static byte[] f(@NonNull InputStream inputStream) throws IOException {
        return g(inputStream, true);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static byte[] g(@NonNull InputStream inputStream, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        d(inputStream, byteArrayOutputStream, z, 1024);
        return byteArrayOutputStream.toByteArray();
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static byte[] h(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Preconditions.r(inputStream);
        Preconditions.r(byteArrayOutputStream);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}

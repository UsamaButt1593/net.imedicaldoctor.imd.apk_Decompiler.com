package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

class NativeSessionFileGzipper {
    NativeSessionFileGzipper() {
    }

    private static void a(@Nullable InputStream inputStream, @NonNull File file) throws IOException {
        if (inputStream != null) {
            byte[] bArr = new byte[8192];
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            gZIPOutputStream2.write(bArr, 0, read);
                        } else {
                            gZIPOutputStream2.finish();
                            CommonUtils.g(gZIPOutputStream2);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        CommonUtils.g(gZIPOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.g(gZIPOutputStream);
                throw th;
            }
        }
    }

    static void b(File file, List<NativeSessionFile> list) {
        for (NativeSessionFile next : list) {
            InputStream inputStream = null;
            try {
                inputStream = next.e();
                if (inputStream != null) {
                    a(inputStream, new File(file, next.a()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                CommonUtils.g(inputStream);
                throw th;
            }
            CommonUtils.g(inputStream);
        }
    }
}

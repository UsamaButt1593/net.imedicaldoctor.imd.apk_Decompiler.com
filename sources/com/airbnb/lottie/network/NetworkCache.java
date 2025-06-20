package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class NetworkCache {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17272a;

    public NetworkCache(Context context) {
        this.f17272a = context.getApplicationContext();
    }

    private static String c(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.b() : fileExtension.s);
        return sb.toString();
    }

    @Nullable
    private File d(String str) throws FileNotFoundException {
        File file = new File(e(), c(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(e(), c(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File e() {
        File file = new File(this.f17272a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public void a() {
        File e2 = e();
        if (e2.exists()) {
            File[] listFiles = e2.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File delete : e2.listFiles()) {
                    delete.delete();
                }
            }
            e2.delete();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @androidx.annotation.WorkerThread
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.core.util.Pair<com.airbnb.lottie.network.FileExtension, java.io.InputStream> b(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = r5.d(r6)     // Catch:{ FileNotFoundException -> 0x0044 }
            if (r1 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{  }
            r2.<init>(r1)     // Catch:{  }
            java.lang.String r0 = r1.getAbsolutePath()
            java.lang.String r3 = ".zip"
            boolean r0 = r0.endsWith(r3)
            if (r0 == 0) goto L_0x001c
            com.airbnb.lottie.network.FileExtension r0 = com.airbnb.lottie.network.FileExtension.ZIP
            goto L_0x001e
        L_0x001c:
            com.airbnb.lottie.network.FileExtension r0 = com.airbnb.lottie.network.FileExtension.JSON
        L_0x001e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Cache hit for "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = " at "
            r3.append(r6)
            java.lang.String r6 = r1.getAbsolutePath()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            com.airbnb.lottie.utils.Logger.a(r6)
            androidx.core.util.Pair r6 = new androidx.core.util.Pair
            r6.<init>(r0, r2)
            return r6
        L_0x0044:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.network.NetworkCache.b(java.lang.String):androidx.core.util.Pair");
    }

    /* access modifiers changed from: package-private */
    public void f(String str, FileExtension fileExtension) {
        File file = new File(e(), c(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        Logger.a("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            Logger.e("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    /* access modifiers changed from: package-private */
    public File g(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(e(), c(str, fileExtension, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }
}

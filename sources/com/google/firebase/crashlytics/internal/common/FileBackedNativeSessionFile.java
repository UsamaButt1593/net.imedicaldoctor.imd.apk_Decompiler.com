package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

class FileBackedNativeSessionFile implements NativeSessionFile {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final File f23650a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f23651b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f23652c;

    FileBackedNativeSessionFile(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.f23651b = str;
        this.f23652c = str2;
        this.f23650a = file;
    }

    @Nullable
    private byte[] c() {
        InputStream e2;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr = new byte[8192];
        try {
            e2 = e();
            byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            if (e2 == null) {
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                if (e2 != null) {
                    e2.close();
                }
                return null;
            }
            while (true) {
                int read = e2.read(bArr);
                if (read > 0) {
                    gZIPOutputStream.write(bArr, 0, read);
                } else {
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    e2.close();
                    return byteArray;
                }
            }
            throw th;
            throw th;
            throw th;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
    }

    @NonNull
    public String a() {
        return this.f23652c;
    }

    @Nullable
    public CrashlyticsReport.FilesPayload.File b() {
        byte[] c2 = c();
        if (c2 != null) {
            return CrashlyticsReport.FilesPayload.File.a().b(c2).c(this.f23651b).a();
        }
        return null;
    }

    @Nullable
    public InputStream e() {
        if (this.f23650a.exists() && this.f23650a.isFile()) {
            try {
                return new FileInputStream(this.f23650a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}

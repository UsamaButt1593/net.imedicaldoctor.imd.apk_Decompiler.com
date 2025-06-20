package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

class BytesBackedNativeSessionFile implements NativeSessionFile {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f23550a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final String f23551b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f23552c;

    BytesBackedNativeSessionFile(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr) {
        this.f23551b = str;
        this.f23552c = str2;
        this.f23550a = bArr;
    }

    @Nullable
    private byte[] c() {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        if (d()) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(this.f23550a);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
        throw th;
    }

    private boolean d() {
        byte[] bArr = this.f23550a;
        return bArr == null || bArr.length == 0;
    }

    @NonNull
    public String a() {
        return this.f23552c;
    }

    @Nullable
    public CrashlyticsReport.FilesPayload.File b() {
        byte[] c2 = c();
        if (c2 == null) {
            return null;
        }
        return CrashlyticsReport.FilesPayload.File.a().b(c2).c(this.f23551b).a();
    }

    @Nullable
    public InputStream e() {
        if (d()) {
            return null;
        }
        return new ByteArrayInputStream(this.f23550a);
    }
}

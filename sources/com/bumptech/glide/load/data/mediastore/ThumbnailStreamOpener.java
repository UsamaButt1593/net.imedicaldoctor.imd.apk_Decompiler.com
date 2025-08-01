package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class ThumbnailStreamOpener {

    /* renamed from: f  reason: collision with root package name */
    private static final String f17854f = "ThumbStreamOpener";

    /* renamed from: g  reason: collision with root package name */
    private static final FileService f17855g = new FileService();

    /* renamed from: a  reason: collision with root package name */
    private final FileService f17856a;

    /* renamed from: b  reason: collision with root package name */
    private final ThumbnailQuery f17857b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f17858c;

    /* renamed from: d  reason: collision with root package name */
    private final ContentResolver f17859d;

    /* renamed from: e  reason: collision with root package name */
    private final List<ImageHeaderParser> f17860e;

    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.f17856a = fileService;
        this.f17857b = thumbnailQuery;
        this.f17858c = arrayPool;
        this.f17859d = contentResolver;
        this.f17860e = list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0030 A[Catch:{ all -> 0x001a }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004c  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(@androidx.annotation.NonNull android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r2 = r6.f17857b     // Catch:{ SecurityException -> 0x0027, all -> 0x0025 }
            android.database.Cursor r2 = r2.a(r7)     // Catch:{ SecurityException -> 0x0027, all -> 0x0025 }
            if (r2 == 0) goto L_0x001f
            boolean r3 = r2.moveToFirst()     // Catch:{ SecurityException -> 0x001d }
            if (r3 == 0) goto L_0x001f
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch:{ SecurityException -> 0x001d }
            r2.close()
            return r7
        L_0x001a:
            r7 = move-exception
            r1 = r2
            goto L_0x004a
        L_0x001d:
            r3 = move-exception
            goto L_0x0029
        L_0x001f:
            if (r2 == 0) goto L_0x0024
            r2.close()
        L_0x0024:
            return r1
        L_0x0025:
            r7 = move-exception
            goto L_0x004a
        L_0x0027:
            r3 = move-exception
            r2 = r1
        L_0x0029:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x001a }
            if (r4 == 0) goto L_0x0044
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x001a }
            r4.<init>()     // Catch:{ all -> 0x001a }
            java.lang.String r5 = "Failed to query for thumbnail for Uri: "
            r4.append(r5)     // Catch:{ all -> 0x001a }
            r4.append(r7)     // Catch:{ all -> 0x001a }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x001a }
            android.util.Log.d(r0, r7, r3)     // Catch:{ all -> 0x001a }
        L_0x0044:
            if (r2 == 0) goto L_0x0049
            r2.close()
        L_0x0049:
            return r1
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.close()
        L_0x004f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.b(android.net.Uri):java.lang.String");
    }

    private boolean c(File file) {
        return this.f17856a.a(file) && 0 < this.f17856a.c(file);
    }

    /* access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            InputStream openInputStream = this.f17859d.openInputStream(uri);
            int b2 = ImageHeaderParserUtils.b(this.f17860e, openInputStream, this.f17858c);
            if (openInputStream != null) {
                try {
                    openInputStream.close();
                } catch (IOException unused) {
                }
            }
            return b2;
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable(f17854f, 3)) {
                Log.d(f17854f, "Failed to open uri: " + uri, e2);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b2 = b(uri);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        File b3 = this.f17856a.b(b2);
        if (!c(b3)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b3);
        try {
            return this.f17859d.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
        }
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, f17855g, thumbnailQuery, arrayPool, contentResolver);
    }
}

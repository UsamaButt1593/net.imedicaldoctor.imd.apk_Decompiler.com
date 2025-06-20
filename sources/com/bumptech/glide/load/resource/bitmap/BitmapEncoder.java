package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    public static final Option<Integer> f18235b = Option.g("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c  reason: collision with root package name */
    public static final Option<Bitmap.CompressFormat> f18236c = Option.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: d  reason: collision with root package name */
    private static final String f18237d = "BitmapEncoder";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final ArrayPool f18238a;

    @Deprecated
    public BitmapEncoder() {
        this.f18238a = null;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.c(f18236c);
        if (compressFormat != null) {
            return compressFormat;
        }
        return bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @NonNull
    public EncodeStrategy b(@NonNull Options options) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:23|(2:43|44)|45|46) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00c5 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[Catch:{ all -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[SYNTHETIC, Splitter:B:31:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0076 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c2 A[SYNTHETIC, Splitter:B:43:0x00c2] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r8, @androidx.annotation.NonNull java.io.File r9, @androidx.annotation.NonNull com.bumptech.glide.load.Options r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.d(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            com.bumptech.glide.util.pool.GlideTrace.d(r4, r2, r3, r1)
            long r2 = com.bumptech.glide.util.LogTime.b()     // Catch:{ all -> 0x0056 }
            com.bumptech.glide.load.Option<java.lang.Integer> r4 = f18235b     // Catch:{ all -> 0x0056 }
            java.lang.Object r4 = r10.c(r4)     // Catch:{ all -> 0x0056 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x0056 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0056 }
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x005c }
            r6.<init>(r9)     // Catch:{ IOException -> 0x005c }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r9 = r7.f18238a     // Catch:{ IOException -> 0x0048, all -> 0x0044 }
            if (r9 == 0) goto L_0x004b
            com.bumptech.glide.load.data.BufferedOutputStream r9 = new com.bumptech.glide.load.data.BufferedOutputStream     // Catch:{ IOException -> 0x0048, all -> 0x0044 }
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r5 = r7.f18238a     // Catch:{ IOException -> 0x0048, all -> 0x0044 }
            r9.<init>(r6, r5)     // Catch:{ IOException -> 0x0048, all -> 0x0044 }
            r5 = r9
            goto L_0x004c
        L_0x0044:
            r8 = move-exception
            r5 = r6
            goto L_0x00c0
        L_0x0048:
            r9 = move-exception
            r5 = r6
            goto L_0x005d
        L_0x004b:
            r5 = r6
        L_0x004c:
            r8.compress(r1, r4, r5)     // Catch:{ IOException -> 0x005c }
            r5.close()     // Catch:{ IOException -> 0x005c }
            r5.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x0058
        L_0x0056:
            r8 = move-exception
            goto L_0x00c6
        L_0x0058:
            r9 = 1
            goto L_0x006f
        L_0x005a:
            r8 = move-exception
            goto L_0x00c0
        L_0x005c:
            r9 = move-exception
        L_0x005d:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x0069
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r9)     // Catch:{ all -> 0x005a }
        L_0x0069:
            if (r5 == 0) goto L_0x006e
            r5.close()     // Catch:{ IOException -> 0x006e }
        L_0x006e:
            r9 = 0
        L_0x006f:
            r4 = 2
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch:{ all -> 0x0056 }
            if (r4 == 0) goto L_0x00bc
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
            r4.<init>()     // Catch:{ all -> 0x0056 }
            java.lang.String r5 = "Compressed with type: "
            r4.append(r5)     // Catch:{ all -> 0x0056 }
            r4.append(r1)     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = " of size "
            r4.append(r1)     // Catch:{ all -> 0x0056 }
            int r1 = com.bumptech.glide.util.Util.h(r8)     // Catch:{ all -> 0x0056 }
            r4.append(r1)     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = " in "
            r4.append(r1)     // Catch:{ all -> 0x0056 }
            double r1 = com.bumptech.glide.util.LogTime.a(r2)     // Catch:{ all -> 0x0056 }
            r4.append(r1)     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = ", options format: "
            r4.append(r1)     // Catch:{ all -> 0x0056 }
            com.bumptech.glide.load.Option<android.graphics.Bitmap$CompressFormat> r1 = f18236c     // Catch:{ all -> 0x0056 }
            java.lang.Object r10 = r10.c(r1)     // Catch:{ all -> 0x0056 }
            r4.append(r10)     // Catch:{ all -> 0x0056 }
            java.lang.String r10 = ", hasAlpha: "
            r4.append(r10)     // Catch:{ all -> 0x0056 }
            boolean r8 = r8.hasAlpha()     // Catch:{ all -> 0x0056 }
            r4.append(r8)     // Catch:{ all -> 0x0056 }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x0056 }
            android.util.Log.v(r0, r8)     // Catch:{ all -> 0x0056 }
        L_0x00bc:
            com.bumptech.glide.util.pool.GlideTrace.e()
            return r9
        L_0x00c0:
            if (r5 == 0) goto L_0x00c5
            r5.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00c5:
            throw r8     // Catch:{ all -> 0x0056 }
        L_0x00c6:
            com.bumptech.glide.util.pool.GlideTrace.e()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.a(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }

    public BitmapEncoder(@NonNull ArrayPool arrayPool) {
        this.f18238a = arrayPool;
    }
}

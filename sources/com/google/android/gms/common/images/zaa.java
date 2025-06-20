package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class zaa implements Runnable {
    @Nullable
    private final ParcelFileDescriptor X;
    final /* synthetic */ ImageManager Y;
    private final Uri s;

    public zaa(ImageManager imageManager, @Nullable Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.Y = imageManager;
        this.s = uri;
        this.X = parcelFileDescriptor;
    }

    public final void run() {
        boolean z;
        Bitmap bitmap;
        Asserts.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.X;
        Bitmap bitmap2 = null;
        boolean z2 = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e2) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.s)), e2);
                z2 = true;
            }
            try {
                this.X.close();
            } catch (IOException e3) {
                Log.e("ImageManager", "closed failed", e3);
            }
            bitmap = bitmap2;
            z = z2;
        } else {
            bitmap = null;
            z = false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.Y;
        imageManager.f20202b.post(new zac(imageManager, this.s, bitmap, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.s)));
        }
    }
}

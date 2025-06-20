package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class zac implements Runnable {
    @Nullable
    private final Bitmap X;
    private final CountDownLatch Y;
    final /* synthetic */ ImageManager Z;
    private final Uri s;

    public zac(ImageManager imageManager, @Nullable Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.Z = imageManager;
        this.s = uri;
        this.X = bitmap;
        this.Y = countDownLatch;
    }

    public final void run() {
        Asserts.a("OnBitmapLoadedRunnable must be executed in the main thread");
        Bitmap bitmap = this.X;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.Z.f20206f.remove(this.s);
        if (imageReceiver != null) {
            ArrayList a2 = imageReceiver.X;
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                zag zag = (zag) a2.get(i2);
                Bitmap bitmap2 = this.X;
                if (bitmap2 == null || bitmap == null) {
                    this.Z.f20207g.put(this.s, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager = this.Z;
                    zag.b(imageManager.f20201a, imageManager.f20204d, false);
                } else {
                    zag.c(this.Z.f20201a, bitmap2, false);
                }
                if (!(zag instanceof zaf)) {
                    this.Z.f20205e.remove(zag);
                }
            }
        }
        this.Y.countDown();
        synchronized (ImageManager.f20198h) {
            ImageManager.f20199i.remove(this.s);
        }
    }
}

package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import org.apache.commons.lang3.time.DateUtils;

final class zab implements Runnable {
    final /* synthetic */ ImageManager X;
    private final zag s;

    public zab(ImageManager imageManager, zag zag) {
        this.X = imageManager;
        this.s = zag;
    }

    public final void run() {
        Asserts.a("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.X.f20205e.get(this.s);
        if (imageReceiver != null) {
            this.X.f20205e.remove(this.s);
            imageReceiver.c(this.s);
        }
        zag zag = this.s;
        zad zad = zag.f20213a;
        Uri uri = zad.f20210a;
        if (uri != null) {
            Long l2 = (Long) this.X.f20207g.get(uri);
            if (l2 != null) {
                if (SystemClock.elapsedRealtime() - l2.longValue() < DateUtils.MILLIS_PER_HOUR) {
                    zag = this.s;
                } else {
                    this.X.f20207g.remove(zad.f20210a);
                }
            }
            this.s.a((Drawable) null, false, true, false);
            ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) this.X.f20206f.get(zad.f20210a);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageManager.ImageReceiver(zad.f20210a);
                this.X.f20206f.put(zad.f20210a, imageReceiver2);
            }
            imageReceiver2.b(this.s);
            zag zag2 = this.s;
            if (!(zag2 instanceof zaf)) {
                this.X.f20205e.put(zag2, imageReceiver2);
            }
            synchronized (ImageManager.f20198h) {
                try {
                    if (!ImageManager.f20199i.contains(zad.f20210a)) {
                        ImageManager.f20199i.add(zad.f20210a);
                        imageReceiver2.d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        ImageManager imageManager = this.X;
        zag.b(imageManager.f20201a, imageManager.f20204d, true);
    }
}

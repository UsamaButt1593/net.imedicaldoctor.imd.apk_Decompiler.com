package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

public final class BitmapPreFiller {

    /* renamed from: a  reason: collision with root package name */
    private final MemoryCache f18098a;

    /* renamed from: b  reason: collision with root package name */
    private final BitmapPool f18099b;

    /* renamed from: c  reason: collision with root package name */
    private final DecodeFormat f18100c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f18101d = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private BitmapPreFillRunner f18102e;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.f18098a = memoryCache;
        this.f18099b = bitmapPool;
        this.f18100c = decodeFormat;
    }

    private static int b(PreFillType preFillType) {
        return Util.g(preFillType.d(), preFillType.b(), preFillType.a());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public PreFillQueue a(PreFillType... preFillTypeArr) {
        long a2 = (this.f18098a.a() - this.f18098a.e()) + this.f18099b.a();
        int i2 = 0;
        for (PreFillType c2 : preFillTypeArr) {
            i2 += c2.c();
        }
        float f2 = ((float) a2) / ((float) i2);
        HashMap hashMap = new HashMap();
        for (PreFillType preFillType : preFillTypeArr) {
            hashMap.put(preFillType, Integer.valueOf(Math.round(((float) preFillType.c()) * f2) / b(preFillType)));
        }
        return new PreFillQueue(hashMap);
    }

    public void c(PreFillType.Builder... builderArr) {
        BitmapPreFillRunner bitmapPreFillRunner = this.f18102e;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.b();
        }
        PreFillType[] preFillTypeArr = new PreFillType[builderArr.length];
        for (int i2 = 0; i2 < builderArr.length; i2++) {
            PreFillType.Builder builder = builderArr[i2];
            if (builder.b() == null) {
                builder.c(this.f18100c == DecodeFormat.PREFER_ARGB_8888 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            }
            preFillTypeArr[i2] = builder.a();
        }
        BitmapPreFillRunner bitmapPreFillRunner2 = new BitmapPreFillRunner(this.f18099b, this.f18098a, a(preFillTypeArr));
        this.f18102e = bitmapPreFillRunner2;
        this.f18101d.post(bitmapPreFillRunner2);
    }
}

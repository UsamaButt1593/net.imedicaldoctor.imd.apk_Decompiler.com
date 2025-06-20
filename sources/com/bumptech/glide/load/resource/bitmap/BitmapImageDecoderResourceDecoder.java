package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import java.io.IOException;

@RequiresApi(api = 28)
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f18239d = "BitmapImageDecoder";

    /* renamed from: c  reason: collision with root package name */
    private final BitmapPool f18240c = new BitmapPoolAdapter();

    /* access modifiers changed from: protected */
    public Resource<Bitmap> c(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap a2 = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(f18239d, 2)) {
            Log.v(f18239d, "Decoded [" + a2.getWidth() + "x" + a2.getHeight() + "] for [" + i2 + "x" + i3 + "]");
        }
        return new BitmapResource(a2, this.f18240c);
    }
}

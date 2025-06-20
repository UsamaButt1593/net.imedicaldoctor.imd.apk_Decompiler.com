package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;

@RequiresApi(api = 28)
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f18219b = "ImageDecoder";

    /* renamed from: a  reason: collision with root package name */
    final HardwareConfigState f18220a = HardwareConfigState.a();

    public /* bridge */ /* synthetic */ boolean a(@NonNull Object obj, @NonNull Options options) throws IOException {
        return e(a.a(obj), options);
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource b(@NonNull Object obj, int i2, int i3, @NonNull Options options) throws IOException {
        return d(a.a(obj), i2, i3, options);
    }

    /* access modifiers changed from: protected */
    public abstract Resource<T> c(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Nullable
    public final Resource<T> d(@NonNull ImageDecoder.Source source, int i2, int i3, @NonNull Options options) throws IOException {
        final DecodeFormat decodeFormat = (DecodeFormat) options.c(Downsampler.f18276g);
        final DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f18273h);
        Option option = Downsampler.f18280k;
        final boolean z = options.c(option) != null && ((Boolean) options.c(option)).booleanValue();
        final PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.c(Downsampler.f18277h);
        final int i4 = i2;
        final int i5 = i3;
        return c(source, i2, i3, new ImageDecoder.OnHeaderDecodedListener() {
            @SuppressLint({"Override"})
            public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                ColorSpace.Named a2;
                imageDecoder.setAllocator(ImageDecoderResourceDecoder.this.f18220a.c(i4, i5, z, false) ? 3 : 1);
                if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() {
                    public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                        return false;
                    }
                });
                Size a3 = imageInfo.getSize();
                int i2 = i4;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = a3.getWidth();
                }
                int i3 = i5;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = a3.getHeight();
                }
                float b2 = downsampleStrategy.b(a3.getWidth(), a3.getHeight(), i2, i3);
                int round = Math.round(((float) a3.getWidth()) * b2);
                int round2 = Math.round(((float) a3.getHeight()) * b2);
                if (Log.isLoggable(ImageDecoderResourceDecoder.f18219b, 2)) {
                    Log.v(ImageDecoderResourceDecoder.f18219b, "Resizing from [" + a3.getWidth() + "x" + a3.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b2);
                }
                imageDecoder.setTargetSize(round, round2);
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 28) {
                    if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                        a2 = ColorSpace.Named.DISPLAY_P3;
                    }
                    a2 = ColorSpace.Named.SRGB;
                } else {
                    if (i4 < 26) {
                        return;
                    }
                    a2 = ColorSpace.Named.SRGB;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(a2));
            }
        });
    }

    public final boolean e(@NonNull ImageDecoder.Source source, @NonNull Options options) {
        return true;
    }
}

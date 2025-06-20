package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

@RequiresApi(21)
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f18320a;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler) {
        this.f18320a = downsampler;
    }

    @Nullable
    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, @NonNull Options options) throws IOException {
        return this.f18320a.d(parcelFileDescriptor, i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull Options options) {
        return this.f18320a.o(parcelFileDescriptor);
    }
}

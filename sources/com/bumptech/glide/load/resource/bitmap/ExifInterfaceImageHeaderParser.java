package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@RequiresApi(27)
public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    @NonNull
    public ImageHeaderParser.ImageType a(@NonNull ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public int b(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException {
        return d(ByteBufferUtil.f(byteBuffer), arrayPool);
    }

    @NonNull
    public ImageHeaderParser.ImageType c(@NonNull InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public int d(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        int l2 = new ExifInterface(inputStream).l(ExifInterface.C, 1);
        if (l2 == 0) {
            return -1;
        }
        return l2;
    }
}

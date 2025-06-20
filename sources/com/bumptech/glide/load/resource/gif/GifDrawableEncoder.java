package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18379a = "GifEncoder";

    @NonNull
    public EncodeStrategy b(@NonNull Options options) {
        return EncodeStrategy.SOURCE;
    }

    /* renamed from: c */
    public boolean a(@NonNull Resource<GifDrawable> resource, @NonNull File file, @NonNull Options options) {
        try {
            ByteBufferUtil.e(resource.get().f(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable(f18379a, 5)) {
                Log.w(f18379a, "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}

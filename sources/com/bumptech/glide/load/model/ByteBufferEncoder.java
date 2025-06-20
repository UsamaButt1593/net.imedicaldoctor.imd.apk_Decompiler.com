package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferEncoder implements Encoder<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18126a = "ByteBufferEncoder";

    /* renamed from: c */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull Options options) {
        try {
            ByteBufferUtil.e(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable(f18126a, 3)) {
                Log.d(f18126a, "Failed to write data", e2);
            }
            return false;
        }
    }
}

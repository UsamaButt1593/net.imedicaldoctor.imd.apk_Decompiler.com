package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.io.File;

public interface DiskCache {

    public interface Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final int f18029a = 262144000;

        /* renamed from: b  reason: collision with root package name */
        public static final String f18030b = "image_manager_disk_cache";

        @Nullable
        DiskCache build();
    }

    public interface Writer {
        boolean a(@NonNull File file);
    }

    void a(Key key, Writer writer);

    @Nullable
    File b(Key key);

    void c(Key key);

    void clear();
}

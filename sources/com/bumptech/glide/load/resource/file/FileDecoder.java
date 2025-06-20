package com.bumptech.glide.load.resource.file;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

public class FileDecoder implements ResourceDecoder<File, File> {
    /* renamed from: c */
    public Resource<File> b(@NonNull File file, int i2, int i3, @NonNull Options options) {
        return new FileResource(file);
    }

    /* renamed from: d */
    public boolean a(@NonNull File file, @NonNull Options options) {
        return true;
    }
}

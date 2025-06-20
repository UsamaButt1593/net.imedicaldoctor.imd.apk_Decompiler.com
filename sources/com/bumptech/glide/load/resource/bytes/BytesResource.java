package com.bumptech.glide.load.resource.bytes;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource implements Resource<byte[]> {
    private final byte[] s;

    public BytesResource(byte[] bArr) {
        this.s = (byte[]) Preconditions.d(bArr);
    }

    public int a() {
        return this.s.length;
    }

    @NonNull
    /* renamed from: b */
    public byte[] get() {
        return this.s;
    }

    @NonNull
    public Class<byte[]> c() {
        return byte[].class;
    }

    public void recycle() {
    }
}

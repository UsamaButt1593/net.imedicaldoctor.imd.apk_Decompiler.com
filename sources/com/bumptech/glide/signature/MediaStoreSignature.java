package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MediaStoreSignature implements Key {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final String f18519c;

    /* renamed from: d  reason: collision with root package name */
    private final long f18520d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18521e;

    public MediaStoreSignature(@Nullable String str, long j2, int i2) {
        this.f18519c = str == null ? "" : str;
        this.f18520d = j2;
        this.f18521e = i2;
    }

    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.f18520d).putInt(this.f18521e).array());
        messageDigest.update(this.f18519c.getBytes(Key.f17830b));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        return this.f18520d == mediaStoreSignature.f18520d && this.f18521e == mediaStoreSignature.f18521e && this.f18519c.equals(mediaStoreSignature.f18519c);
    }

    public int hashCode() {
        long j2 = this.f18520d;
        return (((this.f18519c.hashCode() * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.f18521e;
    }
}

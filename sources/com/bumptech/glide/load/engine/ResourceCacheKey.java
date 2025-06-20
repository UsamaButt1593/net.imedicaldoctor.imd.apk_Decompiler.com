package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import com.dd.plist.ASCIIPropertyListParser;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey implements Key {

    /* renamed from: k  reason: collision with root package name */
    private static final LruCache<Class<?>, byte[]> f17957k = new LruCache<>(50);

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f17958c;

    /* renamed from: d  reason: collision with root package name */
    private final Key f17959d;

    /* renamed from: e  reason: collision with root package name */
    private final Key f17960e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17961f;

    /* renamed from: g  reason: collision with root package name */
    private final int f17962g;

    /* renamed from: h  reason: collision with root package name */
    private final Class<?> f17963h;

    /* renamed from: i  reason: collision with root package name */
    private final Options f17964i;

    /* renamed from: j  reason: collision with root package name */
    private final Transformation<?> f17965j;

    ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int i2, int i3, Transformation<?> transformation, Class<?> cls, Options options) {
        this.f17958c = arrayPool;
        this.f17959d = key;
        this.f17960e = key2;
        this.f17961f = i2;
        this.f17962g = i3;
        this.f17965j = transformation;
        this.f17963h = cls;
        this.f17964i = options;
    }

    private byte[] c() {
        LruCache<Class<?>, byte[]> lruCache = f17957k;
        byte[] k2 = lruCache.k(this.f17963h);
        if (k2 != null) {
            return k2;
        }
        byte[] bytes = this.f17963h.getName().getBytes(Key.f17830b);
        lruCache.o(this.f17963h, bytes);
        return bytes;
    }

    public void a(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f17958c.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f17961f).putInt(this.f17962g).array();
        this.f17960e.a(messageDigest);
        this.f17959d.a(messageDigest);
        messageDigest.update(bArr);
        Transformation<?> transformation = this.f17965j;
        if (transformation != null) {
            transformation.a(messageDigest);
        }
        this.f17964i.a(messageDigest);
        messageDigest.update(c());
        this.f17958c.put(bArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceCacheKey)) {
            return false;
        }
        ResourceCacheKey resourceCacheKey = (ResourceCacheKey) obj;
        return this.f17962g == resourceCacheKey.f17962g && this.f17961f == resourceCacheKey.f17961f && Util.d(this.f17965j, resourceCacheKey.f17965j) && this.f17963h.equals(resourceCacheKey.f17963h) && this.f17959d.equals(resourceCacheKey.f17959d) && this.f17960e.equals(resourceCacheKey.f17960e) && this.f17964i.equals(resourceCacheKey.f17964i);
    }

    public int hashCode() {
        int hashCode = (((((this.f17959d.hashCode() * 31) + this.f17960e.hashCode()) * 31) + this.f17961f) * 31) + this.f17962g;
        Transformation<?> transformation = this.f17965j;
        if (transformation != null) {
            hashCode = (hashCode * 31) + transformation.hashCode();
        }
        return (((hashCode * 31) + this.f17963h.hashCode()) * 31) + this.f17964i.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f17959d + ", signature=" + this.f17960e + ", width=" + this.f17961f + ", height=" + this.f17962g + ", decodedResourceClass=" + this.f17963h + ", transformation='" + this.f17965j + '\'' + ", options=" + this.f17964i + ASCIIPropertyListParser.f18653k;
    }
}

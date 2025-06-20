package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.dd.plist.ASCIIPropertyListParser;
import java.security.MessageDigest;

final class DataCacheKey implements Key {

    /* renamed from: c  reason: collision with root package name */
    private final Key f17871c;

    /* renamed from: d  reason: collision with root package name */
    private final Key f17872d;

    DataCacheKey(Key key, Key key2) {
        this.f17871c = key;
        this.f17872d = key2;
    }

    public void a(@NonNull MessageDigest messageDigest) {
        this.f17871c.a(messageDigest);
        this.f17872d.a(messageDigest);
    }

    /* access modifiers changed from: package-private */
    public Key c() {
        return this.f17871c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataCacheKey)) {
            return false;
        }
        DataCacheKey dataCacheKey = (DataCacheKey) obj;
        return this.f17871c.equals(dataCacheKey.f17871c) && this.f17872d.equals(dataCacheKey.f17872d);
    }

    public int hashCode() {
        return (this.f17871c.hashCode() * 31) + this.f17872d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f17871c + ", signature=" + this.f17872d + ASCIIPropertyListParser.f18653k;
    }
}

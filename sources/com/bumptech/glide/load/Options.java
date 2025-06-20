package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.dd.plist.ASCIIPropertyListParser;
import java.security.MessageDigest;

public final class Options implements Key {

    /* renamed from: c  reason: collision with root package name */
    private final ArrayMap<Option<?>, Object> f17837c = new CachedHashCodeArrayMap();

    private static <T> void f(@NonNull Option<T> option, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        option.h(obj, messageDigest);
    }

    public void a(@NonNull MessageDigest messageDigest) {
        for (int i2 = 0; i2 < this.f17837c.size(); i2++) {
            f(this.f17837c.i(i2), this.f17837c.m(i2), messageDigest);
        }
    }

    @Nullable
    public <T> T c(@NonNull Option<T> option) {
        return this.f17837c.containsKey(option) ? this.f17837c.get(option) : option.d();
    }

    public void d(@NonNull Options options) {
        this.f17837c.j(options.f17837c);
    }

    @NonNull
    public <T> Options e(@NonNull Option<T> option, @NonNull T t) {
        this.f17837c.put(option, t);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.f17837c.equals(((Options) obj).f17837c);
        }
        return false;
    }

    public int hashCode() {
        return this.f17837c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f17837c + ASCIIPropertyListParser.f18653k;
    }
}

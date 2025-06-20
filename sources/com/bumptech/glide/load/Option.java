package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;
import java.security.MessageDigest;

public final class Option<T> {

    /* renamed from: e  reason: collision with root package name */
    private static final CacheKeyUpdater<Object> f17832e = new CacheKeyUpdater<Object>() {
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final T f17833a;

    /* renamed from: b  reason: collision with root package name */
    private final CacheKeyUpdater<T> f17834b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17835c;

    /* renamed from: d  reason: collision with root package name */
    private volatile byte[] f17836d;

    public interface CacheKeyUpdater<T> {
        void a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    private Option(@NonNull String str, @Nullable T t, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        this.f17835c = Preconditions.b(str);
        this.f17833a = t;
        this.f17834b = (CacheKeyUpdater) Preconditions.d(cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> a(@NonNull String str, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, (Object) null, cacheKeyUpdater);
    }

    @NonNull
    public static <T> Option<T> b(@NonNull String str, @Nullable T t, @NonNull CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t, cacheKeyUpdater);
    }

    @NonNull
    private static <T> CacheKeyUpdater<T> c() {
        return f17832e;
    }

    @NonNull
    private byte[] e() {
        if (this.f17836d == null) {
            this.f17836d = this.f17835c.getBytes(Key.f17830b);
        }
        return this.f17836d;
    }

    @NonNull
    public static <T> Option<T> f(@NonNull String str) {
        return new Option<>(str, (Object) null, c());
    }

    @NonNull
    public static <T> Option<T> g(@NonNull String str, @NonNull T t) {
        return new Option<>(str, t, c());
    }

    @Nullable
    public T d() {
        return this.f17833a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f17835c.equals(((Option) obj).f17835c);
        }
        return false;
    }

    public void h(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f17834b.a(e(), t, messageDigest);
    }

    public int hashCode() {
        return this.f17835c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f17835c + '\'' + ASCIIPropertyListParser.f18653k;
    }
}

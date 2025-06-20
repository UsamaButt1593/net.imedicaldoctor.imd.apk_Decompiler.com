package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;
import java.security.MessageDigest;
import java.util.Map;

class EngineKey implements Key {

    /* renamed from: c  reason: collision with root package name */
    private final Object f17942c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17943d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17944e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f17945f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f17946g;

    /* renamed from: h  reason: collision with root package name */
    private final Key f17947h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<Class<?>, Transformation<?>> f17948i;

    /* renamed from: j  reason: collision with root package name */
    private final Options f17949j;

    /* renamed from: k  reason: collision with root package name */
    private int f17950k;

    EngineKey(Object obj, Key key, int i2, int i3, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.f17942c = Preconditions.d(obj);
        this.f17947h = (Key) Preconditions.e(key, "Signature must not be null");
        this.f17943d = i2;
        this.f17944e = i3;
        this.f17948i = (Map) Preconditions.d(map);
        this.f17945f = (Class) Preconditions.e(cls, "Resource class must not be null");
        this.f17946g = (Class) Preconditions.e(cls2, "Transcode class must not be null");
        this.f17949j = (Options) Preconditions.d(options);
    }

    public void a(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        return this.f17942c.equals(engineKey.f17942c) && this.f17947h.equals(engineKey.f17947h) && this.f17944e == engineKey.f17944e && this.f17943d == engineKey.f17943d && this.f17948i.equals(engineKey.f17948i) && this.f17945f.equals(engineKey.f17945f) && this.f17946g.equals(engineKey.f17946g) && this.f17949j.equals(engineKey.f17949j);
    }

    public int hashCode() {
        if (this.f17950k == 0) {
            int hashCode = this.f17942c.hashCode();
            this.f17950k = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f17947h.hashCode()) * 31) + this.f17943d) * 31) + this.f17944e;
            this.f17950k = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f17948i.hashCode();
            this.f17950k = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f17945f.hashCode();
            this.f17950k = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f17946g.hashCode();
            this.f17950k = hashCode5;
            this.f17950k = (hashCode5 * 31) + this.f17949j.hashCode();
        }
        return this.f17950k;
    }

    public String toString() {
        return "EngineKey{model=" + this.f17942c + ", width=" + this.f17943d + ", height=" + this.f17944e + ", resourceClass=" + this.f17945f + ", transcodeClass=" + this.f17946g + ", signature=" + this.f17947h + ", hashCode=" + this.f17950k + ", transformations=" + this.f17948i + ", options=" + this.f17949j + ASCIIPropertyListParser.f18653k;
    }
}

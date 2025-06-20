package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dd.plist.ASCIIPropertyListParser;

public class MultiClassKey {

    /* renamed from: a  reason: collision with root package name */
    private Class<?> f18536a;

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f18537b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f18538c;

    public MultiClassKey() {
    }

    public void a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        b(cls, cls2, (Class<?>) null);
    }

    public void b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        this.f18536a = cls;
        this.f18537b = cls2;
        this.f18538c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f18536a.equals(multiClassKey.f18536a) && this.f18537b.equals(multiClassKey.f18537b) && Util.d(this.f18538c, multiClassKey.f18538c);
    }

    public int hashCode() {
        int hashCode = ((this.f18536a.hashCode() * 31) + this.f18537b.hashCode()) * 31;
        Class<?> cls = this.f18538c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f18536a + ", second=" + this.f18537b + ASCIIPropertyListParser.f18653k;
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        a(cls, cls2);
    }

    public MultiClassKey(@NonNull Class<?> cls, @NonNull Class<?> cls2, @Nullable Class<?> cls3) {
        b(cls, cls2, cls3);
    }
}

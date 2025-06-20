package com.google.firebase.components;

import androidx.annotation.NonNull;
import java.lang.annotation.Annotation;
import org.apache.commons.lang3.StringUtils;

public final class Qualified<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<? extends Annotation> f23418a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<T> f23419b;

    private @interface Unqualified {
    }

    public Qualified(Class<? extends Annotation> cls, Class<T> cls2) {
        this.f23418a = cls;
        this.f23419b = cls2;
    }

    @NonNull
    public static <T> Qualified<T> a(Class<? extends Annotation> cls, Class<T> cls2) {
        return new Qualified<>(cls, cls2);
    }

    @NonNull
    public static <T> Qualified<T> b(Class<T> cls) {
        return new Qualified<>(Unqualified.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qualified.class != obj.getClass()) {
            return false;
        }
        Qualified qualified = (Qualified) obj;
        if (!this.f23419b.equals(qualified.f23419b)) {
            return false;
        }
        return this.f23418a.equals(qualified.f23418a);
    }

    public int hashCode() {
        return (this.f23419b.hashCode() * 31) + this.f23418a.hashCode();
    }

    public String toString() {
        if (this.f23418a == Unqualified.class) {
            return this.f23419b.getName();
        }
        return "@" + this.f23418a.getName() + StringUtils.SPACE + this.f23419b.getName();
    }
}

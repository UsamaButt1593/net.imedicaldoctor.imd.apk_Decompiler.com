package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FieldDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private final String f24328a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Object> f24329b;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final String f24330a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Class<?>, Object> f24331b = null;

        Builder(String str) {
            this.f24330a = str;
        }

        @NonNull
        public FieldDescriptor a() {
            return new FieldDescriptor(this.f24330a, this.f24331b == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(this.f24331b)));
        }

        @NonNull
        public <T extends Annotation> Builder b(@NonNull T t) {
            if (this.f24331b == null) {
                this.f24331b = new HashMap();
            }
            this.f24331b.put(t.annotationType(), t);
            return this;
        }
    }

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.f24328a = str;
        this.f24329b = map;
    }

    @NonNull
    public static Builder a(@NonNull String str) {
        return new Builder(str);
    }

    @NonNull
    public static FieldDescriptor d(@NonNull String str) {
        return new FieldDescriptor(str, Collections.emptyMap());
    }

    @NonNull
    public String b() {
        return this.f24328a;
    }

    @Nullable
    public <T extends Annotation> T c(@NonNull Class<T> cls) {
        return (Annotation) this.f24329b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        return this.f24328a.equals(fieldDescriptor.f24328a) && this.f24329b.equals(fieldDescriptor.f24329b);
    }

    public int hashCode() {
        return (this.f24328a.hashCode() * 31) + this.f24329b.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.f24328a + ", properties=" + this.f24329b.values() + "}";
    }
}

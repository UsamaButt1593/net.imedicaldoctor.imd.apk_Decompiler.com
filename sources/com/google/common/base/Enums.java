package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class Enums {
    @GwtIncompatible

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> f22261a = new WeakHashMap();

    @GwtIncompatible
    private static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long Z = 0;
        private final Class<T> Y;

        StringConverter(Class<T> cls) {
            this.Y = (Class) Preconditions.E(cls);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof StringConverter) {
                return this.Y.equals(((StringConverter) obj).Y);
            }
            return false;
        }

        public int hashCode() {
            return this.Y.hashCode();
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public String h(T t) {
            return t.name();
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public T i(String str) {
            return Enum.valueOf(this.Y, str);
        }

        public String toString() {
            return "Enums.stringConverter(" + this.Y.getName() + ".class)";
        }
    }

    private Enums() {
    }

    @GwtIncompatible
    static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> a(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> map;
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> map2 = f22261a;
        synchronized (map2) {
            try {
                map = map2.get(cls);
                if (map == null) {
                    map = d(cls);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    @GwtIncompatible
    public static Field b(Enum<?> enumR) {
        try {
            return enumR.getDeclaringClass().getDeclaredField(enumR.name());
        } catch (NoSuchFieldException e2) {
            throw new AssertionError(e2);
        }
    }

    public static <T extends Enum<T>> Optional<T> c(Class<T> cls, String str) {
        Preconditions.E(cls);
        Preconditions.E(str);
        return Platform.d(cls, str);
    }

    @GwtIncompatible
    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> d(Class<T> cls) {
        HashMap hashMap = new HashMap();
        Iterator<E> it2 = EnumSet.allOf(cls).iterator();
        while (it2.hasNext()) {
            Enum enumR = (Enum) it2.next();
            hashMap.put(enumR.name(), new WeakReference(enumR));
        }
        f22261a.put(cls, hashMap);
        return hashMap;
    }

    @GwtIncompatible
    public static <T extends Enum<T>> Converter<String, T> e(Class<T> cls) {
        return new StringConverter(cls);
    }
}

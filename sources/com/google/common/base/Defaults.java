package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class Defaults {

    /* renamed from: a  reason: collision with root package name */
    private static final Double f22259a = Double.valueOf(0.0d);

    /* renamed from: b  reason: collision with root package name */
    private static final Float f22260b = Float.valueOf(0.0f);

    private Defaults() {
    }

    @CheckForNull
    public static <T> T a(Class<T> cls) {
        Preconditions.E(cls);
        if (!cls.isPrimitive()) {
            return null;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Character.TYPE) {
            return 0;
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Float.TYPE) {
            return f22260b;
        }
        if (cls == Double.TYPE) {
            return f22259a;
        }
        return null;
    }
}

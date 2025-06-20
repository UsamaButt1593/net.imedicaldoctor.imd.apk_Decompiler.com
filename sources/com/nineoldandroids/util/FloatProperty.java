package com.nineoldandroids.util;

public abstract class FloatProperty<T> extends Property<T, Float> {
    public FloatProperty(String str) {
        super(Float.class, str);
    }

    /* renamed from: g */
    public final void f(T t, Float f2) {
        h(t, f2.floatValue());
    }

    public abstract void h(T t, float f2);
}

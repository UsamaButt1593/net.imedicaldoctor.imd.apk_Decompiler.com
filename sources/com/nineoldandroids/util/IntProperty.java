package com.nineoldandroids.util;

public abstract class IntProperty<T> extends Property<T, Integer> {
    public IntProperty(String str) {
        super(Integer.class, str);
    }

    /* renamed from: g */
    public final void f(T t, Integer num) {
        num.intValue();
        f(t, num);
    }

    public abstract void h(T t, int i2);
}

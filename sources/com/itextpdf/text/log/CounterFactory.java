package com.itextpdf.text.log;

public class CounterFactory {

    /* renamed from: b  reason: collision with root package name */
    private static CounterFactory f25812b = new CounterFactory();

    /* renamed from: a  reason: collision with root package name */
    private Counter f25813a = new DefaultCounter();

    private CounterFactory() {
    }

    public static Counter b(Class<?> cls) {
        return f25812b.f25813a.a(cls);
    }

    public static CounterFactory c() {
        return f25812b;
    }

    public Counter a() {
        return this.f25813a;
    }

    public void d(Counter counter) {
        this.f25813a = counter;
    }
}

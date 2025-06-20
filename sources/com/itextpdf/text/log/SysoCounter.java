package com.itextpdf.text.log;

public class SysoCounter implements Counter {

    /* renamed from: a  reason: collision with root package name */
    protected String f25821a;

    public SysoCounter() {
        this.f25821a = "iText";
    }

    public Counter a(Class<?> cls) {
        return new SysoCounter(cls);
    }

    public void b(long j2) {
        System.out.println(String.format("[%s] %s bytes read", new Object[]{this.f25821a, Long.valueOf(j2)}));
    }

    public void c(long j2) {
        System.out.println(String.format("[%s] %s bytes written", new Object[]{this.f25821a, Long.valueOf(j2)}));
    }

    protected SysoCounter(Class<?> cls) {
        this.f25821a = cls.getName();
    }
}

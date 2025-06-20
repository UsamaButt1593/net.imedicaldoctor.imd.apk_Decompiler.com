package com.itextpdf.text.log;

public class LoggerFactory {

    /* renamed from: b  reason: collision with root package name */
    private static LoggerFactory f25819b = new LoggerFactory();

    /* renamed from: a  reason: collision with root package name */
    private Logger f25820a = new NoOpLogger();

    private LoggerFactory() {
    }

    public static LoggerFactory a() {
        return f25819b;
    }

    public static Logger b(Class<?> cls) {
        return f25819b.f25820a.d(cls);
    }

    public static Logger c(String str) {
        return f25819b.f25820a.e(str);
    }

    public Logger d() {
        return this.f25820a;
    }

    public void e(Logger logger) {
        this.f25820a = logger;
    }
}

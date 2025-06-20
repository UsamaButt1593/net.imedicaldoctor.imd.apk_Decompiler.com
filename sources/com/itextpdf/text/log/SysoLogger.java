package com.itextpdf.text.log;

import java.io.PrintStream;
import org.apache.commons.lang3.ClassUtils;

public class SysoLogger implements Logger {

    /* renamed from: a  reason: collision with root package name */
    private String f25822a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25823b;

    public SysoLogger() {
        this(1);
    }

    private String j(String str) {
        if (this.f25823b == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int indexOf = str.indexOf(46);
        String str2 = str;
        while (indexOf != -1) {
            int i2 = this.f25823b;
            if (indexOf < i2) {
                i2 = indexOf;
            }
            sb.append(str2.substring(0, i2));
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            str2 = str2.substring(indexOf + 1);
            indexOf = str2.indexOf(46);
        }
        sb.append(str.substring(str.lastIndexOf(46) + 1));
        return sb.toString();
    }

    public void a(String str) {
        System.out.println(String.format("%s DEBUG %s", new Object[]{j(this.f25822a), str}));
    }

    public boolean b(Level level) {
        return true;
    }

    public void c(String str) {
        System.out.println(String.format("%s ERROR %s", new Object[]{this.f25822a, str}));
    }

    public Logger d(Class<?> cls) {
        return new SysoLogger(cls.getName(), this.f25823b);
    }

    public Logger e(String str) {
        return new SysoLogger("[itext]", 0);
    }

    public void f(String str) {
        System.out.println(String.format("%s INFO  %s", new Object[]{j(this.f25822a), str}));
    }

    public void g(String str) {
        System.out.println(String.format("%s WARN  %s", new Object[]{j(this.f25822a), str}));
    }

    public void h(String str) {
        System.out.println(String.format("%s TRACE %s", new Object[]{j(this.f25822a), str}));
    }

    public void i(String str, Exception exc) {
        PrintStream printStream = System.out;
        printStream.println(String.format("%s ERROR %s", new Object[]{this.f25822a, str}));
        exc.printStackTrace(printStream);
    }

    public SysoLogger(int i2) {
        this.f25823b = i2;
    }

    protected SysoLogger(String str, int i2) {
        this.f25823b = i2;
        this.f25822a = str;
    }
}

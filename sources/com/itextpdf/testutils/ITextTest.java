package com.itextpdf.testutils;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import java.io.File;
import java.io.IOException;

public abstract class ITextTest {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f25672a = LoggerFactory.c(ITextTest.class.getName());

    /* access modifiers changed from: protected */
    public void a(String str) throws Exception {
    }

    /* access modifiers changed from: protected */
    public void b(String str, String str2) throws Exception {
    }

    /* access modifiers changed from: protected */
    public void c(File file) {
        if (file != null && file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    c(file2);
                }
                file2.delete();
            }
            file.delete();
        }
    }

    /* access modifiers changed from: protected */
    public void d(File file) {
        if (file != null && file.exists()) {
            for (File delete : file.listFiles()) {
                delete.delete();
            }
        }
    }

    /* access modifiers changed from: protected */
    public String e() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract String f();

    /* access modifiers changed from: protected */
    public abstract void g(String str) throws Exception;

    public void h() throws Exception {
        Logger logger = f25672a;
        logger.f("Starting test.");
        String f2 = f();
        if (f2 == null || f2.length() == 0) {
            throw new IOException("outPdf cannot be empty!");
        }
        g(f2);
        a(f2);
        b(f2, e());
        logger.f("Test complete.");
    }
}

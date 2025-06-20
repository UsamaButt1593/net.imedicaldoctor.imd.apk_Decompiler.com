package com.itextpdf.tool.xml.net;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FileRetrieveImpl implements FileRetrieve {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f27650c = LoggerFactory.b(FileRetrieveImpl.class);

    /* renamed from: a  reason: collision with root package name */
    private final List<File> f27651a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f27652b;

    public FileRetrieveImpl() {
        this.f27651a = new CopyOnWriteArrayList();
        this.f27652b = new CopyOnWriteArrayList();
    }

    private URL e(String str) throws MalformedURLException {
        for (String next : this.f27652b) {
            try {
                return new URL(next + str);
            } catch (MalformedURLException unused) {
            }
        }
        throw new MalformedURLException();
    }

    private void f(ReadingProcessor readingProcessor, InputStream inputStream) throws IOException {
        while (true) {
            try {
                int read = inputStream.read();
                if (read != -1) {
                    readingProcessor.a(read);
                } else {
                    try {
                        inputStream.close();
                        return;
                    } catch (IOException e2) {
                        throw new RuntimeWorkerException((Throwable) e2);
                    }
                }
            } catch (IOException e3) {
                throw e3;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        throw new RuntimeWorkerException((Throwable) e4);
                    }
                }
                throw th;
            }
        }
    }

    public void a(InputStream inputStream, ReadingProcessor readingProcessor) throws IOException {
        f(readingProcessor, inputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        r3 = new java.io.File(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        r4 = r7.f27651a.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        if (r4.hasNext() != false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        r5 = new java.io.File(r4.next(), r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        if (r5.isFile() == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r3 = null;
        r2 = e(r8);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r8, com.itextpdf.tool.xml.net.ReadingProcessor r9) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            com.itextpdf.text.log.Logger r2 = f27650c
            com.itextpdf.text.log.Level r3 = com.itextpdf.text.log.Level.DEBUG
            boolean r3 = r2.b(r3)
            if (r3 == 0) goto L_0x0021
            com.itextpdf.tool.xml.exceptions.LocaleMessages r3 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()
            java.lang.String r4 = "retrieve.file.from"
            java.lang.String r3 = r3.b(r4)
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r0] = r8
            java.lang.String r3 = java.lang.String.format(r3, r4)
            r2.a(r3)
        L_0x0021:
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x002b }
            r3.<init>(r8)     // Catch:{ MalformedURLException -> 0x002b }
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x006d
        L_0x002b:
            java.net.URL r8 = r7.e(r8)     // Catch:{ MalformedURLException -> 0x0032 }
            r3 = r2
            r2 = r8
            goto L_0x006d
        L_0x0032:
            java.io.File r3 = new java.io.File
            r3.<init>(r8)
            boolean r4 = r3.isFile()
            if (r4 == 0) goto L_0x0046
            boolean r4 = r3.canRead()
            if (r4 != 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r0 = 1
            goto L_0x006d
        L_0x0046:
            java.util.List<java.io.File> r4 = r7.f27651a
            java.util.Iterator r4 = r4.iterator()
        L_0x004c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x006d
            java.lang.Object r3 = r4.next()
            java.io.File r3 = (java.io.File) r3
            java.io.File r5 = new java.io.File
            r5.<init>(r3, r8)
            boolean r3 = r5.isFile()
            if (r3 == 0) goto L_0x006b
            boolean r3 = r5.canRead()
            if (r3 == 0) goto L_0x006b
            r3 = r5
            goto L_0x0044
        L_0x006b:
            r3 = r5
            goto L_0x004c
        L_0x006d:
            if (r2 == 0) goto L_0x0074
            java.io.InputStream r8 = r2.openStream()
            goto L_0x007b
        L_0x0074:
            if (r0 == 0) goto L_0x007f
            java.io.FileInputStream r8 = new java.io.FileInputStream
            r8.<init>(r3)
        L_0x007b:
            r7.f(r9, r8)
            return
        L_0x007f:
            java.io.IOException r8 = new java.io.IOException
            com.itextpdf.tool.xml.exceptions.LocaleMessages r9 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()
            java.lang.String r0 = "retrieve.file.from.nothing"
            java.lang.String r9 = r9.b(r0)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.net.FileRetrieveImpl.b(java.lang.String, com.itextpdf.tool.xml.net.ReadingProcessor):void");
    }

    public void c(File file) {
        this.f27651a.add(file);
    }

    public void d(String str) {
        this.f27652b.add(str);
    }

    public FileRetrieveImpl(File file) {
        this();
        if (file.isDirectory()) {
            this.f27651a.add(file);
        }
    }

    public FileRetrieveImpl(String... strArr) {
        this();
        for (String str : strArr) {
            if (str.startsWith("http") || str.startsWith("https")) {
                this.f27652b.add(str);
            } else {
                File file = new File(str);
                if (file.isDirectory()) {
                    this.f27651a.add(file);
                }
            }
        }
    }
}

package com.dd.plist;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class PropertyListParser {
    protected PropertyListParser() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        throw new java.lang.Exception("The root of the given input property list is neither a Dictionary nor an Array!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.File r1, java.io.File r2) throws java.lang.Exception {
        /*
            com.dd.plist.NSObject r1 = e(r1)
            r0 = r1
            com.dd.plist.NSDictionary r0 = (com.dd.plist.NSDictionary) r0     // Catch:{ Exception -> 0x000b }
            k(r0, r2)     // Catch:{ Exception -> 0x000b }
            goto L_0x0010
        L_0x000b:
            com.dd.plist.NSArray r1 = (com.dd.plist.NSArray) r1     // Catch:{ Exception -> 0x0011 }
            j(r1, r2)     // Catch:{ Exception -> 0x0011 }
        L_0x0010:
            return
        L_0x0011:
            java.lang.Exception r1 = new java.lang.Exception
            java.lang.String r2 = "The root of the given input property list is neither a Dictionary nor an Array!"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.plist.PropertyListParser.a(java.io.File, java.io.File):void");
    }

    public static void b(File file, File file2) throws Exception {
        l(e(file), file2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        throw new java.lang.Exception("The root of the given input property list is neither a Dictionary nor an Array!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(java.io.File r1, java.io.File r2) throws java.lang.Exception {
        /*
            com.dd.plist.NSObject r1 = e(r1)
            r0 = r1
            com.dd.plist.NSDictionary r0 = (com.dd.plist.NSDictionary) r0     // Catch:{ Exception -> 0x000b }
            o(r0, r2)     // Catch:{ Exception -> 0x000b }
            goto L_0x0010
        L_0x000b:
            com.dd.plist.NSArray r1 = (com.dd.plist.NSArray) r1     // Catch:{ Exception -> 0x0011 }
            n(r1, r2)     // Catch:{ Exception -> 0x0011 }
        L_0x0010:
            return
        L_0x0011:
            java.lang.Exception r1 = new java.lang.Exception
            java.lang.String r2 = "The root of the given input property list is neither a Dictionary nor an Array!"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.plist.PropertyListParser.c(java.io.File, java.io.File):void");
    }

    public static void d(File file, File file2) throws Exception {
        p(e(file), file2);
    }

    public static NSObject e(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        String str = new String(i(fileInputStream, 8), 0, 8);
        fileInputStream.close();
        if (str.startsWith("bplist")) {
            return BinaryPropertyListParser.c(file);
        }
        return (str.trim().startsWith("(") || str.trim().startsWith("{") || str.trim().startsWith("/")) ? ASCIIPropertyListParser.g(file) : XMLPropertyListParser.e(file);
    }

    public static NSObject f(InputStream inputStream) throws Exception {
        if (!inputStream.markSupported()) {
            return h(i(inputStream, Integer.MAX_VALUE));
        }
        inputStream.mark(10);
        String str = new String(i(inputStream, 8), 0, 8);
        inputStream.reset();
        if (str.startsWith("bplist")) {
            return BinaryPropertyListParser.d(inputStream);
        }
        return (str.trim().startsWith("(") || str.trim().startsWith("{") || str.trim().startsWith("/")) ? ASCIIPropertyListParser.h(inputStream) : XMLPropertyListParser.f(inputStream);
    }

    public static NSObject g(String str) throws Exception {
        return e(new File(str));
    }

    public static NSObject h(byte[] bArr) throws Exception {
        String str = new String(bArr, 0, 8);
        if (str.startsWith("bplist")) {
            return BinaryPropertyListParser.e(bArr);
        }
        return (str.trim().startsWith("(") || str.trim().startsWith("{") || str.trim().startsWith("/")) ? ASCIIPropertyListParser.i(bArr) : XMLPropertyListParser.g(bArr);
    }

    protected static byte[] i(InputStream inputStream, int i2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (i2 > 0) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(read);
            i2--;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void j(NSArray nSArray, File file) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), NTLM.DEFAULT_CHARSET);
        outputStreamWriter.write(nSArray.J());
        outputStreamWriter.close();
    }

    public static void k(NSDictionary nSDictionary, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), NTLM.DEFAULT_CHARSET);
        outputStreamWriter.write(nSDictionary.c0());
        outputStreamWriter.close();
    }

    public static void l(NSObject nSObject, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        BinaryPropertyListWriter.h(file, nSObject);
    }

    public static void m(NSObject nSObject, OutputStream outputStream) throws IOException {
        BinaryPropertyListWriter.i(outputStream, nSObject);
    }

    public static void n(NSArray nSArray, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), NTLM.DEFAULT_CHARSET);
        outputStreamWriter.write(nSArray.K());
        outputStreamWriter.close();
    }

    public static void o(NSDictionary nSDictionary, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), NTLM.DEFAULT_CHARSET);
        outputStreamWriter.write(nSDictionary.d0());
        outputStreamWriter.close();
    }

    public static void p(NSObject nSObject, File file) throws IOException {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        q(nSObject, fileOutputStream);
        fileOutputStream.close();
    }

    public static void q(NSObject nSObject, OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        outputStreamWriter.write(nSObject.i());
        outputStreamWriter.close();
    }
}

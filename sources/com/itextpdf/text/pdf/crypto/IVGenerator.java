package com.itextpdf.text.pdf.crypto;

public final class IVGenerator {

    /* renamed from: a  reason: collision with root package name */
    private static ARCFOUREncryption f26779a = new ARCFOUREncryption();

    static {
        long currentTimeMillis = System.currentTimeMillis();
        long freeMemory = Runtime.getRuntime().freeMemory();
        f26779a.e((currentTimeMillis + "+" + freeMemory).getBytes());
    }

    private IVGenerator() {
    }

    public static byte[] a() {
        return b(16);
    }

    public static byte[] b(int i2) {
        byte[] bArr = new byte[i2];
        synchronized (f26779a) {
            f26779a.a(bArr);
        }
        return bArr;
    }
}

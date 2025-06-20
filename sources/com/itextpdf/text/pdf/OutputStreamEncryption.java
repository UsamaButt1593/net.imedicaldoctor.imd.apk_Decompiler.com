package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.pdf.crypto.AESCipher;
import com.itextpdf.text.pdf.crypto.ARCFOUREncryption;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEncryption extends OutputStream {
    private static final int Z2 = 4;
    private static final int a3 = 5;
    protected ARCFOUREncryption X;
    private boolean X2;
    protected AESCipher Y;
    private boolean Y2;
    private byte[] Z;
    protected OutputStream s;

    public OutputStreamEncryption(OutputStream outputStream, byte[] bArr, int i2) {
        this(outputStream, bArr, 0, bArr.length, i2);
    }

    public void b() throws IOException {
        if (!this.Y2) {
            this.Y2 = true;
            if (this.X2) {
                try {
                    byte[] a2 = this.Y.a();
                    this.s.write(a2, 0, a2.length);
                } catch (Exception e2) {
                    throw new ExceptionConverter(e2);
                }
            }
        }
    }

    public void close() throws IOException {
        b();
        this.s.close();
    }

    public void flush() throws IOException {
        this.s.flush();
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.Z;
        bArr[0] = (byte) i2;
        write(bArr, 0, 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019 A[Catch:{ Exception -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f A[Catch:{ Exception -> 0x002d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OutputStreamEncryption(java.io.OutputStream r3, byte[] r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 1
            byte[] r1 = new byte[r0]
            r2.Z = r1
            r2.s = r3     // Catch:{ Exception -> 0x002d }
            r3 = 4
            r1 = 0
            if (r7 == r3) goto L_0x0014
            r3 = 5
            if (r7 != r3) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r3 = 0
            goto L_0x0015
        L_0x0014:
            r3 = 1
        L_0x0015:
            r2.X2 = r3     // Catch:{ Exception -> 0x002d }
            if (r3 == 0) goto L_0x002f
            byte[] r3 = com.itextpdf.text.pdf.crypto.IVGenerator.a()     // Catch:{ Exception -> 0x002d }
            byte[] r7 = new byte[r6]     // Catch:{ Exception -> 0x002d }
            java.lang.System.arraycopy(r4, r5, r7, r1, r6)     // Catch:{ Exception -> 0x002d }
            com.itextpdf.text.pdf.crypto.AESCipher r4 = new com.itextpdf.text.pdf.crypto.AESCipher     // Catch:{ Exception -> 0x002d }
            r4.<init>(r0, r7, r3)     // Catch:{ Exception -> 0x002d }
            r2.Y = r4     // Catch:{ Exception -> 0x002d }
            r2.write((byte[]) r3)     // Catch:{ Exception -> 0x002d }
            goto L_0x0039
        L_0x002d:
            r3 = move-exception
            goto L_0x003a
        L_0x002f:
            com.itextpdf.text.pdf.crypto.ARCFOUREncryption r3 = new com.itextpdf.text.pdf.crypto.ARCFOUREncryption     // Catch:{ Exception -> 0x002d }
            r3.<init>()     // Catch:{ Exception -> 0x002d }
            r2.X = r3     // Catch:{ Exception -> 0x002d }
            r3.f(r4, r5, r6)     // Catch:{ Exception -> 0x002d }
        L_0x0039:
            return
        L_0x003a:
            com.itextpdf.text.ExceptionConverter r4 = new com.itextpdf.text.ExceptionConverter
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.OutputStreamEncryption.<init>(java.io.OutputStream, byte[], int, int, int):void");
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (this.X2) {
            byte[] b2 = this.Y.b(bArr, i2, i3);
            if (b2 != null && b2.length != 0) {
                this.s.write(b2, 0, b2.length);
                return;
            }
            return;
        }
        int min = Math.min(i3, 4192);
        byte[] bArr2 = new byte[min];
        while (i3 > 0) {
            int min2 = Math.min(i3, min);
            this.X.c(bArr, i2, min2, bArr2, 0);
            this.s.write(bArr2, 0, min2);
            i3 -= min2;
            i2 += min2;
        }
    }
}

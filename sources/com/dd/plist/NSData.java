package com.dd.plist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public class NSData extends NSObject {
    private byte[] Z;

    public NSData(File file) throws FileNotFoundException, IOException {
        this.Z = new byte[((int) file.length())];
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        randomAccessFile.read(this.Z);
        randomAccessFile.close();
    }

    public void A(ByteBuffer byteBuffer, int i2) {
        byte[] bArr = this.Z;
        byteBuffer.put(bArr, 0, Math.min(bArr.length, i2));
    }

    public void C(ByteBuffer byteBuffer, int i2, int i3) {
        byte[] bArr = this.Z;
        byteBuffer.put(bArr, i2, Math.min(bArr.length, i3));
    }

    public int D() {
        return this.Z.length;
    }

    /* access modifiers changed from: protected */
    public void c(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append('<');
        int lastIndexOf = sb.lastIndexOf(NSObject.s);
        int i3 = 0;
        while (true) {
            byte[] bArr = this.Z;
            if (i3 < bArr.length) {
                byte b2 = bArr[i3] & 255;
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
                if (sb.length() - lastIndexOf > 80) {
                    sb.append(NSObject.s);
                    lastIndexOf = sb.length();
                } else if ((i3 + 1) % 2 == 0 && i3 != this.Z.length - 1) {
                    sb.append(StringUtils.SPACE);
                }
                i3++;
            } else {
                sb.append('>');
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e(StringBuilder sb, int i2) {
        c(sb, i2);
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && Arrays.equals(((NSData) obj).Z, this.Z);
    }

    /* access modifiers changed from: package-private */
    public void f(BinaryPropertyListWriter binaryPropertyListWriter) throws IOException {
        binaryPropertyListWriter.n(4, this.Z.length);
        binaryPropertyListWriter.j(this.Z);
    }

    /* access modifiers changed from: package-private */
    public void h(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("<data>");
        sb.append(NSObject.s);
        for (String append : z().split(StringUtils.LF)) {
            b(sb, i2 + 1);
            sb.append(append);
            sb.append(NSObject.s);
        }
        b(sb, i2);
        sb.append("</data>");
    }

    public int hashCode() {
        return 335 + Arrays.hashCode(this.Z);
    }

    public byte[] y() {
        return this.Z;
    }

    public String z() {
        return Base64.s(this.Z);
    }

    public NSData(String str) throws IOException {
        this.Z = Base64.e(str.replaceAll("\\s+", ""));
    }

    public NSData(byte[] bArr) {
        this.Z = bArr;
    }
}

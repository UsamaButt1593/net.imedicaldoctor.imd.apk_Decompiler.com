package com.dd.plist;

import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public class UID extends NSObject {
    private String X2;
    private byte[] Z;

    public UID(String str, byte[] bArr) {
        this.X2 = str;
        this.Z = bArr;
    }

    /* access modifiers changed from: protected */
    public void c(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("\"");
        int i3 = 0;
        while (true) {
            byte[] bArr = this.Z;
            if (i3 < bArr.length) {
                byte b2 = bArr[i3];
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
                i3++;
            } else {
                sb.append("\"");
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e(StringBuilder sb, int i2) {
        c(sb, i2);
    }

    /* access modifiers changed from: package-private */
    public void f(BinaryPropertyListWriter binaryPropertyListWriter) throws IOException {
        binaryPropertyListWriter.f(this.Z.length + WorkQueueKt.f29430c);
        binaryPropertyListWriter.j(this.Z);
    }

    /* access modifiers changed from: package-private */
    public void h(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("<string>");
        int i3 = 0;
        while (true) {
            byte[] bArr = this.Z;
            if (i3 < bArr.length) {
                byte b2 = bArr[i3];
                if (b2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b2));
                i3++;
            } else {
                sb.append("</string>");
                return;
            }
        }
    }

    public byte[] y() {
        return this.Z;
    }

    public String z() {
        return this.X2;
    }
}

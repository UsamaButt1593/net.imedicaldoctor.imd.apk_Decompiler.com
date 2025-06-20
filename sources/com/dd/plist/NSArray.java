package com.dd.plist;

import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public class NSArray extends NSObject {
    private NSObject[] Z;

    public NSArray(int i2) {
        this.Z = new NSObject[i2];
    }

    public NSObject[] A() {
        return this.Z;
    }

    public int C(NSObject nSObject) {
        int i2 = 0;
        while (true) {
            NSObject[] nSObjectArr = this.Z;
            if (i2 >= nSObjectArr.length) {
                return -1;
            }
            if (nSObjectArr[i2] == nSObject) {
                return i2;
            }
            i2++;
        }
    }

    public int D(NSObject nSObject) {
        int i2 = 0;
        while (true) {
            NSObject[] nSObjectArr = this.Z;
            if (i2 >= nSObjectArr.length) {
                return -1;
            }
            if (nSObjectArr[i2].equals(nSObject)) {
                return i2;
            }
            i2++;
        }
    }

    public NSObject E() {
        NSObject[] nSObjectArr = this.Z;
        return nSObjectArr[nSObjectArr.length - 1];
    }

    public NSObject F(int i2) {
        return this.Z[i2];
    }

    public NSObject[] G(int... iArr) {
        NSObject[] nSObjectArr = new NSObject[iArr.length];
        Arrays.sort(iArr);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            nSObjectArr[i2] = this.Z[iArr[i2]];
        }
        return nSObjectArr;
    }

    public void H(int i2) {
        NSObject[] nSObjectArr = this.Z;
        if (i2 >= nSObjectArr.length || i2 < 0) {
            throw new ArrayIndexOutOfBoundsException("invalid index:" + i2 + ";the array length is " + this.Z.length);
        }
        NSObject[] nSObjectArr2 = new NSObject[(nSObjectArr.length - 1)];
        System.arraycopy(nSObjectArr, 0, nSObjectArr2, 0, i2);
        NSObject[] nSObjectArr3 = this.Z;
        System.arraycopy(nSObjectArr3, i2 + 1, nSObjectArr2, i2, (nSObjectArr3.length - i2) - 1);
        this.Z = nSObjectArr2;
    }

    public void I(int i2, NSObject nSObject) {
        this.Z[i2] = nSObject;
    }

    public String J() {
        StringBuilder sb = new StringBuilder();
        c(sb, 0);
        sb.append(NSObject.s);
        return sb.toString();
    }

    public String K() {
        StringBuilder sb = new StringBuilder();
        e(sb, 0);
        sb.append(NSObject.s);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void a(BinaryPropertyListWriter binaryPropertyListWriter) {
        super.a(binaryPropertyListWriter);
        for (NSObject a2 : this.Z) {
            a2.a(binaryPropertyListWriter);
        }
    }

    /* access modifiers changed from: protected */
    public void c(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append(ASCIIPropertyListParser.f18649g);
        int lastIndexOf = sb.lastIndexOf(NSObject.s);
        int i3 = 0;
        while (true) {
            NSObject[] nSObjectArr = this.Z;
            if (i3 < nSObjectArr.length) {
                Class<?> cls = nSObjectArr[i3].getClass();
                if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                    sb.append(NSObject.s);
                    lastIndexOf = sb.length();
                    this.Z[i3].c(sb, i2 + 1);
                } else {
                    if (i3 != 0) {
                        sb.append(StringUtils.SPACE);
                    }
                    this.Z[i3].c(sb, 0);
                }
                if (i3 != this.Z.length - 1) {
                    sb.append(ASCIIPropertyListParser.f18651i);
                }
                if (sb.length() - lastIndexOf > 80) {
                    sb.append(NSObject.s);
                    lastIndexOf = sb.length();
                }
                i3++;
            } else {
                sb.append(ASCIIPropertyListParser.f18650h);
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append(ASCIIPropertyListParser.f18649g);
        int lastIndexOf = sb.lastIndexOf(NSObject.s);
        int i3 = 0;
        while (true) {
            NSObject[] nSObjectArr = this.Z;
            if (i3 < nSObjectArr.length) {
                Class<?> cls = nSObjectArr[i3].getClass();
                if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                    sb.append(NSObject.s);
                    lastIndexOf = sb.length();
                    this.Z[i3].e(sb, i2 + 1);
                } else {
                    if (i3 != 0) {
                        sb.append(StringUtils.SPACE);
                    }
                    this.Z[i3].e(sb, 0);
                }
                if (i3 != this.Z.length - 1) {
                    sb.append(ASCIIPropertyListParser.f18651i);
                }
                if (sb.length() - lastIndexOf > 80) {
                    sb.append(NSObject.s);
                    lastIndexOf = sb.length();
                }
                i3++;
            } else {
                sb.append(ASCIIPropertyListParser.f18650h);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && Arrays.equals(((NSArray) obj).A(), this.Z);
    }

    /* access modifiers changed from: package-private */
    public void f(BinaryPropertyListWriter binaryPropertyListWriter) throws IOException {
        binaryPropertyListWriter.n(10, this.Z.length);
        for (NSObject d2 : this.Z) {
            binaryPropertyListWriter.m(binaryPropertyListWriter.d(d2));
        }
    }

    /* access modifiers changed from: package-private */
    public void h(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("<array>");
        sb.append(NSObject.s);
        for (NSObject h2 : this.Z) {
            h2.h(sb, i2 + 1);
            sb.append(NSObject.s);
        }
        b(sb, i2);
        sb.append("</array>");
    }

    public int hashCode() {
        return 623 + Arrays.deepHashCode(this.Z);
    }

    public boolean y(NSObject nSObject) {
        for (NSObject equals : this.Z) {
            if (equals.equals(nSObject)) {
                return true;
            }
        }
        return false;
    }

    public int z() {
        return this.Z.length;
    }

    public NSArray(NSObject... nSObjectArr) {
        this.Z = nSObjectArr;
    }
}

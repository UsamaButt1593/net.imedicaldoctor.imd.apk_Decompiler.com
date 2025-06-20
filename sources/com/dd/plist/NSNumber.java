package com.dd.plist;

import java.io.IOException;
import net.lingala.zip4j.util.InternalZipConstants;

public class NSNumber extends NSObject implements Comparable<Object> {
    public static final int a3 = 0;
    public static final int b3 = 1;
    public static final int c3 = 2;
    private long X2;
    private double Y2;
    private int Z;
    private boolean Z2;

    public NSNumber(double d2) {
        this.Y2 = d2;
        this.X2 = (long) d2;
        this.Z = 1;
    }

    public float A() {
        return (float) this.Y2;
    }

    public int C() {
        return (int) this.X2;
    }

    public boolean D() {
        return this.Z == 2;
    }

    public boolean E() {
        return this.Z == 0;
    }

    public boolean F() {
        return this.Z == 1;
    }

    public long G() {
        return this.X2;
    }

    public int H() {
        return this.Z;
    }

    /* access modifiers changed from: protected */
    public void c(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append(this.Z == 2 ? this.Z2 ? "YES" : "NO" : toString());
    }

    public int compareTo(Object obj) {
        double z = z();
        if (obj instanceof NSNumber) {
            double z2 = ((NSNumber) obj).z();
            if (z < z2) {
                return -1;
            }
            return z == z2 ? 0 : 1;
        } else if (!(obj instanceof Number)) {
            return -1;
        } else {
            double doubleValue = ((Number) obj).doubleValue();
            if (z < doubleValue) {
                return -1;
            }
            return z == doubleValue ? 0 : 1;
        }
    }

    /* access modifiers changed from: protected */
    public void e(StringBuilder sb, int i2) {
        String str;
        b(sb, i2);
        int i3 = this.Z;
        if (i3 == 0) {
            str = "<*I";
        } else if (i3 == 1) {
            str = "<*R";
        } else if (i3 == 2) {
            sb.append(this.Z2 ? "<*BY>" : "<*BN>");
            return;
        } else {
            return;
        }
        sb.append(str);
        sb.append(toString());
        sb.append(">");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NSNumber)) {
            return false;
        }
        NSNumber nSNumber = (NSNumber) obj;
        return this.Z == nSNumber.Z && this.X2 == nSNumber.X2 && this.Y2 == nSNumber.Y2 && this.Z2 == nSNumber.Z2;
    }

    /* access modifiers changed from: package-private */
    public void f(BinaryPropertyListWriter binaryPropertyListWriter) throws IOException {
        long G;
        int H = H();
        int i2 = 1;
        int i3 = 8;
        if (H == 0) {
            if (G() >= 0) {
                if (G() <= 255) {
                    binaryPropertyListWriter.f(16);
                    G = G();
                } else if (G() <= 65535) {
                    binaryPropertyListWriter.f(17);
                    binaryPropertyListWriter.k(G(), 2);
                    return;
                } else if (G() <= InternalZipConstants.f30717k) {
                    binaryPropertyListWriter.f(18);
                    G = G();
                    i2 = 4;
                }
                binaryPropertyListWriter.k(G, i2);
                return;
            }
            binaryPropertyListWriter.f(19);
            binaryPropertyListWriter.k(G(), 8);
        } else if (H == 1) {
            binaryPropertyListWriter.f(35);
            binaryPropertyListWriter.l(z());
        } else if (H == 2) {
            if (y()) {
                i3 = 9;
            }
            binaryPropertyListWriter.f(i3);
        }
    }

    /* access modifiers changed from: package-private */
    public void h(StringBuilder sb, int i2) {
        String str;
        b(sb, i2);
        int i3 = this.Z;
        if (i3 == 0) {
            sb.append("<integer>");
            sb.append(G());
            str = "</integer>";
        } else if (i3 == 1) {
            sb.append("<real>");
            sb.append(z());
            str = "</real>";
        } else if (i3 == 2) {
            str = y() ? "<true/>" : "<false/>";
        } else {
            return;
        }
        sb.append(str);
    }

    public int hashCode() {
        long j2 = this.X2;
        return (((((this.Z * 37) + ((int) (j2 ^ (j2 >>> 32)))) * 37) + ((int) (Double.doubleToLongBits(this.Y2) ^ (Double.doubleToLongBits(this.Y2) >>> 32)))) * 37) + (y() ? 1 : 0);
    }

    public String toString() {
        int i2 = this.Z;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? super.toString() : String.valueOf(y()) : String.valueOf(z()) : String.valueOf(G());
    }

    public boolean y() {
        if (this.Z == 2) {
            return this.Z2;
        }
        return this.X2 != 0;
    }

    public double z() {
        return this.Y2;
    }

    public NSNumber(int i2) {
        long j2 = (long) i2;
        this.X2 = j2;
        this.Y2 = (double) j2;
        this.Z = 0;
    }

    public NSNumber(long j2) {
        this.X2 = j2;
        this.Y2 = (double) j2;
        this.Z = 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:6|5|7|8|9|10|14|15|17|19|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        throw new java.lang.Exception("not a boolean");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        r4.Z = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        if (r4.Z2 != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
        r4.X2 = r0;
        r4.Y2 = (double) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[Catch:{ Exception -> 0x0012, Exception -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A[Catch:{ Exception -> 0x0012, Exception -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NSNumber(java.lang.String r5) {
        /*
            r4 = this;
            r4.<init>()
            if (r5 == 0) goto L_0x007a
            r0 = 0
            long r1 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x0012 }
            r4.X2 = r1     // Catch:{ Exception -> 0x0012 }
            double r1 = (double) r1     // Catch:{ Exception -> 0x0012 }
            r4.Y2 = r1     // Catch:{ Exception -> 0x0012 }
            r4.Z = r0     // Catch:{ Exception -> 0x0012 }
            goto L_0x0071
        L_0x0012:
            r1 = 1
            double r2 = java.lang.Double.parseDouble(r5)     // Catch:{ Exception -> 0x0022 }
            r4.Y2 = r2     // Catch:{ Exception -> 0x0022 }
            long r2 = java.lang.Math.round(r2)     // Catch:{ Exception -> 0x0022 }
            r4.X2 = r2     // Catch:{ Exception -> 0x0022 }
            r4.Z = r1     // Catch:{ Exception -> 0x0022 }
            goto L_0x0071
        L_0x0022:
            java.lang.String r2 = r5.toLowerCase()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r3 = "true"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0072 }
            if (r2 != 0) goto L_0x003a
            java.lang.String r2 = r5.toLowerCase()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r3 = "yes"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x0072 }
            if (r2 == 0) goto L_0x003b
        L_0x003a:
            r0 = 1
        L_0x003b:
            r4.Z2 = r0     // Catch:{ Exception -> 0x0072 }
            if (r0 != 0) goto L_0x0060
            java.lang.String r0 = r5.toLowerCase()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r1 = "false"
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0072 }
            if (r0 != 0) goto L_0x0060
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = "no"
            boolean r5 = r5.equals(r0)     // Catch:{ Exception -> 0x0072 }
            if (r5 == 0) goto L_0x0058
            goto L_0x0060
        L_0x0058:
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = "not a boolean"
            r5.<init>(r0)     // Catch:{ Exception -> 0x0072 }
            throw r5     // Catch:{ Exception -> 0x0072 }
        L_0x0060:
            r5 = 2
            r4.Z = r5     // Catch:{ Exception -> 0x0072 }
            boolean r5 = r4.Z2     // Catch:{ Exception -> 0x0072 }
            if (r5 == 0) goto L_0x006a
            r0 = 1
            goto L_0x006c
        L_0x006a:
            r0 = 0
        L_0x006c:
            r4.X2 = r0     // Catch:{ Exception -> 0x0072 }
            double r0 = (double) r0     // Catch:{ Exception -> 0x0072 }
            r4.Y2 = r0     // Catch:{ Exception -> 0x0072 }
        L_0x0071:
            return
        L_0x0072:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "The given string neither represents a double, an int nor a boolean value."
            r5.<init>(r0)
            throw r5
        L_0x007a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "The given string is null and cannot be parsed as number."
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.plist.NSNumber.<init>(java.lang.String):void");
    }

    public NSNumber(boolean z) {
        this.Z2 = z;
        long j2 = z ? 1 : 0;
        this.X2 = j2;
        this.Y2 = (double) j2;
        this.Z = 2;
    }

    public NSNumber(byte[] bArr, int i2) {
        if (i2 == 0) {
            long g2 = BinaryPropertyListParser.g(bArr);
            this.X2 = g2;
            this.Y2 = (double) g2;
        } else if (i2 == 1) {
            double f2 = BinaryPropertyListParser.f(bArr);
            this.Y2 = f2;
            this.X2 = Math.round(f2);
        } else {
            throw new IllegalArgumentException("Type argument is not valid.");
        }
        this.Z = i2;
    }
}

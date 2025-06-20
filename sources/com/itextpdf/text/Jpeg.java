package com.itextpdf.text;

import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.commons.httpclient.HttpStatus;

public class Jpeg extends Image {
    public static final int N4 = -1;
    public static final int O4 = 0;
    public static final int[] P4 = {PsExtractor.x, 193, 194};
    public static final int Q4 = 1;
    public static final int[] R4 = {195, 197, 198, 199, 200, 201, 202, 203, HttpStatus.SC_RESET_CONTENT, HttpStatus.SC_PARTIAL_CONTENT, HttpStatus.SC_MULTI_STATUS};
    public static final int S4 = 2;
    public static final int[] T4 = {208, 209, 210, 211, 212, 213, 214, 215, 216, 1};
    public static final int U4 = 224;
    public static final int V4 = 226;
    public static final int W4 = 238;
    public static final int X4 = 237;
    public static final byte[] Y4 = {74, 70, 73, 70, 0};
    public static final byte[] Z4 = {56, 66, 73, 77, 3, -19};
    private byte[][] M4;

    Jpeg(Image image) {
        super(image);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:122:0x020e, code lost:
        com.itextpdf.text.Utilities.v(r10, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0217, code lost:
        if (r10.read() != 8) goto L_0x0284;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0219, code lost:
        r0 = (float) y2(r10);
        r1.E3 = r0;
        z0(r0);
        r0 = (float) y2(r10);
        r1.D3 = r0;
        x0(r0);
        r1.e4 = r10.read();
        r1.v3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0237, code lost:
        r10.close();
        r1.B3 = a0();
        r1.C3 = N();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0248, code lost:
        if (r1.M4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x024a, code lost:
        r0 = 0;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x024c, code lost:
        r3 = r1.M4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x024f, code lost:
        if (r0 >= r3.length) goto L_0x025e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0251, code lost:
        r3 = r3[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0253, code lost:
        if (r3 != null) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0255, code lost:
        r1.M4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0258, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0259, code lost:
        r2 = r2 + (r3.length - 14);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x025e, code lost:
        r0 = new byte[r2];
        r2 = 0;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0262, code lost:
        r3 = r1.M4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0265, code lost:
        if (r6 >= r3.length) goto L_0x0277;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0267, code lost:
        r3 = r3[r6];
        java.lang.System.arraycopy(r3, 14, r0, r2, r3.length - 14);
        r2 = r2 + (r1.M4[r6].length - 14);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        x2(com.itextpdf.text.pdf.ICC_Profile.e(r0, r1.e4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0294, code lost:
        throw new com.itextpdf.text.BadElementException(com.itextpdf.text.error_messages.MessageLocalization.b("1.must.have.8.bits.per.component", r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x016a, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A2() throws com.itextpdf.text.BadElementException, java.io.IOException {
        /*
            r21 = this;
            r1 = r21
            r3 = 5
            r4 = 12
            r5 = 16
            r6 = 0
            r7 = 2
            r8 = 32
            r1.s3 = r8
            r8 = 1
            r1.Y3 = r8
            byte[] r10 = r1.u3     // Catch:{ all -> 0x02e5 }
            if (r10 != 0) goto L_0x0029
            java.net.URL r10 = r1.t3     // Catch:{ all -> 0x0025 }
            java.io.InputStream r10 = r10.openStream()     // Catch:{ all -> 0x0025 }
            java.net.URL r11 = r1.t3     // Catch:{ all -> 0x0021 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0021 }
            goto L_0x0032
        L_0x0021:
            r0 = move-exception
            r9 = r10
            goto L_0x02e8
        L_0x0025:
            r0 = move-exception
            r9 = 0
            goto L_0x02e8
        L_0x0029:
            java.io.ByteArrayInputStream r10 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x02e5 }
            byte[] r11 = r1.u3     // Catch:{ all -> 0x02e5 }
            r10.<init>(r11)     // Catch:{ all -> 0x02e5 }
            java.lang.String r11 = "Byte array"
        L_0x0032:
            int r12 = r10.read()     // Catch:{ all -> 0x0021 }
            r13 = 255(0xff, float:3.57E-43)
            if (r12 != r13) goto L_0x02d4
            int r12 = r10.read()     // Catch:{ all -> 0x0021 }
            r14 = 216(0xd8, float:3.03E-43)
            if (r12 != r14) goto L_0x02d4
            r12 = 1
        L_0x0043:
            int r14 = r10.read()     // Catch:{ all -> 0x0021 }
            if (r14 < 0) goto L_0x02c5
            if (r14 != r13) goto L_0x02be
            int r14 = r10.read()     // Catch:{ all -> 0x0021 }
            r15 = 1056964608(0x3f000000, float:0.5)
            r16 = 1076006748(0x40228f5c, float:2.54)
            if (r12 == 0) goto L_0x00c6
            r9 = 224(0xe0, float:3.14E-43)
            if (r14 != r9) goto L_0x00c6
            int r9 = y2(r10)     // Catch:{ all -> 0x0021 }
            if (r9 >= r5) goto L_0x0065
            int r9 = r9 - r7
            com.itextpdf.text.Utilities.v(r10, r9)     // Catch:{ all -> 0x0021 }
            goto L_0x00b2
        L_0x0065:
            byte[] r12 = Y4     // Catch:{ all -> 0x0021 }
            int r12 = r12.length     // Catch:{ all -> 0x0021 }
            byte[] r14 = new byte[r12]     // Catch:{ all -> 0x0021 }
            int r0 = r10.read(r14)     // Catch:{ all -> 0x0021 }
            if (r0 != r12) goto L_0x00b6
            r0 = 0
        L_0x0071:
            if (r0 >= r12) goto L_0x0085
            byte r5 = r14[r0]     // Catch:{ all -> 0x0021 }
            byte[] r19 = Y4     // Catch:{ all -> 0x0021 }
            byte r2 = r19[r0]     // Catch:{ all -> 0x0021 }
            if (r5 == r2) goto L_0x0081
            int r9 = r9 - r7
            int r9 = r9 - r12
            com.itextpdf.text.Utilities.v(r10, r9)     // Catch:{ all -> 0x0021 }
            goto L_0x00b2
        L_0x0081:
            int r0 = r0 + r8
            r5 = 16
            goto L_0x0071
        L_0x0085:
            com.itextpdf.text.Utilities.v(r10, r7)     // Catch:{ all -> 0x0021 }
            int r0 = r10.read()     // Catch:{ all -> 0x0021 }
            int r2 = y2(r10)     // Catch:{ all -> 0x0021 }
            int r5 = y2(r10)     // Catch:{ all -> 0x0021 }
            if (r0 != r8) goto L_0x009b
            r1.b4 = r2     // Catch:{ all -> 0x0021 }
            r1.c4 = r5     // Catch:{ all -> 0x0021 }
            goto L_0x00ab
        L_0x009b:
            if (r0 != r7) goto L_0x00ab
            float r0 = (float) r2     // Catch:{ all -> 0x0021 }
            float r0 = r0 * r16
            float r0 = r0 + r15
            int r0 = (int) r0     // Catch:{ all -> 0x0021 }
            r1.b4 = r0     // Catch:{ all -> 0x0021 }
            float r0 = (float) r5     // Catch:{ all -> 0x0021 }
            float r0 = r0 * r16
            float r0 = r0 + r15
            int r0 = (int) r0     // Catch:{ all -> 0x0021 }
            r1.c4 = r0     // Catch:{ all -> 0x0021 }
        L_0x00ab:
            int r9 = r9 - r7
            int r9 = r9 - r12
            int r9 = r9 + -7
            com.itextpdf.text.Utilities.v(r10, r9)     // Catch:{ all -> 0x0021 }
        L_0x00b2:
            r5 = 16
            r12 = 0
            goto L_0x0043
        L_0x00b6:
            com.itextpdf.text.BadElementException r0 = new com.itextpdf.text.BadElementException     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "1.corrupted.jfif.marker"
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ all -> 0x0021 }
            r3[r6] = r11     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0021 }
            r0.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0021 }
            throw r0     // Catch:{ all -> 0x0021 }
        L_0x00c6:
            r0 = 238(0xee, float:3.34E-43)
            java.lang.String r2 = "ISO-8859-1"
            if (r14 != r0) goto L_0x00f6
            int r0 = y2(r10)     // Catch:{ all -> 0x0021 }
            int r0 = r0 - r7
            byte[] r5 = new byte[r0]     // Catch:{ all -> 0x0021 }
            r9 = 0
        L_0x00d4:
            if (r9 >= r0) goto L_0x00df
            int r14 = r10.read()     // Catch:{ all -> 0x0021 }
            byte r14 = (byte) r14     // Catch:{ all -> 0x0021 }
            r5[r9] = r14     // Catch:{ all -> 0x0021 }
            int r9 = r9 + r8
            goto L_0x00d4
        L_0x00df:
            if (r0 < r4) goto L_0x00f0
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0021 }
            r0.<init>(r5, r6, r3, r2)     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "Adobe"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x00f0
            r1.g4 = r8     // Catch:{ all -> 0x0021 }
        L_0x00f0:
            r3 = 16
        L_0x00f2:
            r20 = 13
            goto L_0x01fe
        L_0x00f6:
            r0 = 226(0xe2, float:3.17E-43)
            r5 = 14
            if (r14 != r0) goto L_0x013d
            int r0 = y2(r10)     // Catch:{ all -> 0x0021 }
            int r0 = r0 - r7
            byte[] r9 = new byte[r0]     // Catch:{ all -> 0x0021 }
            r14 = 0
        L_0x0104:
            if (r14 >= r0) goto L_0x010f
            int r15 = r10.read()     // Catch:{ all -> 0x0021 }
            byte r15 = (byte) r15     // Catch:{ all -> 0x0021 }
            r9[r14] = r15     // Catch:{ all -> 0x0021 }
            int r14 = r14 + r8
            goto L_0x0104
        L_0x010f:
            if (r0 < r5) goto L_0x00f0
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0021 }
            r5 = 11
            r0.<init>(r9, r6, r5, r2)     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "ICC_PROFILE"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x00f0
            byte r0 = r9[r4]     // Catch:{ all -> 0x0021 }
            r0 = r0 & r13
            r2 = 13
            byte r5 = r9[r2]     // Catch:{ all -> 0x0021 }
            r2 = r5 & 255(0xff, float:3.57E-43)
            if (r0 >= r8) goto L_0x012c
            r0 = 1
        L_0x012c:
            if (r2 >= r8) goto L_0x012f
            r2 = 1
        L_0x012f:
            byte[][] r5 = r1.M4     // Catch:{ all -> 0x0021 }
            if (r5 != 0) goto L_0x0137
            byte[][] r2 = new byte[r2][]     // Catch:{ all -> 0x0021 }
            r1.M4 = r2     // Catch:{ all -> 0x0021 }
        L_0x0137:
            byte[][] r2 = r1.M4     // Catch:{ all -> 0x0021 }
            int r0 = r0 - r8
            r2[r0] = r9     // Catch:{ all -> 0x0021 }
            goto L_0x00f0
        L_0x013d:
            r0 = 237(0xed, float:3.32E-43)
            if (r14 != r0) goto L_0x0204
            int r0 = y2(r10)     // Catch:{ all -> 0x0021 }
            int r0 = r0 - r7
            byte[] r2 = new byte[r0]     // Catch:{ all -> 0x0021 }
            r5 = 0
        L_0x0149:
            if (r5 >= r0) goto L_0x0154
            int r9 = r10.read()     // Catch:{ all -> 0x0021 }
            byte r9 = (byte) r9     // Catch:{ all -> 0x0021 }
            r2[r5] = r9     // Catch:{ all -> 0x0021 }
            int r5 = r5 + r8
            goto L_0x0149
        L_0x0154:
            r5 = 0
        L_0x0155:
            byte[] r9 = Z4     // Catch:{ all -> 0x0021 }
            int r9 = r9.length     // Catch:{ all -> 0x0021 }
            int r9 = r0 - r9
            if (r5 >= r9) goto L_0x0170
            r9 = 0
        L_0x015d:
            byte[] r14 = Z4     // Catch:{ all -> 0x0021 }
            int r6 = r14.length     // Catch:{ all -> 0x0021 }
            if (r9 >= r6) goto L_0x0170
            int r6 = r5 + r9
            byte r6 = r2[r6]     // Catch:{ all -> 0x0021 }
            byte r14 = r14[r9]     // Catch:{ all -> 0x0021 }
            if (r6 == r14) goto L_0x016d
            int r5 = r5 + r8
            r6 = 0
            goto L_0x0155
        L_0x016d:
            int r9 = r9 + r8
            r6 = 0
            goto L_0x015d
        L_0x0170:
            byte[] r6 = Z4     // Catch:{ all -> 0x0021 }
            int r9 = r6.length     // Catch:{ all -> 0x0021 }
            int r5 = r5 + r9
            int r6 = r6.length     // Catch:{ all -> 0x0021 }
            int r0 = r0 - r6
            if (r5 >= r0) goto L_0x00f0
            byte r0 = r2[r5]     // Catch:{ all -> 0x0021 }
            int r0 = r0 + r8
            byte r0 = (byte) r0     // Catch:{ all -> 0x0021 }
            int r6 = r0 % 2
            if (r6 != r8) goto L_0x0182
            int r0 = r0 + r8
            byte r0 = (byte) r0     // Catch:{ all -> 0x0021 }
        L_0x0182:
            int r5 = r5 + r0
            byte r0 = r2[r5]     // Catch:{ all -> 0x0021 }
            int r0 = r0 << 24
            int r6 = r5 + 1
            byte r6 = r2[r6]     // Catch:{ all -> 0x0021 }
            r9 = 16
            int r6 = r6 << r9
            int r0 = r0 + r6
            int r6 = r5 + 2
            byte r6 = r2[r6]     // Catch:{ all -> 0x0021 }
            r9 = 8
            int r6 = r6 << r9
            int r0 = r0 + r6
            int r6 = r5 + 3
            byte r6 = r2[r6]     // Catch:{ all -> 0x0021 }
            int r0 = r0 + r6
            r6 = 16
            if (r0 == r6) goto L_0x01a2
            goto L_0x00f0
        L_0x01a2:
            int r0 = r5 + 4
            byte r0 = r2[r0]     // Catch:{ all -> 0x0021 }
            r6 = 8
            int r0 = r0 << r6
            int r9 = r5 + 5
            byte r9 = r2[r9]     // Catch:{ all -> 0x0021 }
            r9 = r9 & r13
            int r0 = r0 + r9
            int r9 = r5 + 8
            byte r9 = r2[r9]     // Catch:{ all -> 0x0021 }
            int r9 = r9 << r6
            int r14 = r5 + 9
            byte r14 = r2[r14]     // Catch:{ all -> 0x0021 }
            r14 = r14 & r13
            int r9 = r9 + r14
            int r14 = r5 + 12
            byte r14 = r2[r14]     // Catch:{ all -> 0x0021 }
            int r14 = r14 << r6
            r20 = 13
            int r17 = r5 + 13
            byte r3 = r2[r17]     // Catch:{ all -> 0x0021 }
            r3 = r3 & r13
            int r14 = r14 + r3
            r3 = 16
            int r17 = r5 + 16
            byte r17 = r2[r17]     // Catch:{ all -> 0x0021 }
            int r18 = r17 << 8
            int r5 = r5 + 17
            byte r2 = r2[r5]     // Catch:{ all -> 0x0021 }
            r2 = r2 & r13
            int r2 = r18 + r2
            if (r9 == r8) goto L_0x01da
            if (r9 != r7) goto L_0x01ea
        L_0x01da:
            if (r9 != r7) goto L_0x01e1
            float r0 = (float) r0     // Catch:{ all -> 0x0021 }
            float r0 = r0 * r16
            float r0 = r0 + r15
            int r0 = (int) r0     // Catch:{ all -> 0x0021 }
        L_0x01e1:
            int r5 = r1.b4     // Catch:{ all -> 0x0021 }
            if (r5 == 0) goto L_0x01e8
            if (r5 == r0) goto L_0x01e8
            goto L_0x01ea
        L_0x01e8:
            r1.b4 = r0     // Catch:{ all -> 0x0021 }
        L_0x01ea:
            if (r2 == r8) goto L_0x01ee
            if (r2 != r7) goto L_0x01fe
        L_0x01ee:
            if (r2 != r7) goto L_0x01f5
            float r0 = (float) r14     // Catch:{ all -> 0x0021 }
            float r0 = r0 * r16
            float r0 = r0 + r15
            int r14 = (int) r0     // Catch:{ all -> 0x0021 }
        L_0x01f5:
            int r0 = r1.c4     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x01fc
            if (r0 == r14) goto L_0x01fc
            goto L_0x01fe
        L_0x01fc:
            r1.c4 = r14     // Catch:{ all -> 0x0021 }
        L_0x01fe:
            r3 = 5
            r5 = 16
            r6 = 0
            goto L_0x0043
        L_0x0204:
            r3 = 16
            r20 = 13
            int r0 = z2(r14)     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x0295
            com.itextpdf.text.Utilities.v(r10, r7)     // Catch:{ all -> 0x0021 }
            int r0 = r10.read()     // Catch:{ all -> 0x0021 }
            r2 = 8
            if (r0 != r2) goto L_0x0284
            int r0 = y2(r10)     // Catch:{ all -> 0x0021 }
            float r0 = (float) r0     // Catch:{ all -> 0x0021 }
            r1.E3 = r0     // Catch:{ all -> 0x0021 }
            r1.z0(r0)     // Catch:{ all -> 0x0021 }
            int r0 = y2(r10)     // Catch:{ all -> 0x0021 }
            float r0 = (float) r0     // Catch:{ all -> 0x0021 }
            r1.D3 = r0     // Catch:{ all -> 0x0021 }
            r1.x0(r0)     // Catch:{ all -> 0x0021 }
            int r0 = r10.read()     // Catch:{ all -> 0x0021 }
            r1.e4 = r0     // Catch:{ all -> 0x0021 }
            r2 = 8
            r1.v3 = r2     // Catch:{ all -> 0x0021 }
            r10.close()
            float r0 = r21.a0()
            r1.B3 = r0
            float r0 = r21.N()
            r1.C3 = r0
            byte[][] r0 = r1.M4
            if (r0 == 0) goto L_0x0283
            r0 = 0
            r2 = 0
        L_0x024c:
            byte[][] r3 = r1.M4
            int r4 = r3.length
            if (r0 >= r4) goto L_0x025e
            r3 = r3[r0]
            if (r3 != 0) goto L_0x0259
            r4 = 0
            r1.M4 = r4
            return
        L_0x0259:
            int r3 = r3.length
            int r3 = r3 - r5
            int r2 = r2 + r3
            int r0 = r0 + r8
            goto L_0x024c
        L_0x025e:
            byte[] r0 = new byte[r2]
            r2 = 0
            r6 = 0
        L_0x0262:
            byte[][] r3 = r1.M4
            int r4 = r3.length
            if (r6 >= r4) goto L_0x0277
            r3 = r3[r6]
            int r4 = r3.length
            int r4 = r4 - r5
            java.lang.System.arraycopy(r3, r5, r0, r2, r4)
            byte[][] r3 = r1.M4
            r3 = r3[r6]
            int r3 = r3.length
            int r3 = r3 - r5
            int r2 = r2 + r3
            int r6 = r6 + r8
            goto L_0x0262
        L_0x0277:
            int r2 = r1.e4     // Catch:{ IllegalArgumentException -> 0x0280 }
            com.itextpdf.text.pdf.ICC_Profile r0 = com.itextpdf.text.pdf.ICC_Profile.e(r0, r2)     // Catch:{ IllegalArgumentException -> 0x0280 }
            r1.x2(r0)     // Catch:{ IllegalArgumentException -> 0x0280 }
        L_0x0280:
            r5 = 0
            r1.M4 = r5
        L_0x0283:
            return
        L_0x0284:
            com.itextpdf.text.BadElementException r0 = new com.itextpdf.text.BadElementException     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "1.must.have.8.bits.per.component"
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ all -> 0x0021 }
            r4 = 0
            r3[r4] = r11     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0021 }
            r0.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0021 }
            throw r0     // Catch:{ all -> 0x0021 }
        L_0x0295:
            r2 = 8
            r5 = 0
            if (r0 == r8) goto L_0x02a7
            if (r0 == r7) goto L_0x02a4
            int r0 = y2(r10)     // Catch:{ all -> 0x0021 }
            int r0 = r0 - r7
            com.itextpdf.text.Utilities.v(r10, r0)     // Catch:{ all -> 0x0021 }
        L_0x02a4:
            r12 = 0
            goto L_0x01fe
        L_0x02a7:
            com.itextpdf.text.BadElementException r0 = new com.itextpdf.text.BadElementException     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "1.unsupported.jpeg.marker.2"
            java.lang.String r3 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x0021 }
            java.lang.Object[] r4 = new java.lang.Object[r7]     // Catch:{ all -> 0x0021 }
            r5 = 0
            r4[r5] = r11     // Catch:{ all -> 0x0021 }
            r4[r8] = r3     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r4)     // Catch:{ all -> 0x0021 }
            r0.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0021 }
            throw r0     // Catch:{ all -> 0x0021 }
        L_0x02be:
            r2 = 8
            r3 = 16
            r5 = 0
            goto L_0x00f2
        L_0x02c5:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "premature.eof.while.reading.jpg"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0021 }
            r0.<init>(r2)     // Catch:{ all -> 0x0021 }
            throw r0     // Catch:{ all -> 0x0021 }
        L_0x02d4:
            com.itextpdf.text.BadElementException r0 = new com.itextpdf.text.BadElementException     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "1.is.not.a.valid.jpeg.file"
            java.lang.Object[] r3 = new java.lang.Object[r8]     // Catch:{ all -> 0x0021 }
            r4 = 0
            r3[r4] = r11     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0021 }
            r0.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0021 }
            throw r0     // Catch:{ all -> 0x0021 }
        L_0x02e5:
            r0 = move-exception
            r5 = 0
            r9 = r5
        L_0x02e8:
            if (r9 == 0) goto L_0x02ed
            r9.close()
        L_0x02ed:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Jpeg.A2():void");
    }

    private static final int y2(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    private static final int z2(int i2) {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = P4;
            if (i4 >= iArr.length) {
                int i5 = 0;
                while (true) {
                    int[] iArr2 = T4;
                    if (i5 >= iArr2.length) {
                        while (true) {
                            int[] iArr3 = R4;
                            if (i3 >= iArr3.length) {
                                return -1;
                            }
                            if (i2 == iArr3[i3]) {
                                return 1;
                            }
                            i3++;
                        }
                    } else if (i2 == iArr2[i5]) {
                        return 2;
                    } else {
                        i5++;
                    }
                }
            } else if (i2 == iArr[i4]) {
                return 0;
            } else {
                i4++;
            }
        }
    }

    public Jpeg(URL url) throws BadElementException, IOException {
        super(url);
        A2();
    }

    public Jpeg(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.u3 = bArr;
        this.Z3 = bArr;
        A2();
    }

    public Jpeg(byte[] bArr, float f2, float f3) throws BadElementException, IOException {
        this(bArr);
        this.D3 = f2;
        this.E3 = f3;
    }
}

package com.itextpdf.xmp.impl;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

public class FixASCIIControlsReader extends PushbackReader {
    private static final int X2 = 1;
    private static final int Y2 = 2;
    private static final int Z = 0;
    private static final int Z2 = 3;
    private static final int a3 = 4;
    private static final int b3 = 5;
    private static final int c3 = 8;
    private int X = 0;
    private int Y = 0;
    private int s = 0;

    public FixASCIIControlsReader(Reader reader) {
        super(reader, 8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (com.itextpdf.xmp.impl.Utils.d((char) r10.X) != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0084, code lost:
        if (com.itextpdf.xmp.impl.Utils.d((char) r10.X) != false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private char b(char r11) {
        /*
            r10 = this;
            int r0 = r10.s
            r1 = 1
            if (r0 == 0) goto L_0x00af
            r2 = 2
            r3 = 5
            if (r0 == r1) goto L_0x00a5
            r4 = 10
            r5 = 57
            r6 = 48
            r7 = 3
            r8 = 4
            r9 = 0
            if (r0 == r2) goto L_0x0088
            r2 = 59
            if (r0 == r7) goto L_0x004d
            if (r0 == r8) goto L_0x0020
            if (r0 == r3) goto L_0x001d
            return r11
        L_0x001d:
            r10.s = r9
            return r11
        L_0x0020:
            if (r6 > r11) goto L_0x003c
            if (r11 > r5) goto L_0x003c
            int r0 = r10.X
            int r0 = r0 * 10
            int r2 = java.lang.Character.digit(r11, r4)
            int r0 = r0 + r2
            r10.X = r0
            int r0 = r10.Y
            int r0 = r0 + r1
            r10.Y = r0
            if (r0 > r3) goto L_0x0039
            r10.s = r8
            goto L_0x004c
        L_0x0039:
            r10.s = r3
            goto L_0x004c
        L_0x003c:
            if (r11 != r2) goto L_0x0039
            int r0 = r10.X
            char r0 = (char) r0
            boolean r0 = com.itextpdf.xmp.impl.Utils.d(r0)
            if (r0 == 0) goto L_0x0039
        L_0x0047:
            r10.s = r9
            int r11 = r10.X
            char r11 = (char) r11
        L_0x004c:
            return r11
        L_0x004d:
            if (r6 > r11) goto L_0x0051
            if (r11 <= r5) goto L_0x0061
        L_0x0051:
            r0 = 97
            if (r0 > r11) goto L_0x0059
            r0 = 102(0x66, float:1.43E-43)
            if (r11 <= r0) goto L_0x0061
        L_0x0059:
            r0 = 65
            if (r0 > r11) goto L_0x007b
            r0 = 70
            if (r11 > r0) goto L_0x007b
        L_0x0061:
            int r0 = r10.X
            r2 = 16
            int r0 = r0 * 16
            int r2 = java.lang.Character.digit(r11, r2)
            int r0 = r0 + r2
            r10.X = r0
            int r0 = r10.Y
            int r0 = r0 + r1
            r10.Y = r0
            if (r0 > r8) goto L_0x0078
            r10.s = r7
            goto L_0x0087
        L_0x0078:
            r10.s = r3
            goto L_0x0087
        L_0x007b:
            if (r11 != r2) goto L_0x0078
            int r0 = r10.X
            char r0 = (char) r0
            boolean r0 = com.itextpdf.xmp.impl.Utils.d(r0)
            if (r0 == 0) goto L_0x0078
            goto L_0x0047
        L_0x0087:
            return r11
        L_0x0088:
            r0 = 120(0x78, float:1.68E-43)
            if (r11 != r0) goto L_0x0093
            r10.X = r9
            r10.Y = r9
            r10.s = r7
            goto L_0x00a4
        L_0x0093:
            if (r6 > r11) goto L_0x00a2
            if (r11 > r5) goto L_0x00a2
            int r0 = java.lang.Character.digit(r11, r4)
            r10.X = r0
            r10.Y = r1
            r10.s = r8
            goto L_0x00a4
        L_0x00a2:
            r10.s = r3
        L_0x00a4:
            return r11
        L_0x00a5:
            r0 = 35
            if (r11 != r0) goto L_0x00ac
            r10.s = r2
            goto L_0x00ae
        L_0x00ac:
            r10.s = r3
        L_0x00ae:
            return r11
        L_0x00af:
            r0 = 38
            if (r11 != r0) goto L_0x00b5
            r10.s = r1
        L_0x00b5:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.FixASCIIControlsReader.b(char):char");
    }

    public int read(char[] cArr, int i2, int i3) throws IOException {
        char[] cArr2 = new char[8];
        boolean z = true;
        int i4 = 0;
        loop0:
        while (true) {
            int i5 = 0;
            while (z && i4 < i3) {
                z = super.read(cArr2, i5, 1) == 1;
                if (z) {
                    char b2 = b(cArr2[i5]);
                    int i6 = this.s;
                    if (i6 == 0) {
                        if (Utils.d(b2)) {
                            b2 = ' ';
                        }
                        cArr[i2] = b2;
                        i4++;
                        i2++;
                    } else {
                        i5++;
                        if (i6 == 5) {
                            unread(cArr2, 0, i5);
                        }
                    }
                } else if (i5 > 0) {
                    unread(cArr2, 0, i5);
                    this.s = 5;
                    z = true;
                }
            }
        }
        if (i4 > 0 || z) {
            return i4;
        }
        return -1;
    }
}

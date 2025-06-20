package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class Jpeg2000 extends Image {
    public static final int T4 = 1783636000;
    public static final int U4 = 1768449138;
    public static final int V4 = 1785751920;
    public static final int W4 = 1718909296;
    public static final int X4 = 1785737832;
    public static final int Y4 = 1668246642;
    public static final int Z4 = 1785737827;
    public static final int a5 = 1970433056;
    public static final int b5 = 1685348972;
    public static final int c5 = 1651532643;
    public static final int d5 = 1785737760;
    InputStream M4;
    int N4;
    int O4;
    int P4;
    ArrayList<ColorSpecBox> Q4;
    boolean R4;
    byte[] S4;

    public static class ColorSpecBox extends ArrayList<Integer> {
        private byte[] s;

        public int b() {
            return ((Integer) get(2)).intValue();
        }

        public byte[] c() {
            return this.s;
        }

        public int d() {
            return ((Integer) get(3)).intValue();
        }

        public int g() {
            return ((Integer) get(0)).intValue();
        }

        public int h() {
            return ((Integer) get(1)).intValue();
        }

        /* access modifiers changed from: package-private */
        public void m(byte[] bArr) {
            this.s = bArr;
        }
    }

    private class ZeroBoxSizeException extends IOException {
        public ZeroBoxSizeException() {
        }

        public ZeroBoxSizeException(String str) {
            super(str);
        }
    }

    Jpeg2000(Image image) {
        super(image);
        this.Q4 = null;
        this.R4 = false;
        if (image instanceof Jpeg2000) {
            Jpeg2000 jpeg2000 = (Jpeg2000) image;
            this.P4 = jpeg2000.P4;
            this.R4 = jpeg2000.R4;
            if (this.S4 != null) {
                this.S4 = (byte[]) jpeg2000.S4.clone();
            }
        }
    }

    private ColorSpecBox E2() throws IOException {
        ColorSpecBox colorSpecBox = new ColorSpecBox();
        int i2 = 8;
        for (int i3 = 0; i3 < 3; i3++) {
            colorSpecBox.add(Integer.valueOf(y2(1)));
            i2++;
        }
        if (colorSpecBox.g() == 1) {
            colorSpecBox.add(Integer.valueOf(y2(4)));
            i2 += 4;
        } else {
            colorSpecBox.add(0);
        }
        int i4 = this.N4;
        if (i4 - i2 > 0) {
            byte[] bArr = new byte[(i4 - i2)];
            this.M4.read(bArr, 0, i4 - i2);
            colorSpecBox.m(bArr);
        }
        return colorSpecBox;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:34|(1:36)|37|38|39|40|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00ef */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void F2() throws java.io.IOException {
        /*
            r9 = this;
            r0 = 33
            r9.s3 = r0
            r0 = 8
            r9.Y3 = r0
            r1 = 0
            r9.M4 = r1
            byte[] r2 = r9.u3     // Catch:{ all -> 0x0018 }
            if (r2 != 0) goto L_0x001b
            java.net.URL r2 = r9.t3     // Catch:{ all -> 0x0018 }
            java.io.InputStream r2 = r2.openStream()     // Catch:{ all -> 0x0018 }
        L_0x0015:
            r9.M4 = r2     // Catch:{ all -> 0x0018 }
            goto L_0x0023
        L_0x0018:
            r0 = move-exception
            goto L_0x0187
        L_0x001b:
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0018 }
            byte[] r3 = r9.u3     // Catch:{ all -> 0x0018 }
            r2.<init>(r3)     // Catch:{ all -> 0x0018 }
            goto L_0x0015
        L_0x0023:
            r2 = 4
            int r3 = r9.y2(r2)     // Catch:{ all -> 0x0018 }
            r9.N4 = r3     // Catch:{ all -> 0x0018 }
            r4 = 12
            r5 = 2
            r6 = 0
            if (r3 != r4) goto L_0x012c
            r3 = 1
            r9.R4 = r3     // Catch:{ all -> 0x0018 }
            int r4 = r9.y2(r2)     // Catch:{ all -> 0x0018 }
            r9.O4 = r4     // Catch:{ all -> 0x0018 }
            r7 = 1783636000(0x6a502020, float:6.290207E25)
            if (r7 != r4) goto L_0x011e
            int r4 = r9.y2(r2)     // Catch:{ all -> 0x0018 }
            r7 = 218793738(0xd0a870a, float:4.268708E-31)
            if (r7 != r4) goto L_0x0110
            r9.D2()     // Catch:{ all -> 0x0018 }
            int r4 = r9.O4     // Catch:{ all -> 0x0018 }
            r7 = 1718909296(0x66747970, float:2.8862439E23)
            if (r7 != r4) goto L_0x0102
            java.io.InputStream r4 = r9.M4     // Catch:{ all -> 0x0018 }
            int r7 = r9.N4     // Catch:{ all -> 0x0018 }
            int r7 = r7 - r0
            com.itextpdf.text.Utilities.v(r4, r7)     // Catch:{ all -> 0x0018 }
            r9.D2()     // Catch:{ all -> 0x0018 }
        L_0x005c:
            int r4 = r9.O4     // Catch:{ all -> 0x0018 }
            r7 = 1785737832(0x6a703268, float:7.259506E25)
            if (r7 == r4) goto L_0x0082
            r8 = 1785737827(0x6a703263, float:7.2595035E25)
            if (r4 == r8) goto L_0x0074
            java.io.InputStream r4 = r9.M4     // Catch:{ all -> 0x0018 }
            int r8 = r9.N4     // Catch:{ all -> 0x0018 }
            int r8 = r8 - r0
            com.itextpdf.text.Utilities.v(r4, r8)     // Catch:{ all -> 0x0018 }
            r9.D2()     // Catch:{ all -> 0x0018 }
            goto L_0x0082
        L_0x0074:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "expected.jp2h.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.<init>(r2)     // Catch:{ all -> 0x0018 }
            throw r0     // Catch:{ all -> 0x0018 }
        L_0x0082:
            int r4 = r9.O4     // Catch:{ all -> 0x0018 }
            if (r7 != r4) goto L_0x005c
            r9.D2()     // Catch:{ all -> 0x0018 }
            int r4 = r9.O4     // Catch:{ all -> 0x0018 }
            r7 = 1768449138(0x69686472, float:1.7559071E25)
            if (r7 != r4) goto L_0x00f4
            int r4 = r9.y2(r2)     // Catch:{ all -> 0x0018 }
            float r4 = (float) r4     // Catch:{ all -> 0x0018 }
            r9.E3 = r4     // Catch:{ all -> 0x0018 }
            r9.z0(r4)     // Catch:{ all -> 0x0018 }
            int r2 = r9.y2(r2)     // Catch:{ all -> 0x0018 }
            float r2 = (float) r2     // Catch:{ all -> 0x0018 }
            r9.D3 = r2     // Catch:{ all -> 0x0018 }
            r9.x0(r2)     // Catch:{ all -> 0x0018 }
            int r2 = r9.y2(r5)     // Catch:{ all -> 0x0018 }
            r9.P4 = r2     // Catch:{ all -> 0x0018 }
            r2 = -1
            r9.v3 = r2     // Catch:{ all -> 0x0018 }
            int r2 = r9.y2(r3)     // Catch:{ all -> 0x0018 }
            r9.v3 = r2     // Catch:{ all -> 0x0018 }
            java.io.InputStream r2 = r9.M4     // Catch:{ all -> 0x0018 }
            r3 = 3
            com.itextpdf.text.Utilities.v(r2, r3)     // Catch:{ all -> 0x0018 }
            r9.D2()     // Catch:{ all -> 0x0018 }
            int r2 = r9.O4     // Catch:{ all -> 0x0018 }
            r3 = 1651532643(0x62706363, float:1.10859504E21)
            if (r2 != r3) goto L_0x00d3
            int r2 = r9.N4     // Catch:{ all -> 0x0018 }
            int r3 = r2 + -8
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0018 }
            r9.S4 = r3     // Catch:{ all -> 0x0018 }
            java.io.InputStream r4 = r9.M4     // Catch:{ all -> 0x0018 }
            int r2 = r2 - r0
            r4.read(r3, r6, r2)     // Catch:{ all -> 0x0018 }
            goto L_0x0163
        L_0x00d3:
            r0 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r2 != r0) goto L_0x0163
        L_0x00d8:
            java.util.ArrayList<com.itextpdf.text.Jpeg2000$ColorSpecBox> r2 = r9.Q4     // Catch:{ all -> 0x0018 }
            if (r2 != 0) goto L_0x00e3
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0018 }
            r2.<init>()     // Catch:{ all -> 0x0018 }
            r9.Q4 = r2     // Catch:{ all -> 0x0018 }
        L_0x00e3:
            java.util.ArrayList<com.itextpdf.text.Jpeg2000$ColorSpecBox> r2 = r9.Q4     // Catch:{ all -> 0x0018 }
            com.itextpdf.text.Jpeg2000$ColorSpecBox r3 = r9.E2()     // Catch:{ all -> 0x0018 }
            r2.add(r3)     // Catch:{ all -> 0x0018 }
            r9.D2()     // Catch:{ ZeroBoxSizeException -> 0x00ef }
        L_0x00ef:
            int r2 = r9.O4     // Catch:{ all -> 0x0018 }
            if (r0 == r2) goto L_0x00d8
            goto L_0x0163
        L_0x00f4:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "expected.ihdr.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.<init>(r2)     // Catch:{ all -> 0x0018 }
            throw r0     // Catch:{ all -> 0x0018 }
        L_0x0102:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "expected.ftyp.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.<init>(r2)     // Catch:{ all -> 0x0018 }
            throw r0     // Catch:{ all -> 0x0018 }
        L_0x0110:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "error.with.jp.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.<init>(r2)     // Catch:{ all -> 0x0018 }
            throw r0     // Catch:{ all -> 0x0018 }
        L_0x011e:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "expected.jp.marker"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.<init>(r2)     // Catch:{ all -> 0x0018 }
            throw r0     // Catch:{ all -> 0x0018 }
        L_0x012c:
            r4 = -11534511(0xffffffffff4fff51, float:-2.7647587E38)
            if (r3 != r4) goto L_0x0179
            java.io.InputStream r3 = r9.M4     // Catch:{ all -> 0x0018 }
            com.itextpdf.text.Utilities.v(r3, r2)     // Catch:{ all -> 0x0018 }
            int r3 = r9.y2(r2)     // Catch:{ all -> 0x0018 }
            int r4 = r9.y2(r2)     // Catch:{ all -> 0x0018 }
            int r6 = r9.y2(r2)     // Catch:{ all -> 0x0018 }
            int r2 = r9.y2(r2)     // Catch:{ all -> 0x0018 }
            java.io.InputStream r7 = r9.M4     // Catch:{ all -> 0x0018 }
            r8 = 16
            com.itextpdf.text.Utilities.v(r7, r8)     // Catch:{ all -> 0x0018 }
            int r5 = r9.y2(r5)     // Catch:{ all -> 0x0018 }
            r9.e4 = r5     // Catch:{ all -> 0x0018 }
            r9.v3 = r0     // Catch:{ all -> 0x0018 }
            int r4 = r4 - r2
            float r0 = (float) r4     // Catch:{ all -> 0x0018 }
            r9.E3 = r0     // Catch:{ all -> 0x0018 }
            r9.z0(r0)     // Catch:{ all -> 0x0018 }
            int r3 = r3 - r6
            float r0 = (float) r3     // Catch:{ all -> 0x0018 }
            r9.D3 = r0     // Catch:{ all -> 0x0018 }
            r9.x0(r0)     // Catch:{ all -> 0x0018 }
        L_0x0163:
            java.io.InputStream r0 = r9.M4
            if (r0 == 0) goto L_0x016c
            r0.close()     // Catch:{ Exception -> 0x016a }
        L_0x016a:
            r9.M4 = r1
        L_0x016c:
            float r0 = r9.a0()
            r9.B3 = r0
            float r0 = r9.N()
            r9.C3 = r0
            return
        L_0x0179:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "not.a.valid.jpeg2000.file"
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.<init>(r2)     // Catch:{ all -> 0x0018 }
            throw r0     // Catch:{ all -> 0x0018 }
        L_0x0187:
            java.io.InputStream r2 = r9.M4
            if (r2 == 0) goto L_0x0190
            r2.close()     // Catch:{ Exception -> 0x018e }
        L_0x018e:
            r9.M4 = r1
        L_0x0190:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Jpeg2000.F2():void");
    }

    private int y2(int i2) throws IOException {
        int i3 = 0;
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            i3 += this.M4.read() << (i4 << 3);
        }
        return i3;
    }

    public ArrayList<ColorSpecBox> A2() {
        return this.Q4;
    }

    public int B2() {
        return this.P4;
    }

    public boolean C2() {
        return this.R4;
    }

    public void D2() throws IOException {
        this.N4 = y2(4);
        this.O4 = y2(4);
        int i2 = this.N4;
        if (i2 == 1) {
            if (y2(4) == 0) {
                int y2 = y2(4);
                this.N4 = y2;
                if (y2 == 0) {
                    throw new IOException(MessageLocalization.b("unsupported.box.size.eq.eq.0", new Object[0]));
                }
                return;
            }
            throw new IOException(MessageLocalization.b("cannot.handle.box.sizes.higher.than.2.32", new Object[0]));
        } else if (i2 == 0) {
            throw new ZeroBoxSizeException(MessageLocalization.b("unsupported.box.size.eq.eq.0", new Object[0]));
        }
    }

    public byte[] z2() {
        return this.S4;
    }

    public Jpeg2000(URL url) throws BadElementException, IOException {
        super(url);
        this.Q4 = null;
        this.R4 = false;
        F2();
    }

    public Jpeg2000(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.Q4 = null;
        this.R4 = false;
        this.u3 = bArr;
        this.Z3 = bArr;
        F2();
    }

    public Jpeg2000(byte[] bArr, float f2, float f3) throws BadElementException, IOException {
        this(bArr);
        this.D3 = f2;
        this.E3 = f3;
    }
}

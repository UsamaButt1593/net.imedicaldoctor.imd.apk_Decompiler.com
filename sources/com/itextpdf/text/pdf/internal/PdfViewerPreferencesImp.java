package com.itextpdf.text.pdf.internal;

import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;

public class PdfViewerPreferencesImp implements PdfViewerPreferences {
    public static final PdfName[] X2 = {PdfName.ka, PdfName.Ed};
    public static final PdfName[] Y = {PdfName.r9, PdfName.q9, PdfName.s9, PdfName.e8, PdfName.Z4, PdfName.I6, PdfName.Eb, PdfName.H6, PdfName.uh, PdfName.vh, PdfName.jd, PdfName.kd, PdfName.od, PdfName.X6, PdfName.Tc, PdfName.nd, PdfName.Jb};
    public static final PdfName[] Y2 = {PdfName.Za, PdfName.Z5, PdfName.A4, PdfName.zg, PdfName.W3};
    public static final PdfName[] Z = {PdfName.ch, PdfName.eh, PdfName.ih, PdfName.dh};
    public static final PdfName[] Z2 = {PdfName.U3, PdfName.Db};
    public static final PdfName[] a3 = {PdfName.Te, PdfName.Y6, PdfName.Z6};
    private static final int b3 = 16773120;
    private PdfDictionary X = new PdfDictionary();
    private int s = 0;

    private int c(PdfName pdfName) {
        int i2 = 0;
        while (true) {
            PdfName[] pdfNameArr = Y;
            if (i2 >= pdfNameArr.length) {
                return -1;
            }
            if (pdfNameArr[i2].equals(pdfName)) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cb A[LOOP:0: B:50:0x00c6->B:52:0x00cb, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00dd A[EDGE_INSN: B:54:0x00dd->B:53:0x00dd ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp f(com.itextpdf.text.pdf.PdfDictionary r5) {
        /*
            com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp r0 = new com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp
            r0.<init>()
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.xc
            com.itextpdf.text.pdf.PdfObject r1 = r5.d0(r1)
            com.itextpdf.text.pdf.PdfObject r1 = com.itextpdf.text.pdf.PdfReader.w0(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0059
            boolean r3 = r1.E()
            if (r3 == 0) goto L_0x0059
            com.itextpdf.text.pdf.PdfName r1 = (com.itextpdf.text.pdf.PdfName) r1
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Ue
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0024
            r1 = 1
            goto L_0x005a
        L_0x0024:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.ac
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x002e
            r1 = 2
            goto L_0x005a
        L_0x002e:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Fg
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0038
            r1 = 4
            goto L_0x005a
        L_0x0038:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Gg
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x0043
            r1 = 8
            goto L_0x005a
        L_0x0043:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Hg
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto L_0x004e
            r1 = 16
            goto L_0x005a
        L_0x004e:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Ig
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0059
            r1 = 32
            goto L_0x005a
        L_0x0059:
            r1 = 0
        L_0x005a:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.yc
            com.itextpdf.text.pdf.PdfObject r3 = r5.d0(r3)
            com.itextpdf.text.pdf.PdfObject r3 = com.itextpdf.text.pdf.PdfReader.w0(r3)
            if (r3 == 0) goto L_0x00af
            boolean r4 = r3.E()
            if (r4 == 0) goto L_0x00af
            com.itextpdf.text.pdf.PdfName r3 = (com.itextpdf.text.pdf.PdfName) r3
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.ch
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0079
            r1 = r1 | 64
            goto L_0x00af
        L_0x0079:
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.eh
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x0084
            r1 = r1 | 128(0x80, float:1.794E-43)
            goto L_0x00af
        L_0x0084:
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.ih
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x008f
            r1 = r1 | 256(0x100, float:3.59E-43)
            goto L_0x00af
        L_0x008f:
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.D8
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x009a
            r1 = r1 | 512(0x200, float:7.175E-43)
            goto L_0x00af
        L_0x009a:
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.dh
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x00a5
            r1 = r1 | 1024(0x400, float:1.435E-42)
            goto L_0x00af
        L_0x00a5:
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.bh
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00af
            r1 = r1 | 2048(0x800, float:2.87E-42)
        L_0x00af:
            r0.a(r1)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.wh
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r1)
            com.itextpdf.text.pdf.PdfObject r5 = com.itextpdf.text.pdf.PdfReader.w0(r5)
            if (r5 == 0) goto L_0x00dd
            boolean r1 = r5.z()
            if (r1 == 0) goto L_0x00dd
            com.itextpdf.text.pdf.PdfDictionary r5 = (com.itextpdf.text.pdf.PdfDictionary) r5
        L_0x00c6:
            com.itextpdf.text.pdf.PdfName[] r1 = Y
            int r3 = r1.length
            if (r2 >= r3) goto L_0x00dd
            r3 = r1[r2]
            com.itextpdf.text.pdf.PdfObject r3 = r5.d0(r3)
            com.itextpdf.text.pdf.PdfObject r3 = com.itextpdf.text.pdf.PdfReader.w0(r3)
            r1 = r1[r2]
            r0.v(r1, r3)
            int r2 = r2 + 1
            goto L_0x00c6
        L_0x00dd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp.f(com.itextpdf.text.pdf.PdfDictionary):com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp");
    }

    private boolean g(PdfName pdfName, PdfName[] pdfNameArr) {
        for (PdfName equals : pdfNameArr) {
            if (equals.equals(pdfName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r4) {
        /*
            r3 = this;
            int r0 = r3.s
            r0 = r0 | r4
            r3.s = r0
            r1 = 16773120(0xfff000, float:2.3504147E-38)
            r1 = r1 & r4
            if (r1 == 0) goto L_0x00bf
            r1 = -16773121(0xffffffffff000fff, float:-1.7022424E38)
            r0 = r0 & r1
            r3.s = r0
            r0 = r4 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x001e
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.r9
            com.itextpdf.text.pdf.PdfBoolean r2 = com.itextpdf.text.pdf.PdfBoolean.j3
            r0.V0(r1, r2)
        L_0x001e:
            r0 = r4 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x002b
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.q9
            com.itextpdf.text.pdf.PdfBoolean r2 = com.itextpdf.text.pdf.PdfBoolean.j3
            r0.V0(r1, r2)
        L_0x002b:
            r0 = r4 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0038
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.s9
            com.itextpdf.text.pdf.PdfBoolean r2 = com.itextpdf.text.pdf.PdfBoolean.j3
            r0.V0(r1, r2)
        L_0x0038:
            r0 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x0047
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.e8
            com.itextpdf.text.pdf.PdfBoolean r2 = com.itextpdf.text.pdf.PdfBoolean.j3
            r0.V0(r1, r2)
        L_0x0047:
            r0 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x0055
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Z4
            com.itextpdf.text.pdf.PdfBoolean r2 = com.itextpdf.text.pdf.PdfBoolean.j3
            r0.V0(r1, r2)
        L_0x0055:
            r0 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x0063
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.I6
            com.itextpdf.text.pdf.PdfBoolean r2 = com.itextpdf.text.pdf.PdfBoolean.j3
            r0.V0(r1, r2)
        L_0x0063:
            r0 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x0072
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Eb
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.ch
        L_0x006e:
            r0.V0(r1, r2)
            goto L_0x0096
        L_0x0072:
            r0 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x007e
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Eb
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.eh
            goto L_0x006e
        L_0x007e:
            r0 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x008a
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Eb
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.ih
            goto L_0x006e
        L_0x008a:
            r0 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x0096
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Eb
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.dh
            goto L_0x006e
        L_0x0096:
            r0 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x00a5
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.H6
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.ka
        L_0x00a1:
            r0.V0(r1, r2)
            goto L_0x00b1
        L_0x00a5:
            r0 = 8388608(0x800000, float:1.17549435E-38)
            r0 = r0 & r4
            if (r0 == 0) goto L_0x00b1
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.X
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.H6
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Ed
            goto L_0x00a1
        L_0x00b1:
            r0 = 16777216(0x1000000, float:2.3509887E-38)
            r4 = r4 & r0
            if (r4 == 0) goto L_0x00bf
            com.itextpdf.text.pdf.PdfDictionary r4 = r3.X
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.od
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Db
            r4.V0(r0, r1)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp.a(int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.itextpdf.text.pdf.PdfDictionary r4) {
        /*
            r3 = this;
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.xc
            r4.a1(r0)
            int r1 = r3.s
            r2 = r1 & 1
            if (r2 == 0) goto L_0x0011
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Ue
        L_0x000d:
            r4.V0(r0, r1)
            goto L_0x0034
        L_0x0011:
            r2 = r1 & 2
            if (r2 == 0) goto L_0x0018
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.ac
            goto L_0x000d
        L_0x0018:
            r2 = r1 & 4
            if (r2 == 0) goto L_0x001f
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Fg
            goto L_0x000d
        L_0x001f:
            r2 = r1 & 8
            if (r2 == 0) goto L_0x0026
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Gg
            goto L_0x000d
        L_0x0026:
            r2 = r1 & 16
            if (r2 == 0) goto L_0x002d
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Hg
            goto L_0x000d
        L_0x002d:
            r1 = r1 & 32
            if (r1 == 0) goto L_0x0034
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Ig
            goto L_0x000d
        L_0x0034:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.yc
            r4.a1(r0)
            int r1 = r3.s
            r2 = r1 & 64
            if (r2 == 0) goto L_0x0045
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.ch
        L_0x0041:
            r4.V0(r0, r1)
            goto L_0x0068
        L_0x0045:
            r2 = r1 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x004c
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.eh
            goto L_0x0041
        L_0x004c:
            r2 = r1 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0053
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.ih
            goto L_0x0041
        L_0x0053:
            r2 = r1 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x005a
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.D8
            goto L_0x0041
        L_0x005a:
            r2 = r1 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0061
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.dh
            goto L_0x0041
        L_0x0061:
            r1 = r1 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0068
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.bh
            goto L_0x0041
        L_0x0068:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.wh
            r4.a1(r0)
            com.itextpdf.text.pdf.PdfDictionary r1 = r3.X
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x007a
            com.itextpdf.text.pdf.PdfDictionary r1 = r3.X
            r4.V0(r0, r1)
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp.b(com.itextpdf.text.pdf.PdfDictionary):void");
    }

    public int d() {
        return this.s;
    }

    public PdfDictionary e() {
        return this.X;
    }

    public void v(PdfName pdfName, PdfObject pdfObject) {
        switch (c(pdfName)) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 14:
                if (!(pdfObject instanceof PdfBoolean)) {
                    return;
                }
                break;
            case 6:
                if (!(pdfObject instanceof PdfName) || !g((PdfName) pdfObject, Z)) {
                    return;
                }
            case 7:
                if (!(pdfObject instanceof PdfName) || !g((PdfName) pdfObject, X2)) {
                    return;
                }
            case 8:
            case 9:
            case 10:
            case 11:
                if (!(pdfObject instanceof PdfName) || !g((PdfName) pdfObject, Y2)) {
                    return;
                }
            case 12:
                if (!(pdfObject instanceof PdfName) || !g((PdfName) pdfObject, Z2)) {
                    return;
                }
            case 13:
                if (!(pdfObject instanceof PdfName) || !g((PdfName) pdfObject, a3)) {
                    return;
                }
            case 15:
                if (!(pdfObject instanceof PdfArray)) {
                    return;
                }
                break;
            case 16:
                if (!(pdfObject instanceof PdfNumber)) {
                    return;
                }
                break;
            default:
                return;
        }
        this.X.V0(pdfName, pdfObject);
    }
}
